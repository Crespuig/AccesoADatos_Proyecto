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
import model.Multimedia;
import model.Service;

/**
 *
 * @author HECTOR
 */
public class ServiceDAO {
    
    private Connection con;
    private Service service;
    private BasicData basicData;
    private Multimedia multimedia;

    public ServiceDAO(Connection con, BasicData basicData, Multimedia multimedia) {
        this.con = con;
        this.basicData = basicData;
        this.multimedia = multimedia;
    }

    public ServiceDAO() {
    }

    public ServiceDAO(Connection con, Service service) {
        this.con = con;
        this.service = service;
    }
    
    public void insertarBasicData() throws SQLException, Exception {
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO basicdata (language, phone, web, idService) VALUES(?,?,?,?)");
        try {
            stmt.setString(1, service.getBasicData().getLanguage());
            stmt.setString(2, service.getBasicData().getPhone());
            stmt.setString(3, service.getBasicData().getWeb());
            stmt.setInt(4, service.getIdService());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al insertar el BasicData");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
    public boolean compruebaBasicData(BasicData basicData) throws SQLException, Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM basicdata WHERE language=? AND phone=?");
            stmt.setString(1, basicData.getLanguage());
            stmt.setString(2, basicData.getPhone());
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el BAsicData");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }
    
    public void insertarMultimedia() throws SQLException, Exception {
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO multimedia (media, idService) VALUES(?,?)");
        try {
            stmt.setString(1, service.getMultimedia().getMedia().toString());
            stmt.setInt(4, service.getIdService());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al insertar el Multimedia");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
    public boolean compruebaMultimedia(Multimedia multimedia) throws SQLException, Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM multimedia WHERE media=?");
            stmt.setString(1, multimedia.getMedia().toString());
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el Multimedia");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
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
    
    
    
}
