/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import Model.KhachHang;
import Service.KhachHangService;
import edusys.XImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class KhachHangView extends javax.swing.JDialog {

    public static String maKH, tenKH;
    DefaultTableModel mol = new DefaultTableModel();
    List<KhachHang> list = new ArrayList<>();
    KhachHangService service = new KhachHangService();
    /**
     * Creates new form NewJDialog
     */
    public KhachHangView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        fillTable(service.getAllKH());
        init();
    }
    void init() {
        setIconImage(XImage.getAppIcon());
        setTitle("Khách Hàng");
    }
    public void fillTable(List<KhachHang> list){
        mol = (DefaultTableModel) tblKhachHang.getModel();
        mol.setRowCount(0);
        for (KhachHang hang : list) {
           mol.addRow(hang.toDataRow());
        }
    }

    
    // lấy dữ liệu từ bảng
    public void showData(int index){
       KhachHang kh=service.getAllKH().get(index);
       txtMaKH.setText(kh.getMAKH());
       txtTenKH.setText(kh.getHoTen());
       rdoNam.setSelected(!kh.isGioiTinh());
       rdoNu.setSelected(kh.isGioiTinh());
       txtSDT.setText(kh.getSoDienThoai());
       txtEmail.setText(kh.getEmail());
       rdoVip.setSelected(kh.isLoaiKH());
       rdoThuong.setSelected(!kh.isLoaiKH());
       txtTCT.setText(kh.getTongChiTieu()+"");
       
      
    }
    public KhachHang readFor() {
        String MaKH = txtMaKH.getText();
        String TenKH = txtTenKH.getText();
        boolean GioiTinh;
        if(rdoNam.isSelected()){
            GioiTinh = false;
        }else{
            GioiTinh = true;
        }
        
        String SDT = txtSDT.getText();
        String Email = txtEmail.getText();
        boolean LoaiKH;
        if(rdoVip.isSelected()){
            LoaiKH = true;
        }else{
            LoaiKH = false;
        }
        Float TCT = Float.parseFloat(txtTCT.getText());
        
        return new KhachHang(MaKH, TenKH, GioiTinh, SDT, Email, LoaiKH, TCT);

    }
    // clear form nhập
    public void clearForm(){
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtTCT.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
    }
    public boolean checkData() {
        if (txtMaKH.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã");
            return false;
        }
        if (txtTenKH.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên");
            return false;
        }
        
        if (txtSDT.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập SDT");
            return false;
        }else{
            try {//đúng dữ liệu
               if(Integer.parseInt(txtSDT.getText())<0){
                   JOptionPane.showMessageDialog(this, "SDT<0");
                   return false;
               }else{
                   if(txtSDT.getText().length()<9 ||txtSDT.getText().length()>11){
                       JOptionPane.showMessageDialog(this, "Số điện thoại phảo có 10 số ");
                       return false;
                   }
               }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "SDT Phải là số");
                return false;
            }
        }
        if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập Email");
            return false;
        }
        if (txtTCT.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập Tổng Chi Tiêu");
            return false;
        }
        return true;
    }
    public void findmaKM() {
        String keyword = txtFind.getText().trim();
        List<KhachHang> listFindmaKH = new ArrayList<>();
        List<KhachHang> listKH = service.getAllKH();
        
            for (KhachHang km: listKH) {
                if (km.getMAKH().contains(keyword)) {
                    listFindmaKH.add(km);
                }
            } 
            fillTable(listFindmaKH);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        btnThemKH = new javax.swing.JButton();
        btnClearForm = new javax.swing.JButton();
        txtTCT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rdoVip = new javax.swing.JRadioButton();
        rdoThuong = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        BackKH = new javax.swing.JLabel();
        btnChonKhachHang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane2.setBackground(new java.awt.Color(0, 255, 204));
        jTabbedPane2.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "Giới tính", "SĐT", "Email", "Loại KH", "Tổng chi tiêu"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblKhachHang);

        jLabel1.setText("Tìm kiếm");

        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFindKeyPressed(evt);
            }
        });

        jLabel2.setText("Mã khách hàng");

        jLabel3.setText("Tên khách hàng");

        jLabel4.setText("Giới tính");

        jLabel5.setText("Số điện thoại");

        jLabel6.setText("Email");

        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        btnThemKH.setBackground(new java.awt.Color(0, 255, 204));
        btnThemKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemKH.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKH.setText("Thêm");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        btnClearForm.setBackground(new java.awt.Color(0, 255, 204));
        btnClearForm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClearForm.setForeground(new java.awt.Color(255, 255, 255));
        btnClearForm.setText("Làm mới");
        btnClearForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearFormMouseClicked(evt);
            }
        });

        jLabel7.setText("Loại khách hàng");

        jLabel8.setText("Tổng chi tiêu");

        buttonGroup2.add(rdoVip);
        rdoVip.setText("VIP");
        rdoVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoVipActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoThuong);
        rdoThuong.setText("Thường");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoNu))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addComponent(txtTenKH)
                                .addComponent(txtSDT)
                                .addComponent(txtEmail)
                                .addComponent(txtTCT))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnThemKH)
                                .addGap(53, 53, 53)
                                .addComponent(btnClearForm))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdoVip)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoThuong))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(rdoVip)
                            .addComponent(rdoThuong))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemKH)
                            .addComponent(btnClearForm)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121))
        );

        jTabbedPane2.addTab("Danh sách khách hàng", jPanel3);

        jPanel5.setBackground(new java.awt.Color(0, 255, 204));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(242, 242, 242));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Quản lý khách hàng");

        BackKH.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        BackKH.setForeground(new java.awt.Color(242, 242, 242));
        BackKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackKH.setText("Back");
        BackKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackKHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackKHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackKHMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackKH, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackKH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnChonKhachHang.setBackground(new java.awt.Color(0, 255, 204));
        btnChonKhachHang.setText("Chọn");
        btnChonKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonKhachHangMouseClicked(evt);
            }
        });
        btnChonKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(561, 561, 561)
                .addComponent(btnChonKhachHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChonKhachHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        int index = tblKhachHang.getSelectedRow();
        this.showData(index);
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        // TODO add your handling code here:
        if (checkData()) {
            KhachHang kh = this.readFor();
            if (service.getKH(kh.getMAKH()) != null) {
                JOptionPane.showMessageDialog(this, "Mã trùng");
            } else {
                if (service.Them(kh) > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    fillTable(service.getAllKH());
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            }
        }
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btnClearFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearFormMouseClicked
        clearForm();
    }//GEN-LAST:event_btnClearFormMouseClicked

    private void rdoVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoVipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoVipActionPerformed

    private void BackKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackKHMouseClicked
        HomeForm form = new HomeForm();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BackKHMouseClicked

    private void BackKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackKHMouseEntered
        BackKH.setLayout(new BorderLayout(10, 10));
        BackKH.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));
    }//GEN-LAST:event_BackKHMouseEntered

    private void BackKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackKHMouseExited
        BackKH.setLayout(null);
        BackKH.setBorder(null);
    }//GEN-LAST:event_BackKHMouseExited

    private void btnChonKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonKhachHangMouseClicked
        //        bh.(getData());
        this.setVisible(false);
    }//GEN-LAST:event_btnChonKhachHangMouseClicked

    private void btnChonKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKhachHangActionPerformed
        maKH = txtMaKH.getText();
        tenKH = txtTenKH.getText();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChonKhachHangActionPerformed

    private void txtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyPressed
        // TODO add your handling code here:
        findmaKM();
    }//GEN-LAST:event_txtFindKeyPressed

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
            java.util.logging.Logger.getLogger(KhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KhachHangView dialog = new KhachHangView(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel BackKH;
    private javax.swing.JButton btnChonKhachHang;
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnThemKH;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoThuong;
    private javax.swing.JRadioButton rdoVip;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTCT;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
