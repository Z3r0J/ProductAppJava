package Controlador;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
public class MySQLConexion {

    public Connection Conexion() {

        String usuario = "randybald";
        String contraseña = "qwertyuiop";
        String servidor = "jdbc:mysql://db4free.net:3306/finaljava";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(servidor, usuario, contraseña);
            System.out.println("Conexion hecha correctamente");
            return con;

        } catch (Exception e) {
            return null;
        }
    }
}
