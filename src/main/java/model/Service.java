/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.BasicDataDAO;
import DAO.MediaDAO;
import DAO.ServiceDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class Service {
    private BasicData basicData;
    private Multimedia multimedia;
    private int idService = 1;

    public Service(BasicData basicData, Multimedia multimedia) {
        this.basicData = basicData;
        this.multimedia = multimedia;
    }
    
    public void insertaBasicDataBBDD(Connection con, BasicData basicData) throws SQLException, Exception {
        ServiceDAO servDao = new ServiceDAO(con, this);
        servDao.insertarBasicData();
    }
    
    public boolean comprobarBasicDataBBDD(Connection con, BasicData basicData) throws SQLException, Exception {
        ServiceDAO servDao = new ServiceDAO(con, this);
        return servDao.compruebaBasicData(basicData);
    }
    
    /*public void insertaMultimediaBBDD(Connection con, Multimedia multimedia) throws SQLException, Exception {
        ServiceDAO servDao = new ServiceDAO(con, this);
        servDao.insertarMultimedia();
    }
    
    public boolean comprobarMultimediaBBDD(Connection con, Multimedia multimedia) throws SQLException, Exception {
        ServiceDAO servDao = new ServiceDAO(con, this);
        return servDao.compruebaMultimedia(multimedia);
    }*/

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
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

    @Override
    public String toString() {
        return "Service: " + "\n\tBasicData: " + basicData + "\n\tMultimedia: " + multimedia;
    }
    

     
    
    
    

    
    
    
     
}