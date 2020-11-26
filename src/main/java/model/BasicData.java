/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.BasicDataDAO;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author HECTOR
 */
public class BasicData {

    private String language;
    private String phone;
    private String web;
    private int idBasicData;

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public int getIdBasicData() {
        return idBasicData;
    }

    public void setIdBasicData(int idBasicData) {
        this.idBasicData = idBasicData;
    }

    public BasicData() {
    }

    public BasicData(int idBasicData) {
        this.idBasicData = idBasicData;
    }

    public BasicData(String language, String phone, String web) {
        this.language = language;
        this.phone = phone;
        this.web = web;
    }

    public int insertaBasicDataBBDD(Connection con) throws SQLException, Exception {
        BasicDataDAO bdDao = new BasicDataDAO(con, this);
        return bdDao.insertaBasicData();
    }

    public int eliminarBasicDataBBDD(Connection con) throws SQLException, Exception {
        BasicDataDAO bdDao = new BasicDataDAO(con, this);
        return bdDao.eliminaBasicData();
    }

    public int actualizarBasicDataBBDD(Connection con) throws SQLException, Exception {
        BasicDataDAO bdDao = new BasicDataDAO(con, this);
        return bdDao.actualizaBasicData();
    }

    /*public Cliente buscaClienteByDni(Connection con) throws SQLException{
        ClienteDAO cliDao = new ClienteDAO(con, this);
        Cliente cli;
        cli = cliDao.buscaClienteByDni(this.getDni());
        return cli;
    }*/
    public void modificaBasicData(Connection con) throws SQLException {
        BasicDataDAO bdDao = new BasicDataDAO(con, this);
        bdDao.actualizaBasicData();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String name) {
        this.language = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return web;
    }

    public void setTitle(String title) {
        this.web = web;
    }

    @Override
    public String toString() {
        return "\n\t\tLanguage: " + language + "\n\t\tPhone: " + phone + "\n\t\tWeb: " + web;
    }

}
