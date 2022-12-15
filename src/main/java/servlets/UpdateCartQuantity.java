/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.CartProductDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.CartProduct;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Samuel
 */
public class UpdateCartQuantity extends HttpServlet {

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
        
        CartProductDaoImpl cartProductDaoImpl = new CartProductDaoImpl();
        
        String cpid = request.getParameter("cpid");
        String cpqty = request.getParameter("cpqty");
        boolean updateSucess = cartProductDaoImpl.updateCartProductQuantityById(Integer.parseInt(cpid), Integer.parseInt(cpqty));
        System.out.println("---------------------");
        System.out.println(cpid+"  -  "+cpqty);
        System.out.println("---------------------");
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("qty", Integer.parseInt(cpqty));
        
        sampleObject.put("updateSucess", updateSucess);
        PrintWriter out = response.getWriter();
        try {
            out.print(sampleObject.toString());
        } finally {
            out.close();
        }
        //request.getRequestDispatcher("Checkout").forward(request, response);
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
