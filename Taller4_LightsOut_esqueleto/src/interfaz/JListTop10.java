package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.PriorityQueue;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

public class JListTop10 {
	public static void crearJList(Top10 datos) {
	JFrame frame = new JFrame("Top 10");
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setSize(300, 200);
    JPanel panel =new JPanel();
    panel.setLayout(new BorderLayout());
    
    
    PriorityQueue<RegistroTop10> registros=(PriorityQueue<RegistroTop10>) datos.darRegistros();
    // Crear un arreglo de elementos para la lista
    String[] elementos = new String[registros.size()];
    System.out.println(registros.size());
    int i=0;
	while(registros.isEmpty()==false) {
		RegistroTop10 ele =registros.poll();
		String nombre=ele.darNombre();
		String puntos=String.valueOf(ele.darPuntos());
		
		elementos[i]=i+1+"-"+nombre+"-"+puntos;
		i++;
	}

    // Crear un JList con los elementos
    JList<String> lista = new JList<>(elementos);
    DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Personalizar el color de primer plano (color de texto)
            c.setForeground(Color.GREEN); // Establecer el color de primer plano deseado

            return c;
        }
    };
    lista.setCellRenderer(renderer);
    // Crear un JScrollPane para la JList en caso de que haya muchos elementos
    JScrollPane scrollPane = new JScrollPane(lista);
    System.out.println("top");
    botonSalir.crearBotonSalir(panel);
    
    // Agregar el JList y el JButton al JPanel
    panel.add(new JScrollPane(lista), BorderLayout.CENTER);
    panel.add(botonSalir.getBoton(), BorderLayout.SOUTH);

    // Agregar el JPanel al JFrame
    frame.add(panel);

    frame.setVisible(true);
}}
