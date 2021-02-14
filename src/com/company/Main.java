package com.company;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {

        DbManager dbManager = new DbManager();
        DataScraber dataScraber = new DataScraber();

        ArrayList<Products> products = null;
        try {
            products = dataScraber.getProduct();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Products product : products){
            dbManager.insertDemo(product);
        }

    }
}
