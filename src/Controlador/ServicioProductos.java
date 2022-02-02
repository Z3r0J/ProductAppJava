package Controlador;


import Modelo.ClaseProductos;
import Vista.RegistrarProductos;
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
public class ServicioProductos {

    MySQLConexion conexion = new MySQLConexion();
    ResultSet set = null;
    RegistrarProductos reg = new RegistrarProductos();
    public void registroProductos(ClaseProductos productos) {
        try {
            String Query = "insert into Productos values(?,?,?,?,?,?)";
            PreparedStatement estadoSQL = conexion.Conexion().prepareStatement(Query);
            estadoSQL.setInt(1, productos.IdProductos);
            estadoSQL.setString(2, productos.NombreProductos);
            estadoSQL.setString(3, productos.MarcaProductos);
            estadoSQL.setString(4, productos.CategoriaProductos);
            estadoSQL.setInt(5, productos.PrecioProducto);
            estadoSQL.setInt(6, productos.StockProducto);
            int status = estadoSQL.executeUpdate();
            if (status > 0) {
                System.out.println("Insertado Correctamente !!!");
                JOptionPane.showMessageDialog(reg, "El producto fue insertado correctamente", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
        }

    }
    
     public void editarProducto(ClaseProductos productos) {
        try {
            String Query = "update Productos set NombreProductos=?,MarcaProductos=?,CategoriaProductos=?,PrecioProducto=?,StockProducto=? where IdProductos=?";
            PreparedStatement estadoSQL = conexion.Conexion().prepareStatement(Query);
            estadoSQL.setString(1, productos.NombreProductos);
            estadoSQL.setString(2, productos.MarcaProductos);
            estadoSQL.setString(3, productos.CategoriaProductos);
            estadoSQL.setInt(4, productos.PrecioProducto);
            estadoSQL.setInt(5, productos.StockProducto);
            estadoSQL.setInt(6, productos.IdProductos);
            int status = estadoSQL.executeUpdate();
            if (status > 0) {
                System.out.println("Actualizado Correctamente !!!");
                JOptionPane.showMessageDialog(reg, "El producto fue actualizado correctamente", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
        }

    }     
  public boolean eliminarProductos(ClaseProductos productos) {
        try {
            String Query = "delete from Productos where IdProductos=?";
            PreparedStatement state = conexion.Conexion().prepareStatement(Query);
            state.setInt(1, productos.IdProductos);
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
