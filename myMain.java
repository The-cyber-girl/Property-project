package lab4;

import java.util.Scanner;

public class myMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of properties");
		int n =sc.nextInt();
		
		Property[] properties = new Property[n];
		 double totalRevenue = 0;
	        int expensiveCount = 0;

		for(int i = 0;i<n;i++ ) {
			System.out.println("Enter the info for property" +(i+1)+ ":");
			properties[i] = new Property();
			properties[i].readInfo();
		}
		
		  System.out.println("\nDisplaying all properties:");
	        for (Property p : properties) {
	            p.displayInfo();
	            totalRevenue += p.totalMonthlyCost(); // [cite: 37]
	            if (p.totalMonthlyCost() > 2500) expensiveCount++; // [cite: 36]
	        }

	        System.out.println("Properties with cost > $2500: " + expensiveCount);
	        System.out.println("Total Monthly Revenue: $" + totalRevenue);
	            
	            
	}

}
