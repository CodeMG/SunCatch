import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    private GamePanel panel;
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

		panel = new GamePanel(getWidth(),getHeight());
		add(panel);
		
		setVisible(true);
    }
    
    
}