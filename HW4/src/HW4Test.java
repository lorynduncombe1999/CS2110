import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class HW4Test {
	//delcare variables 
	Song song1;
	Song song2;
	Song song3;
	Song song4;
	PlayList playList1;
	PlayList playList2;
	File file1;
	File file2;
	Scanner name1;
	Scanner name2;
	PlayList answer;
	Song song5;
	Song song6;
	
	@Before 
	public void setUp() {
		song1 = new Song ( "WESLEE",  "Bathwater",  3,  18);
		song2 = new Song ("Wet", "Latley", 3, 52);
		song3 = new Song ( "Fleewood Mac", "Dreams",4,18);
		song4 = new Song ("Kim Petras", "Hills", 4,0);
		playList1 = new PlayList("Chill");
		playList2 = new PlayList("Fun");
		file1 = new File ("Loryn's Library");
		file2 = new File ("Trey's Library");
		name1 =  new Scanner ("Loryn's Scanner");
		name2 = new Scanner ("Trey's Scanner");
		answer = new PlayList ("answer");
		song5 = new Song("Abba","Dancing Queen",4,13);
		song6 = new Song("Artie Jesperson and his Marching Polka Funk Ensemble","Call Me Maybe",1,135);
		
		
		
	}
	
	//for song class
	@Test
	public void testEquals() {
		assertFalse(song1.equals(song2));
		assertFalse(song2.equals(song3));
		
	}
	
	@Test
	public void testCompareTo() {
		assertEquals(0,song1.compareTo(song1));
		assertEquals(1,song1.compareTo(song2));
	}
	
	@Test 
	public void testGetPlayTimeSeconds() {
		assertEquals(198,song1.getPlayTimeSeconds());
		assertEquals(232,song2.getPlayTimeSeconds());
	}
	
	@Test
	public void testNumberOfSongs() {
		assertFalse(song1.numberOfSongs()==2);
		assertEquals(1,song2.numberOfSongs());
	}

//-----------------------------------------------

//methods for Playlist
	@Test 
	public void testGetPlayTimeSeconds1() {
		assertEquals(258,song3.getPlayTimeSeconds());
		assertEquals(240,song4.getPlayTimeSeconds());
	}
	
	@Test 
	public void testNumberofSongs() {
		playList1.addSong(song1);
		playList1.addSong(song2);
		assertEquals(2,playList1.numberOfSongs());
		
		playList2.addSong(song3);
		assertEquals(1,playList2.numberOfSongs());
	}

	@Test
	public void testLoadSongs() {
		playList1.loadSongs("songFile");
		answer.addSong(song5);
		answer.addSong(song6);
		assertEquals(answer.getPlayableList(),playList1.getPlayableList());
		
	}
	
	@Test 
	public void testAddSong() {
		playList1.addSong(song1);
		assertTrue(playList1.addSong(song1) == true);
		playList1.addSong(song2);
		assertTrue(playList1.addSong(song2)==true);
	}
	
	@Test 
	public void testClear() {
		playList1.addSong(song1);
		assertTrue(playList1.clear());
		assertFalse(playList2.clear());
	}
	@Test 
	public void testRemovePlayable() {
		playList1.addSong(song1);
		playList1.addSong(song2);
		playList2.addSong(song1);
		playList2.addSong(song2);
		playList2.addSong(song3);
		playList2.removePlayable(2);
		answer.addSong(song4);
		answer.addSong(song1);
		answer.addSong(song2);
		assertEquals(playList1.toString(),(playList2.toString()));
		answer.removePlayable(0);
		assertEquals(playList1.toString(),answer.toString());	
		
	}
	
	@Test 
	public void testRemovePlayable1() {
		playList1.addSong(song1);
		playList1.addSong(song2);
		playList2.addSong(song3);
		playList2.addSong(song4);
		assertEquals(song2,playList1.removePlayable(song2));
		assertEquals(song3,playList2.removePlayable(song3));
		}
	
	
	@Test 
	public void testAddPlaylist() {
		playList1.addPlayList(playList2);
		assertFalse(playList1.addPlayList(playList2));
		assertTrue(playList2.addPlayList(playList1));
	}

	@Test
	public void testSortByTime() {
		playList1.addSong(song2);
		playList1.addSong(song1);
		playList1.addSong(song3);
		playList2.addSong(song1);
		playList2.addSong(song2);
		playList2.addSong(song3);
		answer.addSong(song3);
		answer.addSong(song2);
		answer.addSong(song1);
		
		playList1.sortByTime();
		answer.sortByTime();
		assertEquals(playList1.toString(),playList2.toString());
		assertEquals(answer.toString(),playList2.toString());
		
	}
	
	public void testSortByName() {
		playList1.addSong(song3);
		playList1.addSong(song1);
		playList1.addSong(song2);
		playList2.addSong(song1);
		playList2.addSong(song2);
		playList2.addSong(song3);
		answer.addSong(song3);
		answer.addSong(song2);
		answer.addSong(song1);
		playList2.sortByName();
		answer.sortByName();
		assertEquals(playList2.toString(),playList1.toString());
		assertEquals(answer.toString(),playList1.toString());
		
		
	}
	

}
