//Loryn Duncombe(ld3dx) Homework 6

import turtle.Turtle;
public class Recursion {


	//The purpose of this method is to take in a string and return the reverse of it 
	public static  String reverseString(String s) {
		//base case : if there isn't a string or it the length is just a single character
		if(( null == s || s.length() <=1)) {
			return s;
		}
		return ((s.charAt(s.length()-1)+(reverseString(s.substring(1, s.length()-1)) + s.charAt(0))));

	}



	/*The purpose of this method is to solve the Ackermann function 
		//The TA explained to me that This is one gigantic recursive function and you essentially 
		just have to turn the pseudocode into actual code.*/
	public static long Ackermann(long m,long n) {
		if (m == 0) {
			//base case 
			return n+1;
		}
		if (m>0 && n==0) {
			return Ackermann(m-1,1);
		}
		if (m>0 && n>0) {
			return Ackermann(m-1,Ackermann(m,n-1));
		}
		return 0;

	}

	//This method will return the total number of handshakes
	public static int handshakes(int n) {

		//base case: if there is only one person no handshakes will be made 
		if (n<=1) {
			return 0;
		}
		else if (n==2) { //two people means 1 handshake
			return 1;
		}
		else {
			//n-1 gets it closer to the base case. Calling handskakes on itself subtracting one than add it
			return (n-1) + handshakes(n-1);
		}
	
		
	}
	private static void snowflake(Turtle t, int n, double size) {
		if (n==0) {
		t.forward(size);
		}
		else {
			snowflake(t,n-1,size);
			t.left(60);
			snowflake(t,n-1,size);
			t.right(120);
			snowflake(t, n-1, size);
			t.left(60);
			snowflake(t,n-1,size);
		}
	}
		
		
	



	//main method testing 
	public static void main (String[] args) {

		//reverse string method testing
		System.out.println(reverseString("abc"));
		System.out.println(reverseString("LorynDuncombe"));
		System.out.println(reverseString("MondayTuesdayWednesday"));

		//Ackermann method testing 
		System.out.println(Ackermann(0,1));
		System.out.print(Ackermann(1,2));
		System.out.print(Ackermann(0,2));

		//handshakes method testing
		System.out.print(handshakes(2));
		System.out.print(handshakes(4));
		System.out.print(handshakes(6));

	}

}


