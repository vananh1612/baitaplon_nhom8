package baitaplon.model;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "khoa")
public class khoa {

	@Id
	@Column(name = "ID")
	private String ID;

	@Column(name = "TenKhoa")
	private String tenKhoa;


	@OneToMany(mappedBy = "ID_khoa", cascade = CascadeType.ALL)
	private List<nganh> nganhList;

	@OneToMany(mappedBy = "ID_khoa", cascade = CascadeType.ALL)
	private List<sinhvien> sinhvienList;



	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	

	public String getTenKhoa() {
		return tenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}

	

	public List<nganh> getNganhList() {
		return nganhList;
	}

	public void setNganhList(List<nganh> nganhList) {
		this.nganhList = nganhList;
	}

	public List<sinhvien> getSinhvienList() {
		return sinhvienList;
	}

	public void setSinhvienList(List<sinhvien> sinhvienList) {
		this.sinhvienList = sinhvienList;
	}
	

}