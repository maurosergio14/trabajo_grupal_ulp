/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejo
 */
public class Conexion {

    private String url = "jdbc:mysql://localhost/universidad";
    private String usuario = "root";
    private String password = "";
    public Connection conectar = null;

    public Connection conexion;

    public Conexion() throws ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        try {
            conectar = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/universidad", "root", "");
            System.out.println("conexion exitosa");
        } catch (SQLException ex) {
            System.out.println("error al conectar" + ex.getMessage());
        }
    }

    public Connection getConexion() throws SQLException {
        if (conexion == null) {
            // Setup the connection with the DB
            conexion = DriverManager
                    .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                            + "&user=" + usuario + "&password=" + password);
        }
        return conexion;
    }

    public static ResultSet getTabla(String consulta)  {
        Connection cn=null;//  getConexion();
        Statement st;
        ResultSet datos = null;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return datos;

    }

}


