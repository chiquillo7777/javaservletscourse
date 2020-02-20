package com.ecommerce.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database 
{
    private Connection connection;
    private Statement statement;
    private ResultSet result;

    public Database() 
    {
        setConnection( createConnection() );
        setStatement( createStatement() );
        
    }
    
    public Connection getConnection() {
        return connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    private void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResult() {
        return result;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }

    private Connection createConnection() 
    {
        Connection conn = getConnection();
        if(conn==null)
        {
            try 
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                        + "login?"
                        + "user=root&password=root&autoReconnect=true&"
                        + "useSSL=false&allowPublicKeyRetrieval=true");
            } 
            catch (ClassNotFoundException | SQLException ex) 
            {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }

    private Statement createStatement() 
    {
        Statement stt = getStatement();
        Connection conn = getConnection();
        
        if(conn!=null)
        {
            if(stt==null)
            {
                try 
                {
                    stt = conn.createStatement();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return stt;
    }
    
    public int executeNonQueryRows(String pSql)
    {
        int rows = 0;
        
        Statement stt = getStatement();
        if(stt!=null)
        {
            try 
            {
                rows = stt.executeUpdate(pSql);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return rows;
    }
    
    public boolean executeNonQueryBool(String pSql)
    {
        boolean didFail = false;
        
        Statement stt = getStatement();
        if(stt!=null)
        {
            try 
            {
                didFail = stt.execute(pSql);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return didFail;
    } 
    
    public ResultSet executeQuery(String pSql)
    {
        ResultSet locResult = getResult();
        Statement stt = getStatement();
        
        if(stt!=null)
        {
            try 
            {
                locResult = stt.executeQuery(pSql);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return locResult;
    }
}

//executeQuery ----- select query
//exceuteUpdate ------ non select query
//exceute() -------- for select and non selectQuery

