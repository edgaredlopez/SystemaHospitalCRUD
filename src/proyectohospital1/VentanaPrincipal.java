
package proyectohospital1;

//Importacion de librearias a usar 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.sql.*;
import javax.swing.JOptionPane;

 
public class VentanaPrincipal extends javax.swing.JFrame 
{
    
    ///Coneccion con base de datos
    Conexion Enlace = new Conexion();
    Connection Conect=Enlace.Conectar() ;
    
    
    VisualizarEd VisEd= new VisualizarEd();
    BuscadorEdgar BusEd=new BuscadorEdgar();
    ModificarEdgar ModEd= new ModificarEdgar();
    
  
    
    
    
  
    VentanaPrincipal()
    {
        //this.setContentPane(Ejemplo);
        setSize(700,650);//Yamano ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Opciones de cierre
        setTitle("Centro hospitalario 'La Paz'");//Titulo
        setLocationRelativeTo(null);//Modo de centrado
        
       
        //Llamar todos los metodos hacia el constructor
       
        PanelMenu();
        BotonReg();
        BotonVisualizar();
        BotonModificar();
        BotonBloquear();
        BotonBuscar();
        Panel();
        PanelLogin();
        TituloMenu();
        InicioSesion();
        LimpiarLogin();
        Menu1();
        Menu2();
        Menu4();
        
        
        
             
            Textos();
        Logo();
        PedirDatos();
        DatosClinicos();
        Registrar();
        Nuevo();
        Menu();
        Cancelar();
        Limpiar();
        Bloquear();
        
    
       
       
   
    }
    
    
    
    
    
   
    
    
   
    
    //Creacion de etiquetas Globales
    
    //Paneles
    private JPanel ObjetoPanel;//Creacion de objeto panel
    private JPanel PanelMenu1;
    private JPanel PanelLogin;
    private JPanel PanelVisualizacion;
            
            
            
    String [] NombreDoctores= {"Seleccionar Doctor","Dr. Berner","Dr. Max","Dr. Andrea"};//Se crea un areglo para almacenar los datos que queremos mostrar
    private String [] ListaGenero= {"Seleccionar sexo","Masculino","Femenino"};//Se crea un areglo para almacenar los datos que queremos mostrar
    private JButton BotonRegistrar;
    private JButton BotonNuevo;
    private JButton BotonCancelar;
    private JButton BotonMenu;
    private JTextField CajaNombre;   
    private JTextField CajaCelular;
    private JTextField CajaDireccion;   
    private JTextField CajaFecha;   
    private JComboBox Lista;
    private JComboBox Desplegable;
    private JTextField CajaPeso;
    private JTextField CajaTalla;
    private JTextField CajaPresion;
    private JTextField CajaPulso;
    private JTextField CajaTemperatura;
    private JTextArea AreaMotivoConsulta;
    private JTextArea AreaEnfermedad;
    private JButton BotonReg1;
    private JButton BotonVisualizar1;
    private JButton BotonMenu1;
    private int RegPulsado=0;
    private JButton BotonModificar;
    private JButton BotonBuscar1;
    private JButton BotonBloquear1;
    private JTextField CajaUsuario;
    private JTextField CajaPassword;
    private JButton BotonIniciar;
    
    
    
