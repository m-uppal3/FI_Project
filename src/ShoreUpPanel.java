import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class ShoreUpPanel extends JFrame{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JPanel shorePanel;
    private JTextField enterWhereShore;
    private JButton up, down, left, right, current;
    private String whereShore;
    private Coordinate coor;
    private Player player;
    private JLabel instructions;
    private GameState g;

    public ShoreUpPanel(String s, Player p, GameState game){
        super(s);
        setSize(WIDTH,HEIGHT);
        setLayout(null);
        player = p;
        g = game;
        Container contentPane = getContentPane();
        setLocationRelativeTo(null);

        shorePanel = new JPanel(null);
        shorePanel.setSize(400,300);
        shorePanel.setLocation(0,0);

        instructions = new JLabel("Pick which tile you wish to shore up");
        instructions.setBounds(70,48,800,30);
        instructions.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
        shorePanel.add(instructions);

        up = new JButton("Up");
        up.setBounds(140, 90,80,40);
        up.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

               g.shoreupUp();
                dispose();

            }
        });

        down = new JButton("Down");
        down.setBounds(140, 180,80,40);
        down.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                g.shoreupDown();
                dispose();

            }
        });



        left = new JButton("Left");
        left.setBounds(55, 135,80,40);
        left.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                g.shoreupLeft();
                dispose();

            }
        });


        right = new JButton("Right");
        right.setBounds(225, 135,80,40);
        right.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                g.shoreupRight();
                dispose();

            }
        });
        current = new JButton("Current");
        current.setBounds(140, 135,80,40);
        current.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                g.shoreupCurrent();
                dispose();

            }
        });


        shorePanel.add(up);
        shorePanel.add(down);
        shorePanel.add(left);
        shorePanel.add(right);
        shorePanel.add(current);


        contentPane.add(shorePanel);
        setVisible(true);




    }
}
