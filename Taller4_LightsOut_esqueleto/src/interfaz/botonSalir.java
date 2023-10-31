package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class botonSalir implements ActionListener{
	private static JButton salir;
	public static JPanel crearBotonSalir(JPanel panel) {
		 salir = new JButton("salir");
		    salir.setBounds(376, 21, 80, 25);
		    
		    salir.addActionListener(new botonSalir());
		    
		    panel.add(salir);
			return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Ventana.cargarVentanaPrincipal();
	}
	
	public static JButton getBoton() {
		return salir;
	}
}

