/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
  }
//Test is on functionality/hastimeSet
@Test(timeout = 4000)
 public void test01()  throws Throwable  {
	Appt appt0 = new Appt(3, 3, 3, 3, 2018, "Birthday Party", "My Birthday", "vasquezt@boy.com");
    assertFalse(appt0.isRecurring());	
    assertFalse(appt0.isOn(1, 2, 3));	
    assertTrue(appt0.isOn(3, 3, 3));	 
    assertTrue(appt0.hasTimeSet());

}
//Test alternate constructor/hastime set
@Test(timeout = 4000)
public void test02()  throws Throwable  {
    Appt appt0 = new Appt(9, 14, 2018, "Picnic", "Date at the park", "xyz@gmail.com");
    String string0 = appt0.toString();
    assertFalse(appt0.hasTimeSet());
}
//Here we will test the valididty of SetValid()
@Test(timeout = 4000)
public void test03() throws Throwable {
	Appt appt0 = new Appt(-1, -1, -1, -1, -1, "Hello", "Wasup", "gmail");
	appt0.setValid();
	Appt appt1 = new Appt(1, 1, 1, 1, 1, "Hello", "Wasup", "gmail");
	appt1.setValid();
	Appt appt2 = new Appt(25, 1, 1, 2, 1, "Hello", "Wasup", "gmail");	
	appt2.setValid();
	Appt appt3 = new Appt(0, 1, 1, 2, 1, "Hello", "Wasup", "gmail");	
	appt3.setValid();
	Appt appt4 = new Appt(1, 1, 1, 2, 1, "Hello", "Wasup", "gmail");
	appt4.setValid();
	Appt appt5 = new Appt(1, 61, 1, 2, 1, "Hello", "Wasup", "gmail");	
	appt5.setValid();
	Appt appt6 = new Appt(1, 1, 30, 1, 1, "Hello", "Wasup", "gmail");
	appt6.setValid();
	Appt appt7 = new Appt(1, 1, 30, 2, 1, "Hello", "Wasup", "gmail");
	appt7.setValid();
	Appt appt8 = new Appt(1, 1, 30, 3, 1, "Hello", "Wasup", "gmail");
	appt8.setValid();
	Appt appt9 = new Appt(1, 1, 10, 10, 0, "Hello", "Wasup", "gmail");
	appt9.setValid();
	Appt appt10 = new Appt(1, 1, 10, 10, 20, "Hello", "Wasup", "gmail");
	appt10.setValid();	
	
}

@Test(timeout = 4000)
public void test04() throws Throwable {
	Appt appt0 = new Appt(1, 1, 1, 1, 1, "Hello", "Wassup", "Gmail");
	int[] recurDaysArr= {2, 3, 4};
	appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
	
	Appt appt1 = new Appt(1, 1, 1, 1, 1, "Hello", "Wassup", "Gmail");
	int[] recurDaysArr1= {2, 3, 4};
	appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_YEARLY, 4, 20);
}

}
