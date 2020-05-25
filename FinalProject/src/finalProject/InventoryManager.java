package finalProject;

public class InventoryManager {

	public static void main(String[] args) {
		
	
		MainMenu myMenu = new MainMenu();
		while(true) {
			if(myMenu.pendingDrinkCheck()) myMenu.addDrink();
			if(myMenu.pendingFoodCheck()) myMenu.addFood();
			myMenu.displayCheck();
			myMenu.deleteUpdate();
			myMenu.foodTypeUpdate();
			
			
		}
		
		
		

	}

}
