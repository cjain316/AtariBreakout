import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block {
	private int x,y;
	private int width,height;
	private Color color;
	private Rectangle hitbox;
	private boolean broken;
	
	public Block(int x, int y, int width, int height, Color color) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		hitbox = new Rectangle(x,y,width,height);
		broken = false;
	}
	
	public void paint(Graphics g) {
		if (!broken) {
			hitbox.setLocation(x,y);
			g.setColor(new Color(0,0,0));
			g.fillRect(x, y, width, height);
			g.setColor(color);
			g.fillRect(x+3, y+3, width-6, height-6);
		}
	}
	
	public Rectangle getHitbox() {return hitbox;}
	public void setBroken(boolean real) {broken = real;}
	public boolean getBroken() {return broken;}
	
	

}
