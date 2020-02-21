/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.model;

/**
 *
 * @author carlos.chiquillo
 */
public class ShoppingCart {
    private int id;
    private int userid;

    public ShoppingCart(int id, int userid) {
        this.id = id;
        this.userid = userid;
    }

    public ShoppingCart(int userid) {
        this.userid = userid;
    }

    public ShoppingCart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    
}
