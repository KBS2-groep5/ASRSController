package ASRSController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class TspPanel extends JPanel {
    private int x = 325;
    private int y = 345;
    private ArrayList<int[]> productList;
    private boolean can = false;

    TspPanel() {
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.black));
        //setSize(315, 335);
        setBounds(10, 150, this.x, this.y);
    }

    void setProductList(ArrayList<int[]> productList) {
        this.productList = productList;
        this.can = true;
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = this.x / 5;
        int y = this.y / 5;

        //als er een productLijst is gePushed voert het volgende stuk uit
        if (can) {
            //dit is het tekenen van de pakketjes in de stelling dit gebeurd voor het tekenen van de stelling
            for (int i = 0; i < productList.size(); i++) {
                int[] product = productList.get(i);
                //als het product ingepakt is is de kleur groen anders rood
                if (product[2] == 1) {
                    g.setColor(Color.green);
                } else {
                    g.setColor(Color.red);
                }
                g.fillRect(x * product[0], y * product[1], x, y);
            }

        }

        for (int i = 0; i <= 5; i++) {
            for (int t = 0; t <= 5; t++) {
                g.setColor(Color.black);
                g.drawRect(x * i, y * t, x, y);
            }
        }

        //als er een productLijst is gePushed voert het volgende stuk uit
        if (can) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));

            for (int i = 0; i < productList.size() - 1; i++) {
                int[] product = productList.get(i);
                int[] product1 = productList.get(i + 1);
                g2.setColor(Color.blue);
                int offSet = x / 2;
                g2.drawLine(x * product[0] + offSet, y * product[1] + offSet, x * product1[0] + offSet, y * product1[1] + offSet);
            }

            g2.setStroke(new BasicStroke(1));
        }

    }

}
