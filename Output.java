/* This program will act like a website for this community garden. Anyone can make an appointment or make donations that will be given on the screen. After the user is done, the program will output a text file with all the information needed */

// Package needed to scan user input and to create a random number

// Package needed to scan user input
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//This class creates a file in order to save the person's receipt
class CreateFile 
{
    public void fileMake()
    {
    	try {
      	   File file = new File("Receipt.txt");
      	     if (file.createNewFile()) 
      	     {
           	System.out.println("File created: " + file.getName());
     	     } 
      	     else 
      	     {
           	System.out.println("File already exists.");
      	     }
    	   } catch (IOException e) 
      	     {
     	 	System.out.println("An error occurred.");
      		e.printStackTrace();
      	     }
    }
}

//This class writes on the text file to save the receipt
class Write {

//Variables
Info info = new Info();
Appointment app = new Appointment();
Donations donos = new Donations();

   public void writeFile()
   {
    try {
      FileWriter writer = new FileWriter("Receipt.txt");
      writer.write(info.getFirstName() + " " + info.getLastName() + "\n" + info.getEmail() + " " + info.getNumber() + "\n" + app.getMonth() + "/" + app.getDay() + "/" + app.getYear() + "\n" + app.getHour() + app.getTime() + "\n" + "Donations:"+ "\n" + "Money: $ " + donos.getMon() + "\n" + "Seeds: " + donos.getSeed() + " bags" + "\n" + "Soil: " + donos.getSoil() + "lbs" + "\n" + "Fertilizer: " + donos.getFert() + "lbs"+ "\n" + "Labor: " + donos.getLab() + " hours" + "\n" + "Tools: " + donos.getTools() + " tools");
      writer.close();
      System.out.println("Successfully wrote to the file!");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
   }
}

//This class implements both interfaces DayTaken and Welcome to output the random date and time
class Display implements DayTaken, Welcome
{
	public void changeDay( int randDay, int randMonth, int randHour)
	{
		// If the random number chosen happens to be zero, this will randomize the numbers even more by adding one
		if(randDay == 0 || randMonth == 0 || randHour == 0){
			randDay++;
			randMonth++;
		 	randHour++;
  		}
	}


   //Outputs the random date and time
   public void dayDisplay()
   {
	System.out.println("This day is already taken: " + randMonth + "/" + randDay + "/" + year + " at " + randHour);
   }

   //Outputs the random produce
   public void welcomeDisplay()
   {
	System.out.println("Here at the garden you can find many produce such as: ");
	for (int loop = 0; loop < produce.length; loop++)
	{
	   System.out.println(produce[loop] + " ");
	}
}}

//This class will hold all the user's input like first, last name, email, and number
class Info
{
   //Variables
   static Scanner userS = new Scanner(System.in);
   private static String email;
   private static String number;
   public static String firstName;
   public static String lastName;

   //This is to get into the private variable email
   static void setEmail(String e) { email = e; }
   String getEmail() { return email; }

   //This is to get into the private variable number
   static void setNumber(String n) { number = n; }
   String getNumber() { return number;}
   String getFirstName() {return firstName;}
   String getLastName() {return lastName;}
   
   //Asks users for these variables
   public static void Questions()
   {
	   System.out.println("Enter your first name: ");
		firstName = userS.nextLine();
		

		System.out.println("Enter your last name: ");
		lastName = userS.nextLine();
		

		System.out.println("Enter your email: ");
		setEmail(userS.nextLine());
		
		
		System.out.println("Enter your number: ");
		setNumber(userS.nextLine());
		
   }
}

//This class inherits the Info class to output all the user input
class Appointment extends Info
{
   //Variables
   Info inf = new Info();
   public static int day;
   public static int month;
   public static int year;
   public static int hour;
   public static char time;
   
   int getDay() {return day;}
   int getMonth() {return month;}
   int getYear() {return year;}
   int getHour() {return hour;}
   char getTime() {return time;}

   //Shows the info the user has inputed thusfar
   public void showInfo()
   {
	System.out.println("Name: " + inf.getFirstName() + " " + inf.getLastName());
	System.out.println("Email: " + inf.getEmail());
	System.out.println("Phone Number: " + inf.getNumber());
	System.out.println("Date chosen: "  + month + "/" + day + "/" + year);
	System.out.println("Hour chosen: " + hour + time);
   }
}

//This class asks the user if they want to donate
class Donations
{
   //Variables
   Scanner userS = new Scanner(System.in);
   public static double money = 0.0;
   public static int seeds = 0;
   public static float soil = 0;
   public static float fert = 0;
   public static int labor = 0;
   public static int tools = 0;
   public static int choice = 0;

   public void donos()
   {
	System.out.println("What would you like to donate? Please type the number corresponding to the option:\n1: Money\n2: Seeds\n3: Soil\n4: Fertilizer\n5: Labor\n6: Tools\n7: Done");
	choice = userS.nextInt();

	//Catches if the user input anything invalid
	while( choice == 0 || choice > 7)
	{
	   System.out.println("Sorry, you have chosen an invalid number, please try again: ");
	   choice = userS.nextInt();
	}

	while(choice != 7)
        {
	//This switch switches between the different options the user would want to have
	switch(choice){
	case 1: System.out.println("How much money would you like to donate?: ");
		money += userS.nextDouble();
		break;
	case 2: System.out.println("How many bags of seeds would you like to donate?: ");
		seeds += userS.nextInt();
		break;

	case 3: System.out.println("How many pounds of soil would you like to donate?: ");
		soil += userS.nextFloat();
		break;

	case 4: System.out.println("How many pounds of fertilizer would you like to donate?: ");
		fert += userS.nextFloat();
		break;

	case 5: System.out.println("How many hours of labor would you like to do?: ");
		labor += userS.nextInt();
		break;

	case 6: System.out.println("How many tools would you like to donate?: ");
		tools += userS.nextInt();
		break;
	}

	System.out.println("What else would you like to donate?: \n1: Money\n2: Seeds\n3: Soil\n4: Fertilizer\n5: Labor\n6: Tools\n7: Done");
	choice = userS.nextInt();

        }
	System.out.println("Thank you for donating!");
   }

