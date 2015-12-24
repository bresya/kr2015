import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bresya on 23.12.2015.
 */
public class ErrorGUI extends JFrame{
    private final JLabel error;

    ErrorGUI(String s){
        setMinimumSize(new Dimension(300,100));
        JPanel panel = new JPanel();
        error = new JLabel(s);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(15));
        panel.add(error);
        error.setAlignmentX(0.5f);
        error.setAlignmentY(0.3f);
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        ok.setAlignmentX(0.5f);
        ok.setAlignmentY(0.8f);
        panel.add(ok);
        this.add(panel);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }


}
