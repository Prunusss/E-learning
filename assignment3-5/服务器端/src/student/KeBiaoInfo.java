package student;

import java.util.ArrayList;

public class KeBiaoInfo {
	private ArrayList<KeCheng> k_array;
	public boolean addKeCheng(KeCheng k){
		if(k_array.add(k)){
			return true;
		}
		else{
			return false;
		}
		
	}
	public ArrayList<KeCheng> getKeBiao(){
		return this.k_array;
	}
}
