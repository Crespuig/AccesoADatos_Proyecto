/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;


public class Multimedia {
    
    private ArrayList<Media> media;

    public Multimedia() {
        this.media = new ArrayList<>();
    }

    public Multimedia(ArrayList<Media> media) {
        this.media = media;
    }

    public ArrayList<Media> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<Media> media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Multimedia{" + "media=" + media + '}';
    }
    
    
    
    
}
