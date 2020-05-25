package finalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteItem extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private ArrayList<String> itemList = new ArrayList<String>();
	private ArrayList<String> deletedList = new ArrayList<String>();
	private String item_name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteItem frame = new DeleteItem();
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
	public DeleteItem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel deleteItemPanel = new JPanel();
		deleteItemPanel.setForeground(Color.DARK_GRAY);
		deleteItemPanel.setBorder(new LineBorder(new Color(255, 200, 0), 7));
		deleteItemPanel.setBackground(Color.DARK_GRAY);
		deleteItemPanel.setBounds(0, 0, 436, 67);
		contentPane.add(deleteItemPanel);
		
		JLabel lblDeleteItem = new JLabel("Delete item");
		deleteItemPanel.add(lblDeleteItem);
		lblDeleteItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteItem.setForeground(Color.ORANGE);
		lblDeleteItem.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblDeleteItem.setBackground(Color.WHITE);
		
		JLabel lblItemName = new JLabel("Item name");
		lblItemName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblItemName.setBounds(52, 125, 98, 33);
		contentPane.add(lblItemName);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(142, 126, 247, 33);
		contentPane.add(nameTextField);
		
		JLabel lblWarning = new JLabel("");
		lblWarning.setForeground(Color.RED);
		lblWarning.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWarning.setBounds(55, 82, 305, 33);
		contentPane.add(lblWarning);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(96, 232, 85, 21);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteItem.this.setVisible(false);
			}
		});
		contentPane.add(btnBack);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(254, 232, 85, 21);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item_name = nameTextField.getText();
				nameTextField.setText("");
				if(itemList.contains(item_name) == false) {
					lblWarning.setText("Item does not exist!");
				}
				else {
					itemList.remove(item_name);
					deletedList.add(item_name);
					lblWarning.setForeground(Color.GREEN);
					lblWarning.setText("Item deleted successfully!");
				}
			}
		});
		contentPane.add(btnDelete);
		
		
	}
	
	public void itemListAdd(ArrayList<String> list) {
		itemList.addAll(list);
	}
	
	public ArrayList<String> getList(){
		return deletedList;
	}
	
	public void clearList() {
		deletedList.clear();
	}
	
}
