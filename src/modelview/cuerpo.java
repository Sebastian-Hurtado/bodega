/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.Respaldo;

/**
 *
 * @author Sebas
 */
public class cuerpo extends Producto {
    
    public cuerpo(String name, Double price, int stock) {
        super(name, price, stock);
        
    }

    

    
    
    public Boolean login(String usuario,String contraseña){
        empleado login = new empleado();
        if((usuario.equals(login.getempleado())) && (contraseña.equals(login.getcontraseña()))){
            return true;
        }else{
            return false;
        }
        
    }
    public void guardar() throws SQLException{
        Respaldo db = new Respaldo();
        
        db.guardar(this.name, this.price, this.stock);
        
        
        
    }
    public ResultSet Recuperar() throws SQLException{
        Respaldo db = new Respaldo();
        ResultSet resultado = db.recuperarDatos();
        return resultado;
    }
    
}
