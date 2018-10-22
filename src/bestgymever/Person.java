/*
 * JavaUtveckling 2018
 */

package bestgymever;

import java.util.Date;

public class Person {

   private String personNummer;
   private String name;
   private Date date;

   public Person(String personNummer, String name, Date date)
   {
       this.name = name;
       this.personNummer = personNummer;
       this.date = date;
   }

   public String getName()
   {
       return name;
   }

   public Date getDate()
   {
       return date;
   }
   
   public String getPersonNummer()
   {
       return personNummer;
   }
    
}
