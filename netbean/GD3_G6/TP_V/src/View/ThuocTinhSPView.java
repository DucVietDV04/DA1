/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.ChatLieu;
import Model.DanhMuc;
import Model.MauSac;
import Model.NhaSanXuat;
import Service.ChatLieuService;
import Service.DanhMucService;
import Service.MauSacSevice;
import Service.NhaSanXuatSevice;
import edusys.XImage;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puddi
 */
public class ThuocTinhSPView extends javax.swing.JFrame {

    DefaultTableModel mol = new DefaultTableModel();
    MauSacSevice msService = new MauSacSevice();
    DanhMucService dmService = new DanhMucService();
    NhaSanXuatSevice nsxService = new NhaSanXuatSevice();
    ChatLieuService clService = new ChatLieuService();

    public ThuocTinhSPView() {
        initComponents();
        setLocationRelativeTo(null);
        init();
    }
        void init() {
        setIconImage(XImage.getAppIcon());
        setTitle("Thuộc Tính");
    }

    public void fillTable(int i) {
        if (i == 1) {
            this.setTitle("Màu sắc");
            formThuocTinh.setBorder(new TitledBorder("Màu sắc"));
            fillMauSac();
        }
        if (i == 2) {
            this.setTitle("Chất liệu");
            formThuocTinh.setBorder(new TitledBorder("Chất liệu"));
            fillChatLieu();
        }
        if (i == 3) {
            this.setTitle("Danh mục");
            formThuocTinh.setBorder(new TitledBorder("Danh mục"));
            fillDanhMuc();
        }
        if (i == 4) {
            this.setTitle("Nhà sản xuất");
            formThuocTinh.setBorder(new TitledBorder("Nhà sản xuất"));
            fillNSX();
        }

    }

    boolean checkForm() {
        if (txtMaTT.getText().trim().isEmpty()
                || txtTenTT.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa điền đủ thông tin");
            return false;
        }
        boolean a = false, b = false, c = false, d = false;
        for (MauSac object : msService.getAllMS()) {
            if (object.getTenMS().equals(txtTenTT.getText().trim())) {
                a = true;
                break;
            }
        }
        if (a) {
            JOptionPane.showMessageDialog(this, "Màu đã tồn tại!");
            return false;
        }
        for (DanhMuc object : dmService.getAllDM()) {
            if (object.getTenDM().equals(txtTenTT.getText().trim())) {
                b = true;
                break;
            }
        }
        if (b) {
            JOptionPane.showMessageDialog(this, "Danh mục đã tồn tại!");
            return false;
        }
        for (ChatLieu object : clService.getAllChatLieu()) {
            if (object.getTenCL().equals(txtTenTT.getText().trim())) {
                c = true;
                break;
            }
        }
        if (c) {
            JOptionPane.showMessageDialog(this, "Chất liệu đã tồn tại!");
            return false;
        }
        for (NhaSanXuat object : nsxService.getAllNSX()) {
            if (object.getTenNSX().equals(txtTenTT.getText().trim())) {
                d = true;
                break;
            }
        }
        if (d) {
            JOptionPane.showMessageDialog(this, "Nhà sản xuất đã tồn tại!");
            return false;
        }

        return true;
    }

