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
import model.BasicData;
import model.Media;
import model.Multimedia;
import model.Service;

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

    public int insertaMedia(BasicData basicData) throws Exception {
        int idBasicData = obtenerIdBasicData(basicData);
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO media (idBasicData, url)" + "VALUES (?,?);");
            stmt.setInt(1, idBasicData);
            stmt.setString(2, media.getUrl());  
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

        stmt = con.prepareStatement("UPDATE media SET url=?");
        stmt.setString(1, media.getUrl());
       
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
    
    public int obtenerIdBasicData(BasicData basicData) throws SQLException, Exception {        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM basicdata WHERE phone=?");       
            stmt.setString(1, basicData.getPhone());
            rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idBasicData");
            }
            return 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el BasicData");
        }finally{
            if (stmt != null) stmt.close();
        }
        
    }
}

