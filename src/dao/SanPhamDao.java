package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.DBConnection;
import entity.MauSac;
import entity.NhaCungCap;
import entity.NhaSanXuat;
import entity.NhaXuatBan;
import entity.Sach;
import entity.SanPham;
import entity.TacGia;
import entity.TheLoaiSach;
import entity.TheLoaiVanPhongPham;
import entity.VanPhongPham;

public class SanPhamDao {
	private Connection con;
	private PreparedStatement ps = null;
	private ResultSet rs;
	private String query;
	private int rsCheck;
	private TacGiaDao tacgiaDao;
	private NhaSanXuatDao nhaSanXuatDao;
	private TheLoaiDao theloaiDao;
	public SanPhamDao() {
		DBConnection connection = DBConnection.getInstance();
		con = connection.getConnection();
		
	}
	
	public boolean themSanPham(SanPham sanPham) throws Exception {
		Sach s = new Sach();
		VanPhongPham v = new VanPhongPham();
		if (sanPham instanceof Sach) {
			s = (Sach) sanPham;
			query = "INSERT [dbo].[SanPham] VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?," + "?, ?, ?, "
					+ " null, null, null, null)";
			ps = con.prepareStatement(query);
			ps.setString(rsCheck, query);
			query = "INSERT [dbo].[SanPham] VALUES " + "('"+s.getMaSanPham()+"','"+s.getNhaCungCap().getMaNhaCungCap() 
					+"',N'"+s.getLoaiSanPham()	+"',"+s.getSoLuongTon()	+",N'"+s.getDonVi()+"',"+s.getGiaNhap()+","+s.getGiaBan()
					+",N'"+s.getTenSach()+"','"+s.getTacGia().getMaTacGia()+"','"+s.getTheLoaiSach()+"','"+s.getNhaXuatBan().getMaNXB()+"', null, null, null)";
			ps = con.prepareStatement(query);
			
		} else {
			v = (VanPhongPham) sanPham;
			query = "INSERT [dbo].[SanPham] VALUES (?,?,?,?,?,?,?, "
					+ "null, null, null, null, ?,?,?)";
			ps.setString(1, s.getMaSanPham());
			ps.setString(2, s.getNhaCungCap().getMaNhaCungCap());
			ps.setString(3, s.getLoaiSanPham());
			ps.setInt(4, s.getSoLuongTon());
			ps.setString(5, s.getDonVi());
			ps.setLong(6, s.getGiaNhap());
			ps.setLong(7, s.getGiaBan());
			ps.setString(8, v.getTenVanPhongPham());
			ps.setString(9, v.getMauSac().getMaMau());
			ps.setString(10, v.getNhaSanXuat().getMaNhaSX());
		}
		rsCheck = ps.executeUpdate();
		if (rsCheck == 0) {
			return false;
		}
		return true;
	}
	
	public SanPham timSanPhamTheoMa(String maSP) throws SQLException {
		SanPham sp = new SanPham();
		String query = "Select * from SanPham where maSP=?";
		ps = con.prepareStatement(query);
		ps.setString(1, maSP);
		rs = ps.executeQuery();
		while (rs.next()) {

			String maSanPham = rs.getString("maSP");
			String loaiSP = rs.getString("loaiSP");
			int soLuongTon = rs.getInt("soLuongTon");
			NhaCungCap ncc = new NhaCungCap(rs.getString("maNCC"));
			long giaNhap = rs.getLong("giaNhap");
			long giaBan = rs.getLong("giaBan");
			String donVi = rs.getString("donVi");
			sp = new SanPham(maSanPham, ncc, loaiSP, soLuongTon, donVi, giaNhap,giaBan);

			return sp;
		}
		return null;
	}
	
