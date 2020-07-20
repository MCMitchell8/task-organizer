/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskOrganization;

import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author melissacmitchell
 */
public class EnterCompletedTask extends javax.swing.JDialog {

    
    //creates model
    DefaultTableModel model; 
    
    //all tasks stored in array
    ArrayList<Task> tasks = new ArrayList<>();
    
    //all completed tasks stored in array
    ArrayList<Task> completedTasks = new ArrayList<>();
    
    //defaults filter to all tasks
    DisplayFilter displayFilter = DisplayFilter.Both;
    
    //defaults categories to all categories
    boolean filterCategories = false;
    Category categoryFilter = null;
    
    //defaults month and year to all
    int monthToFilter = -1;
    int yearToFilter = -1;
    int dayToFilter = -1;
    
 
    /**
     * Creates new form CompletedTasks
     */
    public EnterCompletedTask(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        //sets table columns
        model = new DefaultTableModel();
                    model.addColumn("Month");
                    model.addColumn("Year");
                    model.addColumn("Day");
                    model.addColumn("Authentication?");
                    model.addColumn("Instructions");
                    model.addColumn("Category");
                    model.addColumn("Repeating?");
                    
        //sets model  
        tableChildComplete.setModel(model);
        
        //sets column widths
        tableChildComplete.getColumnModel().getColumn(0).setPreferredWidth(110);
        tableChildComplete.getColumnModel().getColumn(1).setPreferredWidth(75);
        tableChildComplete.getColumnModel().getColumn(2).setPreferredWidth(50);
        tableChildComplete.getColumnModel().getColumn(3).setPreferredWidth(180);
        tableChildComplete.getColumnModel().getColumn(4).setPreferredWidth(350);
        tableChildComplete.getColumnModel().getColumn(5).setPreferredWidth(130);
        tableChildComplete.getColumnModel().getColumn(6).setPreferredWidth(150);
        
        readFromFile();
        updateDisplay();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableChildComplete = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        buttonDone = new javax.swing.JButton();
        buttonComplete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        buttonAuthenticate = new javax.swing.JButton();
        fieldPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableChildComplete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableChildComplete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableChildCompleteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableChildComplete);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Tasks");

