import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;


public class PilotSpecPanel extends JFrame{

    // Once per turn, fly to any tile on the island for 1 action
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JPanel moveSPanel;
    private Player player;
    private JLabel instructions;
    private JButton enter;
    private JTextField location;
    private String place;
    private GameState g;
    private Coordinate coor;

    public PilotSpecPanel(String s, Player p, GameState game){

        super(s);
        setSize(WIDTH,HEIGHT);
        setLayout(null);
        player = p;
        g = game;
        Container contentPane = getContentPane();
        setLocationRelativeTo(null);

        moveSPanel = new JPanel(null);
        moveSPanel.setSize(400,300);
        moveSPanel.setLocation(0,0);

        instructions = new JLabel("Enter the name of place you wish to move");
        instructions.setBounds(55,65,800,30);
        instructions.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
        moveSPanel.add(instructions);

        location = new JTextField("");
        location.setBounds(45,110,300,20);

        enter = new JButton("Enter");
        enter.setBounds(160, 145, 80, 30);
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                place = location.getText();
                IslandMap bo = g.getGameBoard();
                IslandTile[][] sa = bo.getIslandMap();

                for(int r = 0; r < sa.length; r++){
                    for(int c = 0; c < sa[r].length; c++){

                        ;
                        if (sa[r][c].getName().equals(place)){
                             coor = sa[r][c].getCoordinate();
                        }

                    }
                }

                player.setCoordinate(coor);
                dispose();
            }
        });

        moveSPanel.add(enter);
        moveSPanel.add(location);

        contentPane.add(moveSPanel);
        setVisible(true);


    }


}
