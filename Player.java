import javax.swing.*;
import java.awt.*;

public class Player{
    private int x,y,width,height;
    private final double SPEED = 40;
    private double speed;
    private boolean links,rechts;
    private Rectangle rect;
    public Player(int x,int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        speed = SPEED;
        links = false;
        rechts = false;
        rect = new Rectangle(x,(int)(y+(height*0.5)),width,height);
    }

    public void zeichnen(Graphics g,JPanel panel){
        g.drawImage(Pictures.getFlower(),x,y,panel);
        g.setColor(Color.RED);
        g.drawRect(x,(int)(y+(height*0.5)),width,height);
    }

    public void actualiseSpeed(double percentage){
        speed = (int)(SPEED*percentage);
    }
    
    public void berechnen(){
        move();
    }

    private void move(){
        if(rechts){
            x+=speed;
        }
        else if(links){
            x-=speed;
        }
        rect = new Rectangle(x,(int)(y+(height*0.5)),width,height);
    }

    public Rectangle getRect(){
        return rect;
    }
    
    public boolean getRechts(){
        return rechts;
    }
    
    public void setRechts(boolean rechts){
        this.rechts = rechts;
    }
    
    public boolean getLinks(){
        return links;
    }
    
    public void setLinks(boolean links){
        this.links = links;
    }
    
    public void setSpeed(double speed){
        this.speed = speed;
    }

    public double getSpeed(){
        return speed;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getWidth(){
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

}