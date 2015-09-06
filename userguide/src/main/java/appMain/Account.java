package appMain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Override
	public String toString() {
		return "Account [userName=" + userName + ", userSurname=" + userSurname
				+ ", email=" + email + ", password=" + password
				+ ", creditcard=" + this.getCreditCard() + "]";
	}

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "username")
	private String userName;
	@Column(name = "usersurname")
	private String userSurname;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@ManyToOne
	private CreditCard creditcard;

	public Account() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CreditCard getCreditCard() {
		return creditcard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditcard = creditCard;
	}

}
