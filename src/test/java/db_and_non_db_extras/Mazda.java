package db_and_non_db_extras;

import org.junit.Test;

import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;

public class Mazda  {
	
	@Test
	public void setUp(){
		Driver.getInstance().get("file:///Users/esenali/Downloads/2016TurboTaxExtension.pdf");
		Page.sleep(3000);
		System.out.println(Driver.getInstance().getCurrentUrl());
		System.out.println("end");
	}
	
	
	
	
	
	

//	public static void main(String[] args) {
//		String a = "car";
//		String b = "car";
//		
//		if(a == b){
//			System.out.println("true");
//		}
//		else{
//			System.out.println("false");
//		}
//	}
	//@Override
	//protected void b(){
		
	
}
