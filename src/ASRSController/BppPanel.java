package ASRSController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BppPanel extends JPanel {
    private int x = 360;
    private int y = 415;
    private ArrayList<Package> packageList = new ArrayList<>();

    BppPanel() {
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBounds(710, 80, this.x, this.y);
    }

    void addPackage(Package p) {
        this.packageList.add(p);
        repaint();
    }

    void clearPackages() {
        this.packageList = new ArrayList<>();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = this.x;
        int y = this.y;
        int boxLength = 10;

        ArrayList<ArrayList<int[]>> boxes = new ArrayList<ArrayList<int[]>>();
//        boxes.add(this.packageList);

        for (int i = 0; i < boxes.size(); i++) {
            int s = 0;
            ArrayList<int[]> box = boxes.get(i);
            for (int t = 0; t < box.size(); t++) {
                int[] product = box.get(t);
                int xPos = s;
                int yPos = y / 5 * i;
                int boxHeight = y / 5;
                int height = x / 10 * product[1];

                if (product[2] == 1) {
                    g.setColor(Color.green);
                } else {
                    g.setColor(Color.red);
                }

                g.fillRect(xPos, yPos, height, boxHeight);
                g.setColor(Color.black);
                g.drawRect(xPos, yPos, height, boxHeight);

                g.drawString(Integer.toString(product[0]), xPos + (height / 2), yPos + (boxHeight / 2));

                s += (x / boxLength * product[1]);
            }
        }

        for (int i = 0; i <= 5; i++) {
            g.setColor(Color.black);
            g.drawRect(0, y / 5 * i, x, y);
        }
    }
}