	public Sach getSachTheoMaSP(String maSP) throws SQLException {
		Sach s = new Sach();
		String query = "Select * from SanPham where maSP=?";
		ps = con.prepareStatement(query);
		ps.setString(1, maSP);
		rs = ps.executeQuery();
		while (rs.next()) {
			String maSanPham = rs.getString("maSP");
			String loaiSP = rs.getString("loaiSP");
			int soLuongTon = rs.getInt("soLuongTon");
			NhaCungCap ncc = new NhaCungCap(rs.getString("maNCC"));
			long giaNhap = rs.getLong("giaNhap");
			long giaBan = rs.getLong("giaBan");
			String donVi = rs.getString("donVi");
			String tenSach = rs.getString("tenSach");
			TacGia tacGia = new TacGia(rs.getString("maTacGia"));
			NhaXuatBan nhaXuatBan = new NhaXuatBan(rs.getString("maNXB"));
			TheLoaiSach theLoaiSach = new TheLoaiSach(rs.getString("maTheLoaiSach"));
			s = new Sach(maSanPham, ncc, loaiSP, soLuongTon, donVi, giaNhap,giaBan,tenSach,tacGia,nhaXuatBan,theLoaiSach );
			return s;
		}
		return null;
	}
	
	public String getLoaiSanPhamTheoMa() throws SQLException {
		String query = "Select loaiSP from SanPham where maSP = ?";
		ps = con.prepareStatement(query);
		ps.executeQuery();
		return null;
	}
	
	public SanPham getSanPhamTheoMa(String masp) throws SQLException {
		String query = "Select * from SanPham where maSP=?";
		ps = con.prepareStatement(query);
		ps.setString(1, masp);
		rs = ps.executeQuery();
		while (rs.next()) {
			SanPham sp = new SanPham(rs.getString("maSP"));
			return sp;
		}
		return null;
	}
	
	public ArrayList<Sach> getListSach(String maSach, String tenSP, String maTheLoai, Long giaTu, Long giaDen,
			String maTacGia, String maNXB, String maNCC, boolean hetHang) throws Exception {

		ArrayList<Sach> listSach = new ArrayList<>();
		query = "SELECT SanPham.maSP, SanPham.soLuongTon,SanPham.loaiSP, NhaCungCap.maNCC, NhaCungCap.tenNCC, SanPham.giaNhap, SanPham.ghiChu, SanPham.trongLuong, SanPham.donVi, SanPham.hinhAnh, SanPham.tenSach, TacGia.maTacGia, \r\n"
				+ "                  TacGia.tenTacGia, NhaXuatBan.maNXB, NhaXuatBan.tenNXB, SanPham.namXB, SanPham.soTrang, TheLoaiSach.maTheLoai, TheLoaiSach.tenTheLoai\r\n"
				+ "FROM     SanPham INNER JOIN\r\n"
				+ "                  NhaCungCap ON SanPham.maNCC = NhaCungCap.maNCC INNER JOIN\r\n"
				+ "                  NhaXuatBan ON SanPham.maNXB = NhaXuatBan.maNXB INNER JOIN\r\n"
				+ "                  TacGia ON SanPham.maTacGia = TacGia.maTacGia INNER JOIN\r\n"
				+ "                  TheLoaiSach ON SanPham.maTheLoai = TheLoaiSach.maTheLoai"
				+ " where maSP like '%" + maSach + "%' and tenSach like N'%" + tenSP
				+ "%' and SanPham.maTheLoai like '%" + maTheLoai + "%' \r\n"
				+ "	and SanPham.giaNhap > ? and SanPham.giaNhap < ? and SanPham.maTacGia like '%" + maTacGia + "%' \r\n"
				+ "	and SanPham.maNXB like '%" + maNXB + "%' and SanPham.maNCC like '%" + maNCC + "%'";
		if (hetHang) {
			query = query + " and soLuongTon = 0";
		}
		ps = con.prepareStatement(query);
		ps.setLong(1, giaTu);
		ps.setLong(2, giaDen);
		rs = ps.executeQuery();
		while (rs.next()) {
			Sach s = new Sach(rs.getString("maSP"), new NhaCungCap(rs.getString("maNCC"), rs.getString("tenNCC"),rs.getString("email"),rs.getString("Sdt")), rs.getString("loaiSP"), 
					rs.getInt("soLuongTon"),rs.getString("donVi"), rs.getLong("giaNhap"), rs.getLong("giaBan"), 
					rs.getString("tenSach"), new TacGia(rs.getString("maTacGia"), rs.getString("tenTacGia")),
					new NhaXuatBan(rs.getString("maNXB"), rs.getString("tenNXB")),new TheLoaiSach(rs.getString("maTheLoaiSach")));
			listSach.add(s);
		}
		return listSach;
	}