        buttonDone.setText("Done");
        buttonDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDoneActionPerformed(evt);
            }
        });

        buttonComplete.setText("Complete");
        buttonComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCompleteActionPerformed(evt);
            }
        });

        buttonAuthenticate.setText("Get task checked");
        buttonAuthenticate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAuthenticateActionPerformed(evt);
            }
        });

        jLabel2.setText("Enter password:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAuthenticate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAuthenticate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(buttonDone)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
            .addGroup(layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(buttonComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonDone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDoneActionPerformed
  
        this.dispose();
    }//GEN-LAST:event_buttonDoneActionPerformed

    private void buttonCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCompleteActionPerformed
        //get the number of selected rows
        int rowCount = tableChildComplete.getSelectedRowCount();
        
        //if there is more than one row while there are still rows, 
        //get the first selected row and deletes it
        if (rowCount > 1) {
            JOptionPane.showMessageDialog(null, "Please only select one task.");
            return;
        }
        //otherwise, determine if the task is repeating
        else {
            int rowSelected = tableChildComplete.getSelectedRow();
            copyTask(rowSelected);
            tasks.remove(rowSelected);
            model.removeRow(rowSelected);
        }
        
        writeTasks();
        updateDisplay();
    }//GEN-LAST:event_buttonCompleteActionPerformed

    private void buttonAuthenticateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAuthenticateActionPerformed
        if(valPassword() == true){
            //get the number of selected rows
            int rowCount = tableChildComplete.getSelectedRowCount();

            //if there is more than one row while there are still rows, 
            //get the first selected row and deletes it
            if (rowCount > 1) {
                JOptionPane.showMessageDialog(null, "Please only select one task.");
                return;
            }
            //otherwise, determine if the task is repeating
            else {
                int rowSelected = tableChildComplete.getSelectedRow();
                copyTask(rowSelected);
                tasks.remove(rowSelected);
                model.removeRow(rowSelected);
        }
 
        }
        else{
            JOptionPane.showMessageDialog(null, "Password is incorrect. Please try again.");
        }
        
        writeTasks();
        updateDisplay();
        fieldPassword.setText("");
    }//GEN-LAST:event_buttonAuthenticateActionPerformed

    private void tableChildCompleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableChildCompleteMouseClicked
        // TODO add your handling code here:h
        int rowSelected = tableChildComplete.getSelectedRow();
        Task taskSelected = tasks.get(rowSelected);
        
        if (taskSelected.authentication == true) {
            buttonComplete.setEnabled(false);
        } else {
            buttonComplete.setEnabled(true);
        }
    }//GEN-LAST:event_tableChildCompleteMouseClicked

    public boolean valPassword()
    {
        // Read from Java IO the password string
        // If not nil set to 
        String password = "";
        String newPassword = FileIO.readCurrentPassword();
        if (newPassword.length() > 0) {
            password = newPassword;
        }
        
        String userEntered = new String(fieldPassword.getPassword());
        
        return userEntered.equals(password);
    }
    
    //sorts and filters the data and updates the display
    public void updateDisplay() {
        int count;
        count = model.getRowCount();
       
        //Remove all rows from existing table
        for (int removeItem = 0; removeItem < count; removeItem++) {
            model.removeRow(0);
        }
        
        //Goes through tasks and separates them based on selection
        for(Task task : tasks){
            if (Filters.passesTaskFilter(task, displayFilter) &&
                Filters.passesCategoryFilter(task, filterCategories ? categoryFilter : null) &&
                Filters.passesMonthFilter(task, monthToFilter) &&
                Filters.passesDayFilter(task, dayToFilter) &&
                Filters.passesYearFilter(task, yearToFilter)) {
                

                // If the transaction passes all the filters, add it to the model
                model.addRow(new Object[]{  
                    Conversions.convertMonthToString(task.getMonth()),
                    task.getYear(),
                    task.getDay(),
                    task.getAuthentication() ? "Yes" : "No",
                    task.getInstructions(),
                    task.getCategory(),
                    task.getRepeating() ? "Yes" : "No"
                });
            }
        }
        fieldPassword.setText("");
     }
    
    private void copyTask(Integer rowSelected) {
        Task task = tasks.get(rowSelected);

        completedTasks.add(task);
    }
    
    //reads the tasks in from disk
    private void readFromFile(){
        
        tasks = FileIO.readTasks();
       
        //if there are no tasks, create empty array
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        
        completedTasks = FileIO.readCompletedTasks();
        
        //if there are no completed tasks, create empty array
        if (completedTasks == null) {
            completedTasks = new ArrayList<>();
        }
     
    }

    
    private void writeTasks() {
        //sorts the task

        tasks.sort(Comparator.comparing(Task::getYear)
                .thenComparing(Task::getMonth)
                .thenComparing(Task::getDay)
                .thenComparing(Task::getCategory)
                .thenComparing(Task::getRepeating)
                .thenComparing(Task::getAuthentication)
                );
        
        //writes the sorted list to disk
        FileIO.writeTasks(tasks);

        completedTasks.sort(Comparator.comparing(Task::getYear)
                .thenComparing(Task::getMonth)
                .thenComparing(Task::getDay)
                .thenComparing(Task::getCategory)
                .thenComparing(Task::getRepeating)
                .thenComparing(Task::getAuthentication)
                );
        
        //writes the sorted list to disk
        FileIO.writeCompletedTasks(completedTasks);
    }
    
    private void writeCompletedTasks() {
        //sorts the task
       
        tasks.sort(Comparator.comparing(Task::getYear)
                .thenComparing(Task::getMonth)
                .thenComparing(Task::getDay)
                .thenComparing(Task::getCategory)
                .thenComparing(Task::getRepeating)
                .thenComparing(Task::getAuthentication)
                );
        
        //writes the sorted list to disk
        FileIO.writeCompletedTasks(tasks);
    }
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
            java.util.logging.Logger.getLogger(EnterCompletedTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnterCompletedTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnterCompletedTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnterCompletedTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EnterCompletedTask dialog = new EnterCompletedTask(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAuthenticate;
    private javax.swing.JButton buttonComplete;
    private javax.swing.JButton buttonDone;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableChildComplete;
    // End of variables declaration//GEN-END:variables
}
