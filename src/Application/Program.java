package Application;

import Entites.Contract;
import Entites.Installment;
import Services.ContractService;
import Services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter the contract's data: ");
        System.out.print("Contract's number: ");
        int number = sc.nextInt();
        System.out.print("Date: (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), dtf);
        System.out.print("Contract's value: ");
        double totalValue = sc.nextDouble();
        Contract contract = new Contract(number,date,totalValue);

        System.out.print("Enter the number of installments: ");
        int n = sc.nextInt();

        ContractService service = new ContractService(new PaypalService());
        service.processContract(contract, n);

        System.out.println();
        System.out.println("Installments: ");

        for (Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }

        sc.close();
    }
}
