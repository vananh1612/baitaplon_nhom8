package baitaplon.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user") 
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class user {

    
  
	@Id
    @Column(name = "ID")
    private String ID;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;
    public user(String username, String password) {
        this.userName = username;
        this.passWord = password;
    }
    public user() {
    }
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
    
}
