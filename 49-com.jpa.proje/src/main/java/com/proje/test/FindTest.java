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
		//UserId ile arama yaptýk
		User_My user_My=userService.findById(7);
		
		System.out.println(user_My);
		
		//-------------------------------------------------------------------------------
//		
		//userName ýle arama yaptýk
//		
//		User_My user_My=userService.findByUserName("ali");
//
//		System.out.println(user_My);
		//-------------------------------------------------------------------------------
		
		//user ve user detail býlgýlerýný bulduk
		
//				User_My user_My=userService.findWithUserDetailByUsername("ali");
//     	System.out.println(user_My);
		
		//-------------------------------------------------------------------------------
		
		//tüm userlarý bulduk
		
//		List<User_My> user_My=userService.findUsers();
//		
//		for (User_My user_My2 : user_My) {
//			System.out.println(user_My2);
//		}
		//-------------------------------------------------------------------------------
		
		//toplam user sayýsýný bulduk
		
//		Long user=userService.findUserCount();
//		System.out.println(user);
		
		
		//-------------------------------------------------------------------------------

		//iki classdanda istedigimiz verileri çektik userinfo ile birleþtirme yaptýk bir nevi appened gibi
		
		UserInfo info=userService.findUserInfoByUserName("mtn");
		System.out.println(info);
		
		//-------------------------------------------------------------------------------
		
		//baslangýc pozýsyonu ve ýlerleme mýktarýyla arama yaptýk
		
//		List<User_My>  user_Mies= userService.findUsers(3,2);
//		
//		for (User_My user_My : user_Mies) {
//			System.out.println(user_My);
//		}
		//-------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------

		
		
		                           //USERDETAÝL ÝLE ARAMA YAPTIK\\
		                       //-----------------------------------\\
		//userdetail ýd ile arama yaptýk
		
		UserDetail detail=userDetailService.findById(4);
		
		System.out.println(detail);
//		
		//-------------------------------------------------------------------------------

		//userdetail user_my daki username ile aradýk ve bulduk
//		UserDetail detail=userDetailService.findByUsurname("mtn");
//		
//		System.out.println(detail);
		
		
		//-------------------------------------------------------------------------------

		//userdetail adres ile birleltirerek sorgu attýk
		
//		
//		UserDetail detail=userDetailService.findWithAddressByUserName("mtn");
//		
//		System.out.println(detail);
//		
		//-------------------------------------------------------------------------------

		
		//Userdetail clasýmýzdaki findWithAdvertisementByUserName sorgumuz ile username ile hem userdetail bilgilerini hemde
		//User clasýmýzdaký username ile arama yaparak O USER'A ait avertisementý bulduk
		
		
//		UserDetail detail=userDetailService.findWithAdvertisementByUserName("mtn");
//		
//		System.out.println(detail);
		
		//------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------

		
		                           //ADVERTÝSEMENT ÝLE ARAMA YAPTIK\\
		                        //------------------------------------\\
		
		//id ile arama yaptýk
		
		Advertisement advertisement=advertisementService.findById(23);
		
		System.out.println(advertisement);
		
		//-------------------------------------------------------------------------------

		//GÜZEL BÝR SORGU YAZDIK
		
		//Advertisement ilanýný paylasan kiþinin username ile arama yaparak ilanýmýza ulastýk
		//Yani açýklayacak olursak 
		//1-Ýlk basta advertesement nesnesý olusturarak userdetaile left joýn yaparak ulastýk 
		//2-Sonra userdetail de User_my ile left joýn yaparak ulastý ve datayý bu sekýklde aldýk 
		//3 adýmlýk iliþki sözkonusudur....
		
//		Advertisement advertisement=advertisementService.findByUserName("mtn");
//		System.out.println(advertisement);
		
		//-------------------------------------------------------------------------------

		//Tüm ilanlarý bulduk
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

                               //EDUCATÝON ÝLE ARAMA YAPTIK\\
		                     //-------------------------------\\
		
		//Tüm educationlarý bulduk
		
		List<Education> educations=educationService.findEducations();
		
		for (Education education : educations) {
			System.out.println(education);
		}
//		
		//-------------------------------------------------------------------------------

		//EducationId ile arama yaptýk
		
//		Education education=educationService.findById(16);
//		System.out.println(education);
		
		
		//-------------------------------------------------------------------------------

		
		//EducatinId ile arama yaparak hem education hemde o educationa baglý ilan listelerini getirdik
		
//		Education education=educationService.findWithAdvertisement(17);
//		System.out.println(education);
		
		//-------------------------------------------------------------------------------

		
	}
	
	
	
	
	
	
}
