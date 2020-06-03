import java.lang.*;
import java.util.Scanner;
import java.io.IOException;

public class Binary {

	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(System.in);
		
		int[] array_of_ints = new int[args.length];
		
		for (int e = 0; e < array_of_ints.length; e++) {
        	int a = Integer.parseInt(args[e]);			
        	array_of_ints[e] = a;
		}
		sort_int(array_of_ints);	
		for (int i = 0; i < array_of_ints.length; i++) {
			System.out.println(array_of_ints[i]);
		}
		System.out.println("put the number you want searched");
		int index = search(array_of_ints, scan.nextInt());
		if (index != -1) {
			System.out.println("yes it is at position " + index);
		} else {
			System.out.println("not found");
		}
		scan.close();
	}
	
	static void sort_int(int[] array_of_ints) {
		int temp_store;
		for (int i = 0; i < array_of_ints.length-1; i++) {
	        for (int z = 0; z < array_of_ints.length-i-1; z++) {
	        	if (array_of_ints[z] > array_of_ints[z+1]) {
	        		temp_store = array_of_ints[z];
	    	        array_of_ints[z] = array_of_ints[z + 1];
	    	        array_of_ints[z + 1] = temp_store;
	    	    }
	        }
	    }		
	}
	
	static int search(int[] array_of_ints, int target) {
		int length_store = (array_of_ints.length)/2;
		int target_index = -1;
		int tem_store;
		while (target_index == -1) {
			if (array_of_ints[length_store] == target) {
				target_index = length_store;    
			} else {
				if (array_of_ints[length_store] < target) {
					tem_store = length_store;
					length_store = tem_store + tem_store/2;
				} else {
					if (array_of_ints[length_store] > target) {
						tem_store = length_store;
						length_store = tem_store;
					}
				}
			}	
		}
		return target_index;
	}
}
