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

    public void insertarMedia() throws SQLException, Exception {
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO multimedia (media) VALUES(?)");
        try {
            stmt.setString(1, multimedia.getMedia().toString());

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
    
    public boolean compruebaMedia(Media media) throws SQLException, Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM media WHERE url=?");
            stmt.setString(1, multimedia.getMedia().toString());
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el media");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }
    
}
