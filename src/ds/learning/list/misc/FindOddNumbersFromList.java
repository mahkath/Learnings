package ds.learning.list.misc;

public class FindOddNumbersFromList {

	/**
	 * @param args
	 * http://www.careercup.com/question?id=16306671
	 */
	public static void main(String[] args) {
		int a[]={2,3,2,3,3,4,5,4,2,2,5,6};
		Integer XOR = null;
		for(int i=0;i<a.length;i++){
			if(XOR==null)
				XOR=a[i];
			else
				XOR^=a[i];
		}
		int position=findFirstBitWithSetBit(XOR);
		
		Integer XOR0=null, XOR1=null;
		for(int i=0;i<a.length;i++){
			if(getBitAtPosition(a[i], position)==0){
				if(XOR0==null)
					XOR0=a[i];
				else
					XOR0^=a[i];				
			}else{
				if(XOR1==null)
					XOR1=a[i];
				else
					XOR1^=a[i];						
			}				
		}		
		
		System.out.println(XOR0);
		System.out.println(XOR1);
	}
	
	public static int getBitAtPosition(int x, int position){
		return (x>>position)&1;
	}
	
	public static int findFirstBitWithSetBit(int x){
		int position=0;
		while((x&1)!=1){
			position++;
			x=x>>1;			
		}
		return position;
	}

}
