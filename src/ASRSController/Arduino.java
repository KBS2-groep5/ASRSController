package ASRSController;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import java.io.IOException;

abstract class Arduino {
    private SerialPort port;
    private String portDescriptor;

    Arduino(String portDescriptor) throws InterruptedException {
        this.port = SerialPort.getCommPort(portDescriptor);
        this.portDescriptor = portDescriptor;
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
        if (this.port.isOpen()) {
            this.port.getOutputStream().write(bytes);
            this.port.getOutputStream().flush();
            Thread.sleep(1000);
        } else {
            System.out.println("Port is not open!");
            JOptionPane.showMessageDialog(null, "The port \"" + this.portDescriptor + "\" is not open");
        }

    }

    int bytesAvailable() {
        return this.port.bytesAvailable();
    }

    void readBytes(byte[] readBuffer) {
        this.port.readBytes(readBuffer, readBuffer.length);
    }

    void close() {
        this.port.closePort();
    }
}
