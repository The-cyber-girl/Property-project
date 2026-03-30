package lab4;
import java.util.Scanner;

public class Property {

    String propertyID;
    String ownerName;
    double baseRent;
    int constructionYear;

    // Parameterized constructor
    public Property(String propertyID, String ownerName, double baseRent, int constructionYear) {
        this.propertyID = propertyID;
        this.ownerName = ownerName;
        this.baseRent = baseRent;
        this.constructionYear = constructionYear;
    }

    // Default constructor
    public Property() {
        this.propertyID = "";
        this.ownerName = "";
        this.baseRent = 0.0;
        this.constructionYear = 2000;
    }

    // Read property information from user
    public void readInfo() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the property ID:");
        this.propertyID = scan.next();

        System.out.println("Enter the owner name:");
        this.ownerName = scan.next();

        System.out.println("Enter the base rent:");
        this.baseRent = scan.nextDouble();
        if (baseRent < 0) {
            System.out.println("Base rent must be > 0. Setting to 0.");
            this.baseRent = 0;
        }

        System.out.println("Enter the construction year (1900–2024):");
        this.constructionYear = scan.nextInt();
        if (constructionYear < 1900 || constructionYear > 2024) {
            System.out.println("Invalid year. Setting to 2000.");
            this.constructionYear = 2000;
        }
    }

    // Calculate property age
    public int propertyAge() {
        return 2026 - constructionYear;
    }

    // Calculate maintenance fee
    public double maintenanceFee() {
        double fee;
        if (propertyAge() > 30) {
            fee = 0.15 * baseRent;
        } else {
            fee = 0.07 * baseRent;
        }
        return fee;
    }

    // Calculate total monthly cost
    public double totalMonthlyCost() {
        return baseRent + maintenanceFee();
    }

    // Display property info
    public void displayInfo() {
        System.out.println("----- Property Information -----");
        System.out.println("ID             : " + propertyID);
        System.out.println("Owner          : " + ownerName);
        System.out.println("Age            : " + propertyAge());
        System.out.println("Base Rent      : $" + baseRent);
        System.out.println("Maintenance    : $" + maintenanceFee());
        System.out.println("Total Cost     : $" + totalMonthlyCost());
        System.out.println("--------------------------------");
    }
}