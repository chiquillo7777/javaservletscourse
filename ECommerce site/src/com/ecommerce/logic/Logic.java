
package com.ecommerce.logic;


import com.ecommerce.database.Database;


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
