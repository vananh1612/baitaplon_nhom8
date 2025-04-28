package baitaplon.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sinhvien")
public class sinhvien {
	@Id
	@Column(name = "ID")
	private String ID;
	@Column(name = "MaSinhVien")
	private String maSinhVien;
	@Column(name = "HoTen")
	private String hoTen;

	@Column(name = "NgaySinh")
	@Temporal(TemporalType.DATE)
	private Date ngaySinh;

	@Column(name = "Email")
	private String email;

	@Column(name = "SDT")
	private String sdt;

	@Column(name = "DiaChi")
	private String diaChi;

	@Column(name = "HeDT")
	
	private String heDT;

	@Column(name = "NamHoc")
	@Temporal(TemporalType.DATE)
	private Date namHoc;

	
	@ManyToOne
	@JoinColumn(name = "ID_lop", insertable = false, updatable = false)
	private lop ID_lop;
	@Column(name = "ID_lop")
	private String ID_lop_thuocDB;

	public String getID_lop_thuocDB() {
		return ID_lop_thuocDB;
	}

	public void setID_lop_thuocDB(String iD_lop_thuocDB) {
		ID_lop_thuocDB = iD_lop_thuocDB;
	}

	public String getID() {
		return ID;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getHeDT() {
		return heDT;
	}

	public void setHeDT(String heDT) {
		this.heDT = heDT;
	}

	public Date getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(Date namHoc) {
		this.namHoc = namHoc;
	}


	public lop getID_lop() {
		return ID_lop;
	}

	public void setID_lop(lop iD_lop) {
		ID_lop = iD_lop;
	}

	

}
