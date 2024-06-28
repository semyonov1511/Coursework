/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Intermediary.Manager;
import Rooms.Room;
import Works.Work;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class GUI extends javax.swing.JFrame {

    Manager manager;
    DefaultTreeModel model;
    DefaultMutableTreeNode objects = new DefaultMutableTreeNode("Objects");

    public GUI() {
        manager = new Manager();
        initComponents();
        manager.importObjectData(readingStatusLabel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parametersFrame = new javax.swing.JFrame();
        parametertsPanel = new javax.swing.JPanel();
        costTextLabel = new javax.swing.JLabel();
        timeTextLabel = new javax.swing.JLabel();
        collectiveDoseTextLabel = new javax.swing.JLabel();
        individualDoseTextLabel = new javax.swing.JLabel();
        costLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        collectiveDoseLabel = new javax.swing.JLabel();
        individualDoseLabel = new javax.swing.JLabel();
        warningFrame = new javax.swing.JFrame();
        warningPanel = new javax.swing.JPanel();
        warningLabel = new javax.swing.JLabel();
        readingStatusLabel = new javax.swing.JLabel();
        readWorkInfoFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        objectsTree = new javax.swing.JTree();
        calculateButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        costTextLabel.setText("Стоимость проекта:");

        timeTextLabel.setText("Время проекта:");

        collectiveDoseTextLabel.setText("Коллективная доза:");

        individualDoseTextLabel.setText("Средняя индивидуальная доза:");

        costLabel.setText("costLabel");

        timeLabel.setText("timeLabel");

        collectiveDoseLabel.setText("collectiveDoseLabel");

        individualDoseLabel.setText("individualDoseLabel");

        javax.swing.GroupLayout parametertsPanelLayout = new javax.swing.GroupLayout(parametertsPanel);
        parametertsPanel.setLayout(parametertsPanelLayout);
        parametertsPanelLayout.setHorizontalGroup(
            parametertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametertsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(parametertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(costTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(collectiveDoseTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(individualDoseTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(parametertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(costLabel)
                    .addComponent(timeLabel)
                    .addComponent(collectiveDoseLabel)
                    .addComponent(individualDoseLabel))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        parametertsPanelLayout.setVerticalGroup(
            parametertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametertsPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(parametertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(parametertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(parametertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(collectiveDoseTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(collectiveDoseLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(parametertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(individualDoseTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(individualDoseLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout parametersFrameLayout = new javax.swing.GroupLayout(parametersFrame.getContentPane());
        parametersFrame.getContentPane().setLayout(parametersFrameLayout);
        parametersFrameLayout.setHorizontalGroup(
            parametersFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametersFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(parametertsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        parametersFrameLayout.setVerticalGroup(
            parametersFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametersFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(parametertsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        warningLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        warningLabel.setToolTipText("");

        javax.swing.GroupLayout warningPanelLayout = new javax.swing.GroupLayout(warningPanel);
        warningPanel.setLayout(warningPanelLayout);
        warningPanelLayout.setHorizontalGroup(
            warningPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warningPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        warningPanelLayout.setVerticalGroup(
            warningPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warningPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout warningFrameLayout = new javax.swing.GroupLayout(warningFrame.getContentPane());
        warningFrame.getContentPane().setLayout(warningFrameLayout);
        warningFrameLayout.setHorizontalGroup(
            warningFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warningFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(warningPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        warningFrameLayout.setVerticalGroup(
            warningFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warningFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(warningPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        readWorkInfoFile.setText("Прочитать файл с информаций про работы");
        readWorkInfoFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    readWorkInfoFileActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        objectsTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(objectsTree);

        calculateButton.setText("Запуск расчета интегральных показателей");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Выйти");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(readWorkInfoFile, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(calculateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(readingStatusLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(readWorkInfoFile, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(calculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(readingStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Проверяет, прочитаны ли объекты и выбран ли корректный файл работ, в случае корректности создает новую TreeNode с привязанными
     * к комнатам работами, в ином случае - вызывает окно с предупреждением.
     */
    private void readWorkInfoFileActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_readWorkInfoFileActionPerformed
        if (manager.isObjectsRead()) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));
            int response = chooser.showOpenDialog(null);
            if (chooser.getSelectedFile() != null && manager.checkWorksFile(new File(chooser.getSelectedFile().getAbsolutePath()))) {
                DefaultMutableTreeNode objects = new DefaultMutableTreeNode("Objects");
                File file = new File(chooser.getSelectedFile().getAbsolutePath());
                manager.importWorksData(file);
                manager.connectObjectsWorks();
                for (Room room : manager.getObjects().values()) {
                    DefaultMutableTreeNode concreteRoom = new DefaultMutableTreeNode(room.getName());
                    for (Work work : room.getWorks().values()) {
                        DefaultMutableTreeNode concreteWork = new DefaultMutableTreeNode(work.getName());
                        concreteRoom.add(concreteWork);
                    }
                    objects.add(concreteRoom);
                }
                model = (DefaultTreeModel) objectsTree.getModel();
                model.setRoot(objects);
                objectsTree.setModel(model);
            }
            else{
                warningLabel.setText("Файл выбран некорректно");
                warningFrame.setBounds(400,400,300,220);
                warningFrame.setVisible(true);
            }
        }
        else {
            warningLabel.setText("Перезапустите программу, данные по объекту прочитаны некорректно");
            warningFrame.setBounds(400,400,650,220);
            warningFrame.setVisible(true);
        }
    }//GEN-LAST:event_readWorkInfoFileActionPerformed

    /**
     * Проверяет, прочитаны ли работы, в случае корректности запускает процесс расчета параметров
     * и выызывает окно с ними, в ином случае - вызывает окно с предупреждением.
     */
    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        if (manager.isWorksRead()){
            parametersFrame.setVisible(true);
            parametersFrame.setBounds(200, 200, 430, 280);
            manager.calculateParameters();
            costLabel.setText(String.valueOf(manager.calculator.getTotalCost()));
            timeLabel.setText(String.valueOf(manager.calculator.getTotalTime()));
            collectiveDoseLabel.setText(String.valueOf(manager.calculator.getCollectiveDose()));
            individualDoseLabel.setText(String.valueOf(manager.calculator.getIndividualDose()));
        }
        else {
            warningLabel.setText("Сперва нужно импортировать данные по работам");
            warningFrame.setBounds(400,400,550,220);
            warningFrame.setVisible(true);
        }
    }//GEN-LAST:event_calculateButtonActionPerformed

    /**
     * Осуществляет выход из программы
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calculateButton;
    private javax.swing.JLabel collectiveDoseLabel;
    private javax.swing.JLabel collectiveDoseTextLabel;
    private javax.swing.JLabel costLabel;
    private javax.swing.JLabel costTextLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel individualDoseLabel;
    private javax.swing.JLabel individualDoseTextLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree objectsTree;
    private javax.swing.JFrame parametersFrame;
    private javax.swing.JPanel parametertsPanel;
    private javax.swing.JButton readWorkInfoFile;
    private javax.swing.JLabel readingStatusLabel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeTextLabel;
    private javax.swing.JFrame warningFrame;
    private javax.swing.JLabel warningLabel;
    private javax.swing.JPanel warningPanel;
    // End of variables declaration//GEN-END:variables
}
