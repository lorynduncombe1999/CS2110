//dont forget to add all of the extra stuff like computing id etc 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class PlayList implements Playable{
	private String name; // contains the name of the playlist

	private ArrayList<Playable> playableList; // ArrayList of Playable elements that make up the playlist

	
	//Getters and Setters Auto-genorated 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}

	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}

	
	/*Add a toString() method that returns the name of the playlist followed by its contents 
	(by calling toString() on each item it contains). 
	You should only have one name/title per line */   
	
	public String toString() {
		String method = "";
		for (Playable elements :playableList) {
			return "Title: " + elements.getName() + "Contents: " + playableList;
		}
		return "";
		}


	
	// empty playlist named "Untitled"
	public PlayList() {
	this.name = "Untitled";
	playableList = new ArrayList <Playable>();
		
	}

	public PlayList(String newName) { 
		playableList = new ArrayList <Playable>();
		this.name = newName;
	 
	}
	
//Methods 
	//must have because implements Playable

	// returns the number of seconds in the entire PlayList 
	public int getPlayTimeSeconds() {
		int totalSongTime = 0;
		for (Playable elements: playableList) {
			totalSongTime += elements.getPlayTimeSeconds();
		}
		return totalSongTime;
	}
	// For Song: returns 1.  For PlayList returns the number of songs in the playlist and all playlists contained within.
	public int numberOfSongs() {
		int counter = 0;
		for (Playable element:playableList) {
			counter += 1;
		}
		return counter;
	}
	
	
	public boolean loadSongs(String fileName) {
		File file = new File (fileName);
		try {
			Scanner name = new Scanner (file);
			while (name.hasNext()) {
				
				//trim white space of title
				String title = name.nextLine().trim();
				
				
				//trim white space of artist
				String artist = name.nextLine().trim();
			
				
				//Splits on the semi-colon
				String[] time = name.nextLine().trim().split(":");
				
				
				
				int minutes = Integer.parseInt(time[0]);
				
				int  seconds = Integer.parseInt(time[1]);
				
				int totalMiuntes = (seconds - (seconds % 60)) + minutes;
				int totalSeconds = seconds % 60;
				
				name.nextLine();

				 Song song = new Song(title, artist, totalMiuntes, totalSeconds);
				 playableList.add(song);
				 
				 
					 
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
			return false;
		}
			return true;
		}
			
		

	
	// removes all playable elements in the playlist
	public boolean clear() {
	if (playableList.isEmpty() == true) { //this means there isn't anything in the list (not modified, returns false)
		return false; 
	}
	
	if (playableList.isEmpty()== false) {//this means there are elements in the list (needs to be modified)
		playableList.clear();
		return true;
	}
	else 
		return false;
		
	}
	
	// adds Song s to the end of the play list
	public boolean addSong(Song s) {
		playableList.add((Playable) s);
		return true;
	}

	// removes Playable element at index from the list and returns it
	public Playable removePlayable(int index) {
		return this.getPlayableList().remove(index);
		
	}

	//public Playable sortByName() {
		
	//}
	
	public void sortByTime() {
		 Collections.sort(this.getPlayableList(), new sortByTime());	
	}
	
	public void sortByName() {
		Collections.sort(this.getPlayableList(), new sortByName());
	}

//removes every occurrence of Playable p from the list and returns p ? what is the difference between this and previous method?	
public Playable removePlayable(Playable p) {
	for (Playable elements: playableList) {
	playableList.remove(p);
	}
	return p;
}

//returns the Playable element at the appropriate index
	public Playable getPlayable(int index) {
		return getPlayable(index);
	}
	/*
	 //adds the PlayList that is being passed to the end of the playableList and returns 
	  * true unless the playableList already contains a playlist with the same name, 
	  * in this case, do not add the playlist and return false.  */
	public boolean addPlayList(PlayList p) {
		if (playableList.contains(p)) {
			return false;
		}
		else 
			playableList.add(p);
		return true;
	}
	

	// plays the playlist by calling play() on each item in the playlist in order
	public void play() {
		for (Playable element: playableList) {
			return;
			
		}
	}
		
	}
	
	
	 

	

	