    //====================PANELES=====================
    private void Panel()
    {
       
        ObjetoPanel=new ImagenFondo(); //Inicializacion de panel con el constructor
         
        //this.getContentPane().add(ObjetoPanel);//Anadir panel a la ventana
       
        ObjetoPanel.setLayout(null); //Desactivar el diseno por defecto del panel
        //this.setVisible();
        //ObjetoPanel.setOpaque(true);
  
    }
    private void PanelMenu()
    {
       
        PanelMenu1=new FondoMenu(); //Inicializacion de panel con el constructor
         
        //this.getContentPane().add( PanelMenu1);//Anadir panel a la ventana
       
        PanelMenu1.setLayout(null); //Desactivar el diseno por defecto del panel
        
        PanelMenu1.setOpaque(true);
  
    }
    private void PanelLogin()
    {
       
        PanelLogin=new FondoLogin(); //Inicializacion de panel con el constructor
         
        this.getContentPane().add(PanelLogin);//Anadir panel a la ventana
       
        PanelLogin.setLayout(null); //Desactivar el diseno por defecto del panel
        
        PanelLogin.setOpaque(true);
  
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void Textos()
    {
        //TITULO PARTE 1
        JLabel NombreHospital=new JLabel();//Crear objeto para el titulo
        NombreHospital.setOpaque(false);//Desactivar diseno por defecto
        NombreHospital.setText("Ventana de registro");//Mandar texto
        NombreHospital.setFont(new Font("hobo std", 2,23));//Estilo, tipo y tamano
        NombreHospital.setBounds(180,7, 300, 35); //Ubicacion y tamano de etiqueta
        NombreHospital.setHorizontalAlignment(SwingConstants.CENTER); //CENTRAR PERFECTAMENTE EL TEXTO
       
        NombreHospital.setForeground(Color.BLACK);//Color texto
        
        ObjetoPanel.add(NombreHospital);//Agregar a panel
        
        //TIULO PARTE 2
        JLabel NombreHospital2=new JLabel();//Crear objeto para el titulo
        NombreHospital2.setOpaque(false);//Desactivar diseno por defecto
        NombreHospital2.setText("de pacientes.");//Mandar texto
        NombreHospital2.setFont(new Font("hobo std", 2,25));//Estilo, tipo y tamano
        NombreHospital2.setBounds(180,30, 300, 40); //Ubicacion y tamano de etiqueta
        NombreHospital2.setHorizontalAlignment(SwingConstants.CENTER); //CENTRAR PERFECTAMENTE EL TEXTO
        
        NombreHospital.setForeground(Color.BLACK);//Color texto
        
        ObjetoPanel.add(NombreHospital2);//Agregar a panel
        
    }
    
    
    
    
    private void Logo()
    {
        ImageIcon ObjetoLogo; //Creacion de objeto
        ObjetoLogo=new ImageIcon("LaPaz6.png");//Inicializacion con insercion de imagen
        
        //Etiqueta para la imagen
        JLabel EtiquetaLogo; //Creacion objeto
        EtiquetaLogo=new JLabel(); ///Inicializacion
        EtiquetaLogo.setBounds(480, 8, 210, 75); //Ubicacion y tamano
        
        //Sincronizar tamano de etiqueta con el tamano de la imagen
        EtiquetaLogo.setIcon(new ImageIcon(ObjetoLogo.getImage().getScaledInstance(EtiquetaLogo.getWidth(), EtiquetaLogo.getHeight(), Image.SCALE_SMOOTH)));
        
        
        //Agregar la etiqueta del logo al panel
        ObjetoPanel.add(EtiquetaLogo);
        
        
        PanelLogin.add(EtiquetaLogo);
    
    }
    
    
    private void PedirDatos()
    {
         //Nombre Completo
        JLabel NombreCompleto=new JLabel();//Crear objeto para el titulo
        NombreCompleto.setOpaque(false);//Desactivar diseno por defecto
        NombreCompleto.setText("Nombre completo: ");//Mandar texto
        NombreCompleto.setFont(new Font("arial", 1,12));//Estilo, tipo y tamano
        NombreCompleto.setBounds(20,100, 300, 50); //Ubicacion y tamano de etiqueta
        NombreCompleto.setForeground(Color.BLACK);//Color texto
        ObjetoPanel.add(NombreCompleto);//Agregar a panel
        //Caja de texto
        CajaNombre =new JTextField();//Arriba se creo el objeto de tipo JTextField, aqui solo se inicializa con el constructor JTextFiel
        CajaNombre.setBounds(130, 115, 200, 20); //Definicion del tamaño y ubicacion de la cajita de texto
       
        ObjetoPanel.add(CajaNombre); //Mandando la caja de texto al panel
        
        
        
        //No telefono
        JLabel Celular=new JLabel();//Crear objeto para el titulo
        Celular.setOpaque(false);//Desactivar diseno por defecto
        Celular.setText("No. Celular: ");//Mandar texto
        Celular.setFont(new Font("arial", 1,12));//Estilo, tipo y tamano
        Celular.setBounds(350,100, 300, 50); //Ubicacion y tamano de etiqueta
        Celular.setForeground(Color.BLACK);//Color texto
        ObjetoPanel.add(Celular);//Agregar a panel
        //Caja de texto
        CajaCelular =new JTextField();//Arriba se creo el objeto de tipo JTextField, aqui solo se inicializa con el constructor JTextFiel
        CajaCelular.setBounds(425, 115, 100, 20); //Definicion del tamaño y ubicacion de la cajita de texto
        
        ObjetoPanel.add(CajaCelular); //Mandando la caja de texto al panel
        
        //Direccion
        JLabel Direccion=new JLabel();//Crear objeto para el titulo
        Direccion.setOpaque(false);//Desactivar diseno por defecto
        Direccion.setText("Dirección: ");//Mandar texto
        Direccion.setFont(new Font("arial", 1,12));//Estilo, tipo y tamano
        Direccion.setBounds(20,145, 300, 40); //Ubicacion y tamano de etiqueta
        Direccion.setForeground(Color.BLACK);//Color texto
        ObjetoPanel.add(Direccion);//Agregar a panel
        //Caja de texto
        CajaDireccion =new JTextField();//Arriba se creo el objeto de tipo JTextField, aqui solo se inicializa con el constructor JTextFiel
        CajaDireccion.setBounds(90, 156, 200, 20); //Definicion del tamaño y ubicacion de la cajita de texto
        
        ObjetoPanel.add(CajaDireccion); //Mandando la caja de texto al panel
        
        
        //Fecha
        JLabel Fecha=new JLabel();//Crear objeto para el titulo
        Fecha.setOpaque(false);//Desactivar diseno por defecto
        Fecha.setText("Fecha: ");//Mandar texto
        Fecha.setFont(new Font("arial", 1,12));//Estilo, tipo y tamano
        Fecha.setBounds(350,140, 300, 50); //Ubicacion y tamano de etiqueta
        Fecha.setForeground(Color.BLACK);//Color texto
        ObjetoPanel.add(Fecha);//Agregar a panel
        //Caja de texto
        CajaFecha =new JTextField();//Arriba se creo el objeto de tipo JTextField, aqui solo se inicializa con el constructor JTextFiel
        CajaFecha.setBounds(425, 156, 100, 20); //Definicion del tamaño y ubicacion de la cajita de texto
        
        ObjetoPanel.add(CajaFecha); //Mandando la caja de texto al panel
        
        
        //Doctor Solicitado
        JLabel DoctorSolicitado=new JLabel();//Crear objeto para el titulo
        DoctorSolicitado.setOpaque(false);//Desactivar diseno por defecto
        DoctorSolicitado.setText("Doctor solicitado: ");//Mandar texto
        DoctorSolicitado.setFont(new Font("arial", 1,12));//Estilo, tipo y tamano
        DoctorSolicitado.setBounds(20,180, 110, 50); //Ubicacion y tamano de etiqueta
        DoctorSolicitado.setForeground(Color.BLACK);//Color texto
        ObjetoPanel.add(DoctorSolicitado);//Agregar a panel
        
        
        
        Lista =new JComboBox(NombreDoctores); //Creacion  de un OBJETO de la lista desplegable
        Lista.setBounds(130, 192, 137, 25); //Definicion de tamaño de la lista
       
        Lista.setSelectedItem("Seleccionar Doctor"); //Para indicar que es lo que mostrara al inicio la lista
        //Agregamos la lista desplegable al panel
        ObjetoPanel.add(Lista);  
        
        
        
        //Hora aproximada de atencion
        int Horario=8;
        JLabel HoraAtencion=new JLabel();//Crear objeto para el titulo
        HoraAtencion.setOpaque(false);//Desactivar diseno por defecto
        HoraAtencion.setText("Hora aprox.  de atención:   "+Horario+" AM");//Mandar texto
        HoraAtencion.setFont(new Font("arial", 1,12));//Estilo, tipo y tamano
        HoraAtencion.setBounds(475,180, 300, 50); //Ubicacion y tamano de etiqueta
        HoraAtencion.setForeground(Color.BLACK);//Color texto
        ObjetoPanel.add(HoraAtencion);//Agregar a panel
        
        
        
        //SExo
        JLabel ObjetoSexo=new JLabel();//Crear objeto para el titulo
        ObjetoSexo.setOpaque(false);//Desactivar diseno por defecto
        ObjetoSexo.setText("Sexo: ");//Mandar texto
        ObjetoSexo.setFont(new Font("arial", 1,12));//Estilo, tipo y tamano
        ObjetoSexo.setBounds(285,180, 40, 50); //Ubicacion y tamano de etiqueta
        ObjetoSexo.setForeground(Color.BLACK);//Color texto
        ObjetoPanel.add(ObjetoSexo);//Agregar a panel
        
        
        Desplegable =new JComboBox(ListaGenero); //Creacion  de un OBJETO de la lista desplegable
        Desplegable.setBounds(325, 195, 137, 25); //Definicion de tamaño de la lista
        Desplegable.setSelectedItem("Seleccionar sexo"); //Para indicar que es lo que mostrara al inicio la lista
        //Agregamos la lista desplegable al panel
        ObjetoPanel.add(Desplegable);
        
        //Creado por 
        JLabel CreadoPor=new JLabel(); //Creacion e inicializacion del objeto de texto
        
        CreadoPor.setOpaque(false); //Desactivar el diseno por defecto
        CreadoPor.setText("Programa creado por: Edgar López Laynez"); //Mandar texto
        CreadoPor.setBounds(235,582,1000,18); //Ubicacion y tamano de marco
        CreadoPor.setFont(new Font("Arial", 1, 12));  //Tipo, estilo y tamano de letra
        CreadoPor.setForeground(Color.blue);//Color de texto
        
       //Anadir etiqueta de texto al panel
        ObjetoPanel.add(CreadoPor);
        
   
       
    }
    
    
    private void DatosClinicos()
    {
       //NSeparador
        JLabel Separador=new JLabel();//Crear objeto para el titulo
        Separador.setText("_________________________________________________________________________________________________");//Mandar text
        Separador.setOpaque(false);
        Separador.setBounds(10,220, 1000, 50); //Ubicacion y tamano de etiqueta
        ObjetoPanel.add(Separador);//Agregar a panel 
        
        
        //PESO
        JLabel ObjetoPeso=new JLabel();//Crear objeto para el titulo
        ObjetoPeso.setOpaque(false);//Desactivar diseno por defecto
        ObjetoPeso.setText("Peso: ");//Mandar texto
        ObjetoPeso.setFont(new Font("arial", 1,12));//Estilo, tipo y tamano
        ObjetoPeso.setBounds(20,250, 40, 50); //Ubicacion y tamano de etiqueta
        ObjetoPeso.setForeground(Color.BLACK);//Color texto
        ObjetoPanel.add(ObjetoPeso);//Agregar a panel
        //Caja de texto
        CajaPeso =new JTextField();//Arriba se creo el objeto de tipo JTextField, aqui solo se inicializa con el constructor JTextFiel
        CajaPeso.setBounds(60, 267, 55, 20); //Definicion del tamaño y ubicacion de la cajita de texto
        ObjetoPanel.add(CajaPeso); //Mandando la caja de texto al panel
        
        
        
        //talla
        JLabel ObjetoTalla=new JLabel();//Crear objeto para el titulo
        ObjetoTalla.setOpaque(false);//Desactivar diseno por defecto
        ObjetoTalla.setText("Talla: ");//Mandar texto
        ObjetoTalla.setFont(new Font("arial", 1,12));//Estilo, tipo y tamano
        ObjetoTalla.setBounds(128,250, 40, 50); //Ubicacion y tamano de etiqueta
        ObjetoTalla.setForeground(Color.BLACK);//Color texto
        ObjetoPanel.add(ObjetoTalla);//Agregar a panel
        //Caja de texto
        CajaTalla =new JTextField();//Arriba se creo el objeto de tipo JTextField, aqui solo se inicializa con el constructor JTextFiel
        CajaTalla.setBounds(163, 267, 70, 20); //Definicion del tamaño y ubicacion de la cajita de texto
        ObjetoPanel.add(CajaTalla); //Mandando la caja de texto al panel
        
        //Presion ARTERIAL
        JLabel ObjetoPresion=new JLabel();//Crear objeto para el titulo
        ObjetoPresion.setOpaque(false);//Desactivar diseno por defecto
        ObjetoPresion.setText("Presión arterial: ");//Mandar texto
        ObjetoPresion.setFont(new Font("arial", 1,12));//Estilo, tipo y tamano
        ObjetoPresion.setBounds(250,250, 100, 50); //Ubicacion y tamano de etiqueta
        ObjetoPresion.setForeground(Color.BLACK);//Color texto
        ObjetoPanel.add(ObjetoPresion);//Agregar a panel
        //Caja de texto
        CajaPresion =new JTextField();//Arriba se creo el objeto de tipo JTextField, aqui solo se inicializa con el constructor JTextFiel
        CajaPresion.setBounds(345, 267, 60, 20); //Definicion del tamaño y ubicacion de la cajita de texto
        ObjetoPanel.add(CajaPresion); //Mandando la caja de texto al panel
        
        
        //Pulso
        JLabel ObjetoEdad=new JLabel();//Crear objeto para el titulo
        ObjetoEdad.setOpaque(false);//Desactivar diseno por defecto
        ObjetoEdad.setText("Pulso: ");//Mandar texto
        ObjetoEdad.setFont(new Font("arial", 1,12));//Estilo, tipo y tamano
        ObjetoEdad.setBounds(425,250, 60, 50); //Ubicacion y tamano de etiqueta
        ObjetoEdad.setForeground(Color.BLACK);//Color texto
        ObjetoPanel.add(ObjetoEdad);//Agregar a panel
        //Caja de texto
        CajaPulso =new JTextField();//Arriba se creo el objeto de tipo JTextField, aqui solo se inicializa con el constructor JTextFiel
        CajaPulso.setBounds(465, 267, 50, 20); //Definicion del tamaño y ubicacion de la cajita de texto
        ObjetoPanel.add(CajaPulso); //Mandando la caja de texto al panel
        
        //Temperatura
        JLabel ObjetoTemperatura=new JLabel();//Crear objeto para el titulo
        ObjetoTemperatura.setOpaque(false);//Desactivar diseno por defecto
        ObjetoTemperatura.setText("Temperatura: ");//Mandar texto
        ObjetoTemperatura.setFont(new Font("arial", 1,12));//Estilo, tipo y tamano
        ObjetoTemperatura.setBounds(525,250, 90, 50); //Ubicacion y tamano de etiqueta
        ObjetoTemperatura.setForeground(Color.BLACK);//Color texto
        ObjetoPanel.add(ObjetoTemperatura);//Agregar a panel
        //Caja de texto
        CajaTemperatura =new JTextField();//Arriba se creo el objeto de tipo JTextField, aqui solo se inicializa con el constructor JTextFiel
        CajaTemperatura.setBounds(615, 267, 35, 20); //Definicion del tamaño y ubicacion de la cajita de texto
        ObjetoPanel.add(CajaTemperatura); //Mandando la caja de texto al panel
        
        
        
        //Motivo de consulta
        JLabel TituloMotivo=new JLabel();//Crear objeto para el titulo
        TituloMotivo.setOpaque(false);//Desactivar diseno por defecto
        TituloMotivo.setText("Motivo de consulta: ");//Mandar texto
        TituloMotivo.setFont(new Font("arial", 1,12));//Estilo, tipo y tamano
        TituloMotivo.setBounds(120,300, 160, 30); //Ubicacion y tamano de etiqueta
        TituloMotivo.setForeground(Color.BLACK);//Color texto
        ObjetoPanel.add(TituloMotivo);//Agregar a panel
        
        AreaMotivoConsulta=new JTextArea(); //Se creo el objeto arriba, aqui solo se instancia para agregar el metodo JTextAre   
        AreaMotivoConsulta.setBounds(30, 330, 300, 100); //Tamaño del area de texto
        AreaMotivoConsulta.setEditable(true); //Para activar o desactivar el editado de texto
        ObjetoPanel.add(AreaMotivoConsulta); //Poner AREAA de texto en el panel
        
        
        
        //Enfermedad actual
        JLabel TituloEnfermedad=new JLabel();//Crear objeto para el titulo
        TituloEnfermedad.setOpaque(false);//Desactivar diseno por defecto
        TituloEnfermedad.setText("Sintomas o enfermedad actual: ");//Mandar texto
        TituloEnfermedad.setFont(new Font("arial", 1,12));//Estilo, tipo y tamano
        TituloEnfermedad.setBounds(410,300, 190, 30); //Ubicacion y tamano de etiqueta
        TituloEnfermedad.setForeground(Color.BLACK);//Color texto
        ObjetoPanel.add(TituloEnfermedad);//Agregar a panel
        
        AreaEnfermedad=new JTextArea(); //Se creo el objeto arriba, aqui solo se instancia para agregar el metodo JTextAre   
        AreaEnfermedad.setBounds(350, 330, 300, 100); //Tamaño del area de texto
        AreaEnfermedad.setEditable(true); //Para activar o desactivar el editado de texto
        AreaEnfermedad.setMargin( new Insets(10,10,10,10) );
        
        ObjetoPanel.add(AreaEnfermedad); //Poner AREAA de texto en el panel
   
        
        
        
    }

    
    //Botones
    private void Registrar()
    {
    //Boton para registrar
         BotonRegistrar=new JButton(); //Arriba se creo el Objeto Boton2, aqui solo se inicializa agregandole el constructor de JButton
        BotonRegistrar.setBounds(250, 430, 200, 80); //Tamano de botn
        ImageIcon ImagenBoton;//Creacion de Objto de tipo imagen
        ImagenBoton=new ImageIcon("Registrar.png"); //Inicializando el objeto agregandole el constructor de ImageIcon y mandandole como aprametro una imagen
        //Poner imagen en el boton con el tamano del boton
        BotonRegistrar./*Mandar ICON*/setIcon(/*CrearObjetoPara traer*/new ImageIcon(/*USar objeto para traer imagen*/ImagenBoton.getImage()./*Tamano->*/getScaledInstance(BotonRegistrar.getWidth(), BotonRegistrar.getHeight(),Image.SCALE_SMOOTH )));
        BotonRegistrar.setBorder(null); //Eliminar borde de boto 
        //Poner fondo transparente al boton
        BotonRegistrar.setOpaque(false);
        BotonRegistrar.setBackground(new Color(0,0,0,0));   
        //Agregar boton al panel
        ObjetoPanel.add(BotonRegistrar); 
        
        
        
        
         ActionListener OyenteAccion1=new ActionListener() //Creacion e inicializacion  de objeto actionlistener. oyente de accion
        {
            //Metodo del oyente de accion para poner lo que queremos hacer al presionar el boton
            public void actionPerformed(ActionEvent e) 
            {
                
                try
                {
                    PreparedStatement Guardar= Conect.prepareStatement("INSERT INTO datospaciente (Nombre,Celular,Direccion,Fecha,Doctor,Sexo,Peso,Talla,Presion,Pulso,Temperatura,Motivo,Sintomas)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    
                    Guardar.setString(1, CajaNombre.getText());
                    Guardar.setString(2, CajaCelular.getText());
                    Guardar.setString(3, CajaDireccion.getText());
                    Guardar.setString(4, CajaFecha.getText());
                    Guardar.setString(5, Lista.getSelectedItem().toString());
                    Guardar.setString(6, Desplegable.getSelectedItem().toString());
                    Guardar.setString(7, CajaPeso.getText());
                    Guardar.setString(8, CajaTalla.getText());
                    Guardar.setString(9, CajaPresion.getText());
                    Guardar.setString(10, CajaPulso.getText());
                    Guardar.setString(11, CajaTemperatura.getText());
                    Guardar.setString(12, AreaMotivoConsulta.getText());
                    Guardar.setString(13, AreaEnfermedad.getText());
                    
                    Guardar.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Datos de paciente registrados EXITOSAMENTE" );
                    
                } catch (Exception a) 
                {
                    JOptionPane.showMessageDialog(null, "No se ingresaron 'todos' los datos para registrarlos. Intentelo nuevamente");;
                }
                Limpiar();
                Bloquear();
            }
        };    
        
        BotonRegistrar.addActionListener(OyenteAccion1); //Agregamos la etiqueta al panel
        
        
        
        
    
    }
    
    private void Menu()
    {
    //Boton para registrar
        BotonMenu=new JButton(); //Arriba se creo el Objeto Boton2, aqui solo se inicializa agregandole el constructor de JButton
        BotonMenu.setBounds(50, 515, 100, 40); //Tamano de botn
        ImageIcon ImagenBoton;//Creacion de Objto de tipo imagen
        ImagenBoton=new ImageIcon("Menu.png"); //Inicializando el objeto agregandole el constructor de ImageIcon y mandandole como aprametro una imagen
        //Poner imagen en el boton con el tamano del boton
        BotonMenu./*Mandar ICON*/setIcon(/*CrearObjetoPara traer*/new ImageIcon(/*USar objeto para traer imagen*/ImagenBoton.getImage()./*Tamano->*/getScaledInstance(BotonMenu.getWidth(), BotonMenu.getHeight(),Image.SCALE_SMOOTH )));
        BotonMenu.setBorder(null); //Eliminar borde de boto 
        //Poner fondo transparente al boton
        BotonMenu.setOpaque(false);
        BotonMenu.setBackground(new Color(0,0,0,0));   
        //Agregar boton al panel
        ObjetoPanel.add(BotonMenu); 
        //VisEd.add(BotonMenu);
        
        
        
         ActionListener OyenteAccion=new ActionListener() //Creacion e inicializacion  de objeto actionlistener. oyente de accion
        {
            //Metodo del oyente de accion para poner lo que queremos hacer al presionar el boton
            public void actionPerformed(ActionEvent e) 
            {
               
                add(PanelMenu1);
                PanelMenu1.setVisible(true);
                ObjetoPanel.setVisible(false);
                //PanelMenu1.setVisible(false);
                //RegPulsado=1;
            }
        }; 
         BotonMenu.addActionListener(OyenteAccion); //Agregamos la etiqueta al panel
    
    }
    
    private void Nuevo()
    {
    //Boton para registrar
        BotonNuevo=new JButton(); //Arriba se creo el Objeto Boton2, aqui solo se inicializa agregandole el constructor de JButton
        BotonNuevo.setBounds(300, 515, 100, 40); //Tamano de botn
        ImageIcon ImagenBoton;//Creacion de Objto de tipo imagen
        ImagenBoton=new ImageIcon("Nuevo.png"); //Inicializando el objeto agregandole el constructor de ImageIcon y mandandole como aprametro una imagen
        //Poner imagen en el boton con el tamano del boton
        BotonNuevo./*Mandar ICON*/setIcon(/*CrearObjetoPara traer*/new ImageIcon(/*USar objeto para traer imagen*/ImagenBoton.getImage()./*Tamano->*/getScaledInstance(BotonNuevo.getWidth(), BotonNuevo.getHeight(),Image.SCALE_SMOOTH )));
        BotonNuevo.setBorder(null); //Eliminar borde de boto 
        //Poner fondo transparente al boton
        BotonNuevo.setOpaque(false);
        BotonNuevo.setBackground(new Color(0,0,0,0));   
        //Agregar boton al panel
        ObjetoPanel.add(BotonNuevo); 
        
        
        ActionListener OyenteAccion=new ActionListener() //Creacion e inicializacion  de objeto actionlistener. oyente de accion
        {
            //Metodo del oyente de accion para poner lo que queremos hacer al presionar el boton
            public void actionPerformed(ActionEvent e) 
            {
                //LO que queremos mostrar
                Desbloquear();
                
            }
        };    
        
        BotonNuevo.addActionListener(OyenteAccion); //Agregamos la etiqueta al panel
        
        
    
    
    }
    
    private void Cancelar()
    {
    //Boton para registrar
        BotonCancelar=new JButton(); //Arriba se creo el Objeto Boton2, aqui solo se inicializa agregandole el constructor de JButton
        BotonCancelar.setBounds(500, 515, 100, 40); //Tamano de botn
        ImageIcon ImagenBoton;//Creacion de Objto de tipo imagen
        ImagenBoton=new ImageIcon("Cancelar.png"); //Inicializando el objeto agregandole el constructor de ImageIcon y mandandole como aprametro una imagen
        //Poner imagen en el boton con el tamano del boton
        BotonCancelar./*Mandar ICON*/setIcon(/*CrearObjetoPara traer*/new ImageIcon(/*USar objeto para traer imagen*/ImagenBoton.getImage()./*Tamano->*/getScaledInstance(BotonCancelar.getWidth(), BotonCancelar.getHeight(),Image.SCALE_SMOOTH )));
        BotonCancelar.setBorder(null); //Eliminar borde de boto 
        //Poner fondo transparente al boton
        BotonCancelar.setOpaque(false);
        BotonCancelar.setBackground(new Color(0,0,0,0));   
        //Agregar boton al panel
        ObjetoPanel.add(BotonCancelar); 
        
        ActionListener OyenteAccion=new ActionListener() //Creacion e inicializacion  de objeto actionlistener. oyente de accion
        {
            //Metodo del oyente de accion para poner lo que queremos hacer al presionar el boton
            public void actionPerformed(ActionEvent e) 
            {
                //LO que queremos mostrar
                Limpiar();
                Bloquear();
                
            }
        };    
        
        BotonCancelar.addActionListener(OyenteAccion); //Agregamos la etiqueta al panel
    
    }

    
    //Acciones en metodos
    private void Limpiar()
    {
   
    CajaNombre.setText(""); 
    CajaCelular.setText(""); 
    CajaDireccion.setText("");   
    CajaFecha.setText("");  
    CajaPeso.setText(""); 
    CajaTalla.setText(""); 
    CajaPresion.setText(""); 
    CajaPulso.setText("");
        
    CajaTemperatura.setText("");

    AreaMotivoConsulta.setText("");

    AreaEnfermedad.setText(""); 

    //Doctor
    Lista.setSelectedItem("Seleccionar Doctor"); //Para indicar que es lo que mostrara al inicio la lista
    //Sexo
    Desplegable.setSelectedItem("Seleccionar sexo"); //Para indicar que es lo que mostrara al inicio la lista
    }
    
    private void LimpiarLogin()
    {
    
    CajaUsuario.setText(""); 
    CajaPassword.setText(""); 
    
    }
    
    private void Bloquear()
    {
    
    CajaNombre.setEnabled(false); 
    CajaCelular.setEnabled(false);
    CajaDireccion.setEnabled(false);
    CajaFecha.setEnabled(false);
    CajaPeso.setEnabled(false);
    CajaTalla.setEnabled(false);
    CajaPresion.setEnabled(false);
    CajaPulso.setEnabled(false);
    CajaTemperatura.setEnabled(false);
    AreaMotivoConsulta.setEnabled(false);
    AreaEnfermedad.setEnabled(false);
    //Doctor
    Lista.setEnabled(false); //Desactivar desplegable
    //Sexo
    Desplegable.setEnabled(false); //Desactivar desplegable
    BotonRegistrar.setEnabled(false);//Desactivamos el boton registrar
    
    
    }
    
    private void Desbloquear()
    {
    
    CajaNombre.setEnabled(true); 
    CajaCelular.setEnabled(true);
    CajaDireccion.setEnabled(true);
    CajaFecha.setEnabled(true);
    CajaPeso.setEnabled(true);
    CajaTalla.setEnabled(true);
    CajaPresion.setEnabled(true);
    CajaPulso.setEnabled(true);
    CajaTemperatura.setEnabled(true);
    AreaMotivoConsulta.setEnabled(true);
    AreaEnfermedad.setEnabled(true);
    //Doctor
    Lista.setEnabled(true); //Desactivar desplegable
    //Sexo
    Desplegable.setEnabled(true); //Desactivar desplegable
    BotonRegistrar.setEnabled(true);//Activamos el boton registrar
    
    
    }
    
    
    
    
    
    

      
    
    
    
    //Clase para importar imagen de fondo de ventana
    class ImagenFondo extends JPanel
    {
        private Image Imagen;
        @Override
        public void paint(Graphics g)
        {
                Imagen=new ImageIcon(getClass().getResource("/Imagenes/Fondo8.jpg")).getImage();
                g.drawImage(Imagen, 0, 0, getWidth(), getHeight(), this);
                setOpaque(false);
                super.paint(g);
          
                 
        }
    
    }
    
    //Clase para importar imagen de fondo de ventana
    class FondoMenu extends JPanel
    {
        private Image Imagen;
        @Override
        public void paint(Graphics g)
        {
                Imagen=new ImageIcon(getClass().getResource("/Imagenes/Fondo5.jpg")).getImage();
                g.drawImage(Imagen, 0, 0, getWidth(), getHeight(), this);
                setOpaque(false);
                super.paint(g);
          
                 
        }
    
    }
    
    
    //Clase para importar imagen de fondo de ventana
    class FondoLogin extends JPanel
    {
        private Image Imagen;
        @Override
        public void paint(Graphics g)
        {
                Imagen=new ImageIcon(getClass().getResource("/Imagenes/FondoLogin.jpg")).getImage();
                g.drawImage(Imagen, 0, 0, getWidth(), getHeight(), this);
                setOpaque(false);
                super.paint(g);
          
                 
        }
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Contenido para el menu
    
    
    
    
    
    
    
    
    
    private void TituloMenu()
    {
        //TITULO PARTE 1
        JLabel MenuTitle=new JLabel();//Crear objeto para el titulo
        MenuTitle.setOpaque(false);//Desactivar diseno por defecto
        MenuTitle.setText("Menu Principal");//Mandar texto
        MenuTitle.setFont(new Font("hobo std", 2,35));//Estilo, tipo y tamano
        MenuTitle.setBounds(180,25, 300, 35); //Ubicacion y tamano de etiqueta
        MenuTitle.setHorizontalAlignment(SwingConstants.CENTER); //CENTRAR PERFECTAMENTE EL TEXTO
       
        MenuTitle.setForeground(Color.black);//Color texto
        
        PanelMenu1.add(MenuTitle);//Agregar a panel
        
       
        
    }
    
    
    
    
    
    
    
    
    
    
    
    private void BotonReg()
    {
    //Boton para registrar
        BotonReg1=new JButton(); //Arriba se creo el Objeto Boton2, aqui solo se inicializa agregandole el constructor de JButton
        BotonReg1.setBounds(240, 100, 200, 90); //Tamano de botn
        //BotonReg1.setLocation(300, 300);
     
        ImageIcon ImagenBoton;//Creacion de Objto de tipo imagen
        ImagenBoton=new ImageIcon("VentanaRegistrar.png"); //Inicializando el objeto agregandole el constructor de ImageIcon y mandandole como aprametro una imagen
        //Poner imagen en el boton con el tamano del boton
        BotonReg1./*Mandar ICON*/setIcon(/*CrearObjetoPara traer*/new ImageIcon(/*USar objeto para traer imagen*/ImagenBoton.getImage()./*Tamano->*/getScaledInstance(BotonReg1.getWidth(), BotonReg1.getHeight(),Image.SCALE_SMOOTH )));
        BotonReg1.setBorder(null); //Eliminar borde de boto 
        //Poner fondo transparente al boton
        BotonReg1.setOpaque(false);
        BotonReg1.setBackground(new Color(0,0,0,0));   
        //Agregar boton al panel
        PanelMenu1.add(BotonReg1); 
        
        
        ActionListener OyenteAccion=new ActionListener() //Creacion e inicializacion  de objeto actionlistener. oyente de accion
        {
            //Metodo del oyente de accion para poner lo que queremos hacer al presionar el boton
            public void actionPerformed(ActionEvent e) 
            {
               
                add(ObjetoPanel);
                ObjetoPanel.setVisible(true);
                PanelMenu1.setVisible(false);
                RegPulsado=1;
            }
        };    
        
        BotonReg1.addActionListener(OyenteAccion); //Agregamos la etiqueta al panel

    }
    
    
    
    
    
    
    
    private void BotonVisualizar()
    {
        
    //Boton para registrar
        BotonVisualizar1=new JButton(); //Arriba se creo el Objeto Boton2, aqui solo se inicializa agregandole el constructor de JButton
        BotonVisualizar1.setBounds(240, 200, 200, 90); //Tamano de botn
        //BotonReg1.setLocation(300, 300);
     
        ImageIcon ImagenBoton;//Creacion de Objto de tipo imagen
        ImagenBoton=new ImageIcon("Visualizar.png"); //Inicializando el objeto agregandole el constructor de ImageIcon y mandandole como aprametro una imagen
        //Poner imagen en el boton con el tamano del boton
        BotonVisualizar1./*Mandar ICON*/setIcon(/*CrearObjetoPara traer*/new ImageIcon(/*USar objeto para traer imagen*/ImagenBoton.getImage()./*Tamano->*/getScaledInstance(BotonVisualizar1.getWidth(), BotonVisualizar1.getHeight(),Image.SCALE_SMOOTH )));
        BotonVisualizar1.setBorder(null); //Eliminar borde de boto 
        //Poner fondo transparente al boton
        BotonVisualizar1.setOpaque(false);
        BotonVisualizar1.setBackground(new Color(0,0,0,0));   
        //Agregar boton al panel
        PanelMenu1.add(BotonVisualizar1); 
        
        
        ActionListener OyenteAccion=new ActionListener() //Creacion e inicializacion  de objeto actionlistener. oyente de accion
        {
            //Metodo del oyente de accion para poner lo que queremos hacer al presionar el boton
            public void actionPerformed(ActionEvent e) 
            {
                PanelMenu1.setVisible(false);
                
                add(VisEd);
                VisEd.setVisible(true);
                
                /*Login Log=new Login();
               
                add(Log);
                Log.setVisible(true);
                */
                
                
            //Log.setSize(700,650);
            //Log.setLocation(0, 0);
            /*Log.setBounds(0, 0, 700, 650);
        
        ObjetoPanel.removeAlrootrl();
        add(Log,BorderLayout.CENTER);
        ObjetoPanel.revalidate();
        ObjetoPanel.repaint();*/
        
            }
        };    
        
        BotonVisualizar1.addActionListener(OyenteAccion); //Agregamos la etiqueta al panel
    

    }
    
    
    private void BotonModificar()
    {
        
    //Boton para registrar
        BotonModificar=new JButton(); //Arriba se creo el Objeto Boton2, aqui solo se inicializa agregandole el constructor de JButton
        BotonModificar.setBounds(240, 300, 200, 90); //Tamano de botn
        //BotonReg1.setLocation(300, 300);
     
        ImageIcon ImagenBoton;//Creacion de Objto de tipo imagen
        ImagenBoton=new ImageIcon("Modificar.png"); //Inicializando el objeto agregandole el constructor de ImageIcon y mandandole como aprametro una imagen
        //Poner imagen en el boton con el tamano del boton
        BotonModificar./*Mandar ICON*/setIcon(/*CrearObjetoPara traer*/new ImageIcon(/*USar objeto para traer imagen*/ImagenBoton.getImage()./*Tamano->*/getScaledInstance(BotonModificar.getWidth(), BotonModificar.getHeight(),Image.SCALE_SMOOTH )));
        BotonModificar.setBorder(null); //Eliminar borde de boto 
        //Poner fondo transparente al boton
        BotonModificar.setOpaque(false);
        BotonModificar.setBackground(new Color(0,0,0,0));   
        //Agregar boton al panel
        PanelMenu1.add(BotonModificar); 
        
        
        ActionListener OyenteAccion=new ActionListener() //Creacion e inicializacion  de objeto actionlistener. oyente de accion
        {
            //Metodo del oyente de accion para poner lo que queremos hacer al presionar el boton
            public void actionPerformed(ActionEvent e) 
            {
                
               PanelMenu1.setVisible(false);
                
                add(ModEd);
                ModEd.setVisible(true);
              
            }
        };    
        
        BotonModificar.addActionListener(OyenteAccion); //Agregamos la etiqueta al panel
    

    }
    
    
    
    
    
    
    
    private void BotonBuscar()
    {
        
    //Boton para registrar
        BotonBuscar1=new JButton(); //Arriba se creo el Objeto Boton2, aqui solo se inicializa agregandole el constructor de JButton
        BotonBuscar1.setBounds(240, 400, 200, 90); //Tamano de botn
        //BotonReg1.setLocation(300, 300);
     
        ImageIcon ImagenBoton;//Creacion de Objto de tipo imagen
        ImagenBoton=new ImageIcon("Buscar.png"); //Inicializando el objeto agregandole el constructor de ImageIcon y mandandole como aprametro una imagen
        //Poner imagen en el boton con el tamano del boton
        BotonBuscar1./*Mandar ICON*/setIcon(/*CrearObjetoPara traer*/new ImageIcon(/*USar objeto para traer imagen*/ImagenBoton.getImage()./*Tamano->*/getScaledInstance(BotonBuscar1.getWidth(), BotonBuscar1.getHeight(),Image.SCALE_SMOOTH )));
        BotonBuscar1.setBorder(null); //Eliminar borde de boto 
        //Poner fondo transparente al boton
        BotonBuscar1.setOpaque(false);
        BotonBuscar1.setBackground(new Color(0,0,0,0));   
        //Agregar boton al panel
        PanelMenu1.add(BotonBuscar1); 
        
        
        ActionListener OyenteAccion=new ActionListener() //Creacion e inicializacion  de objeto actionlistener. oyente de accion
        {
            //Metodo del oyente de accion para poner lo que queremos hacer al presionar el boton
            public void actionPerformed(ActionEvent e) 
            {
               
                  PanelMenu1.setVisible(false);
                
                add(BusEd);
                BusEd.setVisible(true);
                
            }
        };    
        
        BotonBuscar1.addActionListener(OyenteAccion); //Agregamos la etiqueta al panel
    

    }
    
    
    
    
    
    
    
    private void BotonBloquear()
    {
        
    //Boton para registrar
        BotonBloquear1=new JButton(); //Arriba se creo el Objeto Boton2, aqui solo se inicializa agregandole el constructor de JButton
        BotonBloquear1.setBounds(240, 500, 200, 90); //Tamano de botn
        //BotonReg1.setLocation(300, 300);
     
        ImageIcon ImagenBoton;//Creacion de Objto de tipo imagen
        ImagenBoton=new ImageIcon("BloquearEdit.png"); //Inicializando el objeto agregandole el constructor de ImageIcon y mandandole como aprametro una imagen
        //Poner imagen en el boton con el tamano del boton
        BotonBloquear1./*Mandar ICON*/setIcon(/*CrearObjetoPara traer*/new ImageIcon(/*USar objeto para traer imagen*/ImagenBoton.getImage()./*Tamano->*/getScaledInstance(BotonBloquear1.getWidth(), BotonBloquear1.getHeight(),Image.SCALE_SMOOTH )));
        BotonBloquear1.setBorder(null); //Eliminar borde de boto 
        //Poner fondo transparente al boton
        BotonBloquear1.setOpaque(false);
        BotonBloquear1.setBackground(new Color(0,0,0,0));   
        //Agregar boton al panel
        PanelMenu1.add(BotonBloquear1); 
        
        
        ActionListener OyenteAccion=new ActionListener() //Creacion e inicializacion  de objeto actionlistener. oyente de accion
        {
            //Metodo del oyente de accion para poner lo que queremos hacer al presionar el boton
            public void actionPerformed(ActionEvent e) 
            {
               
                add(PanelLogin);
                PanelLogin.setVisible(true);
                PanelMenu1.setVisible(false);
                RegPulsado=1;
                LimpiarLogin();
                
            }
        };    
        
        BotonBloquear1.addActionListener(OyenteAccion); //Agregamos la etiqueta al panel
    

    }
    
    
    private void InicioSesion()
    {
        String Usuario4="root";
         String Password4="toor";
         
         
        
        //usuario
        JLabel Usuario=new JLabel();//Crear objeto para el titulo
        Usuario.setOpaque(false);//Desactivar diseno por defecto
        Usuario.setText("Usuario: ");//Mandar texto
        Usuario.setFont(new Font("arial", 1,15));//Estilo, tipo y tamano
        Usuario.setBounds(190,180, 300, 50); //Ubicacion y tamano de etiqueta
        Usuario.setForeground(Color.white);//Color texto
        PanelLogin.add(Usuario);//Agregar a panel
        //Caja de texto
        CajaUsuario =new JTextField();//Arriba se creo el objeto de tipo JTextField, aqui solo se inicializa con el constructor JTextFiel
        CajaUsuario.setBounds(260, 195, 200, 30); //Definicion del tamaño y ubicacion de la cajita de texto
        PanelLogin.add(CajaUsuario); //Mandando la caja de texto al panel
        
        //Contrasena
        JLabel Password=new JLabel();//Crear objeto para el titulo
        Password.setOpaque(false);//Desactivar diseno por defecto
        Password.setText("Contraseña: ");//Mandar texto
        Password.setFont(new Font("arial", 1,15));//Estilo, tipo y tamano
        Password.setBounds(170,250, 300, 50); //Ubicacion y tamano de etiqueta
        Password.setForeground(Color.white);//Color texto
        PanelLogin.add(Password);//Agregar a panel
        //Caja de texto
        CajaPassword =new JTextField();//Arriba se creo el objeto de tipo JTextField, aqui solo se inicializa con el constructor JTextFiel
        CajaPassword.setBounds(260, 265, 200, 30); //Definicion del tamaño y ubicacion de la cajita de texto
        PanelLogin.add(CajaPassword); //Mandando la caja de texto al panel
    
    
        
        
    //Boton para registrar
        BotonIniciar=new JButton(); //Arriba se creo el Objeto Boton2, aqui solo se inicializa agregandole el constructor de JButton
        BotonIniciar.setBounds(280, 320, 150, 55); //Tamano de botn
        //BotonReg1.setLocation(300, 300);
     
        ImageIcon ImagenBoton;//Creacion de Objto de tipo imagen
        ImagenBoton=new ImageIcon("IniciarSesion.png"); //Inicializando el objeto agregandole el constructor de ImageIcon y mandandole como aprametro una imagen
        //Poner imagen en el boton con el tamano del boton
        BotonIniciar./*Mandar ICON*/setIcon(/*CrearObjetoPara traer*/new ImageIcon(/*USar objeto para traer imagen*/ImagenBoton.getImage()./*Tamano->*/getScaledInstance(BotonIniciar.getWidth(), BotonIniciar.getHeight(),Image.SCALE_SMOOTH )));
        BotonIniciar.setBorder(null); //Eliminar borde de boto 
        //Poner fondo transparente al boton
        BotonIniciar.setOpaque(false);
        BotonIniciar.setBackground(new Color(0,0,0,0));   
        //Agregar boton al panel
        PanelLogin.add(BotonIniciar); 
         
        
        ActionListener OyenteAccion=new ActionListener() //Creacion e inicializacion  de objeto actionlistener. oyente de accion
        {
            //Metodo del oyente de accion para poner lo que queremos hacer al presionar el boton
            public void actionPerformed(ActionEvent e) 
            {
              
                
                if(CajaUsuario.getText().equals(Usuario4)&&CajaPassword.getText().equals(Password4))
                {
                    
        
                    add(PanelMenu1);
                    PanelMenu1.setVisible(true);
                    PanelLogin.setVisible(false);
                   
                }
                else 
                {
                    
                    JOptionPane.showMessageDialog ( null,"Los datos ingresados son incorrectos. Intentelo nuevamente");
                     LimpiarLogin();
                }  
                 
                
            }
        };
  
        
        BotonIniciar.addActionListener(OyenteAccion); //Agregamos la etiqueta al panel
   

        
    }
    
    
    private void Menu1()
    {
    //Boton para registrar
        JButton BotonMenu2=new JButton(); //Arriba se creo el Objeto Boton2, aqui solo se inicializa agregandole el constructor de JButton
        BotonMenu2.setBounds(50, 515, 100, 40); //Tamano de botn
        ImageIcon ImagenBoton;//Creacion de Objto de tipo imagen
        ImagenBoton=new ImageIcon("Menu.png"); //Inicializando el objeto agregandole el constructor de ImageIcon y mandandole como aprametro una imagen
        //Poner imagen en el boton con el tamano del boton
        BotonMenu2./*Mandar ICON*/setIcon(/*CrearObjetoPara traer*/new ImageIcon(/*USar objeto para traer imagen*/ImagenBoton.getImage()./*Tamano->*/getScaledInstance(BotonMenu2.getWidth(), BotonMenu2.getHeight(),Image.SCALE_SMOOTH )));
        BotonMenu2.setBorder(null); //Eliminar borde de boto 
        //Poner fondo transparente al boton
        BotonMenu2.setOpaque(false);
        BotonMenu2.setBackground(new Color(0,0,0,0));   
        //Agregar boton al panel
        
        VisEd.add(BotonMenu2);
        
        
        
         ActionListener OyenteAccion=new ActionListener() //Creacion e inicializacion  de objeto actionlistener. oyente de accion
        {
            //Metodo del oyente de accion para poner lo que queremos hacer al presionar el boton
            public void actionPerformed(ActionEvent e) 
            {
               VisEd.setVisible(false);
                add(PanelMenu1);
                PanelMenu1.setVisible(true);
                
                //PanelMenu1.setVisible(false);
                //RegPulsado=1;
            }
        }; 
         BotonMenu2.addActionListener(OyenteAccion); //Agregamos la etiqueta al panel
    
    }
    
    
    
    
     private void Menu2()
    {
    //Boton para registrar
        JButton BotonMenu3=new JButton(); //Arriba se creo el Objeto Boton2, aqui solo se inicializa agregandole el constructor de JButton
        BotonMenu3.setBounds(50, 515, 100, 40); //Tamano de botn
        ImageIcon ImagenBoton;//Creacion de Objto de tipo imagen
        ImagenBoton=new ImageIcon("Menu.png"); //Inicializando el objeto agregandole el constructor de ImageIcon y mandandole como aprametro una imagen
        //Poner imagen en el boton con el tamano del boton
        BotonMenu3./*Mandar ICON*/setIcon(/*CrearObjetoPara traer*/new ImageIcon(/*USar objeto para traer imagen*/ImagenBoton.getImage()./*Tamano->*/getScaledInstance(BotonMenu3.getWidth(), BotonMenu3.getHeight(),Image.SCALE_SMOOTH )));
        BotonMenu3.setBorder(null); //Eliminar borde de boto 
        //Poner fondo transparente al boton
        BotonMenu3.setOpaque(false);
        BotonMenu3.setBackground(new Color(0,0,0,0));   
        //Agregar boton al panel
        
        BusEd.add(BotonMenu3);
        
        
        
         ActionListener OyenteAccion=new ActionListener() //Creacion e inicializacion  de objeto actionlistener. oyente de accion
        {
            //Metodo del oyente de accion para poner lo que queremos hacer al presionar el boton
            public void actionPerformed(ActionEvent e) 
            {
               BusEd.setVisible(false);
                add(PanelMenu1);
                PanelMenu1.setVisible(true);
                
                //PanelMenu1.setVisible(false);
                //RegPulsado=1;
            }
        }; 
         BotonMenu3.addActionListener(OyenteAccion); //Agregamos la etiqueta al panel
    
    }
    
    
     
     private void Menu4()
    {
    //Boton para registrar
        JButton BotonMenu4=new JButton(); //Arriba se creo el Objeto Boton2, aqui solo se inicializa agregandole el constructor de JButton
        BotonMenu4.setBounds(50, 515, 100, 40); //Tamano de botn
        ImageIcon ImagenBoton;//Creacion de Objto de tipo imagen
        ImagenBoton=new ImageIcon("Menu.png"); //Inicializando el objeto agregandole el constructor de ImageIcon y mandandole como aprametro una imagen
        //Poner imagen en el boton con el tamano del boton
        BotonMenu4./*Mandar ICON*/setIcon(/*CrearObjetoPara traer*/new ImageIcon(/*USar objeto para traer imagen*/ImagenBoton.getImage()./*Tamano->*/getScaledInstance(BotonMenu4.getWidth(), BotonMenu4.getHeight(),Image.SCALE_SMOOTH )));
        BotonMenu4.setBorder(null); //Eliminar borde de boto 
        //Poner fondo transparente al boton
        BotonMenu4.setOpaque(false);
        BotonMenu4.setBackground(new Color(0,0,0,0));   
        //Agregar boton al panel
        
        BusEd.add(BotonMenu4);
        
        
        
         ActionListener OyenteAccion=new ActionListener() //Creacion e inicializacion  de objeto actionlistener. oyente de accion
        {
            //Metodo del oyente de accion para poner lo que queremos hacer al presionar el boton
            public void actionPerformed(ActionEvent e) 
            {
               ModEd.setVisible(false);
                add(PanelMenu1);
                PanelMenu1.setVisible(true);
                
                //PanelMenu1.setVisible(false);
                //RegPulsado=1;
            }
        }; 
         BotonMenu4.addActionListener(OyenteAccion); //Agregamos la etiqueta al panel
    
    }
    
    
    
    
    
}
