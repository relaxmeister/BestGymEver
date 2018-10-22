/*
 * JavaUtveckling 2018
 */

package bestgymever;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class FrequencyChecker {
    
    public List<Person> frequencyList = new ArrayList<>();
    
    /**
     * 
     * @param inputPerson
     * @return
     * @throws ParseException 
     */
    //public static List<Person> addOccasion(Person inputPerson) throws ParseException {
    public static Person addOccasion(Person inputPerson) throws ParseException {
       
       //nuvarande medlem, tidigare medlem, eller obehörig(aldrig varit medlem)
       List<Person> frequencyList = new ArrayList<>();

       long millis=System.currentTimeMillis();
       java.sql.Date newDate = new java.sql.Date(millis); 
       //you can print current date in java. it doesnt print time.
               
       //kopierar över person till ett nytt personobject
       Person k = new Person(inputPerson.getPersonNummer(), inputPerson.getName(), 
                        newDate);

       frequencyList.add(k); //den tar gång på gång och byter ut mot k

       return k;
   }

}
