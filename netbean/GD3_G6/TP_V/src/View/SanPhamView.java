/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.SanPham;
import Service.DanhMucService;
import Service.SanPhamService;
import edusys.XImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puddi
 */
public class SanPhamView extends javax.swing.JFrame {
    DanhMucService dmService = new DanhMucService();
    DefaultTableModel mol = new DefaultTableModel();
    SanPhamService spService = new SanPhamService();
    int a;
    int index = -1;

    public SanPhamView() {
        initComponents();
        setLocationRelativeTo(null);
        fillTableSP(spService.getAllSP());
        init();
    }
    void init() {
        setIconImage(XImage.getAppIcon());
        setTitle("Sản Phẩm");
    }
    public void reload() {
        // Reload cửa sổ cha
        this.dispose();
        new SanPhamView().setVisible(true);

    }

    void fillTableSP(List<SanPham> list) {
        mol = (DefaultTableModel) tblSanPham.getModel();
        mol.setRowCount(0);
        for (SanPham sanPham : list) {
            mol.addRow(sanPham.todataRow());
        }
    }
    public void trangThaiRD() {
        List<SanPham> list = new ArrayList<>();
        if (rdCon.isSelected()) {
            for (SanPham sanPham : spService.getAll()) {
                if (sanPham.getTrangThai().equals("1")) {
                    list.add(sanPham);
                }
            }
        }
        if (rdHet.isSelected()) {
            for (SanPham sanPham : spService.getAll()) {
                if (sanPham.getTrangThai().equals("0")) {
                    list.add(sanPham);
                }
            }
        }
        fillTableSP(list);

    }

    public void find() {
        String keyword = txtTimKiem.getText().trim();
        List<SanPham> listFindmaSP = new ArrayList<>();
        List<SanPham> listFindTenSP = new ArrayList<>();
        List<SanPham> listFindDM = new ArrayList<>();
        List<SanPham> listFindNSX = new ArrayList<>();
        List<SanPham> listSP = spService.getAll();
        if (rdMaSP.isSelected()) {
            for (SanPham sanPham : listSP) {
                if (sanPham.getMaSP().contains(keyword)) {
                    listFindmaSP.add(sanPham);
                }
            }
            fillTableSP(listFindmaSP);
        }
        if (rdTenSP.isSelected()) {
            for (SanPham sanPham : listSP) {
                if (sanPham.getTenSP().contains(keyword)) {
                    listFindTenSP.add(sanPham);
                }
            }
            fillTableSP(listFindTenSP);
        }
        if (rdDanhMuc.isSelected()) {
            for (SanPham sanPham : listSP) {
                if (sanPham.getMaDM().contains(keyword)) {
                    listFindDM.add(sanPham);
                }
            }
            fillTableSP(listFindDM);
        }
        if (rdNhaSX.isSelected()) {
            for (SanPham sanPham : listSP) {
                if (sanPham.getMaNSX().contains(keyword)) {
                    listFindNSX.add(sanPham);
                }
            }
            fillTableSP(listFindNSX);
        }
    }

