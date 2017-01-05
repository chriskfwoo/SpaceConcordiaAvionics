package SpaceConcordiaAvionics;

import com.digi.xbee.api.XBeeDevice;
import com.digi.xbee.api.exceptions.XBeeException;
import com.digi.xbee.api.models.XBeeMessage;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static void main(String[] args) {

        GUI groundControl = new GUI();
        GraphGUI groundControlGraphs = new GraphGUI(groundControl);

        // parameter: serial port and baud rate
        XbeeListener groundXbee = new XbeeListener("COM1",9600);


        try {
            groundXbee.getDevice().open();
        } catch (XBeeException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // TODO Only read data when launch?

        // read packets every 3 times a second
        Runnable fixRun = () -> {

            // returns an XBeeMessage object containing the a byte data and the source address of the remote node that sent the data
            XBeeMessage xbeeMessage = groundXbee.getDevice().readData();

            // returns the data of the message in string format.
            String packet = xbeeMessage.getDataString();

            // TODO testing for reading device
            System.out.println(packet+"\n");

            // save the packets to a file
            groundXbee.savePackets(packet);

            // filter and update data for GUI
            String[] arrayPacket = groundXbee.filterPacket(packet);
            groundControl.updateLabels(arrayPacket);
            groundControlGraphs.updateGraphs();

        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(fixRun, 0, 333, TimeUnit.MILLISECONDS);

        // close the device
        groundXbee.getDevice().close();

    }
}
