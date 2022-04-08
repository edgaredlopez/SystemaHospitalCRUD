
package proyectohospital1;

import com.sun.istack.internal.Pool;
import java.sql.Connection;

public class MetodosBD 
{
    Pool MetodosPool=new Pool() {
       
        public Object take() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void recycle(Object t) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }; 

    
    
    public int Guardar(String Nombre, int Celular,String Direccion, String Fecha,
                      String Doctor, String Sexo, String Peso, String Talla,
                       String Presion, String Pulso, String Temperatura,
                        String Motivo, String Sintomas)
    { 
        int Resultado=0;
        
        Connection Con=null;
        String SSQL="INSERT INTO datospaciente(Nombre,Celular,Direccion,Fecha,Doctor,Sexo,Peso,Talla,Presion,Pulso,Temperatura,Motivo,Sintomas)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,)";
        
        
        
        
        
        return 0;
    }
    
    
}
