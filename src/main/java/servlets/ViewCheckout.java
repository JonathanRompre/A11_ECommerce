/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.CartDaoImpl;
import dao.CartProductDaoImpl;
import dao.ProductDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.CartProduct;
import modele.Product;
import modele.CheckoutItem;

/**
 *
 * @author Samuel
 */
public class ViewCheckout extends HttpServlet {

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
        CartDaoImpl cartDaoImpl = new CartDaoImpl();
        CartProductDaoImpl cartProductDaoImpl = new CartProductDaoImpl();
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
        
        
        HttpSession session = request.getSession();
        Integer uID = (Integer) session.getAttribute("uid");
        Integer cID = cartDaoImpl.getCurrentCartIdByUserId(uID);
                
        List<CartProduct> cartProductsList = cartProductDaoImpl.getAllCartProductsWithCartId(cID);
        List<CheckoutItem> listCheckoutItems = new ArrayList<>();
        
        for (CartProduct cartProduct : cartProductsList) {
            Product product  = cartProduct.getProduct();
            CheckoutItem checkoutItem = new CheckoutItem(cartProduct, product);
            listCheckoutItems.add(checkoutItem);
        }
        
        session.setAttribute("checkoutList", listCheckoutItems);
                    
        
        request.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(request, response);
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