    public void hienThiThuocTinh(int i) {
        // Tạo đối tượng là cửa sổ khác
        ThuocTinhSPView tt = new ThuocTinhSPView();
        // Thêm sự kiện addWindowListender khi kết thúc cửa sổ mới
        tt.addWindowListener(new WindowAdapter() {
            @Override
            //Thực hiện ghi đè phương thức sự kiện
            public void windowClosed(WindowEvent e) {
                // Đưa phương thức muốn reload lại khi tắt cửa sổ con
                fillTableSP(spService.getAllSP());
            }
        });
        //Thực hiện tạo các thuộc tính khi bắt đầu mở cửa sổ con
        tt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tt.setSize(1000, 600);
        tt.fillTable(i);
        tt.setLocationRelativeTo(this);
        tt.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupTimMa = new javax.swing.ButtonGroup();
        gruopTrangThai = new javax.swing.ButtonGroup();
        buttonGroupThuocTinhSanPham = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        BackSP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        rdMaSP = new javax.swing.JRadioButton();
        rdTenSP = new javax.swing.JRadioButton();
        rdDanhMuc = new javax.swing.JRadioButton();
        rdNhaSX = new javax.swing.JRadioButton();
        rdHet = new javax.swing.JRadioButton();
        rdCon = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rdMauSac = new javax.swing.JRadioButton();
        rdChatLieu = new javax.swing.JRadioButton();
        rdTenDM = new javax.swing.JRadioButton();
        rdTenNSX = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sản phẩm");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Mã danh mục", "Mã nhà sản xuất", "Đơn giá", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSanPhamMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        jPanel1.setBackground(new java.awt.Color(51, 255, 204));

        BackSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BackSP.setForeground(new java.awt.Color(255, 255, 255));
        BackSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        BackSP.setText("BACK");
        BackSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackSPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackSPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackSPMouseExited(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1122.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(BackSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(BackSP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtTimKiem.setText("Tìm kiếm ở đây...");
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        groupTimMa.add(rdMaSP);
        rdMaSP.setText("Mã sản phẩm");
        rdMaSP.setBorderPainted(true);
        rdMaSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdMaSPMouseClicked(evt);
            }
        });

        groupTimMa.add(rdTenSP);
        rdTenSP.setText("Tên sản phẩm");
        rdTenSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTenSPMouseClicked(evt);
            }
        });

        groupTimMa.add(rdDanhMuc);
        rdDanhMuc.setText("Mã danh mục");
        rdDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdDanhMucMouseClicked(evt);
            }
        });

        groupTimMa.add(rdNhaSX);
        rdNhaSX.setText("Mã nhà sản xuất");
        rdNhaSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdNhaSXMouseClicked(evt);
            }
        });
        rdNhaSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNhaSXActionPerformed(evt);
            }
        });

        gruopTrangThai.add(rdHet);
        rdHet.setText("Hết hàng");
        rdHet.setBorderPainted(true);
        rdHet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdHetMouseClicked(evt);
            }
        });

        gruopTrangThai.add(rdCon);
        rdCon.setText("Còn hàng");
        rdCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdConMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setText("Trạng thái");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setText("Thuộc tính sản phẩm");

        buttonGroupThuocTinhSanPham.add(rdMauSac);
        rdMauSac.setText("Màu sắc");
        rdMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdMauSacMouseClicked(evt);
            }
        });

        buttonGroupThuocTinhSanPham.add(rdChatLieu);
        rdChatLieu.setText("Chất liệu");
        rdChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdChatLieuMouseClicked(evt);
            }
        });

        buttonGroupThuocTinhSanPham.add(rdTenDM);
        rdTenDM.setText("Danh mục");
        rdTenDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTenDMMouseClicked(evt);
            }
        });

        buttonGroupThuocTinhSanPham.add(rdTenNSX);
        rdTenNSX.setText("Nhà sản xuất");
        rdTenNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTenNSXMouseClicked(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1082, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdMaSP)
                                    .addComponent(rdDanhMuc))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdTenSP)
                                    .addComponent(rdNhaSX))))
                        .addGap(125, 125, 125)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addComponent(rdCon)
                                .addGap(53, 53, 53)
                                .addComponent(rdHet))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdMauSac)
                                .addGap(44, 44, 44)
                                .addComponent(rdChatLieu)
                                .addGap(38, 38, 38)
                                .addComponent(rdTenDM)
                                .addGap(40, 40, 40)
                                .addComponent(rdTenNSX)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(503, 503, 503)
                .addComponent(btnThem)
                .addGap(88, 88, 88)
                .addComponent(btnXoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(rdCon)
                    .addComponent(rdHet))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdMaSP)
                    .addComponent(rdTenSP)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdMauSac)
                            .addComponent(rdChatLieu)
                            .addComponent(rdTenDM)
                            .addComponent(rdTenNSX))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdDanhMuc)
                            .addComponent(rdNhaSX))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackSPMouseClicked
        HomeForm form1 = new HomeForm();
        form1.setVisible(true);
        form1.pack();
        form1.setLocationRelativeTo(null);
        form1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BackSPMouseClicked

    private void BackSPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackSPMouseEntered
        BackSP.setLayout(new BorderLayout(10, 10));
        BackSP.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));
    }//GEN-LAST:event_BackSPMouseEntered

    private void BackSPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackSPMouseExited
        BackSP.setLayout(null);
        BackSP.setBorder(null);
    }//GEN-LAST:event_BackSPMouseExited

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
      
    }//GEN-LAST:event_tblSanPhamMouseClicked
    private void spCl(){
        int index = tblSanPham.getSelectedRow();
        String maSP = tblSanPham.getValueAt(index, 0).toString();
        SanPhamChiTietView tt = new SanPhamChiTietView();
        tt.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                fillTableSP(spService.getAllSP());
            }
        });
        tt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tt.setSize(1200, 650);
        tt.fillFormCTSP(maSP);
        tt.setLocationRelativeTo(this);
        tt.setVisible(true);
    }
    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        find();
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void rdNhaSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNhaSXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNhaSXActionPerformed

    private void rdConMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdConMouseClicked
        trangThaiRD();
    }//GEN-LAST:event_rdConMouseClicked

    private void rdHetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdHetMouseClicked
        trangThaiRD();
    }//GEN-LAST:event_rdHetMouseClicked

    private void rdMaSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdMaSPMouseClicked
        find();
    }//GEN-LAST:event_rdMaSPMouseClicked

    private void rdTenSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTenSPMouseClicked
        find();
    }//GEN-LAST:event_rdTenSPMouseClicked

    private void rdDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdDanhMucMouseClicked
        find();
    }//GEN-LAST:event_rdDanhMucMouseClicked

    private void rdNhaSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdNhaSXMouseClicked
        find();
    }//GEN-LAST:event_rdNhaSXMouseClicked

    private void rdMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdMauSacMouseClicked
        hienThiThuocTinh(1);
    }//GEN-LAST:event_rdMauSacMouseClicked

    private void rdChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdChatLieuMouseClicked
        hienThiThuocTinh(2);
    }//GEN-LAST:event_rdChatLieuMouseClicked

    private void rdTenDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTenDMMouseClicked
        hienThiThuocTinh(3);
    }//GEN-LAST:event_rdTenDMMouseClicked

    private void rdTenNSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTenNSXMouseClicked
        hienThiThuocTinh(4);
    }//GEN-LAST:event_rdTenNSXMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        //int index = tblSanPham.getSelectedRow();
        //String maSP = tblSanPham.getValueAt(index, 0).toString();
        SanPhamChiTietView1 tt = new SanPhamChiTietView1();
        tt.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                fillTableSP(spService.getAllSP());
            }
        });
        tt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tt.setSize(1200, 650);
       // tt.fillFormCTSP(maSP);
        tt.setLocationRelativeTo(this);
        tt.setVisible(true);
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // TODO add your handling code here:
        index = tblSanPham.getSelectedRow();
        String sp = tblSanPham.getValueAt(index, 0).toString();
        if (spService.xoaSP(sp) > 0) {
            JOptionPane.showMessageDialog(this, "Xóa Thành công");
            fillTableSP(spService.getAll());
        }else{
            JOptionPane.showMessageDialog(this, "XÓA THẤT BẠI");
        }
        
    }//GEN-LAST:event_btnXoaMouseClicked

    private void tblSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount()== 2) {
            spCl();
        }else{
            index = tblSanPham.getSelectedRow();
        }
    }//GEN-LAST:event_tblSanPhamMousePressed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(SanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPhamView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackSP;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroupThuocTinhSanPham;
    private javax.swing.ButtonGroup groupTimMa;
    private javax.swing.ButtonGroup gruopTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdChatLieu;
    private javax.swing.JRadioButton rdCon;
    private javax.swing.JRadioButton rdDanhMuc;
    private javax.swing.JRadioButton rdHet;
    private javax.swing.JRadioButton rdMaSP;
    private javax.swing.JRadioButton rdMauSac;
    private javax.swing.JRadioButton rdNhaSX;
    private javax.swing.JRadioButton rdTenDM;
    private javax.swing.JRadioButton rdTenNSX;
    private javax.swing.JRadioButton rdTenSP;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

  

}
