/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Service {
    private String basicData;
    private String multimedia;

    public Service() {
    }

    public Service(String basicData, String multimedia) {
        this.basicData = basicData;
        this.multimedia = multimedia;
    }

    public String getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
    }

    public String getBasicData() {
        return basicData;
    }

    public void setBasicData(String basicData) {
        this.basicData = basicData;
    }

    @Override
    public String toString() {
        return "Service{" + "basicData=" + basicData + ", multimedia=" + multimedia + '}';
    }
    
    
}
