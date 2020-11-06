/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;


public class Service {
    private BasicData basicData;
    private String multimedia;

    public Service(BasicData basicData/*, String multimedia*/) {
        this.basicData = basicData;
        this.multimedia = multimedia;
    }

    public BasicData getBasicData() {
        return basicData;
    }

    public void setBasicData(BasicData basicData) {
        this.basicData = basicData;
    }

    public String getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
    }

    @Override
    public String toString() {
        return "Service: " + "\n\tBasicData: " + basicData + "\n\tMultimedia: " + multimedia;
    }
    

     
    
    
    

    
    
    
     
}