/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import edusys.XImage;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class HomeForm extends javax.swing.JFrame {
    public HomeForm() {
        initComponents();
        setLocationRelativeTo(null);
        init();
    }

    void init() {
        setIconImage(XImage.getAppIcon());
        setTitle("Home");

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        lblBanHang = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        lblSanPham = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        lblKhuyenMai = new javax.swing.JLabel();
        lblThongKe = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
        lblDoiMK = new javax.swing.JLabel();
        panelBody = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblLoGo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBackground(new java.awt.Color(51, 255, 204));

        lblBanHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBanHang.setForeground(new java.awt.Color(255, 255, 255));
        lblBanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add to basket.png"))); // NOI18N
        lblBanHang.setText("BÁN HÀNG");
        lblBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBanHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBanHangMouseExited(evt);
            }
        });

        lblHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hóa đơn.png"))); // NOI18N
        lblHoaDon.setText("HÓA ĐƠN");
        lblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseExited(evt);
            }
        });

        lblSanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lblSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sản phẩm.png"))); // NOI18N
        lblSanPham.setText("SẢN PHẨM");
        lblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSanPhamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSanPhamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSanPhamMouseExited(evt);
            }
        });

        lblNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nhân viên.png"))); // NOI18N
        lblNhanVien.setText("NHÂN VIÊN");
        lblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseExited(evt);
            }
        });

        lblKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        lblKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/khách hàng.png"))); // NOI18N
        lblKhachHang.setText("KHÁCH HÀNG");
        lblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseExited(evt);
            }
        });

        lblKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        lblKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/khuyến mãi.png"))); // NOI18N
        lblKhuyenMai.setText("KHUYẾN MÃI");
        lblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhuyenMaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblKhuyenMaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblKhuyenMaiMouseExited(evt);
            }
        });

        lblThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lblThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thống kê.png"))); // NOI18N
        lblThongKe.setText("THỐNG KÊ");
        lblThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThongKeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblThongKeMouseExited(evt);
            }
        });

        lblThoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(255, 255, 255));
        lblThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/toát.png"))); // NOI18N
        lblThoat.setText("THOÁT");
        lblThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoatMouseClicked(evt);
            }
        });

        lblDoiMK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDoiMK.setForeground(new java.awt.Color(255, 255, 255));
        lblDoiMK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoiMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/toát.png"))); // NOI18N
        lblDoiMK.setText("Đổi MK");
        lblDoiMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDoiMKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDoiMKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDoiMKMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDoiMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(lblKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblThoat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(lblBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(51, 255, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("00:00:00");

        lblLoGo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1123-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addComponent(lblLoGo)
                .addContainerGap(416, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(lblLoGo)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(37, 37, 37)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        panelBody.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHangMouseClicked
        BanHangView banHang = new BanHangView();
        banHang.setVisible(true);
        banHang.pack();
        banHang.setLocationRelativeTo(null);
        banHang.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_lblBanHangMouseClicked

    private void lblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseClicked
        HoaDonView don = new HoaDonView();
        don.setVisible(true);
        don.pack();
        don.setLocationRelativeTo(null);
        don.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_lblHoaDonMouseClicked

    private void lblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSanPhamMouseClicked
        SanPhamView pham = new SanPhamView();
        pham.setVisible(true);
        pham.pack();
        pham.setLocationRelativeTo(null);
        pham.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_lblSanPhamMouseClicked

    private void lblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseClicked
        NhanVienView vien = new NhanVienView();
        vien.setVisible(true);
        vien.pack();
        vien.setLocationRelativeTo(null);
        vien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_lblNhanVienMouseClicked

    private void lblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseClicked
        KhachHangView hang=new KhachHangView(this, true);
        hang.setVisible(true);
        hang.pack();
        hang.setLocationRelativeTo(null);
        hang.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_lblKhachHangMouseClicked

    private void lblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhuyenMaiMouseClicked
        KhuyenMaiView khuyenMai = new KhuyenMaiView();
        khuyenMai.setVisible(true);
        khuyenMai.pack();
        khuyenMai.setLocationRelativeTo(null);
        khuyenMai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_lblKhuyenMaiMouseClicked

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblThoatMouseClicked

    private void lblBanHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHangMouseEntered
        lblBanHang.setLayout(new BorderLayout(10, 10));
        lblBanHang.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));
    }//GEN-LAST:event_lblBanHangMouseEntered

    private void lblBanHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHangMouseExited
        lblBanHang.setLayout(null);
        lblBanHang.setBorder(null);
    }//GEN-LAST:event_lblBanHangMouseExited

    private void lblKhuyenMaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhuyenMaiMouseEntered
        lblKhuyenMai.setLayout(new BorderLayout(10, 10));
        lblKhuyenMai.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));
    }//GEN-LAST:event_lblKhuyenMaiMouseEntered

    private void lblKhuyenMaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhuyenMaiMouseExited
        lblKhuyenMai.setLayout(null);
        lblKhuyenMai.setBorder(null);
    }//GEN-LAST:event_lblKhuyenMaiMouseExited

    private void lblSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSanPhamMouseEntered
        lblSanPham.setLayout(new BorderLayout(10, 10));
        lblSanPham.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));
    }//GEN-LAST:event_lblSanPhamMouseEntered

    private void lblSanPhamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSanPhamMouseExited
        lblSanPham.setLayout(null);
        lblSanPham.setBorder(null);
    }//GEN-LAST:event_lblSanPhamMouseExited

    private void lblHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseEntered
        lblHoaDon.setLayout(new BorderLayout(10, 10));
        lblHoaDon.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));
    }//GEN-LAST:event_lblHoaDonMouseEntered

    private void lblHoaDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseExited
        lblHoaDon.setLayout(null);
        lblHoaDon.setBorder(null);
    }//GEN-LAST:event_lblHoaDonMouseExited

    private void lblNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseEntered
        lblNhanVien.setLayout(new BorderLayout(10, 10));
        lblNhanVien.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));
    }//GEN-LAST:event_lblNhanVienMouseEntered

    private void lblNhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseExited
        lblNhanVien.setLayout(null);
        lblNhanVien.setBorder(null);
    }//GEN-LAST:event_lblNhanVienMouseExited

    private void lblKhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseEntered
        lblKhachHang.setLayout(new BorderLayout(10, 10));
        lblKhachHang.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));
    }//GEN-LAST:event_lblKhachHangMouseEntered

    private void lblKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseExited
        lblKhachHang.setLayout(null);
        lblKhachHang.setBorder(null);
    }//GEN-LAST:event_lblKhachHangMouseExited

    private void lblDoiMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoiMKMouseClicked
        // TODO add your handling code here:
        DoiMK dmk = new DoiMK();
        dmk.setVisible(true);
        dmk.pack();
        dmk.setLocationRelativeTo(null);
        dmk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_lblDoiMKMouseClicked

    private void lblDoiMKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoiMKMouseEntered
        // TODO add your handling code here:
        lblDoiMK.setLayout(new BorderLayout(10, 10));
        lblDoiMK.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));
    }//GEN-LAST:event_lblDoiMKMouseEntered

    private void lblDoiMKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoiMKMouseExited
        // TODO add your handling code here:
        lblDoiMK.setLayout(null);
        lblDoiMK.setBorder(null);
    }//GEN-LAST:event_lblDoiMKMouseExited

    private void lblThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongKeMouseExited
        lblThongKe.setLayout(null);
        lblThongKe.setBorder(null);
    }//GEN-LAST:event_lblThongKeMouseExited

    private void lblThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongKeMouseEntered
        lblThongKe.setLayout(new BorderLayout(10, 10));
        lblThongKe.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));
    }//GEN-LAST:event_lblThongKeMouseEntered

    private void lblThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongKeMouseClicked

    }//GEN-LAST:event_lblThongKeMouseClicked

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
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBanHang;
    private javax.swing.JLabel lblDoiMK;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblLoGo;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblSanPham;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblThongKe;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
