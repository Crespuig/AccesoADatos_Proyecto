/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;


public class Service {
    private BasicData basicData;
    private Multimedia multimedia;

    public Service(BasicData basicData, Multimedia multimedia) {
        this.basicData = basicData;
        this.multimedia = multimedia;
    }

    public BasicData getBasicData() {
        return basicData;
    }

    public void setBasicData(BasicData basicData) {
        this.basicData = basicData;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }

    @Override
    public String toString() {
        return "Service: " + "\n\tBasicData: " + basicData + "\n\tMultimedia: " + multimedia;
    }
    

     
    
    
    

    
    
    
     
}