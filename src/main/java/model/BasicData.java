/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class BasicData {
    
    private String name;
    private String phone;
    private String title;

    public BasicData() {
    }

    public BasicData(String name, String phone, String title) {
        this.name = name;
        this.phone = phone;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BasicData{" + "name=" + name + ", phone=" + phone + ", title=" + title + '}';
    }
    
    
    
}
