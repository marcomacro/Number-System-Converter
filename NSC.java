import java.util.Scanner;

// NSC - Number System Converter
// v0.2 AnyToDec
//
// Converts decimal numbers to binary, octal and  hexal representation.
// Additionally u could convert to a free-to-choose system up to 36.
// To do so, change the 'vBase'-variable.
// v0.2 - Changes:
// - Converts numbers of a chooseable number system to decimal representation.
// - output "-1" indicates an input error (only within anyToDec())
public class NSC {
	
	// vBase - variable Base
	// vBase <= 36 otherwise method undefined
	public static int vBase = 36;
	
	static Scanner sc = new Scanner(System.in);
	static boolean running = true;
	static int srcBase = 10;
	
	public static String[] symbols = 
	{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
	 "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
	 "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
	 "U", "V", "W", "X", "Y", "Z"};
	
	public static String[] commands = {"base", "help", "exit"};
	 
	public static void main (String[] args){	
		// declarations
		int number = 0;
		String numberStr = "";
		
		run();
		/*
		// input 1
		System.out.println("");
		System.out.println("NSC - Number System Converter (Part 1)");
		System.out.println("Converts decimal numbers to other number systems.");
		System.out.println("");
		System.out.print("Number: ");
		number = sc.nextInt();
		
		// output 1
		System.out.println("Binary: " + decToAny(number, 2));
		System.out.println("Octal : " + decToAny(number, 8));
		System.out.println("Hexal : " + decToAny(number, 16));
		System.out.println(vBase + "'er : " + decToAny(number, vBase));
		System.out.println("");
		
		// input 2
		System.out.println("NSC - Number System Converter (Part 2)");
		System.out.println("Converts numbers from a chooseable number system to decimal.");
		System.out.println("");
		System.out.print("Number : ");
		numberStr = sc.next();
		System.out.print("[base] : ");
		srcBase = sc.nextInt();
		
		// output 2
		System.out.println("Decimal: " + anyToDec(numberStr, srcBase));	*/
	}
	
	public static void run() {
		String[] command = {};
		while (running == true) {
			System.out.print("NSC[" + srcBase +"]> ");
			command = sc.nextLine().split(" ");
			if (command[0].equals("exit")) {
				running = false;
			} else if (command[0].equals("base")) {
				processBase(command);
			} else if (command[0].equals("targetBase")) {
				processTargetBase(command);
			} else if (command[0].equals("symbols")) {
				// TO DO: print symbolTable
			} else if (command[0].equals("help")) {
				// TO DO: print help
			} else {
				int x = parseInteger(command[0]);
				if (x>=0) {
					printResults(x);
				}
			}
		}
	}
	
	public static void processBase(String[] params) {
		if (params.length==1) {
			System.out.println("base: " + srcBase);
		} else {
			int x = parseInteger(params[1]);
			if (x>=0) {
				srcBase = x;
			}
		}
	}
	
	public static void processTargetBase(String[] params) {
		if (params.length==1) {
			System.out.println("targetBase: " + vBase);
		} else {
			int x = parseInteger(params[1]);
			if (x>=0) {
				vBase = x;
			}
		}
	}
	
	public static void printResults(int var) {
		System.out.printf("[%2s]: %8s\n", "2", decToAny(var, 2));
		System.out.printf("[%2s]: %8s\n", "8", decToAny(var, 8));
		System.out.printf("[%2s]: %8s\n", "16", decToAny(var, 16));
		System.out.printf("[%2s]: %8s\n", vBase, decToAny(var, vBase));
		System.out.println("");
	}
	
	public static int parseInteger(String s) {
		int result = -1;
		try {
			result = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.out.println("err: unknownArgument"); 
		}
		return result;
	}
	
	public static String anyToDec(String n, int sourceBase) {
		char[] chNumber = n.toCharArray();
		int result = 0;
		int digit = 0;
		for (int i=0; i<chNumber.length; i++) {
			if ((digit = Character.getNumericValue(chNumber[i])) >= sourceBase) {
				result = -1;
				break;
			}
			result += digit * Math.pow(sourceBase, chNumber.length-1-i);
		}
		return String.valueOf(result);
	}
	
	// Note: method works up to a maximum base of 36, otherwise method will be
	// undefined or exit by error
	public static String decToAny (int n, int targetBase) {
		String result = "";
		for (int i=n; i>0; i=i/targetBase) {
			result = symbols[i%targetBase] + result;
		}
		return result;
	}

}