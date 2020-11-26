/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ServiceDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class Multimedia {
    
    private ArrayList<Media> media;
    Connection con;

    public Multimedia() {
        this.media = new ArrayList<>();
    }

    public Multimedia(ArrayList<Media> media) {
        this.media = media;
    }

    private Multimedia(Connection con, ArrayList<Media> media) {
        this.con = con;
        this.media = media;
        
    }
    
    /*public void insertaMediaBBDD(Connection con, ArrayList<Media> media) throws SQLException, Exception {
        Media media = new Media(con, this);
        media.insertaMediaBBDD(con, media);
    }
    
    public boolean comprobarMediaBBDD(Connection con, Multimedia multimedia) throws SQLException, Exception {
        ServiceDAO servDao = new ServiceDAO(con, this);
        return servDao.compruebaMultimedia(multimedia);
    }*/

    public ArrayList<Media> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<Media> media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "\n\t\tMedia: " + media;
    }
    
    
    
    
}
