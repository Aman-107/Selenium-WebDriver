package JDBC_Integration;

public class codeJust {

	public static void main(String[] args) {
		
		int n =10;
		String stars = "*".repeat(n); // Initialize with the maximum number of stars
		String pattern ="*************";
		for (int i=n; i>0; i--) {
			//pattern += "*";                           // star in increasing order
			System.out.println(stars.substring(0, i)); // star in decreasing order
		}
	}
	
}
