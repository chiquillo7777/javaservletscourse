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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos.chiquillo
 */
public class ShoppingCartLogic extends Logic {
    
    public List<Product> getProductsInShoppingCartBYCustomerId(int userid)
    {
        Database locDatabase = getDatabase();
        ResultSet result = locDatabase.executeQuery("select p.id, p.name, p.description, p. category, p.price from users u inner join shoppingcart sc on u.id = sc.userid inner join shoppingcart_details sd on sc.id = sd.shoppingcartid inner join products p on p.id = sd.productid where u.id=" +userid);
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
    
    public boolean addProductToShoppingCart(int shoppingcartid, int productid, int quantity){
           boolean isAdded = false;
           Database locDataBase = getDatabase();
           int locshoppingcartid = shoppingcartid;
           int locproductid = productid;
           int  locquantity = quantity;
           isAdded = locDataBase.executeNonQueryBool("Insert into shoppingcart_details(shoppingcartid, productid, quantity) values ((select sc.id from shoppingcart sc inner join users u on u.id=sc.userid where u.id="+ shoppingcartid + "), "+ productid +", "+ quantity+")");
           
        return isAdded;
    }
    
}
