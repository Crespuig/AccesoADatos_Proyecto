/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import DAO.BasicDataDAO;
import DAO.Conexion_DB;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import model.BasicData;
import model.ServiceList;
import org.xml.sax.SAXException;
import parser.ServiceListController;


public class App {
    public static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) throws SAXException, ClassNotFoundException, SQLException {
        Conexion_DB conexion_DB = new Conexion_DB();
        System.out.println("Abrir conexión");
        Connection con = conexion_DB.abrirConexion();
        System.out.println("Conexión abierta");
        
        System.out.println("Cerrar conexion");
        conexion_DB.cerrarConexion(con);
        System.out.println("Conexion cerrada");
        
        /*String nombreFichero1 = "hotelesMadrid.xml";
        File fichXml1 = new File(nombreFichero1);
        
        ServiceListController svc = new ServiceListController(fichXml1);
        svc.recuperarXML();
        
        ServiceList serviceList = new ServiceList();
        serviceList = svc.leerDOM();
        
        System.out.println(serviceList);*/
        
        menuBasicData();

        /*Conexion_DB conexion_DB = new Conexion_DB();
        System.out.println("Abrir conexión");
        Connection con = conexion_DB.abrirConexion();
        System.out.println("Conexión abierta");
        
        Cliente cliente = pideDatosCliente();
        cliente.insertaClienteBBDD(con);
        System.out.println("Cliente insertado correctamente");        
        
        System.out.println("Cerrar conexion");
        conexion_DB.cerrarConexion(con);
        System.out.println("Conexion cerrada");*/
        
    }
    
    public static BasicData pideDatosBasicData(){
        Scanner teclado = new Scanner(System.in);
        int dni;
        String  language, phone, web;
        BasicData basd = null;
        
        System.out.println("Introduce lenguaje: ");
        language = teclado.nextLine();
        System.out.println("Introduce teléfono: ");
        phone = teclado.nextLine();
        System.out.println("Introduce web: ");
        web = teclado.nextLine();
        
        basd = new BasicData(language, phone, web);
        
        return basd;
    }
    
    public static BasicData pideDatosBasicDataModificacion(int id){
        Scanner teclado = new Scanner(System.in);
        String  language, phone, web;
        BasicData basd = null;
        
        System.out.println("Introduce lenguaje: ");
        language = teclado.nextLine();
        System.out.println("Introduce teléfono: ");
        phone = teclado.nextLine();
        System.out.println("Introduce web: ");
        web = teclado.nextLine();
        
        basd = new BasicData(language, phone, web);
        
        return basd;
    }
    
    public static int pedirId(){
        int dni = 0;
        System.out.println("Introduce el ID del servicio: ");
        try {
            dni = Integer.parseInt(in.next());
        } catch (NumberFormatException e) {
            System.out.println("Debes introducir un número de 8 dígitos");
        }        
        return dni;
    }
    
    public static void menu(){
        System.out.println("\n---------   MENU   ---------");
        System.out.println("\t1. Alta cliente");
        System.out.println("\t2. Baja cliente");
        System.out.println("\t3. Modificación cliente");
        System.out.println("\t4. Listado clientes");
        System.out.println("\t5. Consulta cliente(DNI)");
        System.out.println("\t6. Salir");
        System.out.println("Introduce una opción: ");
    }
    
    public static void menuBasicData() throws ClassNotFoundException, SQLException{
        Conexion_DB conexion_DB = new Conexion_DB();
        System.out.println("Abrir conexión");
        Connection con = conexion_DB.abrirConexion();
               
        BasicData basicData;
        int idBasicData;
        BasicDataDAO basicDataDAO;
        int opc = 0;
        do {
            try {
                menu();
                try {
                    opc = Integer.parseInt(in.nextLine());
                    System.out.println();
                } catch (NumberFormatException err) {
                    System.out.println("\n- - - - - - - - - - - - - - -");
                    System.out.println("Debes introducir un número.");
                    System.out.println("- - - - - - - - - - - - - - -");
                    System.out.println();
                }
                switch (opc) {
                    case 1:
                        basicData = pideDatosBasicData();
                        if (basicData != null) {
                            System.out.println(((basicData.insertaClienteBBDD(con) == 1) 
                                    ? "Cliente dado de alta correctamente" 
                                    : "El cliente no se pudo dar de alta correctamente"));
                        }
                        break;  
                    case 2:
                       idBasicData = pedirId();
                        basicData = new BasicData(idBasicData);
                        if (basicData != null) {
                            System.out.println(((basicData.eliminarClienteBBDD(con) == 1) 
                                    ? "Cliente eliminado correctamente" 
                                    : "El cliente con el DNI ("+idBasicData+") no se encuentra en la base de datos"));
                        }
                        break;
                    case 3:
                        basicData = pideDatosBasicData();
                        if (basicData != null) {
                            System.out.println(((basicData.actualizarClienteBBDD(con) == 1) 
                                    ? "Cliente actualizado correctamente" 
                                    : "El cliente con el DNI ("+basicData.getIdBasicData()+") no se encuentra en la base de datos"));
                        }
                        break;
                    case 4:
                        basicDataDAO = new BasicDataDAO(con);
                        System.out.println(basicDataDAO.recuperaClientes());
                        break;
                    case 5:
                        idBasicData = pedirId();
                        basicDataDAO = new BasicDataDAO(con);
                        basicData = basicDataDAO.buscaBasicDataById(idBasicData);
                        System.out.println(basicData.toString());
                        break;
                    case 6:
                        System.out.println("------------------");
                        System.out.println("¡¡GRACIAS, ADIÓS!!");
                        System.out.println("------------------");
                        break;
                    default:
                        System.out.println("-------------------------------------");
                        System.out.println("Debes introducir una opción del menú.");
                        System.out.println("-------------------------------------");
                        break;
                }
            } catch (Exception e) {
            }
        } while (opc != 6);
        System.out.println("Cerrar conexion");
        conexion_DB.cerrarConexion(con);
        System.out.println("Conexion cerrada");
       
    }
    } 
        
    
    

