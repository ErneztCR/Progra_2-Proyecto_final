package com.mycompany.proyectodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ervargas
 */
public class cls_admin_user {

    private String name;
    private String lastname;
    private String userId;
    private String username;
    private String password;

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void Create(String tf_name, String tf_lastname, String tf_user_id, String tf_username, String tf_psswrd) {

        PreparedStatement ps;
        ResultSet rs;

        // instanciamos la clase cls_connectionDB
        cls_connectionDB connect = new cls_connectionDB();

        Connection con = null;

        // llamamos al metodo connect
        con = connect.connect();

        try {

            ps = con.prepareStatement(
                    "INSERT INTO tab_users (var_user_name, var_user_lastname, var_user_id, var_username, var_password) values (?, ?, ?, ?, ?)");
            ps.setString(1, tf_name);
            ps.setString(2, tf_lastname);
            ps.setString(3, tf_user_id);
            ps.setString(4, tf_username);
            ps.setString(5, tf_psswrd);

            int res = ps.executeUpdate();

            if (res > 0) {

                JOptionPane.showMessageDialog(null,
                "El usuario ha sido creado exitosamente. Ahora puede acceder utilizando las credenciales que ha proporcionado.");

            } else {

                JOptionPane.showMessageDialog(null, "Error al registrar usuario");

            }

            con.close();

        } catch (Exception e) {

            System.err.println(e);

        }
    }

    // Ajusta el método Read para recibir solo el nombre de usuario como argumento
    public void Read(String tf_username) {
        PreparedStatement ps;
        ResultSet rs;

        cls_connectionDB connect = new cls_connectionDB();
        Connection con = null;

        con = connect.connect();

        try {
            ps = con.prepareStatement("SELECT * FROM tab_users WHERE var_username = ?");
            ps.setString(1, tf_username); // Usar el valor del nombre de usuario

            rs = ps.executeQuery();

            if (rs.next()) {
                // Asignar los valores recuperados a las propiedades correspondientes
                name = rs.getString("var_user_name");
                lastname = rs.getString("var_user_lastname");
                userId = rs.getString("var_user_id");
                username = rs.getString("var_username");
                password = rs.getString("var_password");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el usuario");
            }

            con.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void Update(String tf_name, String tf_lastname, String tf_user_id, String tf_username, String tf_psswrd) {
        PreparedStatement ps;

        cls_connectionDB connect = new cls_connectionDB();
        Connection con = null;

        con = connect.connect();

        try {
            ps = con.prepareStatement(
                    "UPDATE tab_users SET var_user_name = ?, var_user_lastname = ?, var_user_id = ?, var_password = ? WHERE var_username = ?");
            ps.setString(1, tf_name);
            ps.setString(2, tf_lastname);
            ps.setString(3, tf_user_id);
            ps.setString(4, tf_psswrd);
            ps.setString(5, tf_username);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar al usuario");
            }

            con.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void delete(String userId) {
        cls_connectionDB connect = new cls_connectionDB();
        Connection con = null;
    
        con = connect.connect();
    
        try {
            // Crear la consulta SQL para eliminar el usuario
            String query = "DELETE FROM tab_users WHERE var_user_id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, userId);
    
            // Ejecutar la consulta
            int rowsAffected = preparedStatement.executeUpdate();
    
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
            }
    
            // Cerrar la conexión y el PreparedStatement
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean loginUser(String username, String password) {
        boolean isAuthenticated = false;

        try {
            cls_connectionDB connectDB = new cls_connectionDB(); // Crear una instancia de la clase cls_connectionDB
            Connection connection = connectDB.connect(); // Llamar al método connect() de la instancia

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM tab_users WHERE var_username = ? AND var_password = ?"); // Corregir la columna
                                                                                            // var_password
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                isAuthenticated = true;
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isAuthenticated;
    }
}