    boolean checkFormSua() {
        if (txtMaTT.getText().trim().isEmpty()
                || txtTenTT.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa điền đủ thông tin");
            return false;
        }
        boolean a = false, b = false, c = false, d = false;
        for (MauSac object : msService.getAllMS()) {
            if (object.getMaMS().equals(txtMaTT.getText().trim())) {
                a = true;
                break;
            }
        }
        if (!a&&this.getTitle().equalsIgnoreCase("Màu sắc")) {
            JOptionPane.showMessageDialog(this, "Mã màu không tồn tại!");
            return false;
        }
        for (DanhMuc object : dmService.getAllDM()) {
            if (object.getMaDM().equals(txtMaTT.getText().trim())) {
                b = true;
                break;
            }
        }
        if (!b&&this.getTitle().equalsIgnoreCase("Danh mục")) {
            JOptionPane.showMessageDialog(this, "Mã danh mục không tồn tại!");
            return false;
        }
        for (ChatLieu object : clService.getAllChatLieu()) {
            if (object.getStt().equals(txtMaTT.getText().trim())) {
                c = true;
                break;
            }
        }
        if (!c&&this.getTitle().equalsIgnoreCase("Chất liệu")) {
            JOptionPane.showMessageDialog(this, "Mã chất liệu không tồn tại!");
            return false;
        }
        for (NhaSanXuat object : nsxService.getAllNSX()) {
            if (object.getMaNSX().equals(txtMaTT.getText().trim())) {
                d = true;
                break;
            }
        }
        if (!d&&this.getTitle().equalsIgnoreCase("Nhà sản xuất")) {
            JOptionPane.showMessageDialog(this, "Mã nhà sản xuất không tồn tại!");
            return false;
        }

        return true;
    }

    void fillMauSac() {
        mol = (DefaultTableModel) tblBangTT.getModel();
        mol.setRowCount(0);
        int i = 1;
        for (MauSac ms : msService.getAllMS()) {
            mol.addRow(new Object[]{
                i, ms.getTenMS()
            });
            i++;
        }
    }

    void fillDanhMuc() {
        mol = (DefaultTableModel) tblBangTT.getModel();
        mol.setRowCount(0);
        for (DanhMuc dm : dmService.getAllDM()) {
            mol.addRow(new Object[]{
                dm.getMaDM(), dm.getTenDM()
            });
        }
    }

    void fillNSX() {
        mol = (DefaultTableModel) tblBangTT.getModel();
        mol.setRowCount(0);
        for (NhaSanXuat nsx : nsxService.getAllNSX()) {
            mol.addRow(new Object[]{
                nsx.getMaNSX(), nsx.getTenNSX()
            });
        }
    }

    void fillChatLieu() {
        mol = (DefaultTableModel) tblBangTT.getModel();
        mol.setRowCount(0);
        for (ChatLieu cl : clService.getAllChatLieu()) {
            mol.addRow(new Object[]{
                cl.getStt(), cl.getTenCL()
            });
        }
    }

    public MauSac getMSOnForm() {
        String a = txtMaTT.getText().trim();
        String b = txtTenTT.getText().trim();
        return new MauSac(a, b);
    }

    public DanhMuc getDMOnForm() {
        String a = txtMaTT.getText().trim();
        String b = txtTenTT.getText().trim();
        return new DanhMuc(a, b);
    }

    public ChatLieu getClOnForm() {
        String a = txtMaTT.getText().trim();
        String b = txtTenTT.getText().trim();
        return new ChatLieu(a, b);
    }

