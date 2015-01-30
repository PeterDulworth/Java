public class equation {
	public double a, b, c, d, e, f;
	public double aOld, bOld, cOld, dOld, eOld, fOld;
	private double xSolution, ySolution;
	public double aS, bS, cS, dS, eS, fS;
	public double x1, y1, x2 ,y2;
	private int rows, columns;

	//private static final int PROTEINS = 0;

	public static void equation(int numbEquations) {
		if(numbEquations > 1) {
			this.rows = numbEquations;
			this.columns = numbEquations;
		}
	}
	public void setXSolution(double xSolution) {
		if(xSolution == 0) {
			this.xSolution = Math.abs(xSolution);
		}
		else {
			this.xSolution = xSolution;
		}
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
	}	
	public double getYSolution() {
		return this.ySolution;
	}
	public void newLine(int numbLines) {
		for (int i = 0; i < numbLines; i++) {
			System.out.println("");
		}
	}	
	public void printEquation() {
		newLine(1);
		System.out.println(((a >= 0) ? ""  : "- ") + Math.abs(a) + "x " + ((b > 0) ? "+ " : "- ") + Math.abs(b) + "y = " + ((c > 0) ? "" : "- ") + Math.abs(c));
		System.out.println(((d >= 0) ? ""  : "- ") + Math.abs(d) + "x " + ((e > 0) ? "+ " : "- ") + Math.abs(e) + "y = " + ((f > 0) ? "" : "- ") + Math.abs(f));
		newLine(1);
	}
	public void saveValues() {
		aOld = a;
		bOld = b;
		cOld = c;
		dOld = d;
		eOld = e;
		fOld = f;
	}
	public void saveRowValues(int rowNumb) {
		if(rowNumb == 1) {
			aOld = a;
			bOld = b;
			cOld = c;
		}
		else if(rowNumb == 2) {
			dOld = d;
			eOld = e;
			fOld = f;
		}	
		else{}
	}
	public void printValues() {
			System.out.println(a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ".");
	}
	public void printValues(String numbLines) {
		if(numbLines == "MULTILINE") {
			System.out.println(a + ", " + b + ", " + c);
			System.out.println(d + ", " + e + ", " + f);
		}
		else {
			System.out.println(a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ".");
		}
	}
	public void printOldValues() {
		System.out.println(aOld + ", " + bOld + ", " + cOld + ", " + dOld + ", " + eOld + ", " + fOld + ".");
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
	public void swapRows() {
		saveValues();

		a = d;
		b = e;
		c = f;

		d = aOld;
		e = bOld;
		f = cOld;
	}
	// public void graph() {
	// 	for(int i = 0; i < 10; i ++) {
	// 		System.out.println()
	// 	}
	// }
}