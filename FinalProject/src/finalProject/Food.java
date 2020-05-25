package finalProject;

import java.util.HashMap;

public class Food implements Items{
	
	private HashMap<String, Float> entree_list = new HashMap<String, Float>();
	private HashMap<String, Float> main_course_list = new HashMap<String, Float>();
	private HashMap<String, Float> dessert_list = new HashMap<String, Float>();
		
	public void addItem(String food_name,String food_type, Float food_price) {
		if(food_type == "Entree") {
			entree_list.put(food_name,food_price);
		}
		else if(food_type == "Main Course") {
			main_course_list.put(food_name, food_price);
		}
		else {
			dessert_list.put(food_name, food_price);
		}
	}
	
	@Override
	public void removeItem(String name) {
		if(entree_list.containsKey(name)) entree_list.remove(name);
		else if(main_course_list.containsKey(name)) main_course_list.remove(name);
		else if(dessert_list.containsKey(name)) dessert_list.remove(name);
	}
	
	@Override
	public void displayAllItem() {
		System.out.println("Entrees:");
		for(String i: entree_list.keySet()) {
			System.out.println("Food name = " + i + " Food price = " + Float.toString(entree_list.get(i)));
		}
		System.out.println();
		
		System.out.println("Main Courses:");
		for(String i: main_course_list.keySet()) {
			System.out.println("Food name = " + i + " Food price = " + Float.toString(main_course_list.get(i)));
		}
		System.out.println();
		
		System.out.println("Desserts:");
		for(String i: dessert_list.keySet()) {
			System.out.println("Food name = " + i + " Food price = " + Float.toString(dessert_list.get(i)));
		}
		System.out.println();
	}
	
	@Override
	public boolean contains(String name) {
		if(entree_list.containsKey(name) || main_course_list.containsKey(name) || dessert_list.containsKey(name)) return true;
		else return false;
	}
	
	public HashMap<String, Float> getEntree(){
		return entree_list;
	}
	
	public HashMap<String, Float> getMainCourse(){
		return main_course_list;
	}
	
	public HashMap<String, Float> getDessert(){
		return dessert_list;
	}
	
	
	

}
