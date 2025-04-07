/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package logica;

import conexion.ConexionBD;
import java.sql.*;

public class UsuarioDAO {

    public boolean validarUsuario(String usuario, String contraseña) {
        Connection conn = ConexionBD.conectar();
        if (conn != null) {
            try {
                String query = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, usuario);
                ps.setString(2, contraseña);
                ResultSet rs = ps.executeQuery();
                return rs.next(); // true si encontró usuario
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return false;
    }
}
