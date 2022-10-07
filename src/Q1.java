// CS 2210B
// Assignment 2
// Question 1
// Name: Ali Mohamed
// Western ID: 251192600

public class Q1 {
	
	public void printInput(int d, int m, int n, int[] stops) {
		System.out.println("Input:");
		System.out.println();
		
		System.out.printf(">> %d\n",d);
		System.out.printf(">> %d\n",m);
		System.out.printf(">> %d\n",n);
		
		StringBuilder builder = new StringBuilder();
		for (int value : stops) {
		    builder.append(value);
		    builder.append(" ");
		}
		String stopString = builder.toString();
		System.out.printf(">> %s\n",stopString);
		
		System.out.println();
	}
	
	public void solution(int d, int m, int n, int[] stops) {
		int currFuel = 0;
		int reFuel = 0;
		int maxDistance = m;
		
		for(int i = 0; maxDistance < d; i++) {
			reFuel = i;
			
			if (reFuel >= n){
				System.out.println("Maximum distance travelled.");
	        }
			else if(stops[currFuel] >= maxDistance) {
				System.out.println("Maximum distance travelled.");
			}
			
			while(currFuel < (n - 1)) {
				if((stops[reFuel] + 1) <= maxDistance) {
					reFuel++;
					currFuel++;
					maxDistance = stops[reFuel] + m;
					currFuel++;
				}
			}
			
			System.out.println("Output:");
			System.out.println();
			System.out.printf(">> %d\n",reFuel);
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		
		Q1 testQ = new Q1();
		
		/*TEST 1*/
		
		int d = 950; //distance to city
		int m = 400; //distance per full tank
		int n = 4; //number of stops
		int stop[] = {200,375,550,750}; //distance of stops
		
		testQ.printInput(d, m, n, stop);
		testQ.solution(d, m, n, stop);
		
		/*TEST 2 - City too far from last stop*/
		
		int d2 = 1500; //distance to city
		int m2 = 500; //distance per full tank
		int n2 = 4; //number of stops
		int stop2[] = {200,450,800,900}; //distance of stops
		
		testQ.printInput(d2, m2, n2, stop2);
		testQ.solution(d2, m2, n2, stop2);
		
	}
	
}
