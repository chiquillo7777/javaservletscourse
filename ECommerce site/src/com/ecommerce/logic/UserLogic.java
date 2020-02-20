/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.logic;

import com.ecommerce.database.Database;
import com.ecommerce.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos.chiquillo
 */
public class UserLogic extends Logic {
    
    
      public User getUserById(int pId)
    {
        Database locDatabase = getDatabase();
        ResultSet result = locDatabase.executeQuery("select * from users where id="+pId);
        
        User user =null;
          try {
              user = new User(result.getInt("id"), result.getString("username"), result.getString("email"), result.getString("password"));
          } catch (SQLException ex) {
              Logger.getLogger(UserLogic.class.getName()).log(Level.SEVERE, null, ex);
          }
        return user;
    }
    
    public List<User> getCustomerList()
    {
        Database locDatabase = getDatabase();
        ResultSet result = locDatabase.executeQuery("select * from users;");
        //locDatabase.executeNonQueryRows("insert data into sales;");
        List<User> usersList = new ArrayList<>();

          try {
              while(result.next()){
                  try {
                      usersList.add(new User(result.getInt("id"), result.getString("username"), result.getString("email"), result.getString("password")));
                  } catch (SQLException ex) {
                      Logger.getLogger(UserLogic.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          } catch (SQLException ex) {
              Logger.getLogger(UserLogic.class.getName()).log(Level.SEVERE, null, ex);
          }
         
          return usersList;
    }
    
     public  int login(String email, String password){
       int userId = 0; 
        Database locDatabase = getDatabase();
        ResultSet result = locDatabase.executeQuery("select id from users where email = '" + email + "' and password ='" +password + "';");
          try {
              while(result.next()){
                  try {
                      userId = result.getInt("id");
                  } catch (SQLException ex) {
                      Logger.getLogger(UserLogic.class.getName()).log(Level.SEVERE, null, ex);
                  }
              } } catch (SQLException ex) {
              Logger.getLogger(UserLogic.class.getName()).log(Level.SEVERE, null, ex);
          }
       
          return userId;
    }
     
    public boolean addUser(User user){
           boolean isAdded = false;
           Database locDataBase = getDatabase();
           String username = user.getUsername();
           String email = user.getEmail();
           String password = user.getPassword();
           isAdded = locDataBase.executeNonQueryBool("insert into users (username, email, password) values(" + "'" + username + "',  '" + email + "', '" + password + "')");
           
        return isAdded;
    }
}