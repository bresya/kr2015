import javax.swing.*;
import java.awt.*;

/**
 * Created by bresya on 24.12.2015.
 */
public class ImagePanel extends JPanel{
    private Image background;
    public ImagePanel(String s){
        this.background = Toolkit.getDefaultToolkit().createImage(s);
    }

    public void setBack(String s){
        this.background = Toolkit.getDefaultToolkit().createImage(s);
        this.updateUI();
    }
    public void paint(Graphics g){
        g.drawImage(background,0,0,this);
        super.paint(g);
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }
}
