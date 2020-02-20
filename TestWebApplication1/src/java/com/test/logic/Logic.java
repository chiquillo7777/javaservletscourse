/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.logic;

import com.test.database.Database;

/**
 *
 * @author balbino.aylagas
 */
public class Logic 
{
    private Database database;

    public Logic() 
    {
        setDatabase( createDatabase() );
    }

    public Database getDatabase() {
        return database;
    }

    private void setDatabase(Database database) {
        this.database = database;
    }

    private Database createDatabase() 
    {
        Database locDatabase = getDatabase();
        
        if(locDatabase==null)
        {
            locDatabase = new Database();
        }
        
        return locDatabase;
    }
    
    
}
