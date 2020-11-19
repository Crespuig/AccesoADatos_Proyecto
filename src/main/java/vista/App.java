/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import DAO.Conexion_DB;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import model.ServiceList;
import org.xml.sax.SAXException;
import parser.ServiceListController;


public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException, ClassNotFoundException, SQLException {
        Conexion_DB conexion_DB = new Conexion_DB();
        System.out.println("Abrir conexión");
        Connection con = conexion_DB.abrirConexion();
        System.out.println("Conexión abierta");
        
        System.out.println("Cerrar conexion");
        conexion_DB.cerrarConexion(con);
        System.out.println("Conexion cerrada");
        
        String nombreFichero1 = "hotelesMadrid.xml";
        File fichXml1 = new File(nombreFichero1);
        
        ServiceListController svc = new ServiceListController(fichXml1);
        svc.recuperarXML();
        
        ServiceList serviceList = new ServiceList();
        serviceList = svc.leerDOM();
        
        System.out.println(serviceList);
        
    }
    
}
