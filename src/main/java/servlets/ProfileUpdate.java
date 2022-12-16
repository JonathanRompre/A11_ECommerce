/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.UserDaoImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.User;
import modele.Utilitaire;
import org.json.simple.JSONObject;

/**
 *
 * @author Jon
 */
public class ProfileUpdate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        UserDaoImpl userDaoImpl = new UserDaoImpl();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String currentPw = request.getParameter("currentPassword");
        String newPw = request.getParameter("newPassword");

        User user = userDaoImpl.getUserById((Integer) request.getSession().getAttribute("uid"));

        boolean authValid = false;
        boolean pwChange = false;
        boolean updateSuccess = false;

        if (currentPw != null && newPw != null && Utilitaire.validateUserPassword((Integer) request.getSession().getAttribute("uid"), currentPw)) {
            user.setPassword(newPw);
            if (firstName != null) {
                user.setFirstName(firstName);
            }
            if (lastName != null) {
                user.setLastName(lastName);
            }
            if (email != null) {
                user.setEmail(email);
            }
            pwChange = true;
            authValid = true;
        } else {
            // user trying to change pw but couldn't auth the given current pw
            // Don't update anything in that case.
            if (currentPw != null && newPw != null) {
                authValid = false;
                pwChange = true;
            } else {
                if (firstName != null) {
                    user.setFirstName(firstName);
                }
                if (lastName != null) {
                    user.setLastName(lastName);
                }
                if (email != null) {
                    user.setEmail(email);
                }
            }
        }
        
        if(!pwChange || authValid){
            updateSuccess = userDaoImpl.updateUser(user);
        }
        
        JSONObject jso = new JSONObject();
        jso.put("authValid",authValid);
        jso.put("pwChange",pwChange);
        jso.put("updateSuccess", updateSuccess);
        
        PrintWriter pw = response.getWriter();
        try{
            pw.print(jso.toString());
        }finally{
            pw.close();
        }

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

}
