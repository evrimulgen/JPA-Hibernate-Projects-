package com.proje.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.proje.model.util.PhoneType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedQueries({
		@NamedQuery(name = "UserDetail.findById", query = "SELECT UD FROM UserDetail UD WHERE UD.userDetailId=:userDetailId"),
		@NamedQuery(name = "UserDetail.findByUsurname", query = "SELECT UD FROM UserDetail UD WHERE UD.user_My.userName=:userName"),
		@NamedQuery(name = "UserDetail.findWithAddressByUserName", query = "SELECT UD FROM UserDetail UD LEFT JOIN FETCH UD.addresses WHERE UD.user_My.userName=:userName"),
		@NamedQuery(name = "UserDetail.findWithAdvertisementByUserName", query = "SELECT UD FROM UserDetail UD LEFT JOIN  UD.advertisements A WHERE UD.user_My.userName=:userName") })
public class UserDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userDetailId;

	private String firstName;

	private String lastName;

	private Date birthOfDate;

	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "userDetail_PhoneNumber", joinColumns = @JoinColumn(name = "userDetailId"))
	@MapKeyColumn(name = "phoneType")
	@Column(name = "phoneNumber")
	@MapKeyEnumerated(EnumType.STRING)
	private Map<PhoneType, String> phoneNumbers = new HashMap<PhoneType, String>();

	// Embedable clasýmýz buranýn içine gömülecek farklý bir tablo olacak ama
	// user_My
	// detaile baglý olacak
	@Embedded
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "userDetail_address", joinColumns = @JoinColumn(name = "UserDetailId"))
	private List<Address> addresses = new ArrayList<Address>();

	@OneToMany(mappedBy = "userDetail", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private List<Advertisement> advertisements = new ArrayList<Advertisement>();

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "userDetail")
	private User_My user_My;

	public UserDetail(String firstName, String lastName, Date birthOfDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthOfDate = birthOfDate;
	}

	@Override
	public String toString() {
		return "UserDetail [userDetailId=" + userDetailId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthOfDate=" + birthOfDate + ", phoneNumbers=" + phoneNumbers + ", addresses=" + addresses
				+ ", advertisements=" + advertisements + "]";
	}

}
