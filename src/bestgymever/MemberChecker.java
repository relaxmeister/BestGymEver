/*
 * JavaUtveckling 2018
 */

package bestgymever;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class MemberChecker {

    public static List<Person> getAllActiveMembers(List<Person> allPersons) throws ParseException {
        
       //nuvarande medlem, tidigare medlem, eller obehörig(aldrig varit medlem)
       List<Person> onlyActiveMembers = new ArrayList<>();
 
       long millis=System.currentTimeMillis();
       java.sql.Date newDate = new java.sql.Date(millis); 
       //you can print current date in java. it doesnt print time.

       for (Person p : allPersons){ //vi går igenom person för person
           long test = getDifferenceDays(p.getDate(), newDate);
           
           if (test <= 365)
           { 
               onlyActiveMembers.add(p);
           }
       }
       return onlyActiveMembers;
   }
    
    public static List<Person> getAllInactiveMembers(List<Person> allPersons) throws ParseException {
       //nuvarande medlem, tidigare medlem, eller obehörig(aldrig varit medlem)
       List<Person> onlyInactiveMembers = new ArrayList<>();

       
       long millis=System.currentTimeMillis();
       java.sql.Date newDate = new java.sql.Date(millis); 

       for (Person p : allPersons){ //vi går igenom person för person
           long test = getDifferenceDays(p.getDate(), newDate);
           
           if (test >= 365)
           { 
               onlyInactiveMembers.add(p);
           }
       }
       return onlyInactiveMembers;
   }
    
   /**
    * Räknar ut antal dagar differens mellan dagens datum och medlemsskapets datum
    * @param d1
    * @param d2
    * @return 
    */
   public static long getDifferenceDays(Date d1, Date d2)
   {
       long diff = d2.getTime() - d1.getTime();
       return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
   }

    public static Person whoIsTraining(String input, List<Person> allActiveMembers) throws NullPointerException {
        for (Person p : allActiveMembers) {
            if (input.equalsIgnoreCase(p.getName()) || input.equals(p.getPersonNummer())) {
                //System.out.println(p.getName() + " innehar ett aktivt medlemskap");
                return p;
            }
        }
        //hade kunnat ha text här om att inputen inte uppfyller kravet
        return null;
    }

    public static void isMembershipActive(String input, List<Person> allActiveMembers, List<Person> allInactiveMembers) {
        for (Person p : allActiveMembers) {
            if (input.equalsIgnoreCase(p.getName()) || input.equals(p.getPersonNummer())) {
                System.out.println(p.getName() + " innehar ett aktivt medlemskap");
                return;
            }
        }
        for (Person p : allInactiveMembers) {
            if (input.equalsIgnoreCase(p.getName()) || input.equals(p.getPersonNummer())) {
                System.out.println(p.getName() + " är en föredetta medlem");
                return; //gör att vi inte fortsätter utan hoppar ur metoden
            }
        }
        System.out.println(input + " finns inte i systemet, ä därför obehörig");
        return;
    }
}
