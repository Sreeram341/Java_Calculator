/********************************************************************************************
 * 
 * File Name : CalcButtn.java
 * 
 * Authors : Sreeram Pulavarthi, Sudheer Tindivanam
 * 
 * Group #: 12
 * 
 * Date: 10-06-2017
 * 
 * Compiler Used: Java 1.8
 * 
 * Description of File: Creates the Buttons, Adds the action listener and sends back response to frame class
 * 
 *********************************************************************************************
 */

package Calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class CalcButtn extends JButton implements ActionListener {
	
	public String btn_val;
	
	private BaseWindow bw;

	public CalcButtn(String name,BaseWindow bw) {
		// TODO Auto-generated constructor stub
		
		//gridbag.setConstraints(this, c);
		
		this.bw = bw;
		
		this.setPreferredSize(new Dimension(10, 10));
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		this.setBorder(border);
		
		this.setFont(getFont().deriveFont(30f));
		
		this.setFont(getFont().deriveFont(Font.BOLD));
		
		this.setText(name);
		
		this.setVisible(true);
		
		this.addActionListener(this);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		//String BTNTYP = this.getText();
				
		getbtnName();
		
	}
	public String getbtnName() {
		
		btn_val=this.getText();
		//System.out.println(btn_val);
	
		bw.showbtn_prsd(btn_val);
		
		return this.btn_val;
	}
	
}
