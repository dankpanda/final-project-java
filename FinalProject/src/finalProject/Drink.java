package finalProject;

import java.util.HashMap;

public class Drink implements Items{
	
	private HashMap<String, Float> drink_list = new HashMap<String, Float>();

	public void addItem(String drink_name, float drink_price) {
		drink_list.put(drink_name,drink_price);
	}
	
	@Override
	public void removeItem(String name) {
		drink_list.remove(name);
	}
	
	@Override
	public void displayAllItem() {
		for(String i: drink_list.keySet()) {
			System.out.println("Drink name = " + i + " Drink price = " + Float.toString(drink_list.get(i)));
		}
	}
	
	@Override
	public boolean contains(String name) {
		return drink_list.containsKey(name);
	}
	
	public HashMap<String, Float> getDrink(){
		return drink_list;
	}
	

}
