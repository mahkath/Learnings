
public class MatrixMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int first[][] = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int second[][] = new int[][]{{3,2},{5,4},{8,9}};
		
		int third[][] = new int[first.length][second[0].length];
		
		if(first[0].length != second.length) {
			System.out.println("Cannot Multiply");
			return;
		}
		
		for(int i=0; i< first.length; i++) {
			for(int j=0; j < second[0].length; j++) {
				for(int k=0; k< first[0].length; k++) {
					System.out.println(i + " " + j + " --> " + first[i][k] +" " + second[k][j]);
					third[i][j] += first[i][k] * second[k][j];
				}
			}
		}
		
		
	}

}
