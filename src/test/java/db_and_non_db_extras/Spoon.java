package db_and_non_db_extras;

import java.util.Random;

import com.fourstay.utilities.Page;

public class Spoon  {
	
	public static void main(String[] args) throws InterruptedException {
	
		boolean check = true;
		int limit = 650;
		int c = 0;
		Random random = new Random();
		while(check){
			char a = (char) random.nextInt(50000);
		
			c++;
			if(c == 40 || c == 70 || c == 110 || c == 146 || c == 170 || c == 207
					|| c == 234 || c == 278 || c == 320 || c == 350 || c == 370 
					|| c == 396 || c == 423 || c == 450 || c == 476 || c == 500
					|| c == 530 || c == 556 || c == 587 || c == 600 || c == 634)
				System.out.println();
			Thread.sleep(30);
			System.out.print(a);
			if(c > limit)
				break;
		}
	}
}
