/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modele.Administrator;
import modele.Product;
import modele.User;
import org.hibernate.boot.model.relational.Database;

/**
 *
 * @author Samuel
 */
public class ConfigDatabaseDaoImpl implements IConfigDatabaseDao {

    private static Connection connection;

    @Override
    public boolean addDatabaseProduct(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ConstantesDao.DATABASE_Product);
            preparedStatement.setString(1, product.getDescription());
            preparedStatement.setString(1, product.getImageName());
            preparedStatement.setInt(1, product.getQuantity());
            preparedStatement.setDouble(1, product.getPrice());
            preparedStatement.setBoolean(1, product.isActive());
            preparedStatement.setBoolean(1, product.isRecurrentPossible());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addDatabaseUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ConstantesDao.DATABASE_USER);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(1, user.getLastName());
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setBoolean(1, user.isIsSuspended());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
