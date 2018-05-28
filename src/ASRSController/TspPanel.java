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

    public List<Package> getPackageList(){
        return this.packageList;
    }

    void addPackage(Package p) {
        this.packageList.add(p);
        this.packageList = TSPAlgorithm.sort(this.packageList);
        this.paintImmediately(0, 0, 1000, 1000);
    }

    void clearPackages() {
        this.packageList = new ArrayList<>();
        this.paintImmediately(0, 0, 1000, 1000);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = this.x / 5;
        int y = this.y / 5;

        for (Package p : packageList) {
            g.setColor(p.getKickedOut() ? Color.GREEN : Color.RED);
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
