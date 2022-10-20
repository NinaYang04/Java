
public class FastPowerUsingRecursionDemo {
	
	public static double pow(double x, int n) {
		if (n == 0) return 1;
		
		double y = pow(x, n/2);
		y = y * y;
		
//		if (n % 2 == 1) {
//			y = y * x;
//		}
//		return y;
		
		return n % 2 == 1 ? x * y : y;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			System.out.printf("%d ^ %d = %f\n", 2, i, pow(2, i));
		}
	}

}
