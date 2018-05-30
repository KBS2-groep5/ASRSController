package ASRSController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BppPanel extends JPanel {
    private final int x = 360;
    private final int y = 415;
    private List<Container> containers = new ArrayList<>();

    BppPanel() {
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBounds(710, 80, this.x, this.y);
    }

    List<Container> getContainers() {
        return this.containers;
    }

    void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < this.containers.size(); i++) {
            g.setColor(Color.BLACK);
            g.drawString(this.containers.get(i).toString(), 20, 20 + i * 20);
        }

        g.setFont(new Font("Arial", Font.PLAIN, 11));

        int containers = 1;
        int n = 0;
        while(n < this.containers.size()-1){
            n++;
            if (!this.containers.get(n).getPackages().isEmpty()) {
                containers++;
            }
        }

        for (int i = 0; i < this.containers.size(); i++) {
            Container container = this.containers.get(i);

            // Outline of containers
            g.setColor(Color.BLACK);
            g.fillRect(0, i * (this.y / containers), 360, (this.y / containers));
            g.setColor(Color.WHITE);
            g.fillRect(1, 1 + i * (this.y / containers), this.x - 2, (this.y / containers) - 1);

            int offsetLeft = 0;
            for (Package p : container.getPackages()) {
                // Package
                g.setColor(p.getPacked() ? Color.GREEN : Color.RED);
                g.fillRect(offsetLeft + 1, i * (this.y / containers) + 1, (int) ((float) p.getHeight() / 100 * this.x) - 1, (this.y / containers));

                // Package ID and name
                g.setColor(Color.BLACK);
                g.drawString("" + p.getProductNr(), offsetLeft + 8, i * (this.y / containers) + 18);
                g.drawString(p.getHeight() > 20 ? p.getName() : "...", offsetLeft + 8, i * (this.y / containers) + 32);

                offsetLeft += (int) ((float) p.getHeight() / 100 * this.x);

                // Black line to divide packages
                g.fillRect(offsetLeft, i * (this.y / containers) + 1, 1, (this.y / containers));
            }
        }
    }
}
