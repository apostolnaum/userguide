package appMain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "creditcard")
public class CreditCard {
	@Override
	public String toString() {
		return "CreditCard [cardtype=" + cardtype + ", cardNumber="
				+ cardNumber + ", CRCcode=" + CRCcode + ", currentBalance="
				+ currentBalance + ", expirationDate=" + expirationDate
				+ ", accounts="  + "]";
	}

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "cardtype")
	private String cardtype;
	@Column(name = "cardnumber")
	private Long cardNumber;
	@Column(name = "crccode")
	private int CRCcode;
	@Column(name = "currentbalance")
	private float currentBalance;
	@Column(name = "expirationdate")
	private Date expirationDate;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "creditcard", cascade = CascadeType.ALL)
	private Set<Account> accounts;

	public CreditCard() {
		super();
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCRCcode() {
		return CRCcode;
	}

	public void setCRCcode(int cRCcode) {
		CRCcode = cRCcode;
	}

	public float getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(float currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}
