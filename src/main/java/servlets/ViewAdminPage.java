/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.AdministratorDaoImpl;
import dao.ProductDaoImpl;
import dao.UserDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Passwords;
import modele.Product;
import modele.User;

/**
 *
 * @author Jon
 */
public class ViewAdminPage extends HttpServlet {

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
        String action = request.getParameter("action");
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
        AdministratorDaoImpl adi = new AdministratorDaoImpl();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        if (action != null) {
            boolean isAdmin = false;
            if ((request.getSession().getAttribute("adminAuth") == null) || ((boolean) request.getSession().getAttribute("adminAuth") == false)) {
                request.getSession().setAttribute("adminAuth", false);
                if (action.equals("auth")) {
                    isAdmin = Passwords.isExpectedPassword(request.getParameter("adminPass").toCharArray(), adi.getAdminSalt(), adi.getAdminPassword());
                    request.getSession().setAttribute("adminAuth", isAdmin);
                }
            } else {
                int id = 0;
                if (request.getParameter("id") != null) {
                    id = Integer.parseInt(request.getParameter("id"));
                }
                switch(action){
                    
                    case "activateProduct":
                    case "deactivateProduct":
                        Product p = productDaoImpl.getProductById(id);
                        p.setActive(!action.contains("deactivate"));
                        productDaoImpl.updateProduct(p);
                        break;
                    case "activateUser":
                    case "deactivateUser":
                        User u = userDaoImpl.getUserById(id);
                        u.setSuspended(action.contains("deactivate"));
                        userDaoImpl.updateUser(u);
                        break;
                    case "exit":
                        request.getSession().setAttribute("adminAuth", false);
                        break;
                    case "addProduct":
                        String category = request.getParameter("category");
                        String type = request.getParameter("type");
                        String description = request.getParameter("description");
                        double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
                        int stock = Integer.parseInt(request.getParameter("stock"));
                        String image = request.getParameter("image");
                        try{
                            p = new Product(5489, type, description, image, stock, unitPrice, category, true, false);
                            productDaoImpl.saveProduct(p);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        break;
                    case "changeAdminPass":
                        String pass1 = request.getParameter("adminPassChange");
                        String pass2 = request.getParameter("adminPassChangeConfirm");
                        if(pass1.equals(pass2)){
                            boolean success = adi.saveAdminPassword(pass1);
                            request.setAttribute("saveSuccess", success);
                        }
                    case "deleteProduct":
                        p = productDaoImpl.getProductById(id);
                        productDaoImpl.deleteProduct(p);
                        break;
                }

            }
        }

        if (request.getSession().getAttribute("adminAuth") != null && (boolean) request.getSession().getAttribute("adminAuth")) {
            List<Product> prodList = productDaoImpl.getAllProducts();
            List<User> userList = userDaoImpl.getAllUsers();
            request.setAttribute("productList", prodList);
            request.setAttribute("userList", userList);
        }
        if (action != null && action.equals("exit")) {
            response.sendRedirect("Accueil");
        } else {
            request.getRequestDispatcher("/WEB-INF/administration.jsp").forward(request, response);
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
