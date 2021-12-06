import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;


public class ExplorerSpecPanel extends JFrame{

    // Explorer: Move and/or shore up diagonally
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JPanel moveSPanel, shoreSPanel, startPanel;
    private Player explorer;
    private JButton  one, two, SPleftUp, SPrightUp, SPleftDown, SPrightDown, leftUp, rightUp, leftDown, rightDown;
    private JLabel instructions, newinstructions;
    private GameState g;

    public ExplorerSpecPanel(String s, Player pl, GameState game){

        super(s);
        setSize(WIDTH,HEIGHT);
        setLayout(null);
        explorer = pl;
        g = game;
        Container contentPane = getContentPane();
        setLocationRelativeTo(null);

        startPanel = new JPanel(null);
        startPanel.setSize(400,300);
        startPanel.setLocation(0,0);
        startPanel.setVisible(true);

        one = new JButton("Move");
        one.setBounds(40, 100,140,50);

        one.addActionListener(e -> {

            startPanel.setVisible(false);
            moveSPanel.setVisible(true);

        });

        two = new JButton("Shore Up");
        two.setBounds(210, 100,140,50);

        two.addActionListener(e -> {

            startPanel.setVisible(false);
            shoreSPanel.setVisible(true);

        });




        startPanel.add(one);
        startPanel.add(two);

        moveSPanel = new JPanel(null);
        moveSPanel.setSize(400,300);
        moveSPanel.setLocation(0,0);
        moveSPanel.setVisible(false);

        shoreSPanel = new JPanel(null);
        shoreSPanel.setSize(400,300);
        shoreSPanel.setLocation(0,0);
        shoreSPanel.setVisible(false);

        instructions = new JLabel("Pick which direction you wish to move");
        instructions.setBounds(55,40,800,30);
        instructions.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
        moveSPanel.add(instructions);



        leftUp = new JButton("Up Left");
        leftUp.setBounds(55, 90,100,40);

        leftUp.addActionListener(e -> {

            ((Explorer)explorer).moveLeftUp();
            dispose();

        });

        rightUp = new JButton("Up Right");
        rightUp.setBounds(225, 90,100,40);

        rightUp.addActionListener(e -> {

            ((Explorer)explorer).moveRightUp();
            dispose();

        });


        leftDown = new JButton("Down Left");
        leftDown.setBounds(55, 135,100,40);

        leftDown.addActionListener(e -> {

            ((Explorer)explorer).moveDownLeft();
            dispose();

        });

        rightDown = new JButton("Down Right");
        rightDown.setBounds(225, 135,100,40);

        rightDown.addActionListener(e -> {

            ((Explorer)explorer).moveDownLeft();
            dispose();
        });

        //shore up stuff

        newinstructions = new JLabel("Pick which direction you wish to shore up");
        newinstructions.setBounds(55,40,800,30);
        newinstructions.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
        shoreSPanel.add(newinstructions);

        SPleftUp = new JButton("Up Left");
        SPleftUp.setBounds(55, 90,100,40);

        SPleftUp.addActionListener(e -> {

            game.shoreupLeftUp();
            dispose();

        });

        SPrightUp = new JButton("Up Right");
        SPrightUp.setBounds(225, 90,100,40);

        SPrightUp.addActionListener(e -> {

            game.shoreupRightUp();
            dispose();

        });


        SPleftDown = new JButton("Down Left");
        SPleftDown.setBounds(55, 135,100,40);

        SPleftDown.addActionListener(e -> {

           game.shoreupLeftDown();
            dispose();

        });

        SPrightDown = new JButton("Down Right");
        SPrightDown.setBounds(225, 135,100,40);

        SPrightDown.addActionListener(e -> {

            game.shoreupRightDown();
            dispose();


        });



        moveSPanel.add(leftUp);
        moveSPanel.add(rightUp);
        moveSPanel.add(rightDown);
        moveSPanel.add(leftDown);

        shoreSPanel.add(SPleftUp);
        shoreSPanel.add(SPrightDown);
        shoreSPanel.add(SPrightUp);
        shoreSPanel.add(SPleftDown);


        contentPane.add(startPanel);
        contentPane.add(shoreSPanel);
        contentPane.add(moveSPanel);
        setVisible(true);


    }


}
