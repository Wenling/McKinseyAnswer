import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class SortArrayByFreq {
	
	public static List<Integer> sortIntegerByFrequency(int[] array) {
		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
		Map<Integer, List<Integer>> frequencyCounter = new TreeMap<Integer, List<Integer>>(new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				if(o1 > o2) return -1;
				else if(o1 < o2) return 1;
				return 0;
			}
		});
		
		for(int i = 0; i < array.length; ++ i) {
			if(counter.get(array[i]) != null) counter.put(array[i], counter.get(array[i]) + 1);
			else counter.put(array[i], 1);
		}
		for(Iterator<Integer> iter = counter.keySet().iterator(); iter.hasNext();) {
			Integer number = iter.next();
			Integer freq = counter.get(number);
			List<Integer> temp = frequencyCounter.get(freq);
			if(temp != null) {
				temp.add(number);
			} else {
				temp = new ArrayList<Integer>();
				temp.add(number);
			}
			frequencyCounter.put(freq, temp);
		}
		List<Integer> result = new ArrayList<Integer>();
		for(Iterator<Integer> iter = frequencyCounter.keySet().iterator(); iter.hasNext();) {
			Integer freq = iter.next();
			List<Integer> numbers = frequencyCounter.get(freq);
			for(int i = 0; i < numbers.size(); i ++) {
				for(int j = 0; j < freq; j ++) {
					result.add(numbers.get(i));
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = {23,654,453,12,1,34,1, 23, 23, 453};
		List<Integer> list = sortIntegerByFrequency(array);
		for(Integer in : list) {
			System.out.print(in + " ");
		}
	}

}
