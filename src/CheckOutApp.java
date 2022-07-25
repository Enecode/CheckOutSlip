import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.Scanner;

public class CheckOutApp {
    static int price;
    static int balance;
    static double totalAmount;
    static double vat;
    static int subTotal;

    static double discount;


    public static void main(String[] args) {


        ArrayList<String> customerName = new ArrayList<>();
        ArrayList<String> cashierName = new ArrayList<>();
        ArrayList<String> itemCustomerBought = new ArrayList<>();
        ArrayList<Integer> quantityBought = new ArrayList<>();
        ArrayList<Integer> amountPerQuantity = new ArrayList<>();
        ArrayList<Integer> amountCustomerPaid = new ArrayList<>();
        ArrayList<Double> discountAmount = new ArrayList<>();


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SS");
        Scanner input = new Scanner(System.in);

        System.out.println("How many customer? ");

        int cName = input.nextInt();
        for (int i = 1; i <= cName; i++) {
            System.out.println("Customer details " + i);

            getDetails(customerName, cashierName, itemCustomerBought, quantityBought, amountPerQuantity, amountCustomerPaid, discountAmount);
        }

        printPaymentSlip(amountCustomerPaid, customerName, cashierName, itemCustomerBought, quantityBought, amountPerQuantity, discountAmount);
    }

    public static void getDetails(ArrayList<String> customerName, ArrayList<String> cashierName, ArrayList<String> itemCustomerBought, ArrayList<Integer> quantityBought, ArrayList<Integer> amountPerQuantity, ArrayList<Integer> amountCustomerPaid, ArrayList<Double> discountAmount) {
        Scanner input = new Scanner(System.in);

        System.out.println("Name of cashier: ");
        String cashiersName = input.nextLine();
        cashierName.add(cashiersName);

        System.out.println("Customer Name: ");
        String userName = input.nextLine();
        customerName.add(userName);

        System.out.println("Item customer bought: ");
        String itemsBought = input.nextLine();
        itemCustomerBought.add(itemsBought);

        System.out.println("How many quantity?: ");
        int itemsQty = input.nextInt();
        quantityBought.add(itemsQty);

        System.out.println("How how much per quantity?: ");
        int itemsQtyPrice = input.nextInt();
        amountPerQuantity.add(itemsQtyPrice);

        System.out.println("Amount customer paid: ");
        int amountPaid = input.nextInt();
        amountCustomerPaid.add(amountPaid);

        System.out.println("how much discount?: ");
        int discountOnItem = input.nextInt();
        discountAmount.add((double) discountOnItem);
    }

    private static void printPaymentSlip(ArrayList<Integer> amountCustomerPaid, ArrayList<String> customerName, ArrayList<String> cashierName, ArrayList<String> itemCustomerBought, ArrayList<Integer> quantityBought, ArrayList<Integer> amountPerQuantity, ArrayList<Double> discountAmount) {
        for (int i = 0; i < customerName.size(); i++) {
            System.out.println("=================");
            System.out.println("Customer " + i);
            System.out.println("=================");

            System.out.printf("%s%n", "EneDigital Complex\nMain Branch\nLocation: Sabo Yaba:\nTel:+2347012345678");
            Date date = new Date();
            System.out.printf("Date: " + String.format(String.valueOf(date)));
            System.out.printf("%n%s%s", "Cashier's Name: ", cashierName.get(i));
            System.out.printf("%n%s%s%n%n", "Customer Name: ", customerName.get(i));

            System.out.println("=====================================================================================");
            System.out.printf("%30s%10s%10s%15s%n", "Item", "QTY", "Price", "Total(NGN) ");
            System.out.println(" ------------------------------------------------------------------------------------");
            subTotal = 0;
            for (int j = 0; j < quantityBought.size(); j++) {
                price = quantityBought.get(j) * amountPerQuantity.get(j);
                System.out.printf("%30s%10s%10s%10s%n", itemCustomerBought.get(j), quantityBought.get(j), amountPerQuantity.get(j), price);

                discount = discountAmount.get(j) * subTotal / 100;

                vat = 17.50 / 100 * subTotal;

                subTotal += price;
                totalAmount = subTotal - discount + vat;
                balance = (int) (totalAmount - discount - amountCustomerPaid.get(i));

            }

            System.out.println(" ------------------------------------------------------------------------------------");
            System.out.printf("%40s%15s%n", "SubTotal ", subTotal);
            System.out.printf("%40s%15s%n", "Discount ", discount);
            System.out.printf("%40s%15s%n", "VAT ", vat);
            System.out.printf("======================================================================================= %n");

            System.out.printf("%40s%15s%n", "Bill Total", totalAmount);
            System.out.printf("%40s%15s%n", "Amount Paid", amountCustomerPaid.get(i));
            System.out.printf("%40s%15s%n", "Balance", balance);
            System.out.printf("======================================================================================= %n");
            
            System.out.printf("%40s%n", "\t\t\tThanks for your patronage");
            System.out.printf("====================================================================================== %n");

        }
    }
}
