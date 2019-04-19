package com.proje.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @author MetinKalinsaz
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedQueries({
		// USER VE USERDETAÝL BÝLGÝLERÝNÝ SORGUYLA ALDIK
		@NamedQuery(name = "User_My.findById", query = "SELECT U FROM User_My U LEFT JOIN FETCH U.userDetail WHERE U.userId=:userId "),
		@NamedQuery(name = "User_My.findByUserName", query = "SELECT U FROM User_My U  WHERE U.userName=:userName "),
		@NamedQuery(name = "User_My.findWithUserDetailByUsername", query = "SELECT U FROM User_My U LEFT JOIN FETCH U.userDetail WHERE U.userName=:userName "),
		@NamedQuery(name = "User_My.findUsers", query = "SELECT U FROM User_My U "),
		@NamedQuery(name = "User_My.findCount", query = "SELECT COUNT(U) FROM User_My U"),
		@NamedQuery(name = "User_My.findUserInfoByUserName", query = "SELECT new com.proje.model.UserInfo(U.userName,U.userDetail.firstName,U.userDetail.lastName,U.userDetail.birthOfDate)"
				+ " FROM User_My U WHERE U.userName=:userName") })
public class User_My implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	private String userName;

	private String password_my;

	@Temporal(TemporalType.DATE)
	private Date creationDate;

	// BÜTÜN BÝLGÝLER GELMESÝN SORGUYLA GELMESÝNÝ ÝSTEDÝK
	// PERFORMANSI ARTTIRMAK ÝÇÝN
	// cascadetype ile bir user silinince userdatail de silinsin eklensin
	// guncellensin dedýk (fetch=FetchType.LAZY)
	@OneToOne(fetch = FetchType.LAZY)
	private UserDetail userDetail;

	public User_My(String userName, String password, Date creationDate) {
		this.creationDate = creationDate;
		this.password_my = password;
		this.userName = userName;

	}

	@Override
	public String toString() {
		return "User_My [userId=" + userId + ", userName=" + userName + ", password_my=" + password_my
				+ ", creationDate=" + creationDate + ", userDetail=" + userDetail + "]";
	}

}
