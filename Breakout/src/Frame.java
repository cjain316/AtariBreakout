import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Frame extends JPanel implements KeyListener, ActionListener{
    Paddle paddle = new Paddle(885,900);
    Ball newBall = new Ball(950,700,20);
    Block[][] blocks = new Block[6][20];
    private Image Sprite = null;
    private AffineTransform tx;
    Color[] colors = {new Color(0,255,100),new Color(0,255,0),new Color(255,0,0)
    		,new Color(0,0,255),new Color(255,255,0),new Color(0,255,255), new Color(255,255,255)};
    Color color;
    /* paint is getting called roughly 144x per second */
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 1920, 1080);
        
        if (colliding(newBall,paddle)) {newBall.setVy(-9);if (randBool()) {newBall.setVx(9);}
        else {newBall.setVx(-9);}}
        if (newBall.getX() >= 1920 || newBall.getX() <= 0) {newBall.setVx(newBall.getVx()*-1);}
        if (newBall.getY() > 1080) {Sprite = getImage("Resources\\\\lose.png");}
        if (newBall.getY() <= 0) {Sprite = getImage("Resources\\\\win.png");}
        
	    
        for (int a = 0; a < blocks.length;a++) {
        	for (int b = 0; b < blocks[a].length;b++) {
        		if (!blocks[a][b].getBroken()) {if (colliding(newBall,blocks[a][b])) 
        		{blocks[a][b].setBroken(true); newBall.setVy(9);}
        		blocks[a][b].paint(g);}
        	}
        }
        
        if (Sprite != null) {
        	tx = AffineTransform.getTranslateInstance(640, 420);
        	g2.drawImage(Sprite, tx, null);
        }
        
	    paddle.paint(g);
	    newBall.paint(g);
	    
	}

    
    
    public static void main(String[] arg) {
        Frame f = new Frame();
        
    }    
    
    @Override
    public void keyPressed(KeyEvent arg) {
    	//System.out.println(arg.getExtendedKeyCode());
        if (arg.getExtendedKeyCode() == 65) {paddle.setVelocity(-15);}
        if (arg.getExtendedKeyCode() == 68) {paddle.setVelocity(15);}}

    @Override
    public void keyReleased(KeyEvent arg) {
        if (arg.getExtendedKeyCode() == 65) {paddle.setVelocity(0);}
        if (arg.getExtendedKeyCode() == 68) {paddle.setVelocity(0);}}
    
    
    public boolean colliding(Ball b, Paddle p) {
    	return b.getHitbox().intersects(p.getHitbox());
    }
    public boolean colliding(Ball b, Block p) {
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
    	for (int a = 0; a < blocks.length; a++) {
        	color = colors[a];
        	for (int b = 0; b < blocks[a].length;b++) {
        		blocks[a][b] = new Block(
        				(1920/blocks.length)*b,
        				((1080)/blocks[a].length*a),
        				(1920/blocks.length),
        				((1080)/blocks[a].length),
        				color
        				);
        	}
        }
    	
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
    
    protected Image getImage(String path) {

        Image tempImage = null;
        try {
            URL imageURL = Background.class.getResource(path);
            tempImage    = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {e.printStackTrace();}
        return tempImage;
    }
    
}
