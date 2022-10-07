// CS 2210B
// Assignment 2
// Question 2
// Name: Ali Mohamed
// Western ID: 251192600

import java.util.*;

public class Q2 {
	
	private ArrayList<client>[] hashtable;
	
	public Q2() {
        this.hashtable = new ArrayList[32];
    }
	
	public String get(int k) {
		int hashIndex = hash(k);
		
		//Check if the index is empty.
		if (this.hashtable[hashIndex] == null) {
			return null;
		}
		
		//Get reference for chain
		ArrayList<client> idsAtIndex = this.hashtable[hashIndex];
		
		//Perform a linear search in the list for client
		for (int i = 0; i < idsAtIndex.size(); i++) {
			if (idsAtIndex.get(i).getID() == k) {
				return idsAtIndex.get(i).getName();
			}
		}
		return null;
	}
	
	public void put(int k, String n) {
		int hashIndex = hash(k);
		client pClient = new client(k,n);
		
		//Check if the index is empty.
		if (this.hashtable[hashIndex] == null) {
			this.hashtable[hashIndex] = new ArrayList<client>();
			this.hashtable[hashIndex].add(pClient);
			return;
		}
		
		//Get reference for chain
		ArrayList<client> idsAtIndex = this.hashtable[hashIndex];
		
		//Check if list already exists and get index
		boolean exists = false;
		int index = 0;
		while (!exists) {
			if(idsAtIndex.get(index).getID() == k) {
				exists = true;
			}
			else {
				index++;
			}
		}
		
		//If the list exists, check for key. If the key exists, update the name
		if(!exists) {
			idsAtIndex.add(pClient);
		}
		else{
			idsAtIndex.get(index).setName(n);
		}
	}
	
	public String remove(int k) {
		int hashIndex = hash(k);
		
		//Get reference for list from hash table
		if (this.hashtable[hashIndex] == null) {
			this.hashtable[hashIndex] = new ArrayList<client>();
		}
		ArrayList<client> idsAtIndex = this.hashtable[hashIndex];
		
		//Check if list is empty
		if (idsAtIndex.size() == 0) {
			return null;
		}
		
		//Get reference for index from hash table
		boolean exists = false;
		int index = 0;
		while (!exists) {
			if(idsAtIndex.get(index).getID() == k) {
				exists = true;
			}
			else {
				index++;
			}
		}
		
		//If the list exists, check for key. If the key exists, update the name
		if(!exists) {
			return null;
		}
		else {
			client rClient = idsAtIndex.get(index);
			idsAtIndex.remove(rClient);
			return rClient.getName();
		}
		
		
	}
	
	//Hash Function
	private int hash(int k){
		int hash = 7;
		int modifier = this.hashtable.length;
		hash = (k * hash) % modifier; 
		return hash;
	}
	
	public String toString(){
		String result = "";
	    for(int i = 0; i < hashtable.length; i++){
	    	for(int j = 0; j < hashtable[i].size(); j++){
	    		result += hashtable[i].get(j).getName();
	        }
	    	result += "\n";
	    }
	    return result;
	}
	
	
	public static void main(String[] args) {
		
		Q2 bankData = new Q2();
		
		//Initial Data
		bankData.put(27042003, "Ali"); //5
		bankData.put(29092005,"John"); //3
		bankData.put(21032008,"Jane"); //24
		bankData.put(26091983,"Rose"); //9
		bankData.put(11031971,"Max"); //21
		bankData.put(13456987,"Mohamed"); //29
		bankData.put(17985419,"Jack"); //13
		bankData.put(21724391,"Jack"); //23
		
		/*TEST 1 - Search Operation*/
		boolean b1 = false;
		boolean b2 = false;
		
		String s1 = bankData.get(27042003); //Existing Item
		String s2 = bankData.get(12345678); //Non-Existing Item
		
		b1 = s1.equals("Ali");
		b2 = s2 == null;
		
		if(b1 && b2) {
			System.out.println("TEST 1 Successful");
		}
		else {
			System.out.println("TEST 1 Unsuccessful");
		}
		
		/*TEST 2 - Insertion Operation */
		b1 = false;
		b2 = false;
		
		bankData.put(11092001,"Nine"); //Non-Existing Item
		bankData.put(26091983,"Farah"); //Existing Item with diffrent name
		
		String s3 = bankData.get(11092001);
		String s4 = bankData.get(26091983);
		
		b1 = s3.equals("Nine");
		b2 = s4.equals("Farah");
		
		if(b1 && b2) {
			System.out.println("TEST 2 Successful");
		}
		else {
			System.out.println("TEST 2 Unsuccessful");
		}
		
		/*TEST 3 - Deletion Operation */
		b1 = false;
		b2 = false;
		
		String s5 = bankData.remove(11092001); //Existing Item
		String s6 = bankData.remove(12345678); //Non-Existing Item
		
		b1 = s5.equals("Nine");
		b2 = s6 == null;
		
		if(b1 && b2) {
			System.out.println("TEST 3 Successful");
		}
		else {
			System.out.println("TEST 3 Unsuccessful");
		}
		
	}
	
}
