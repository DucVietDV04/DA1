/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.taiKhoanNV;
import Service.taiKhoanNVService;
import edusys.XImage;
import javax.swing.JOptionPane;

/**
 *
 * @author puddi
 */
public class TaiKhoanView extends javax.swing.JFrame {

    taiKhoanNVService tkService = new taiKhoanNVService();
    public TaiKhoanView() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Tài khoản");
        init();
    }
    void init() {
        setIconImage(XImage.getAppIcon());
        setTitle("Tài Khoản");
    }
    boolean checkform(){
        if (txtMatKhau.getText().trim().isEmpty()
                ||txtTaiKhoan.getText().trim().isEmpty()
                ||txtTenNV.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa điền đủ thông tin!");
            return false;
        }
//        for (taiKhoanNV object : tkService.getAllTK()) {
//            if (object.getTkNV().equals(txtTaiKhoan.getText())) {
//                JOptionPane.showMessageDialog(this, "Đã tồn tại tài khoản!");
//                return false;
//            } 
//        }
        return true;
    }
    public taiKhoanNV getDataOnForm(){
        taiKhoanNV tk=new taiKhoanNV();
        tk.setTkNV(txtTaiKhoan.getText());
        tk.setTenNV(txtTenNV.getText());
        tk.setMatKhau(txtMatKhau.getText());
        tk.setVaiTro(rdoQuanly.isSelected());
        return tk;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        rdoQuanly = new javax.swing.JRadioButton();
        rdoNhanvien = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm tài khoản");

        jLabel1.setText("Tài khoản");

        jLabel2.setText("Tên nhân viên");

        jLabel3.setText("Mật khẩu");

        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoQuanly);
        rdoQuanly.setText("Quản lý");

        buttonGroup1.add(rdoNhanvien);
        rdoNhanvien.setText("Nhân viên");

        jLabel4.setText("Vai trò");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdoQuanly, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThem)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                        .addComponent(txtTenNV, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTaiKhoan, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoQuanly)
                    .addComponent(rdoNhanvien)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnThem)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        taiKhoanNV tk = getDataOnForm();
        if (checkform()) {
            if (tkService.them(tk)!=0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                this.setTitle("Thêm thành công");
                this.dispose();
                
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
            }
        } 
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

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
            java.util.logging.Logger.getLogger(TaiKhoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaiKhoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaiKhoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaiKhoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaiKhoanView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton rdoNhanvien;
    private javax.swing.JRadioButton rdoQuanly;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
