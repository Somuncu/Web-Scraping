package com.company;

import java.sql.*;
import java.util.ArrayList;

public class DbManager {

    public void selectDemo() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try{
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from products");
            ArrayList<Products> products = new ArrayList<Products>();
            while(resultSet.next()){
                products.add(new Products(
                        resultSet.getString("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("imageUri"),
                        resultSet.getString("datePublished"),
                        resultSet.getString("productCategory"),
                        resultSet.getString("color"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("discount") == 1
                        ));
            }
            System.out.println(products.size());
        }catch (SQLException exeption){
            dbHelper.showErrorMessage(exeption);
        }
        finally {
            connection.close();
        }
    }

    public void insertDemo(Products product) throws SQLException{
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try{
            connection = dbHelper.getConnection();
            statement = connection.prepareStatement("insert into products(id,title,description,imageUri,datePublished,productCategory,color,price,discount,oldprice) values(?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1,product.getId());
            statement.setString(2,product.getTitle());
            statement.setString(3,product.getDescription());
            statement.setString(4,product.getImageUri());
            statement.setString(5,product.getDatePublished());
            statement.setString(6,product.getProductCategory());
            statement.setString(7,product.getColor());
            statement.setDouble(8,product.getPrice());
            statement.setInt(9,product.getDiscount() ? 1 : 0 );
            statement.setDouble(10,product.getOldprice());
            int result = statement.executeUpdate();
            System.out.println("kayıt Eklendi");

        }catch (SQLException exeption){
            dbHelper.showErrorMessage(exeption);
        }
        finally {
            statement.close();
            connection.close();
        }
    }

}
