package org.hotel.entity;

// default package
// Generated Aug 9, 2017 9:25:36 PM by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * MHotels generated by hbm2java
 */
@Entity
@Table(name = "m_hotels", catalog = "hotels")
public class MHotels implements java.io.Serializable {

	private Integer htlId;
	private MCity MCity;
	private String htlName;
	private String htlStreet;
	private String htlActive;
	private String htlPhoneNo;
	private String htlEmail;

	public MHotels() {
	}

	public MHotels(MCity MCity, String htlName, String htlStreet, String htlActive, String htlPhoneNo,
			String htlEmail) {
		this.MCity = MCity;
		this.htlName = htlName;
		this.htlStreet = htlStreet;
		this.htlActive = htlActive;
		this.htlPhoneNo = htlPhoneNo;
		this.htlEmail = htlEmail;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "htl_id", unique = true, nullable = false)
	public Integer getHtlId() {
		return this.htlId;
	}

	public void setHtlId(Integer htlId) {
		this.htlId = htlId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cty_id", nullable = false)
	public MCity getMCity() {
		return this.MCity;
	}

	public void setMCity(MCity MCity) {
		this.MCity = MCity;
	}

	@Column(name = "htl_name", nullable = false, length = 70)
	public String getHtlName() {
		return this.htlName;
	}

	public void setHtlName(String htlName) {
		this.htlName = htlName;
	}

	@Column(name = "htl_street", nullable = false, length = 50)
	public String getHtlStreet() {
		return this.htlStreet;
	}

	public void setHtlStreet(String htlStreet) {
		this.htlStreet = htlStreet;
	}

	@Column(name = "htl_active", nullable = false, length = 2)
	public String getHtlActive() {
		return this.htlActive;
	}

	public void setHtlActive(String htlActive) {
		this.htlActive = htlActive;
	}

	@Column(name = "htl_phone_no", nullable = true, length = 10)
	public String getHtlPhoneNo() {
		return this.htlPhoneNo;
	}

	public void setHtlPhoneNo(String htlPhoneNo) {
		this.htlPhoneNo = htlPhoneNo;
	}
	
	@Column(name = "htl_email", nullable = true, length = 40)
	public String getHtlEmail() {
		return this.htlEmail;
	}

	public void setHtlEmail(String htlEmail) {
		this.htlEmail = htlEmail;
	}
}