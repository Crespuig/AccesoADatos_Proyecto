/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.MediaDAO;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author HECTOR
 */
public class Media {
    private String url;
    private String type;
    private int idMedia;    

    public Media() {
        
    }

    public Media(String url) {
        this.url = url;
    }

    Media(Connection con, Multimedia aThis) {
        
    }
    
    public void insertaMediaBBDD(Connection con, BasicData basicData) throws SQLException, Exception {
        MediaDAO mediaDao = new MediaDAO(con, this);
        mediaDao.insertaMedia(basicData);
    }
    
    public int obtenerIdBasicDataBBDD(Connection con, BasicData basicData) throws SQLException, Exception {
        MediaDAO mediaDao = new MediaDAO(con, this);
       return  mediaDao.obtenerIdBasicData(basicData);
    }

    public int getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(int idMedia) {
        this.idMedia = idMedia;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\n\t\t\tUrl: " + url;
    }
    
    
    
}
