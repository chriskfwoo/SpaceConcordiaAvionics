package SpaceConcordiaAvionics;


import com.digi.xbee.api.XBeeDevice;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class XbeeListener {

    // TODO Replace with the serial port where your receiver module is connected.
    //private static final String PORT = "COM1";

    // TODO Replace with the baud rate of you receiver module.
    //private static final int BAUD_RATE = 9600;

    XBeeDevice groundXbee;

    public XbeeListener(String PORT, int BAUD_RATE){
        groundXbee = new XBeeDevice(PORT, BAUD_RATE);
    }

    public XBeeDevice getDevice(){
        return groundXbee;
    }

    public String[] filterPacket(String p){

        // TODO filter the string
        String[] packet = p.split(",");
        return packet;
    }

    public void savePackets(String packet){

        // TODO save data packets into a text file
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("data_logs.txt", true));
            pw.write(packet+"\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
















//            if (xbeeMessage != null)
//                System.out.format("From %s >> %s | %s%n", xbeeMessage.getDevice().get64BitAddress(),
//                        HexUtils.prettyHexString(HexUtils.byteArrayToHexString(xbeeMessage.getData())),
//                        new String(xbeeMessage.getData()));