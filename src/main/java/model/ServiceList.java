/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;


public class ServiceList extends ArrayList<Service>{
    public ArrayList<Service> getService() {
        return this;
    }
    
    /*public ArrayList<Multimedia> getMultimedia(){
        return this;
    }*/

    @Override
    public String toString() {
        String result = "+";
        for (int i = 0; i < this.getService().size(); i++) {
            result += "\n" + this.getService().get(i);
        }

        return result;

    }
    
    /*@Override
    public String toString() {
        String result = "+";
        for (int i = 0; i < this.getMultimedia().size(); i++) {
            result += "\n" + this.getMultimedia().get(i);
        }

        return result;

    }*/
}
