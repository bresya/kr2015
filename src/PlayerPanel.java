import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by bresya on 19.12.2015.
 */
class PlayerPanel extends JPanel{
    private Player player;
    private ImageIcon imageIcon;

    PlayerPanel(final Player player, final Logic logic){
        this.player = player;
        setLayout(null);
        setBackground(new Color(62,105,69));
        setMinimumSize(new Dimension(160, 25));
        setMaximumSize(new Dimension(160, 25));
        setPreferredSize(new Dimension(160,25));
        JLabel label = new JLabel();
        label.setBounds(10, 0, 160, 25);
        switch (player.getRole()){
            case GK:
                imageIcon = new ImageIcon("src/image/gk.png");
                break;
            case CB:
                imageIcon = new ImageIcon("src/image/def.png");
                break;
            case RB:
                imageIcon = new ImageIcon("src/image/rb.png");
                break;
            case LB:
                imageIcon = new ImageIcon("src/image/lb.png");
                break;
            case CM:
                imageIcon = new ImageIcon("src/image/mf.png");
                break;
            case RM:
                imageIcon = new ImageIcon("src/image/rm.png");
                break;
            case LM:
                imageIcon = new ImageIcon("src/image/lm.png");
                break;
            case CAM:
                imageIcon = new ImageIcon("src/image/cam.png");
                break;
            case RW:
                imageIcon = new ImageIcon("src/image/rw.png");
                break;
            case LW:
                imageIcon = new ImageIcon("src/image/lw.png");
                break;
            case ST:
                imageIcon = new ImageIcon("src/image/st.png");
                break;
        }
        label.setText(player.getName());
        label.setIcon(imageIcon);
        add(label);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logic.setPlayer(player);
                logic.getProfileView().refresh();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    boolean isInMain(){
        return player.isInMain();
    }
}
