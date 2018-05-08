
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
 /* @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	  Calendar calendar1 = new GregorianCalendar(2015, 10, 10);
	  Calendar calendar2 = new GregorianCalendar(2016, 4, 3);	  
	  CalDay calday1 = new CalDay((GregorianCalendar) calendar);
	  CalDay calday2 = new CalDay((GregorianCalendar) calendar);
	  Appt appt0 = new Appt(1, 1, 1, 1, 1, "Hello", "Wasup", "gmail");
	  Appt appt1 = new Appt(2, 2, 1, 1, 1, "Hello", "Wasup", "gmail"); 
	  calday1.addAppt(appt0);
	  calday2.addAppt(appt1);
	  DataHandler dataHandler;
	  dataHandler = new DataHandler(); 
	  List<CalDay> mylist = new ArrayList<CalDay>();
	  mylist = dataHandler.getApptRange(calendar1, calendar2);

  }*/

}
