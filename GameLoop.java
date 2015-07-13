import java.awt.*;

public class GameLoop extends Thread{
    private GamePanel panel;
    public GameLoop(GamePanel panel){
        this.panel = panel;
        start();
    }
    
    public void run(){
        while(true){
            panel.berechnen();
            panel.repaint();
            try{
                sleep(100);
            }
            catch(Exception e){
                
            }
        }
    }
    
}