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

 

    @ManyToOne
	@JoinColumn(name = "ID_khoa", insertable = false, updatable = false)
	private khoa ID_khoa;

	public String getID() {
		return ID;
	}
	@Column(name = "ID_khoa")
	private String ID_khoa_thuocDB;

	public void setID(String iD) {
		ID = iD;
	}

	public String getID_khoa_thuocDB() {
		return ID_khoa_thuocDB;
	}

	public void setID_khoa_thuocDB(String iD_khoa_thuocDB) {
		ID_khoa_thuocDB = iD_khoa_thuocDB;
	}

	public String getTenNganh() {
		return tenNganh;
	}

	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}


	public khoa getID_khoa() {
		return ID_khoa;
	}

	public void setID_khoa(khoa iD_khoa) {
		ID_khoa = iD_khoa;
	}

	

	

}
