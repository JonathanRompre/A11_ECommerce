/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.ConfigDatabaseDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Product;
import modele.User;

/**
 *
 * @author Samuel
 */
public class ConfigDatabase extends HttpServlet {

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
        ConfigDatabaseDaoImpl configDatabaseDaoImpl = new ConfigDatabaseDaoImpl();
        //list of Product
        List<Product> productList = new ArrayList<Product>();
        Product product1 = new Product("Chicken dry food for adult large breed dog", "dogFoodDry.jpg", Integer.SIZE, 74.99, true, true);
        Product product2 = new Product("White fish wet food for adult dog", "dogFoodWet.jpg", Integer.SIZE, 3.89, true, true);
        Product product3 = new Product("Dog Raw Food, Beef and Chicken", "dogFoodRaw.jpg", Integer.SIZE, 79.99, true, true);
        Product product4 = new Product("Hips and Joints Adult Dog Biscuits", "dogBiscuit.jpg", Integer.SIZE, 7.99, true, true);
        Product product5 = new Product("Beef marrow bone 18 to 23 cm, 400g", "dogBoneMarrow.jpg", Integer.SIZE, 8.29, true, true);
        Product product6 = new Product("Training pads for puppies and small dogs, 150 un.", "dogPad.jpg", Integer.SIZE, 49.99, true, true);
        Product product7 = new Product("Indoor turf dog potty with absorbent pad", "dogTurfPad.jpg", Integer.SIZE, 51.99, true, true);
        Product product8 = new Product("Luxurious Ultra Soft Pet Bed, dark grey", "dogBed.jpg", Integer.SIZE, 89.99, true, false);
        Product product9 = new Product("Hyper Fetch dog toy", "dogFetchToy.jpg", Integer.SIZE, 99.99, true, false);
        Product product10 = new Product("Squeezz Dental Stick", "dogToyKong.jpg", Integer.SIZE, 18.49, true, false);
        Product product11 = new Product("Chicken Wet Food for Senior Cats", "catFoodWet.jpg", Integer.SIZE, 2.59, true, true);
        Product product12 = new Product("Chicken wet food for adult cats", "catFoodWet2.jpg", Integer.SIZE, 1.25, true, true);
        Product product13 = new Product("Grain Free Chicken, Chicken Liver & Duck Treats, 30 g (1 oz)", "catTreat.jpg", Integer.SIZE, 74.99, true, true);
        Product product14 = new Product("Nibbly cat treats, chicken & liver", "catTreat2.jpg", Integer.SIZE, 3.99, true, true);
        Product product15 = new Product("Chicken dry food for indoor adult cats", "catFoodDry.jpg", Integer.SIZE, 60.99, true, true);
        Product product16 = new Product("Clumping litter", "dogFood.jpg", Integer.SIZE, 13.99, true, true);
        Product product17 = new Product("Recycled jumbo scoop, grey", "catLitterScoop.jpg", Integer.SIZE, 1.89, true, false);
        Product product18 = new Product("Kaia 4-Level Cat Tree", "CatTree.jpg", Integer.SIZE, 179.99, true, false);
        Product product19 = new Product("Laser Toy", "catLaser.jpg", Integer.SIZE, 6.99, true, true);
        Product product20 = new Product("Cat-teaser wand with a feathered fish", "catToy.jpg", Integer.SIZE, 9.99, true, true);
        //Add to the list of product
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);
        productList.add(product10);
        productList.add(product11);
        productList.add(product12);
        productList.add(product13);
        productList.add(product14);
        productList.add(product15);
        productList.add(product16);
        productList.add(product17);
        productList.add(product18);
        productList.add(product19);
        productList.add(product20);
        //Send to database
        for (int i = 0; i < productList.size(); i++) {
            configDatabaseDaoImpl.addDatabaseProduct(productList.get(i));
        }
        
        
        //list of user
        List<User> userList = new ArrayList<User>();
        
        User user1 = new User("Luc", "Gendron", "LGendron@site.com");
        User user2 = new User("Lucie", "Dufort", "MissDufort@site.com");
        User user3 = new User("Fred", "Cailloux", "Flintstone@site.com");
        User user4 = new User("Laurent", "Dauphin", "TheRealFlipper@site.com");
        User user5 = new User("Dieudonné", "Jean", "DJ@site.com");
        //add user to the list
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        //Send to database
        for (int i = 0; i < userList.size(); i++) {
            configDatabaseDaoImpl.addDatabaseUser(userList.get(i));
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
