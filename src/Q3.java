// CS 2210B
// Assignment 2
// Question 3
// Name: Ali Mohamed
// Western ID: 251192600

public class Q3 {
	
	public int minCoin(int[] coinsGiven, int value) {
		
		//Base Case
		if(value == 0) {
			return 0;
		}
		
		//Recursive Case
	       int result1 = Integer.MAX_VALUE;
	       for (int i=0; i < coinsGiven.length; i++){
	         if (coinsGiven[i] <= value){
	             int result2 = minCoin(coinsGiven, value-coinsGiven[i]);
	             if (result2 != Integer.MAX_VALUE && result2 + 1 < result1) {
	            	 result1 = result2 + 1;
	             } 
	         }
	       }
	       return result1;
		
		
	}
	
	public static void main(String[] args) {
		
		Q3 myObj = new Q3();
		
		/* TEST 1 - Should be 2 coins*/
		int[] coins = {25, 10, 5};
		int v = 30;
		int minimumCoins = myObj.minCoin(coins,v);
		
		if(minimumCoins == Integer.MAX_VALUE || minimumCoins < 0) {
			System.out.println(-1);
		}
		else {
			System.out.printf("Minimum %d coins required\n", minimumCoins);
		}
		
		/* TEST 2 - Should be impossible*/
		int[] coins2 = {25, 10, 5};
		int v2 = 31;
		int minimumCoins2 = myObj.minCoin(coins2,v2);
		
		if(minimumCoins2 == Integer.MAX_VALUE || minimumCoins2 < 0) {
			System.out.println(-1);
		}
		else {
			System.out.printf("Minimum %d coins required\n", minimumCoins2);
		}
		
	}

}
