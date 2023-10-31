package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class Ventana implements ActionListener,MouseListener {
	private static JTextField tamText;
	private static JTextField difText;
	private static JFrame frame;
	private static Tablero elTablero;
	private static int tam;
	private int dif;
	private static Top10 lista;
	public static void main(String[] args) {
		lista=new Top10();
		cargarVentanaPrincipal();
    }
public static void cargarVentanaPrincipal() {
	// TODO Auto-generated method stub
	lista.cargarRecords(new File ("./data/top10.csv"));
	System.out.println("datos cargados");
	
    frame = new JFrame("LightOut");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //SquarePanel squarePanel = new SquarePanel();
    //frame.add(squarePanel);
    JPanel panel =new JPanel();
    frame.setSize(500, 500);
    frame.add(panel);
    
    panel.setLayout(null);
    JLabel labelTam = new JLabel("Tamaño");
    labelTam.setBounds(10,20,80,25);
    
    tamText = new JTextField(20);
    tamText.setBounds(100,20,165,25);
    panel.add(labelTam);
    panel.add(tamText);
    
    // dificultad
    JLabel labelDif = new JLabel("Dificultad");
    labelDif.setBounds(10,50,80,25);
    
    difText = new JTextField(20);
    difText.setBounds(100,50,165,25);
    panel.add(labelDif);
    panel.add(difText);
    
    // botón de inicio
    JButton inicio = new JButton("Jugar");
    inicio.setBounds(10, 80, 80, 25);
    inicio.addActionListener(new Ventana());
    panel.add(inicio);
    
    panel=botonTop10.crearBotonTop(panel);
    
    frame.setVisible(true);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hi");
		System.out.println(tamText.getText());
		System.out.println(difText.getText());
		tam= Integer.parseInt(tamText.getText());
		dif= Integer.parseInt(difText.getText());
		
		elTablero = new Tablero(tam);
		elTablero.desordenar(dif);
		
		frame.getContentPane().removeAll();
		SquarePanel squarePanel = new SquarePanel();
		squarePanel.setTablero(elTablero.darTablero());
		squarePanel.setLayout(null);
		
		squarePanel.addMouseListener(new Ventana());
		
		
		
		squarePanel=(SquarePanel) botonSalir.crearBotonSalir(squarePanel);
		squarePanel=(SquarePanel) botonReiniciar.crearBotonReiniciar(squarePanel);
		
		
		frame.add(squarePanel);
		frame.revalidate();
		

		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
        System.out.println("Mouse presionado en (" + e.getX() + ", " + e.getY() + ")");
        
        int click_x = e.getX(); 
        int click_y = e.getY(); 
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y); 
      
        elTablero.jugar(casilla[0], casilla[1]); 
        
        
        frame.getContentPane().removeAll();
		SquarePanel squarePanel = new SquarePanel();
		SquarePanel.setTablero(elTablero.darTablero());
		
		squarePanel.setLayout(null);
		
		squarePanel.addMouseListener(new Ventana());
		frame.add(squarePanel);
		boolean win=elTablero.tableroIluminado();
		System.out.println(win);
		if(win==true) {
			frame.getContentPane().removeAll();
			cargarVentanaPrincipal();
			
		}
		else{
			squarePanel=(SquarePanel) botonSalir.crearBotonSalir(squarePanel);
			squarePanel=(SquarePanel) botonReiniciar.crearBotonReiniciar(squarePanel);
			
			frame.add(squarePanel);
		frame.revalidate();
		
    }}
	 private int[] convertirCoordenadasACasilla(int x, int y) 
	 { 
		 System.out.println(tam); 
	  int fila = (int) (y / (300/tam)); 
	  int columna = (int) (x / (300/tam)); 
	  System.out.println(fila+","+columna);
	  return new int[] { fila, columna }; 
	 } 

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void reinciarPartida() {
		frame.getContentPane().removeAll();
		SquarePanel squarePanel = new SquarePanel();
		elTablero.reiniciar();
		System.out.println("reiniciar");
		squarePanel.setTablero(elTablero.darTablero());
		squarePanel.addMouseListener(new Ventana());
		squarePanel.setLayout(null);
		
		
		
		squarePanel=(SquarePanel) botonSalir.crearBotonSalir(squarePanel);
		squarePanel=(SquarePanel) botonReiniciar.crearBotonReiniciar(squarePanel);
		
		
		frame.add(squarePanel);
		frame.revalidate();


	}
public static void mostrarTop() {
	JListTop10.crearJList(lista);
}


}

