/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.logic;

import com.ecommerce.Database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author balbino.aylagas
 */
public class UserLogic
    public User getUserById(int pId)
    {
        Database locDatabase = getDatabase();
        ResultSet result = locDatabase.executeQuery("select * from customer where id="+pId);
        
        User user = null;
        return user;
    }
    
    public List<Object> getCustomerList()
    {
        Database locDatabase = getDatabase();
        ResultSet result = locDatabase.executeQuery("select * from customer;");
        locDatabase.executeNonQueryRows("insert data into sales;");
        
        ArrayList customerList = null;
        return customerList;
    }
}
