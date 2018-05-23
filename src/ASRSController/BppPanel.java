/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRSController;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author chris
 */
public class BppPanel extends JPanel {
    
    private int x = 360;
    private int y = 415;
    private ArrayList<int[]> packingList;
    private boolean can = false;
    
    public BppPanel(){
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.black));
        //setSize(360, 414);
        setBounds(710, 80, this.x, this.y);
    }
    
    public void setPackingList(ArrayList<int[]> packingList){
        this.packingList = packingList;
        this.can = true;
        this.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int x = this.x;
        int y = this.y;
        int boxLength = 10;
        
        if(can == true){
            ArrayList<ArrayList<int[]>> boxes = new ArrayList<ArrayList<int[]>>();
            boxes.add(this.packingList);
            
            for(int i = 0; i < boxes.size(); i++){
                int s = 0;
                ArrayList<int[]> box = boxes.get(i);
                for(int t = 0; t < box.size(); t++){
                    int[] product = box.get(t);
                    int xPos = 0 + s;
                    int yPos = y / 5 * i;
                    int boxHeight = y / 5;
                    int height = x / 10 * product[1];

                    if(product[2] == 1){
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

        }
        
        for(int i = 0; i <= 5; i++){
            g.setColor(Color.black);
            g.drawRect(0, y / 5 * i, x, y);
        }
        
    }
    
}
