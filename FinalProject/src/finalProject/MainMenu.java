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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddItem = new JButton("Add item");
		btnAddItem.setBounds(158, 97, 116, 21);
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.setVisible(false);
				myAdd.setVisible(true);
				
			}
		});
		contentPane.add(btnAddItem);
		
		
		JButton btnDeleteItem = new JButton("Delete item");
		btnDeleteItem.setBounds(158, 144, 116, 21);
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDelete.itemListAdd(myAdd.getList());
				MainMenu.this.setVisible(false);
				myDelete.setVisible(true);
			}
		});
		contentPane.add(btnDeleteItem);
		
		JButton btnViewMenu = new JButton("View menu");
		btnViewMenu.setBounds(158, 189, 116, 21);
		btnViewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.setVisible(false);
				myView.clearMenu();
				myView.updateText(myFood.getEntree(), myFood.getMainCourse(), myFood.getDessert(), myDrink.getDrink());
				myView.setVisible(true);
			}
		});
		contentPane.add(btnViewMenu);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new LineBorder(new Color(255, 200, 0), 6));
		panel.setBounds(0, 0, 436, 63);
		contentPane.add(panel);
		
		JLabel lblRestaurantMenu = new JLabel("Restaurant Menu");
		panel.add(lblRestaurantMenu);
		lblRestaurantMenu.setForeground(Color.ORANGE);
		lblRestaurantMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurantMenu.setFont(new Font("Tahoma", Font.BOLD, 33));
	}
	
	public void addFood() {
		myFood.addItem(myAdd.getFoodName(), myAdd.getFoodType(), myAdd.getFoodPrice());
		myAdd.clearFood();

	}
	
	public void addDrink() {
			myDrink.addItem(myAdd.getDrinkName(), myAdd.getDrinkPrice());
			myAdd.clearDrink();
		
	}
	
	public void displayCheck() {
		if(myAdd.isVisible() || myDelete.isVisible() || myView.isVisible()) {
			MainMenu.this.setVisible(false);
		}
		else MainMenu.this.setVisible(true);
	}
	
	public boolean pendingFoodCheck() {
		return myAdd.pendingFoodCheck();
		
	}
	
	public void foodTypeUpdate() {
		if(myAdd.getFoodTypeVisibility()) myAdd.setFoodTypeVisiblity(true);
		else myAdd.setFoodTypeVisiblity(false);
	}
	
	public boolean pendingDrinkCheck() {
		return myAdd.pendingDrinkCheck();
	}
	
	public void deleteUpdate() {
		myAdd.deleteItem(myDelete.getList());
		for(String i: myDelete.getList()) {
			if(myFood.contains(i)) myFood.removeItem(i);
			if(myDrink.contains(i)) myDrink.removeItem(i);
		}
		myDelete.clearList();
	}
}

