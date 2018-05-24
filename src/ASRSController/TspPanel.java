package ASRSController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class TspPanel extends JPanel {
    private final int x = 325;
    private final int y = 345;
    private List<Package> packageList = new ArrayList<>();

    TspPanel() {
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.black));
        //setSize(315, 335);
        setBounds(10, 150, this.x, this.y);
    }

    void addPackage(Package p) {
        this.packageList.add(p);
        this.packageList = TSPAlgorithm.sort(this.packageList);
        System.out.println(this.getCommands(this.packageList));
        repaint();
    }

    void clearPackages() {
        this.packageList = new ArrayList<>();
        repaint();
    }

    static List<String> getCommands(List<Package> packageList){
        List<String> commands = new ArrayList<>();
        for(int c = 0; c < packageList.size(); c++){
            Package t = packageList.get(c);
            for(int x = 0; x < t.getX(); x++){
                commands.add("right");
            }
            for(int y = 0; y < t.getY(); y++){
                commands.add("down");
            }
            commands.add("push");
        }

        return commands;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = this.x / 5;
        int y = this.y / 5;

        for (Package p : packageList) {
            g.setColor(p.getPacked() ? Color.GREEN : Color.RED);
            g.fillRect(x * p.getX(), y * p.getY(), x, y);
        }

        for (int i = 0; i <= 5; i++) {
            for (int t = 0; t <= 5; t++) {
                g.setColor(Color.black);
                g.drawRect(x * i, y * t, x, y);
            }
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        for (int i = 0; i < packageList.size() - 1; i++) {
            Package p = packageList.get(i);
            Package p1 = packageList.get(i + 1);
            g2.setColor(Color.blue);
            int offSet = x / 2;
            g2.drawLine(x * p.getX() + offSet, y * p.getY() + offSet, x * p1.getX() + offSet, y * p1.getY() + offSet);
        }

        g2.setStroke(new BasicStroke(1));
    }
}
