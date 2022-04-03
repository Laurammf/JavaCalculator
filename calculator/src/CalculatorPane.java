
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;

class CalculatorPane extends VBox {
	private Button cButton, sieveButton, euclidButton, nprimesButton, eulerButton, infoButton;
	private Button factorButton, sigmaButton, congruentButton, partitionButton, hButton;
	private TextField input1, input2, input3, input4;
	private Label resultLabel, infoLabel, aLabel, bLabel, cLabel, dLabel, initialLabel, hLabel;
	private ArrayList<String> operations;

	public CalculatorPane() {
		operations = new ArrayList<String>();
		// input fields
		input1 = new TextField();
		input1.setPrefWidth(50);
		input1.setAlignment(Pos.CENTER);

		input2 = new TextField();
		input2.setPrefWidth(50);
		input2.setAlignment(Pos.CENTER);

		input3 = new TextField();
		input3.setPrefWidth(50);
		input3.setAlignment(Pos.CENTER);

		input4 = new TextField();
		input4.setPrefWidth(50);
		input4.setAlignment(Pos.CENTER);

		// HBox to explain input fields
		aLabel = new Label("a");
		aLabel.setAlignment(Pos.CENTER);
		bLabel = new Label("b");
		bLabel.setAlignment(Pos.CENTER);
		cLabel = new Label("c");
		cLabel.setAlignment(Pos.CENTER);
		dLabel = new Label("d");
		dLabel.setAlignment(Pos.CENTER);

		HBox line0 = new HBox(aLabel, bLabel, cLabel, dLabel);
		line0.setSpacing(60);
		line0.setAlignment(Pos.CENTER);

		// Hbox to organize inputs
		HBox line1 = new HBox(input1, input2, input3, input4);
		line1.setSpacing(20);
		line1.setAlignment(Pos.CENTER);

		// Hbox for result
		resultLabel = new Label("---");
		resultLabel.setAlignment(Pos.CENTER);

		HBox line2 = new HBox(resultLabel);
		line2.setSpacing(20);
		line2.setAlignment(Pos.CENTER);

		// Hbox to organize calculation buttons
		sieveButton = new Button("sieve of Eratosthenes");
		sieveButton.setOnAction(this::sieve);

		euclidButton = new Button("Euclid algorithm");
		euclidButton.setOnAction(this::euclid);

		HBox line3 = new HBox(sieveButton, euclidButton);
		line3.setSpacing(10);
		line3.setAlignment(Pos.CENTER);

		nprimesButton = new Button("number of primes");
		nprimesButton.setOnAction(this::nPrimes);

		eulerButton = new Button("Euler's totient");
		eulerButton.setOnAction(this::eulerTot);

		HBox line4 = new HBox(nprimesButton, eulerButton);
		line4.setSpacing(10);
		line4.setAlignment(Pos.CENTER);

		factorButton = new Button("prime factorization");
		factorButton.setOnAction(this::primeFact);

		sigmaButton = new Button("sigma(a,b) function");
		sigmaButton.setOnAction(this::sigma);

		HBox line5 = new HBox(factorButton, sigmaButton);
		line5.setSpacing(10);
		line5.setAlignment(Pos.CENTER);

		congruentButton = new Button("linear congruential generator");
		congruentButton.setOnAction(this::LCG);

		partitionButton = new Button("partition function");
		partitionButton.setOnAction(this::partition);

		HBox line6 = new HBox(congruentButton, partitionButton);
		line6.setSpacing(10);
		line6.setAlignment(Pos.CENTER);

//Hbox to organize c and equal buttons
		cButton = new Button(" C ");
		cButton.setOnAction(this::reset);

		hButton = new Button("history of operations");
		hButton.setOnAction(this::history);

		HBox line7 = new HBox(cButton, hButton);
		line7.setSpacing(10);
		line7.setAlignment(Pos.CENTER);

		infoButton = new Button("click for information");
		infoButton.setOnAction(this::infoWindow);

		HBox line8 = new HBox(infoButton);
		line8.setSpacing(10);
		line8.setAlignment(Pos.CENTER);

		setSpacing(20);
		setAlignment(Pos.CENTER);
		getChildren().addAll(line0, line1, line2, line3, line4, line5, line6, line7, line8);

	}

