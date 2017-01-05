package SpaceConcordiaAvionics;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class GUI {

    private JPanel mainPanel;
    private JFrame groundControl;

    private JPanel headerPanel;
    private JPanel southPanel;
    private JPanel dataPanel;
    private JLabel altitudeLabel;
    private JLabel latitudeLabel;
    private JLabel longitudeLabel;
    private JLabel accelXLabel;
    private JLabel accelYLabel;
    private JLabel accelZLabel;
    private JLabel gyroXLabel;
    private JLabel gyroYLabel;
    private JLabel gyroZLabel;
    private JLabel windVelocityLabel;
    private JLabel finStrainLabel;
    private JLabel logoLabel;

    // TODO getters for graph datas

    public GUI(){
        initialize();
    }

    private void initialize(){
        groundControl = new JFrame("Ground Station");
        groundControl.getContentPane().add(mainPanel);
        groundControl.setExtendedState(JFrame.MAXIMIZED_BOTH);
        groundControl.setBounds(100, 100, 1233, 836);
        groundControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logoLabel.setIcon(new ImageIcon(getClass().getResource("logo.png")));
        groundControl.setVisible(true);
    }

    public void updateLabels(String[] filterPacket){

        // TODO determine array order and handle edge cases
        altitudeLabel.setText(filterPacket[0]);
        latitudeLabel.setText(filterPacket[1]);
        longitudeLabel.setText(filterPacket[2]);
        accelXLabel.setText(filterPacket[3]);
        accelYLabel.setText(filterPacket[4]);
        accelZLabel.setText(filterPacket[5]);
        gyroXLabel.setText(filterPacket[6]);
        gyroYLabel.setText(filterPacket[7]);
        gyroZLabel.setText(filterPacket[8]);
        windVelocityLabel.setText(filterPacket[9]);
        finStrainLabel.setText(filterPacket[10]);

    }
}
