package ArrayAndString;

/**
 * Given an image represented by an NxN matrix, 
 * where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees 
Can you do this in place?
 * @author Chi
 *
 */
public class Rotate {
	
	private static void rotate(int[][] matrix, int n){
		for(int layer = 0; layer < n/2; layer++){
			int first = layer;
			int last = n-1-layer;
			for(int i = first; i < last; i++){
				int offset = i - first;
				int top = matrix[first][i]; 
				matrix[first][i] = matrix[last-offset][first];
				
				matrix[last-offset][first] = matrix[last][last-offset];
				
				matrix[last][last-offset] = matrix[i][last];
				
				matrix[i][last] = top;
			}
		}
	} 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		for (int[] is : array) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		rotate(array, 4);
		
		for (int[] is : array) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

}
