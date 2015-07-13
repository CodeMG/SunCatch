import javax.swing.*;
import java.awt.*;

public class Sun{
    private int x,y,width,height;
    private double speed;
    private double xSpeed,ySpeed;
    private boolean ingame;
    private Rectangle rect;
    public Sun(int x,int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        speed = 30;
        
        recalculate();
        ingame = true;
        rect = new Rectangle(x,y,width,height);
    }
    
    public void berechnen(){
        move();
    }
    
    public void move(){
        x+=xSpeed;
        y+=ySpeed;
        rect = new Rectangle(x,y,width,height);
    }
    
    public void recalculate(){
        if((int)(Math.random()*3) == 1){
            xSpeed = Math.random()*500;
        }
        else{
            xSpeed = -Math.random()*500;
        }
        
        if((int)(Math.random()*3) == 1){
            ySpeed = Math.random()*500;
        }
        else{
            ySpeed = -Math.random()*500;
        }
        double length = Math.sqrt(Math.pow(xSpeed,2)+Math.pow(ySpeed,2));
        xSpeed = xSpeed/length;
        ySpeed = ySpeed/length;
        xSpeed*=speed;
        ySpeed*=speed;
    }
    
    public boolean isIngame(){
        return ingame;
    }
    
    public void setIngame(boolean ingame){
        this.ingame = ingame;
    }
    
    public double getXSpeed(){
        return xSpeed;
    }
    
    public double getYSpeed(){
        return ySpeed;
    }
    
    public void setXSpeed(double xSpeed){
        this.xSpeed = xSpeed;
    }
    
    public void setYSpeed(double ySpeed){
        this.ySpeed = ySpeed;
    }
    
    public void zeichnen(Graphics g,JPanel panel){
        g.drawImage(Pictures.getSun(),x,y,panel);
    }
    
    public Rectangle getRect(){
        return rect;
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