import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
 * @author Marcell Voros
 * 
 *  
 * I have decided to do with arraylist. It is not the fastest way to get any value but it is different from the TreeSet.
 * The arraylist has many methods that we can use during the exercise. I have added more options inside main menu.
 * I have also added one more parameter which is the address of the contact.
 * The exercise is a schedule that interprets with the user through the keyboard.
 * We can create new contacts and new events with this application, and check it or delete it.
 */

public class LaAgenda {
	static ArrayList<Contacto> mySchedule = new ArrayList<Contacto>();
	static ArrayList<Event> mySchedule2 = new ArrayList<Event>();
	static Scanner number = new Scanner(System.in);
	static Scanner cadena = new Scanner(System.in);
	static String respuesta = "";

	public static void main(String[] args) {
		System.out.println("Welcome to the schedule app!\nPress any number and enter to go to the main menu.");
		int anyEnter = number.nextInt();
		// I have a schedule with some elements from the beginning.
		// I have a event with some elements from the beginning.
		initSchedule();
		initEvent();
		do {
			System.out.println(
					"\n* ------------------------------ *\n|Welcome to the main menu        |\n|                                |\n|Press 1 to create a new event   |\n|Press 2 to see my events        |\n|Press 3 to delete an event      |\n|Press 4 to create a new contact |\n|Press 5 to delete a contact     |\n|Press 6 to find a contact       |\n|Press 7 to see contacts         |\n|Press 9 to exit the app         |\n* ------------------------------ *");
			anyEnter = number.nextShort();
			switch (anyEnter) {
			case 1:
				addEvent();
				break;
			case 2:
				seeEvents();
				break;
			case 3:
				mySchedule2.remove(deleteEvent());
				break;
			case 4:
				addContact();
				break;
			case 5:
				mySchedule.remove(deleteContact());
				break;
			case 6:
				findContact();
				break;
			case 7:
				seeContacts();
				break;
			case 9:
				System.out.println("Thank you for using the application, see you later.");
				anyEnter = 0;
				break;
			default:
				System.out.println("\nTry again or exit the app.\n");
				break;
			}
		} while (anyEnter != 0);

	}

	private static void initSchedule() {
		mySchedule.add(new Contacto("Angel", "98655223", "angel@gmail.com", "28221 Majadahonda"));
		mySchedule.add(new Contacto("Nayra", "98231243", "nayra@gmail.com", "28000 Madrid"));
		mySchedule.add(new Contacto("Pedro", "96321231", "pedro@gmail.com", "28224 Las Rozas"));
	}

	private static void initEvent() {
		mySchedule2.add(new Event("Marcell Wedding", "28221 Majadahonda", "2022.10.22"));
		mySchedule2.add(new Event("Photo Exhibition", "28220 Las Rozas", "2022.08.22"));
		mySchedule2.add(new Event("My Anniversary", "23221 Avila", "2022.09.11"));
	}

	// The method that looks for the contact
	private static void findContact() {
		System.out.println("Give me the full name to find");
		String name = cadena.nextLine();
		for (Contacto c : mySchedule) {
			if (c.getName().equals(name)) {
				System.out.println("The result is: " + c);
			}
		}
	}

	// The method that deletes a contact
	private static Contacto deleteContact() {
		Contacto delete = new Contacto();
		System.out.println("Give me the full name to delete");
		String name = cadena.nextLine();
		for (Contacto c : mySchedule) {
			if (c.getName().equals(name)) {
				System.out.println("Are you sure, yes or not?");
				respuesta = cadena.nextLine();
				if (respuesta.equals("yes")) {
					System.out.println("You deleted a contact: " + name);
					delete = c;
				} else {
					System.out.println("Try again, ");
					System.out.println(deleteContact());
				}
			}
		}
		return delete;
	}

	// The method that creates the new contact
	public static void addContact() {
		Contacto addNew = new Contacto();
		System.out.println("Name: ");
		addNew.setName(cadena.nextLine());
		System.out.println("Phone: ");
		addNew.setPhone(cadena.nextLine());
		System.out.println("Email: ");
		addNew.setEmail(cadena.nextLine());
		System.out.println("Address: ");
		addNew.setAddress(cadena.nextLine());
		mySchedule.add(addNew);
		System.out.println("You added a contact: \n" + addNew);
	}

	// The method that creates the new event
	public static void addEvent() {
		Event addNew = new Event();
		System.out.println("Name: ");
		addNew.setName(cadena.nextLine());
		System.out.println("Address: ");
		addNew.setAddress(cadena.nextLine());
		System.out.println("Fecha: year.month.day");
		addNew.setFecha(cadena.nextLine());
		mySchedule2.add(addNew);
		System.out.println("You added an event: \n" + addNew);
	}

	// The method that deletes an event
	private static Event deleteEvent() {
		Event delete = new Event();
		System.out.println("Give me the full name of the event to delete");
		String name = cadena.nextLine();
		for (Event c : mySchedule2) {
			if (c.getName().equals(name)) {
				System.out.println("Are you sure, yes or not?");
				respuesta = cadena.nextLine();
				if (respuesta.equals("yes")) {
					System.out.println("You deleted an event: " + name);
					delete = c;
				} else {
					System.out.println("Try again, ");
					System.out.println(deleteEvent());
				}
			}
		}
		return delete;
	}

	// The method that give me to see the events
	public static void seeEvents() {
		for (Event c : mySchedule2) {
			System.out.println(c);
		}

	}

	// The method to see all contacts
	private static void seeContacts() {
		for (Contacto c : mySchedule) {
			System.out.println(c);
		}

	}

}
