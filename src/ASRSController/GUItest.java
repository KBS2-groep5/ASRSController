package ASRSController;

import org.json.simple.JSONArray;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.toIntExact;

class GUItest extends javax.swing.JFrame {
    private JFileChooser fc;
    private String filePath = "";
    private DbConnect db;

    private TspPanel tspPanel = new TspPanel();
    private BppPanel bppPanel = new BppPanel();
    private javax.swing.JLabel adress;
    private javax.swing.JLabel amountView;
    private javax.swing.JLabel name;
    private javax.swing.JLabel ordernumber;
    private javax.swing.JLabel place;
    private javax.swing.JTable productsTable;
    private javax.swing.JButton uploadButton;

    private String selectedOrderPickPort;
    private String selectedSortPort;

    GUItest() {
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        db = new DbConnect();

        add(this.tspPanel);
        add(this.bppPanel);

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JScrollPane jScrollPane2 = new JScrollPane();
        JTextPane jTextPane2 = new JTextPane();
        JComboBox<String> orderpickBox = new JComboBox<>();
        JComboBox<String> sortbox = new JComboBox<>();
        java.awt.Label sortLabel = new java.awt.Label();
        java.awt.Label orderpickLabel = new java.awt.Label();
        java.awt.Label sorteerStatus = new java.awt.Label();
        uploadButton = new javax.swing.JButton();
        JButton startButton = new JButton();
        JButton stopButton = new JButton();
        java.awt.Label uploadLabel = new java.awt.Label();
        java.awt.Label amountLabel = new java.awt.Label();
        amountView = new javax.swing.JLabel();
        java.awt.Label ordernumberLabel = new java.awt.Label();
        java.awt.Label robotStatus = new java.awt.Label();
        ordernumber = new javax.swing.JLabel();
        JLabel jLabel2 = new JLabel();
        adress = new javax.swing.JLabel();
        place = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        productsTable = new javax.swing.JTable();


        jScrollPane2.setViewportView(jTextPane2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Automated Storage and Retrieval System");
        setName("GUI"); // NOI18N

        orderpickBox.setModel(new javax.swing.DefaultComboBoxModel<>());
        orderpickBox.addActionListener(this::selectOrderPickBox);
        for (String temp : Arduino.getComPorts()) {
            orderpickBox.addItem(temp);
        }
        orderpickBox.addItem("Choose port ()");
        this.selectedOrderPickPort = orderpickBox.getSelectedItem().toString();

        sortbox.setModel(new javax.swing.DefaultComboBoxModel<>());
        sortbox.addActionListener(this::selectSortBox);
        for (String temp : Arduino.getComPorts()) {
            sortbox.addItem(temp);
        }
        sortbox.addItem("Choose port ()");
        sortLabel.setText("Sorteerrobot");

        orderpickLabel.setText("Orderpicker");

        sorteerStatus.setAlignment(java.awt.Label.RIGHT);
        sorteerStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sorteerStatus.setFont(new java.awt.Font("Dialog", Font.BOLD, 24)); // NOI18N
        sorteerStatus.setText("Sorteer Status");

        uploadButton.setText("Bestand");
        uploadButton.addActionListener(this::uploadButtonActionPerformed);

        startButton.setText("Start");
        startButton.addActionListener(this::startButtonActionPerformed);

        stopButton.setText("Stop");
        stopButton.addActionListener(this::stopButtonActionPreformed);

        uploadLabel.setText("JSON order uploaden");

        amountLabel.setText("Aantal producten:");

        amountView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amountView.setText("0");

        ordernumberLabel.setAlignment(java.awt.Label.RIGHT);
        ordernumberLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ordernumberLabel.setFont(new java.awt.Font("Dialog", Font.BOLD, 24)); // NOI18N
        ordernumberLabel.setText("Ordernummer:");

        robotStatus.setFont(new java.awt.Font("Dialog", Font.BOLD, 24)); // NOI18N
        robotStatus.setText("Robot Status");

        ordernumber.setFont(new java.awt.Font("Dialog", Font.PLAIN, 24)); // NOI18N
        ordernumber.setText("Geen");

        jLabel2.setText("Adres:");

        adress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adress.setText("Adres");

        place.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        place.setText("Plaats");

        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("Naam");

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String[]{
                        "Product", "Artikelnr"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(productsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 10, 15)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(sortLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(orderpickLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(orderpickBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(sortbox, javax.swing.GroupLayout.PREFERRED_SIZE, 67, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(robotStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 160, 160)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                                .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(ordernumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(ordernumber))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(uploadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(adress, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGap(31, 31, 31)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(amountView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(uploadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                        .addComponent(jLabel2)
                                                        .addComponent(place, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGap(126, 126, 126)
                                .addComponent(sorteerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(uploadButton)
                                                        .addComponent(uploadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(5, 5, 5)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(amountView))
                                                .addGap(141, 141, 141)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(ordernumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(ordernumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(sorteerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(robotStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(sortbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(orderpickLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(orderpickBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(adress)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(name)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(place)
                                                .addGap(114, 114, 114)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(39, Short.MAX_VALUE))
        );

        uploadButton.getAccessibleContext().setAccessibleDescription("");
        ordernumberLabel.getAccessibleContext().setAccessibleName("Ordernummer laber");
        ordernumber.getAccessibleContext().setAccessibleName("Order nummer");

        pack();
    }

    private void selectOrderPickBox(java.awt.event.ActionEvent evt) {
        JComboBox<String> orderPickBox = (JComboBox<String>) evt.getSource();
        this.selectedOrderPickPort = orderPickBox.getSelectedItem().toString();
    }

    private void selectSortBox(java.awt.event.ActionEvent evt) {
        JComboBox<String> sortBox = (JComboBox<String>) evt.getSource();
        this.selectedSortPort = sortBox.getSelectedItem().toString();
    }

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // todo: early return if already running
        String port1 = this.selectedOrderPickPort;
        port1 = port1.substring(port1.lastIndexOf("(") + 1, port1.lastIndexOf(")"));
        String port2 = this.selectedSortPort;
        port2 = port2.substring(port2.lastIndexOf("(") + 1, port2.lastIndexOf(")"));
        ReceiptWriter.writeReceipts(bppPanel.getContainers(), this.filePath);
        try {

            TSPArduino arduino1 = new TSPArduino(port1);
            BPPArduino arduino2 = new BPPArduino(port2);
            System.out.println("Sending...");
            arduino1.sendOrder(tspPanel.getPackageList());
            arduino2.sendOrder(tspPanel.getPackageList(), bppPanel.getContainers());
            System.out.println("Sent...");
            int numberOfPackagesKickedOut = 0;
            int numberOfPackagesPacked = 0;

            boolean running = true;

            while (running) {
                if (arduino1.bytesAvailable() > 0) {
                    arduino1.readBytes(new byte[]{0});
                    tspPanel.getPackageList().get(numberOfPackagesKickedOut).setKickedOut(true);
                    numberOfPackagesKickedOut += 1;
                    System.out.println("Kicked out");
                }

                if (arduino2.bytesAvailable() > 0) {
                    arduino2.readBytes(new byte[]{0});
                    tspPanel.getPackageList().get(numberOfPackagesPacked).setKickedOut(true);
                    numberOfPackagesPacked += 1;
                    System.out.println("Packed");
                    bppPanel.paintImmediately(0, 0, 1000, 1000);
                    running = numberOfPackagesPacked >= tspPanel.getPackageList().size();
                }
            }

            System.out.println("Done running");

            arduino1.close();
            arduino2.close();
        } catch (InterruptedException e) {
            System.out.println("Kijk dit gaat er fout: ");
            e.printStackTrace();
        }
    }

    private void stopButtonActionPreformed(java.awt.event.ActionEvent evt) {
        //this.run = false;
    }

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() != uploadButton) {
            return;
        }
        tspPanel.clearPackages();

        int returnVal = fc.showOpenDialog(GUItest.this);

        if (returnVal != JFileChooser.APPROVE_OPTION) {
            System.out.println("Open command cancelled by user.");
        }

        File file = fc.getSelectedFile();
        System.out.println("Opening: " + file.getName() + ".");

        int s = file.getName().lastIndexOf(".");
        if (!file.getName().substring(s + 1).equals("json")) {
            JOptionPane.showMessageDialog(null, "The file you selected is not a json file. You selected: " + file.getName().substring(s + 1));
            return;
        }

        this.filePath = file.getPath();

        JSONReadFromFile JSON = new JSONReadFromFile(this.filePath);

        this.ordernumber.setText(JSON.getOrdernr());
        this.adress.setText(JSON.getAdress());
        this.name.setText(JSON.getFirstName() + " " + JSON.getLastName());
        this.place.setText(JSON.getPlace());

        List<Package> productList = new ArrayList<>();

        JSONArray ProductList = JSON.getProductList();
        Iterator<Long> iterator = ProductList.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            int productNr = toIntExact(iterator.next());

            Package p = this.db.getPackage(productNr);

            if (p == null) {
                JOptionPane.showMessageDialog(null, "Opgevraagd product met id " + productNr + " staat niet in database");
                continue;
            }

            productList.add(p);

            this.tspPanel.addPackage(p);

            productsTable.setValueAt(p.getProductNr(), i, 1);
            productsTable.setValueAt(p.getName(), i, 0);

            i++;
        }

        List<Container> solution = BPPAlgorithm.solve(productList);
        this.bppPanel.setContainers(solution);

        this.amountView.setText(Integer.toString(i));

        repaint();
    }
}
