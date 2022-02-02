package Controlador;


import Modelo.ClaseUsuarios;
import Vista.PantallaPrincipal;
import Vista.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
public class ServicioUsuarios {

    MySQLConexion conexion = new MySQLConexion();
    ResultSet set = null;
    Login login = new Login();

    public void login(ClaseUsuarios usuario) {
        try {
            PreparedStatement estadoSQL = conexion.Conexion().prepareStatement("SELECT * FROM Usuarios where Usuario=? AND Contraseña=?");
            estadoSQL.setString(1, usuario.Usuario);
            estadoSQL.setString(2, usuario.Contraseña);

            set = estadoSQL.executeQuery();
            if (set.next()) {
                System.out.println("Logueado Correctamente");

                usuario.Nombre = set.getString(2);
                usuario.Apellido = set.getString(3);
                JOptionPane.showMessageDialog(login, "Bienvenido " + usuario.Nombre + " " + usuario.Apellido, "Mensaje de bienvenida", JOptionPane.INFORMATION_MESSAGE);
                PantallaPrincipal princ = new PantallaPrincipal();
                princ.LbWelcome.setText("Bienvenido, " + usuario.Nombre + " " + usuario.Apellido);
                princ.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(login, "El usuario no esta registrado y/o su contraseña esta erronea", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(login, "Oops ocurrio un error!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void registroUsuario(ClaseUsuarios usuario) {
        try {
            String Query = "insert into Usuarios values(?,?,?,?,?,?,?)";
            PreparedStatement estadoSQL = conexion.Conexion().prepareStatement(Query);
            estadoSQL.setInt(1, usuario.Id);
            estadoSQL.setString(2, usuario.Nombre);
            estadoSQL.setString(3, usuario.Apellido);
            estadoSQL.setString(4, usuario.Usuario);
            estadoSQL.setString(5, usuario.Contraseña);
            estadoSQL.setString(6, usuario.Telefono);
            estadoSQL.setString(7, usuario.Correo);
            int status = estadoSQL.executeUpdate();
            if (status > 0) {
                System.out.println("Insertado Correctamente !!!");
                JOptionPane.showMessageDialog(login, "El usuario fue insertado correctamente", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
        }

    }
    
     public void editarUsuario(ClaseUsuarios usuario) {
        try {
            String Query = "update Usuarios set Nombre=?,Apellido=?,Usuario=?,Contraseña=?,Telefono=?,Correo=? where Id=?";
            PreparedStatement estadoSQL = conexion.Conexion().prepareStatement(Query);
            estadoSQL.setString(1, usuario.Nombre);
            estadoSQL.setString(2, usuario.Apellido);
            estadoSQL.setString(3, usuario.Usuario);
            estadoSQL.setString(4, usuario.Contraseña);
            estadoSQL.setString(5, usuario.Telefono);
            estadoSQL.setString(6, usuario.Correo);
            estadoSQL.setInt(7, usuario.Id);
            int status = estadoSQL.executeUpdate();
            if (status > 0) {
                System.out.println("Actualizado Correctamente !!!");
                JOptionPane.showMessageDialog(login, "El usuario fue editado correctamente", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
        }

    }
     
  public boolean eliminarUs(ClaseUsuarios usuario) {
        try {
            String Query = "delete from Usuarios where Id=?";
            PreparedStatement state = conexion.Conexion().prepareStatement(Query);
            state.setInt(1, usuario.Id);
            int status = state.executeUpdate();
            if (status > 0) {
                System.out.println("Eliminado Correctamente !!!");
                return true;
            }
            return false;

        } catch (Exception e) {
            return false;
        }

    }
    
    
}
