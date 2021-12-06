import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;


public class HelicopterLift extends JFrame{

    // Explorer: Move and/or shore up diagonally
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JPanel genericMoveP, escapeIslandP, startPanel;
    private Player player, receiver;
    private JButton  one, two, enter;
    private JLabel instructions, newinstructions, place;
    private JTextField whichPlayerGive, entPlace;
    private Multiplayer mul;
    private GameState g;
    private IslandMap map;
    private String givePlayer, loc;
    private String[] listPl;

    public HelicopterLift(String s, Player pl, GameState game, Multiplayer mp, IslandMap m){

        super(s);
        setSize(WIDTH,HEIGHT);
        setLayout(null);
        player = pl;
        g = game;
        mul = mp;
        map = m;
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
            genericMoveP.setVisible(true);

        });

        two = new JButton("Escape the Island");
        two.setBounds(210, 100,140,50);

        two.addActionListener(e -> {

            startPanel.setVisible(false);
            escapeIslandP.setVisible(true);

        });

        startPanel.add(one);
        startPanel.add(two);

        genericMoveP = new JPanel(null);
        genericMoveP.setSize(400,300);
        genericMoveP.setLocation(0,0);
        genericMoveP.setVisible(false);

        escapeIslandP = new JPanel(null);
        escapeIslandP.setSize(400,300);
        escapeIslandP.setLocation(0,0);
        escapeIslandP.setVisible(false);

        instructions = new JLabel("Enter name/s of desired player/s to move");
        instructions.setBounds(45,42,800,20);
        JLabel in = new JLabel("(ex: Navigator, Explorer)");
        in.setBounds(45,62,800,20);


        genericMoveP.add(in);
        genericMoveP.add(instructions);
        whichPlayerGive = new JTextField("");
        whichPlayerGive.setBounds(45,90,300,20);

        place = new JLabel("Enter name of location");
        place.setBounds(45,132,250,10);

        entPlace = new JTextField("");
        entPlace.setBounds(45,150, 300,20);


        enter = new JButton("Enter");
        enter.setBounds(160, 185, 80, 30);
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                givePlayer = whichPlayerGive.getText();
                loc = entPlace.getText();

                listPl = givePlayer.split(", ");

                if(listPl.length == 1){
                   game.useHelicopterLift(player, map.getTile(loc));
                }
                else {
                    for (int i = 0; i < listPl.length; i++) {

                        String pl = listPl[i];
                        game.useHelicopterLift(player, getReceiver(pl), map.getTile(loc));

                    }
                }

                dispose();
            }
        });

        genericMoveP.add(place);
        genericMoveP.add(entPlace);
        genericMoveP.add(whichPlayerGive);
        genericMoveP.add(enter);


        //useHelicopterLift(Player p, IslandTile tile)
        //useHelicopterLift(Player giver, Player receiver, IslandTile tile)



        //shore up stuff

        newinstructions = new JLabel("Congratulations! You have escaped Forbidden Island!");
        newinstructions.setBounds(20,80,800,30);
        newinstructions.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));

        JButton ex = new JButton("Exit");
        ex.setBounds(140, 130, 80, 30);
        ex.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



        escapeIslandP.add(newinstructions);
        escapeIslandP.add(ex);


        contentPane.add(startPanel);
        contentPane.add(escapeIslandP);
        contentPane.add(genericMoveP);
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