    public NhaSanXuat getNSXOnForm() {
        String a = txtMaTT.getText().trim();
        String b = txtTenTT.getText().trim();
        return new NhaSanXuat(a, b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        formThuocTinh = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtTenTT = new javax.swing.JTextField();
        btnThemTT = new javax.swing.JButton();
        btnSuaTT = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtMaTT = new javax.swing.JTextField();
        btnclean = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBangTT = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thuộc tính Sản Phẩm");

        formThuocTinh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thuộc tính sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel12.setText("Tên thuộc tính");

        btnThemTT.setText("THÊM");
        btnThemTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemTTMouseClicked(evt);
            }
        });

        btnSuaTT.setText("SỬA");
        btnSuaTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaTTMouseClicked(evt);
            }
        });

        jLabel14.setText("Mã thuộc tính");

        btnclean.setText("Clean");
        btnclean.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncleanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout formThuocTinhLayout = new javax.swing.GroupLayout(formThuocTinh);
        formThuocTinh.setLayout(formThuocTinhLayout);
        formThuocTinhLayout.setHorizontalGroup(
            formThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formThuocTinhLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(formThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formThuocTinhLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenTT, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formThuocTinhLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnThemTT)
                        .addGap(55, 55, 55)
                        .addComponent(btnSuaTT)
                        .addGap(59, 59, 59)
                        .addComponent(btnclean)))
                .addGap(55, 55, 55))
        );
        formThuocTinhLayout.setVerticalGroup(
            formThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formThuocTinhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemTT)
                    .addComponent(btnSuaTT)
                    .addComponent(btnclean))
                .addGap(18, 18, 18)
                .addGroup(formThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTenTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblBangTT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "MÃ", "TÊN "
            }
        ));
        tblBangTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangTTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBangTT);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 255, 204));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1122.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("THUỘC TÍNH SẢN PHẨM");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemTTMouseClicked
        if (checkForm()) {
            if (this.getTitle().equalsIgnoreCase("Màu sắc")) {
                MauSac ms = getMSOnForm();
                if (msService.AddMS(ms) > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                    fillMauSac();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                }
            } else if (this.getTitle().equalsIgnoreCase("Chất liệu")) {
                ChatLieu ms = getClOnForm();
                if (clService.AddChatLieu(ms) > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                    fillChatLieu();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                }
            } else if (this.getTitle().equalsIgnoreCase("Danh mục")) {
                DanhMuc ms = getDMOnForm();
                if (dmService.AddDM(ms) > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                    fillDanhMuc();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                }
            } else if (this.getTitle().equalsIgnoreCase("Nhà sản xuất")) {
                NhaSanXuat ms = getNSXOnForm();
                if (nsxService.AddNSX(ms) > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                    fillNSX();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                }
            }
        }
    }//GEN-LAST:event_btnThemTTMouseClicked

    private void btnSuaTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaTTMouseClicked
        if (checkFormSua()) {
            if (this.getTitle().equalsIgnoreCase("Màu sắc")) {
                MauSac ms = getMSOnForm();
                if (msService.UpdateMS(ms) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công!");
                    fillMauSac();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại!");
                }
            } else if (this.getTitle().equalsIgnoreCase("Chất liệu")) {
                ChatLieu ms = getClOnForm();
                if (clService.updateChatLieu(ms) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công!");
                    fillChatLieu();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại!");
                }
            } else if (this.getTitle().equalsIgnoreCase("Danh mục")) {
                DanhMuc ms = getDMOnForm();
                if (dmService.UpdateDM(ms) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công!");
                    fillDanhMuc();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại!");
                }
            } else if (this.getTitle().equalsIgnoreCase("Nhà sản xuất")) {
                NhaSanXuat ms = getNSXOnForm();
                if (nsxService.UpdateNSX(ms) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công!");
                    fillNSX();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại!");
                }
            }
        }
    }//GEN-LAST:event_btnSuaTTMouseClicked

    private void btncleanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncleanMouseClicked
        txtMaTT.setText("");
        txtTenTT.setText("");
    }//GEN-LAST:event_btncleanMouseClicked

    private void tblBangTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangTTMouseClicked
        int index = tblBangTT.getSelectedRow();
        txtMaTT.setText(tblBangTT.getValueAt(index, 0).toString());
        txtTenTT.setText(tblBangTT.getValueAt(index, 1).toString());
    }//GEN-LAST:event_tblBangTTMouseClicked

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
            java.util.logging.Logger.getLogger(ThuocTinhSPView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThuocTinhSPView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThuocTinhSPView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThuocTinhSPView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThuocTinhSPView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaTT;
    private javax.swing.JButton btnThemTT;
    private javax.swing.JButton btnclean;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel formThuocTinh;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBangTT;
    private javax.swing.JTextField txtMaTT;
    private javax.swing.JTextField txtTenTT;
    // End of variables declaration//GEN-END:variables
}
