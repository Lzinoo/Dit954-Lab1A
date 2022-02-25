import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image
    //BufferedImage[] carImage = new BufferedImage[3];
    ArrayList<BufferedImage> carImage = new ArrayList<>(); //A list of images
    //Point[] carPoints = new Point[3];
    ArrayList<Point> carPoints = new ArrayList<>(); // To keep track of a single cars position

    // TODO: Make this general for all cars
    void moveit(int index, int x, int y){
        carPoints.get(index).x = x;
        carPoints.get(index).y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < carPoints.size(); i++){
            g.drawImage(carImage.get(i), carPoints.get(i).x, carPoints.get(i).y, null);
        }
    }

    //Looks at a list of cars and adds them to be rendered
    public void updateRender(ArrayList<Vehicles> vehicles) {
        for (int i = 0; i < vehicles.size(); i++) {
            carPoints.add(i, new Point((int)vehicles.get(i).getX(),(int)vehicles.get(i).getY()));
            addImage(vehicles.get(i),i);
        }
    }

    //Adds an image based on the class of the car at runtime
    private void addImage(Vehicles vehicle, int index) {
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            if (vehicle.getClass() == Volvo240.class) {
                carImage.add(index, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            } else if (vehicle.getClass() == Scania.class) {
                carImage.add(index, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
            } else if (vehicle.getClass() == Saab95.class) {
                carImage.add(index, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            } else {
                carImage.add(index, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + vehicle.getModelName() + ".jpg")));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
