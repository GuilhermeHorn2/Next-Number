package misc;

import java.util.ArrayList;

public class main_misc {
    
	
	public static void main(String[] args) {
	
	
		  next_number(109);

	 
	}
	
	private static boolean all_0(String bits){
		
		for(int i = 0;i < bits.length();i++){
			if(!bits.substring(i, i+1).equals("0")){
				return false;
			}
		}
		return true;
		
	}
	
	private static boolean all_1(String bits){
		
		for(int i = 0;i < bits.length();i++){
			if(!bits.substring(i, i+1).equals("1")){
				return false;
			}
		}
		return true;
		
	}
	
	private static int big_endian_to_dec(String n){
		
		int r = 0;
		for(int i = 0;i < n.length();i++){
			
			int bit = Integer.valueOf(n.substring(i,i+1));
			
			r += bit*(Math.pow(2, i));
			
		}
		return r;
		
	}
	
	private static void next_number(int n){
		
		String bits = Integer.toBinaryString(n);
		
		
		if(all_0(bits)) {
			//There is no number with the same number of 1s that is smaller or larger than n
			System.out.println("null");
			return;
		}
		if(all_1(bits)){
			//There is no number with the same number of 1s that is smaller than n
			System.out.println("smallest: null");
			
			//largest:
			String larg = "0"+bits;
			char[] c = larg.toCharArray();
			
			StringBuilder result_app = new StringBuilder();
			
			for(int i =c.length-1;i >= 0;i--){
				
				if(c[i] == '1' && i != 0){
					if(c[i-1] == '0'){
						result_app.append(c[i-1]);
						result_app.append(c[i]);
						i--;
						continue;
					}
					result_app.append(c[i]);
				}
				
			}
			
			String result = result_app.toString();//big endian
			
			int x = big_endian_to_dec(result);
			
			System.out.println("largest: " + x);
			return;	
		}
		else {
			
			//smallest
			
			StringBuilder small_app = new StringBuilder();
			
			char []c = bits.toCharArray();
			
			int k = 0;
			for(int i = bits.length()-1;i >= 0;i--){
				
				if(c[i] == '0' && i != 0 && k == 0){
					if(c[i-1] == '1'){
						small_app.append(c[i-1]);
						small_app.append(c[i]);
						i--;
						k++;
						continue;
					}
				}
				small_app.append(c[i]);
			}
			
			String smallest = small_app.toString();//big endian
			if(k == 0) {
				//There is no number with the same number of 1s that is smaller than n,ex:0011
				System.out.println("smallest: null");
			}
			else{
				int x = big_endian_to_dec(smallest);
				System.out.println("smallest: " + x);
			}
			
			//largest
			
			StringBuilder large_app = new StringBuilder();
			
			k = 0;
			
			for(int i = c.length-1;i >= 0;i--){
			
				if(c[i] == '1' && i != 0 && k == 0) {
					if(c[i-1] == '0') {
						large_app.append(c[i-1]);
						large_app.append(c[i]);
						i--;
						k++;
						continue;
					}
				}
				large_app.append(c[i]);
			}
			
			String largest = large_app.toString();//big endian
			
			if(k == 0) {
				System.out.println("largest: null");
			}
			else {
				int x = big_endian_to_dec(largest);
				System.out.println("largest: "+x);
			}
			
			return;
		}
		
		
		
		
		
	}
	
		
	
	}
	
	
