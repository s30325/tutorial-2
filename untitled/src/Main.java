import java.util.Scanner;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ile masz lat?: ");
        int age = scanner.nextInt();
        System.out.print("Czy mieszkasz Warszawie? (tak/nie): ");
        String resident = scanner.next().toLowerCase();
        String day = LocalDate.now().getDayOfWeek().name().toLowerCase();
        double ticketPrice = calculateTicketPrice(age, resident.equals("tak"), day);
        String discountInfo = calculateDiscountInfo(age, resident.equals("tak"), day);
        System.out.println("Dane klienta - Wiek: " + age + " lat, Mieszkaniec Warszawy: " + resident + ", Dzień tygodnia: " + day);
        System.out.println("Cena biletu po rabacie: " + ticketPrice + " PLN");
        System.out.println("Zniżka: " + discountInfo);
    }
    public static double calculateTicketPrice(int age, boolean isWarsawResident, String day) {
        double basePrice = 40;
        double ticketPrice = basePrice;
        if (age < 10 || day.equals("thursday")) {
            ticketPrice = 0;
        } else if (age >= 10 && age <= 18) {
            ticketPrice *= 0.5;
        }
        if (isWarsawResident) {
            ticketPrice *= 0.9;}
        return ticketPrice;
    }
    public static String calculateDiscountInfo(int age, boolean isWarsawResident, String day) {
        StringBuilder discountInfo = new StringBuilder();
        if (age < 10 || day.equals("thursday")) {
            discountInfo.append("Bezpłatny wstęp");
        } else if (age >= 10 && age <= 18) {
            discountInfo.append("50% zniżki");
        }
        if (isWarsawResident) {
            if (discountInfo.length() > 0) {
                discountInfo.append(", ");}
            discountInfo.append("10% zniżki dla mieszkańców Warszawy");
        }
        return discountInfo.toString();
    }
}