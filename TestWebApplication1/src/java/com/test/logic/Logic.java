
package com.test.logic;

import com.test.database.Database;


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