	public List<Sach> getAllSach() throws Exception {
		List<Sach> dsS = new ArrayList<Sach>();
		tacgiaDao = new TacGiaDao();
		theloaiDao = new TheLoaiDao();
		try {
			String query = "Select * from SanPham where loaiSP=?";
			ps = con.prepareStatement(query);
			ps.setString(1, "Sách");
			rs = ps.executeQuery();
			while (rs.next()) {

				String maSanPham = rs.getString("maSP");
				int soLuongTon = rs.getInt("soLuongTon");
				String loaiSP = rs.getString("loaiSP");
				NhaCungCap ncc = new NhaCungCap(rs.getString("maNCC"));
				long giaNhap = rs.getLong("giaNhap");
				long giaBan = rs.getLong("giaBan");
				String donVi = rs.getString("donVi");
				String tenSach = rs.getString("tenSach");
				TacGia tacGia = new TacGia();
				if (rs.getString("maTG") != null) {
					tacGia = tacgiaDao.getTacGia(rs.getString("maTG")).get(0);
					
				} else {
					tacGia = null;
				}
				NhaXuatBan nhaXuatBan = new NhaXuatBan(rs.getString("maNXB"));
				TheLoaiSach theLoaiSach = theloaiDao.getSachTheoTheLoai(rs.getString("maTheLoaiSach")).get(0);
				Sach s = new Sach(maSanPham, ncc, loaiSP, soLuongTon, donVi, giaNhap,giaBan,tenSach,tacGia,nhaXuatBan,theLoaiSach );
				dsS.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed");//test
		}
		return dsS;
	}
	
	public List<VanPhongPham> getAllVPP() {
		List<VanPhongPham> dsVPP = new ArrayList<>();
		nhaSanXuatDao = new NhaSanXuatDao();
		
		try {
			String query = "Select * "
					+ "	FROM SanPham INNER JOIN"
					+ " MauSac ON SanPham.maMauSac = MauSac.maMauSac where loaiSP=?";
			ps = con.prepareStatement(query);
			ps.setString(1, "VPP");
			rs = ps.executeQuery();
			while (rs.next()) {

				String maSanPham = rs.getString("maSP");
				int soLuongTon = rs.getInt("soLuongTon");
				String loaiSP = rs.getString("loaiSP");
				NhaCungCap ncc = new NhaCungCap(rs.getString("maNCC"));
				long giaNhap = rs.getLong("giaNhap");
				long giaBan = rs.getLong("giaBan");
				String donVi = rs.getString("donVi");
				String tenVPP = rs.getString("tenVanPhongPham");
				MauSac mauSac = new MauSac(rs.getString("maMauSac"),rs.getString("tenMau"));
				TheLoaiVanPhongPham theLoaiVanPhongPham = new TheLoaiVanPhongPham(rs.getString("maLoaiVanPhongPham"));
				NhaSanXuat nhaSanXuat = new NhaSanXuat();
				if (rs.getString("maNSX") != null) {
					nhaSanXuat = nhaSanXuatDao.getNhaSanXuat(rs.getString("maNSX")).get(0);
				} else {
					nhaSanXuat = null;
				}
				
				VanPhongPham vpp = new VanPhongPham(maSanPham, ncc, loaiSP, soLuongTon, donVi, giaNhap,giaBan, tenVPP, mauSac, nhaSanXuat, theLoaiVanPhongPham);

				dsVPP.add(vpp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsVPP;
	}
	
	public boolean kiemTraTonTaiSanPham(String tenSP) {
		String query = "select * from SanPham where tenSach = N'"+tenSP+"'";// or tenVanPhongPham = N'"+tenSP+"'";
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Đã vào tới đây luôn rồi");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
