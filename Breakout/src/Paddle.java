import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle {

    // parts of a class - instance vars /properties
    // attributes
    private int x, y; //location
    private int width, height; //size
    private Color c;
    private int vy;
    private Rectangle hitbox;
    
    //constructor that allow setting of the location 
    public Paddle(int newX, int newY) {
        //assigns values to the attributes
        x = newX;
        y = newY;
        width = 150;
        height = 25;
        c = Color.white;
        hitbox = new Rectangle(x,y,width,height);
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public int getvY() {
        return vy;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    public void paint(Graphics g) {
        //update y
        if ((x + vy) > 0 && (x+vy) < (1770) ) {
            x += vy;
        } //velocity in y affects position in the y
        
        //set the color
        hitbox.setLocation(x,y);
        g.setColor(c);
        g.fillRect(x, y, width, height);
    
    }
    
    public Rectangle getHitbox() {return hitbox;}
    
    //SETTER - allows outsiders to set some value 
    //in the class
    public void setVelocity(int newVy) {
        vy = newVy;
    }
    
    
}