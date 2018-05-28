package ASRSController;

import java.util.List;

class TSPArduino extends Arduino {
    TSPArduino(String portDescriptor) throws InterruptedException {
        super(portDescriptor);
    }

    void sendOrder(List<Package> packages) {
        byte[] commands = new byte[100];
        commands[0] = 'g';
        commands[1] = 'f';
        commands[2] = 'h';
        int x = 0;
        int y = 4;
        int i = 3;
        for (Package t : packages) {
            for (x = x; x < t.getX(); x++) {
                commands[i] = 'b';
                i += 1;
            }
            for (x = x; x > t.getX(); x--) {
                commands[i] = 'a';
                i += 1;
            }
            for (y = y; y < t.getY(); y++) {
                commands[i] = 'd';
                i += 1;
            }
            for (y = y; y > t.getY(); y--) {
                commands[i] = 'c';
                i += 1;
            }
            commands[i] = 'e';
            i += 1;
            x = t.getX();
            y = t.getY();
        }
        commands[i] = 'i';

        try {
            this.write(commands);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
