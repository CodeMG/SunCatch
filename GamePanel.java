import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class GamePanel extends JPanel implements KeyListener{
    private Player player;
    private ArrayList<Sun> suns;
    private int lostSuns;
    private int biggestSun;
    private int totalPoints;
    private int pointsTilNextSun;
    private int pointCounter;
    public GamePanel(int width,int height){
        setSize(800,600);
        setLayout(null);
        addKeyListener(this);

        player = new Player(350,550,128,16);

        biggestSun = 0;
        lostSuns = 0;
        pointsTilNextSun = 0;
        pointCounter = pointsTilNextSun;
        
        suns = new ArrayList<Sun>();
        new GameLoop(this);
    }

    public void berechnen(){
        for(int i = 0; i < suns.size();i++){
            suns.get(i).berechnen();
            totalPoints+=suns.get(i).getPoints();
            pointCounter-=suns.get(i).getPoints();
        }
        if(pointCounter <= 0){
            suns.add(new Sun(100,100,32,32));
            pointCounter  = pointsTilNextSun;
            pointsTilNextSun = 4*biggestSun*500;
        }
        
        collision();
        player.berechnen();
        if(suns.size() > biggestSun){
            biggestSun = suns.size();
        }
        player.actualiseSpeed((double)((double)suns.size()/(double)biggestSun));
        
    }

    public void collision(){
        for(int i = 0; i < suns.size();i++){
            Sun sun = suns.get(i);
            if(sun.isIngame()){
                if(player.getRect().intersects(sun.getRect())){
                    double a = (sun.getX()+(sun.getWidth()*0.5))-player.getX();
                    if(a <= 0){
                        a = 0;
                    }
                    else if(a >= player.getWidth()){
                        a = player.getWidth();
                    }
                    a = a/player.getWidth();
                    double x = sun.getXSpeed();
                    double y = sun.getYSpeed();
                    if(a <= 0.5){
                        double winkel = (Math.random()*50)+110;
                        x = (sun.getXSpeed()*Math.cos(Math.toRadians(winkel)))-(sun.getYSpeed()*Math.sin(Math.toRadians(winkel)));
                        y = (sun.getXSpeed()*Math.sin(Math.toRadians(winkel)))+(sun.getYSpeed()*Math.cos(Math.toRadians(winkel)));
                        sun.setXSpeed((int)x);
                        sun.setYSpeed((int)y);
                    }
                    else if(a>= 0.5){
                       double winkel = (Math.random()*50)+20;
                        x = (sun.getXSpeed()*Math.cos(Math.toRadians(winkel)))-(sun.getYSpeed()*Math.sin(Math.toRadians(winkel)));
                        y = (sun.getXSpeed()*Math.sin(Math.toRadians(winkel)))+(sun.getYSpeed()*Math.cos(Math.toRadians(winkel)));
                        sun.setXSpeed((int)x);
                        sun.setYSpeed((int)y);
                    }
                    sun.setYSpeed(-Math.abs(sun.getYSpeed()));
                }
                if(((sun.getX()+sun.getXSpeed()+sun.getWidth()) >= getWidth()) || (sun.getX()+sun.getXSpeed() <= 0)){
                    sun.setXSpeed(-sun.getXSpeed());
                }
                if((sun.getY()+sun.getYSpeed() <= 0)){
                    sun.setYSpeed(-sun.getYSpeed());
                }
                if(((sun.getY()+sun.getYSpeed()+sun.getHeight()) >= getHeight())){
                    suns.remove(sun);
                }
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(Pictures.getBackground(),0,0,this);

        player.zeichnen(g,this);

        for(int i = 0; i< suns.size();i++){
            suns.get(i).zeichnen(g,this);
        }
        
        g.setColor(Color.RED);
        g.drawString(""+biggestSun+"/" + suns.size(),50,50);
        
        g.drawString(""+totalPoints,600,50);
        
        requestFocus();
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_A){
            player.setLinks(true);
            player.setRechts(false);
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            player.setRechts(true);
            player.setLinks(false);
        }
    }

    public void keyTyped(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_A){
            player.setLinks(false);
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            player.setRechts(false);
        }
    }
    
    
}