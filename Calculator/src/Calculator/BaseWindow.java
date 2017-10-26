/********************************************************************************************
 * 
 * File Name : Base Window.java
 * 
 * Authors : Sreeram Pulavarthi, Sudheer Tindivanam
 * 
 * Group #: 12
 * 
 * Date: 10-06-2017
 * 
 * Compiler Used: Java 1.8
 * 
 * Description of File: Creates the Main Frame , creates the main heart and core logic for calculator, 
 * 						Add the TextField and constructs the CalcButtn class. 
 * 
 *********************************************************************************************
 */

package Calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class BaseWindow extends JFrame {

	static ArrayList<String> LblData = new ArrayList<String>();

	public static ArrayList<CalcButtn> CALNUMBTNLIST = new ArrayList<CalcButtn>();

	public static ArrayList<CalcButtn> CALOPRTRBTNLIST = new ArrayList<CalcButtn>();

	public static ArrayList<CalcButtn> CALEXPRRBTNLIST = new ArrayList<CalcButtn>();

	CalcLabel CLBL = new CalcLabel();

	String getbtnText = "", curr_wrd = "";

	Double decimal_part = 0.0, ress=0.0;
	
	int num1 = 0, num2 = 0, res = 0, curr_cntr = 0, pre_cntr = 0;
	
	
	public BaseWindow() {
		// TODO Auto-generated constructor stub

		////////////////////////// CREATE BORDER LAYOUT FOR MAIN FRAME
		////////////////////////// //////////////////////////////

		BorderLayout BL = new BorderLayout();

		this.setLayout(BL);

		/////////////////////////// PANEL CREATION FOR ADDING MAIN BUTTONS ON WEST SIDE
		/////////////////////////// //////////////////////

		JPanel JP = new JPanel(); // PANEL FOR BUTTONS

		GridLayout GL = new GridLayout(6, 3, 15, 15); /// GRID LAYOUT FOR MAIN NUMBERS AND OPEARTORS

		JP.setLayout(GL); // ADD GRID LAYOUT FOR PANEL

		JPanel Jsub = new JPanel(); // EMPTY PANEL FOR SPACE

		JPanel Jmain = new JPanel(); // MAIN PANEL FOR ADDING EMPTY PANEL AND BUTTON PANEL

		// GridLayout GL2 = new GridLayout(1, 2,15,15); /// FOR MAIN PANEL ADDING 2 MORE
		// LEFT SUB PANELS

		///////////////////////// PANEL CREATION FOR ADDING OPERATOR BUTTONS ON EAST
		///////////////////////// SIDE ////////////////

		JPanel JP3 = new JPanel();

		GridLayout GL3 = new GridLayout(4, 3, 15, 15);

		JP3.setLayout(GL3);

		JPanel LeftJsub = new JPanel(); // EMPTY PANEL FOR SPACE

		JPanel LeftJmain = new JPanel(); // MAIN PANEL FOR ADDING EMPTY PANEL AND BUTTON PANEL

		///////////////////////////// CENTER AND BOTTOM PANELS FOR SPACE ALIGNEMNT ON
		///////////////////////////// FRAME //////

		JPanel JPCENT = new JPanel();

		JPCENT.setPreferredSize(new Dimension(10, 10));

		this.add(JPCENT, BL.CENTER);

		JPanel JPBOT = new JPanel();

		JPBOT.setPreferredSize(new Dimension(10, 10));

		this.add(JPBOT, BL.SOUTH);

		/////////////////// CREATE PANEL, ADD GRID LAYOUT TO PANEL AND ADD TO FRAME
		/////////////////// ////////////////////

		/**/

		CalcButtn CB1 = new CalcButtn("1", this);

		CB1.setForeground(Color.orange);

		CALNUMBTNLIST.add(CB1);

		this.getContentPane().add(JP, BL.WEST);

		CalcButtn CB2 = new CalcButtn("2", this);

		CB2.setForeground(Color.orange);

		CALNUMBTNLIST.add(CB2);

		CalcButtn CB3 = new CalcButtn("3", this);

		CB3.setForeground(Color.orange);

		CALNUMBTNLIST.add(CB3);

		CalcButtn CB4 = new CalcButtn("4", this);

		CB4.setForeground(Color.red);

		CALNUMBTNLIST.add(CB4);

		CalcButtn CB5 = new CalcButtn("5", this);

		CB5.setForeground(Color.red);

		CALNUMBTNLIST.add(CB5);

		CalcButtn CB6 = new CalcButtn("6", this);

		CB6.setForeground(Color.red);

		CALNUMBTNLIST.add(CB6);

		CalcButtn CB7 = new CalcButtn("7", this);

		CB7.setForeground(Color.red);

		CALNUMBTNLIST.add(CB7);

		CalcButtn CB8 = new CalcButtn("8", this);

		CB8.setForeground(Color.red);

		CALNUMBTNLIST.add(CB8);

		CalcButtn CB9 = new CalcButtn("9", this);

		CB9.setForeground(Color.red);

		CALNUMBTNLIST.add(CB9);

		CalcButtn CBDOT = new CalcButtn(".", this);

		CBDOT.setForeground(Color.red);

		CALNUMBTNLIST.add(CBDOT);

		CalcButtn CBZER = new CalcButtn("0", this);

		CBZER.setForeground(Color.red);

		CALNUMBTNLIST.add(CBZER);

		CalcButtn CBEQL = new CalcButtn("=", this);

		CBEQL.setForeground(Color.black);

		CALNUMBTNLIST.add(CBEQL);

		////////////////////////////////// CREATING EXPRESSION LABELS AND ADDING TO
		////////////////////////////////// PANEL1 WEST /////////////

		CalcButtn CBOPPLS = new CalcButtn("+", this);

		CBOPPLS.setForeground(Color.black);

		CALNUMBTNLIST.add(CBOPPLS);

		CalcButtn CBOPMNS = new CalcButtn("-", this);

		CBOPMNS.setForeground(Color.black);

		CALNUMBTNLIST.add(CBOPMNS);

		CalcButtn CBOPMUL = new CalcButtn("*", this);

		CBOPMNS.setForeground(Color.black);

		CALNUMBTNLIST.add(CBOPMUL);

		CalcButtn CBOPDIV = new CalcButtn("÷", this);

		CBOPDIV.setForeground(Color.black);

		CALNUMBTNLIST.add(CBOPDIV);

		CalcButtn CBOPMOD = new CalcButtn("%", this);

		CBOPMOD.setForeground(Color.black);

		CALNUMBTNLIST.add(CBOPMOD);

		CalcButtn CBOPCLR = new CalcButtn("CLR", this);

		CBOPMOD.setForeground(Color.black);

		CALNUMBTNLIST.add(CBOPCLR);

		for (int i = 0; i < CALNUMBTNLIST.size(); i++) {

			JP.add(CALNUMBTNLIST.get(i));
		}

		JP.setPreferredSize(new Dimension(400, 400));

		Jmain.add(Jsub);

		Jmain.add(JP);

		this.getContentPane().add(Jmain, BL.WEST);

		////////////////////////////////// CREATING JLABLS AND ADDING TO PANEL2 EAST
		////////////////////////////////// /////////////////////

		CalcButtn CBEXPSQR = new CalcButtn("X^2", this);

		CBEXPSQR.setForeground(Color.magenta);

		CALEXPRRBTNLIST.add(CBEXPSQR);

		CalcButtn CBEXPCUB = new CalcButtn("X^3", this);

		CBEXPCUB.setForeground(Color.magenta);

		CALEXPRRBTNLIST.add(CBEXPCUB);

		CalcButtn CBEXPINV = new CalcButtn("1/X", this);

		CBEXPINV.setForeground(Color.GRAY);

		CALEXPRRBTNLIST.add(CBEXPINV);

		CalcButtn CBEXPSIN = new CalcButtn("sin X", this);

		CBEXPSIN.setForeground(Color.blue);

		CALEXPRRBTNLIST.add(CBEXPSIN);

		CalcButtn CBEXPCOS = new CalcButtn("cos X", this);

		CBEXPCOS.setForeground(Color.blue);

		CALEXPRRBTNLIST.add(CBEXPCOS);

		CalcButtn CBEXPTAN = new CalcButtn("tan X", this);

		CBEXPTAN.setForeground(Color.blue);

		CALEXPRRBTNLIST.add(CBEXPTAN);

		CalcButtn CBEXPEXPO = new CalcButtn("e ^ X", this);

		CBEXPEXPO.setForeground(Color.green);

		CALEXPRRBTNLIST.add(CBEXPEXPO);

		CalcButtn CBEXPNATLOG = new CalcButtn("ln X", this);

		CBEXPNATLOG.setForeground(Color.green);

		CALEXPRRBTNLIST.add(CBEXPNATLOG);

		CalcButtn CBEXPSQRT = new CalcButtn("SQRT", this);

		CBEXPSQRT.setForeground(Color.pink);

		CALEXPRRBTNLIST.add(CBEXPSQRT);

		CalcButtn CBEXPPI = new CalcButtn("π", this);

		CBEXPPI.setForeground(Color.red);

		CALEXPRRBTNLIST.add(CBEXPPI);

		CalcButtn CBEXPEE = new CalcButtn("e", this);

		CBEXPEE.setForeground(Color.red);

		CALEXPRRBTNLIST.add(CBEXPEE);

		for (int i = 0; i < CALEXPRRBTNLIST.size(); i++) {

			JP3.add(CALEXPRRBTNLIST.get(i));
		}

		JP3.setPreferredSize(new Dimension(400, 400));

		LeftJmain.add(JP3);

		LeftJmain.add(LeftJsub);

		this.add(LeftJmain, BL.EAST);

		/////////////////////////// FRAME SETTINGS ////////////////////////////

		// this.getContentPane().setBackground(Color.white);

		this.setTitle("Calculator");

		this.setSize(950, 600);

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);

		///////////////////// ADD LABEL TO FRAME ///////////////////////////////////

		CLBL.setText("0");

		this.getContentPane().add(CLBL, BL.NORTH);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				new BaseWindow();

			}
		});

	}

	public void showbtn_prsd(String btn_val) {
		// TODO Auto-generated method stub

		System.out.println(curr_wrd);
		
		curr_wrd = btn_val;
		
		LblData.add(curr_wrd);
		if (curr_wrd == "CLR") {

			LblData.clear();
			CLBL.setText("");
			getbtnText = "";
			curr_cntr = 0;
			ress= 0.0;
			
		} 
		
		else if (curr_wrd == "=") {
			
			String num1_str = "", num2_str = "", cnrt_res = "";
			
			getbtnText += curr_wrd;
			// CLBL.setText("");
			// System.out.println(getbtnText +" curr_cntr "+ curr_cntr);
			CLBL.setText(getbtnText);

			for (int i = curr_cntr; i < LblData.size(); i++) {

				// System.out.println(LblData.get(i));
				if (LblData.get(i).trim().equals("-")) {

					int curr_minus_symb_pos = LblData.lastIndexOf("-");

					//System.out.println("Minus position found at : " + curr_minus_symb_pos);

					int k = curr_minus_symb_pos - 1;
					int l = curr_minus_symb_pos + 1;
					// get the string found till the operator found and convert into integer
					if (curr_cntr == 0) {

						for (int j = curr_cntr; j <= k; j++) {

							num1_str += LblData.get(j);
						}

						for (int jj = l; jj < LblData.size() - 1; jj++) {
							num2_str += LblData.get(jj);
						}

					} else {

						//System.out.println("Curr_counter =" + curr_cntr + " K = " + k);
						for (int j = curr_cntr; j <= k; j++) {

							//System.out.println("J= " + j + LblData.get(j));
							num1_str += LblData.get(j);

						}
						for (int jj = l; jj < LblData.size() - 1; jj++) {
							num2_str += LblData.get(jj);
						}

					}

					//System.out.println("First string " + num1_str + " , Second String  " + num2_str );

					ress = Double.parseDouble(num1_str) - Double.parseDouble(num2_str);  
					
					//cnrt_res = String.format("%10.2f",ress);
					
					decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
					
					if(decimal_part>0) {
						
						cnrt_res = String.format("%.2f",ress);
						
						//System.out.println(decimal_part);
						
						getbtnText += cnrt_res;
					}
					else {

						cnrt_res = String.format("%.0f",ress);
						
						//System.out.println(decimal_part);
						
						getbtnText += cnrt_res;
						
					}

					CLBL.setText(getbtnText);

					LblData.add(cnrt_res);

					curr_cntr = LblData.size() - 1;

				}

				else if (LblData.get(i).trim().equals("+")) {

					int curr_minus_symb_pos = LblData.lastIndexOf("+");

					//System.out.println("Add position found at : " + curr_minus_symb_pos);

					int k = curr_minus_symb_pos - 1;
					int l = curr_minus_symb_pos + 1;
					// get the string found till the operator found and convert into integer
					if (curr_cntr == 0) {

						for (int j = curr_cntr; j <= k; j++) {

							num1_str += LblData.get(j);
						}

						for (int jj = l; jj < LblData.size() - 1; jj++) {
							num2_str += LblData.get(jj);
						}

					} else {

						//System.out.println("Curr_counter =" + curr_cntr + " K = " + k);
						for (int j = curr_cntr; j <= k; j++) {
//
							//System.out.println("J= " + j + LblData.get(j));
							num1_str += LblData.get(j);

						}
						for (int jj = l; jj < LblData.size() - 1; jj++) {
							num2_str += LblData.get(jj);
						}

					}

					//System.out.println("First string " + num1_str + " , Second String  " + num2_str + " Curr_counter "
							///+ curr_cntr);

					ress = Double.parseDouble(num1_str) + Double.parseDouble(num2_str);  
					
					//cnrt_res = String.format("%10.2f",ress);
					
					decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
					
					if(decimal_part>0) {
						
						cnrt_res = String.format("%.2f",ress);
						
						//System.out.println(decimal_part);
						
						getbtnText += cnrt_res;
					}
					else {

						cnrt_res = String.format("%.0f",ress);
						
						//System.out.println(decimal_part);
						
						getbtnText += cnrt_res;
						
					}

					CLBL.setText(getbtnText);

					LblData.add(cnrt_res);

					curr_cntr = LblData.size() - 1;

				}

				else if (LblData.get(i).trim().equals("*")) {

					int curr_minus_symb_pos = LblData.lastIndexOf("*");

					//System.out.println("Add position found at : " + curr_minus_symb_pos);

					int k = curr_minus_symb_pos - 1;
					int l = curr_minus_symb_pos + 1;
					// get the string found till the operator found and convert into integer
					if (curr_cntr == 0) {

						for (int j = curr_cntr; j <= k; j++) {

							num1_str += LblData.get(j);
						}

						for (int jj = l; jj < LblData.size() - 1; jj++) {
							num2_str += LblData.get(jj);
						}

					} else {

						//System.out.println("Curr_counter =" + curr_cntr + " K = " + k);
						for (int j = curr_cntr; j <= k; j++) {

							//System.out.println("J= " + j + LblData.get(j));
							num1_str += LblData.get(j);

						}
						for (int jj = l; jj < LblData.size() - 1; jj++) {
							num2_str += LblData.get(jj);
						}

					}

					System.out.println("First string " + num1_str + " , Second String  " + num2_str + " Curr_counter "
					+ curr_cntr);

					ress = Double.parseDouble(num1_str) * Double.parseDouble(num2_str);  
					
					//cnrt_res = String.format("%10.2f",ress);
					
					decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
					
					if(decimal_part>0) {
						
						cnrt_res = String.format("%.2f",ress);
						
						//System.out.println(decimal_part);
						
						getbtnText += cnrt_res;
					}
					else {

						cnrt_res = String.format("%.0f",ress);
						
						//System.out.println(decimal_part);
						
						getbtnText += cnrt_res;
						
					}
					
					System.out.println(getbtnText + "    "+cnrt_res);
					
					CLBL.setText(getbtnText);

					LblData.add(cnrt_res);

					curr_cntr = LblData.size() - 1;

				}

				else if (LblData.get(i).trim().equals("÷")) {

					int curr_minus_symb_pos = LblData.lastIndexOf("÷");

					//System.out.println("Add position found at : " + curr_minus_symb_pos);

					int k = curr_minus_symb_pos - 1;
					int l = curr_minus_symb_pos + 1;
					// get the string found till the operator found and convert into integer
					if (curr_cntr == 0) {

						for (int j = curr_cntr; j <= k; j++) {

							num1_str += LblData.get(j);
						}

						for (int jj = l; jj < LblData.size() - 1; jj++) {
							System.out.println("Entered 0");
							num2_str += LblData.get(jj);
						}

					} else {

						//System.out.println("Curr_counter =" + curr_cntr + " K = " + k);
						for (int j = curr_cntr; j <= k; j++) {

							System.out.println("J= " + LblData.get(j));
							num1_str += LblData.get(j);

						}
						for (int jj = l; jj < LblData.size() - 1; jj++) {
							System.out.println("J= " + LblData.get(jj));
							num2_str += LblData.get(jj);
						}

					}

					//System.out.println("First string " + num1_str + " , Second String  " + num2_str + " Curr_counter "
							//+ curr_cntr);
					if(Double.parseDouble(num2_str)>0) {
					ress = Double.parseDouble(num1_str) / Double.parseDouble(num2_str);  
					
					//cnrt_res = String.format("%10.2f",ress);
					
					decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
					
					if(decimal_part>0) {
						
						cnrt_res = String.format("%.2f",ress);
						
						//System.out.println(decimal_part);
						
						getbtnText += cnrt_res;
					}
					else {

						cnrt_res = String.format("%.0f",ress);
						
						//System.out.println(decimal_part);
						
						getbtnText += cnrt_res;
						
					}

					CLBL.setText(getbtnText);

					LblData.add(cnrt_res);

					curr_cntr = LblData.size() - 1;
					}
					else {
						
						LblData.clear();	
						getbtnText = "";
						CLBL.setText("Cannot divide by zero");
						
					}
					

				}

				else if (LblData.get(i).trim().equals("%")) {

					int curr_minus_symb_pos = LblData.lastIndexOf("%");

					//System.out.println("Add position found at : " + curr_minus_symb_pos);

					int k = curr_minus_symb_pos - 1;
					int l = curr_minus_symb_pos + 1;
					// get the string found till the operator found and convert into integer
					if (curr_cntr == 0) {

						for (int j = curr_cntr; j <= k; j++) {

							num1_str += LblData.get(j);
						}

						for (int jj = l; jj < LblData.size() - 1; jj++) {
							num2_str += LblData.get(jj);
						}

					} else {

						System.out.println("Curr_counter =" + curr_cntr + " K = " + k);
						for (int j = curr_cntr; j <= k; j++) {

							System.out.println("J= " + j + LblData.get(j));
							num1_str += LblData.get(j);

						}
						for (int jj = l; jj < LblData.size() - 1; jj++) {
							num2_str += LblData.get(jj);
						}

					}

					//System.out.println("First string " + num1_str + " , Second String  " + num2_str + " Curr_counter "
						//	+ curr_cntr);

					ress = Double.parseDouble(num1_str) % Double.parseDouble(num2_str);  
					
					//cnrt_res = String.format("%10.2f",ress);
					
					decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
					
					if(decimal_part>0) {
						
						cnrt_res = String.format("%.2f",ress);
						
						//System.out.println(decimal_part);
						
						getbtnText += cnrt_res;
					}
					else {

						cnrt_res = String.format("%.0f",ress);
						
						//System.out.println(decimal_part);
						
						getbtnText += cnrt_res;
						
					}

					CLBL.setText(getbtnText);

					LblData.add(cnrt_res);

					curr_cntr = LblData.size() - 1;

				}
			
			
			else if (LblData.get(i).trim().equals("X^2"))
			{
				int curr_minus_symb_pos = LblData.lastIndexOf("X^2");
				
				if (ress > 0 || ress <0)
					
				{
					LblData.remove(curr_minus_symb_pos);
					//LblData.remove(curr_minus_symb_pos-1);
					
					getbtnText ="";
					
					ress = Math.pow(ress, 2);
					
					decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
					
					if (decimal_part >0) {
					
						getbtnText = String.format("%.2f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
					else {
						
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
				}
				
				
				else
				{
					
				LblData.remove(curr_minus_symb_pos);
				
				System.out.println("Nothing " +getbtnText.substring(0, curr_minus_symb_pos));
				
				ress = Math.pow(Double.parseDouble(getbtnText.substring(0, curr_minus_symb_pos)), 2);
				
				decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
				
				if (decimal_part >0) {
				
					getbtnText = String.format("%.2f",ress);
					
					LblData.add(getbtnText);
					
					CLBL.setText(getbtnText);
					
					curr_cntr = LblData.size() - 1;
					
				}
				
				else {
					
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
						}
				
					}
				}
				
			else if (LblData.get(i).trim().equals("X^3"))
			{
				int curr_minus_symb_pos = LblData.lastIndexOf("X^3");
				
				if (ress > 0 || ress <0)
					
				{
					LblData.remove(curr_minus_symb_pos);
					//LblData.remove(curr_minus_symb_pos-1);
					
					getbtnText ="";
					
					ress = Math.pow(ress, 3);
					
					decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
					
					if (decimal_part >0) {
					
						getbtnText = String.format("%.2f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
					else {
						
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
				}
				
				
				else
				{
					
				LblData.remove(curr_minus_symb_pos);
				
				System.out.println(getbtnText.substring(0, curr_minus_symb_pos));
				
				ress = Math.pow(Double.parseDouble(getbtnText.substring(0, curr_minus_symb_pos)), 3);
				
				decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
				
				if (decimal_part >0) {
				
					getbtnText = String.format("%.2f",ress);
					
					LblData.add(getbtnText);
					
					CLBL.setText(getbtnText);
					
					curr_cntr = LblData.size() - 1;
					
				}
				
				else {
					
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
						}
					}
				}
				
			else if (LblData.get(i).trim().equals("1/X"))
			{
				int curr_minus_symb_pos = LblData.lastIndexOf("1/X");
				
				if (ress > 0 || ress <0)
					
				{
					LblData.remove(curr_minus_symb_pos);
					//LblData.remove(curr_minus_symb_pos-1);
					
					getbtnText ="";
					
					ress = (1/ress);
					
					decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
					
					if (decimal_part >0) {
					
						getbtnText = String.format("%.2f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
					else {
						
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
				}
				
				
				else
				{
					
				LblData.remove(curr_minus_symb_pos);
				
				System.out.println(getbtnText.substring(0, curr_minus_symb_pos));
				
				ress = 1/(Double.parseDouble(getbtnText.substring(0, curr_minus_symb_pos)));
				
				decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
				
				if (decimal_part >0) {
				
					getbtnText = String.format("%.2f",ress);
					
					LblData.add(getbtnText);
					
					CLBL.setText(getbtnText);
					
					curr_cntr = LblData.size() - 1;
					
				}
				
				else {
					
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
						}
					}
				}
				
			else if (LblData.get(i).trim().equals("sin X"))
			{
				int curr_minus_symb_pos = LblData.lastIndexOf("sin X");
				
				if (ress > 0 || ress <0)
					
				{
					LblData.remove(curr_minus_symb_pos);
					//LblData.remove(curr_minus_symb_pos-1);
					
					getbtnText ="";
					
					ress = Math.sin(ress);
					
					decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
					
					if (decimal_part >0) {
					
						getbtnText = String.format("%.2f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
					else {
						
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
				}
				
				
				else
				{
					
				LblData.remove(curr_minus_symb_pos);
				
				System.out.println(getbtnText.substring(0, curr_minus_symb_pos));
				
				ress = Math.sin(Double.parseDouble(getbtnText.substring(0, curr_minus_symb_pos)));
				
				decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
				
				if (decimal_part >0) {
				
					getbtnText = String.format("%.2f",ress);
					
					LblData.add(getbtnText);
					
					CLBL.setText(getbtnText);
					
					curr_cntr = LblData.size() - 1;
					
				}
				
				else {
					
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
						}
					}
				}
			else if (LblData.get(i).trim().equals("cos X"))
			{
				int curr_minus_symb_pos = LblData.lastIndexOf("cos X");
				
				if (ress > 0 || ress <0)
					
				{
					LblData.remove(curr_minus_symb_pos);
					//LblData.remove(curr_minus_symb_pos-1);
					
					getbtnText ="";
					
					ress = Math.cos(ress);
					
					decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
					
					if (decimal_part >0) {
					
						getbtnText = String.format("%.2f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
					else {
						
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
				}
				
				
				else
				{
					
				LblData.remove(curr_minus_symb_pos);
				
				System.out.println(getbtnText.substring(0, curr_minus_symb_pos));
				
				ress = Math.cos(Double.parseDouble(getbtnText.substring(0, curr_minus_symb_pos)));
				
				decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
				
				if (decimal_part >0) {
				
					getbtnText = String.format("%.2f",ress);
					
					LblData.add(getbtnText);
					
					CLBL.setText(getbtnText);
					
					curr_cntr = LblData.size() - 1;
					
				}
				
				else {
					
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
						}
					}
				}
			else if (LblData.get(i).trim().equals("tan X"))
			{
				int curr_minus_symb_pos = LblData.lastIndexOf("tan X");
				
				if (ress > 0 || ress <0)
					
				{
					LblData.remove(curr_minus_symb_pos);
					//LblData.remove(curr_minus_symb_pos-1);
					
					getbtnText ="";
					
					ress = Math.tan(ress);
					
					decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
					
					if (decimal_part >0) {
					
						getbtnText = String.format("%.2f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
					else {
						
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
				}
				
				
				else
				{
					
				LblData.remove(curr_minus_symb_pos);
				
				System.out.println(getbtnText.substring(0, curr_minus_symb_pos));
				
				ress = Math.tan(Double.parseDouble(getbtnText.substring(0, curr_minus_symb_pos)));
				
				decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
				
				if (decimal_part >0) {
				
					getbtnText = String.format("%.2f",ress);
					
					LblData.add(getbtnText);
					
					CLBL.setText(getbtnText);
					
					curr_cntr = LblData.size() - 1;
					
				}
				
				else {
					
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
						}
					}
				}
			else if (LblData.get(i).trim().equals("e ^ X"))
			{
				int curr_minus_symb_pos = LblData.lastIndexOf("e ^ X");
				
				if (ress > 0 || ress <0)
					
				{
					LblData.remove(curr_minus_symb_pos);
					//LblData.remove(curr_minus_symb_pos-1);
					
					getbtnText ="";
					
					ress = Math.pow(2.71,ress);
					
					decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
					
					if (decimal_part >0) {
					
						getbtnText = String.format("%.2f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
					else {
						
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
				}
				
				
				else
				{
					
				LblData.remove(curr_minus_symb_pos);
				
				System.out.println(getbtnText.substring(0, curr_minus_symb_pos));
				
				ress = Math.pow(2.71,Double.parseDouble(getbtnText.substring(0, curr_minus_symb_pos)));
				
				decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
				
				if (decimal_part >0) {
				
					getbtnText = String.format("%.2f",ress);
					
					LblData.add(getbtnText);
					
					CLBL.setText(getbtnText);
					
					curr_cntr = LblData.size() - 1;
					
				}
				
				else {
					
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
						}
					}
				}
			else if (LblData.get(i).trim().equals("ln X"))
			{
				int curr_minus_symb_pos = LblData.lastIndexOf("ln X");
				
				if (ress > 0 || ress <0)
					
				{
					LblData.remove(curr_minus_symb_pos);
					//LblData.remove(curr_minus_symb_pos-1);
					
					getbtnText ="";
					
					ress = Math.log(ress);
					
					decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
					
					if (decimal_part >0) {
					
						getbtnText = String.format("%.2f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
					else {
						
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
				}
				
				
				else
				{
					
				LblData.remove(curr_minus_symb_pos);
				
				System.out.println(getbtnText.substring(0, curr_minus_symb_pos));
				
				ress = Math.log(Double.parseDouble(getbtnText.substring(0, curr_minus_symb_pos)));
				
				decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
				
				if (decimal_part >0) {
				
					getbtnText = String.format("%.2f",ress);
					
					LblData.add(getbtnText);
					
					CLBL.setText(getbtnText);
					
					curr_cntr = LblData.size() - 1;
					
				}
				
				else {
					
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
						}
					}
				}
		else if (LblData.get(i).trim().equals("SQRT"))
			{
				int curr_minus_symb_pos = LblData.lastIndexOf("SQRT");
				
				if (ress > 0 || ress <0)
					
				{
					LblData.remove(curr_minus_symb_pos);
					//LblData.remove(curr_minus_symb_pos-1);
					
					getbtnText ="";
					
					ress = Math.sqrt(ress);
					
					decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
					
					if (decimal_part >0) {
					
						getbtnText = String.format("%.2f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
					else {
						
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
					}
					
				}
				
				
				else
				{
					
				LblData.remove(curr_minus_symb_pos);
				
				System.out.println(getbtnText.substring(0, curr_minus_symb_pos));
				
				ress = Math.sqrt(Double.parseDouble(getbtnText.substring(0, curr_minus_symb_pos)));
				
				decimal_part = Double.parseDouble(ress.toString().split("\\.")[1]);
				
				if (decimal_part >0) {
				
					getbtnText = String.format("%.2f",ress);
					
					LblData.add(getbtnText);
					
					CLBL.setText(getbtnText);
					
					curr_cntr = LblData.size() - 1;
					
				}
				
				else {
					
						getbtnText = String.format("%.0f",ress);
						
						LblData.add(getbtnText);
						
						CLBL.setText(getbtnText);
						
						curr_cntr = LblData.size() - 1;
						}
					}
				}
		else if (LblData.get(i).trim().equals("π"))
			{
				int curr_minus_symb_pos = LblData.lastIndexOf("π");

			LblData.remove(curr_minus_symb_pos);
			//LblData.remove(curr_minus_symb_pos-1);
			
			getbtnText ="";
				
				ress = Math.PI;
				
					getbtnText = String.format("%.4f",ress);
					
					LblData.add(getbtnText);
					
					CLBL.setText(getbtnText);
					
					//curr_cntr = LblData.size() - 1;
			}
		else if (LblData.get(i).trim().equals("π"))
			{
				int curr_minus_symb_pos = LblData.lastIndexOf("π");

			LblData.remove(curr_minus_symb_pos);
			//LblData.remove(curr_minus_symb_pos-1);
			
			getbtnText ="";
				
				ress = Math.PI;
				
					getbtnText = String.format("%.4f",ress);
					
					LblData.add(getbtnText);
					
					CLBL.setText(getbtnText);
					
					//curr_cntr = LblData.size() - 1;
			}
			else if (LblData.get(i).trim().equals("e"))
			{
				int curr_minus_symb_pos = LblData.lastIndexOf("e");

			LblData.remove(curr_minus_symb_pos);
			//LblData.remove(curr_minus_symb_pos-1);
			
			getbtnText ="";
				
				ress = Math.PI;
				
					getbtnText = String.format("%.4f",ress);
					
					LblData.add(getbtnText);
					
					CLBL.setText(getbtnText);
					
					//curr_cntr = LblData.size() - 1;
			}
				
			}
				
		}
		else {
			getbtnText += curr_wrd;
			//System.out.println(getbtnText);
			CLBL.setText(getbtnText);
		}

	}

}