	public void sieve(ActionEvent event) {
		String userInput = input1.getText();
		String str = new String();
		if (userInput.isEmpty()) {
			resultLabel.setText("Please insert a number");
		}
		if (userInput.startsWith(" ")) {
			resultLabel.setText("Please insert a number");
		}
		Scanner scan = new Scanner(userInput);
		int n1;
		if (scan.hasNextInt() && (n1 = Integer.parseInt(input1.getText())) > 1) {
			boolean[] A = new boolean[n1];
			ArrayList<Integer> output = new ArrayList<Integer>();
			for (int i = 0; i < A.length; i++) {
				A[i] = true;
			}
			for (int j = 2; j <= n1; j++) {
				if (SupportMethods.isPrime(j)) {
					output.add(j);
				}
			}

			for (int m = 0; m < output.size(); m++) {
				str = str + output.get(m) + "; ";
			}
			resultLabel.setText(str);
			String sieveString = "N: Sieve of Eratosthenes, P: " + Integer.parseInt(input1.getText()) + ", R: "
					+ resultLabel.getText() + "\r\n";
			operations.add(sieveString);

		} else {
			resultLabel.setText("Please insert an integer bigger than 1!");
			String sieveErrorString = "N: Sieve of Eratosthenes, R:  error\r\n";
			operations.add(sieveErrorString);
		}
	}

	public void euclid(ActionEvent event) {
		String userInput1 = input1.getText();
		String userInput2 = input2.getText();
		if (userInput1.isEmpty() || userInput2.isEmpty()) {
			resultLabel.setText("Please insert two integers");
		}
		if (userInput1.startsWith(" ") || userInput2.startsWith(" ")) {
			resultLabel.setText("Please insert two integers");
		}
		Scanner scan1 = new Scanner(userInput1);
		Scanner scan2 = new Scanner(userInput2);
		int number1, number2;
		if (scan1.hasNextInt() && (number1 = Integer.parseInt(input1.getText())) > 0 && scan2.hasNextInt()
				&& (number2 = Integer.parseInt(input2.getText())) > 0) {
			int n1 = Integer.parseInt(input1.getText());
			int n2 = Integer.parseInt(input2.getText());
			int min = Math.min(n1, n2);
			int gcd = 0;
			for (int i = 1; i <= min; i++) {
				if (n1 % i == 0 && n2 % i == 0) {
					gcd = i;
				}
			}
			String str = "" + gcd;
			resultLabel.setText(str);
			String euclidString = "N: Euclid's algorithm, P: " + n1 + " ," + n2 + ", R: " + resultLabel.getText()
					+ "\r\n";
			operations.add(euclidString);
		} else {
			resultLabel.setText("Please insert two integers, both bigger than 0!");
			String euclidErrorString = "N: Euclid's algorithm, R:  error\r\n";
			operations.add(euclidErrorString);
		}

	}

	public void nPrimes(ActionEvent event) {
		String userInput = input1.getText();
		int c = 0;
		if (userInput.isEmpty()) {
			resultLabel.setText("Please insert a number");
		}
		if (userInput.startsWith(" ")) {
			resultLabel.setText("Please insert a number");
		}
		Scanner scan = new Scanner(userInput);
		int n1 = Integer.parseInt(input1.getText());
		if (scan.hasNextInt() && (n1 = Integer.parseInt(input1.getText())) > 0) {
			for (int i = 2; i <= n1; i++) {
				if (SupportMethods.isPrime(i) == true) {
					c++;
				}
			}
			String str = "" + c;
			resultLabel.setText(str);

			String nPrimesString = "N: Number of Primes, P: " + Integer.parseInt(input1.getText()) + " R: "
					+ resultLabel.getText() + "\r\n";
			operations.add(nPrimesString);
		} else {
			resultLabel.setText("Please insert an integer bigger than 0!");
			String nPrimeErrorString = "N: Number of Primes, R: error\r\n";
			operations.add(nPrimeErrorString);
		}

	}

	public void eulerTot(ActionEvent event) {
		String userInput = input1.getText();
		if (userInput.isEmpty()) {
			resultLabel.setText("Please insert a number");
		}
		if (userInput.startsWith(" ")) {
			resultLabel.setText("Please insert a number");
		}
		Scanner scan = new Scanner(userInput);
		int number1;
		if (scan.hasNextInt() && (number1 = Integer.parseInt(input1.getText())) > 1) {
			int n1 = Integer.parseInt(input1.getText());
			int result = SupportMethods.eulerTot(n1);
			String str = "" + result;
			resultLabel.setText(str);
			String eulerString = "N: Euler's totient, P: " + Integer.parseInt(input1.getText()) + " R: "
					+ resultLabel.getText() + "\r\n";
			operations.add(eulerString);
		} else {
			resultLabel.setText("Please insert an integer bigger than 0!");
			String eulerErrorString = "N: Euler's totient, R: error\r\n";
			operations.add(eulerErrorString);
		}

	}

