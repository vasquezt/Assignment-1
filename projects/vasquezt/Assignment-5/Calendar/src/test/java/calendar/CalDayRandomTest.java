package calendar;

import java.util.Calendar;
import org.junit.Test;
import java.util.LinkedList;
import java.util.GregorianCalendar;
import java.util.Random;


import static org.junit.Assert.*;





/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;	
	
    public static Appt RandomGenerateAppt(Random random) {
		 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 10);
		 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 10);
		 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 10);
		 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 10);
		 int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 String emailAddress="xyz@gmail.com";

		 //Construct a new Appointment object with the initial data	 
		 //Construct a new Appointment object with the initial data	 
        Appt appt = new Appt(startHour,
                 startMinute ,
                 startDay ,
                 startMonth ,
                 startYear ,
                 title,
                description,
                emailAddress);
        return appt;
    }	
	
	
	

    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	 public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 
		 System.out.println("Start testing...");
		 try{ 		 
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed =System.currentTimeMillis(); //10
				 //System.out.println(" Seed:"+randomseed );
				 Random random = new Random(randomseed);	 
				 
				 for (int j = 0; j < NUM_TESTS; j++) {
					 DataHandler datahandler = new DataHandler();
					 CalDay newDay = new CalDay();					 
					 Appt appt = RandomGenerateAppt(random);
					 newDay.addAppt(appt);
				 }
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 }		
		 }catch(NullPointerException e) {
		 
		 }
	 }
}
