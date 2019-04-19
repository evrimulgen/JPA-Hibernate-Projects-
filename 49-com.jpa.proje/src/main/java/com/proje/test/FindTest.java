package com.proje.test;

import java.util.List;

import com.proje.model.Advertisement;
import com.proje.model.Education;
import com.proje.model.UserDetail;
import com.proje.model.UserInfo;
import com.proje.model.User_My;
import com.proje.service.AdvertisementService;
import com.proje.service.EducationService;
import com.proje.service.UserDetailService;
import com.proje.service.UserService;
import com.proje.service.impl.AdvertisementServiceImpl;
import com.proje.service.impl.EducationServiceImpl;
import com.proje.service.impl.UserDetailServiceImpl;
import com.proje.service.impl.UserServiceImpl;

public class FindTest {


	public static void main(String[] args) {
		
		AdvertisementService advertisementService=new AdvertisementServiceImpl();
		
		EducationService educationService=new EducationServiceImpl();
		
		UserDetailService userDetailService=new UserDetailServiceImpl();
		
		UserService userService=new UserServiceImpl();
		
		//-------------------------------------------------------------------------------

		                               //USER ILE ARAMA YAPTIK\\
		                           //-----------------------------\\
		//UserId ile arama yapt�k
		User_My user_My=userService.findById(7);
		
		System.out.println(user_My);
		
		//-------------------------------------------------------------------------------
//		
		//userName �le arama yapt�k
//		
//		User_My user_My=userService.findByUserName("ali");
//
//		System.out.println(user_My);
		//-------------------------------------------------------------------------------
		
		//user ve user detail b�lg�ler�n� bulduk
		
//				User_My user_My=userService.findWithUserDetailByUsername("ali");
//     	System.out.println(user_My);
		
		//-------------------------------------------------------------------------------
		
		//t�m userlar� bulduk
		
//		List<User_My> user_My=userService.findUsers();
//		
//		for (User_My user_My2 : user_My) {
//			System.out.println(user_My2);
//		}
		//-------------------------------------------------------------------------------
		
		//toplam user say�s�n� bulduk
		
//		Long user=userService.findUserCount();
//		System.out.println(user);
		
		
		//-------------------------------------------------------------------------------

		//iki classdanda istedigimiz verileri �ektik userinfo ile birle�tirme yapt�k bir nevi appened gibi
		
		UserInfo info=userService.findUserInfoByUserName("mtn");
		System.out.println(info);
		
		//-------------------------------------------------------------------------------
		
		//baslang�c poz�syonu ve �lerleme m�ktar�yla arama yapt�k
		
//		List<User_My>  user_Mies= userService.findUsers(3,2);
//		
//		for (User_My user_My : user_Mies) {
//			System.out.println(user_My);
//		}
		//-------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------

		
		
		                           //USERDETA�L �LE ARAMA YAPTIK\\
		                       //-----------------------------------\\
		//userdetail �d ile arama yapt�k
		
		UserDetail detail=userDetailService.findById(4);
		
		System.out.println(detail);
//		
		//-------------------------------------------------------------------------------

		//userdetail user_my daki username ile arad�k ve bulduk
//		UserDetail detail=userDetailService.findByUsurname("mtn");
//		
//		System.out.println(detail);
		
		
		//-------------------------------------------------------------------------------

		//userdetail adres ile birleltirerek sorgu att�k
		
//		
//		UserDetail detail=userDetailService.findWithAddressByUserName("mtn");
//		
//		System.out.println(detail);
//		
		//-------------------------------------------------------------------------------

		
		//Userdetail clas�m�zdaki findWithAdvertisementByUserName sorgumuz ile username ile hem userdetail bilgilerini hemde
		//User clas�m�zdak� username ile arama yaparak O USER'A ait avertisement� bulduk
		
		
//		UserDetail detail=userDetailService.findWithAdvertisementByUserName("mtn");
//		
//		System.out.println(detail);
		
		//------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------

		
		                           //ADVERT�SEMENT �LE ARAMA YAPTIK\\
		                        //------------------------------------\\
		
		//id ile arama yapt�k
		
		Advertisement advertisement=advertisementService.findById(23);
		
		System.out.println(advertisement);
		
		//-------------------------------------------------------------------------------

		//G�ZEL B�R SORGU YAZDIK
		
		//Advertisement ilan�n� paylasan ki�inin username ile arama yaparak ilan�m�za ulast�k
		//Yani a��klayacak olursak 
		//1-�lk basta advertesement nesnes� olusturarak userdetaile left jo�n yaparak ulast�k 
		//2-Sonra userdetail de User_my ile left jo�n yaparak ulast� ve datay� bu sek�klde ald�k 
		//3 ad�ml�k ili�ki s�zkonusudur....
		
//		Advertisement advertisement=advertisementService.findByUserName("mtn");
//		System.out.println(advertisement);
		
		//-------------------------------------------------------------------------------

		//T�m ilanlar� bulduk
//		
//		List< Advertisement> advertisements=advertisementService.findAdvertisements();
//		
//		for (Advertisement advertisement : advertisements) {
//			
//			System.out.println(advertisement);
//		}
		
		//-------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------

                               //EDUCAT�ON �LE ARAMA YAPTIK\\
		                     //-------------------------------\\
		
		//T�m educationlar� bulduk
		
		List<Education> educations=educationService.findEducations();
		
		for (Education education : educations) {
			System.out.println(education);
		}
//		
		//-------------------------------------------------------------------------------

		//EducationId ile arama yapt�k
		
//		Education education=educationService.findById(16);
//		System.out.println(education);
		
		
		//-------------------------------------------------------------------------------

		
		//EducatinId ile arama yaparak hem education hemde o educationa bagl� ilan listelerini getirdik
		
//		Education education=educationService.findWithAdvertisement(17);
//		System.out.println(education);
		
		//-------------------------------------------------------------------------------

		
	}
	
	
	
	
	
	
}
