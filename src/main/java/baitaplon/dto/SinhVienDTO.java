package baitaplon.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class SinhVienDTO {
	private String ID;
	private String ma_sinh_vien;
	private String ho_ten;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay_sinh;
	private String email;
	private String sdt;
	private String dia_chi;
	private String hedt;
	@DateTimeFormat(pattern = "yyyy")
	private Date nam_hoc;
	private String ID_lop;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getHo_ten() {
		return ho_ten;
	}

	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}

	public Date getNgay_sinh() {
		return ngay_sinh;
	}

	public void setNgay_sinh(Date ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
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

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	
	public String getMa_sinh_vien() {
		return ma_sinh_vien;
	}

	public void setMa_sinh_vien(String ma_sinh_vien) {
		this.ma_sinh_vien = ma_sinh_vien;
	}

	public String getHedt() {
		return hedt;
	}

	public void setHedt(String hedt) {
		this.hedt = hedt;
	}

	public Date getNam_hoc() {
		return nam_hoc;
	}

	public void setNam_hoc(Date nam_hoc) {
		this.nam_hoc = nam_hoc;
	}

	

	public String getID_lop() {
		return ID_lop;
	}

	public void setID_lop(String iD_lop) {
		ID_lop = iD_lop;
	}
	

}
