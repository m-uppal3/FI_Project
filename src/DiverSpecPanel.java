import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class DiverSpecPanel extends JFrame{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JPanel movePanel;
    private JTextField enterWhereMove;
    private JButton enterMove, up, down, left, right;
    private Player diver;
    private JLabel instructions;
    private GameState g;

    public DiverSpecPanel(String s, Player p, GameState game){
        super(s);
        setSize(WIDTH,HEIGHT);
        setLayout(null);
        diver = (Diver)p;
        g = game;
        Container contentPane = getContentPane();
        setLocationRelativeTo(null);

        movePanel = new JPanel(null);
        movePanel.setSize(400,300);
        movePanel.setLocation(0,0);

        instructions = new JLabel("Pick which direction you wish to dive");
        instructions.setBounds(60,40,800,30);
        instructions.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
        movePanel.add(instructions);

        up = new JButton("Up");
        up.setBounds(140, 90,80,40);
        up.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ((Diver)diver).diveUp();
                dispose();

            }
        });

        down = new JButton("Down");
        down.setBounds(140, 180,80,40);
        down.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ((Diver)diver).diveDown();
                dispose();

            }
        });

        left = new JButton("Left");
        left.setBounds(55, 135,80,40);
        left.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ((Diver)diver).diveLeft();
                dispose();

            }
        });

        right = new JButton("Right");
        right.setBounds(225, 135,80,40);
        right.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ((Diver)diver).diveRight();
                dispose();

            }
        });

        movePanel.add(up);
        movePanel.add(down);
        movePanel.add(left);
        movePanel.add(right);



        contentPane.add(movePanel);
        setVisible(true);




    }
}
