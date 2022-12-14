/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.CartDaoImpl;
import dao.CartProductDaoImpl;
import dao.ProductDaoImpl;
import dao.UserDaoImpl;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Cart;
import modele.CartProduct;
import modele.Product;

/**
 *
 * @author Samuel
 */
public class AddToCart extends HttpServlet {

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
        CartProductDaoImpl cartProductDaoImpl = new CartProductDaoImpl();
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();

        HttpSession session = request.getSession();
        Integer uID = (Integer) session.getAttribute("uid");
        String pID = (String) request.getParameter("pid");
        boolean cartActive = cartDaoImpl.hasActiveCartForUserId(uID);
        boolean cartCreationSucces = false;
        Date date = new Date();

        if (!cartActive) {
            Cart cart = new Cart(userDaoImpl.getUserById(uID), true);
            cartCreationSucces = cartDaoImpl.saveCart(cart);
        }

        if (cartActive || (cartCreationSucces == true)) {
            Integer cID = cartDaoImpl.getCurrentCartIdByUserId(uID);
            int aproduct = Integer.parseInt(pID);
            List<CartProduct> cartProductsList = cartProductDaoImpl.getAllCartProductsWithCartId(cID);
            CartProduct cartProduct = new CartProduct(cartDaoImpl.getCartById(cID), productDaoImpl.getProductById(Integer.parseInt(pID)), 1, date);

            if (cartProductsList == null) {
                cartProductDaoImpl.saveCartProduct(cartProduct);
            } else {
                boolean exist = false;
                for (CartProduct c : cartProductsList) {
                    if (c.getProduct().getId() == aproduct) {
                        exist = true;
                        cartProduct = c ;
                    }
                }
                if (!exist) {
                    cartProductDaoImpl.saveCartProduct(cartProduct);
                } else {
                    cartProductDaoImpl.updateCartProductQuantity(cartProduct, (cartProduct.getQuantity() + 1));
                }

            }
        }
        Integer cID = cartDaoImpl.getCurrentCartIdByUserId(uID);
        List<CartProduct> cartList = cartProductDaoImpl.getAllCartProductsWithCartId(cID);
        request.getSession().setAttribute("cartList", cartList);
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/Accueil");
        disp.forward(request, response);
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
