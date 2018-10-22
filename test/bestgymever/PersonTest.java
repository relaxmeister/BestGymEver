/*
 * JavaUtveckling 2018
 */
package bestgymever;

import java.util.Date;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class PersonTest {
    

    Date date = new Date();
    Person p = new Person("9008160101", "Peter Niklasson", date);
    

    /**
     * Test of getName method, of class Person.
     */
    @Test
    public void getNameTest() {
        //arrange
        final String expected = "Peter Niklasson";
        //Act
        final String actual = p.getName();
        System.out.println(p.getName());
        //assert
        Assert.assertEquals(expected, actual);
        //använder final för vi vill ha konstanter som inte förändras
        
       
        
    }

    /**
     * Test of getDate method, of class Person.
     */
    @Test
    public void getDateTest() {

    }

    /**
     * Test of getPersonNummer method, of class Person.
     */
    @Test
    public void getPersonNummerTest() {
        //arrange
        final String expected = "9008160101";
        //Act
        final String actual = p.getPersonNummer();
        System.out.println(p.getPersonNummer());
        //assert
        Assert.assertEquals(expected, actual);
        TestCase.assertNotNull(p.getPersonNummer());
        
    }
    
}
