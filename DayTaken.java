import java.util.Random;
// This interface will generate random numbers to output to the person using the program a random date and time that is taken
public interface DayTaken
{
   Random rand = new Random();
   
	//These variables hold a random day, month, and hour
	int randDay = rand.nextInt(32);
	int randMonth = rand.nextInt(13);
	int randHour = rand.nextInt(13);
	int year = 2025;

	//This initializes a void statement
  	 void dayDisplay();

	void changeDay(int randDay, int randMonth, int randHour);
}
