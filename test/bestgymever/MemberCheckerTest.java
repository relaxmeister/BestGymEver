/*
 * JavaUtveckling 2018
 */
package bestgymever;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class MemberCheckerTest {
    

    MemberChecker c = new MemberChecker(); // om inte static
        
    
    /*@Test
    public final void operatorSupportedTest() {
        TestCase.assertTrue(c.operatorSupported("+"));
        TestCase.assertFalse(c.operatorSupported("a"));*/
    /*    public void timeLeftTest() {
        
        int timeLeftOnTape = 400;
        int testing = 30;
        
        LocalTime startTime = LocalTime.of(14, 30);
        LocalTime endTime = LocalTime.of(15, 30);
       
        TestCase.assertTrue(r.timeLeft(timeLeftOnTape, startTime, endTime));
        TestCase.assertEquals(true, r.timeLeft(timeLeftOnTape, startTime, endTime));
        TestCase.assertEquals(false, r.timeLeft(testing, startTime, endTime));*/
        
        

    /**
     * Test of getAllActiveMembers method, of class MemberChecker.
     */
    @Test
    public void getAllActiveMembersTest() throws Exception {
        
        //TestCase.assertTrue(MemberChecker.);
        
    }

    /**
     * Test of getAllInactiveMembers method, of class MemberChecker.
     */
    @Test
    public void getAllInactiveMembersTest() throws Exception {
    }

    
    
    /**
     * Test of whoIsTraining method, of class MemberChecker.
     */
    @Test
    public void whoIsTrainingTest() {

    String input1 = "1515151515";
    String input2 = "1414141414";
    String input3 = "1212121212";
    
    List<Person> activeMembers = new ArrayList<>();
    Date aDate = new Date();
    Person correctPerson1 = new Person("1515151515", "Peter Nilsson", aDate);
    Person correctPerson2 = new Person("1414141414", "Jeffe Leffe", aDate);
    
    activeMembers.add(correctPerson1);
    activeMembers.add(correctPerson2);
    
    Person thisGuy = MemberChecker.whoIsTraining(input1, activeMembers);
    Person otherGuy = MemberChecker.whoIsTraining(input2, activeMembers);
    
    
    //expected, actual
    TestCase.assertEquals(correctPerson1, thisGuy); //i metoden får vi tillbaka person som stämmer med inmatning
    TestCase.assertEquals(correctPerson2, otherGuy);
    TestCase.assertFalse(input3.equals(otherGuy.getPersonNummer()));
    TestCase.assertTrue(input2.equals(otherGuy.getPersonNummer()));
    
    //denna checkar av att vår return null funkar som den ska
    TestCase.assertNull(MemberChecker.whoIsTraining("felNamnNr", activeMembers));
    //inmatning som inte stämmer gör att vi returnerar ingenting, alltså korrekt
        
    }

    /**
     * Test of isMembershipActive method, of class MemberChecker.
     */
    @Test
    public void isMembershipActiveTest() {
    }
    
    @Test
    public void getDifferenceDaysTest() throws ParseException {
   /* public static long getDifferenceDays(Date d1, Date d2)
   {
       long diff = d2.getTime() - d1.getTime();
       return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
   }*/
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        
        String dagen1 = "2016-01-01";
        String dagen2 = "2018-07-08";
        String dagen3 = "2018-07-08";
        
        Date date1 = formatter1.parse(dagen1);
        Date date2 = formatter1.parse(dagen2);
        Date date3 = formatter1.parse(dagen3);
        
        //int differens1 = (int) MemberChecker.getDifferenceDays(date2, date3);
        System.out.println(MemberChecker.getDifferenceDays(date2, date3));
        System.out.println((MemberChecker.getDifferenceDays(date1, date2)));
        System.out.println((MemberChecker.getDifferenceDays(date2, date1)));
        
        //actual, expected
        
        TestCase.assertTrue((MemberChecker.getDifferenceDays(date1, date2)) > 0);
        TestCase.assertTrue((MemberChecker.getDifferenceDays(date2, date1)) < 0);
        TestCase.assertEquals(0, MemberChecker.getDifferenceDays(date2, date3));
        TestCase.assertFalse(((MemberChecker.getDifferenceDays(date3, date1)) > 0));
    }  
}
