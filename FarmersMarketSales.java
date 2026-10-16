import java.util.Scanner;

public class FarmersMarketSales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("    WELCOME TO THE FARMERS MARKET POS    ");
        System.out.println("=========================================");

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("How many different produce items did they purchase? ");
        int numItems = scanner.nextInt();
        scanner.consumeLineFixOrNext(); 
        String[] itemNames = new String[numItems];
        double[] quantities = new double[numItems];
        double[] unitPrices = new double[numItems];
        double[] subtotals = new double[numItems];

        double totalBill = 0.0;

        for (int i = 0; i < numItems; i++) {
            System.out.println("\n--- Item " + (i + 1) + " ---");
            System.out.print("Enter produce name (e.g., Tomatoes, Apples): ");
            scanner.nextLine(); // consume newline
            itemNames[i] = scanner.nextLine();

            System.out.print("Enter quantity (in kg or units): ");
            quantities[i] = scanner.nextDouble();

            System.out.print("Enter price per unit/kg (₹): ");
            unitPrices[i] = scanner.nextDouble();

            subtotals[i] = quantities[i] * unitPrices[i];
            totalBill += subtotals[i];
        }

        double discountRate = 0.0;
        double discountAmount = 0.0;
        if (totalBill > 500.0) {
            discountRate = 0.05; // 5% discount
            discountAmount = totalBill * discountRate;
        }

        double finalAmount = totalBill - discountAmount;

        System.out.println("\n=========================================");
        System.out.println("            FARMERS MARKET BILL          ");
        System.out.println("=========================================");
        System.out.println("Customer: " + customerName);
        System.out.println("-----------------------------------------");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Item", "Qty", "Price", "Subtotal");
        System.out.println("-----------------------------------------");

        for (int i = 0; i < numItems; i++) {
            System.out.printf("%-15s %-10.2f ₹%-9.2f ₹%-9.2f\n", 
                itemNames[i], quantities[i], unitPrices[i], subtotals[i]);
        }

        System.out.println("-----------------------------------------");
        System.out.printf("Subtotal:                  ₹%.2f\n", totalBill);
        if (discountAmount > 0) {
            System.out.printf("Discount (5%):            -₹%.2f\n", discountAmount);
        } else {
            System.out.println("Discount:                  None (Spend > ₹500 for 5%)");
}
        System.out.printf("Final Payable Amount:      ₹%.2f\n", finalAmount);
        System.out.println("=========================================");
        System.out.println("   Thank you for supporting local farms! ");
        System.out.println("=========================================");

        scanner.close();
    }
}
