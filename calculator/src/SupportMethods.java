import java.util.ArrayList;

public class SupportMethods {
	static int sumParts = 0;

	public static void main (String[] args)  
    {
		System.out.println(SupportMethods.isPrime(97));
    }
	public static int lcg(int a, int b, int m, int n) {
		if (n == 0) {
			return 11;
		}
		return (((a * SupportMethods.lcg(a, b, m, n - 1)) + b) % m);
	}

	public static ArrayList<Integer> factors(int b) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 1; i <= b; i++) {
			if (b % i == 0) {
				factors.add(i);

			}
		}
		return (factors);
	}

	public static ArrayList<Integer> randomList(int a, int b, int m, int n) {
		ArrayList<Integer> randNums = new ArrayList<Integer>();
		// int x = 0;
		if (n == 0) {
			randNums.add(11);
		}
		for (int i = 1; i <= n; i++) {
			int x = SupportMethods.lcg(a, b, m, i);
			randNums.add(x);
		}
		return (randNums);
	}

	static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	public static void createParts(int n) {
		int index = 0;
		int[] parts = new int[n];
		parts[index] = n;

		while (true) {
			sumParts = sumParts + 1;

			int remain = 0;
			while (index >= 0 && parts[index] == 1) {
				remain += parts[index];
				index--;
			}

			if (index < 0) {
				return; }

			parts[index]--;
			remain++;

			while (remain > parts[index]) {
				parts[index + 1] = parts[index];
				remain = remain - parts[index];
				index++;
			}

			parts[index + 1] = remain;
			index++;
		}
	}

	public static int displayParts (int a) {
		SupportMethods.createParts(a);
		return sumParts;
	}
	
	static void reset () {
		sumParts = 0;
	}
	
	public static int gcd(int n1, int n2) {
		int min = Math.min(n1, n2);
		int gcd = 0;
		for (int i = 1; i <= min; i++) {
			if (n1 % i == 0 && n2 % i == 0) {
				gcd = i;
			}
		}
		return gcd;
	}
	
	public static int eulerTot(int n1) {
		int tot = 0;
		for (int i = 0; i <= n1; i++) {
			if (SupportMethods.gcd(n1, i) == 1) {
				tot++;
			}
	}
		return tot;	
	} 
	

}
