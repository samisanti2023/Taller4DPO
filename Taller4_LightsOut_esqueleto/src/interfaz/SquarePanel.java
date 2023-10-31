package interfaz;


	import javax.imageio.ImageIO;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

import java.awt.Color;
	import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

	public class SquarePanel extends JPanel  {
		
		private static boolean[][] elTablero;
		 public static void setTablero(boolean[][]valor) {
		        elTablero = valor;}
	    protected void paintCuadrado(Graphics g,boolean bool,int x,int y,int tam) {
	        
	        int width = tam;
	        int height = tam;

	        // Dibuja el borde negro del cuadrado
	        g.setColor(Color.BLACK);
	        g.drawRect(x, y, width, height);
	        if (bool==true) {
	        // Establece el color de relleno en amarillo
	        g.setColor(Color.BLUE);

	        // Dibuja el cuadrado amarillo
	        g.fillRect(x, y, width, height);
	        
	    }
	
	        else {
	            try {
                    // Cargar la imagen desde un archivo
                    BufferedImage image = ImageIO.read(new File("./data/guiMario.png"));
                    
                    // Dibujar el cuadrado con la imagen
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.fillRect(x, y, width, width);
                    g2d.drawImage(image, x, y, width, width, this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
	        
	    }
	    @Override
	    public void paintComponent(Graphics g) {
	    	
	    	super.paintComponent(g);
	    	
	    	int tamanio = elTablero.length;
	    	int tamCasilla =300/tamanio;
	    	int x=10;
	    	int y=10;
	    	int i=0;
	    	
			while (i<tamanio) {
				int ii = 0;
				while(ii<tamanio)
				{
					boolean bool= elTablero[i][ii];
					paintCuadrado(g,bool,x,y,tamCasilla);
					x=x+tamCasilla;
					ii++;
				}
				x=10;
				y=y+tamCasilla;
				i++;
				
				
		}
	    }

	}


