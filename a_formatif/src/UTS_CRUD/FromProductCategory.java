/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UTS_CRUD;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rini sukma ayu
 */
public class FromProductCategory extends javax.swing.JFrame {
    private Connections conn = new Connections();
    
    private DefaultTableModel model;
    //auto number
    private void autonumber(){
        try{
            Connection c = Connections.getConnection();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM product_category ORDER BY "
                        + "id_PCategory DESC";
                ResultSet r = s.executeQuery(sql);
                    if(r.next()){
                        String CategoryCode =r.getString("PCategory_code").substring(2);
                        String CS = ""+ (Integer.parseInt("PCategory_code")+1);
                        String Zero = "";
                        if(CS.length()==1){
                            Zero = "00";
                        }else if(CS.length()==2){
                            Zero = "0";
                        }else {
                            Zero = "";
                        }
                        txtCategoryCode.setText("CS"+ Zero + CS);
                    }else{
                        txtCategoryCode.setText("CP001");
                    }
                    r.close();
                    s.close();
                }catch(Exception e){
                    System.out.println("Auto Number Eror");
                }
    }
    // clear textfield
        private void clear(){
            txtCategoryName.setText("");
        }
        
        //load data ke table
        public void loadData(){
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            try{
                Connection c = Connections.getConnection();
                Statement s = c.createStatement();
                String sql = "SELECT * FROM product_category";
                ResultSet r = s.executeQuery(sql);
                while(r.next()){
                    Object[] o = new Object[3];
                         o [0] = r.getString("ID_PCategory");
                         o [1] = r.getString("PCategory_code");
                         o [2] = r.getString("PCategory_nama");
                         model.addRow(o);
                }
                r.close();
                s.close();
            }catch(SQLException e){
                System.out.println("Somthing wrong");
            }
        }
    /**
     * 
     * Creates new form FromProductCategory
     */
        //Memanggil method
        public FromProductCategory(){
            initComponents();
            this.setLocationRelativeTo(null);
            
            txtCategoryCode.setEditable(false);
            model = new DefaultTableModel();
            tblCategoryProduct.setModel(model);
            
            //add column table
            model.addColumn("ID");
            model.addColumn("Category Code");
            model.addColumn("Category Name");
            
            loadData();
            autonumber();
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategoryProduct = new javax.swing.JTable();
        txtCategoryName = new javax.swing.JTextField();
        CategoryName = new javax.swing.JLabel();
        CategoryCode = new javax.swing.JLabel();
        txtCategoryCode = new javax.swing.JTextField();

        jLabel4.setText("jLabel4");

        jTextField3.setText("jTextField3");

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setText("Category Product");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setText("Cencel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        tblCategoryProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Category Code", "Category Nama"
            }
        ));
        tblCategoryProduct.setDoubleBuffered(true);
        tblCategoryProduct.setDragEnabled(true);
        tblCategoryProduct.setFillsViewportHeight(true);
        tblCategoryProduct.setFocusCycleRoot(true);
        tblCategoryProduct.setFocusTraversalPolicyProvider(true);
        tblCategoryProduct.setInheritsPopupMenu(true);
        jScrollPane1.setViewportView(tblCategoryProduct);

        txtCategoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoryNameActionPerformed(evt);
            }
        });

        CategoryName.setText("Category Name");

        CategoryCode.setText("Category Code");

        txtCategoryCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoryCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addGap(27, 27, 27)
                                .addComponent(btnEdit)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancel))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CategoryName)
                                    .addComponent(CategoryCode))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCategoryName, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(txtCategoryCode)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jLabel1)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CategoryCode)
                    .addComponent(txtCategoryCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CategoryName)
                    .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String SCategory_Code = txtCategoryCode.getText();
        String SCategory_Name = txtCategoryName.getText();
        try{
            Connection c = Connections.getConnection();
            String sql = "INSERT INTO product_category(PCategory_code,PCategory_name)VALUES(?,?)";
            try (PreparedStatement p = c.prepareStatement(sql)) {
                p.setString(1,SCategory_Code);
                p.setString(2, SCategory_Name);
                p.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Data_Successful Saved");
        }catch(SQLException e){
            System.out.println("Something wrong");
        }finally{
            loadData();
            autonumber();
            clear();
            
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int i = tblCategoryProduct.getSelectedRow();
        if(i == -1){
            return;
        }
        String id = (String)model.getValueAt(i, 0);
        String CategoryCode = txtCategoryCode.getText();
        String CategoryName = txtCategoryName.getText();
        try{
            Connection c = Connections.getConnection();
            String sql = "UPDATE product_category SET PCategory_code = ? WHERE id_name = ? WHERE id_PCategory = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, CategoryCode);
            p.setString(2, CategoryName);
            p.setString(3, id);
            p.close();
            JOptionPane.showMessageDialog(null,"The data has been update");
        }catch(SQLException e){
            System.out.println("Update Error");
        }finally{
            loadData();
            autonumber();
            clear();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int i = tblCategoryProduct.getSelectedRow();
        if(i == -1){
            return;
        } String id = (String)model.getValueAt(i, 0);
        int question = JOptionPane.showConfirmDialog(null, "Sure this data will be delet?",
                "Confrim",JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE); 
        if(question == JOptionPane.OK_OPTION){
            try{
                Connection c = Connections.getConnection();
                String sql = "DELETE FROM product_category WHERE id_PCategory = ?";
                try (PreparedStatement p = c.prepareStatement(sql)) {
                    p.setString(1, id);
                    p.executeUpdate();
                }
                JOptionPane.showMessageDialog(null, "The data been deleted");
            }catch(SQLException e){
                System.out.println("Delete Eror");
            }finally{
                loadData();
                autonumber();
                btnSave.setEnabled(true);
            }
        }
        if(question == JOptionPane.CANCEL_OPTION){
            
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        clear();
        loadData();
        btnSave.setEnabled(true);
        autonumber();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        btnSave.setEnabled(false);
        int i = tblCategoryProduct.getSelectedRow();
        if(i == -1){
            return;
        }
        String CategoryCode = (String)model.getValueAt(i, 1);
        txtCategoryCode.setText(CategoryCode);
        String CategoryName = (String)model.getValueAt(i, 2);
        txtCategoryName.setText(CategoryName);
    }//GEN-LAST:event_formMouseClicked

    private void txtCategoryCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryCodeActionPerformed

    private void txtCategoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryNameActionPerformed

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
            java.util.logging.Logger.getLogger(FromProductCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromProductCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromProductCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromProductCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromProductCategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CategoryCode;
    private javax.swing.JLabel CategoryName;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tblCategoryProduct;
    private javax.swing.JTextField txtCategoryCode;
    private javax.swing.JTextField txtCategoryName;
    // End of variables declaration//GEN-END:variables
}
