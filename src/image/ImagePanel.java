package image;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bresya on 24.12.2015.
 */
public class ImagePanel extends JPanel{
    private final ImageIcon background;
    public ImagePanel(ImageIcon i){
        this.background = i;
    }
    public void paint(Graphics g){
        g.drawImage(background.getImage(),0,0,this);
        super.paint(g);
    }
}
