package capitulo14ExercicioResolvido;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner entr = new Scanner(System.in);
		
		List<Employee> funcs = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		int num = entr.nextInt();

		for (int i = 1; i <= num; i++) {
			System.out.println("Employee #" + i + " data");
			entr.nextLine();
			System.out.print("Outsourced (y/n) ?");
			String sn = entr.nextLine();
			if (!sn.equals("y") && !sn.equals("n")) {
				do {
					System.out.println("Escolha apenas y(Sim) ou n(Não): ");
					sn = entr.nextLine();
				} while (!sn.equals("y") && !sn.equals("n"));
			}
			System.out.print("Name: ");
			String name = entr.nextLine();
			System.out.print("Hours: ");
			int hours = entr.nextInt();
			System.out.print("Value per hour: ");
			double value = entr.nextDouble();
			if (sn.equals("y")) {
				System.out.print("Additional charge: ");
				double charge = entr.nextDouble();
				OutsourcedEmployee employee = new OutsourcedEmployee(name, hours, value, charge);
				funcs.add(employee);
			} else {
				Employee employee = new Employee(name, hours, value);
				funcs.add(employee);
			}

		}

		entr.close();
		
		System.out.println("PAYMENTS: ");
		for(Employee e : funcs) {
			System.out.println(e.getName() + " - $" + String.format("%.2f", e.payment())); 
		}
	}
}
