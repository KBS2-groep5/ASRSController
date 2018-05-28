package ASRSController;

import java.util.ArrayList;
import java.util.List;

class BPPArduino extends Arduino {
    BPPArduino(String portDescriptor) throws InterruptedException {
        super(portDescriptor);
    }

    void sendOrder(List<Package> packages, List<Container> containers) {
        byte[] commands = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99};
        int current = 0;
        List<Package> lastPackageContainers = new ArrayList<Package>();
        for (Container c : containers) {
            lastPackageContainers.add(c.getPackages().get(c.getPackages().size()));
        }

        for (Package p : packages) {
            if (containers.get(0).getPackages().contains(p)) {
                commands[current] = 97;
            } else {
                commands[current] = 98;
            }
            if (lastPackageContainers == p) {
                if (containers.get(0).getPackages().contains(p)) {
                    commands[current] = 11;
                } else {
                    commands[current] = 12;
                }
            }
            current += 1;
        }

        try {
            this.write(commands);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
