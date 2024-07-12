/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.HoaDon;
import Model.KhachHang;
import Model.KhuyenMai;
import Model.SanPham;
import Service.HoaDonService;
import Service.KhuyenMaiService;
import Service.SanPhamService;
import edusys.XImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class BanHangView extends javax.swing.JFrame {

    DefaultTableModel mol = new DefaultTableModel();
    SanPhamService spService = new SanPhamService();
    List<SanPham> list = new ArrayList<>();
    HoaDonService hdService = new HoaDonService();
    List<HoaDon> lst = hdService.getAllHD();
    KhuyenMaiService kmService = new KhuyenMaiService();
    List<KhuyenMai> listKM = new ArrayList<>();
    int so = hdService.countHoaDon();
    int so2 = hdService.countHoaDon();
    int index = -1;
    String userName;

    public BanHangView() {
        initComponents();
        setLocationRelativeTo(null);
        fillTableSP(spService.getAll());
        txtTienKH.setText("0");
        init();
    }

    void init() {
        setIconImage(XImage.getAppIcon());
        setTitle("Bán Hàng");
    }

    public void fillTableSP(List<SanPham> list) {
        mol = (DefaultTableModel) tblSanPham.getModel();
        mol.setRowCount(0);
        for (SanPham sp : list) {
            mol.addRow(new Object[]{
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getDonGia2(),
                sp.getMauSac(),
                sp.getChatLieu(),
                sp.getKichThuoc(),
                sp.getSoLuong(),});
        }
    }

    public void fillTableHD(List<HoaDon> lst) {

        mol.setRowCount(0);
        for (HoaDon hd : lst) {
            mol.addRow(new Object[]{
                hd.getMaHD(),
                hd.getNgayTao(),
                hd.getTongTien()
            });
        }
    }

    // gán giá trị vào ô text trong khu Đơn hàng
    public void setKH(KhachHang kh) {
        txtMaKH.setText(kh.getMAKH());
        txtTenKH.setText(kh.getHoTen());

    }

    // lấy dữ liệu sản phẩm từ bảng
    public SanPham getSP() {
        int index = tblSanPham.getSelectedRow();
        String maSP, tenSP, donGia;
        maSP = tblSanPham.getValueAt(index, 0).toString();
        tenSP = tblSanPham.getValueAt(index, 1).toString();
        donGia = tblSanPham.getValueAt(index, 2).toString();
        return new SanPham(maSP, tenSP, maSP, maSP, donGia, donGia);
    }

    public String maTangTuDong(String HD) {
        so++;
        String maHD = HD + String.format("%04d", so);
        return maHD;
    }

    public String maTangTuDong2(String HD) {
        so2++;
        String maHD = HD + String.format("%04d", so2);
        return maHD;
    }

    public void taoHD(List<HoaDon> list) {
//        LoginView lg = new LoginView();
        String maHD = maTangTuDong("HD");
        lblMaHD.setText(maTangTuDong2("HD"));
//        userName = LoginView.getTaiKhoan();
        LocalDate ngayTao = LocalDate.now();
        mol = (DefaultTableModel) tblHoaDonCho.getModel();
        mol.addRow(new Object[]{
            this.tblHoaDonCho.getRowCount() + 1, maHD, ngayTao, txtTenKH.getText().equals("") ? "Khách bán lẻ" : txtTenKH.getText()
        });
        if (txtMaKH.getText().equals("")) {
            txtMaKH.setText("KH000");
            txtTenKH.setText("Khách bán lẻ");
        }

    }

    // điền vào các lbl trong khung đơn hàng
    public void donHang() {
        int total = 0;
        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            Integer value = (Integer) tblGioHang.getValueAt(i, 4);
            total += value;
        }
        lblTongTien.setText(String.valueOf(total));
        lblGiamGia.setText("20%");
        lblThanhToan.setText(String.valueOf(total * 0.8));
        int tienKH = Integer.parseInt(txtTienKH.getText());
        lblTienThua.setText(String.valueOf(tienKH - total * 0.8));

        if (lblTongTien.getText().trim().isEmpty()) {
            btnChonKH.setEnabled(false);
        }

        if ((tienKH - total * 0.8) < 0) {
            btnThanhToan.setEnabled(false);
            return;
        } else {
            btnThanhToan.setEnabled(true);
        }

    }

    public void xoaSP() {
        int index = tblGioHang.getSelectedRow();
        mol = (DefaultTableModel) tblGioHang.getModel();
        mol.removeRow(index);
    }

    public void clear() {

        mol.setRowCount(0);
    }

    public void find() {
        String keyword = txtFind.getText().trim();
        List<SanPham> listFindmaSP = new ArrayList<>();
        List<SanPham> listSP = spService.getAll();
        for (SanPham sanPham : listSP) {
            if (sanPham.getMaSP().contains(keyword)) {
                listFindmaSP.add(sanPham);
            }
        }
        fillTableSP(listFindmaSP);

    }

    public void find1() {
        String keyword = txtFind.getText().trim();
        List<SanPham> listFindTenSP = new ArrayList<>();
        List<SanPham> listSP = spService.getAll();

        for (SanPham sanPham : listSP) {
            if (sanPham.getTenSP().contains(keyword)) {
                listFindTenSP.add(sanPham);
            }
        }
        fillTableSP(listFindTenSP);

    }

