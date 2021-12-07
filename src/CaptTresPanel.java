import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CaptTresPanel extends JFrame{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JPanel captPanel;
    private JButton fire, water, wind, earth;
    private Player player;
    private JLabel instructions;
    private GameState g;

    public CaptTresPanel(String s, Player p, GameState game){
        super(s);
        setSize(WIDTH,HEIGHT);
        setLayout(null);
        player = p;
        g = game;
        Container contentPane = getContentPane();
        setLocationRelativeTo(null);
        captPanel = new JPanel(null);
        captPanel.setSize(400,300);
        captPanel.setLocation(0,0);

        instructions = new JLabel("Pick which treasure you wish to capture");
        instructions.setBounds(55,40,800,30);
        instructions.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
        captPanel.add(instructions);

        fire = new JButton();
        fire.setBounds(16,100,80,80);
        try {
            Image img = ImageIO.read(getClass().getResource("Fire.png"));
            Image newimg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            fire.setIcon(new ImageIcon(newimg));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        fire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                g.captureFire();
               dispose();
            }
        });

        earth = new JButton();
        earth.setBounds(107,100,80,80);
        try {
            Image img = ImageIO.read(getClass().getResource("stone.png"));
            Image newimg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            earth.setIcon(new ImageIcon(newimg));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        earth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                g.captureEarth();
               dispose();

            }
        });


        water = new JButton();
        water.setBounds(199,100,80,80);
        try {
            Image img = ImageIO.read(getClass().getResource("water.png"));
            Image newimg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            water.setIcon(new ImageIcon(newimg));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        water.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                g.captureWater();
               dispose();

            }
        });


        wind = new JButton();
        wind.setBounds(289,100,80,80);
        try {
            Image img = ImageIO.read(getClass().getResource("wind.png"));
            Image newimg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            wind.setIcon(new ImageIcon(newimg));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        wind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                g.captureWind();
               dispose();

            }
        });

        captPanel.add(fire);
        captPanel.add(wind);
        captPanel.add(earth);
        captPanel.add(water);




        contentPane.add(captPanel);
        setVisible(true);




    }
}
