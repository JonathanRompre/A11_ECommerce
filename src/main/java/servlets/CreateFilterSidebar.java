/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Category;
import modele.Product;
import modele.Constantes;
import modele.ItemCategorie;
import modele.ProductUtilitaire;
import modele.Utilitaire;

/**
 *
 * @author Jon
 */
public class CreateFilterSidebar extends HttpServlet {

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

        String baseUrl = request.getRequestURI();
        String baseSearchQuery = request.getQueryString();
        
        request.getSession().setAttribute("listProduct", 
                    ProductUtilitaire.getFilteredProductList(baseSearchQuery)
                );
        
        List<Product> listeProduct = (List<Product>) request.getSession().getAttribute("listProduct");
        
        Set<ItemCategorie> uniqueCategorie = new TreeSet<>();
        Set<ItemCategorie> uniqueType = new TreeSet<>();
        Set<ItemCategorie> priceRanges = new TreeSet<>();
        Set<ItemCategorie> availability = new TreeSet<>();
        boolean priceRange1Added = false;
        boolean priceRange2Added = false;
        boolean priceRange3Added = false;
        boolean priceRange4Added = false;
        
        for (Product p : listeProduct) {
            // get unique categories
            ItemCategorie tmp = new ItemCategorie(p.getCategorie(), baseUrl +"?"+ Utilitaire.buildUrl(baseSearchQuery, "Companion", p.getCategorie()),
                    Utilitaire.isActiveFilter(baseSearchQuery, p.getCategorie())
            );
            
            uniqueCategorie.add(
                    tmp
            );

            // get unique types
            tmp = new ItemCategorie(p.getType(),
                    baseUrl +"?"+ Utilitaire.buildUrl(baseSearchQuery, "Type", p.getType()),
                    Utilitaire.isActiveFilter(baseSearchQuery, p.getType())
            );
            boolean notEqual = true;
            for(ItemCategorie ic:uniqueType){
                if(tmp.getName().equals(ic.getName()) || tmp.equals(ic) || tmp.compareTo(ic)==0){
                    notEqual = false;
                }
            }
            if(notEqual){
                uniqueType.add(tmp);
            }
            
            // get price ranges
            if (p.getPrice() > 0 && p.getPrice() < 20 && !priceRange1Added) {
                if(priceRanges.add(
                    new ItemCategorie(Constantes.PRICE_RANGE_0_1999,
                            baseUrl +"?"+ Utilitaire.buildUrl(baseSearchQuery, "Price", Constantes.PRICE_RANGE_0_1999),
                            Utilitaire.isActiveFilter(baseSearchQuery, Constantes.PRICE_RANGE_0_1999)
                    )
                )){
                    priceRange1Added = true;
                };
            } else if (p.getPrice() >= 20 && p.getPrice() < 50 && !priceRange2Added) {
                if(priceRanges.add(
                    new ItemCategorie(Constantes.PRICE_RANGE_20_4999,
                            baseUrl +"?"+ Utilitaire.buildUrl(baseSearchQuery, "Price", Constantes.PRICE_RANGE_20_4999),
                            Utilitaire.isActiveFilter(baseSearchQuery, Constantes.PRICE_RANGE_20_4999)
                    )
                )){
                    priceRange2Added = true;
                };
            } else if (p.getPrice() >= 50 && p.getPrice() < 100 && !priceRange3Added) {
                if(priceRanges.add(
                    new ItemCategorie(Constantes.PRICE_RANGE_50_9999,
                            baseUrl +"?"+ Utilitaire.buildUrl(baseSearchQuery, "Price", Constantes.PRICE_RANGE_50_9999),
                            Utilitaire.isActiveFilter(baseSearchQuery, Constantes.PRICE_RANGE_50_9999)
                    )
                )){
                    priceRange3Added = true;
                };
            } else if(p.getPrice() >= 100 && p.getPrice() < 500 && !priceRange4Added){
                if(priceRanges.add(
                    new ItemCategorie(Constantes.PRICE_RANGE_100_49999,
                            baseUrl +"?"+ Utilitaire.buildUrl(baseSearchQuery, "Price", Constantes.PRICE_RANGE_100_49999),
                            Utilitaire.isActiveFilter(baseSearchQuery, Constantes.PRICE_RANGE_100_49999)
                    )
                )){
                    priceRange4Added = true;
                };
            }

            // get availability
            if (p.getQuantity() > 0 && p.isActive()) {
                availability.add(
                        new ItemCategorie(Constantes.AVAILABILITY_AVAILABLE,
                                baseUrl +"?"+ Utilitaire.buildUrl(baseSearchQuery, "Availability", Constantes.AVAILABILITY_AVAILABLE),
                                Utilitaire.isActiveFilter(baseSearchQuery, Constantes.AVAILABILITY_AVAILABLE)
                        )
                );
            } else {
                availability.add(
                        new ItemCategorie(Constantes.AVAILABILITY_NOT_AVAILABLE,
                                baseUrl +"?"+ Utilitaire.buildUrl(baseSearchQuery, "Availability", Constantes.AVAILABILITY_NOT_AVAILABLE),
                                Utilitaire.isActiveFilter(baseSearchQuery, Constantes.AVAILABILITY_NOT_AVAILABLE)
                        )
                );
            }
        }
        // assemble list of categories.
        List<Category> categories = new ArrayList<>();
        if (!uniqueCategorie.isEmpty()) {
            categories.add(
                    new Category("Companion", uniqueCategorie)
            );
        }
        if (!uniqueType.isEmpty()) {
            categories.add(
                    new Category("Type", uniqueType)
            );
        }
        categories.add(
                new Category("Price", Utilitaire.sortPriceFilters(priceRanges))
        );
        categories.add(
                new Category("Availability", availability)
        );

        request.setAttribute("filterCategories", categories);
        request.getRequestDispatcher("/WEB-INF/genFiltres.jsp").forward(request, response);
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
