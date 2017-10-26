/********************************************************************************************
 * 
 * File Name : CalcLabel.java
 * 
 * Authors : Sreeram Pulavarthi, Sudheer Tindivanam
 * 
 * Group #: 12
 * 
 * Date: 10-06-2017
 * 
 * Compiler Used: Java 1.8
 * 
 * Description of File: Creates the JTextField , Adds the text to the text field from right to left
 * 
 *********************************************************************************************
 */


package Calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class CalcLabel extends JTextField {

	public CalcLabel() {
		// TODO Auto-generated constructor stub		
			
		this.setSize(50,50);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		this.setForeground(Color.BLUE);
				
		this.setHorizontalAlignment(SwingConstants.RIGHT);
				
		this.setFont(this.getFont().deriveFont(80.f));
		
		this.setBorder(border);
		
		this.setEnabled(true);
		
		this.setEditable(false);
		
	}
	
	
}