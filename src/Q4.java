// CS 2210B
// Assignment 2
// Question 4
// Name: Ali Mohamed
// Western ID: 251192600

public class Q4 {
		
	public int numWays(int[] coinsGiven, int value)  {
        
		//Initialize table
		int[] table = new int[value+1];
        for(int i = 0; i < table.length; i++) {
        	table[i] = 0;
        }
 
        // Base case
        table[0] = 1;
 
        for (int i = 0; i < coinsGiven.length; i++)
            for (int j = coinsGiven[i]; j <= value; j++)
                table[j] += table[j - coinsGiven[i]];
 
        return table[value];
    }

	public static void main(String[] args) {

		Q4 myObj = new Q4();
		
		/*TEST 1 - Should be 6 Solutions*/
		 int arr[] = {1, 2, 3};
	     int n = 6;
	     int nW = myObj.numWays(arr, n) - 1;
	     System.out.printf("There are %d solutions.\n",nW);
		
		/*TEST 2 - Should be 0 Solutions*/
	     int arr2[] = {7};
	     int n2 = 2;
	     int nW2 = myObj.numWays(arr2, n2);
	     System.out.printf("There are %d solutions.\n",nW2);

	}

}
