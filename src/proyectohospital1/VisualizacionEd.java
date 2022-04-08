
package proyectohospital1;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel; 


public class VisualizacionEd extends javax.swing.JPanel {
     ///Coneccion con base de datos
    Conexion Enlace = new Conexion();
    Connection Conect=Enlace.Conectar();

    
    public VisualizacionEd() {
        initComponents();
        MostrarDatosPaciente();
    }
    
    public void MostrarDatosPaciente()
    {
        DefaultTableModel TPaciente= new DefaultTableModel();
        TPaciente.addColumn("Nombre");
        TPaciente.addColumn("Celular");
        TPaciente.addColumn("Direccion");
        TPaciente.addColumn("Fecha");
        TPaciente.addColumn("Doctor");
        TPaciente.addColumn("Sexo");
        TPaciente.addColumn("Peso");
        TPaciente.addColumn("Talla");
        TPaciente.addColumn("Presion");
        TPaciente.addColumn("Pulso");
        TPaciente.addColumn("Temperatura");
        TPaciente.addColumn("Motivo");
        TPaciente.addColumn("Sintomas");
        
        TablaPacientes.setModel(TPaciente);
        
        String [] Datos= new String[13];
        
        try
        {
          Statement Leer= Conect.createStatement();
          ResultSet Resultado= Leer.executeQuery("SELECT * FROM datospaciente");
          
          while(Resultado.next())//Mientras se encuentren valores
          {
              Datos[0]=Resultado.getString(1); //En el array 0 de la fila 1 de la base de datos
              Datos[1]=Resultado.getString(2);
              Datos[2]=Resultado.getString(3);
              Datos[3]=Resultado.getString(4);
              Datos[4]=Resultado.getString(5);
              Datos[5]=Resultado.getString(6);
              Datos[6]=Resultado.getString(7);
              Datos[7]=Resultado.getString(8);
              Datos[8]=Resultado.getString(9);
              Datos[9]=Resultado.getString(10);
              Datos[10]=Resultado.getString(11);
              Datos[11]=Resultado.getString(12);
              Datos[12]=Resultado.getString(13);
              
              TPaciente.addRow(Datos);
          }
          
          TablaPacientes.setModel(TPaciente);
          
        } catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e+"Error en la consulta de BD" );
        }
        
        
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPacientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        TablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaPacientes);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Visualizacion de datos registrados");

        jButton1.setText("Bloquear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaPrincipal Volver = new VentanaPrincipal();
        this.setVisible(false);
        Volver.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPacientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
