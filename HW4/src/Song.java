//I have a question in the song constructor 

public class Song implements Comparable<Song>, Playable {

	// fields
	private String artist; // the artist performing the song

	private String title; // the title of the song

	private int minutes; // number of min in length

	private int seconds; // number of seconds of the song (always less than 60)

	// Getters and Setters Auto-generated
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	// constructors -need to initialize all of them
	public Song(String artist, String title) {
		this.artist = artist;
		this.title = title;

	}

	public Song(String artist, String title, int minutes, int seconds) {
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public Song(Song s) {
		this.title = title;
	}

	// two songs are equal if all four fields are equal
	public boolean equals(Object o) {
		if (o instanceof Song) { // checks to see if o is and instance of song
			Song c = (Song) o;// casting o
			if (artist == c.getArtist()
					&& (title == c.getTitle() && minutes == c.getMinutes() && seconds == c.getSeconds())) {
				return true;
			}

			else {
				return false;
			}
		} else {
			return false;

		}

	}

	// converts into language digestible to humans
	public String toString() {

		return "{Song: title = " + title + " artist = " + artist + "}";

	}

	public void play() {

		System.out.printf("Playing Song: artist = %-20s title = %s\n", artist, title);

	}

	/*
	 * Make the Song class implement the interface Comparable<Song>, and make the
	 * ordering criteria as follows: Songs will be ordered by the artist in
	 * ascending order. If the artists are the same, then by title in ascending
	 * order. If both artist and title are the same, then any order is acceptable.
	 */
	public int compareTo(Song o1) {
		int num = this.getArtist().compareTo(o1.getArtist());
		if (num < 0) {
			return 1;// this puts song 1 first

		}
		if (num > 0) {
			return -1; // puts song 1 second
		}
		if (num == 0) {
			int numtwo = this.getTitle().compareTo(o1.getTitle());
			return numtwo;
		}

		else
			return 0;

	}

	// Need the following 3 methods because you are implementing Playable
	public String getName() {
		return title;
	}

	public int getPlayTimeSeconds() {
		int convertedSeconds;
		convertedSeconds = minutes * 60;
		return convertedSeconds + seconds;
	}

	public int numberOfSongs() {
		return 1;
	}

}
