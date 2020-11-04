package cafeOrder_app;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;




public class A1 extends JFrame implements ActionListener{

	public static void main(String[] args) {
		new A1();
		set();
	}
	
	
	private JLabel lblSize,lblType,lblDetail,lblExtra;
	private JTextField txtDetail;
	private JButton btnAdd, btnOrder;
	private ButtonGroup btnGrps;
	private JRadioButton rdJuice,rdWater,rdTea,rdCoffee;
	private JCheckBox chInfo;
	private JComboBox<String> cBox;
		
	private static ArrayList<String> arrayList = new ArrayList<String>(9);
	ArrayList<Double> arrayListDouble = new ArrayList<Double>();
	
		
	public A1() {
		
		setLayout(null);
		init();
		
		
		//setting my GUI parameters
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);	
		setVisible(true);
		
	}
	
	private void init() {
		
		
		lblSize = new JLabel("Select size: ");
		lblSize.setLocation(70, 70);
		lblSize.setSize(80,50);
		add(lblSize);
		
		lblType = new JLabel("Select which type of beverage you want to order: ");
		lblType.setLocation(70, 150);
		lblType.setSize(300,50);
		add(lblType);
		
		lblDetail = new JLabel("Select how many glasses you want to order: ");
		lblDetail.setLocation(70, 230);
		lblDetail.setSize(300,50);
		add(lblDetail);
		
		lblExtra = new JLabel("");
		lblExtra.setLocation(70, 350);
		lblExtra.setSize(300,50);
		add(lblExtra);
		
		
		txtDetail = new JTextField();
		txtDetail.setLocation(70,275);
		txtDetail.setSize(300,30);
		txtDetail.addActionListener(this);
		txtDetail.setToolTipText("Enter Integer Number.");
		add(txtDetail);
		
		
		btnAdd = new JButton("Add");
		btnAdd.setLocation(70,320);
		btnAdd.setSize(90,40);
		add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnOrder = new JButton("Order");
		btnOrder.setLocation(280,320);
		btnOrder.setSize(90,40);
		add(btnOrder);
		
		btnOrder.addActionListener(this);
				
		btnGrps = new ButtonGroup();
		
		rdJuice = new JRadioButton("Juice");
		rdJuice.setLocation(70,190);
		rdJuice.setSize(90,60);
		add(rdJuice);
		rdJuice.addActionListener(this);
		
		rdWater = new JRadioButton("Water");
		rdWater.setLocation(170,190);
		rdWater.setSize(90,60);
		add(rdWater);
		rdWater.addActionListener(this);
		
		rdTea = new JRadioButton("Tea");
		rdTea.setLocation(270,190);
		rdTea.setSize(90,60);
		add(rdTea);
		rdTea.addActionListener(this);
		
		rdCoffee = new JRadioButton("Coffee");
		rdCoffee.setLocation(370,190);
		rdCoffee.setSize(90,60);
		add(rdCoffee);
		rdCoffee.addActionListener(this);
		
		btnGrps.add(rdJuice);
		btnGrps.add(rdWater);
		btnGrps.add(rdTea);
		btnGrps.add(rdCoffee);
		rdJuice.setSelected(false);
		
		
		cBox = new JComboBox<String>();
		cBox.addItem("Small");
		cBox.addItem("Medium");
		cBox.addItem("Large");
		cBox.setLocation(70,110);
		cBox.setSize(100,30);
		add(cBox);

	}

	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAdd)) {
			calculate();
		}else if(e.getSource().equals(btnOrder)) {
			order(arrayList);
			total(arrayListDouble);
			arrayList.clear();
			arrayListDouble.clear();
			set();
		}
	}
	
	
	
	private void calculate() {
				
		String[] list = {"Apple", "Orange", "Pineapple"};
		JComboBox cb = new JComboBox(list);
		
		try {
		if(btnGrps.getSelection() == null || txtDetail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Choose a beverage type and enter an amount.","Message",JOptionPane.WARNING_MESSAGE);
		}else {
			if(rdJuice.isSelected()){
				JOptionPane.showConfirmDialog(null, cb, "Select a fruit", JOptionPane.OK_CANCEL_OPTION);
				lblExtra.setText(txtDetail.getText() + " glass(es) of " + cb.getSelectedItem().toString() + " juice added.");
				if(cb.getSelectedItem().toString() == "Apple") {
					Double amount = 0.0;
					amount = amount + Double.valueOf(txtDetail.getText());
					arrayList.set(0, "Apple juice - " + amount * 4.0);
					arrayListDouble.add(Double.valueOf(txtDetail.getText()) * 4.0);
				}else if(cb.getSelectedItem().toString() == "Orange") {
					Double amount = 0.0;
					amount = amount + Double.valueOf(txtDetail.getText());
					arrayList.set(1, "Orange juice - " + amount * 5.0);
					arrayListDouble.add(Double.valueOf(txtDetail.getText()) * 5.0);
				}else if(cb.getSelectedItem().toString() == "Pineapple") {
					Double amount = 0.0;
					amount = amount + Double.valueOf(txtDetail.getText());
					arrayList.set(2, "Pineapple juice - " + amount * 6.0);
					arrayListDouble.add(Double.valueOf(txtDetail.getText()) * 6.0);
				}
				txtDetail.setText("");
				btnGrps.clearSelection();
			}else if(rdWater.isSelected()) {
				int i = JOptionPane.showConfirmDialog(null, "Would you like ice?","ice",JOptionPane.YES_NO_OPTION);
				if(i == 0) {
					lblExtra.setText(txtDetail.getText() + " glass(es) of water with ice added.");
					Double amount = 0.0;
					amount = amount + Double.valueOf(txtDetail.getText());
					arrayList.set(3, "Water with ice  - " + amount * 2.5);
					arrayListDouble.add(Double.valueOf(txtDetail.getText()) * 2.5);
					txtDetail.setText("");
					btnGrps.clearSelection();
				}else if(i == 1) {
					lblExtra.setText(txtDetail.getText() + " glass(es) of water added.");
					Double amount = 0.0;
					amount = amount + Double.valueOf(txtDetail.getText());
					arrayList.set(4, "Water   - " + amount * 2.0);
					arrayListDouble.add(Double.valueOf(txtDetail.getText()) * 2.0);
					txtDetail.setText("");
					btnGrps.clearSelection();
				}
				
			}else if(rdTea.isSelected()) {
				int i = JOptionPane.showConfirmDialog(null, "Would you like sugar?","sugar",JOptionPane.YES_NO_OPTION);
				if(i == 0) {
					lblExtra.setText(txtDetail.getText() + " glass(es) of tea with sugar added.");
					Double amount = 0.0;
					amount = amount + Double.valueOf(txtDetail.getText());
					arrayList.set(5, "Tea with sugar  - " + amount * 2.0);
					arrayListDouble.add(Double.valueOf(txtDetail.getText()) * 2.0);
					txtDetail.setText("");
					btnGrps.clearSelection();
				}else if(i == 1) {
					lblExtra.setText(txtDetail.getText() + " glass(es) of tea added.");
					Double amount = 0.0;
					amount = amount + Double.valueOf(txtDetail.getText());
					arrayList.set(6, "Tea - " + amount * 1);
					arrayListDouble.add(Double.valueOf(txtDetail.getText()) * 1.0);
					txtDetail.setText("");
					btnGrps.clearSelection();
				}
			}else if(rdCoffee.isSelected()) {
				int i = JOptionPane.showConfirmDialog(null, "Would you like milk?","milk",JOptionPane.YES_NO_OPTION);
				if(i == 0) {
					lblExtra.setText(txtDetail.getText() + " glass(es) of coffee with milk added.");
					Double amount = 0.0;
					amount = amount + Double.valueOf(txtDetail.getText());
					arrayList.set(7, "Coffee with milk  - " + amount * 12.0);
					arrayListDouble.add(Double.valueOf(txtDetail.getText()) * 12.0);
					txtDetail.setText("");
					btnGrps.clearSelection();
				}else if(i == 1) {
					lblExtra.setText(txtDetail.getText() + " glass(es) of coffee added.");
					Double amount = 0.0;
					amount = amount + Double.valueOf(txtDetail.getText());
					arrayList.set(8, "Coffee - " + amount * 10.0);
					arrayListDouble.add(Double.valueOf(txtDetail.getText()) * 10.0);
					txtDetail.setText("");
					btnGrps.clearSelection();
				}
			}
		}
		}
		catch(java.lang.NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"You must enter an integer." );
			lblExtra.setText("");
		}
	
		
		
		
		
	}
	
	public static void order(ArrayList<String> a) {
		String result = "";
		
		for(int i = 0; i < a.size();i++) {
			if(a.get(i).isEmpty()) {
				continue;
			}else {
				result = result + a.get(i)+ "\n";
			}
		}
		JOptionPane.showMessageDialog(null, result);
	}
	
	private static void total(ArrayList<Double> d) {
		Double total = 0.0;
		
		for(int i = 0;i<d.size();i++) {
			total = total + d.get(i);
		}
		JOptionPane.showMessageDialog(null,"You should pay " +total+" TL.");
		
	}
	public static void set() {
		arrayList.add("");
		arrayList.add("");
		arrayList.add("");
		arrayList.add("");
		arrayList.add("");
		arrayList.add("");
		arrayList.add("");
		arrayList.add("");
		arrayList.add("");
		
		
	}
	
		
		
	
	
	}
