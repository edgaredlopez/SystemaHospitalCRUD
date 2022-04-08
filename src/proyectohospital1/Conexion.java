
package proyectohospital1;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;




public class Conexion 
{
    //Variables para evitar espacio abajo
    private String Driver="com.mysql.jdbc.Driver";
    private String CadenaConeccion="jdbc:mysql://127.0.0.1/registrohospital";
    private String usuario="root";
    private String contrasena="";
    public Connection Enlazar;
    
    public Connection Conectar()
    {
        try{
            Class.forName(Driver);
            Enlazar=DriverManager.getConnection(CadenaConeccion,usuario,contrasena);
            //JOptionPane.showMessageDialog(null,"Se ha establecido una coneccion con la BD");
        }catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null,"No se ha podido establecer una coneccion con la BD"+e.getMessage());
        }
        return Enlazar;
    }



}
