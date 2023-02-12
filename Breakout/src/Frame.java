import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Frame extends JPanel implements KeyListener, ActionListener{
    Paddle paddle = new Paddle(885,900);
    Ball newBall = new Ball(950,700,20);
    /* paint is getting called roughly 144x per second */
    public void paint(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 1920, 1080);
        
        if (colliding(newBall,paddle)) 
	        {newBall.setVy(-9);
	        if (randBool()) {newBall.setVx(9);}
	        else {newBall.setVx(-9);}
        }
        if (newBall.getX() <= 0 || newBall.getX() >= 1920) {newBall.setVx(newBall.getVx()*-1);}
        if (newBall.getY() <= 0) {newBall.setVy(9);}
	    
	    paddle.paint(g);
	    newBall.paint(g);
	    
	}

    
    
    public static void main(String[] arg) {
        Frame f = new Frame();
    }    
    
    @Override
    public void keyPressed(KeyEvent arg) {
    	System.out.println(arg.getExtendedKeyCode());
        if (arg.getExtendedKeyCode() == 65) {paddle.setVelocity(-7);}
        if (arg.getExtendedKeyCode() == 68) {paddle.setVelocity(7);}}

    @Override
    public void keyReleased(KeyEvent arg) {
        if (arg.getExtendedKeyCode() == 65) {paddle.setVelocity(0);}
        if (arg.getExtendedKeyCode() == 68) {paddle.setVelocity(0);}}
    
    
    public boolean colliding(Ball b, Paddle p) {
    	return b.getHitbox().intersects(p.getHitbox());
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        repaint();
    }
    
    public boolean randBool() {if (Math.random() > 0.5) {return true;} else {return false;}}
    
    Timer t;
    
    public Frame() {
        JFrame f = new JFrame("Pong");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.addKeyListener(this);
        
        f.setResizable(false);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        
        t = new Timer(7, this);
        t.start();
        f.setVisible(true);
       
        
    }
    
}
