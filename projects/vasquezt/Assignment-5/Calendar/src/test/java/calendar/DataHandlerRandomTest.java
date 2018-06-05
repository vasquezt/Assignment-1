package calendar;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Random;
import java.util.GregorianCalendar;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;	
	
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"deleteAppt","getApptRange"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
    
    public static Appt RandomGenerateAppt(Random random) {
		 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 2);
		 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 2);
		 int startDay=ValuesGenerator.getRandomIntBetween(random, 2, 3);
		 int startMonth=ValuesGenerator.getRandomIntBetween(random, 2, 3);
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
    public static GregorianCalendar RandomGenerateDay(Random random) {
		 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 4);
		 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 4);
		 int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
		 GregorianCalendar thisDay = new GregorianCalendar(startYear, startMonth, startDay);		 
		 return thisDay;
    }
    
    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	 @Test
	 public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;	 
		 
		 System.out.println("Start testing...");
		 long randomseed =System.currentTimeMillis(); //10		 
		 try{ 		 
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 //System.out.println(" Seed:"+randomseed );
				 Random random = new Random(randomseed);

				 DataHandler dataHandler;
				 dataHandler = new DataHandler();
				 
				 int totApointments = ValuesGenerator.getRandomIntBetween(random, 0, 5);
				 for(int i = 0; i < totApointments; i++) { //Fill Datahandler with 0-4 Appts
			         Appt appt = RandomGenerateAppt(random);
			         dataHandler.saveAppt(appt);
				 }
				 for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = DataHandlerRandomTest.RandomSelectMethod(random);
					if (methodName.equals("deleteAppt")){
						dataHandler.deleteAppt(RandomGenerateAppt(random));
					}
					if (methodName.equals("getApptRange")) {
						LinkedList<CalDay> calDays = new LinkedList<CalDay>();
						GregorianCalendar firstDay = RandomGenerateDay(random);
			 	        GregorianCalendar lastDay = RandomGenerateDay(random);
			 	        if(firstDay.before(lastDay)) {
			 	        	calDays = (LinkedList<CalDay>) dataHandler.getApptRange(firstDay,lastDay);						}
						}
					}	
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			     if((iteration%10000)==0 && iteration!=0 )
			    	 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);			 
			 }		
		 
		 
		 }catch(NullPointerException e) {
		 
		 }
	 }
}
