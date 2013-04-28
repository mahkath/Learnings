import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Coins {

	public static void main(String args[]) {
		Integer arrCoinTypes[] = {25,10,5,1};
		List<Integer> coinList = Arrays.asList(arrCoinTypes);
		
		Coins c = new Coins();
		c.getChange(coinList, 99);
	}
	
	public synchronized void getChange(List<Integer> arrCoinTypes, int amount) {
		
		LinkedList<String> stack = new LinkedList<String>();
		
		for(int i=0; i<arrCoinTypes.size(); i++) {
			coinsRecurr(amount,arrCoinTypes.subList(i,arrCoinTypes.size()),stack);	
		}
		
	}
	
	
	private void coinsRecurr(int coinValue, List<Integer> coinList, LinkedList<String> stack) {
		if(coinList.size() <=0) {
			return;
		}
		
		int coin = (int)coinList.get(0);
		int quotient = coinValue/coin;
		
		if(coinList.size() <=1) {
			stack.push( coin +"*"+ coinValue/coin);
			System.out.println(stack.toString());
			stack.pop();
			return;
		}
		for(int i=1; i<=quotient; i++) {
			stack.push(coin+"*"+i);
			coinsRecurr(coinValue-coin*i, coinList.subList(1, coinList.size()), stack);
			stack.pop();
		}
	}

}
