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

	

	
	

}