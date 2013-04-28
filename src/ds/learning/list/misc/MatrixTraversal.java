package ds.learning.list.misc;

/**
 * @author amar
 * The Class MatrixTraversal.
 */
public class MatrixTraversal {

	/**
	 * Prints the elements in the outer rows and columns in the array and shrinks the array as it prints the elements 
	 * and moves to the inner rows, columns
	 *  
	 * @param array the matrix
	 */
	static StringBuffer print(int array[][]) {
		StringBuffer buffer = new StringBuffer();
		// keeps track of which direction to proceed
		int direction = 0;  
		int up = 0, down = 3, right = 3, left = 0;  // down and right are the , m, n of the mXn array
		boolean isAllElementsVisited = false;  // 

		while (!isAllElementsVisited) {  // The control comes out of the loop, once all the elements are visited ie.. when all the rows and columns are shrinked  
			if (direction == 0) {     // Move from left to right
				if (right < left) {  
					isAllElementsVisited = true;
				} else {
					for (int i = left; i <= right; i++) {
						buffer.append(array[up][i] + "-");
					}
					up++; // Shrink the array by moving to next row Eg: once all the elements of row 0 are printed increment the pointer to 1
					direction++;
				}
			} else if (direction == 1) {   // Move from up to down
				if (down < up) {    
					isAllElementsVisited = true;
				} else {
					for (int i = up; i <= down; i++) {
						buffer.append(array[i][right] + "-");
					}
					right = right - 1; // Shrink the array by pointing to inner column
					direction++;
				}
			} else if (direction == 2) {
				if (right < left) {  // Move from right to left
					isAllElementsVisited = true;
				} else {
					for (int i = right; i >= left; i--) {
						buffer.append(array[down][i] + "-");
					}
					down = down - 1; // Shrink the array, ignore the last row already visited
					direction++;
				}
			} else if (direction == 3) {
				if (down < up) {     // Move in upside direction, from bottom to top
					isAllElementsVisited = true;
				} else {
					for (int i = down; i >= up; i--) {
						buffer.append(array[i][left] + "-");
					}
					left++;          // Shrink the array, eliminate the left most column already visited 
					direction = 0;   // Set the direction back to - 'left to right', now all the elements in inner array are printed (the shrinked array) 
				}
			}
		}
		return buffer;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		int matrix[][] = {  { 1, 2, 3, 4 }, 
							{ 5, 6, 7, 8 }, 
							{ 9, 10, 11, 12 },
							{ 13, 14, 15, 16 } 
						  };
		//prints -1-2-3-4-8-12-16-15-14-13-9-5-6-7-11-10-
		System.out.println(print(matrix));
	}
}
