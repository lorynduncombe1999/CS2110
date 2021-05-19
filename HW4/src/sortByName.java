import java.util.Comparator;

public class sortByName implements Comparator<Playable>{
	
	//This method will sort the Playableitems by the value returned by getName() in ascending order.
	@Override
	public int compare(Playable o1, Playable o2) {
		String name1 = o1.getName();
		String name2 = o2.getName();
		return name1.compareTo(name2);
	}
}
