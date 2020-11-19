/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author mati
 */
public class Conexion_DB {

    public Connection abrirConexion() throws ClassNotFoundException, SQLException {
        Connection con = null;

        Class.forName("com.mysql.cj.jdbc.Driver");//cargar el driver
        String urlOdbc = "jdbc:mysql://localhost:3306/proyectodb";
        String user = "root";
        String passwd="";
        con = (java.sql.DriverManager.getConnection(urlOdbc, user, passwd));
        return con;
    }

    public void cerrarConexion(Connection con) throws SQLException {
        if (con != null) {
            con.close();
        }
    }

}
