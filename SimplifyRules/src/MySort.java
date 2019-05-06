import java.util.Comparator;
import java.util.List;

public class MySort implements Comparator<List<Integer>> {

	public int compare(List<Integer> a, List<Integer> b) {
		
		return a.get(0).compareTo(b.get(0)); 
	    
	}	    
}
