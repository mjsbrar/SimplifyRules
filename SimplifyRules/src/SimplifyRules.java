import java.util.*;

public class SimplifyRules {
	
	public static List<Integer> inputValues() {
		
		List<Integer> inputEntry = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the start from ZipCode value: ");
		int a = sc.nextInt();
		System.out.println("Enter the end to ZipCode value: ");
		int b = sc.nextInt();
		
		inputEntry.add(a);
		inputEntry.add(b);
		
		return inputEntry;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<List<Integer>> inputData = new ArrayList<>();
		
		System.out.println("Please enter the count of ZipCode range pairs we have: ");
		
		int count = sc.nextInt();
		
		while (count > 0) {
			inputData.add(inputValues());
			count--;
		}
		
		Collections.sort(inputData, new MySort());
		
		System.out.println(simplifyRules(inputData));
		
	}

	private static List<List<Integer>> simplifyRules(List<List<Integer>> inputData) {

		int arrayIndex = 0;
		while (arrayIndex + 1 < inputData.size()) {
			List<Integer> result = compareRanges(inputData.get(arrayIndex), inputData.get(arrayIndex + 1));

			if (result != null) {
				inputData.set(arrayIndex + 1, result);
				inputData.remove(arrayIndex);

				arrayIndex += 1;
			} else {
				arrayIndex++;
			}
		}
		return inputData;
	}

	
	private static List<Integer> compareRanges(List<Integer> previous, List<Integer> current) {
		List<Integer> result = null;

		if (previous.get(0) < current.get(0) && previous.get(1) > current.get(0)) {
			result = new ArrayList<>();
			result.add(previous.get(0));
			result.add(current.get(1)); 	
		}
		return result;
	}
	
}
