import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GamePanel extends JPanel implements KeyListener{
    private Player player;
    private Sun[] suns;
    private int level = 1;
    public GamePanel(int width,int height){
        setSize(800,600);
        setLayout(null);
        addKeyListener(this);
        
        player = new Player(350,550,128,16);
        
        suns = new Sun[10 ];
        for(int i = 0;i < suns.length;i++){
            suns[i] = new Sun((int)(Math.random()*(width-64)),50,64,64);
        }
        
        new GameLoop(this);
    }
    
    private void reload(){
        level++;
        suns = new Sun[(int)Math.log(level)];
    }
    
    public void berechnen(){
        for(int i = 0; i < suns.length;i++){
            suns[i].berechnen();
        }
        collision();
        player.berechnen();
    }
    
    public void collision(){
        for(int i = 0; i < suns.length;i++){
            if(player.getRect().intersects(suns[i].getRect())){
                double a = suns[i].getX()-player.getX();
                if(a <= 0){
                    a = 0;
                }
                a = a/player.getWidth();
                if(a <= 0.3333){
                    suns[i].setYSpeed(-Math.abs(suns[i].getYSpeed()));
                    suns[i].setXSpeed(suns[i].getXSpeed()-Math.random());
                }
                else if(a>= 0.6666){
                    suns[i].setYSpeed(-Math.abs(suns[i].getYSpeed()));
                    suns[i].setXSpeed(suns[i].getXSpeed()+Math.random());
                }
                suns[i].setYSpeed(-Math.abs(suns[i].getYSpeed()));
            }
            if(((suns[i].getX()+suns[i].getXSpeed()+suns[i].getWidth()) >= getWidth()) || (suns[i].getX()+suns[i].getXSpeed() <= 0)){
                suns[i].setXSpeed(-suns[i].getXSpeed());
            }
            if((suns[i].getY()+suns[i].getYSpeed() <= 0)){
                suns[i].setYSpeed(-suns[i].getYSpeed());
            }
            if(((suns[i].getY()+suns[i].getYSpeed()+suns[i].getHeight()) >= getHeight())){
                //NOOB
            }
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(Pictures.getBackground(),0,0,this);
        
        player.zeichnen(g,this);
        
        for(int i = 0; i< suns.length;i++){
            suns[i].zeichnen(g,this);
        }
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