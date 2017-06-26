package db_and_non_db_extras;

import java.util.Random;


public class FunPrint  {
	
	public static void main(String[] args) throws InterruptedException {
		print(1000);
	}
	
	public static void print(int limit) throws InterruptedException{
		int c = 0;
		Random random = new Random();
		
		do{
			char a = (char) random.nextInt(50000);
			int r = random.nextInt(20) + 30;
			c++;
			if(c > r){
				System.out.println();
				c = 0;
			}
			Thread.sleep(30);
			System.err.print(a);
			limit--;
		}while(limit > 0);
	}
	
}
