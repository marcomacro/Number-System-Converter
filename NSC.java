import java.util.Scanner;

// NSC - Number System Converter
// v0.1 DecToAny
//
// Converts decimal numbers to binary, octal and  hexal representation.
// Additionally u could convert to a free-to-choose system up to 36.
// To do so, change the 'vBase'-variable.
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
		
		// input
		System.out.println("");
		System.out.println("NSC - Number System Converter");
		System.out.println("Converts decimal numbers to other number systems.");
		System.out.println("");
		System.out.print("[Dec] : ");
		number = sc.nextInt();
		
		// output
		System.out.println("Binary: " + decToBin(number));
		System.out.println("Octal : " + decToOct(number));
		System.out.println("Hexal : " + decToHex(number));
		System.out.println(vBase + "'er : " + decToVBase(number, vBase));
		System.out.println("");
	}
	
	public static String decToBin(int n){
		String result = "";
		for (int i=n; i>0; i=i/2) {
			result = Integer.toString(i%2) + result;
		}
		return result;
	}
	
	public static String decToOct(int n) {
		String result = "";
		for (int i=n; i>0; i=i/8) {
			result = Integer.toString(i%8) + result;
		}
		return result;
	}
	
	public static String decToHex(int n) {
		String result = "";
		for (int i=n; i>0; i=i/16) {
			result = symbols[i%16] + result;
		}
		return result;
	}
	
	// decToVBase - decimalToVariableBase
	// Note: method works up to a maximum base of 36, otherwise method will be
	// undefined or exit by error
	public static String decToVBase (int n, int base) {
		String result = "";
		for (int i=n; i>0; i=i/base) {
			result = symbols[i%base] + result;
		}
		return result;
	}

}











