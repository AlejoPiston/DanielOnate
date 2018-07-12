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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Paciente;

import modelos.Terapia;
import servicios.PacienteFacadeLocal;
import servicios.TerapiaFacadeLocal;
import servicios.TerapiaJpaController;

/**
 *
 * @author Liz
 */
@WebServlet(name = "TerapiaController", urlPatterns = {"/terapia"})
public class TerapiaController extends HttpServlet {

    @PersistenceContext(unitName = "WebTerapiaPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

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
    private TerapiaFacadeLocal service;
    private PacienteFacadeLocal pacservice;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String command = request.getParameter("command");
            switch (command) {
                case "create":
                    create(request, response);
                    break;
                case "save":
                    save(request, response);
                    break;
            }
        } catch (ServletException  | IOException e) {
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                request.setAttribute("descriptionError", e.getMessage());
                rd.forward(request, response);
            }catch(Exception ex){
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            request.setAttribute("descriptionError", ex.getMessage());
            rd.forward(request, response);
        }
        }

    

    private Terapia findTerapia(String pk) {
        int id = Integer.valueOf(pk);
        return service.find(id);
    }

    private void send(HttpServletRequest request, HttpServletResponse response, Terapia terapia, String view) throws ServletException, IOException {
        request.setAttribute("terapia", terapia);
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("terapia/create.jsp");
//        List<Paciente> listPaciente;
//        listPaciente = pacservice.findAll();
//        request.setAttribute("paciente",listPaciente);
        rd.forward(request, response);
    }

    private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Terapia terapia = findTerapia(request.getParameter("id"));
        send(request, response, terapia, "terapia/find.jsp");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Terapia terapia = findTerapia(request.getParameter("id"));
        send(request, response, terapia, "terapia/edit.jsp");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Terapia terapia = findTerapia(request.getParameter("id"));
        send(request, response, terapia, "terapia/delete.jsp");
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Terapia> listTerapia;
        listTerapia = service.findAll();
        request.setAttribute("terapias", listTerapia);
        RequestDispatcher rd = request.getRequestDispatcher("terapia/list.jsp");
        rd.forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, Exception {

        try {
            TerapiaJpaController service = new TerapiaJpaController(utx, em);

            String action = request.getParameter("action");

            String fecha = request.getParameter("fecha");
            String observacion = request.getParameter("observacion");
            String responsable = request.getParameter("responsable");
            String pacienteid = request.getParameter("pacienteid");

            Date fechaTerapia = new Date();
            if (fecha != null) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                fechaTerapia = format.parse(fecha);
            }

            Terapia terapia = new Terapia();

            terapia.setFecha(fechaTerapia);
            terapia.setObservacion(observacion);
            terapia.setResponsable(responsable);
            terapia.setRealizada(Boolean.FALSE);

            Integer pacienteId = Integer.parseInt(pacienteid);
            Paciente paciente = pacservice.find(pacienteId);
            terapia.setPacienteid(paciente);

            service.create(terapia);

            paciente = pacservice.find(pacienteId);

            request.setAttribute("paciente", paciente);
            RequestDispatcher rd = request.getRequestDispatcher("paciente/find.jsp");
            rd.forward(request, response);
        } catch (ServletException | IOException | ParseException e) {
            throw e;
        }

//        
//        String pk = request.getParameter("id");
//        String fechaterapia = request.getParameter("fechaterapia");
//        String observacion = request.getParameter("observacion");
//        String responsable = request.getParameter("responsable");
//        String realizada = request.getParameter("realizada");
//        String pacienteid = request.getParameter("pacienteid");
//        
//        Paciente paciente = new Paciente();
//        paciente = pacservice.find(Integer.parseInt(pacienteid));
//        
//        Date fecha = new Date();
//        if (fechaterapia != null ){
//            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            fecha= format.parse(fechaterapia);
//        }
//        
//        if (pk != null){
//           Terapia terapia =  findTerapia(pk);
//           String action = request.getParameter("action");
//           if(action.equals("update")){
//               terapia.setFecha(fecha);
//               terapia.setObservacion(observacion);
//               terapia.setResponsable(responsable);
//               terapia.setRealizada(Boolean.parseBoolean(realizada));
//               service.edit(terapia);
//           }
//           else{ 
//               service.remove(terapia);
//           }
//        }
//        else{
//            Terapia terapia = new Terapia();
//            terapia.setPacienteid(paciente);
//            terapia.setFecha(fecha);
//            terapia.setObservacion(observacion);
//            terapia.setResponsable(responsable);
//            terapia.setRealizada(Boolean.parseBoolean(realizada));
//            service.create(terapia);
//        }
//      this.list(request,response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

}
