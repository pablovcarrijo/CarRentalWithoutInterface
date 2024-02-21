package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		
		System.out.print("Retirada (DD/MM/YYYY hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		
		System.out.print("Retorno: ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
		
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
		
		System.out.print("Price per hour: ");
		Double pricePerHour = sc.nextDouble();
		System.out.print("Price per day: ");
		Double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvoice(cr);
		
		System.out.println("FATURA:");
		
		System.out.println("Pagamento básico: " + cr.getInvoice().getBasicPayment());
		System.out.println("Tax: " + cr.getInvoice().getTax());
		System.out.println("Pagamento total: " + cr.getInvoice().totalPayment());
		
		sc.close();
		
	}
	
}
