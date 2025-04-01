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
@Table(name = "nganh")
public class nganh {
	
	@Id
    @Column(name = "ID")
    private String ID;
    
	@Column(name = "TenNganh")
    private String tenNganh;

    @OneToMany(mappedBy = "ID_nganh", cascade = CascadeType.ALL)
    private List<sinhvien> sinhvienList;

    @ManyToOne
	@JoinColumn(name = "ID_khoa", insertable = false, updatable = false)
	private khoa ID_khoa;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTenNganh() {
		return tenNganh;
	}

	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}

	public List<sinhvien> getSinhvienList() {
		return sinhvienList;
	}

	public void setSinhvienList(List<sinhvien> sinhvienList) {
		this.sinhvienList = sinhvienList;
	}

	public khoa getID_khoa() {
		return ID_khoa;
	}

	public void setID_khoa(khoa iD_khoa) {
		ID_khoa = iD_khoa;
	}

	

	

}
