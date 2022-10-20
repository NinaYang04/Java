import java.util.Scanner;

public class Lab2Demo {

	public static void main(String[] args) {
		System.out.println("Enter number of citizens");
		Scanner citizens = new Scanner(System.in);
		int c = citizens.nextInt();
		int[] C = new int[c];
		System.out.printf("%9s", "ID");
		
		for (int i = 0; i < C.length; i++) {
			System.out.printf("%3d", i);
		}
		;
		System.out.println();

		int[] Contactee; 
		Contactee = new int[c];
		for (int i = 0; i < Contactee.length; i++) {
			Contactee[i] = i;
		}
		;
		for (int i = 0; i < Contactee.length - 1; i++) {
			int m = (int) (Math.random() * (Contactee.length - i) + i);
			int temp = Contactee[i];
			Contactee[i] = Contactee[m];
			Contactee[m] = temp;
		}
		;
		System.out.printf("%5s", "Contactee");
		for (int i = 0; i < C.length; i++) {
			System.out.printf("%3d", Contactee[i]);
		}
		;
		System.out.println();
		System.out.println("-----------------------");
		
		// part2
		System.out.println();
		System.out.println("Enter id of infected citizen :");       //指定一個ID為傳染源頭。
		Scanner id = new Scanner(System.in);
		int idnumber = id.nextInt();
		int enternumber = idnumber;           //紀錄傳染鏈的頭，方便後面對比使否為傳染鏈的尾。
 		System.out.println("These citizens are to br self-isolated in the following 14 days：");
 		System.out.printf("%d",idnumber);
        
        //ID與接觸者關係
 		while (Contactee[idnumber] != enternumber) {
			for (int i = 0; i < C.length; i++) {
				if (Contactee[idnumber] == i) {
					System.out.printf("%3d", i);
					idnumber = i;
				}
				;
			}
			;
			if(Contactee[idnumber] == enternumber) {       //當尾巴連到傳染鏈的頭，等於結束傳染鏈。
				break;
			};
		}
		;
    id.close();
    citizens.close();
        
	};

}
