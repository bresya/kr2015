

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bresya on 19.12.2015.
 */
public class ProfileView extends JPanel{
    private Player player;
    private Logic logic;
    private MainSquad squad;
    private Team team;
    private JLabel stamina;
    private JLabel pace;
    private JLabel shooting;
    private JLabel defending;
    private JLabel strength;
    private JLabel passing;

    private JLabel role;
    private JLabel age;
    private JLabel name;

    private JButton mainSquad;
    private JButton Delete= new JButton("Delete");

    private void setLabelSize(JLabel panel){
        panel.setMinimumSize(new Dimension(140,20));
        panel.setPreferredSize(new Dimension(140,20));
        panel.setMaximumSize(new Dimension(140,20));
    }

    private void setPanelSize(JPanel panel){
        panel.setMinimumSize(new Dimension(400,40));
        panel.setPreferredSize(new Dimension(400,40));
        panel.setMaximumSize(new Dimension(400,40));
    }

    void colorize(JLabel label){
        int i = Integer.parseInt(label.getText().split(":")[1].split(" ")[1]);
        if (i>85){
            label.setForeground(Color.RED);
        }
        else if (i>70){
            label.setForeground(new Color(255,190,0));
        }
        else label.setForeground(Color.GREEN);
    }

    //void refresh(){
    //    this.setPlayer(logic.getPlayer());
    //    this.updateUI();
    //}

    public void refresh() {
        this.player = logic.getPlayer();
        squad = logic.getSquad();
        team = logic.getTeam();
        stamina.setText("Stamina: " + Integer.toString(player.getStats()[0]));
        pace.setText("Pace: " + Integer.toString(player.getStats()[1]));
        shooting.setText("Shooting: " + Integer.toString(player.getStats()[2]));
        defending.setText("Defending: " + Integer.toString(player.getStats()[3]));
        strength.setText("Strength: " + Integer.toString(player.getStats()[4]));
        passing.setText("Passing: " + Integer.toString(player.getStats()[5]));

        colorize(shooting);
        colorize(stamina);
        colorize(defending);
        colorize(pace);
        colorize(passing);
        colorize(strength);

        role.setText("Role: " + player.getRole().toString());
        age.setText("Age: " + Integer.toString(player.getAge()));
        name.setText("Name: " + player.getName());
        for (ActionListener a: mainSquad.getActionListeners()){
            mainSquad.removeActionListener(a);
        }

            if (!player.isInMain()){
                mainSquad.setText("To Main Squad");
            }
            else {
                mainSquad.setText("From Main Squad");
            }
            mainSquad.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                            if (!player.isInMain()) {
                                if (squad.getDefenders().size() + squad.getMidfielders().size() + squad.getStrikers().size() != 10) {
                                    if (squad.getGoalkeeper() == null || !player.getRole().equals(Role.GOALKEEPER)) {
                                        squad.addPlayer(player);
                                        mainSquad.setText("From Main Squad");
                                    } else {
                                        ErrorGUI errorGUI = new ErrorGUI("There is a GK already");
                                    }
                                }
                                else {ErrorGUI errorGUI = new ErrorGUI("Main Squad is full");}
                            } else {
                                squad.deletePlayer(player);
                                mainSquad.setText("To Main Squad");
                            }
                            logic.setSquad(squad);
                            logic.setTeam(team);
                            logic.getPlayersView().refresh();



                }
            });



        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.isInMain()){
                    squad.deletePlayer(player);
                    team.deletePlayer(player);
                }
                else team.deletePlayer(player);
                logic.setSquad(squad);
                logic.setTeam(team);
                logic.getPlayersView().refresh();
            }
        });

        this.updateUI();
    }

    ProfileView(final Logic logic){
        this.logic = logic;
        player = logic.getPlayer();
        stamina = new JLabel("Stamina: " + Integer.toString(player.getStats()[0]));
        pace = new JLabel("Pace: " + Integer.toString(player.getStats()[1]));
        shooting = new JLabel("Shooting: " + Integer.toString(player.getStats()[2]));
        defending = new JLabel("Defending: " + Integer.toString(player.getStats()[3]));
        strength = new JLabel("Strength: " + Integer.toString(player.getStats()[4]));
        passing = new JLabel("Passing: " + Integer.toString(player.getStats()[5]));

        role = new JLabel("Role: "+ player.getRole().toString());
        age = new JLabel("Age: " + Integer.toString(player.getAge()));
        name = new JLabel("Name: " + player.getName());

        Delete= new JButton("Delete");

        this.setSize(new Dimension(500,500));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        setLabelSize(stamina);
        setLabelSize(pace);
        panel.add(stamina);
        panel.add(pace);
        panel.setMinimumSize(new Dimension(250,40));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        setLabelSize(shooting);
        setLabelSize(defending);
        panel1.add(shooting);
        panel1.add(defending);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        setLabelSize(strength);
        setLabelSize(passing);
        panel2.add(strength);
        panel2.add(passing);
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        setLabelSize(name);
        setLabelSize(age);
        setLabelSize(role);
        panel3.add(name);
        panel3.add(age);
        panel3.add(role);

        setPanelSize(panel);
        setPanelSize(panel1);
        setPanelSize(panel2);
        setPanelSize(panel3);

        mainPanel.add(panel3);
        mainPanel.add(panel);
        mainPanel.add(panel1);
        mainPanel.add(panel2);


        mainSquad = new JButton("Main Squad");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(mainSquad);
        buttonPanel.add(Box.createVerticalStrut(30));


        buttonPanel.add(Delete);

        mainPanel.add(buttonPanel);
        this.add(mainPanel);
        mainPanel.setAlignmentY(0.5f);
        mainPanel.setAlignmentX(0.5f);

        this.setVisible(true);
    }


}
