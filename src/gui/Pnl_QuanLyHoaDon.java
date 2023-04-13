/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.sql.SQLException;

import connectDB.DBConnection;
import dao.HoaDonDao;
import dao.KhachHangDao;
import entity.HoaDon;
import entity.ChiTietHoaDon;
import entity.KhachHang;
import entity.NhanVien;
import javax.swing.table.DefaultTableModel;
import service_impl.HoaDonServicelmpl;


/**
 *
 * @author Admin
 */
public class Pnl_QuanLyHoaDon extends javax.swing.JPanel implements ActionListener,MouseListener{
    
    
    private HoaDonServicelmpl iHoaDon;
    private List<HoaDon> dsHoaDon;
    private DefaultTableModel tableModel_HoaDon;
    private com.toedter.calendar.JDateChooser dcNgayLap;
    private javaswingdev.FontAwesomeIcon icoCapNhat;
    private javaswingdev.FontAwesomeIcon icoLamMoi;
    private javaswingdev.FontAwesomeIcon icoThem;
    private javaswingdev.FontAwesomeIcon icoXoa;
    private javaswingdev.FontAwesomeIcon icoXuatFile;
    private javaswingdev.FontAwesomeIcon iconNhapFile;
    
    /**
     * Creates new form Pnl_QuanLyHoaDon
     */
    public Pnl_QuanLyHoaDon() {
        initComponents();
        
      
        
        btnThem.addActionListener(this);
        btnCapNhat.addActionListener(this);
        btnLamMoi.addActionListener(this);
        btnXoa.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblTenManHinh = new javax.swing.JLabel();
        pnlBangDuLieuVaChucNang = new javax.swing.JPanel();
        sc_tbl_QLHD = new javax.swing.JScrollPane();
        tblQLHD = new javax.swing.JTable();
        pnlChucNang = new javax.swing.JPanel();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnNhapFile = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
        pnlChiTietHoaDon = new javax.swing.JPanel();
        pnlCTHDHead = new javax.swing.JPanel();
        lblCTHDHead = new javax.swing.JLabel();
        pnlThongTinChiTietHoaDon = new javax.swing.JPanel();
        lblMaHoaDon = new javax.swing.JLabel();
        lblMaHoaDon1 = new javax.swing.JLabel();
        lblMaHoaDon2 = new javax.swing.JLabel();
        lblMaHoaDon3 = new javax.swing.JLabel();
        lblMaHoaDon4 = new javax.swing.JLabel();
        lblMaHoaDon5 = new javax.swing.JLabel();
        lblMaHoaDon6 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtNgayLap = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        setPreferredSize(new java.awt.Dimension(1543, 1080));
        setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(java.awt.Color.lightGray);

        lblTenManHinh.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lblTenManHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenManHinh.setText("QUẢN LÝ HÓA ĐƠN");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenManHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 1543, Short.MAX_VALUE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(lblTenManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlBangDuLieuVaChucNang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlBangDuLieuVaChucNang.setPreferredSize(new java.awt.Dimension(1119, 930));

        tblQLHD.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblQLHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Hóa Đơn", "Tên Khách Hàng", "SDT", "Ngày Lập", "Thành Tiền", "Ghi Chú"
            }
        ));
        sc_tbl_QLHD.setViewportView(tblQLHD);
        if (tblQLHD.getColumnModel().getColumnCount() > 0) {
            tblQLHD.getColumnModel().getColumn(0).setResizable(false);
            tblQLHD.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblQLHD.getColumnModel().getColumn(1).setResizable(false);
            tblQLHD.getColumnModel().getColumn(1).setPreferredWidth(10);
            tblQLHD.getColumnModel().getColumn(2).setResizable(false);
            tblQLHD.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblQLHD.getColumnModel().getColumn(3).setResizable(false);
            tblQLHD.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblQLHD.getColumnModel().getColumn(4).setResizable(false);
            tblQLHD.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        pnlChucNang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnXoa.setText("Xóa");

        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCapNhat.setText("Cập nhật");

        btnNhapFile.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNhapFile.setText("Nhập file");

        btnXuatFile.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnXuatFile.setText("Xuất file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlChucNangLayout = new javax.swing.GroupLayout(pnlChucNang);
        pnlChucNang.setLayout(pnlChucNangLayout);
        pnlChucNangLayout.setHorizontalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnNhapFile, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlChucNangLayout.setVerticalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnCapNhat)
                    .addComponent(btnNhapFile)
                    .addComponent(btnXuatFile))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBangDuLieuVaChucNangLayout = new javax.swing.GroupLayout(pnlBangDuLieuVaChucNang);
        pnlBangDuLieuVaChucNang.setLayout(pnlBangDuLieuVaChucNangLayout);
        pnlBangDuLieuVaChucNangLayout.setHorizontalGroup(
            pnlBangDuLieuVaChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sc_tbl_QLHD, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
            .addComponent(pnlChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBangDuLieuVaChucNangLayout.setVerticalGroup(
            pnlBangDuLieuVaChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBangDuLieuVaChucNangLayout.createSequentialGroup()
                .addComponent(sc_tbl_QLHD, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(pnlBangDuLieuVaChucNang, java.awt.BorderLayout.LINE_START);

        pnlChiTietHoaDon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlCTHDHead.setBackground(new java.awt.Color(255, 255, 255));
        pnlCTHDHead.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCTHDHead.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCTHDHead.setText("CHI TIẾT HÓA ĐƠN");

        javax.swing.GroupLayout pnlCTHDHeadLayout = new javax.swing.GroupLayout(pnlCTHDHead);
        pnlCTHDHead.setLayout(pnlCTHDHeadLayout);
        pnlCTHDHeadLayout.setHorizontalGroup(
            pnlCTHDHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnlCTHDHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCTHDHeadLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblCTHDHead)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlCTHDHeadLayout.setVerticalGroup(
            pnlCTHDHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(pnlCTHDHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCTHDHeadLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblCTHDHead)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        lblMaHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMaHoaDon.setText("Mã Hóa Đơn: ");

        lblMaHoaDon1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMaHoaDon1.setText("Số Điện Thoại:");

        lblMaHoaDon2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMaHoaDon2.setText("Tên Khách Hàng:");

        lblMaHoaDon3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMaHoaDon3.setText("Mã Khách Hàng:");

        lblMaHoaDon4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMaHoaDon4.setText("Thành Tiền:");

        lblMaHoaDon5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMaHoaDon5.setText("Ngày Lập:");

        lblMaHoaDon6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMaHoaDon6.setText("Ghi Chú:");

        txtMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDActionPerformed(evt);
            }
        });

        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });

        txtNgayLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayLapActionPerformed(evt);
            }
        });

        txtGhiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuActionPerformed(evt);
            }
        });

        txtThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhTienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThongTinChiTietHoaDonLayout = new javax.swing.GroupLayout(pnlThongTinChiTietHoaDon);
        pnlThongTinChiTietHoaDon.setLayout(pnlThongTinChiTietHoaDonLayout);
        pnlThongTinChiTietHoaDonLayout.setHorizontalGroup(
            pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinChiTietHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinChiTietHoaDonLayout.createSequentialGroup()
                        .addComponent(lblMaHoaDon4, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlThongTinChiTietHoaDonLayout.createSequentialGroup()
                        .addGroup(pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlThongTinChiTietHoaDonLayout.createSequentialGroup()
                                .addComponent(lblMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(19, 19, 19))
                            .addComponent(lblMaHoaDon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlThongTinChiTietHoaDonLayout.createSequentialGroup()
                                .addComponent(lblMaHoaDon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3))
                            .addGroup(pnlThongTinChiTietHoaDonLayout.createSequentialGroup()
                                .addComponent(lblMaHoaDon6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(57, 57, 57)))
                        .addGap(11, 11, 11)
                        .addGroup(pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKH)
                            .addGroup(pnlThongTinChiTietHoaDonLayout.createSequentialGroup()
                                .addGroup(pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtGhiChu)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinChiTietHoaDonLayout.createSequentialGroup()
                        .addGroup(pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlThongTinChiTietHoaDonLayout.createSequentialGroup()
                                .addComponent(lblMaHoaDon1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(pnlThongTinChiTietHoaDonLayout.createSequentialGroup()
                                .addComponent(lblMaHoaDon5, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addGap(10, 10, 10)))
                        .addGroup(pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(txtSoDienThoai))))
                .addContainerGap())
        );
        pnlThongTinChiTietHoaDonLayout.setVerticalGroup(
            pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinChiTietHoaDonLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaHoaDon)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaHoaDon3)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaHoaDon2)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaHoaDon1)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaHoaDon5)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaHoaDon4)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlThongTinChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaHoaDon6)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pnlThongTinChiTietHoaDonLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblMaHoaDon, lblMaHoaDon1, lblMaHoaDon2, lblMaHoaDon3, lblMaHoaDon4, lblMaHoaDon5, lblMaHoaDon6});

        pnlThongTinChiTietHoaDonLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtGhiChu, txtMaHD, txtMaKH, txtNgayLap, txtSoDienThoai, txtTenKH, txtThanhTien});

        javax.swing.GroupLayout pnlChiTietHoaDonLayout = new javax.swing.GroupLayout(pnlChiTietHoaDon);
        pnlChiTietHoaDon.setLayout(pnlChiTietHoaDonLayout);
        pnlChiTietHoaDonLayout.setHorizontalGroup(
            pnlChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChiTietHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCTHDHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnlThongTinChiTietHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlChiTietHoaDonLayout.setVerticalGroup(
            pnlChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCTHDHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlThongTinChiTietHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnlChiTietHoaDon, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuatFileActionPerformed

    private void txtMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDActionPerformed

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiActionPerformed

    private void txtNgayLapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayLapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayLapActionPerformed

    private void txtGhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuActionPerformed

    private void txtThanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhTienActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnNhapFile;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JLabel lblCTHDHead;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblMaHoaDon1;
    private javax.swing.JLabel lblMaHoaDon2;
    private javax.swing.JLabel lblMaHoaDon3;
    private javax.swing.JLabel lblMaHoaDon4;
    private javax.swing.JLabel lblMaHoaDon5;
    private javax.swing.JLabel lblMaHoaDon6;
    private javax.swing.JLabel lblTenManHinh;
    private javax.swing.JPanel pnlBangDuLieuVaChucNang;
    private javax.swing.JPanel pnlCTHDHead;
    private javax.swing.JPanel pnlChiTietHoaDon;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlThongTinChiTietHoaDon;
    private javax.swing.JScrollPane sc_tbl_QLHD;
    private javax.swing.JTable tblQLHD;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void DocDuLieuTuArrayListVaoModel() throws Exception {
	iHoaDon = new HoaDonServicelmpl();
	dsHoaDon = iHoaDon.getDSHoaDon();
	int i = 1;
	for (HoaDon hd : dsHoaDon) {
            Object[] ob = { i++, hd.getMaHD(), hd.getKhachHang(), hd.getNhanVien(), 
		hd.getNgayLapHD(), hd.getTienKhachDua() };
            tableModel_HoaDon.addRow(ob);
        }
    }
    
    public HoaDon revertHoaDon() {
	String maHD = txtMaHD.getText();
	String maKH = txtMaKH.getText();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String day = sdf.format(dcNgayLap.getDate());
	String date[] = day.split("-");
	int nam = Integer.parseInt(date[0]);
	int thang = Integer.parseInt(date[1]);
	int ngay = Integer.parseInt(date[2]);

	LocalDate lcDate = LocalDate.of(nam, thang, ngay);
	String sdt = txtSoDienThoai.getText();
        String thanhTien = txtThanhTien.getText();
		
	String ghiChu = txtGhiChu.getText();
		
	return new HoaDon(maHD);
    }
    
    public void editOnRow() {
	int row = tblQLHD.getSelectedRow();
	HoaDon hd = revertHoaDon();

	tblQLHD.setValueAt(hd.getMaHD(), row, 1);
	tblQLHD.setValueAt(hd.getKhachHang().getMaKH(), row, 2);
	tblQLHD.setValueAt(hd.getKhachHang().getHoTenKH(), row, 3);
	tblQLHD.setValueAt(hd.getKhachHang().getSDT(), row, 4);
        tblQLHD.setValueAt(hd.getNgayLapHD(), row, 5);
	tblQLHD.setValueAt(hd.getTienKhachDua(), row, 6);
	System.out.println(row);
    }
    
    public void ThemNhanVienVaoDB() {
        HoaDon hd = revertHoaDon();
		
	try {
            iHoaDon.themHoaDon(hd);
        } catch (SQLException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
        }	
    }

	public void clear_formThongTinNhanVien() {
		txtMaHD.setText("");
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtSoDienThoai.setText("");
		txtNgayLap.setText("");
		txtGhiChu.setText("");
	}
	public void xoaHetDuLieu() {
		DefaultTableModel dtm = (DefaultTableModel) tblQLHD.getModel();
		dtm.getDataVector().removeAllElements();
	}
}