import java.util.Scanner;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SystemSolver {

JFrame frame;
JButton solve;
JButton reset;
JPanel centerPanel;
JPanel southPanel;
JLabel answer;
boolean equationsAreParallel = false;
boolean yAsymptotesAreEqual = false;
JTextField aField;
JTextField bField;
JTextField cField;
JTextField dField;
JTextField eField;
JTextField fField;
JLabel x1Field;
JLabel x2Field;
JLabel x3Field;
JLabel x4Field;
JLabel plus;
JLabel plus2;
JLabel equals;
JLabel equals2;
double a, b, c, d, e, f;
double aOld, bOld, cOld, dOld, eOld, fOld;
double xSolution, ySolution;
double aS, bS, cS, dS, eS, fS;
double x1, y1, x2 ,y2;
boolean solutionFound = false;


	public static void main(String[] args ) {
		SystemSolver mySystemSolver = new SystemSolver();
		mySystemSolver.launchGUI();
	} // close main

	public void launchGUI() {
		frame = new JFrame("System Solver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		solve = new JButton("Solve");
		solve.addActionListener(new MySolveListener());
		reset = new JButton("Reset");
		reset.addActionListener(new MyResetListener());
		southPanel = new JPanel();
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		centerPanel = new JPanel();

		southPanel.add(solve);
		southPanel.add(reset);
		background.add(BorderLayout.SOUTH, southPanel);

		GridLayout eqnGrid = new GridLayout(2,3);
		eqnGrid.setVgap(1); // vertical gap
		eqnGrid.setHgap(1); // horizontile gap
		centerPanel = new JPanel(eqnGrid);
		background.add(BorderLayout.NORTH, centerPanel);

		aField = new JTextField(20);
		x1Field = new JLabel("X");
		plus = new JLabel("+");
		centerPanel.add(aField);
		centerPanel.add(x1Field);
		centerPanel.add(plus);

		bField = new JTextField(20);
		x2Field = new JLabel("Y");
		equals = new JLabel("=");
		centerPanel.add(bField);
		centerPanel.add(x2Field);
		centerPanel.add(equals);

		cField = new JTextField(20);
		centerPanel.add(cField);

		dField = new JTextField(20);
		x3Field = new JLabel("X");
		plus2 = new JLabel("+");
		centerPanel.add(dField);
		centerPanel.add(x3Field);
		centerPanel.add(plus2);

		eField = new JTextField(20);
		x4Field = new JLabel("Y");
		equals2 = new JLabel("=");
		centerPanel.add(eField);
		centerPanel.add(x4Field);
		centerPanel.add(equals2);

		fField = new JTextField(20);
		centerPanel.add(fField);

		answer = new JLabel();
		answer.setText("Please Enter an Equation.");
		background.add(BorderLayout.CENTER, answer);

		frame.getContentPane().add(background);
		frame.setSize(300,300);
		frame.setVisible(true);
	}

	public void setValues() {
		String textA = aField.getText();
		a = Double.parseDouble(textA);
		String textB = bField.getText();
		b = Double.parseDouble(textB);
		String textC = cField.getText();
		c = Double.parseDouble(textC);
		String textD = dField.getText();
		d = Double.parseDouble(textD);
		String textE = eField.getText();
		e = Double.parseDouble(textE);
		String textF = fField.getText();
		f = Double.parseDouble(textF);
	}

	public void resetValues() {
		a = b = c = d = e = f = 0;
		aOld = bOld = cOld = dOld = eOld = fOld = 0;
		aField.setText("");
		bField.setText("");
		cField.setText("");
		dField.setText("");
		eField.setText("");
		fField.setText("");
		setXSolution(0);
		setYSolution(0);
		solutionFound = false;
	}

	public void saveValues() {
		aOld = a;
		bOld = b;
		cOld = c;
		dOld = d;
		eOld = e;
		fOld = f;
	}

	public boolean checkIfParallelSame() {
		if(a == d && b == e && c == f) {
			return true;
		}
		else if(a/d == b/e && b/e == c/f) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean checkIfParallelDifferent() {
		if(a == d && b == e && c != f) {
			return true;
		}
		else if(a/d == b/e && c != f) {
			return true;
		}
		else {
			return false;
		}
	}

	public void scalarRowProduct(double scalar, int row) {
		if(row == 1) {
			a = scalar * a;
			b = scalar * b;
			c = scalar * c;
		}
		else if(row == 2) {
			d = scalar * d;
			e = scalar * e;
			f = scalar * f;
		}
		else{}
	}

	public void rowSum(int replaceRow) {
		if(replaceRow == 1) {
			a = a + d;
			b = b + e;
			c = c + f;
		}
		else if(replaceRow == 2) {
			d = a + d;
			e = b + e;
			f = c + f;
		}
		else{}
	}

	public void setXSolution(double xSolution) {
		if(xSolution == 0) {
			this.xSolution = Math.abs(xSolution);
		}
		else {
			this.xSolution = xSolution;
		}
		solutionFound = true;
	}

	public double getXSolution() {
		return this.xSolution;
	}

	public void setYSolution(double ySolution) {
		if(ySolution == 0) {
			this.ySolution = Math.abs(ySolution);
		}
		else {
			this.ySolution = ySolution;
		}
		solutionFound = true;
	}

	public double getYSolution() {
		return this.ySolution;
	}

	public void solve() {

		setValues();

		if(checkIfParallelSame()) {
			equationsAreParallel = true;
			yAsymptotesAreEqual = true;
		}	else if(checkIfParallelDifferent()) {
			equationsAreParallel = true;
			yAsymptotesAreEqual = false;
		} else {
			equationsAreParallel = false;
			yAsymptotesAreEqual = false;
		}

		saveValues();
		scalarRowProduct(d * -1, 1);
		scalarRowProduct(aOld, 2);
		rowSum(2);
		saveValues();
		scalarRowProduct((1/e), 2);
		saveValues();
		setYSolution(f);
		setXSolution((c-(b*f))/a);
	}

	class MySolveListener implements ActionListener{
		public void actionPerformed(ActionEvent ev) {
			try {
				solve();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			if((equationsAreParallel == false) && (yAsymptotesAreEqual == false)) {
				if(solutionFound) {
					answer.setText("There is an answer! X = " + getXSolution() + ", Y = " + getYSolution() + ".");
				} else	{
					answer.setText("Please Enter an Equation.");
				}
			} else if((equationsAreParallel == true) && (yAsymptotesAreEqual == false)) {
				answer.setText("There are no answers!");
			}	else if((equationsAreParallel == true) && (yAsymptotesAreEqual == true)) {
				answer.setText("There are infinitely many answers!");
			}
			frame.repaint();
		}
	}
	class MyResetListener implements ActionListener{
		public void actionPerformed(ActionEvent ev) {
			resetValues();
			answer.setText("Please Enter an Equation.");
			frame.repaint();
		}
	}
} // close class
