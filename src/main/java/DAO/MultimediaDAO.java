/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Media;
import model.Multimedia;

/**
 *
 * @author HECTOR
 */
public class MultimediaDAO {
    private Connection con;
    private Multimedia multimedia;
    
    public MultimediaDAO(Connection con, Multimedia multimedia) {
        this.con = con;
        this.multimedia = multimedia;
    }

    public MultimediaDAO(Connection con) {
        this.con = con;
    }
    
    

    /*public void insertarMultimedia() throws SQLException, Exception {
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO multimedia (media, url) VALUES(?,?)");
        try {
            stmt.setString(1, multimedia.getMedia().toString());
            stmt.setString(1, multimedia.getUrl().toString());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al insertar el media");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
    public boolean compruebaMultimedia(Media media) throws SQLException, Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM multimedia WHERE url=?");
            stmt.setString(1, multimedia.getUrl().toString());
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el multimedia");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }*/
    
}
