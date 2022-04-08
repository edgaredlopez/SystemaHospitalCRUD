
package proyectohospital1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuscadorEdgar extends javax.swing.JPanel {

    ///Coneccion con base de datos
    Conexion Enlace = new Conexion();
    Connection Conect=Enlace.Conectar();
    
    public BuscadorEdgar() {
        initComponents();
        MostrarDatosPaciente(0,null);
    }
    public void MostrarDatosPaciente(int OpBuscar,String Valor)
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
        
        String CodSQL;
        
        if(OpBuscar==0&&Valor==null)
        {
            CodSQL="SELECT * FROM datospaciente";
            
        }else
        {
            if(OpBuscar==1 && Valor!=null)
            {
                CodSQL="SELECT * FROM datospaciente WHERE Nombre='"+Valor+"'"; 
            }else
            {
                if(OpBuscar==2 && Valor!=null)
                {
                    CodSQL="SELECT * FROM datospaciente WHERE Celular='"+Valor+"'"; 
                
                }else{
                    CodSQL="SELECT * FROM datospaciente";
                
                }
            }
        }
        
        
        
        String [] Datos= new String[13];
        
        try
        {
          Statement Leer= Conect.createStatement();
          ResultSet Resultado= Leer.executeQuery(CodSQL);
          
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPacientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        ComboOpcion = new javax.swing.JComboBox<>();
        CampoBuscar = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Visualizacion de datos registrados");

        TablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaPacientes);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por\n"));

        ComboOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar todos", "Nombre", "Celular" }));
        ComboOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboOpcionActionPerformed(evt);
            }
        });

        CampoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoBuscarActionPerformed(evt);
            }
        });

        BtnBuscar.setText("Bsucar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CampoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(BtnBuscar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jButton1.setText("Actualizar Datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Buscador de datos de pacientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //MostrarDatosPaciente();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboOpcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboOpcionActionPerformed

    private void CampoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoBuscarActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
       
        int Opcion=ComboOpcion.getSelectedIndex();
        String ValorBus=CampoBuscar.getText();
        MostrarDatosPaciente(Opcion,ValorBus);
        
    }//GEN-LAST:event_BtnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JTextField CampoBuscar;
    private javax.swing.JComboBox<String> ComboOpcion;
    private javax.swing.JTable TablaPacientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
