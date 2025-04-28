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
@Table(name = "lop")
public class lop {
	
	@Id
    @Column(name = "ID")
    private String ID;
    
	@Column(name = "TenLop")
    private String tenLop;

    @OneToMany(mappedBy = "ID_lop", cascade = CascadeType.ALL)
    private List<sinhvien> sinhvienList;

    @ManyToOne
	@JoinColumn(name = "ID_nganh", insertable = false, updatable = false)
	private nganh ID_nganh;
	@Column(name = "ID_nganh")
	private String ID_nganh_thuocDB;

	public String getID_nganh_thuocDB() {
		return ID_nganh_thuocDB;
	}

	public void setID_nganh_thuocDB(String iD_nganh_thuocDB) {
		ID_nganh_thuocDB = iD_nganh_thuocDB;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	
	public List<sinhvien> getSinhvienList() {
		return sinhvienList;
	}

	public void setSinhvienList(List<sinhvien> sinhvienList) {
		this.sinhvienList = sinhvienList;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public nganh getID_nganh() {
		return ID_nganh;
	}

	public void setID_nganh(nganh iD_nganh) {
		ID_nganh = iD_nganh;
	}

	

	
	

}
