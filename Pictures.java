import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
public class Pictures{
    private static BufferedImage background,sun,flower,start,options,credits,exit;
    
    public Pictures(){
        background = bildHinzufuegen("Bilder//background.png");
        sun = bildHinzufuegen("Bilder//sonne.png");
        flower = bildHinzufuegen("Bilder//blume.png");
        start = bildHinzufuegen("Bilder//start.png");
        options = bildHinzufuegen("Bilder//options.png");
        credits = bildHinzufuegen("Bilder//credits.png");
        exit = bildHinzufuegen("Bilder//exit.png");
    }

    public BufferedImage bildHinzufuegen(String pfad){
        BufferedImage img = null;
        try {       img = ImageIO.read(getClass().getResource(pfad));
        } catch (IOException e) {}
        return  img;
    }

    public BufferedImage bildZerlegen(BufferedImage image, int x, int y, int b, int h){
        BufferedImage img = null;
        img = image.getSubimage(x,y,b,h);
        return  img;
    }

    public static BufferedImage getBackground(){
        return background;
    }
    
    public static BufferedImage getSun(){
        return sun;
    }
    
    public static BufferedImage getFlower(){
        return flower;
    }
    
    public static BufferedImage getStart(){
        return start;
    }
    
    public static BufferedImage getOptions(){
        return options;
    }
    
    public static BufferedImage getCredits(){
        return credits;
    }
    
    public static BufferedImage getExit(){
        return exit;
    }
}