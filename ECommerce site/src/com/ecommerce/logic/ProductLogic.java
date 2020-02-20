/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.logic;

import com.ecommerce.database.Database;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos.chiquillo
 */
public class ProductLogic extends Logic{
    
    public List<Product> getProductsList()
    {
        Database locDatabase = getDatabase();
        ResultSet result = locDatabase.executeQuery("select * from products;");
        //locDatabase.executeNonQueryRows("insert data into sales;");
        List<Product> productsList = new ArrayList<>();

          try {
              while(result.next()){
                  try {
                       productsList.add(new Product(result.getInt("id"), result.getString("name"), result.getString("description"), result.getString("category"), result.getFloat("price")));
                  } catch (SQLException ex) {
                      Logger.getLogger(UserLogic.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          } catch (SQLException ex) {
              Logger.getLogger(UserLogic.class.getName()).log(Level.SEVERE, null, ex);
          }
         
          return productsList;
    }
}
