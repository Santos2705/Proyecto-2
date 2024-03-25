/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Nodes.HashTable_Guest_Node;
import Data_Structures.HashTable_Clients;
import Data_Structures.BinarySearchTree_Reservations;
import Data_Structures.BDD_Rooms;
import java.io.FileReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Home extends javax.swing.JFrame {

    public static HashTable_Clients bdd_clients;
    public static BinarySearchTree_Reservations bdd_reservations;
    public static BDD_Rooms bdd_rooms;

    /**
     * Creates new form MenuInicial
     */
    public Home(HashTable_Clients h, BinarySearchTree_Reservations ar, BDD_Rooms ah) {
        initComponents();
        bdd_clients = h;
        bdd_reservations = ar;
        bdd_rooms = ah;
        if (h == null) {
            bdd_reservations = this.readReservas("reservas.csv");
            bdd_rooms = readRooms("habitaciones.csv");
            bdd_rooms = readRecord("historico.csv");
            bdd_clients = this.reedClients("estado.csv");

        }
        this.setVisible(true);
    }

    public static BDD_Rooms readRecord(String filePath) {
        BDD_Rooms nodes = bdd_rooms;
        try ( CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 7) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 7) {
                        throw new IOException("Invalid CSV format");
                    }
                    String ci = values[0].replace(".", "");
                    nodes.addNewRecord(Integer.parseInt(values[6]), values[1], values[2], values[3], values[4], values[5], Integer.parseInt(ci));
                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return nodes;
    }    
    
    public static BDD_Rooms readRooms(String filePath) {
        BDD_Rooms nodes = new BDD_Rooms();
        try ( CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 3) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 3) {
                        throw new IOException("Invalid CSV format");
                    }
                    nodes.createRoom(Integer.parseInt(values[0]), Integer.parseInt(values[2]), values[1]);
                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return nodes;
    }
        
        
    public static BinarySearchTree_Reservations readReservas(String filePath) {
        BinarySearchTree_Reservations nodes = new BinarySearchTree_Reservations();
        try ( CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 9) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 9) {
                        throw new IOException("Invalid CSV format");
                    }
                    String ci = values[0].replace(".", "");
                    nodes.newReservation(Integer.parseInt(ci), values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]);
                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return nodes;
    }



    public static HashTable_Clients reedClients(String filePath) {
        HashTable_Clients nodes = new HashTable_Clients();
        try ( CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 7) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            HashTable_Guest_Node[] clientes = new HashTable_Guest_Node[10];
            for (int i = 0; i < 10; i++) {
                clientes[i] = null;
            }
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 7) {
                        throw new IOException("Invalid CSV format");
                    }
                    if (values[0].equals("")) {
                        for (int i = 0; i < 10; i++) {
                            if (clientes[i] == null) {
                                clientes[i] = new HashTable_Guest_Node(values[1], values[2], values[3], values[4], values[6], values[5], 0);
                                break;
                            }

                        }
                    } else {
                        nodes.newGuest(values[1], values[2], values[3], values[4], values[5], values[6], Integer.parseInt(values[0]));
                        for (int i = 0; i < 10; i++) {
                            if (clientes[i] != null) {
                                nodes.newGuest(clientes[i].getName(), clientes[i].getLast_name(), clientes[i].getEmail(), clientes[i].getGender(), clientes[i].getArrival(), clientes[i].getPhone(), Integer.parseInt(values[0]));
                                clientes[i] = null;
                            }
                        }
                        bdd_rooms.searchRoom(Integer.parseInt(values[0])).setOccupied(true);

                    }

                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return nodes;
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(153, 102, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU INICIAL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        jButton1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 102, 255));
        jButton1.setText("CHECK-OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, -1, -1));

        jButton2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 102, 255));
        jButton2.setText("HUÉSPEDES");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jButton3.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(153, 102, 255));
        jButton3.setText("RESERVACIONES");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        jButton4.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(153, 102, 255));
        jButton4.setText("HISTORIAL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 170, -1));

        jButton5.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(153, 102, 255));
        jButton5.setText("CHECK-IN");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Escoja una opcion");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Guests_menu menu = new Guests_menu(bdd_clients, bdd_reservations, bdd_rooms);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Reservation_menu menu = new Reservation_menu(bdd_clients, bdd_reservations, bdd_rooms);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        RoomsRecord_menu menu = new RoomsRecord_menu(bdd_clients, bdd_reservations, bdd_rooms);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        CheckIn_menu menu = new CheckIn_menu(bdd_clients, bdd_reservations, bdd_rooms);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CheckOut_menu menu = new CheckOut_menu(bdd_clients, bdd_reservations, bdd_rooms);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home(bdd_clients, bdd_reservations, bdd_rooms).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
