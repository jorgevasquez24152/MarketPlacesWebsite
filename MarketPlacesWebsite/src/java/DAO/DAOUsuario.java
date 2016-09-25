package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import utilidades.DBUtil;

public class DAOUsuario {

    private Connection conexion;

    public DAOUsuario() {
        conexion = DBUtil.getConexion();
    }

    public void agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIO(ID_USUARIO, NOMBRE, PASSWORD, GENERO, PAIS) VALUES (?, ?, ?, ?, ? )";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, usuario.getIdUsuario());
            preparedStatement.setString(2, usuario.getNombre());
            preparedStatement.setString(3, usuario.getPassword());
            preparedStatement.setString(4, usuario.getGenero());
            preparedStatement.setString(5, usuario.getPais());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
