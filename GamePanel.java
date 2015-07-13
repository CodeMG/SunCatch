import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GamePanel extends JPanel implements KeyListener{
    private Player player;
    private Sun[] suns;
    private int lostSuns;
    private int level = 1;
    public GamePanel(int width,int height){
        setSize(800,600);
        setLayout(null);
        addKeyListener(this);

        player = new Player(350,550,128,16);

        lostSuns = 0;
        suns = new Sun[1];
        for(int i = 0;i < suns.length;i++){
            suns[i] = new Sun((int)(Math.random()*(width-64)),50,48,48);
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
        double sunsOriginal = suns.length;
        player.actualiseSpeed((sunsOriginal-lostSuns)/sunsOriginal);
        
    }

    public void collision(){
        for(int i = 0; i < suns.length;i++){
            if(suns[i].isIngame()){
                if(player.getRect().intersects(suns[i].getRect())){
                    double a = (suns[i].getX()+(suns[i].getWidth()*0.5))-player.getX();
                    if(a <= 0){
                        a = 0;
                    }
                    else if(a >= player.getWidth()){
                        a = player.getWidth();
                    }
                    a = a/player.getWidth();
                    double x = suns[i].getXSpeed();
                    double y = suns[i].getYSpeed();
                    if(a <= 0.5){
                        double winkel = (Math.random()*50)+110;
                        x = (suns[i].getXSpeed()*Math.cos(Math.toRadians(winkel)))-(suns[i].getYSpeed()*Math.sin(Math.toRadians(winkel)));
                        y = (suns[i].getXSpeed()*Math.sin(Math.toRadians(winkel)))+(suns[i].getYSpeed()*Math.cos(Math.toRadians(winkel)));
                        suns[i].setXSpeed((int)x);
                        suns[i].setYSpeed((int)y);
                        System.out.println(x);
                        System.out.println(y);
                    }
                    else if(a>= 0.5){
                       double winkel = (Math.random()*50)+20;
                        x = (suns[i].getXSpeed()*Math.cos(Math.toRadians(winkel)))-(suns[i].getYSpeed()*Math.sin(Math.toRadians(winkel)));
                        y = (suns[i].getXSpeed()*Math.sin(Math.toRadians(winkel)))+(suns[i].getYSpeed()*Math.cos(Math.toRadians(winkel)));
                        suns[i].setXSpeed((int)x);
                        suns[i].setYSpeed((int)y);
                        System.out.println(x);
                        System.out.println(y);
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
                    lostSuns+=1;
                    suns[i].setIngame(false);
                }
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