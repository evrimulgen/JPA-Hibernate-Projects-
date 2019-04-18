package com.proje.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "advertisements")
@NamedQueries({
		@NamedQuery(name = "Advertisement.findById", query = "SELECT A FROM Advertisement A LEFT JOIN FETCH A.educations WHERE A.advertisementId=:advertisementId"),
		@NamedQuery(name = "Advertisement.findByUserName", query = "SELECT A FROM Advertisement A LEFT JOIN   A.userDetail UD LEFT JOIN   UD.user_My U WHERE U.userName=:userName "),
		@NamedQuery(name = "Advertisement.findAdvertisements", query = "SELECT A FROM Advertisement A ") })
public class Advertisement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer advertisementId;

	@Column(name = "titles")
	private String title;

	// uzun veriler alabýlmesi için
	@Lob
	@Column(name = "workDefinitions")
	private String workDefinition;

	@Lob
	@Column(name = "criterias")
	private String criteria;

	@Temporal(TemporalType.TIMESTAMP)
	private Date addDate;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Education> educations = new ArrayList<Education>();

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserDetail.class)
	@JoinColumn(name = "userDetailId")
	private UserDetail userDetail;

	public Advertisement(String title, String workDefinition, String criteria, Date addDate) {
		super();
		this.title = title;
		this.workDefinition = workDefinition;
		this.criteria = criteria;
		this.addDate = addDate;

	}

	@Override
	public String toString() {
		return "Advertisement [advertisementId=" + advertisementId + ", title=" + title + ", workDefinition="
				+ workDefinition + ", criteria=" + criteria + ", addDate=" + addDate + "]";
	}

}
