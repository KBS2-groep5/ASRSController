package ASRSController;

import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Arduino {
    private SerialPort port;

    Arduino(String portDescriptor) throws InterruptedException {
        this.port = SerialPort.getCommPort(portDescriptor);
        port.setComPortParameters(9600, 8, 1, 0);
        port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
        port.openPort();

        // this fucking library
        Thread.sleep(2000);
        port.readBytes(new byte[]{0}, 1);
    }

    static String[] getComPorts() {
        String[] ports = new String[SerialPort.getCommPorts().length];
        int i = 0;
        for (SerialPort loopPort : SerialPort.getCommPorts()) {
            ports[i] = loopPort.getDescriptivePortName();
            i++;
        }
        return ports;
    }

    void write(byte[] bytes) throws IOException, InterruptedException {
        if(this.port.isOpen()) {
            this.port.getOutputStream().write(bytes);
            this.port.getOutputStream().flush();
            Thread.sleep(1000);
        }   else {
            System.out.println("Port is not open!");
        }

    }
    //TODO: Poort moet daarna nog gesloten worden, maar wanneer..?
    void sendCommand(String command) throws InterruptedException {
        try {
            this.write(command.getBytes("UTF-8"));

        } catch (IOException e) {
            System.out.println("Failed to send command:");
            e.printStackTrace();
        }
    }

    static List<String> getTSPCommands(List<Package> packageList){
        List<String> commands = new ArrayList<>();
        commands.add("g");
        commands.add("f");
        commands.add("h");
        int x = 0;
        int y = 4;
        for(int c = 0; c < packageList.size(); c++){
            Package t = packageList.get(c);
            for(x = x; x < t.getX(); x++){
                commands.add("b");
            }
            for(x = x; x > t.getX(); x--){
                commands.add("a");
            }
            for(y = y; y < t.getY(); y++){
                commands.add("d");
            }
            for(y = y; y > t.getY(); y--){
                commands.add("c");
            }
            commands.add("e");
            x = t.getX();
            y = t.getY();
        }
        commands.add("i");
        return commands;
    }


    int bytesAvailable() {
        return this.port.bytesAvailable();
    }

    int readBytes(byte[] readBuffer) {
        return this.port.readBytes(readBuffer, readBuffer.length);
    }

    void close() {
        this.port.closePort();
    }
}
