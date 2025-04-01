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
