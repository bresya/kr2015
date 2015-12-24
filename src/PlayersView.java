import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bresya on 19.12.2015.
 */
public class PlayersView extends JPanel{
    private Logic logic;

    private JPanel mainSquad, goalkeepers, midfielders, strikers, defenders;
    private JButton addPlayer;

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
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);
        JLabel mainL = new JLabel("Main Squad");
        add(mainL);

        mainSquad = new JPanel();
        mainSquad.setLayout(new BoxLayout(mainSquad,BoxLayout.Y_AXIS));
        mainSquad.setAlignmentX(LEFT_ALIGNMENT);
        mainSquad.setAutoscrolls(true);
        add(mainSquad);

        JLabel goalL = new JLabel("Goalkeepers");
        add(goalL);
        goalkeepers = new JPanel();
        goalkeepers.setLayout(new BoxLayout(goalkeepers,BoxLayout.Y_AXIS));
        goalkeepers.setAlignmentX(LEFT_ALIGNMENT);
        goalkeepers.setAutoscrolls(true);
        add(goalkeepers);

        JLabel defL = new JLabel("Defenders");
        add(defL);
        defenders = new JPanel();
        defenders.setLayout(new BoxLayout(defenders, BoxLayout.Y_AXIS));
        defenders.setAlignmentX(LEFT_ALIGNMENT);
        defenders.setAutoscrolls(true);
        add(defenders);

        JLabel midL = new JLabel("Midfielders");
        add(midL);
        midfielders = new JPanel();
        midfielders.setLayout(new BoxLayout(midfielders, BoxLayout.Y_AXIS));
        midfielders.setAlignmentX(LEFT_ALIGNMENT);
        midfielders.setAutoscrolls(true);
        add(midfielders);

        JLabel stL = new JLabel("Strikers");
        add(stL);
        strikers = new JPanel();
        strikers.setLayout(new BoxLayout(strikers, BoxLayout.Y_AXIS));
        strikers.setAlignmentX(LEFT_ALIGNMENT);
        strikers.setAutoscrolls(true);
        add(strikers);

        addMainSquad(squad,logic);
        addTeam(team, logic);
        addPlayer = new JButton("Add Player");
        addPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPlayer addPlayer1 = new AddPlayer(logic);
                addPlayer1.setVisible(true);
                addPlayer1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            }
        });
        this.add(addPlayer);

    }

    public static void main(String[] args){

    }
}
