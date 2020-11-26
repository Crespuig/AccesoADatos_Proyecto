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

/**
 *
 * @author HECTOR
 */
public class MediaDAO {

    private Connection con;
    private Media media;

    public MediaDAO(Connection con, Media media) {
        this.con = con;
        this.media = media;
    }

    public MediaDAO(Connection con) {
        this.con = con;
    }

    public int insertaMedia() throws Exception {
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO media (url, type)"
                    + "VALUES (?,?);");
            stmt.setString(1, media.getUrl());
            stmt.setString(2, media.getType());
            
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Problema al insertar media.");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public int actualizaMedia() throws SQLException {
        PreparedStatement stmt = null;

        stmt = con.prepareStatement("UPDATE media SET url=?, type=?");
        stmt.setString(1, media.getUrl());
        stmt.setString(2, media.getType());
       
        return stmt.executeUpdate();

    }

    public int eliminaMedia() throws SQLException {
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("DELETE FROM media WHERE media=?");
        stmt.setInt(1, media.getIdMedia());
        return stmt.executeUpdate();
    }

    public Media buscaMediaById(int id) throws SQLException, Exception {
        Media basicdata = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM media WHERE media=?");       
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                media = new Media();
                media.setIdMedia(rs.getInt("idMedia"));
                media.setUrl(rs.getString("url"));
                media.setType(rs.getString("type"));
            }
            return basicdata;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el Media");
        }finally{
            if (stmt != null) stmt.close();
        }
        
    

    }

    public String recuperaMedia() throws SQLException, Exception {
        String lista = "Lista de Media: \n-----------------\n";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM media");

            rs = stmt.executeQuery();
            while (rs.next()) {
                lista += rs.getInt("idMedia") + " -> " + rs.getString("url") + " " + rs.getString("type") + "\n";

            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al recuperar los Media");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }
}

