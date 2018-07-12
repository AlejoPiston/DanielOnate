/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Paciente;
import servicios.PacienteFacadeLocal;

/**
 *
 * @author JAEL ARMAS
 */
@WebServlet(name = "PacienteController", urlPatterns = {"/paciente"})
public class PacienteController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     @EJB
     private PacienteFacadeLocal service;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        
        response.setContentType("text/html;charset=UTF-8");
       
        try{
            String command= request.getParameter("command");
            switch(command){
                case "create":
                    create (request,response);
                    break;
                case "edit":
                    edit(request, response);
                    break;
                case "find":
                    find(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "list":
                    list(request, response);
                    break;
                case "save":
                    save(request, response);
                    break;
            }       
        }catch( Exception e){
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            request.setAttribute("descriptionError", e.getMessage());
            rd.forward(request,response);  
        }
    }
 
    private Paciente findPaciente(String pk){
        int id= Integer.valueOf(pk);
        return service.find(id);      
    }
    
    private void send(HttpServletRequest request, HttpServletResponse response, Paciente paciente, String view)throws  ServletException,IOException{
        request.setAttribute("paciente", paciente);
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request,response);
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (ParseException ex) {
             Logger.getLogger(PacienteController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (ParseException ex) {
             Logger.getLogger(PacienteController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void create(HttpServletRequest request, HttpServletResponse response)  throws  ServletException,IOException {
        RequestDispatcher rd = request.getRequestDispatcher("paciente/create.jsp");
        rd.forward(request,response);
    }
    
    private void edit(HttpServletRequest request, HttpServletResponse response)  throws  ServletException,IOException{
        Paciente paciente =findPaciente(request.getParameter("id"));
        send(request, response, paciente, "paciente/edit.jsp"); //vista en la cual va a mostrar
        
    }
    
    private void find(HttpServletRequest request, HttpServletResponse response)  throws  ServletException,IOException{
        Paciente paciente =findPaciente(request.getParameter("id"));
        send(request, response, paciente, "paciente/find.jsp");
        
        
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response)  throws  ServletException,IOException{
        Paciente paciente =findPaciente(request.getParameter("id"));
        send(request, response, paciente, "paciente/delete.jsp"); //vista en la cual va a mostrar
        
        
    }
    
    private void list(HttpServletRequest request, HttpServletResponse response)  throws  ServletException,IOException{
        List<Paciente> listPaciente;
        listPaciente = service.findAll();
        request.setAttribute("pacientes",listPaciente);
        RequestDispatcher rd = request.getRequestDispatcher("paciente/list.jsp");
        rd.forward(request,response);
        
    }
    
    private void save(HttpServletRequest request, HttpServletResponse response)  throws  ServletException,IOException, ParseException{
       
        String pk = request.getParameter("id");
        String cedula = request.getParameter("cedula");
        String nombre = request.getParameter("nombre");
        String fechanacimiento = request.getParameter("fechanacimiento");
        String estatura = request.getParameter("estatura");
        String peso = request.getParameter("peso");
        
        Date fecNac = new Date();
        if (fechanacimiento != null ){
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            fecNac = format.parse(fechanacimiento);
        }
        
        if (pk != null){
           Paciente paciente =  findPaciente(pk);
           String action = request.getParameter("action");
           if(action.equals("update")){
               paciente.setCedula(cedula);
               paciente.setNombre(nombre);
               paciente.setFechanacimiento(fecNac);
               paciente.setEstatura(Integer.parseInt(estatura));
               paciente.setPeso(Integer.parseInt(peso));
               service.edit(paciente);
           }
           else{ 
               service.remove(paciente);
           }
        }
        else{
            Paciente paciente = new Paciente();
            paciente.setCedula(cedula);
            paciente.setNombre(nombre);
            paciente.setFechanacimiento(fecNac);
            paciente.setEstatura(Integer.parseInt(estatura));
            paciente.setPeso(Integer.parseInt(peso));
            service.create(paciente);
        }
      this.list(request,response);
    }
    

}
