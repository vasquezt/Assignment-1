/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import calendar.Appt;
import calendar.CalDay;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  CalDay calday1 = new CalDay();	  

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	  Calendar calendar = new GregorianCalendar(2015, 10, 10);
	  CalDay calday1 = new CalDay((GregorianCalendar) calendar);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
	  Calendar calendar = new GregorianCalendar(2015, 10, 10);
	  CalDay calday1 = new CalDay((GregorianCalendar) calendar);
	  Appt appt0 = new Appt(-1, -1, -1, -1, -1, "Hello", "Wasup", "gmail");
	  calday1.addAppt(appt0);  
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
	  Calendar calendar = new GregorianCalendar(2015, 10, 10);
	  CalDay calday1 = new CalDay((GregorianCalendar) calendar);
	  Appt appt0 = new Appt(-1, -1, -1, -1, -1, "Hello", "Wasup", "gmail");
	  calday1.addAppt(appt0);
  }
  
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
	  Calendar calendar = new GregorianCalendar(2015, 10, 10);
	  CalDay calday1 = new CalDay((GregorianCalendar) calendar);
	  Appt appt0 = new Appt(1, 1, 1, 1, 1, "Hello", "Wasup", "gmail");
	  Appt appt1 = new Appt(2, 2, 1, 1, 1, "Hello", "Wasup", "gmail"); 
	  calday1.addAppt(appt0); 
	  int i;
	  i = calday1.getSizeAppts();
	  i = calday1.getDay();
	  i = calday1.getMonth();
	  i = calday1.getYear();
  } 
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
	  Calendar calendar = new GregorianCalendar(2015, 10, 10);
	  CalDay calday1 = new CalDay((GregorianCalendar) calendar);
	  Appt appt0 = new Appt(1, 1, 1, 1, 1, "Hello", "Wasup", "gmail");
	  Appt appt1 = new Appt(2, 2, 1, 1, 1, "Hello", "Wasup", "gmail"); 
	  calday1.addAppt(appt0);
	  calday1.addAppt(appt1);
	  String returnstring;
	  returnstring = calday1.toString();
	  returnstring = calday1.getFullInfomrationApp(calday1);
  }	
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
	  Calendar calendar = new GregorianCalendar(2015, 10, 10);
	  CalDay calday1 = new CalDay((GregorianCalendar) calendar);
	  Appt appt0 = new Appt(1, 1, 1, 1, 1, "Hello", "Wasup", "gmail");
	  Appt appt1 = new Appt(2, 2, 1, 1, 1, "Hello", "Wasup", "gmail"); 
	  calday1.addAppt(appt0);
	  String returnstring;
	  
  }	  
}

