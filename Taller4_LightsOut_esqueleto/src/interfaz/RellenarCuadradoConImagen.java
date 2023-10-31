package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RellenarCuadradoConImagen {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Rellenar Cuadrado con Imagen");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 400);
                
                JPanel panel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        
                        int squareSize = 100;
                        int x = (getWidth() - squareSize) / 2;
                        int y = (getHeight() - squareSize) / 2;
                        
                        try {
                            // Cargar la imagen desde un archivo
                            BufferedImage image = ImageIO.read(new File("./data/guiMario.png"));
                            
                            // Dibujar el cuadrado con la imagen
                            Graphics2D g2d = (Graphics2D) g;
                            g2d.fillRect(x, y, squareSize, squareSize);
                            g2d.drawImage(image, x, y, squareSize, squareSize, this);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                
                frame.add(panel);
                frame.setVisible(true);
            }
        });
    }
}

