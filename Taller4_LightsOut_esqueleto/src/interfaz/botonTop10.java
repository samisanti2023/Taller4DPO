package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class botonTop10 implements ActionListener{
	public static JPanel crearBotonTop(JPanel panel) {
		 JButton top = new JButton("Top 10");
		    top.setBounds(100, 80, 80, 25);
		    
		    top.addActionListener(new botonTop10());
		    
		    panel.add(top);
			return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Ventana.mostrarTop();
	}


}
