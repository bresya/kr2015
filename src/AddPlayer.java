import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bresya on 19.12.2015.
 */

public class AddPlayer extends JFrame{
    Logic logic;

    private final JTextField name = new JTextField(15);
    private final JTextField age = new JTextField(3);
    private final JComboBox<Role> roleJComboBox = new JComboBox<Role>();
    private final JTextField stamina = new JTextField(3);
    private final JTextField pace = new JTextField(3);
    private final JTextField defending = new JTextField(3);
    private final JTextField passing = new JTextField(3);
    private final JTextField strength = new JTextField(3);
    private final JTextField shooting = new JTextField(3);
    private final JLabel nameL;
    private final JLabel ageL;
    private final JLabel roleL;
    private final JLabel stamL;
    private final JLabel paceL;
    private final JLabel defL;
    private final JLabel passL;
    private final JLabel strL;
    private final JLabel shL;
    private final JButton Add = new JButton("Add");

    void setTextFieldSize(JTextField jTextField){
        jTextField.setMinimumSize(new Dimension(40,20));
        jTextField.setMaximumSize(new Dimension(40, 20));
    }
    AddPlayer(final Logic logic){
        name.setMinimumSize(new Dimension(150, 20));
        name.setMaximumSize(new Dimension(150, 20));
        name.setPreferredSize(new Dimension(150, 20));
        setTextFieldSize(age);
        setTextFieldSize(stamina);
        setTextFieldSize(pace);
        setTextFieldSize(defending);
        setTextFieldSize(passing);
        setTextFieldSize(strength);
        setTextFieldSize(shooting);

        nameL = new JLabel("Name");
        ageL = new JLabel("Age");
        roleL= new JLabel("Role");
        stamL= new JLabel("Stamina");
        paceL= new JLabel("Pace");
        defL= new JLabel("Defence");
        passL= new JLabel("Passing");
        strL= new JLabel("Strength");
        shL= new JLabel("Shooting");

        roleJComboBox.setMaximumSize(new Dimension(200, 20));
        roleJComboBox.addItem(Role.GK);
        roleJComboBox.addItem(Role.LB);
        roleJComboBox.addItem(Role.RB);
        roleJComboBox.addItem(Role.CB);
        roleJComboBox.addItem(Role.CM);
        roleJComboBox.addItem(Role.LM);
        roleJComboBox.addItem(Role.RM);
        roleJComboBox.addItem(Role.CAM);
        roleJComboBox.addItem(Role.ST);
        roleJComboBox.addItem(Role.RW);
        roleJComboBox.addItem(Role.LW);
        this.setMaximumSize(new Dimension(350,250));
        this.setMinimumSize(new Dimension(350, 250));
        this.setPreferredSize(new Dimension(350, 250));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        JPanel nameP = new JPanel();
        nameP.setLayout(new BoxLayout(nameP, BoxLayout.Y_AXIS));
        nameP.add(nameL);
        nameL.setAlignmentX(CENTER_ALIGNMENT);
        nameP.add(name);
        name.setAlignmentX(CENTER_ALIGNMENT);
        JPanel ageP = new JPanel();
        ageP.setLayout(new BoxLayout(ageP, BoxLayout.Y_AXIS));
        ageP.add(ageL);
        ageL.setAlignmentX(CENTER_ALIGNMENT);
        ageP.add(age);
        age.setAlignmentX(CENTER_ALIGNMENT);
        JPanel roleP = new JPanel();
        roleP.setLayout(new BoxLayout(roleP, BoxLayout.Y_AXIS));
        roleP.add(roleL);
        roleL.setAlignmentX(CENTER_ALIGNMENT);
        roleP.add(roleJComboBox);
        roleJComboBox.setAlignmentX(CENTER_ALIGNMENT);
        roleP.setAlignmentX(RIGHT_ALIGNMENT);
        JPanel stamP = new JPanel();
        stamP.setLayout(new BoxLayout(stamP, BoxLayout.Y_AXIS));
        stamP.add(stamL);
        stamP.add(stamina);
        JPanel paceP = new JPanel();
        paceP.setLayout(new BoxLayout(paceP, BoxLayout.Y_AXIS));
        paceP.add(paceL);
        paceP.add(pace);
        JPanel defP = new JPanel();
        defP.setLayout(new BoxLayout(defP, BoxLayout.Y_AXIS));
        defP.add(defL);
        defP.add(defending);
        JPanel passP = new JPanel();
        passP.setLayout(new BoxLayout(passP, BoxLayout.Y_AXIS));
        passP.add(passL);
        passP.add(passing);
        JPanel shootP = new JPanel();
        shootP.setLayout(new BoxLayout(shootP, BoxLayout.Y_AXIS));
        shootP.add(shL);
        shootP.add(shooting);
        JPanel strP = new JPanel();
        strP.setLayout(new BoxLayout(strP, BoxLayout.Y_AXIS));
        strP.add(strL);
        strP.add(strength);

        JPanel nar = new JPanel();
        nar.setLayout(new BoxLayout(nar,BoxLayout.X_AXIS));
        nar.add(nameP);
        nar.add(ageP);
        nar.add(roleP);
        JPanel spd = new JPanel();
        spd.setLayout(new BoxLayout(spd,BoxLayout.X_AXIS));
        spd.add(stamP);
        spd.add(paceP);
        spd.add(defP);
        JPanel pss = new JPanel();
        pss.setLayout(new BoxLayout(pss,BoxLayout.X_AXIS));
        pss.add(passP);
        pss.add(shootP);
        pss.add(strP);
        mainPanel.add(nar);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(spd);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(pss);

        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!stamina.getText().isEmpty() && !name.getText().isEmpty() && !age.getText().isEmpty() && !shooting.getText().isEmpty() && !pace.getText().isEmpty() && !defending.getText().isEmpty() && !strength.getText().isEmpty() && !passing.getText().isEmpty()) {
                    if(Integer.parseInt(age.getText())>0 && Integer.parseInt(age.getText())<100 &&Integer.parseInt(stamina.getText())>0 && Integer.parseInt(stamina.getText())<100 &&Integer.parseInt(strength.getText())>0 && Integer.parseInt(strength.getText())<100 &&Integer.parseInt(passing.getText())>0 && Integer.parseInt(shooting.getText())<100 &&Integer.parseInt(shooting.getText())>0 && Integer.parseInt(shooting.getText())<100 &&Integer.parseInt(defending.getText())>0 && Integer.parseInt(defending.getText())<100 &&Integer.parseInt(pace.getText())>0 && Integer.parseInt(pace.getText())<100){
                        int[] stats = {Integer.parseInt(stamina.getText()), Integer.parseInt(pace.getText()), Integer.parseInt(shooting.getText()), Integer.parseInt(defending.getText()), Integer.parseInt(strength.getText()), Integer.parseInt(passing.getText())};
                        logic.getTeam().addPlayer(new Player(name.getText(), Integer.parseInt(age.getText()), false, (Role) roleJComboBox.getSelectedItem(), stats));
                        logic.refresh();
                        logic.addPlayersToFile();
                        dispose();
                    }
                    else{
                        ErrorGUI errorGUI = new ErrorGUI("All values must be in a range of 1..99");
                    }

                }
                else {
                    ErrorGUI errorGUI = new ErrorGUI("Please fill all fields");
                }
            }
        });
        mainPanel.add(Add);
        this.add(mainPanel);
    }
}
