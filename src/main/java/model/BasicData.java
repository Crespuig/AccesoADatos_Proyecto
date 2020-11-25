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

    public int insertaClienteBBDD(Connection con) throws SQLException, Exception {
        BasicDataDAO cliDao = new BasicDataDAO(con, this);
        return cliDao.insertaBasicData();
    }

    public int eliminarClienteBBDD(Connection con) throws SQLException, Exception {
        BasicDataDAO cliDAO = new BasicDataDAO(con, this);
        return cliDAO.elimina();
    }

    public int actualizarClienteBBDD(Connection con) throws SQLException, Exception {
        BasicDataDAO cliDAO = new BasicDataDAO(con, this);
        return cliDAO.actualiza();
    }

    /*public Cliente buscaClienteByDni(Connection con) throws SQLException{
        ClienteDAO cliDao = new ClienteDAO(con, this);
        Cliente cli;
        cli = cliDao.buscaClienteByDni(this.getDni());
        return cli;
    }*/
    public void modificaCliente(Connection con) throws SQLException {
        BasicDataDAO cliDao = new BasicDataDAO(con, this);
        cliDao.actualiza();
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