	public void primeFact(ActionEvent event) {
		String userInput = input1.getText();
		int tot = 0;
		String str = new String();
		ArrayList<Integer> factors = new ArrayList<Integer>();
		if (userInput.isEmpty()) {
			resultLabel.setText("Please insert a number");
		}
		if (userInput.startsWith(" ")) {
			resultLabel.setText("Please insert a number");
		}
		Scanner scan = new Scanner(userInput);
		int n1;
		if (scan.hasNextInt() && (n1 = Integer.parseInt(input1.getText())) > 1) {
			for (int i = 2; i <= n1; i++) {
				int c = 0;
				while (n1 % i == 0) {
					n1 = (n1 / i);
					factors.add(i);
					c++;
				}
			}
			for (int j = 0; j < factors.size(); j++) {
				str = str + factors.get(j) + "; ";
				resultLabel.setText(str);
			}
			String primeFactString = "N: Prime factorization, P: " + Integer.parseInt(input1.getText()) + " R: "
					+ resultLabel.getText() + "\r\n";
			operations.add(primeFactString);
		} else {
			resultLabel.setText("Please insert an integer bigger than 1!");
			String primeFactErrorString = "N: Prime factorization, R: error\r\n";
			operations.add(primeFactErrorString);
		}

	}

	public void sigma(ActionEvent event) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		String userInput1 = input1.getText();
		String userInput2 = input2.getText();
		int sum = 0;
		String str = new String();
		if (userInput1.isEmpty() || userInput2.isEmpty()) {
			resultLabel.setText("Please insert two integers");
		}
		if (userInput1.startsWith(" ") || userInput2.startsWith(" ")) {
			resultLabel.setText("Please insert two integers");
		}
		Scanner scan1 = new Scanner(userInput1);
		Scanner scan2 = new Scanner(userInput2);
		int number1, number2;
		if (scan1.hasNextInt() && (number1 = Integer.parseInt(input1.getText())) >= 0 && scan2.hasNextInt()
				&& (number2 = Integer.parseInt(input2.getText())) > 1) {

			int n1 = Integer.parseInt(input1.getText());
			int n2 = Integer.parseInt(input2.getText());
			for (int i = 1; i <= n2; i++) {
				if (n2 % i == 0) {
					factors.add(i);
				}
			}
			for (int j = 0; j < factors.size(); j++) {
				sum = (int) (sum + Math.pow(factors.get(j), n1));
			}
			str = "" + sum;
			resultLabel.setText(str);
			String sigmaString = "N: Sigma, P: " + n1 + " ," + n2 + " R: " + resultLabel.getText() + "\r\n";
			operations.add(sigmaString);
			// }
		} else {
			resultLabel.setText("Please insert as first input an integer => 0, \r\nas second input an integer > 1");
			String sigmaErrorString = "N: Sigma, R: errors";
			operations.add(sigmaErrorString);
		}

	}

	public void LCG(ActionEvent event) {
		String userInput1 = input1.getText();
		String userInput2 = input2.getText();
		String userInput3 = input3.getText();
		String userInput4 = input4.getText();
		String str = new String();

		if (userInput1.isEmpty() || userInput2.isEmpty() || userInput3.isEmpty() || userInput4.isEmpty()) {
			resultLabel.setText("Please insert four integers => 0");
		}
		if (userInput1.startsWith(" ") || userInput2.startsWith(" ") || userInput3.startsWith(" ")
				|| userInput4.startsWith(" ")) {
			resultLabel.setText("Please insert four integers => 0");
		}
		Scanner scan1 = new Scanner(userInput1);
		Scanner scan2 = new Scanner(userInput2);
		Scanner scan3 = new Scanner(userInput3);
		Scanner scan4 = new Scanner(userInput4);
		int number1, number2, number3, number4;
		if (scan1.hasNextInt() && (number1 = Integer.parseInt(input1.getText())) >= 0 && scan2.hasNextInt()
				&& (number2 = Integer.parseInt(input2.getText())) >= 0 && scan3.hasNextInt()
				&& (number3 = Integer.parseInt(input3.getText())) >= 0 && scan4.hasNextInt()
				&& (number4 = Integer.parseInt(input4.getText())) >= 0) {
			int n1 = Integer.parseInt(input1.getText());
			int n2 = Integer.parseInt(input2.getText());
			int n3 = Integer.parseInt(input3.getText());
			int n4 = Integer.parseInt(input4.getText());

			ArrayList<Integer> LCGresult = SupportMethods.randomList(n1, n2, n3, n4);

			for (int m = 0; m < LCGresult.size(); m++) {
				str = str + LCGresult.get(m) + "; ";
			}
			resultLabel.setText(str);

			String LCGString = "N: Linear Congruential Generator, P: " + n1 + " ," + n2 + " ," + n3 + " ," + n4 + " R: "
					+ resultLabel.getText() + "\r\n";
			operations.add(LCGString);

		} else {
			resultLabel.setText("Please insert four integers => 0!");
			String LCGErrorString = "N: Linear Congruential Generator, R: error\r\n";
			operations.add(LCGErrorString);
		}

	}

	public void partition(ActionEvent event) {
		String userInput = input1.getText();
		Scanner scan = new Scanner(userInput);
		if (userInput.isEmpty()) {
			resultLabel.setText("Please insert one integer bigger than 0!");
		}
		if (userInput.startsWith(" ")) {
			resultLabel.setText("Please insert one integer bigger than 0!");
		}
		int number1;
		int n1 = Integer.parseInt(input1.getText());
		if (scan.hasNextInt() && (number1 = Integer.parseInt(input1.getText())) >= 1) {
			int result = SupportMethods.displayParts(n1);
			String str = "" + result;
			resultLabel.setText(str);
			String partitionString = "N: Partition Function, P: " + n1 + ", R: " + resultLabel.getText() + "\r\n";
			operations.add(partitionString);
			SupportMethods.reset();
		} else {
			resultLabel.setText("Please insert one integer bigger than 0!");
			String partitionErrorString = "N: Partition Function, R: error\r\n";
			operations.add(partitionErrorString);
		}
	}

	public void reset(ActionEvent event) {
		input1.clear();
		input2.clear();
		input3.clear();
		input4.clear();
		resultLabel.setText("---");
	}

	public void infoWindow(ActionEvent event) {
		FlowPane infoPane = new FlowPane();
		Stage infoStage = new Stage();
		infoStage.setTitle("Information");

		String str = "     Sieve of Eratosthenes: \r\n     computes all prime numbers "
				+ "smaller or equal than the input a. Input a ought to be > 1*.  \r\n\r\n      "
				+ "Euclid algorithm: \r\n     computes greatest commom divisor of two numbers."
				+ "Inputs a and b ought to be > 0**. \r\n\r\n      Euler's totient: \r\n     "
				+ "computes the number of integers coprimes with input a. Input a ought to "
				+ "be > 0*.\r\n\r\n     Prime factorization: \r\n     decomposes the number into "
				+ "prime factors. Input a ought to be > 1*. \r\n\r\n      Sigma(a,b): \r\n     "
				+ "sums the a-th power of the integers between 1 and a (included). \r\n     "
				+ "First input a ought to be => 0, second input b > 1**. \r\n\r\n     "
				+ "Linear congruential generator: \r\n     computes first n random numbers, "
				+ "randomly generated by the formula: x(d+1) = (x* a(d) + b) (mod c). " + "\r\n     "
				+ "Seed number is 11." + "\r\n\r\n     Partition Function: \r\n     "
				+ "calculates the number of possible partitions of n."
				+ "\r\n     E.g. p(3) = 3, because 3 can be written as 1+1+1, 2+1, 3+1."
				+ "\r\n\r\n     Additional notes" + "\r\n     * Input fields b, "
				+ "c and d will not be considered for the " + "calculation.\r\n     "
				+ "**Input fields c and d will not be considered " + "for the calculation.";

		infoLabel = new Label(str);
		infoLabel.setAlignment(Pos.CENTER);

		infoPane.getChildren().add(infoLabel);
		Scene infoScene = new Scene(infoPane, 600, 470);
		infoStage.setScene(infoScene);
		GridPane.setHalignment(infoLabel, HPos.RIGHT);
		infoStage.show();

	}

	public void history(ActionEvent event) {
		Stage historyStage = new Stage();
		FlowPane historyPane = new FlowPane();
		historyStage.setTitle("History of operations");

		initialLabel = new Label("N: Name of the calculation, P: user inputs implemented, " + "R: result" + "\r\n");
		resultLabel.setAlignment(Pos.CENTER);

		hLabel = new Label(operations.toString());
		hLabel.setAlignment(Pos.CENTER);

		historyPane.getChildren().add(initialLabel);
		historyPane.getChildren().add(hLabel);
		Scene historyScene = new Scene(historyPane, 500, 300);
		historyStage.setScene(historyScene);
		historyStage.show();

	}

}
