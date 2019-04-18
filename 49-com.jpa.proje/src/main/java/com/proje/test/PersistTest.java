package com.proje.test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.proje.model.Address;
import com.proje.model.Advertisement;
import com.proje.model.Education;
import com.proje.model.User_My;
import com.proje.model.UserDetail;
import com.proje.model.util.PhoneType;
import com.proje.service.AdvertisementService;
import com.proje.service.EducationService;
import com.proje.service.UserDetailService;
import com.proje.service.UserService;
import com.proje.service.impl.AdvertisementServiceImpl;
import com.proje.service.impl.EducationServiceImpl;
import com.proje.service.impl.UserDetailServiceImpl;
import com.proje.service.impl.UserServiceImpl;

public class PersistTest {

	private static AdvertisementService advertisementService = new AdvertisementServiceImpl();

	private static EducationService educationService = new EducationServiceImpl();

	private static UserDetailService userDetailService = new UserDetailServiceImpl();

	private static UserService userService = new UserServiceImpl();

	//Tarýh bilgilerinin alýnýp verilecegi calender metodumuz
	public static Date customCalender(int day, int month, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);

		return calendar.getTime();

	}

	public static void main(String[] args) {
		PersistTest persistTest = new PersistTest();
		persistTest.insertData();

	}

	public void insertData() {

		UserDetail userDetail1 = new UserDetail("metin", "kalýnsaz", customCalender(21, 10, 1991));

		UserDetail userDetail2 = new UserDetail("isa", "kalýnsaz", customCalender(17, 8, 1989));

		UserDetail userDetail3 = new UserDetail("ali", "veli", customCalender(12, 11, 1994));

		UserDetail userDetail4 = new UserDetail("ahmet", "yýlmaz", customCalender(19, 5, 1987));

		UserDetail userDetail5 = new UserDetail("alpay", "tirasoglu", customCalender(01, 04, 1993));

		UserDetail userDetail6 = new UserDetail("umut", "sinav", customCalender(23, 11, 1991));

		// ------------------------------------------------------------------------------------------------------------

		User_My user1 = new User_My("mtn", "12345", customCalender(15, 4, 2019));
		User_My user2 = new User_My("merkur", "89065", customCalender(15, 4, 2019));
		User_My user3 = new User_My("ali", "64547", customCalender(15, 4, 2019));
		User_My user4 = new User_My("ahmet", "95858", customCalender(15, 4, 2019));
		User_My user5 = new User_My("alpy", "525252", customCalender(15, 4, 2019));
		User_My user6 = new User_My("umut", "010101", customCalender(15, 4, 2019));

		// ------------------------------------------------------------------------------------------------------------

		Education education1 = new Education("Bilgisayar MÜHENDÝSÝ", 4);
		Education education2 = new Education("ELEKTRÝK-ELEKTRONÝK MÜHENDÝSÝ", 4);
		Education education3 = new Education("Bilgisayar Programcýlýgý", 2);
		Education education4 = new Education("ÇEVRE MÜHENDÝSÝ", 4);
		Education education5 = new Education("iNGÝLÝZCE ÖGRETMENÝ", 4);
		Education education6 = new Education("KÝMYA", 4);

		// ------------------------------------------------------------------------------------------------------------

		Advertisement advertisement1 = new Advertisement("mühendis", "mühendislik çözümleri üretmeli",
				"4 yýllýk lisan egitim", new Date());
		Advertisement advertisement2 = new Advertisement("Bilgisayar mühendis", "mühendislik çözümleri üretmeli",
				"4 yýllýk lisan egitim", new Date());
		Advertisement advertisement3 = new Advertisement("bilgisayar", "programcý",
				"2 veya 4 yýllýk lisan-önlisans egitim", new Date());
		Advertisement advertisement4 = new Advertisement("çevre-kimya ",
				"mühendislik çözümleri üretmeli -çevre kimya bilmeli", "4 yýllýk lisan egitim", new Date());
		Advertisement advertisement5 = new Advertisement("bölüm",
				"mühendislik çözümleri üretmeli,ingilizce bilmeli ,kimya bilmeli", "4 yýllýk lisan egitim", new Date());
		Advertisement advertisement6 = new Advertisement("Ýngilizce-mühendis",
				"mühendislik çözümleri üretmeli inghilizce bilmeli", "4 yýllýk lisan egitim", new Date());

		// ------------------------------------------------------------------------------------------------------------

		// @ManyToMany iliþkisini kuruyoruz
		// bir egitim daliyla ilgili bircok ilan bulunabýlýr ve bir ilan birden fazla
		// egitim dalýný içerebilir
		List<Education> educations = Arrays.asList(education1, education3);
		advertisement3.setEducations(educations);

		List<Education> educations2 = Arrays.asList(education1);
		advertisement2.setEducations(educations2);

		List<Education> educations3 = Arrays.asList(education1, education2, education3);
		advertisement1.setEducations(educations3);

		List<Education> educations4 = Arrays.asList(education1, education2, education3, education4, education5,
				education6);
		advertisement5.setEducations(educations4);

		List<Education> educations5 = Arrays.asList(education4, education6);
		advertisement4.setEducations(educations5);

		List<Education> educations6 = Arrays.asList(education1, education2, education3, education4, education5);
		advertisement6.setEducations(educations6);

		// ------------------------------------------------------------------------------------------------------------

		// @OneToMany iliþkisini kuruyoruz burada
		// býr kullanýcýnýn bircok ilaný bulunabýlýr
		// ayný ilaný baska kullanýcýlarda paylasmýs olabýlýr

		advertisement1.setUserDetail(userDetail1);
		advertisement2.setUserDetail(userDetail4);
		advertisement3.setUserDetail(userDetail2);
		advertisement4.setUserDetail(userDetail5);
		advertisement5.setUserDetail(userDetail3);
		advertisement6.setUserDetail(userDetail4);

		// ------------------------------------------------------------------------------------------------------------

		userDetail1.getPhoneNumbers().put(PhoneType.HOME, "02123495412");
		userDetail1.getPhoneNumbers().put(PhoneType.CELL, "05543693417");

		userDetail2.getPhoneNumbers().put(PhoneType.CELL, "053548090");
		userDetail2.getPhoneNumbers().put(PhoneType.WORK, "434346784");
		userDetail2.getPhoneNumbers().put(PhoneType.HOME, "02123496567");

		userDetail3.getPhoneNumbers().put(PhoneType.HOME, "043356567");
		userDetail3.getPhoneNumbers().put(PhoneType.CELL, "5355677889");

		userDetail4.getPhoneNumbers().put(PhoneType.CELL, "05546344757");
		userDetail4.getPhoneNumbers().put(PhoneType.HOME, "021234965678");

		userDetail5.getPhoneNumbers().put(PhoneType.CELL, "05443444546");
		userDetail5.getPhoneNumbers().put(PhoneType.WORK, "02127886554");

		userDetail6.getPhoneNumbers().put(PhoneType.CELL, "0543344757");

		// ------------------------------------------------------------------------------------------------------------

		Address address1 = new Address("karapürcek mah", "365.sk", 06000, "ankara");
		Address address2 = new Address("izzetpasa MAH.", "ÇAM SOK.", 35000, "istanbul");
		userDetail1.getAddresses().add(address1);
		userDetail1.getAddresses().add(address2);

		Address address3 = new Address("karapürçek mah.", "365. sok.", 06000, "ankara");
		Address address4 = new Address("talin mah.", "talin sok..", 987654, "estonya talin");
		Address address5 = new Address("çaglayan mah.", "çaglayan sok.", 35000, "istanbul");

		userDetail2.getAddresses().add(address3);
		userDetail2.getAddresses().add(address4);
		userDetail2.getAddresses().add(address5);

		Address address6 = new Address("çaglayan mah.", "ömeranlý sok.", 42000, "konya");
		Address address7 = new Address("yenibosna mah.", "yenibosna sok.", 35000, "istanbul");

		userDetail3.getAddresses().add(address6);
		userDetail3.getAddresses().add(address7);

		Address address8 = new Address("izzetpasa mah.", "çam sok.", 35000, "istanbul");
		Address address9 = new Address("bornova mah.", "evka4 sok.", 34000, "izmir");

		userDetail4.getAddresses().add(address8);
		userDetail4.getAddresses().add(address9);

		Address address10 = new Address("avcýlar mah.", "45. sok.", 35000, "istanbul");
		Address address11 = new Address("efirli mah.", "56. sok.", 52000, "ordu");

		userDetail5.getAddresses().add(address10);
		userDetail5.getAddresses().add(address11);

		Address address12 = new Address("ceyhan mah.", "adana sok.", 01000, "adana");
		Address address13 = new Address("balýklý mah.", "345. sok.", 43000, "kütahya");

		userDetail6.getAddresses().add(address12);
		userDetail6.getAddresses().add(address13);

		// ------------------------------------------------------------------------------------------------------------

		// @OneToOne iliþkisini ku8ruyoruz
		// bir userýn býr tane uyser detayý olabýlýr atamayý yaptýk

		user1.setUserDetail(userDetail1);
		user2.setUserDetail(userDetail2);
		user3.setUserDetail(userDetail3);
		user4.setUserDetail(userDetail4);
		user5.setUserDetail(userDetail5);
		user6.setUserDetail(userDetail6);

		// ------------------------------------------------------------------------------------------------------------

		// service ile save metoduyla persist iþlemini yaptýk
		userDetailService.saveUserDetail(userDetail1);
		userDetailService.saveUserDetail(userDetail2);
		userDetailService.saveUserDetail(userDetail3);
		userDetailService.saveUserDetail(userDetail4);
		userDetailService.saveUserDetail(userDetail5);
		userDetailService.saveUserDetail(userDetail6);

		// ------------------------------------------------------------------------------------------------------------

		// service ile save metoduyla persist iþlemini yaptýk
		userService.saveUser(user1);
		userService.saveUser(user2);
		userService.saveUser(user3);
		userService.saveUser(user4);
		userService.saveUser(user5);
		userService.saveUser(user6);

		// ------------------------------------------------------------------------------------------------------------

		// service ile save metoduyla persist iþlemini yaptýk
		educationService.saveEducation(education1);
		educationService.saveEducation(education2);
		educationService.saveEducation(education3);
		educationService.saveEducation(education4);
		educationService.saveEducation(education5);
		educationService.saveEducation(education6);

		// ------------------------------------------------------------------------------------------------------------

		// service ile save metoduyla persist iþlemini yaptýk
		advertisementService.saveAdvertisement(advertisement1);
		advertisementService.saveAdvertisement(advertisement2);
		advertisementService.saveAdvertisement(advertisement3);
		advertisementService.saveAdvertisement(advertisement4);
		advertisementService.saveAdvertisement(advertisement5);
		advertisementService.saveAdvertisement(advertisement6);

		// ------------------------------------------------------------------------------------------------------------

	}

}
