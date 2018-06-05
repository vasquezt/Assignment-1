
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  DataHandler dataHandler;
	  dataHandler = new DataHandler();


  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	  Calendar calendar1 = new GregorianCalendar(2015, 10, 10);
	  Calendar calendar2 = new GregorianCalendar(2016, 4, 3);	  
	  CalDay calday1 = new CalDay((GregorianCalendar) calendar1);
	  CalDay calday2 = new CalDay((GregorianCalendar) calendar2);
	  Appt appt0 = new Appt(1, 1, 1, 1, 1, "Hello", "Wasup", "gmail");
	  Appt appt1 = new Appt(2, 2, 1, 1, 1, "Hello", "Wasup", "gmail"); 
	  calday1.addAppt(appt0);
	  calday2.addAppt(appt1);
	  DataHandler dataHandler;
	  dataHandler = new DataHandler();
      LinkedList<CalDay> calDays = new LinkedList<CalDay>();
	  //calDays = (LinkedList<CalDay>) dataHandler.getApptRange(calday1,calday2);	

  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {  
	
	  DataHandler dataHandler;
	  dataHandler = new DataHandler();
	  
	Calendar rightnow = Calendar.getInstance();
	  
	int thisMonth = rightnow.get(Calendar.MONTH);  
	int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
	int thisYear = rightnow.get(Calendar.YEAR);
	
	GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
	GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth,thisDay);  
	
	tomorrow.add(today.DAY_OF_MONTH,1);	
	
	LinkedList<CalDay> calDays = new LinkedList<CalDay>();
	calDays = (LinkedList<CalDay>) dataHandler.getApptRange(today,tomorrow);	
  
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
		
	  DataHandler dataHandler;
	  dataHandler = new DataHandler();
	  
	Calendar rightnow = Calendar.getInstance();
	  
	int thisMonth = rightnow.get(Calendar.MONTH);  
	int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
	int thisYear = rightnow.get(Calendar.YEAR);
	  
	GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
	GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth,thisDay);  
	
	tomorrow.add(today.DAY_OF_MONTH,1);		
	
	Appt appt0 = new Appt(1, 1, 1, 1, 1, "Hello", "Wassup", "Gmail");
	int[] recurDaysArr= {2, 3, 4};
	appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
	
	Appt appt1 = new Appt(1, 1, 1, 1, 1, "Hello", "Wassup", "Gmail");
	int[] recurDaysArr1= {2, 3, 4};
	appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_YEARLY, 4, 20);
	
	dataHandler.saveAppt(appt0);
	dataHandler.saveAppt(appt1);
	
  }
  
}
