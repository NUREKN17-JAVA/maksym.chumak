package ua.nure.cs.chumak.usermanagement1.domain;

import java.util.Calendar;
import java.util.Date;
import junit.framework.TestCase;


public class UserTest extends TestCase {

  private static final int ETALONE_AGE_1 = 20;
  private static final int ETALONE_AGE_2 = 18;
  private static final int ETALONE_AGE_3 = 13;
  private static final int DAY_OF_BIRTH = 26;
  private static final int MONTH_OF_BIRTH = 3;
  private static final int YEAR_OF_BIRTH = 1999;
  private static final int THIS_YEAR = 2019;
  private static final int MONTH_OF_BIRTH_4 = Calendar.NOVEMBER;
  private static final int ETALONE_AGE_4 = THIS_YEAR - YEAR_OF_BIRTH - 1;
  private static final int MONTH_OF_BIRTH_5 = Calendar.SEPTEMBER;
  private static final int ETALONE_AGE_5 = THIS_YEAR - YEAR_OF_BIRTH;
  private User user;
  private Date dateOfBirth;
  
  public void testGetFullName() {
    user.setFirstName("John");
    user.setLastName("Doe");
    assertEquals("Doe, John", user.getFullName());
  }
  
  public void testGetAge1() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH);
    user.setDateOfBirth(calendar.getTime());
    assertEquals(ETALONE_AGE_1, user.getAge());
  }
  
  public void testGetAge2() {
	Calendar calendar = Calendar.getInstance();
	calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH);
	user.setDateOfBirth(calendar.getTime());
	assertTrue("You are not an adult.", ETALONE_AGE_2 <= user.getAge());
  }

  public void testGetAge3() {
	Calendar calendar = Calendar.getInstance();
	calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH);
	user.setDateOfBirth(calendar.getTime());
	assertTrue("You not have a car license.", ETALONE_AGE_3 < user.getAge());
  }
	  
  public void testGetAge4(){
	Calendar calendar = Calendar.getInstance();
	calendar.set(YEAR_OF_BIRTH,MONTH_OF_BIRTH_4,DAY_OF_BIRTH);
	dateOfBirth = calendar.getTime();
	user.setDateOfBirth(dateOfBirth);
	assertEquals(ETALONE_AGE_4,user.getAge());
  }
  
  public void testGetAge5(){
	Calendar calendar = Calendar.getInstance();
	calendar.set(YEAR_OF_BIRTH,MONTH_OF_BIRTH_5,DAY_OF_BIRTH);
	dateOfBirth = calendar.getTime();
	user.setDateOfBirth(dateOfBirth);
	assertEquals(ETALONE_AGE_5,user.getAge());
  }
  
  protected void setUp() throws Exception {
    super.setUp();
    user = new User();
  }

  protected void tearDown() throws Exception {
    super.tearDown();
  }

}