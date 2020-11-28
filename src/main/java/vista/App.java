/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import DAO.BasicDataDAO;
import DAO.Conexion_DB;
import DAO.ServiceDAO;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import model.BasicData;
import model.Media;
import model.Multimedia;
import model.Service;
import model.ServiceList;
import org.xml.sax.SAXException;
import parser.ServiceListController;
import static vista.App.in;



public class App {
    public static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) throws SAXException, ClassNotFoundException, SQLException, Exception {
        Service service;
        
        String nombreFichero1 = "hotelesMadrid.xml";
        File fichXml1 = new File(nombreFichero1);
        
        ServiceListController svc = new ServiceListController(fichXml1);
        svc.recuperarXML();
        
        ServiceList serviceList = new ServiceList();
        serviceList = svc.leerDOM();
        
        System.out.println(serviceList);
        

        Conexion_DB conexion_DB = new Conexion_DB();
        System.out.println("Abrir conexión");
        Connection con = conexion_DB.abrirConexion();
        System.out.println("Conexión abierta");
        
        /*BasicData basicData = new BasicData("es", " + 34 910 88 33 33", "http://www.esmadrid.com/alojamientos/four-seasons-hotel-madrid");
        Media media = new Media("URL");
        media.insertaMediaBBDD(con,basicData);*/
        
        
        
        for (int i = 0; i < svc.getServiceList().getService().size(); i++) {
            service = svc.getServiceList().get(i);
            
            if (!service.comprobarBasicDataBBDD(con, service.getBasicData())) {
                ServiceDAO serviceDao = new ServiceDAO(con, service);
                serviceDao.insertarBasicData();
                for (int j = 0; j <svc.getServiceList().get(i).getMultimedia().getMedia().size(); j++) {
                    Media mediaTemp = svc.getServiceList().get(i).getMultimedia().getMedia().get(j);
                    mediaTemp.insertaMediaBBDD(con, service.getBasicData());
                }
            }
            
            
          
        }
        
        
        System.out.println("Cerrar conexion");
        conexion_DB.cerrarConexion(con);
        System.out.println("Conexion cerrada");
        
    }
    
}
        
    
    

