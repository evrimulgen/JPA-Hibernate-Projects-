# JPA-Hibernate-Project-

**Jpa-Hibernate-Project**

-Projede Address clasımızı @Embedable olarak tanımladım ve UserDetail clasımızın içerisindeki

ElementCollection içerisine gömülebilir olarak tuttum.Bu Adres bilgilerini UserDetail'e baglı

farklı bir tablo olarak ayarladım.

-Ayrıca birden fazla clasımızın bilgilerini göstermek için UserInfo adında bilgileri farklı bir classda

gösterecek şekilde yeni bir class oluşturdum.Amacımız birden fazla classdaki dataları tek classdan okumak.


@NamedQuery(name = "User_My.findUserInfoByUserName", query = 
"SELECT new com.proje.model.UserInfo(U.userName,U.userDetail.firstName,U.userDetail.lastName,U.userDetail.birthOfDate)"
				+ " FROM User_My U WHERE U.userName=:userName")})


-Education egitim bilgilerinin oldugu clasımız

-Advertisement user'un paylastıgı ilanları tutan farklı bır tablo

-Test classımızda ise insertData ile dataları db ye kaydediyoruz.

-TestFind ile datalarımızı db'den okuyarak bulma işlemini gerçekleştiriyoruz.

-Projenin service kısmı mevcut oldugu için yapılacak degişikliklerden minumum derecede etkilenmesi için bu şekilde dizayn ettim.


------------------------------------------------------------------------------------------------------------------------

                                          **Jpa-Hibernate-Project-İlişkiler**


**User_My** Class yapısı ve jpa hibernate ilişkileri ve sorguları
@AllArgsConstructor
@NoArgsConstructor

@Entity
@NamedQueries({
		// USER VE USERDETAİL BİLGİLERİNİ SORGUYLA ALDIK
		
		@NamedQuery(name = "User_My.findById", query =
		"SELECT U FROM User_My U LEFT JOIN FETCH U.userDetail WHERE U.userId=:userId "),
		@NamedQuery(name = "User_My.findByUserName", query = "SELECT U FROM User_My U  WHERE U.userName=:userName "),
		@NamedQuery(name = "User_My.findWithUserDetailByUsername", query = "SELECT U FROM User_My U LEFT JOIN FETCH U.userDetail WHERE U.userName=:userName "),
		@NamedQuery(name = "User_My.findUsers", query = "SELECT U FROM User_My U "),
		@NamedQuery(name = "User_My.findCount", query = "SELECT COUNT(U) FROM User_My U"),
		@NamedQuery(name = "User_My.findUserInfoByUserName", query = "SELECT new com.proje.model.UserInfo(U.userName,U.userDetail.firstName,U.userDetail.lastName,U.userDetail.birthOfDate)"
				+ " FROM User_My U WHERE U.userName=:userName")})
public class User_My implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	private String userName;

	private String password_my;

	@Temporal(TemporalType.DATE)
	private Date creationDate;

	// BÜTÜN BİLGİLER GELMESİN SORGUYLA GELMESİNİ İSTEDİK
	// PERFORMANSI ARTTIRMAK İÇİN
	// cascadetype ile bir user silinince userdatail de silinsin eklensin
	// guncellensin dedık  (fetch=FetchType.LAZY)
	@OneToOne(fetch=FetchType.LAZY)
	private UserDetail userDetail;


-----------------------------------------------------------------------------------------

**UserDetail** Class yapısı ve jpa hibernate ilişkileri ve sorguları


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

	@ElementCollection(fetch=FetchType.LAZY)
	@JoinTable(name = "userDetail_PhoneNumber", joinColumns = @JoinColumn(name = "userDetailId"))
	@MapKeyColumn(name = "phoneType")
	@Column(name = "phoneNumber")
	@MapKeyEnumerated(EnumType.STRING)
	private Map<PhoneType, String> phoneNumbers = new HashMap<PhoneType, String>();

	// Embedable clasımız buranın içine gömülecek farklı bir tablo olacak ama user_My
	// detaile baglı olacak
	@Embedded
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "userDetail_address", joinColumns = @JoinColumn(name = "UserDetailId"))
	private List<Address> addresses = new ArrayList<Address>();

	@OneToMany(mappedBy="userDetail",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},fetch=FetchType.LAZY)
	private List<Advertisement> advertisements = new ArrayList<Advertisement>();

	@OneToOne(fetch=FetchType.LAZY,mappedBy="userDetail")
	private User_My user_My;


-------------------------------------------------------------------------------------------------------

**Education** Class yapısı ve jpa hibernate ilişkileri ve sorguları


@AllArgsConstructor
@NoArgsConstructor

@Entity
@NamedQueries(


		{ @NamedQuery(name = "Education.findEducations", query = "SELECT E FROM Education E"),
		@NamedQuery(name = "Education.findById", query = "SELECT E FROM Education E WHERE E.educationId=:educationId"),
		@NamedQuery(name = "Education.findWithAdvertisement", query = "SELECT E FROM Education E LEFT JOIN FETCH E.advertisements WHERE E.educationId=:educationId"),

})


public class Education implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer educationId;

	private String educationName;

	private int lisansYear;

	@ManyToMany(mappedBy="educations",fetch=FetchType.EAGER)
	private List<Advertisement> advertisements = new ArrayList<Advertisement>();


-------------------------------------------------------------------------------------------------------------------


**Advertisement** Class yapısı ve jpa hibernate ilişkileri ve sorguları



@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="advertisements")
@NamedQueries({

		@NamedQuery(name = "Advertisement.findById", query = "SELECT A FROM Advertisement A LEFT JOIN FETCH A.educations WHERE A.advertisementId=:advertisementId"),
		@NamedQuery(name = "Advertisement.findByUserName", query = "SELECT A FROM Advertisement A LEFT JOIN   A.userDetail UD LEFT JOIN   UD.user_My U WHERE U.userName=:userName "),
		@NamedQuery(name = "Advertisement.findAdvertisements", query = "SELECT A FROM Advertisement A ")})
		
public class Advertisement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer advertisementId;

	@Column(name="titles")
	private String title;

	// uzun veriler alabılmesi için
	@Lob
	@Column(name="workDefinitions")
	private String workDefinition;

	@Lob
	@Column(name="criterias")
	private String criteria;

	@Temporal(TemporalType.TIMESTAMP)
	private Date addDate;

	

	@ManyToMany(fetch=FetchType.LAZY)
	private List<Education> educations = new ArrayList<Education>();

	@ManyToOne(fetch=FetchType.LAZY,targetEntity=UserDetail.class)
	@JoinColumn(name = "userDetailId")
	private UserDetail userDetail;

---------------------------------------------------------------------------------------------------------

**Address** Class yapısı ve jpa hibernate ilişkileri ve sorguları


@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Address {

	private String street;

	private String road;

	private int postaCode;

	private String city;

}

-------------------------------------------------------------------------------------------------------

**UserInfo** Class yapısı ve jpa hibernate ilişkileri ve sorguları


@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserInfo {

	private String userName;

	private String firstName;

	private String lastName;

	private Date birthOfDate;

}
