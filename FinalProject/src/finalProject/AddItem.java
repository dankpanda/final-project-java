package finalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.util.ArrayList;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.Action;
public class AddItem extends JFrame {

	private JPanel contentPane;
	private JCheckBox chckbxDrink;
	private JComboBox<String> foodTypeBox;
	private JTextField nameTextField;
	private JTextField priceTextField;
	private String item_name;
	private Float item_price;
	private ArrayList<String> pendingDrink = new ArrayList<String>();
	private ArrayList<String> pendingFood = new ArrayList<String>();
	private ArrayList<String> itemList = new ArrayList<String>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItem frame = new AddItem();
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
	
	
	public AddItem() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 324);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Text field for user to enter item name
		nameTextField = new JTextField();
		nameTextField.setBounds(136, 113, 247, 33);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		// A simple label besides the text field to tell the user what data their supposed to enter on the text field
		JLabel lblItemName = new JLabel("Item name");
		lblItemName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblItemName.setBounds(46, 112, 98, 33);
		contentPane.add(lblItemName);
		
		// Sets the background color
		JPanel addItemPanel = new JPanel();
		addItemPanel.setBackground(Color.DARK_GRAY);
		addItemPanel.setForeground(Color.DARK_GRAY);
		addItemPanel.setBorder(new LineBorder(new Color(255, 200, 0), 7));
		addItemPanel.setBounds(0, 0, 434, 67);
		contentPane.add(addItemPanel);
		
		// A simple label that acts as the header of the window
		JLabel lblAddItem = new JLabel("Add item");
		addItemPanel.add(lblAddItem);
		lblAddItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddItem.setForeground(Color.ORANGE);
		lblAddItem.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblAddItem.setBackground(Color.WHITE);
		
		// A label used to alert the user about the outcome of their actions
		JLabel lblWarning = new JLabel("");
		lblWarning.setForeground(Color.RED);
		lblWarning.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWarning.setBounds(46, 77, 305, 33);
		contentPane.add(lblWarning);
		
		// A simple label besides the text field to tell the user what data their supposed to enter on the text field
		JLabel lblItemPrice = new JLabel("Item price");
		lblItemPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblItemPrice.setBounds(46, 156, 98, 33);
		contentPane.add(lblItemPrice);
		
		// Text field for user to enter item price
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		priceTextField.setBounds(136, 156, 247, 33);
		contentPane.add(priceTextField);
		
		// A checkbox to ask whether the item is a drink or not. This checkbox is mutually exclusive with the combo box below
		chckbxDrink = new JCheckBox("Item is a drink");
		chckbxDrink.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxDrink.setBounds(46, 205, 117, 27);
		contentPane.add(chckbxDrink);
		
		// A combo box that asks the user whether the item is an entree, main course or dessert. This combo box is mutually exclusive with the checkbox above
		foodTypeBox = new JComboBox<String>();
		foodTypeBox.setBounds(268, 209, 115, 21);
		foodTypeBox.addItem("Entree");
		foodTypeBox.addItem("Main Course");
		foodTypeBox.addItem("Dessert");
		contentPane.add(foodTypeBox);
		
		// The submit button
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(254, 256, 85, 21);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblWarning.setForeground(Color.RED);
				String temp_item_name = nameTextField.getText();
				
				// Checks whether the user entered a valid price 
				try {
				float temp_item_price = Float.parseFloat(priceTextField.getText());
				}
				catch(Exception f) {
					lblWarning.setText("Please enter a valid price!");
					priceTextField.setText("");
					nameTextField.setText("");
					return;
				}
				float temp_item_price = Float.parseFloat(priceTextField.getText());
				priceTextField.setText("");
				nameTextField.setText("");
				
				// Ensures the user entered an item name
				if(temp_item_name.length() == 0) {
					lblWarning.setText("Please enter item name!");
					return;
				}
				
				// Ensures item name is not over 20 characters long
				if(temp_item_name.length() > 20) {
					lblWarning.setText("Name cannot be longer than 20 letters!");
					return;
				}
				
				// Ensures the user entered a non negative price
				if(temp_item_price <= 0) {
					lblWarning.setText("Please enter a valid price!");
					return;
				}
				
				// Ensures the user entered item is unique
				if(itemList.contains(temp_item_name)) {
					lblWarning.setText("Item already exists!");
					return;
				}
				
				// Success message
				lblWarning.setForeground(Color.GREEN);
				lblWarning.setText("Item added successfully!");
				item_name = temp_item_name;
				item_price = temp_item_price;
				itemList.add(item_name);
				
					// Checks whether item was a drink or not
					if(chckbxDrink.isSelected()) {
					pendingDrink.add(item_name);
				
				}
				else {
					pendingFood.add(item_name);
					pendingFood.add((String)foodTypeBox.getSelectedItem());
				}
			}
		});
		contentPane.add(btnSubmit);
		
		// The back button
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(96, 256, 85, 21);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Hides the current window
				AddItem.this.setVisible(false);
			}
		});
		contentPane.add(btnBack);
		
		
		
	}
	
	// Used to check whether a new drink is ready to be added or not
	public boolean pendingDrinkCheck() {
		if(pendingDrink.isEmpty()) return false;
		else return true;
	}
	
	// Used to check whether a new food is ready to be added or not
	public boolean pendingFoodCheck() {
		if(pendingFood.isEmpty()) return false;
		else return true;
	}
	
	// Get food name
	public String getFoodName() {
		return pendingFood.get(0);
	}
	
	// Get food price
	public Float getFoodPrice() { 
		pendingFood.add(Float.toString(item_price));
		return Float.parseFloat(pendingFood.get(2));
	}
	
	// Get food type
	public String getFoodType() {
		return pendingFood.get(1);
	}
	
	// Get drink name
	public String getDrinkName() {
		return pendingDrink.get(0);
	}
	
	// Get drink price
	public Float getDrinkPrice() {
		pendingDrink.add(Float.toString(item_price));
		return Float.parseFloat(pendingDrink.get(1));
	}
	
	// Clears the pending drink list
	public void clearDrink() {
		pendingDrink.clear();
	}
	
	// Clears the pending food list
	public void clearFood() {
		pendingFood.clear();
	}
	
	// Get list of items
	public ArrayList<String> getList(){
		return itemList;
	}
	
	// Deletes items from the given list
	public void deleteItem(ArrayList<String> deletedList) {
		itemList.removeAll(deletedList);
	}
	
	// Function to set the visibility of the food type combo box
	public void setFoodTypeVisiblity(boolean param) {
		foodTypeBox.setVisible(param);
	}
	
	// Function to ensure food type combo box and drink checkbox is mutually exclusive
	public boolean getFoodTypeVisibility() {
		if(chckbxDrink.isSelected()) return false;
		else return true;
	}
}
