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

/**
 *
 * @author HECTOR
 */
public class BasicDataDAO {
    private Connection con;
    private BasicData basicData;

    public BasicDataDAO(Connection con, BasicData basicData) {
        this.con = con;
        this.basicData = basicData;
    }

    public BasicDataDAO(Connection con) {
        this.con = con;
    }

    public int insertaBasicData() throws Exception {
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO basicdata (language, phone, web)"
                    + "VALUES (?,?,?,?,?,?,?,?);");
            stmt.setString(1, basicData.getLanguage());
            stmt.setString(2, basicData.getPhone());
            stmt.setString(3, basicData.getWeb());
            
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Problema al insertar basicData.");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public int actualizaBasicData() throws SQLException {
        PreparedStatement stmt = null;

        stmt = con.prepareStatement("UPDATE basicdata SET language=?, phone=? "
                + "web=?");
        stmt.setString(1, basicData.getLanguage());
        stmt.setString(2, basicData.getPhone());
        stmt.setString(3, basicData.getTitle());
       
        return stmt.executeUpdate();

    }

    public int eliminaBasicData() throws SQLException {
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("DELETE FROM basicdata WHERE idBasicData=?");
        stmt.setInt(1, basicData.getIdBasicData());
        return stmt.executeUpdate();
    }

    public BasicData buscaBasicDataById(int id) throws SQLException, Exception {
        BasicData basicdata = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM basicdata WHERE idBasicData=?");       
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                basicdata = new BasicData();
                basicdata.setIdBasicData(rs.getInt("idBasicData"));
                basicdata.setLanguage(rs.getString("language"));
                basicdata.setPhone(rs.getString("phone"));
                basicdata.setWeb(rs.getString("web"));
            }
            return basicdata;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el BasicData");
        }finally{
            if (stmt != null) stmt.close();
        }
        
    

    }

    public String recuperaBasicData() throws SQLException, Exception {
        String lista = "Lista de BasicData: \n-----------------\n";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM basicdata");

            rs = stmt.executeQuery();
            while (rs.next()) {
                lista += rs.getInt("idBasicData") + " -> " + rs.getString("language") + " " + rs.getString("phone") + " " + rs.getString("web") + "\n";

            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al recuperar los BasicData");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }
}

