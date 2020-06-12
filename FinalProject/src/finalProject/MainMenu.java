package finalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private Food myFood = new Food();
	private Drink myDrink = new Drink();
	private AddItem myAdd = new AddItem();
	private DeleteItem myDelete = new DeleteItem();
	private ViewItem myView = new ViewItem();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// The add item button
		JButton btnAddItem = new JButton("Add item");
		btnAddItem.setBounds(158, 97, 116, 21);
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.setVisible(false);	// Hides current window
				myAdd.setVisible(true);	// Displays add item window
				
			}
		});
		contentPane.add(btnAddItem);
		
		// The delete item button
		JButton btnDeleteItem = new JButton("Delete item");
		btnDeleteItem.setBounds(158, 144, 116, 21);
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDelete.itemListAdd(myAdd.getList());	// Updates item list prior to deletion
				MainMenu.this.setVisible(false);	// Hides current window
				myDelete.setVisible(true);	// Displays delete item window
			}
		});
		contentPane.add(btnDeleteItem);
		
		// The view menu button
		JButton btnViewMenu = new JButton("View menu");
		btnViewMenu.setBounds(158, 189, 116, 21);
		btnViewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.setVisible(false);	// Hides current window
				myView.clearMenu();	// Clears entire menu
				myView.updateText(myFood.getEntree(), myFood.getMainCourse(), myFood.getDessert(), myDrink.getDrink()); // Updates new menu 
				myView.setVisible(true);	// Displays view menu window
			}
		});
		contentPane.add(btnViewMenu);
		
		// Sets background color
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new LineBorder(new Color(255, 200, 0), 6));
		panel.setBounds(0, 0, 436, 63);
		contentPane.add(panel);
		
		// A label for window header
		JLabel lblRestaurantMenu = new JLabel("Restaurant Menu");
		panel.add(lblRestaurantMenu);
		lblRestaurantMenu.setForeground(Color.ORANGE);
		lblRestaurantMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurantMenu.setFont(new Font("Tahoma", Font.BOLD, 33));
	}
	
	// Adds a new food that was pending from myAdd
	public void addFood() {
		myFood.addItem(myAdd.getFoodName(), myAdd.getFoodType(), myAdd.getFoodPrice());
		myAdd.clearFood();

	}
	
	// Adds a new drink that was pending from myAdd
	public void addDrink() {
			myDrink.addItem(myAdd.getDrinkName(), myAdd.getDrinkPrice());
			myAdd.clearDrink();
		
	}
	
	// Checks whether the current window should be visible or not
	public void displayCheck() {
		if(myAdd.isVisible() || myDelete.isVisible() || myView.isVisible()) {
			MainMenu.this.setVisible(false);
		}
		else MainMenu.this.setVisible(true);
	}
	
	// Checks whether there are any pending food to be added from myAdd
	public boolean pendingFoodCheck() {
		return myAdd.pendingFoodCheck();
		
	}
	
	// Updates whether the combo box on myAdd should be displayed or not
	public void foodTypeUpdate() {
		if(myAdd.getFoodTypeVisibility()) myAdd.setFoodTypeVisiblity(true);
		else myAdd.setFoodTypeVisiblity(false);
	}
	
	// Checks whether there are any pending drink to be added from myAdd
	public boolean pendingDrinkCheck() {
		return myAdd.pendingDrinkCheck();
	}
	
	// Updates the list after any item is deleted from myDelete
	public void deleteUpdate() {
		myAdd.deleteItem(myDelete.getList());
		for(String i: myDelete.getList()) {
			if(myFood.contains(i)) myFood.removeItem(i);
			if(myDrink.contains(i)) myDrink.removeItem(i);
		}
		myDelete.clearList();
	}
}

