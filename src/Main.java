import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bresya on 19.12.2015.
 */
public class Main extends JFrame{
    Player player;
    private final PlayersView playersView;
    private final ProfileView profileView;
    //private final JButton addPlayer = new JButton("Add Player");
    private final Logic logic;
    private final JScrollPane jScrollPane;

    void refresh(){
        playersView.refresh();
        profileView.refresh();
        profileView.updateUI();
        playersView.updateUI();
        jScrollPane.updateUI();
        jScrollPane.repaint();
    }

    Main(final Logic logic){
        this.logic = logic;
        playersView = logic.getPlayersView();
        profileView = logic.getProfileView();
        JPanel panel = new JPanel();
        jScrollPane = new JScrollPane(playersView);
        jScrollPane.setPreferredSize(new Dimension(180,400));
        jScrollPane.setMaximumSize(new Dimension(180, 400));
        jScrollPane.setMinimumSize(new Dimension(180, 400));
        setMinimumSize(new Dimension(800, 400));
        setMaximumSize(new Dimension(800, 400));
        setPreferredSize(new Dimension(800, 400));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        jScrollPane.setAutoscrolls(true);
        panel.add(jScrollPane);
        panel.add(profileView);


        this.add(panel);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setPlayer(){

    }
}
