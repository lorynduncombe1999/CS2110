import java.util.Comparator;
public class sortByTime implements Comparator<Playable>
{
	/*Also add a method sortByTime() in PlayList that sorts by the Song or PlayList's 
	total time in seconds, in ascending order (shortest first). It also must use a comparator 
	object to achieve this. That object will use one of the methods in the Playable interface 
	to get the time for each object. */
	
	public int compare (Playable o1, Playable o2) {
		int length1 = o1.getPlayTimeSeconds();
		int length2 = o2.getPlayTimeSeconds();
		
		if (length1 > length2) {
			return 1;
		}
		if(length1 < length2) {
			return -1;
		}
		else 
			return 0;
	}



}