//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        BackBH = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelDonHang = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        btnChonKH = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JScrollPane();
        txtGC = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        btnHuyHD = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        cboLoaiThanhToan = new javax.swing.JComboBox<>();
        txtTienKH = new javax.swing.JTextField();
        lblMaHD = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        lblThanhToan = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnTaoMaHD = new javax.swing.JButton();
        panelSanPham = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        btnThemSP = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonCho = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoaSPGioHang = new javax.swing.JButton();
        btnClearGioHang = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1188, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 255, 204));

        BackBH.setBackground(new java.awt.Color(183, 151, 104));
        BackBH.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        BackBH.setForeground(new java.awt.Color(255, 255, 255));
        BackBH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        BackBH.setText("BACK");
        BackBH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackBHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackBHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackBHMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BÁN HÀNG");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/895580.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(BackBH, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 977, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(BackBH))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        panelDonHang.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn hàng"));

        jLabel3.setText("Mã khách hàng :");

        jLabel4.setText("Tên khách hàng :");

        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        btnChonKH.setBackground(new java.awt.Color(0, 255, 204));
        btnChonKH.setText("Chọn");
        btnChonKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonKHMouseClicked(evt);
            }
        });
        btnChonKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(txtMaKH))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChonKH, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChonKH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Mã hóa đơn :");

        jLabel6.setText("Tổng tiền");

        jLabel7.setText("Giảm giá");

        jLabel8.setText("Thanh toán");

        jLabel9.setText("Tiền khách đưa");

        jLabel10.setText("Tiền thừa trả khách");

        jLabel11.setText("Hình thức thanh toán");

        jLabel12.setText("Hình thức giao hàng");

        txtGC.setColumns(20);
        txtGC.setRows(5);
        txtGhiChu.setViewportView(txtGC);

        jLabel13.setText("Ghi chú:");

        btnHuyHD.setBackground(new java.awt.Color(0, 255, 204));
        btnHuyHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/huy hoa don.png"))); // NOI18N
        btnHuyHD.setText("Hủy hóa đơn");
        btnHuyHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyHDMouseClicked(evt);
            }
        });
        btnHuyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHDActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 255, 204));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reload.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLamMoiMouseClicked(evt);
            }
        });
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(0, 255, 204));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/6445237.png"))); // NOI18N
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.setEnabled(false);
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        cboLoaiThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản" }));

        txtTienKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKHActionPerformed(evt);
            }
        });
        txtTienKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKHKeyReleased(evt);
            }
        });

        jLabel19.setText("Bán tại cửa hàng");

        jLabel15.setText("VNĐ");

        jLabel16.setText("VNĐ");

        jLabel17.setText("VNĐ");

        jLabel18.setText("VNĐ");

        jLabel22.setText("VNĐ");

        btnTaoMaHD.setBackground(new java.awt.Color(0, 255, 204));
        btnTaoMaHD.setText("Tạo");
        btnTaoMaHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoMaHDMouseClicked(evt);
            }
        });
        btnTaoMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMaHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDonHangLayout = new javax.swing.GroupLayout(panelDonHang);
        panelDonHang.setLayout(panelDonHangLayout);
        panelDonHangLayout.setHorizontalGroup(
            panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDonHangLayout.createSequentialGroup()
                .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDonHangLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDonHangLayout.createSequentialGroup()
                                .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(32, 32, 32)
                                .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(panelDonHangLayout.createSequentialGroup()
                                            .addComponent(lblMaHD)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnTaoMaHD))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDonHangLayout.createSequentialGroup()
                                            .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(panelDonHangLayout.createSequentialGroup()
                                                    .addComponent(lblTienThua)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel22))
                                                .addGroup(panelDonHangLayout.createSequentialGroup()
                                                    .addComponent(lblThanhToan)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel17))
                                                .addGroup(panelDonHangLayout.createSequentialGroup()
                                                    .addComponent(lblGiamGia)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel16))
                                                .addGroup(panelDonHangLayout.createSequentialGroup()
                                                    .addComponent(lblTongTien)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel15))
                                                .addComponent(cboLoaiThanhToan, javax.swing.GroupLayout.Alignment.LEADING, 0, 136, Short.MAX_VALUE)
                                                .addComponent(txtTienKH, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel18)))))
                            .addComponent(txtGhiChu)))
                    .addGroup(panelDonHangLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelDonHangLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDonHangLayout.createSequentialGroup()
                        .addComponent(btnHuyHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLamMoi)))
                .addGap(59, 59, 59))
        );
        panelDonHangLayout.setVerticalGroup(
            panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDonHangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblMaHD)
                    .addComponent(btnTaoMaHD))
                .addGap(18, 18, 18)
                .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblTongTien)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblGiamGia)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblThanhToan)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTienKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblTienThua)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboLoaiThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyHD)
                    .addComponent(btnLamMoi))
                .addGap(19, 19, 19)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        panelSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));
        panelSanPham.setLayout(new java.awt.BorderLayout());

        jLabel20.setText("Tìm kiếm");

        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFindKeyPressed(evt);
            }
        });

        btnThemSP.setBackground(new java.awt.Color(0, 255, 204));
        btnThemSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnThemSP.setText("Thêm sản phẩm");
        btnThemSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemSPMouseClicked(evt);
            }
        });
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addContainerGap(821, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemSP)
                        .addGap(197, 197, 197))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemSP))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelSanPham.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Đơn giá", "Màu sắc", "Chất liệu", "Kích cỡ", "Số lượng tồn"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        panelSanPham.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn chờ"));
        jPanel7.setAutoscrolls(true);

        tblHoaDonCho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Ngày tạo", "Khách hàng"
            }
        ));
        tblHoaDonCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonChoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDonCho);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 151, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel7);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Đơn giá", "Số lượng", "Tổng"
            }
        ));
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblGioHang);
        if (tblGioHang.getColumnModel().getColumnCount() > 0) {
            tblGioHang.getColumnModel().getColumn(2).setResizable(false);
            tblGioHang.getColumnModel().getColumn(3).setResizable(false);
        }

        btnXoaSPGioHang.setBackground(new java.awt.Color(0, 255, 204));
        btnXoaSPGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnXoaSPGioHang.setText("Xóa sản phẩm");
        btnXoaSPGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaSPGioHangMouseClicked(evt);
            }
        });
        btnXoaSPGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPGioHangActionPerformed(evt);
            }
        });

        btnClearGioHang.setBackground(new java.awt.Color(0, 255, 204));
        btnClearGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear.png"))); // NOI18N
        btnClearGioHang.setText("Xóa tất cả");
        btnClearGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearGioHangMouseClicked(evt);
            }
        });
        btnClearGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearGioHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaSPGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearGioHang))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnXoaSPGioHang)
                .addGap(18, 18, 18)
                .addComponent(btnClearGioHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(panelDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void BackBHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBHMouseClicked
        HomeForm home = new HomeForm();
        home.setVisible(true);
        home.pack();
        home.setLocationRelativeTo(null);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BackBHMouseClicked

    private void btnChonKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonKHMouseClicked

    }//GEN-LAST:event_btnChonKHMouseClicked

    private void btnThemSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemSPMouseClicked
    }//GEN-LAST:event_btnThemSPMouseClicked

    private void btnTaoMaHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoMaHDMouseClicked
        taoHD(lst);
        donHang();
    }//GEN-LAST:event_btnTaoMaHDMouseClicked

    private void btnLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoiMouseClicked
        clearForm();
    }//GEN-LAST:event_btnLamMoiMouseClicked

    private void btnXoaSPGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaSPGioHangMouseClicked
        xoaSP();
    }//GEN-LAST:event_btnXoaSPGioHangMouseClicked

    private void btnClearGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearGioHangMouseClicked
        clear();
    }//GEN-LAST:event_btnClearGioHangMouseClicked

    private void BackBHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBHMouseEntered
        BackBH.setLayout(new BorderLayout(10, 10));
        BackBH.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));
    }//GEN-LAST:event_BackBHMouseEntered

    private void BackBHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBHMouseExited
        BackBH.setLayout(null);
        BackBH.setBorder(null);
    }//GEN-LAST:event_BackBHMouseExited

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblSanPhamMouseClicked
    public Double fillDonHang() {
        int x = tblGioHang.getRowCount();
        if (x == 0) {
            return 0.0;
        }
        Double sum = 0.0;
        for (int i = 0; i < x; i++) {
            sum += Double.parseDouble(tblGioHang.getValueAt(i, 3).toString());
        }
        return sum;
    }
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

        HoaDon hd = this.getFormBH();
        if (checkForm()) {
            if (hdService.Them(hd) != 0) {
                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                hdService.Them(hd);
            } else {
                JOptionPane.showMessageDialog(this, "Them that bai");
            }
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnHuyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyHDActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        SanPham sp = getSP();
        String m = JOptionPane.showInputDialog(this, "Nhập số lượng sản phẩm bạn muốn", "Số lượng sản phẩm", HEIGHT);
        int gia = Integer.parseInt(sp.getDonGia());
        int sl = Integer.parseInt(m.trim());
        int indexs = tblSanPham.getSelectedRow();
        int soLuongMua = Integer.parseInt(m);
        int soLuongTon = Integer.parseInt(tblSanPham.getValueAt(indexs, 6).toString());
        if (soLuongMua > soLuongTon) {
            JOptionPane.showMessageDialog(this, "Số lượng không đủ");
            return;
        } else if (soLuongMua < 1) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ, vui lòng nhập lại");
            return;
        }
        int tong = Math.round((gia * sl) * 100) / 100;
        mol = (DefaultTableModel) tblGioHang.getModel();
        mol.addRow(new Object[]{
            sp.getMaSP(), sp.getTenSP(), sp.getDonGia(), m, tong
        });
        soLuongTon = soLuongTon - soLuongMua;
        tblSanPham.setValueAt(soLuongTon, indexs, 6);
        fillDonHang();
        donHang();
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void btnClearGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearGioHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearGioHangActionPerformed

    private void btnXoaSPGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPGioHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaSPGioHangActionPerformed

    private void btnChonKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKHActionPerformed
        // TODO add your handling code here:

        KhachHangView kh = new KhachHangView(this, true);

        kh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        kh.setLocationRelativeTo(this);
        kh.setVisible(true);
        txtMaKH.setText(kh.maKH);
        txtTenKH.setText(kh.tenKH);
    }//GEN-LAST:event_btnChonKHActionPerformed

    private void btnTaoMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTaoMaHDActionPerformed

    private void txtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyPressed
        // TODO add your handling code here:
        find();
        find1();
    }//GEN-LAST:event_txtFindKeyPressed

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void btnHuyHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyHDMouseClicked
        // TODO add your handling code here:
        try {
            int hoi = JOptionPane.showConfirmDialog(this, "Bạn muốn hủy hóa đơn không?");
            if (hoi != JOptionPane.YES_NO_OPTION) {
                return;
            } else {
                mol = (DefaultTableModel) tblHoaDonCho.getModel();
                mol.setRowCount(0);
                mol = (DefaultTableModel) tblGioHang.getModel();
                mol.setRowCount(0);
                clearForm();
                JOptionPane.showMessageDialog(this, "Hủy hóa đơn thành công!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hủy hóa đơn thất bại!");
        }

    }//GEN-LAST:event_btnHuyHDMouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void tblHoaDonChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonChoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHoaDonChoMouseClicked

    private void txtTienKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKHActionPerformed

    private void txtTienKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKHKeyReleased
        donHang();
    }//GEN-LAST:event_txtTienKHKeyReleased
    public void showDataRow() {
        HoaDon hd = lst.get(index);
        txtMaKH.setText(hd.getMaKH());
        txtTenKH.setText(hd.getTenKH());
        lblMaHD.setText(hd.getMaHD());
        lblGiamGia.getText();

    }

    void clearForm() {
        lblMaHD.setText("");
        lblTongTien.setText("");
        lblGiamGia.setText("");
        lblThanhToan.setText("");
        txtTienKH.setText("0");
        lblTienThua.setText("");
        txtMaKH.setText("");
        txtTenKH.setText("");
    }

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
            java.util.logging.Logger.getLogger(BanHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackBH;
    private javax.swing.JButton btnChonKH;
    private javax.swing.JButton btnClearGioHang;
    private javax.swing.JButton btnHuyHD;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTaoMaHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnXoaSPGioHang;
    private javax.swing.JComboBox<String> cboLoaiThanhToan;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblThanhToan;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel panelDonHang;
    private javax.swing.JPanel panelSanPham;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDonCho;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextArea txtGC;
    private javax.swing.JScrollPane txtGhiChu;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTienKH;
    // End of variables declaration//GEN-END:variables

    private boolean checkForm() {
        if (lblMaHD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã HD rỗng");
            return false;
        }
        if (lblTongTien.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tổng tiền rỗng");
            return false;
        }
        if (lblGiamGia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giảm giá rỗng");
            return false;
        }
        if (lblThanhToan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Thanh toán rỗng");
            return false;
        }
        if (txtTienKH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tiền KH rỗng");
            return false;
        }

        int tien;
        try {
            tien = Integer.parseInt(txtTienKH.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "không đúng định dạng");
        }
        if (lblTienThua.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tiền thừa rỗng");
            return false;
        }
        if (txtMaKH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã KH rỗng");
            return false;
        }
        if (txtTenKH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên KH rỗng");
            return false;
        }
        return true;
    }

    public HoaDon getFormBH() {
        String maHD = lblMaHD.getText().trim();
        String maKH = txtMaKH.getText().trim();
        Date ngayTao = new Date();
        String tongTien = String.valueOf(lblTongTien.getText().trim());

        return new HoaDon(maHD, maHD, maHD, maHD, maHD, maHD, tongTien, tongTien, maHD, ngayTao, tongTien);
    }

}
