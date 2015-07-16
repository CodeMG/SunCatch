import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    private GamePanel panel;
    private MainMenue menue;
    public Frame(){
        pack();
        setSize(800,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(3);
        new Pictures();
        
        int decorationWidth = getInsets().left + getInsets().right;
        int decorationHeight = getInsets().top + getInsets().bottom;
        int frameWidth = getWidth() - decorationWidth;
        int frameHeight = getHeight() - decorationHeight;
        
        setSize(800+decorationWidth,600+decorationHeight);
        
        menue = new MainMenue(getWidth(),getHeight(),this);
        add(menue);
        setVisible(true);
    }

    public void showGamePanel(){
        menue.setVisible(false);
        panel = new GamePanel(800,600);
        add(panel);
    }
    
}