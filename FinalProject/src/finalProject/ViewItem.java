package finalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class ViewItem extends JFrame {

	private JPanel contentPane;
	private JTextArea entreeTextArea;
	private JTextArea mainCourseTextArea;
	private JTextArea dessertTextArea;
	private JTextArea drinkTextArea;
	private JScrollPane entreeScroll;
	private JScrollPane mainCourseScroll;
	private JScrollPane dessertScroll;
	private JScrollPane drinkScroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewItem frame = new ViewItem();
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
	public ViewItem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 773);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 735, 63);
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.DARK_GRAY);
		panel.setBorder(new LineBorder(Color.ORANGE, 6));
		contentPane.add(panel);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.ORANGE);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 33));
		panel.add(lblMenu);
		
		entreeTextArea = new JTextArea();
		entreeScroll = new JScrollPane(entreeTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		entreeScroll.setBounds(0, 99, 360, 301);
		entreeTextArea.setEditable(false);
		entreeTextArea.setBackground(Color.GRAY);
		entreeTextArea.setBounds(0, 99, 360, 301);
		entreeScroll.setBackground(Color.GRAY);
		entreeTextArea.setFont(entreeTextArea.getFont().deriveFont(15f));
		contentPane.add(entreeScroll);
		
		mainCourseTextArea = new JTextArea();
		mainCourseScroll = new JScrollPane(mainCourseTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		mainCourseScroll.setBounds(375, 99, 360, 301);
		mainCourseTextArea.setEditable(false);
		mainCourseTextArea.setBackground(Color.GRAY);
		mainCourseTextArea.setBounds(375, 99, 360, 301);
		mainCourseScroll.setBackground(Color.GRAY);
		mainCourseTextArea.setFont(mainCourseTextArea.getFont().deriveFont(15f));
		contentPane.add(mainCourseScroll);
		
		dessertTextArea = new JTextArea();
		dessertScroll = new JScrollPane(dessertTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		dessertScroll.setBounds(0, 435, 360, 301);
		dessertTextArea.setEditable(false);
		dessertTextArea.setBackground(Color.GRAY);
		dessertTextArea.setBounds(0, 435, 360, 301);
		dessertScroll.setBackground(Color.GRAY);
		dessertTextArea.setFont(dessertTextArea.getFont().deriveFont(15f));
		contentPane.add(dessertScroll);
		
		drinkTextArea = new JTextArea();
		drinkScroll = new JScrollPane(drinkTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		drinkScroll.setBounds(375, 435, 360, 301);
		drinkTextArea.setEditable(false);
		drinkTextArea.setBackground(Color.GRAY);
		drinkTextArea.setBounds(375, 435, 360, 301);
		drinkScroll.setBackground(Color.GRAY);
		drinkTextArea.setFont(drinkTextArea.getFont().deriveFont(15f));
		contentPane.add(drinkScroll);
			
		JLabel lblEntree = new JLabel("Entree");
		lblEntree.setBounds(145, 60, 92, 41);
		lblEntree.setForeground(Color.BLACK);
		lblEntree.setFont(new Font("Tahoma", Font.BOLD, 21));
		contentPane.add(lblEntree);
		
		JLabel lblMainCourse = new JLabel("Main Course");
		lblMainCourse.setBounds(490, 64, 152, 33);
		lblMainCourse.setFont(new Font("Tahoma", Font.BOLD, 21));
		contentPane.add(lblMainCourse);
		
		JLabel lblDessert = new JLabel("Dessert");
		lblDessert.setBounds(133, 399, 92, 26);
		lblDessert.setFont(new Font("Tahoma", Font.BOLD, 21));
		contentPane.add(lblDessert);
		
		JLabel lblDrinks = new JLabel("Drinks");
		lblDrinks.setBounds(521, 399, 78, 26);
		lblDrinks.setFont(new Font("Tahoma", Font.BOLD, 21));
		contentPane.add(lblDrinks);
		
		JButton btnNewButton = new JButton("< Back");
		btnNewButton.setBounds(10, 68, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewItem.this.setVisible(false);
			}
		});
		contentPane.add(btnNewButton);
		
	}
	
	public void clearMenu() {
		drinkTextArea.setText("");
		mainCourseTextArea.setText("");
		entreeTextArea.setText("");
		dessertTextArea.setText("");
	}
	
	public String linePreset(String name, Float price) {
		int size = 83;
		int loops = size-2*(Float.toString(price).length());
		String output = name;
		output += "\n";
		for(int i = 0; i < loops; i++) output += " ";
		output += "$";
		output += price.toString();
		return output;
	}
	
	public void updateText(HashMap<String, Float> entree, HashMap<String, Float> main_course, HashMap<String, Float> dessert, HashMap<String, Float> drink) {
		for(String i: entree.keySet()) {
			entreeTextArea.append(linePreset(i,entree.get(i)));
			entreeTextArea.append("\n");
		}
		for(String i: main_course.keySet()) {
			mainCourseTextArea.append(linePreset(i,main_course.get(i)));
			mainCourseTextArea.append("\n");
		}
		for(String i: dessert.keySet()) {
			dessertTextArea.append(linePreset(i,dessert.get(i)));
			dessertTextArea.append("\n");
		}
		for(String i: drink.keySet()) {
			drinkTextArea.append(linePreset(i,drink.get(i)));
			drinkTextArea.append("\n");
		}
	}
}
