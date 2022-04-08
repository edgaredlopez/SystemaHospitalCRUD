
package proyectohospital1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModificarEdgar extends javax.swing.JPanel {
    
    ///Coneccion con base de datos
    Conexion Enlace = new Conexion();
    Connection Conect=Enlace.Conectar();
    

    
    public ModificarEdgar() {
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

    
    
    public void ActualizarDatos()
    {
        int Fila=TablaPacientes.getSelectedRow();
        
        //int Id=Integer.parseInt(this.TablaPacientes.getValueAt(Fila,0).toString());
        String Nom=TablaPacientes.getValueAt(Fila,0).toString();
        String Celu=TablaPacientes.getValueAt(Fila,1).toString();
        String Dire=TablaPacientes.getValueAt(Fila,2).toString();
        String Fe=TablaPacientes.getValueAt(Fila,3).toString();
        String Doc=TablaPacientes.getValueAt(Fila,4).toString();
        String Sex=TablaPacientes.getValueAt(Fila,5).toString();
        String Pes=TablaPacientes.getValueAt(Fila,6).toString();
        String Tall=TablaPacientes.getValueAt(Fila,7).toString();
        String Pres=TablaPacientes.getValueAt(Fila,8).toString();
        String Puls=TablaPacientes.getValueAt(Fila,9).toString();
        String Temp=TablaPacientes.getValueAt(Fila,10).toString();
        String Motiv=TablaPacientes.getValueAt(Fila,11).toString();
        String Sint=TablaPacientes.getValueAt(Fila,12).toString();
        
        
        try 
        {
            PreparedStatement actu=Conect.prepareStatement("UPDATE datospaciente SET Nombre='"+Nom+"',Celular='"+Celu+"',Direccion='"+Dire+"',Fecha='"+Fe+"',Doctor='"+Doc+"',Sexo='"+Sex+"',Peso='"+Pes+"',Talla='"+Tall+"',Presion='"+Pres+"',Pulso='"+Puls+"',Temperatura='"+Temp+"',Motivo='"+Motiv+"',Sintomas='"+Sint+"'WHERE Nombre='"+Nom+"'");     
            actu.executeUpdate();
            MostrarDatosPaciente(0,null);//Para que se actualice
            
            
            
        } catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e+ "No se logro actualizar los datos");
        }
        
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        BtnActualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ComboOpcion = new javax.swing.JComboBox<>();
        CampoBuscar = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPacientes = new javax.swing.JTable();

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Modificador de datos");

        BtnActualizar.setText("Actualizar Datos");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

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

        TablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaPacientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnActualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        ActualizarDatos();
    }//GEN-LAST:event_BtnActualizarActionPerformed

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
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JTextField CampoBuscar;
    private javax.swing.JComboBox<String> ComboOpcion;
    private javax.swing.JTable TablaPacientes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
