import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainMenue extends JPanel implements ActionListener{
    private JButton start,options,credits,exit;
    private Frame container;
    public MainMenue(int width,int height,Frame container){
        setSize(width,height);
        setLayout(null);
        
        start = new JButton(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(Pictures.getStart(),0,0,this);
            }
        };
        start.setBackground(new Color(0,0,0,0f));
        start.setBounds((int)(width*0.5-100),25,200,100);
        start.addActionListener(this);
        add(start);
        
        options = new JButton(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(Pictures.getOptions(),0,0,this);
            }
        };
        options.setBackground(new Color(0,0,0,0f));
        options.setBounds((int)(width*0.5-100),175,200,100);
        options.addActionListener(this);
        add(options);
        
        credits = new JButton(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(Pictures.getCredits(),0,0,this);
            }
        };
        credits.setBackground(new Color(0,0,0,0f));
        credits.setBounds((int)(width*0.5-100),325,200,100);
        credits.addActionListener(this);
        add(credits);
        
        exit = new JButton(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(Pictures.getExit(),0,0,this);
            }
        };
        exit.setBackground(new Color(0,0,0,0f));
        exit.setBounds((int)(width*0.5-100),475,200,100);
        exit.addActionListener(this);
        add(exit);
        
        this.container = container;
        
        setVisible(true);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(Pictures.getBackground(),0,0,this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == start){
            container.showGamePanel();
        }
        else if(e.getSource() == options){
            
        }
        else if(e.getSource() == credits){
            
        }
        else if(e.getSource() == exit){
            System.exit(0);
        }
    }
}