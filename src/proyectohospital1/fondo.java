package proyectohospital1;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.WindowConstants;

/**
 * Ejemplo de JLayeredPane con una imagen de fondo.
 * 
 * @author Chuidiang
 * 
 */
public class fondo {

	
	
        public void FondoEd()
        {
        // La ventana y el layered pane.
		JFrame v = new JFrame("Ejemplo de JLayeredPane");
		JLayeredPane layered = new JLayeredPane();

		// La imagen de fondo metida en un JLabel, dandole el
		// tamano adecuado.
		JLabel fondo = new JLabel();
		ImageIcon imagen = new ImageIcon("Fondo.jpg");
		fondo.setIcon(imagen);
		fondo.setSize(imagen.getIconWidth(), imagen.getIconHeight());

		// La etiqueta que ira encima de la imagen.
		JLabel primerPlano = new JLabel("Primer plano");
		primerPlano.setSize(200, 40);

		// Se mete imagen y etiqueta en el JLayeredPane.
		// Debe ser Integer, no vale int.
		// Los Integer bajos corresponden a capas del fondo.
		layered.add(fondo, new Integer(1));
		layered.add(primerPlano, new Integer(2));

		// Se visualiza todo.
		v.getContentPane().add(layered);
		v.setSize(imagen.getIconWidth(), imagen.getIconHeight());
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		v.setVisible(true);
        }

}