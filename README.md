# JPA-Hibernate-Projects-

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

