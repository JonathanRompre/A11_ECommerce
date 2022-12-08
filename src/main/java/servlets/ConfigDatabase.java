/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.ProductDaoImpl;
import dao.UserDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Constantes;
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
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        try{
        //list of Product
        List<Product> productList = new ArrayList<Product>();
        Product product1 = new Product(6984, Constantes.TYPE_FOOD, "Chicken dry food for adult large breed dog", "dogFoodDry.jpg", 1, 74.99, Constantes.CATEGORIE_PRODUIT_CHIEN, true, true);
        Product product2 = new Product(9843, Constantes.TYPE_FOOD, "White fish wet food for adult dog", "dogFoodWet.jpg", 1, 3.89, Constantes.CATEGORIE_PRODUIT_CHIEN, true, true);
        Product product3 = new Product(1456, Constantes.TYPE_FOOD, "Dog Raw Food, Beef and Chicken", "dogFoodRaw.jpg", 1, 79.99, Constantes.CATEGORIE_PRODUIT_CHIEN, true, true);
        Product product4 = new Product(9432, Constantes.TYPE_TREAT,"Hips and Joints Adult Dog Biscuits", "dogBiscuit.jpg", 1, 7.99, Constantes.CATEGORIE_PRODUIT_CHIEN, true, true);
        Product product5 = new Product(5684, Constantes.TYPE_TREAT,"Beef marrow bone 18 to 23 cm, 400g", "dogBoneMarrow.jpg", 1, 8.29, Constantes.CATEGORIE_PRODUIT_CHIEN, true, true);
        Product product6 = new Product(3574, Constantes.TYPE_SUPPLY, "Training pads for puppies and small dogs, 150 un.", "dogPad.jpg", 1, 49.99, Constantes.CATEGORIE_PRODUIT_CHIEN, true, true);
        Product product7 = new Product(7591, Constantes.TYPE_SUPPLY, "Indoor turf dog potty with absorbent pad", "dogTurfPad.jpg", 1, 51.99, Constantes.CATEGORIE_PRODUIT_CHIEN, true, true);
        Product product8 = new Product(9438, Constantes.TYPE_SUPPLY, "Luxurious Ultra Soft Pet Bed, dark grey", "dogBed.jpg", 1, 89.99, Constantes.CATEGORIE_PRODUIT_CHIEN, true, false);
        Product product9 = new Product(6674, Constantes.TYPE_TOY, "Hyper Fetch dog toy", "dogFetchToy.jpg", 1, 99.99, Constantes.CATEGORIE_PRODUIT_CHIEN, true, false);
        Product product10 = new Product(4489, Constantes.TYPE_TOY, "Squeezz Dental Stick", "dogToyKong.jpg", 1, 18.49, Constantes.CATEGORIE_PRODUIT_CHIEN, true, false);
        Product product11 = new Product(3784, Constantes.TYPE_FOOD, "Chicken Wet Food for Senior Cats", "catFoodWet.jpg", 1, 2.59, Constantes.CATEGORIE_PRODUIT_CHAT, true, true);
        Product product12 = new Product(1124, Constantes.TYPE_FOOD, "Chicken wet food for adult cats", "catFoodWet2.jpg", 1, 1.25, Constantes.CATEGORIE_PRODUIT_CHAT, true, true);
        Product product13 = new Product(7748, Constantes.TYPE_TREAT, "Grain Free Chicken, Chicken Liver & Duck Treats, 30 g (1 oz)", "catTreat.jpg", 1, 74.99, Constantes.CATEGORIE_PRODUIT_CHAT, true, true);
        Product product14 = new Product(3784, Constantes.TYPE_TREAT, "Nibbly cat treats, chicken & liver", "catTreat2.jpg", 1, 3.99, Constantes.CATEGORIE_PRODUIT_CHAT, true, true);
        Product product15 = new Product(6971, Constantes.TYPE_FOOD, "Chicken dry food for indoor adult cats", "catFoodDry.jpg", 1, 60.99, Constantes.CATEGORIE_PRODUIT_CHAT, true, true);
        Product product16 = new Product(3748, Constantes.TYPE_SUPPLY, "Clumping litter", "catLitter.jpg", 1, 13.99, Constantes.CATEGORIE_PRODUIT_CHAT, true, true);
        Product product17 = new Product(3945, Constantes.TYPE_SUPPLY, "Recycled jumbo scoop, grey", "catLitterScoop.jpg", 1, 1.89, Constantes.CATEGORIE_PRODUIT_CHAT, true, false);
        Product product18 = new Product(3942, Constantes.TYPE_TOY, "Kaia 4-Level Cat Tree", "catTree.jpg", 1, 179.99, Constantes.CATEGORIE_PRODUIT_CHAT, true, false);
        Product product19 = new Product(7789, Constantes.TYPE_TOY, "Laser Toy", "catLaser.jpg", 1, 6.99, Constantes.CATEGORIE_PRODUIT_CHAT, true, true);
        Product product20 = new Product(3942, Constantes.TYPE_TOY, "Cat-teaser wand with a feathered fish", "catToy.jpg", 1, 9.99, Constantes.CATEGORIE_PRODUIT_CHAT, true, true);
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
            productDaoImpl.saveProduct(productList.get(i));
            System.out.println(productList.get(i));
        }

        //list of user
        List<User> userList = new ArrayList<User>();

        User user1 = new User("Luc", "Gendron", "LGendron@site.com","PwLucGendron",true);
        User user2 = new User("Lucie", "Dufort", "MissDufort@site.com","PwLucieDufort",true);
        User user3 = new User("Fred", "Cailloux", "Flintstone@site.com","PwFredCailloux",false);
        User user4 = new User("Laurent", "Dauphin", "TheRealFlipper@site.com","PwLaurentDauphin",true);
        User user5 = new User("Dieudonné", "Jean", "DJ@site.com","PwDieudonnéJean",true);
        //add user to the list
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        //Send to database
        for (int i = 0; i < userList.size(); i++) {
            userDaoImpl.saveUser(userList.get(i));
        }
        }catch (Exception e) {
            e.printStackTrace();
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
