/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.File;
import model.ServiceList;
import org.xml.sax.SAXException;
import parser.ServiceListController;


public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException {
        String nombreFichero1 = "hotelesMadrid.xml";
        File fichXml1 = new File(nombreFichero1);
        
        ServiceListController svc = new ServiceListController(fichXml1);
        svc.recuperarXML();
        
        ServiceList serviceList = new ServiceList();
        serviceList = svc.leerDOM();
        
        System.out.println(serviceList);
        
    }
    
}
