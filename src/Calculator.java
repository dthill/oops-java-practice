import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		new Calculator().calculate();

	}

	void calculate(){

	}

	double getOperant(){
		double operant = 0.0;
		while(true){
			try {
				operant = scanner.nextDouble();
				break;
			} catch (InputMismatchException exception) {
				System.out.println("Please provide a valid operant");
			} 
		}
		return operant;
	}

	
}
