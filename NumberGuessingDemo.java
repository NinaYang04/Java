import java.util.Scanner;
import java.awt.font.NumericShaper.Range;
import java.util.Random;

public class NumberGuessingDemo {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		Random ran = new Random();
		int ans = ran.nextInt(100);	
		System.out.println("(0,100)");
		int min = 0, max = 100;
		int q = input.nextInt();
		
		while (true) {
			
			
				if (q == ans) {
					System.out.println("Correct.");
		
				} else if (q > ans) {
					max = q;
					System.out.println(min + " < ? <" + q);
					
					
				} else if (q < ans) {
					min = q;
					System.out.println(q + " < ? <" + max);
					
					
				} else if (q > max || q < min) {	
					System.out.println("Out of range. Try again?");
					
				}
			q = input.nextInt();
			
		}

	}
}