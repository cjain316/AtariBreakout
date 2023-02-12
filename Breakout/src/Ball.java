import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball { //class Header

    private int x;
    private int y;
    private Rectangle hitbox;
    
    public int getX() {return x;}

    public void setX(int x) {this.x = x;}

    public int getY() {return y;}
    
    public int getSize() {return width;}
    
    public void setY(int y) {this.y = y;}

    public int getWidth() {return width;}

    public void setWidth(int width) {this.width = width;}

    public int getVx() {return vx;}

    public void setVx(int vx) {this.vx = vx;}

    public int getVy() {return vy;}

    public void setVy(int vy) {this.vy = vy;}

    public Color getColor() {return color;}
    
    public Rectangle getHitbox() {return hitbox;}

    private int width; //size variable
    private Color color; //color
    private int vx, vy; //velocity variables
    
    // # - parts of a class - constructor
    // helps with creation of class
    // assigns values to the instance variable
    public Ball() { //the default constructor is the one w/o parameters
        
        x = (int)(Math.random()*(600-100+1))+100; // [100 600] randomize it
        y = (int)(Math.random()*(400-100+1))+100;//randomize it between [100 400]
        
        width = 3;
        
        color = new Color(0, 0, 0);
        
        vx = 0;
        vy = -7;
        
        hitbox = new Rectangle(x,y,width,width);
                
    }
        
    public Ball(int newX, int newY, int newWidth) {
        x = newX;
        y = newY;
        width = newWidth;
        //also randomize the colors
        vy = 9;
        hitbox = new Rectangle(x,y,width,width);
    }
    public void setVelocityX(int vx) {
        this.vx = vx;
    }
    
    public void setVelocityY(int vy) {
        this.vy = vy;
    }
    
    //add a method to the ball that allows it to paint itself
    public void paint(Graphics g) {
        
        //update velocity
        x += vx;
        y += vy;
        
        //set the color
        hitbox.setLocation(x,y);
        g.setColor(color);
        
        //draw the object
        g.fillOval(x, y, width, width);
        
    }
    
    
    
    
}