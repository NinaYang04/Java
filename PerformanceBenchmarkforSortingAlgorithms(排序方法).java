import java.util.Arrays;

public class PerformanceBenchmarkforSortingAlgorithms {

	public static int numOfRepetitions = 10;
	public static String[] algorithmTitles = {"Bubble sort", "Selection sort", "Insertion sort", "Arrays.sort"};
	public static int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000};
	public static double[][] records = new double[algorithmTitles.length][sizes.length];
	
	public static void main(String[] args) {
		
//		debug();
		
		for (int i = algorithmTitles.length - 1; i >= 0; i--) {
			simulate(i);
		}
		showStat();

	}

	public static void debug() {
		
		int[] A =arrayGen(5);
		display(A); 
		
		double t0 = System.nanoTime() / 1e6;
		insertionSort(A); //Bubble sort/Selection sort/Insertion sort/Arrays.sort
		double t1 = System.nanoTime() / 1e6;
		
		display(A);
		System.out.println(t1 - t0);
	}
	
	public static void simulate(int algoNo) {
		
		System.out.printf("Simulating %s: ", algorithmTitles);
		
		
		for (int i = 0; i < sizes.length; i++) {
			
			for (int j = 1; j <= numOfRepetitions; j++) {
				
				int[] A = arrayGen(sizes[i]);
				double t0 = System.nanoTime() / 1e6;
				
				switch (algoNo) {
					case 0:
						bubbleSort(A);
					case 1:
						selectionSort(A);
					case 2:
						insertionSort(A);
					case 3:
						Arrays.sort(A);
					
				}
				
				double t1 = System.nanoTime() / 1e6;
				records[algoNo][i] += t1 - t0;
			}
			
			System.out.printf(".");
			records[algoNo][i] /= numOfRepetitions;
		}
		System.out.println("done.");
	}
	
	public static void showStat() {
		
		System.out.println("Benchmark (time unit: ms)");
		System.out.printf("%7s" , "Size");
		for (String title: algorithmTitles)
			System.out.printf("%17s" , title);
		System.out.println();
		
		for(int i = 0 ; i < sizes.length; i++) {
			System.out.printf("%7d" , sizes[i]);
			for (int j = 0; j < records.length; j++)
				System.out.printf("%17.3f" , records[j][i]);
			System.out.println();
		}
	}
	
	public static int[] arrayGen(int N) {
		
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++)
			A[i] = (int) (Math.random() * N * 10);
		return A;
	}
	
	public static void display(int[] A) {
		
		for (int item: A)
			System.out.printf("%d", item);
		System.out.println();
	}
	
	public static void bubbleSort(int[] A) {
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length - i - 1; j++) {
				if (A[j] > A[j + i]) {
					int tmp = A[j];
					A[j] = A[j + i];
					A[j + i] = tmp;
				}
			}
		}
	}
	
	public static void selectionSort(int[] A) {
		for (int i = 0; i < A.length; i++) {
			int idx = i ;
			for (int j = i; j < A.length; j ++) {
				if (A[j] < A [idx]) {
					idx = j;
				}
			}
			
			int tmp = A[i];
			A[i] = A[idx];
			A[idx] = tmp;
		}
	}
	public static void insertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			
			int tmp = A[i];
			int j = i - 1;
			for (;j > 0; j--) {
				
				if (A[j] > tmp) {
					A[j+1] = A[j];
				} else {
					break;
				}
			}
			A[j + 1] = tmp;
			
//			System.out.println(i);
//			display(A);
		}
	}

}
