package com.mycompany.proyectodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author ervargas
 */
public class cls_connectionDB {

    Connection connect = null;
    
    String user = "root";
    String password = "";
    String DB = "proyectoDB";
    String IP = "localhost";
    String port = "3306";
    
    String chain = "jdbc:mysql://" + IP + ":" + port + "/" + DB;

    public Connection connect() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(chain, user, password);
            //JOptionPane.showMessageDialog(null, "Conexion exitosa");

        } catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null, "Error en la conexion" + e.getMessage());

        }

        return connect;
    }
}
