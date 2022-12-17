/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.CartDaoImpl;
import dao.CartProductDaoImpl;
import dao.UserDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import modele.CartProduct;
import modele.Utilitaire;
import org.json.simple.JSONObject;

/**
 *
 * @author Jon
 */
public class LoginValidation extends HttpServlet {

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
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        CartDaoImpl cartDaoImpl= new CartDaoImpl();
        CartProductDaoImpl cartProductDaoImpl = new CartProductDaoImpl();
        

        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean emailExists = userDaoImpl.userEmailExists(email);
        Integer id = null;
        boolean loginSuccess = false;
        if (emailExists) {
            id = userDaoImpl.getUserIdFromEmail(email);
            if (id != null) {
                loginSuccess = Utilitaire.validateUserPassword(id, password);
                request.setAttribute("authenticating", false);
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("uid", id);
        session.setMaxInactiveInterval(30 * 60);
        
        Integer cID = cartDaoImpl.getCurrentCartIdByUserId(id);
        List<CartProduct> cartList = cartProductDaoImpl.getAllCartProductsWithCartId(cID);
        session.setAttribute("cartList", cartList.size());
       
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("emailExists", emailExists);
        sampleObject.put("loginSuccess", loginSuccess);

        PrintWriter out = response.getWriter();
        try {
            out.print(sampleObject.toString());
        } finally {
            out.close();
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
