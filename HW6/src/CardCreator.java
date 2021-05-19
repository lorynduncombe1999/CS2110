//Loryn Duncombe(ld3dx) Homework 6
// told to import through the java recommendation
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CardCreator {
private PrintQueue printqueue;

private String filename ;
public CardCreator (PrintQueue d, String filename) {
	printqueue = d;
	this.filename=filename;
}

public void run() {
	Scanner s = null; // new scanner sent to null 
	try {
		s = new Scanner(new FileReader(filename));
		while (s.hasNextLine()) { // goes through every file and reads it 
			Thread.activeCount();
			printqueue.enqueue(s.nextLine());
			Thread.sleep(1000);
		}
		
			 
		}catch (IOException e) { // catches exception 
			System.out.println("Could not read file");
			
	}catch(InterruptedException e){ // catches exception
		e.printStackTrace();
		
	} finally {if (s != null)
		s.close();
	printqueue.turnOff(); 
	
	
	 
	}
	
}
}
