package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javaswingdev.GradientDropdownMenu;
import javaswingdev.MenuEvent;


import javax.swing.JPanel;


public class Frm_TrangChu extends javax.swing.JFrame {
		private JPanel pnl_TrangChu = new Pnl_TrangChu();
		private JPanel pnl_QLNV = new Pnl_QuanLyNhanVien();
        private JPanel pnl_TKNV = new Pnl_TimKiemNhanVien();
        private JPanel pnl_QLSP = new Pnl_QuanLySanPham();
        private JPanel pnl_TKSach = new Pnl_TimKiemSach() ;
        private JPanel pnl_LPDH = new Pnl_PhieuDatHang();
<<<<<<< HEAD
        private JPanel pnl_TKVPP = new Pnl_TimKiemVPP();
=======
        private JPanel pnl_QLHD = new Pnl_QuanLyHoaDon();
>>>>>>> duy
    public Frm_TrangChu() {
        
        initComponents();
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        GradientDropdownMenu menu = new GradientDropdownMenu();
        menu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        menu.setGradientColor(new Color(85, 107, 47), new Color(160, 82, 45));
        menu.setBackground(new Color(80, 80, 22));
        menu.addItem("Trang chủ");
        menu.addItem("      Khách hàng       ", "Tìm kiếm khách hàng", "Quản lý khách hàng");
        menu.addItem("       Nhân viên       ", "Tìm kiếm nhân viên", "Quản lý nhân viên");
<<<<<<< HEAD
        menu.addItem("       Sản phẩm        ", "Tìm kiếm VPP","Tìm kiếm sách", "Quản lý sản phẩm");
        menu.addItem("        Hóa đơn        ", "Tìm kiếm hóa đơn", "Lập hóa đơn");
=======
        menu.addItem("       Sản phẩm        ", "Tìm kiếm sản phẩm", "Quản lý sản phẩm");
        menu.addItem("        Hóa đơn        ", "Tìm kiếm hóa đơn", "Lập hóa đơn", "Quản lý hóa đơn");
>>>>>>> duy
        menu.addItem("		Phiếu đặt hàng	 ", "Tìm kiếm hóa đơn", "Lập phiếu đặt");
        menu.addItem("        Báo cáo        ");
        menu.applay(this);  
        JPanel pnl_center = new JPanel();
        pnl_center.setLayout(new BorderLayout());
        pnl_center.add(pnl_TrangChu, BorderLayout.CENTER);
        menu.addEvent(new MenuEvent(){

			@Override
            public void selected(int index, int subIndex, boolean menuItem){
                if(menuItem) {
                    String selectedMenuItem = menu.getMenuNameAt(index, subIndex).trim();
                    if(selectedMenuItem.equals("Quản lý nhân viên")) {
                        pnl_center.removeAll();
                        pnl_center.add(pnl_QLNV, BorderLayout.CENTER);
                        pnl_center.revalidate();
                        pnl_center.repaint();   
                    } else if(selectedMenuItem.equals("Tìm kiếm nhân viên")) {
                        pnl_center.removeAll();
                        pnl_center.add(pnl_TKNV, BorderLayout.CENTER);
                        pnl_center.revalidate();
                        pnl_center.repaint(); 
                        
                    }else if(selectedMenuItem.equals("Tìm kiếm VPP")) {
                        pnl_center.removeAll();
                        pnl_center.add(pnl_TKVPP, BorderLayout.CENTER);
                        pnl_center.revalidate();
                        pnl_center.repaint(); 
                        
                    }else if(selectedMenuItem.equals("Tìm kiếm sách")) {
                        pnl_center.removeAll();
                        pnl_center.add(pnl_TKSach, BorderLayout.CENTER);
                        pnl_center.revalidate();
                        pnl_center.repaint(); 
                        
                    }else if(selectedMenuItem.equals("Quản lý sản phẩm")) {
                        pnl_center.removeAll();
                        pnl_center.add(pnl_QLSP, BorderLayout.CENTER);
                        pnl_center.revalidate();
                        pnl_center.repaint(); 
                        
                    }else if(selectedMenuItem.equals("Lập phiếu đặt")) {
                        pnl_center.removeAll();
                        pnl_center.add(pnl_LPDH, BorderLayout.CENTER);
                        pnl_center.revalidate();
                        pnl_center.repaint();               
                    }
                    else if(selectedMenuItem.equals("Trang chủ")) {
                        pnl_center.removeAll();
                        pnl_center.add(pnl_TrangChu, BorderLayout.CENTER);
                        pnl_center.revalidate();
                        pnl_center.repaint();           
                    }
                    else if(selectedMenuItem.equals("Quản lý hóa đơn")) {
                        pnl_center.removeAll();
                        pnl_center.add(pnl_QLHD, BorderLayout.CENTER);
                        pnl_center.revalidate();
                        pnl_center.repaint();           
                    }
                }
            }
        });
        this.add(pnl_center, BorderLayout.CENTER);
   }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {

            
        java.awt.EventQueue.invokeLater(() -> {
            new Frm_TrangChu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
