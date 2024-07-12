/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.KhuyenMai;
import Service.KhuyenMaiService;
import edusys.XImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class KhuyenMaiView extends javax.swing.JFrame {

    KhuyenMaiService service = new KhuyenMaiService();
    DefaultTableModel mol = new DefaultTableModel();
    int index = -1;

 
    public KhuyenMaiView() {
        initComponents();
        this.fillTable(service.getAll());
        this.setLocationRelativeTo(null);
        init();
    }
    void init() {
        setIconImage(XImage.getAppIcon());
        setTitle("Khuyến Mãi");
    }
    public void fillTable(List<KhuyenMai> list) {
        mol = (DefaultTableModel) tblBangKM.getModel();
        mol.setRowCount(0);
        for (KhuyenMai khuyenMai : list) {
            mol.addRow(khuyenMai.toDataRow());
        }
    }

    public void showData() throws ParseException {
        KhuyenMai khuyenMai = service.getAll().get(index);
        txtMaKM.setText(khuyenMai.getMaKM());
        txtTenKM.setText(khuyenMai.getTenKM());
        txtDieuKien.setText(khuyenMai.getDieuKien());
        txtNgayBD.setText(khuyenMai.getNgayBatDau());
        txtNgayKT.setText(khuyenMai.getNgayKetThuc());
        txtMucKhuyenMai.setText(khuyenMai.getMucKhuyenMai());
        txtpaneMota.setText(khuyenMai.getMoTa());

    }

    public KhuyenMai readFor() {
        String MaKM, TenChuongTrinh, DieuKien, NgayBD, NgayKT, MucKhuyenMai,Mota;

        MaKM = txtMaKM.getText();
        TenChuongTrinh = txtTenKM.getText();
        DieuKien = txtDieuKien.getText();
        NgayBD = txtNgayBD.getText();
        NgayKT =txtNgayKT.getText();
        MucKhuyenMai = txtMucKhuyenMai.getText();
        Mota = txtpaneMota.getText();
        return new KhuyenMai(MaKM, TenChuongTrinh, DieuKien, NgayBD, NgayKT, MucKhuyenMai, Mota);

    }

    public boolean checkData() {
        if (txtMaKM.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã");
            return false;
        }
        if (txtTenKM.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên");
            return false;
        }
        if (txtDieuKien.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập điều kiện");
            return false;
        }
        if (txtMucKhuyenMai.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập khuyến mãi");
            return false;
        }

        String inputText = txtMucKhuyenMai.getText().trim();
        String cleanedInput = inputText.replaceAll("\\s", "");  // Loại bỏ khoảng trắng
        String regex = "\\d+(%|\\s*VND)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cleanedInput);
        if (!matcher.find()) {
            JOptionPane.showMessageDialog(this, "Không hợp lệ. Yêu cầu nhập số và có đuôi là '%' hoặc 'VND'.");
            return false;
        }

        if (txtNgayBD.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập NgayBD");
            return false;
        }
        if (txtNgayKT.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập NgayKT");
            return false;
        }
        return true;
    }
public void findmaKM() {
        String keyword = txtFind.getText().trim();
        List<KhuyenMai> listFindmaKM = new ArrayList<>();
        List<KhuyenMai> listKM = service.getAll();
        
            for (KhuyenMai km: listKM) {
                if (km.getMaKM().contains(keyword)) {
                    listFindmaKM.add(km);
                }
            } 
            fillTable(listFindmaKM);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        txtTenKM = new javax.swing.JTextField();
        txtMucKhuyenMai = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtpaneMota = new javax.swing.JTextPane();
        btnTao = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtDieuKien = new javax.swing.JTextField();
        txtNgayBD = new javax.swing.JTextField();
        txtNgayKT = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBangKM = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chương trình khuyến mại"));

        jLabel3.setText("Tạo mã khuyễn mại");

        jLabel10.setText("Tên khuyến mại ");

        jLabel11.setText("Điều kiện");

        jLabel12.setText("Ngày bắt đầu ");

        jLabel13.setText("Ngày kết thúc");

        txtTenKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKMActionPerformed(evt);
            }
        });

        jLabel14.setText("Mô tả");

        jScrollPane1.setViewportView(txtpaneMota);

        btnTao.setText("Tạo");
        btnTao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoMouseClicked(evt);
            }
        });
        btnTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnreset.setText("Reset");
        btnreset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnresetMouseClicked(evt);
            }
        });
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        jLabel15.setText("Khuyến mãi");

        txtDieuKien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDieuKienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnTao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(335, 335, 335))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNgayKT, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                            .addComponent(txtNgayBD, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1)
                        .addGap(119, 119, 119))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtMucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách khuyến mại"));

        jLabel9.setText("Phần tìm kiếm");

        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFindKeyPressed(evt);
            }
        });

        tblBangKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã KM", "Tên chương trình", "Điều kiện", "Ngày bắt đầu", "Ngày kết thúc", "Mục khuyến mại", "Mô Tả"
            }
        ));
        tblBangKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangKMMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblBangKM);

        jScrollPane2.setViewportView(jScrollPane3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 244, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý khuyến mại");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Back");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBangKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangKMMouseClicked
        index = tblBangKM.getSelectedRow();
        try {
            this.showData();
        } catch (ParseException ex) {
            Logger.getLogger(KhuyenMaiView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblBangKMMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        HomeForm form = new HomeForm();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setLayout(new BorderLayout(10, 10));
        jLabel4.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setLayout(null);
        jLabel4.setBorder(null);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

    }//GEN-LAST:event_jButton3MouseClicked

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindActionPerformed

    private void txtDieuKienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDieuKienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDieuKienActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnresetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseClicked
        txtMaKM.setText("");
        txtTenKM.setText("");
        txtDieuKien.setText("");
        txtMucKhuyenMai.setText("");
        txtNgayBD.setText("");
        txtNgayKT.setText("");
        txtpaneMota.setText("");
    }//GEN-LAST:event_btnresetMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        index = tblBangKM.getSelectedRow();
        KhuyenMai khuyenMai = this.readFor();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng cần sửa");

        }else{
            String Ma=tblBangKM.getValueAt(index, 0).toString();
            if (service.update(khuyenMai, Ma)>0) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                fillTable(service.getAll());

            }else{
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        }
    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTaoActionPerformed

    private void btnTaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoMouseClicked
        if (checkData()) {
            KhuyenMai khuyenMai = this.readFor();
            if (service.getKM(khuyenMai.getMaKM()) != null) {
                JOptionPane.showMessageDialog(this, "Mã trùng");
            } else {
                if (service.add(khuyenMai) > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    fillTable(service.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            }
        }
    }//GEN-LAST:event_btnTaoMouseClicked

    private void txtTenKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKMActionPerformed

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
            java.util.logging.Logger.getLogger(KhuyenMaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhuyenMaiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTao;
    private javax.swing.JButton btnreset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblBangKM;
    private javax.swing.JTextField txtDieuKien;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtMucKhuyenMai;
    private javax.swing.JTextField txtNgayBD;
    private javax.swing.JTextField txtNgayKT;
    private javax.swing.JTextField txtTenKM;
    private javax.swing.JTextPane txtpaneMota;
    // End of variables declaration//GEN-END:variables
}
