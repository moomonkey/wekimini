/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekimini.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;
import javax.swing.JToggleButton;
import wekimini.ConnectsInputsToOutputs.InputOutputConnectionsListener;
import wekimini.Wekinator;
import wekimini.kadenze.KadenzeLogging;

/**
 *
 * @author rebecca
 */
public class InputOutputConnectionsEditor extends javax.swing.JFrame {
    private Wekinator w;
    private LabeledButtonGridPanel gridPanel;

    public InputOutputConnectionsEditor(Wekinator w) {
        initComponents();
        this.w = w;
        setup(w.getInputManager().getInputNames(),
                w.getOutputManager().getOutputGroup().getOutputNames(),
                w.getLearningManager().getConnectionMatrix());
                w.getLearningManager().addConnectionsListener(new InputOutputConnectionsListener() {

            @Override
            public void newConnectionMatrix(boolean[][] connections) {
                gridPanel.setNewOriginal(connections);
            }
        });

    }

    //For testing:
    private InputOutputConnectionsEditor(String[] rowNames, String[] colNames) {
        initComponents();
        this.w = null;
        boolean[][] e = new boolean[rowNames.length][colNames.length];
        setup(rowNames, colNames, e);
    }

    /**
     * Creates new form MockupInputSelection
     */
    private void setup(String[] rowNames, String[] colNames, boolean[][] enabled) {

        int numRows = rowNames.length;
        int numCols = colNames.length;
        
      //  this.listener = listener;
       /* if (rowNames == null || colNames == null || rowNames.length != numRows || colNames.length != numCols) {
            throw new IllegalArgumentException("Number of rows/columns must match number of row/column names");
        } */

        if (enabled == null || rowNames.length == 0 || enabled.length != rowNames.length || enabled[0] == null || enabled[0].length != colNames.length) {
            throw new IllegalArgumentException("Dimensions of enabled must match dimensions of row/column names");
        } 

        //scrollPanel.removeAll();
        gridPanel = new LabeledButtonGridPanel(rowNames, colNames, enabled);
        scrollPanel.setViewportView(gridPanel);
        //scrollPanel.validate();
        //scrollPanel.setMaximumSize(new Dimension(gridPanel.getPreferredSize().width + 20, gridPanel.getPreferredSize().height + 20));
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenuAction = new javax.swing.JPopupMenu();
        menuItemRevert = new javax.swing.JMenuItem();
        menuItemEnableAll = new javax.swing.JMenuItem();
        menuItemDisableAll = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        scrollPanel = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        menuItemRevert.setText("Revert all changes");
        menuItemRevert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRevertActionPerformed(evt);
            }
        });
        popupMenuAction.add(menuItemRevert);

        menuItemEnableAll.setText("Connect all");
        menuItemEnableAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEnableAllActionPerformed(evt);
            }
        });
        popupMenuAction.add(menuItemEnableAll);

        menuItemDisableAll.setText("Disconnect all");
        menuItemDisableAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDisableAllActionPerformed(evt);
            }
        });
        popupMenuAction.add(menuItemDisableAll);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        scrollPanel.setBackground(new java.awt.Color(255, 255, 255));
        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        scrollPanel.setViewportView(jPanel1);

        jLabel5.setText("<html>An \"X\" means that the value of the output corresponding to the column will be influenced by the value of the input corresponding to the row.</html>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanel)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Actions...");
        jButton1.setComponentPopupMenu(popupMenuAction);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //System.out.println("KEY PRESSED");
    }//GEN-LAST:event_formKeyPressed

    private void menuItemRevertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRevertActionPerformed
        gridPanel.revert();
    }//GEN-LAST:event_menuItemRevertActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.getComponentPopupMenu().show(jButton1, 0, 0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void menuItemEnableAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEnableAllActionPerformed
        gridPanel.setAll(true);
    }//GEN-LAST:event_menuItemEnableAllActionPerformed

    private void menuItemDisableAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDisableAllActionPerformed
        gridPanel.setAll(false);
    }//GEN-LAST:event_menuItemDisableAllActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean[][] oldConnections = w.getLearningManager().getConnectionMatrix();
        boolean[][] c = gridPanel.getConnectionsFromForm();
        if (gridPanel.checkValid(c)) {
            w.getLearningManager().updateInputOutputConnections(c);
            KadenzeLogging.getLogger().selectedFeatures(w, oldConnections, c);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /* try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
         if ("Nimbus".equals(info.getName())) {
         javax.swing.UIManager.setLookAndFeel(info.getClassName());
         break;
         }
         }
         } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(MockupInputSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(MockupInputSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(MockupInputSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(MockupInputSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String[] rowNames = {"abcdefgp.getPreferredSize().width", "b", "c", "d"};
                String[] colNames = {"1", "2", "1", "2", "1", "2", "1", "2"};
                new InputOutputConnectionsEditor(rowNames, colNames).setVisible(true);
                /*
                 new InputOutputConnectionsEditor(rowNames.length, colNames.length, rowNames, colNames, enabled, new ConnectionsListener() {

                 @Override
                 public void notify(boolean[][] connections) {
                 System.out.println("Got them");
                 for (int i = 0; i < connections.length; i++) {
                 for (int j = 0; j < connections[0].length; j++) {
                 System.out.print(connections[i][j] + "/");
                 }
                 System.out.println("");
                 }
                 }
                 }).setVisible(true); */
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenuItem menuItemDisableAll;
    private javax.swing.JMenuItem menuItemEnableAll;
    private javax.swing.JMenuItem menuItemRevert;
    private javax.swing.JPopupMenu popupMenuAction;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables

    public class MyToggle extends JToggleButton {

        int x, y;

        public MyToggle(ButtonLocation bl) {
            super();
            this.x = bl.x;
            this.y = bl.y;
            // System.out.println("h");
            setMinimumSize(new Dimension(40, 40));
            setMaximumSize(new Dimension(40, 40));
            setPreferredSize(new Dimension(40, 40));
            setSize(new Dimension(40, 40));
            //setMaximumSize(new Dimension(80, 80)); //Doesn't seem to work
            this.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // System.out.println("BUTTON CHANGE");
                }
            });

            this.getModel().addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // System.out.println("MODEL CHANGE");
                    if (isSelected()) {

                        setText("X");
                    } else {
                        setText("");
                    }

                }

            });
        }
        // addActionListener(this::actionPerformed);

        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // System.out.println("H");
           /* if (isSelected()) {
             setText("I");
             } else {
             setText("J");
             }
             repaint(); */
        }

        @Override
        public void setSelected(boolean s) {
            //System.out.println("SETTING SELECTED");
            this.getModel().setSelected(s);
            if (s) {
                setText("X");
            } else {
                setText("");
            }
        }

    }

    public class ButtonLocation {

        public int x;
        public int y;

        public ButtonLocation(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //doesn't really work
//See http://stackoverflow.com/questions/14777926/java-how-to-make-a-jlabel-with-vertical-text
    public class JVertLabel extends JComponent {

        private String text;

        public JVertLabel(String s) {
            text = s;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.rotate(Math.toRadians(270.0));
            g2d.drawString(text, 0, 0);
        }
    }

    public interface ConnectionsListener {

        public void notify(boolean[][] connections);
    }

}
