import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by bresya on 19.12.2015.
 */
public class PlayersView extends JPanel{
    private Logic logic;

    private JPanel mainSquad, goalkeepers, midfielders, strikers, defenders;
    private ImagePanel addPlayer;

    void refresh(){
        mainSquad.removeAll();
        goalkeepers.removeAll();
        midfielders.removeAll();
        strikers.removeAll();
        defenders.removeAll();
        addMainSquad(logic.getSquad(), logic);
        addTeam(logic.getTeam(), logic);
        this.updateUI();
    }

    void addMainSquad(MainSquad squad, Logic logic){
        if (squad.getGoalkeeper()!=null){
        mainSquad.add(new PlayerPanel(squad.getGoalkeeper(),logic));
        mainSquad.add(Box.createVerticalStrut(10));}
        for (int i=0; i<squad.getDefenders().size();i++){
            mainSquad.add(new PlayerPanel(squad.getDefenders().get(i),logic));
            mainSquad.add(Box.createVerticalStrut(10));
        }
        for (int i=0; i<squad.getMidfielders().size();i++){
            mainSquad.add(new PlayerPanel(squad.getMidfielders().get(i),logic));
            mainSquad.add(Box.createVerticalStrut(10));
        }
        for (int i=0; i<squad.getStrikers().size();i++){
            mainSquad.add(new PlayerPanel(squad.getStrikers().get(i),logic));
            mainSquad.add(Box.createVerticalStrut(10));
        }
    }

    void addTeam(Team team, Logic logic){
        for (int i = 0; i < team.getGoalkeepers().size(); i++) {
            goalkeepers.add(new PlayerPanel(team.getGoalkeepers().get(i),logic));
            goalkeepers.add(Box.createVerticalStrut(10));
        }
        for (int i = 0; i < team.getDefenders().size(); i++) {
            defenders.add(new PlayerPanel(team.getDefenders().get(i),logic));
            defenders.add(Box.createVerticalStrut(10));
        }
        for (int i = 0; i < team.getMidfielders().size(); i++) {
            midfielders.add(new PlayerPanel(team.getMidfielders().get(i),logic));
            midfielders.add(Box.createVerticalStrut(10));
        }
        for (int i = 0; i < team.getStrikers().size(); i++) {
            strikers.add(new PlayerPanel(team.getStrikers().get(i),logic));
            strikers.add(Box.createVerticalStrut(10));
        }


    }

    public PlayersView(final Logic logic){
        this.setAutoscrolls(true);
        this.logic = logic;
        MainSquad squad = logic.getSquad();
        Team team = logic.getTeam();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);
        JLabel mainL = new JLabel("Main Squad");
        mainPanel.add(mainL);

        mainSquad = new JPanel();
        mainSquad.setBackground(new Color(82,172,98));
        mainSquad.setLayout(new BoxLayout(mainSquad,BoxLayout.Y_AXIS));
        mainSquad.setAlignmentX(LEFT_ALIGNMENT);
        mainSquad.setAutoscrolls(true);
        mainPanel.add(mainSquad);

        JLabel goalL = new JLabel("Goalkeepers");
        mainPanel.add(goalL);
        goalkeepers = new JPanel();
        goalkeepers.setBackground(new Color(82, 172, 98));
        goalkeepers.setLayout(new BoxLayout(goalkeepers, BoxLayout.Y_AXIS));
        goalkeepers.setAlignmentX(LEFT_ALIGNMENT);
        goalkeepers.setAutoscrolls(true);
        mainPanel.add(goalkeepers);

        JLabel defL = new JLabel("Defenders");
        mainPanel.add(defL);
        defenders = new JPanel();
        defenders.setBackground(new Color(82, 172, 98));
        defenders.setLayout(new BoxLayout(defenders, BoxLayout.Y_AXIS));
        defenders.setAlignmentX(LEFT_ALIGNMENT);
        defenders.setAutoscrolls(true);
        mainPanel.add(defenders);

        JLabel midL = new JLabel("Midfielders");
        mainPanel. add(midL);
        midfielders = new JPanel();
        midfielders.setBackground(new Color(82, 172, 98));
        midfielders.setLayout(new BoxLayout(midfielders, BoxLayout.Y_AXIS));
        midfielders.setAlignmentX(LEFT_ALIGNMENT);
        midfielders.setAutoscrolls(true);
        mainPanel. add(midfielders);

        JLabel stL = new JLabel("Strikers");
        mainPanel.  add(stL);
        strikers = new JPanel();
        strikers.setBackground(new Color(82, 172, 98));
        strikers.setLayout(new BoxLayout(strikers, BoxLayout.Y_AXIS));
        strikers.setAlignmentX(LEFT_ALIGNMENT);
        strikers.setAutoscrolls(true);
        mainPanel.add(strikers);

        addMainSquad(squad, logic);
        addTeam(team, logic);
        addPlayer = new ImagePanel("/image/add.png");
        addPlayer.setMinimumSize(new Dimension(70,30));
        addPlayer.setMaximumSize(new Dimension(70, 30));
        addPlayer.setPreferredSize(new Dimension(70, 30));
        addPlayer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddPlayer addPlayer1 = new AddPlayer(logic);
                addPlayer1.setVisible(true);
                addPlayer1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                addPlayer.setBack("/image/addH.png");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addPlayer.setBack("/image/add.png");
            }
        });
        addPlayer.setAlignmentX(LEFT_ALIGNMENT);
        mainPanel.add(addPlayer);
        mainPanel.setBackground(new Color(82, 172, 98));
        this.setBackground(new Color(82, 172, 98));

        this.add(mainPanel);

    }

    public static void main(String[] args){

    }
}