   //Returns each variable as it's needed type
   public Double getMon()
   {
	return money;
   }
   public int getSeed()
   {
	return seeds;
   }
   public Float getSoil()
   {
	return soil;
   }
   public Float getFert()
   {
	return fert;
   }
   public int getLab()
   {
	return labor;
   }
   public int getTools()
   {
	return tools;
   }

}

//This is the main class, this will hold the majority of the code
class Output
{
   public static void main(String args[])
   {	
	   //Variables
	try (Scanner userS = new Scanner(System.in)) {
		Info info = new Info();
		Appointment app = new Appointment();
		Display dis = new Display();
		Donations dono = new Donations();
		CreateFile file = new CreateFile();
		Write text = new Write();
		char choice;

		//Welcomes the user to the "website"
		System.out.println("Welcome to the Moreno Valley College Community Garden!");
		dis.dayDisplay(); //Takes the random date and tells the user that it's taken
		dis.welcomeDisplay(); //Shows some produce
		System.out.println("With that in mind please input when you would like to visit the garden.");
		info.Questions(); //Calls the question void

		//Does the loop once but if the date chosen is the same as the random date already taken, it asks the user again to pick a different date
		do{

		System.out.println("Please input the number of the month you'd like to visit: ");
		app.month = userS.nextInt();

		//Catches if invalid
		while(app.getMonth() == 0 || app.getMonth() > 13)
		{
		   System.out.println("This input is invalid, please try again: ");
		   app.month = userS.nextInt();
		}

		System.out.println("Please input the number of the day you'd like to visit: ");
		app.day = userS.nextInt();

		//Catches if invalid
		while(app.getMonth() == 2 && app.getDay() == 29 || app.getMonth() == 2 && app.getDay() == 30 || app.getMonth() == 2 && app.getDay() == 31)
		{
		   System.out.println("This day is invalid for this month, please input day again: ");
		   app.day = userS.nextInt();
		}
		
		//Catches if invalid
		while(app.getMonth() == 2 && app.getDay() == 31 || app.getMonth() == 4 && app.getDay() == 31 || app.getMonth() == 6 && app.getDay() == 31 || app.getMonth() == 9 && app.getDay() == 31 || app.getMonth() == 11 && app.getDay() == 31)
		{
		   System.out.println("This day is invalid for this month, please input day again: ");
		   app.day = userS.nextInt();
		}
		
		//Catches if invalid
		while(app.getDay() > 31)
		{
		   System.out.println("This day is invalid, please input day again: ");
		   app.day = userS.nextInt();
		}

		System.out.println("Please input the year you'd like to visit: ");
		app.year = userS.nextInt();

		//Catches if invalid
		while(app.getYear() > 2025)
		{
		   System.out.println("This year is invalid, please try again: ");
		   app.year = userS.nextInt();
		}

		System.out.println("Please input the time you'd like to go: ");
		app.hour = userS.nextInt();

		System.out.println("Type a for AM, type p for PM: ");
		app.time = userS.next().charAt(0);
		
		//Catches if invalid
		if(app.getTime() != 'a' || app.getTime() != 'A' || app.getTime() != 'p' || app.getTime() != 'P')
		{
		   System.out.println("You did not type a or p, please try again: ");
		   app.time = userS.next().charAt(0);
		}
		
		//Catches if invalid
		if(app.getMonth() == DayTaken.randMonth && app.getDay() == DayTaken.randDay && app.getHour() == DayTaken.randHour)
		{
		   System.out.println("This appointment is already taken, please start again.");
		} }
		while(app.getMonth() == DayTaken.randMonth && app.getDay() == DayTaken.randDay && app.getHour() == DayTaken.randHour);

		app.showInfo();

		System.out.println("Would you like to donate to the garden? Y for yes and n for no: ");
		choice = userS.next().charAt(0);

		//Catches if invalid
		if(choice != 'y' || choice != 'Y' || choice != 'n' || choice != 'N')
		{
		   System.out.println("You did not type y or n, please try again: ");
		   choice = userS.next().charAt(0);
		}

		//This switch switches between the different options the user would want to have
		switch(choice)
		{
		   case'n': System.out.println("Thank you for visiting Moreno Valley's Community Garden!");
			    file.fileMake();
			    text.writeFile();
			    break;

		   case'N': System.out.println("Thank you for visiting Moreno Valley's Community Garden!");
			    file.fileMake();
			    text.writeFile();
			    break;

		   case'y': dono.donos();
			    System.out.println("Thank you for visiting Moreno Valley's Community Garden!");
			    file.fileMake();
			    text.writeFile();
			    break;

		   case'Y': dono.donos();
			    System.out.println("Thank you for visiting Moreno Valley's Community Garden!");
			    file.fileMake();
			    text.writeFile();
			    break;
		}
	}
	
   }}



	