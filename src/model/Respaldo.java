/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sebas
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
public class Respaldo {
    private static java.sql.Connection con;
    
    public static String driver  = "com.mysql.jdbc.Driver";
    public static String user = "root";
    public static String pass = "";
    public static String url = "jdbc:mysql://localhost:3306/parcial1";
    final String  tabla = "productos";
    public static void Conectar() throws SQLException{
        
        con = null;
        try {

            con =  DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException e) {
            System.out.println("Conexión no exitosa");
        }
    }
    public void guardar(String name,Double precio, int stock) throws SQLException{
        if(con==null){
            Respaldo.Conectar();
        }
        try {
        
        
        
        PreparedStatement guardar;
        Connection conexion = (Connection) con;
        
        guardar = conexion.prepareStatement("INSERT INTO " + this.tabla + 
                "(nombre,precio,stock) VALUES(?,?,?)");
        
        guardar.setString(1, name);
        guardar.setDouble(2, precio);
        guardar.setInt(3, stock);
        
        guardar.executeUpdate();
        
        System.out.println("Escritura exitosa");
        
        
        
        
    } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public ResultSet recuperarDatos() throws SQLException {
        if (con == null) {
            Respaldo.Conectar();
        }
        ResultSet resultado = null;
        try {
        PreparedStatement consulta;
        Connection conexion = (Connection) con;
        consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla);
        resultado = consulta.executeQuery(); 
        
       
        
        } catch (SQLException e) {
            System.out.println(e);
        }
         return resultado;
    }
}
