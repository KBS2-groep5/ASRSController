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

/*
        List<Package> lastPackageContainers = new ArrayList<Package>();
        for(Container c : containers){
            if(c.getPackages().size() == 0){ continue; }
            int tempLength = c.getPackages().size()-1;
            lastPackageContainers.add(c.getPackages().get(tempLength));
        }
*/

        for (Package p : packages) {
            if (containers.get(0).getPackages().contains(p)) {
                commands[current] = 97;
            } else {
                commands[current] = 98;
            }
/*
            if(lastPackageContainers.contains(p)){
                current++;
                if(containers.get(0).getPackages().contains(p)){
                    commands[current] = 101;
                } else {
                    commands[current] = 102;
                }
            }
*/
            current++;
        }

        boolean leftFull = false;
        boolean rightFull = false;
        for (int i = commands.length; i >= 0;i--) {
            if(commands[i] == 97){
                if(!leftFull){
                    commands[i+1] = 101;
                    leftFull = true;
                }
            }
            if(commands[i] == 98){
                if(!rightFull){
                    commands[i+1] = 102;
                    rightFull = true;
                }
            }
        }

        try {
            this.write(commands);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
