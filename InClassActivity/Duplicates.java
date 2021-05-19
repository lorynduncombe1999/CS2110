import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Duplicates {
	
	public static ArrayList removeDups(ArrayList<String> inputList) {
		ArrayList<String> SecondArrayList = inputList;
				for (int i = 0; i< inputList.size(); i++) {
					for (int j = i+1; j< inputList.size(); j++) {
					if (inputList.get(i).equals(SecondArrayList.get(j))) 
						SecondArrayList.remove(j);
		
					}
				}
		return SecondArrayList;		
	}	

	public static void main(String[] args) {
		ArrayList<String> inputList = new ArrayList<String>();
		//comment out above and uncomment below if you want to try the array bonus
		//String[] inputList;

		Scanner key = new Scanner(System.in);
		System.out.println("How many Strings would you like to enter?");
		int num = key.nextInt();
		key.nextLine();

		//uncomment below if you want to try the array bonus
		//inputList = new String[num];

		String str;
		for(int i = 0; i < num; i++) {
			System.out.println("What String would you like to add?");
			str = key.nextLine();
			inputList.add(str.toLowerCase());
			//comment out above and uncomment below if you want to try the array bonus
			//inputList[i] = str;
		}
			System.out.println(inputList);
			System.out.println(removeDups(inputList));
			




						
			}
			
	{
		
		
		
		//comment out above and uncomment below if you want to try the array bonus
		//System.out.println(Arrays.toString(inputList));
		//System.out.println(Arrays.toString(removeDups(inputList)));
		
	}

}
