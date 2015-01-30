import java.util.Scanner;
import java.lang.*;

public class SystemSolver {

	public static void main(String[] args ) {

		Scanner input = new Scanner(System.in);
		equation eqn = new equation();

		eqn.newLine(1);
		System.out.println("**************************************************************************");
		eqn.newLine(1);
		System.out.println("Please enter a system of two equations with the following format:");
		eqn.newLine(1);
		System.out.println("aX + bY = c");
		System.out.println("dX + eY = f");
		eqn.newLine(1);

		System.out.print("a = ");
		eqn.a = input.nextDouble();
		System.out.print("b = ");
		eqn.b = input.nextDouble();
		System.out.print("c = ");
		eqn.c = input.nextDouble();
		
		System.out.print("d = ");
		eqn.d = input.nextDouble();
		System.out.print("e = ");
		eqn.e = input.nextDouble();
		System.out.print("f = ");
		eqn.f = input.nextDouble();

		eqn.newLine(1);
		System.out.println("You have entered the following system:");
		eqn.printEquation();

		eqn.saveValues();

		if(eqn.checkIfParallelSame()) {
			System.out.println("************************************************************************************************************");
			System.out.println("*                                                                                                          *");
			System.out.println("* Equations 1 and 2 are scalar multiples of each other thus there are infinately many solutions and x = y. *");
			System.out.println("*                                                                                                          *");
			System.out.println("************************************************************************************************************");
			eqn.newLine(1);
			System.exit(0);
		}

		else if(eqn.checkIfParallelDifferent()) {
			System.out.println("*********************************************************************************************");
			System.out.println("*                                                                                           *");
			System.out.println("* Equations 1 and 2 are parallel but have different y-intercepts and thus have no solutions *");
			System.out.println("*                                                                                           *");
			System.out.println("*********************************************************************************************");
			eqn.newLine(1);
			System.exit(0);
		}
		
		eqn.scalarRowProduct(eqn.d * -1, 1);
		eqn.scalarRowProduct(eqn.aOld, 2);
		System.out.println("Multiplying equation 1 by " + eqn.d + " and equation 2 by " + eqn.aOld + " we get:");
		eqn.printEquation();

		eqn.rowSum(2);
		System.out.println("Replacing equation 2 with the sum of equation 1 and equation 2 we get:");
		eqn.printEquation();

		eqn.saveValues();
		
		eqn.scalarRowProduct((1/eqn.e), 2);
		System.out.println("Solving equation 2 for Y we get:");
		eqn.printEquation();

		eqn.saveValues();
		eqn.setYSolution(eqn.f);
		eqn.setXSolution((eqn.c-(eqn.b*eqn.f))/eqn.a);

		System.out.println("*********************************************************************************************");
		System.out.println("*                                                                                           *");
		System.out.println("*                                   Equation Solved!                                        *");
		System.out.println("*                                       X = " + eqn.getXSolution() + "                                            *");
		System.out.println("*                                       Y = " + eqn.getYSolution() + "                                             *");
		System.out.println("*                                                                                           *");
		System.out.println("*********************************************************************************************");
		eqn.newLine(1);
	}
}
