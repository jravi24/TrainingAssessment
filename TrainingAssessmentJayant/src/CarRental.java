import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.time.*;
import java.time.temporal.ChronoUnit;
//import org.joda.time.DateTime;
//import org.joda.time.LocalDateTime;

class Users{
	String name;
	String phone_number;
	String status;
	public Users(String name, String phone_number,String status) {
		super();
		this.name = name;
		this.phone_number = phone_number;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

class PremiumUsers extends Users {

	public PremiumUsers(String name, String phone_number,String status) {
		super(name, phone_number,status);
		// TODO Auto-generated constructor stub
	}
	public int getDiscount(float cost) {
		if(cost<5000) {
			return 0;
		}
		else if(cost>=5000 && cost<10000) {
			return 10;
		}
		else {
			return 20;
		}
	}

}
class RegularUsers extends Users{
	public RegularUsers(String name, String phone_number,String status) {
		super(name, phone_number,status);
		// TODO Auto-generated constructor stub
	}
	public int getDiscount(float cost) {
		if(cost<4000) {
			return 10;
		}
		else if(cost>=4000 && cost<8000) {
			return 15;
		}
		else if(cost>=8000 && cost<12000) {
			return 20;
		}
		else {
			return 25;
		}
	}

}
class Cars{
	String name;
	String RegistrationId;
	int number_of_seats;
	public Cars(String name, String registrationId, int number_of_seats) {
		super();
		this.name = name;
		RegistrationId = registrationId;
		this.number_of_seats = number_of_seats;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegistrationId() {
		return RegistrationId;
	}
	public void setRegistrationId(String registrationId) {
		RegistrationId = registrationId;
	}
	public int getNumber_of_seats() {
		return number_of_seats;
	}
	public void setNumber_of_seats(int number_of_seats) {
		this.number_of_seats = number_of_seats;
	}
	
}
class Hatchback extends Cars{

	public Hatchback(String name, String registrationId) {
		super(name, registrationId, 4);
		// TODO Auto-generated constructor stub
	}
	
}
	
	
class SUV extends Cars{

	public SUV(String name, String registrationId) {
		super(name, registrationId, 7);
		// TODO Auto-generated constructor stub
	}
	
}
class Sedan extends Cars{

	public Sedan(String name, String registrationId) {
		super(name, registrationId, 5);
		// TODO Auto-generated constructor stub
	}
	
}
class Reservation{
	String reg_id;
	String customer_id;
	LocalDateTime book_time;
	Cars car;
	public Reservation(String reg_id, String customer_id, LocalDateTime book_time,Cars car) {
		super();
		this.reg_id = reg_id;
		this.customer_id = customer_id;
		this.book_time = book_time;
		this.car = car;
	}
	public Cars getCar() {
		return car;
	}
	public void setCar(Cars car) {
		this.car = car;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public LocalDateTime getBook_time() {
		return book_time;
	}
	public void setBook_time(LocalDateTime book_time) {
		this.book_time = book_time;
	}
	
}

public class CarRental {
	public static void main (String[] args) {
		Users Ruser1 = new RegularUsers("Jayant","9130","Active");
		Users Ruser2 = new RegularUsers("Ayush","9209","Active");
		Users Ruser3 = new RegularUsers("Aman","9316","Active");
		Users PRuser1 = new PremiumUsers("Karan","8078","Active");
		Users PRuser2 = new PremiumUsers("Harsh","8136","Active");
		Map<String,RegularUsers> regularusers = new HashMap<String,RegularUsers>();
		regularusers.put(Ruser1.getPhone_number(),(RegularUsers) Ruser1);
		regularusers.put(Ruser2.getPhone_number(),(RegularUsers) Ruser2);
		regularusers.put(Ruser3.getPhone_number(),(RegularUsers) Ruser3);
		Map<String,PremiumUsers> premiumusers = new HashMap<String,PremiumUsers>();
		premiumusers.put(PRuser1.getPhone_number(), (PremiumUsers) PRuser1);
		premiumusers.put(PRuser2.getPhone_number(), (PremiumUsers) PRuser2);
		Cars hatchback1 = new Hatchback("Swift","AD12");
		Cars hatchback2 = new Hatchback("Swift","AD22");
		Cars hatchback3 = new Hatchback("Swift","GP23");
		Cars hatchback4 = new Hatchback("Polo","AD20");
		Cars hatchback5 = new Hatchback("Polo","BE12");
		Map<String,Cars> carList = new HashMap<String,Cars>();
		Map<String,Reservation> reservations = new HashMap<String,Reservation>();
		carList.put(hatchback1.getRegistrationId(), (Hatchback) hatchback1);
		carList.put(hatchback2.getRegistrationId(), (Hatchback) hatchback2);
		carList.put(hatchback3.getRegistrationId(), (Hatchback) hatchback3);
		carList.put(hatchback4.getRegistrationId(), (Hatchback) hatchback4);
		carList.put(hatchback5.getRegistrationId(), (Hatchback) hatchback5);
		Cars sedan1 = new Sedan("Ciaz","GP12");
		Cars sedan2 = new Sedan("Cruze","BE23");
		Cars sedan3 = new Sedan("Ciaz","AR67");
		carList.put(sedan1.getRegistrationId(), (Sedan) sedan1);
		carList.put(sedan2.getRegistrationId(), (Sedan) sedan2);
		carList.put(sedan3.getRegistrationId(), (Sedan) sedan3);
		Cars suv1 = new SUV("Fortuner","GP20");
		Cars suv2 = new SUV("Fortuner","BE32");
		carList.put(suv1.getRegistrationId(), (SUV) suv1);
		carList.put(suv2.getRegistrationId(), (SUV) suv2);
		System.out.println("-----WELCOME TO CAR RENTAL SERVICE-----");
		String uid = null;
		do{
		System.out.println("Please enter your phone number or enter 0 to exit");
		Scanner sc= new Scanner(System.in);
		uid= sc.nextLine();
		for(Map.Entry<String, RegularUsers> entry: regularusers.entrySet()) {
			String key = entry.getKey();
			RegularUsers user = entry.getValue();
			if(key.equals(uid)) {
				RegularUsers currentuser = entry.getValue();
				System.out.println("---Welcome " + currentuser.getName() + " ---");
				for(Map.Entry<String,Reservation> userReservations: reservations.entrySet()) {
					String user_id = userReservations.getKey();
					Reservation res_data = userReservations.getValue();
					if(user_id.equals(uid)) {
						System.out.println("You have the car " + res_data.getReg_id() + " in use since " + res_data.getBook_time());
						System.out.println("Do you want to cancel the reservation?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						String cancel_choice = sc.nextLine();
						if(cancel_choice.equals("1")) {
							LocalDateTime cur_time = LocalDateTime.now();
							long diff = ChronoUnit.SECONDS.between(res_data.getBook_time(),cur_time);
							carList.put(res_data.getReg_id(),res_data.getCar());
							float cost = diff*500;
							int discount = currentuser.getDiscount(cost);
							payment(cost,discount);
						}
						if(cancel_choice.equals("2")) {
							break;
						}
					}
				}
				
				System.out.println("-------Registration ID------Number of Seats------Car Name");
				for(Map.Entry<String,Cars> carEntry: carList.entrySet()) {
					Cars car = carEntry.getValue();
					System.out.println("-------" + car.getRegistrationId() + "                   " + car.getNumber_of_seats() + "                " + car.getName());
				}
				System.out.println("Please enter Registration Id of car you want to drive");
				String book_reg_id = sc.nextLine();
				Cars car = carList.get(book_reg_id);
				LocalDateTime cur_time = LocalDateTime.now();
				Reservation reservation = new Reservation(car.getRegistrationId(),user.getPhone_number(),cur_time,car);
				reservations.put(user.getPhone_number(), reservation);
				carList.remove(book_reg_id);
				System.out.println("Booking successfull of car " + car.getName() + " at " + cur_time);
			}
			
		}
		for(Map.Entry<String, PremiumUsers> entry: premiumusers.entrySet()) {
			String key = entry.getKey();
			PremiumUsers user = entry.getValue();
			if(key.equals(uid)) {
				PremiumUsers currentuser = entry.getValue();
				System.out.println("---Welcome " + currentuser.getName() + " ---");
				for(Map.Entry<String,Reservation> userReservations: reservations.entrySet()) {
					String user_id = userReservations.getKey();
					Reservation res_data = userReservations.getValue();
					if(user_id.equals(uid)) {
						System.out.println("You have the car " + res_data.getReg_id() + " in use since " + res_data.getBook_time());
						System.out.println("Do you want to cancel the reservation?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						String cancel_choice = sc.nextLine();
						if(cancel_choice.equals("1")) {
							LocalDateTime cur_time = LocalDateTime.now();
							long diff = ChronoUnit.SECONDS.between(res_data.getBook_time(),cur_time);
							carList.put(res_data.getReg_id(),res_data.getCar());
							float cost = diff*500;
							int discount = currentuser.getDiscount(cost);
							payment(cost,discount);
						}
						if(cancel_choice.equals("2")) {
							break;
						}
					}
				}
				
				System.out.println("-------Registration ID------Number of Seats------Car Name");
				for(Map.Entry<String,Cars> carEntry: carList.entrySet()) {
					Cars car = carEntry.getValue();
					System.out.println("-------" + car.getRegistrationId() + "                   " + car.getNumber_of_seats() + "                " + car.getName());
				}
				System.out.println("Please enter Registration Id of car you want to drive");
				String book_reg_id = sc.nextLine();
				Cars car = carList.get(book_reg_id);
				LocalDateTime cur_time = LocalDateTime.now();
				Reservation reservation = new Reservation(car.getRegistrationId(),user.getPhone_number(),cur_time,car);
				reservations.put(user.getPhone_number(), reservation);
				carList.remove(book_reg_id);
				System.out.println("Booking successfull of car " + car.getName() + " at " + cur_time);
			}
			
		}
	}while(!uid.equals("0"));
}

	private static void payment(float cost, int discount) {
		// TODO Auto-generated method stub
		System.out.println("-----Welcome to Payment Gateway-----");
		double final_cost = cost*discount/100;
		double conv_cost = final_cost;
		System.out.println("Final cost in INR is " + final_cost);
		System.out.println("Please select your desired currency");
		String newLine = System.getProperty("line.separator");
		System.out.println("1. EUR" + newLine + "2. USD" + newLine + "3. GBP" + newLine + "4. AUD" + newLine + "5. JPY" + newLine + "6. INR");
		Scanner sc = new Scanner(System.in);
		String currency_choice = sc.nextLine();
		if(currency_choice.equals("1")) {
			conv_cost = final_cost*81;
			System.out.println("Cost in EUR is " + conv_cost);
		}
		else if(currency_choice.equals("2")) {
			conv_cost = final_cost*(1/67.5);
			System.out.println("Cost in USD is " + conv_cost);
		}
		else if(currency_choice.equals("3")) {
			conv_cost = final_cost*(1/90);
			System.out.println("Cost in GBP is " + conv_cost);
		}
		else if(currency_choice.equals("4")) {
			conv_cost = final_cost*(1/54);
			System.out.println("Cost in AUD is " + conv_cost);
		}
		else if(currency_choice.equals("5")) {
			conv_cost = final_cost*(1/0.6);
			System.out.println("Cost in JPY is " + conv_cost);
		}
		else if(currency_choice.equals("6")) {
			conv_cost = final_cost*1;
			System.out.println("Cost in INR is " + conv_cost);
		}
		else {
			System.out.println("Not a valid choice");
			return;
		}
		System.out.println("Enter 1 to Confirm Payment");
		String payment_choice = sc.nextLine();
		if(payment_choice.equals("1")) {
			System.out.println("Payment confirmed");
			return;
		}
		else {
			System.out.println("Payment Declined");
			return;
		}
	}
}
