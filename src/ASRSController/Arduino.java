package ASRSController;

import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;

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

    void write(byte[] bytes) throws IOException {
        // todo: check if port is open (currently throws NullPointerException)
        Integer i = 2;
        this.port.getOutputStream().write(bytes);
        this.port.getOutputStream().flush();
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
