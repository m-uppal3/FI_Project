import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;


public class EngineerSpecPanel extends JFrame{

    // Engineer: Shore up 2 tiles for 1 action
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JPanel moveSPanel;
    private Player player;
    private JLabel instructions;
    private JButton enter;
    private GameState g;

    public EngineerSpecPanel(String s, Player p, GameState game){

        super(s);
        setSize(WIDTH,HEIGHT);
        setLayout(null);
        player = p;
        g = game;
        Container contentPane = getContentPane();
        setLocationRelativeTo(null);

        //use the drop down for all of the possible combinations

        String[] choices = {"Right", "Left", "Down", "Up", "Current"};
        final JComboBox<String> first = new JComboBox<String>(choices);
        final JComboBox<String> second = new JComboBox<String>(choices);

        first.setBounds(80, 110,80,20);
        second.setBounds(240, 110,80,20);

        moveSPanel = new JPanel(null);
        moveSPanel.setSize(400,300);
        moveSPanel.setLocation(0,0);


        enter = new JButton("Enter");
        enter.setBounds(160, 185, 80, 30);
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String f = (String) first.getSelectedItem();
                String s = (String) second.getSelectedItem();

                boolean fLeft = f.equals("Left");
                boolean fRight = f.equals("Right");
                boolean fDown = f.equals("Down");
                boolean fUp = f.equals("Up");
                boolean fCurrent = f.equals("Current");

                boolean sLeft = s.equals("Left");
                boolean sRight = s.equals("Right");
                boolean sDown = s.equals("Down");
                boolean sUp = s.equals("Up");
                boolean sCurrent = s.equals("Current");

                if( (fLeft || sLeft) && (fUp || sUp)){
                    game.shoreupLeftAndUp();
                }
                else if( (fLeft || sLeft) && (fDown || sDown) ){
                    game.shoreupLeftAndDown();
                }
                else if ( (fLeft || sLeft) && (fRight || sRight) ){
                    game.shoreupLeftAndRight();
                }
                else if( (fUp || sUp) && (fRight || sRight)){
                    game.shoreupUpAndRight();
                }
                else if((fUp || sUp)&& (fDown || sDown) ){
                    game. shoreupUpAndDown();
                }
                else if((fDown || sDown)&& (fRight || sRight)){
                    game.shoreupDownAndRight();
                }
                else if((fCurrent || sCurrent) && (fUp || sUp) ){
                    game.shoreupCurrentAndUp();
                }
                else if((fCurrent || sCurrent) && (fDown || sDown)){
                    game.shoreupCurrentAndDown();
                }
                else if((fCurrent || sCurrent) && (fLeft || sLeft)){
                    game.shoreupCurrentAndLeft();
                }
                else if((fCurrent || sCurrent) && (fRight || sRight) ) {
                    game.shoreupCurrentAndRight();
                }


                dispose();




            }
        });

        instructions = new JLabel("Pick which directions you wish to move");
        instructions.setBounds(70,60,800,30);
        instructions.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
        moveSPanel.add(instructions);

        moveSPanel.add(first);
        moveSPanel.add(second);
        moveSPanel.add(enter);
        contentPane.add(moveSPanel);
        setVisible(true);


    }


}
