package com.example.promotions.repository;

import com.example.promotions.entity.Promotion;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PromotionRepository {

    public List<Promotion> promotionsList(){

        List<Promotion> promotionList = new ArrayList<>();
        String currentTime = "unavailable";

        // Get time from DB server
        try {
            String url = "jdbc:mysql://testpromotion.csz4lcf937uu.us-east-1.rds.amazonaws.com:3306/promotions";
            String username = "admin";
            String password = "admin123";

            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            //ResultSet resultSet = stmt.executeQuery("SELECT nombre FROM promos p where id = 1");
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM promos p");



            while ( resultSet.next() ) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("nombre");
                String desc = resultSet.getString("descripcion");
                String fecha = resultSet.getString("fecha");
                Promotion p = new Promotion(id, name, desc, fecha);

                promotionList.add(p);
            }
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return promotionList;
    }
}
