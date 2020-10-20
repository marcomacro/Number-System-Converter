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
	
	public static String[] symbols = 
	{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
	 "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
	 "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
	 "U", "V", "W", "X", "Y", "Z"};
	 
	public static void main (String[] args){	
		// declarations
		Scanner sc = new Scanner(System.in);
		int number = 0;
		String numberStr = "";
		int srcBase = 0;
		
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
		System.out.println("Decimal: " + anyToDec(numberStr, srcBase));	
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