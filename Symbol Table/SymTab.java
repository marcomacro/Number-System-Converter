// SymTab - Symbol Table
// Prints the assignment of digit-symbols
// to (logical) numbers for the NSC
// U may use 'java SymTab > new.txt' for a printout in a txt-file
public class SymTab {
	
	public static String[] symbols = 
	{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
	 "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
	 "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
	 "U", "V", "W", "X", "Y", "Z"};
	 
	public static void main (String args[]) {
		System.out.println("");
		System.out.println("Symbol Table:");
		System.out.println("-------------");
		for (int i=0; i<symbols.length; i++) {
			System.out.println(String.format("%3s  - %3d", symbols[i], i));
			if (i%5==0){System.out.println("");}
		}
	}
}