package finalProject;

import java.util.HashMap;

public abstract class FoodType {
	public String type_name;
	public HashMap<String, Float> food_list = new HashMap<String, Float>();
	public abstract void addFood();
	public abstract void removeFood();
	
}
