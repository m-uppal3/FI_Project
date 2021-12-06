import java.awt.*;
import javax.swing.*;


public class NavigatorSpecPanel extends JFrame{

    // Explorer: Move and/or shore up diagonally

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JPanel oneTilePanel, twoTilePanel, startPanel;
    private Player navigator;
    private JLabel instructions, Ninstructions, newIn;
    private JButton one, two, enter, enter2;
    private JTextField location, location2;
    private Multiplayer mul;
    private GameState g;
    private Player receiver;

    public NavigatorSpecPanel(String s, Player pl, GameState game, Multiplayer mp){

        super(s);
        setSize(WIDTH,HEIGHT);
        setLayout(null);
        navigator = pl;
        g = game;
        mul = mp;
        Container contentPane = getContentPane();
        setLocationRelativeTo(null);

        startPanel = new JPanel(null);
        startPanel.setSize(400,300);
        startPanel.setLocation(0,0);
        startPanel.setVisible(true);

        oneTilePanel = new JPanel(null);
        oneTilePanel.setSize(400,300);
        oneTilePanel.setLocation(0,0);
        oneTilePanel.setVisible(false);

        twoTilePanel = new JPanel(null);
        twoTilePanel.setSize(400,300);
        twoTilePanel.setLocation(0,0);
        twoTilePanel.setVisible(false);


        instructions = new JLabel("Select the number of tiles desired to move");
        instructions.setBounds(55,50,800,30);
        instructions.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
        startPanel.add(instructions);


        one = new JButton("1");
        one.setBounds(65, 110,100,50);

        one.addActionListener(e -> {

            startPanel.setVisible(false);
            oneTilePanel.setVisible(true);

        });

        two = new JButton("2");
        two.setBounds(215, 110,100,50);

        two.addActionListener(e -> {

            startPanel.setVisible(false);
            twoTilePanel.setVisible(true);

        });


        Ninstructions = new JLabel("Enter player you wish to move");
        Ninstructions.setBounds(100,65,800,30);
        Ninstructions.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
        oneTilePanel.add(Ninstructions);

        newIn = new JLabel("Enter player you wish to move");
        newIn.setBounds(100,65,800,30);
        newIn.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
        twoTilePanel.add(newIn);


        String[] choices = {"Right", "Left", "Down", "Up"};
        JComboBox<String> first = new JComboBox<String>(choices);
        JComboBox<String> first1 = new JComboBox<String>(choices);
        JComboBox<String> second = new JComboBox<String>(choices);

        first.setBounds(80, 150,80,20);
        first1.setBounds(160, 150,80,20);
        second.setBounds(240, 150,80,20);

        oneTilePanel.add(first1);
        twoTilePanel.add(first);
        twoTilePanel.add(second);

        location = new JTextField("");
        location.setBounds(45,110,300,20);

        enter = new JButton("Enter");
        enter.setBounds(160, 200, 80, 30);
        enter.addActionListener(e -> {
            String receiver = location.getText();
            String direc = (String) first.getSelectedItem();
            mul.navigatorSpecialAction((Navigator) navigator, getReceiver(receiver), direc);
            dispose();
        });

        oneTilePanel.add(enter);
        oneTilePanel.add(location);

        location2 = new JTextField("");
        location2.setBounds(45,110,300,20);

        enter2 = new JButton("Enter");
        enter2.setBounds(160, 200, 80, 30);
        enter2.addActionListener(e -> {
            String receiver2 = location2.getText();
            String direc1 = (String) first.getSelectedItem();
            String direc2 = (String) second.getSelectedItem();
            mul.navigatorSpecialAction((Navigator) navigator, getReceiver(receiver2), direc1, direc2);
            dispose();

        });

        twoTilePanel.add(enter2);
        twoTilePanel.add(location2);



        startPanel.add(one);
        startPanel.add(two);




        



        contentPane.add(startPanel);
        contentPane.add(twoTilePanel);
        contentPane.add(oneTilePanel);
        setVisible(true);


    }

    public Player getReceiver(String s){


        switch (s) {
            case "engineer":
                receiver = mul.getEngineer() ;
                break;
            case "messenger":
                receiver = mul.getMessenger();
                break;
            case "diver":
                receiver = mul.getDiver();
                break;
            case "explorer":
                receiver = mul.getExplorer();
                break;
            case "pilot":
                receiver = mul.getPilot();
                break;
        }

        return receiver;
    }

}
