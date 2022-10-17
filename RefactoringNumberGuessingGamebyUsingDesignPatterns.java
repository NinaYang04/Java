import java.util.Random;
import java.util.Scanner;

public class RefactoringNumberGuessingGamebyUsingDesignPatterns {

	public static void main(String[] args) {
		
		new Game(new BinarySearchAI()).run();

	}

}

class Player{
	
	public int next(int low, int high) {
		return 0; //for now
	}
}

class HumanPlayer extends Player{
	
	private Scanner input = new Scanner(System.in);
	HumanPlayer(){}
	
	@Override
	public int next(int low, int high) {
		return input.nextInt();
	}
}

class NaiveAI extends Player{
	
	@Override
	public int next(int low, int high) {
		return (int) (Math.random() * (high - low) + low);
	}
}

class BinarySearchAI extends Player{
	
	@Override
	public int next(int low, int high) {
		return (high + low) / 2;
	}
}

class Game {
	
	private int low = 0, high = 99, ans;
	private Player player;
	
	Game(Player player){
		ans = (int) (Math.random() * 100);
		this.player = player;
	}
	
	public void run() {
		
		while (true) {
			
			/*//HumanPlayer
			System.out.printf("(%d, %d)?\n", low, high);
			int q = player.next(low, high);*/
			
			//NaiveAI
			System.out.printf("(%d, %d)?", low, high);
			int q = player.next(low, high);
			System.out.printf("%d\n", q);
			
			if(q > high || q < low) {	
				System.out.println("Out of range. Try again?");
				continue;
			}
			
			if (q == ans) {
				System.out.println("Bingo.");
				break;
				
			} else if (q > ans) {
				System.out.println("Too large.");
				high = q;				
				
			} else {
				System.out.println("Too small.");
				low = q;				
				
			} 
			
//			if (low == high) {
//				System.out.println("Game Over.");
//				break;
//			}
			
		}
	}
	
}