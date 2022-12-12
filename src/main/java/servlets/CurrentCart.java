/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.CartDaoImpl;
import dao.UserDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Cart;
import modele.User;

/**
 *
 * @author Samuel
 */
public class CurrentCart extends HttpServlet {

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
        CartDaoImpl cartDaoImpl = new CartDaoImpl();

        HttpSession session = request.getSession();
        Integer uID = (Integer) session.getAttribute("uid");
        boolean cartActive = cartDaoImpl.hasActiveCartForUserId(uID);
        boolean cartCreationSucces = false;

        if (cartActive) {
            System.out.println("CartActive");
        } else {
            Cart cart = new Cart(userDaoImpl.getUserById(uID), true);
            cartCreationSucces = cartDaoImpl.saveCart(cart);
        }
        String url;
        if (cartActive || (cartCreationSucces != true)) {
            url = "Acceuil";
        } else {
            url = "AddToCart";
        }
        request.getRequestDispatcher(url).include(request, response);
        Integer id = cartDaoImpl.getCurrentCartIdByUserId(uID);
        session.setAttribute("cid", id);
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
