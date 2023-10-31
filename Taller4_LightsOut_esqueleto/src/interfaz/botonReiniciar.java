package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class botonReiniciar implements ActionListener{
	public static JPanel crearBotonReiniciar(JPanel panel) {
		 JButton reiniciar = new JButton("Reiniciar");
		    reiniciar.setBounds(376, 51, 80, 25);
		    
		    reiniciar.addActionListener(new botonReiniciar());
		    
		    panel.add(reiniciar);
			return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Ventana.reinciarPartida();
	}}
