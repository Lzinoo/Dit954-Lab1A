import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image
    BufferedImage[] carImage = new BufferedImage[3];
    // To keep track of a single cars position
    Point[] carPoints = new Point[3];

    // TODO: Make this general for all cars
    void moveit(int index, int x, int y){
        carPoints[index].x = x;
        carPoints[index].y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.carPoints[0] = new Point(0,0);
        this.carPoints[1] = new Point(0,100);
        this.carPoints[2] = new Point(0,200);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            carImage[0] = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            carImage[1] = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            carImage[2] = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < 3; i++){
            g.drawImage(carImage[i],carPoints[i].x, carPoints[i].y, null);
        }
    }
}
