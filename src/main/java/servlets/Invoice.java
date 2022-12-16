/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.CartDaoImpl;
import dao.CartProductDaoImpl;
import dao.ProductDaoImpl;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.CartProduct;
import modele.CheckoutItem;
import modele.Product;

public class Invoice extends HttpServlet {

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
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            CartDaoImpl cartDaoImpl = new CartDaoImpl();
            CartProductDaoImpl cartProductDaoImpl = new CartProductDaoImpl();
            ProductDaoImpl productDaoImpl = new ProductDaoImpl();

            HttpSession session = request.getSession();
            Integer uID = (Integer) session.getAttribute("uid");
            Integer cID = cartDaoImpl.getCurrentCartIdByUserId(uID);

            List<CartProduct> cartProductsList = cartProductDaoImpl.getAllCartProductsWithCartId(cID);
            List<CheckoutItem> listCheckoutItems = new ArrayList<>();
            cartDaoImpl.setCartCurrentFalseForUserId(uID);
            

            for (CartProduct cartProduct : cartProductsList) {
                Product product = cartProduct.getProduct();
                CheckoutItem checkoutItem = new CheckoutItem(cartProduct, product);
                listCheckoutItems.add(checkoutItem);
            }
            if (listCheckoutItems == null) {
                document.add(new Paragraph("Your cart is empty"));

            } else {
                Paragraph titre = new Paragraph("Invoice", FontFactory.getFont(FontFactory.TIMES, 18, Font.BOLDITALIC, BaseColor.BLUE));
                titre.setAlignment(Element.ALIGN_CENTER);
                titre.setSpacingAfter(30f);

                document.add(titre);

                int prixTotal = 0;
                PdfPTable table = new PdfPTable(5);

                table.addCell(new Paragraph("Name", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLDITALIC, BaseColor.BLACK)));
                table.addCell(new Paragraph("Description", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLDITALIC, BaseColor.BLACK)));
                table.addCell(new Paragraph("Price unit", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLDITALIC, BaseColor.BLACK)));
                table.addCell(new Paragraph("Quantity", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLDITALIC, BaseColor.BLACK)));
                table.addCell(new Paragraph("Total", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLDITALIC, BaseColor.BLACK)));

                for (int index = 0; index < listCheckoutItems.size(); index++) {
                    CheckoutItem item = (CheckoutItem) listCheckoutItems.get(index);
                    
                    int qty = item.getCartProduct().getQuantity();
                    double price = item.getProduct().getPrice();
                    double total = (qty * price );
                    NumberFormat formatter = new DecimalFormat("##.##");
                    table.addCell(" " + item.getProduct().getCategorie() + item.getProduct().getType() + " ");
                    table.addCell(" " + item.getProduct().getDescription() + " $");
                    table.addCell(" " + item.getProduct().getPrice());
                    table.addCell(" " + item.getCartProduct().getQuantity());
                    table.addCell(" " + formatter.format(total));
                }
                document.add(table);

            }
            document.close();
            
        } catch (Exception e) {
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
