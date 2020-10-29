/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;


public class Service {
    private int id;
    private String basicData;
    private ArrayList<Media> multimedia;
    
    public Service() {
    }

    public Service(int id, String basicData, ArrayList<Media> multimedia) {
        this.id = id;
        this.basicData = basicData;
        this.multimedia = multimedia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBasicData() {
        return basicData;
    }

    public void setBasicData(String basicData) {
        this.basicData = basicData;
    }

    public ArrayList<Media> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(ArrayList<Media> multimedia) {
        this.multimedia = multimedia;
    }

    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", basicData=" + basicData + ", multimedia=" + multimedia + '}';
    }

    
    
    
}
