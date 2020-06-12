package finalProject;

public class InventoryManager {

	public static void main(String[] args) {
		
		// Initialize main application
		MainMenu myMenu = new MainMenu();
		while(true) {
			if(myMenu.pendingDrinkCheck()) myMenu.addDrink(); // Checks whether there are any new drinks added
			if(myMenu.pendingFoodCheck()) myMenu.addFood(); // Checks whether there are any new food added
			myMenu.displayCheck(); // Checks whether main menu window should be hidden or not
			myMenu.deleteUpdate(); // Checks whether there are any items deleted
			myMenu.foodTypeUpdate(); // Checks whether the add item's combo box should be visible or not
			
			
		}
		
		
		

	}

}
