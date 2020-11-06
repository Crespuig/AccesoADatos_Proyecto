/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HECTOR
 */
public class BasicData {
    private String language;
    private String phone;
    private String web;

    public BasicData() {
    }

    public BasicData(String language, String phone, String web) {
        this.language = language;
        this.phone = phone;
        this.web = web;
    }

    public String getName() {
        return language;
    }

    public void setName(String name) {
        this.language = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return web;
    }

    public void setTitle(String title) {
        this.web = web;
    }

    @Override
    public String toString() {
        return "\n\t\tLanguage: " + language + "\n\t\tPhone: " + phone + "\n\t\tWeb: " + web;
    }
    
    
}
