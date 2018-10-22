/*
 * JavaUtveckling 2018
 */

package bestgymever;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.text.SimpleDateFormat;
//import java.text.format.DateTimeFormatter;
import java.time.LocalTime;
import javax.swing.JOptionPane;
//import java.text.

public class BestGymEver {


    public static void main(String[] args) throws ParseException {
        
        //Vi vill kunna skriva in persons uppgifter för att se om kunden finns i systemeet eller inte samt skicka tillbaka ifromation
        //Vi kommer vilja skriva in på ett sätt som kan jämföras med listan?
        //tools - create/update tests kolla tidigare exempel
        
        
        String filePath = "src\\bestgymever\\customers.txt";

        //String outFilePathString = "src\\bestgymever\\ActiveMembers.txt";
        //String outFilePathStringtwo = "src\\bestgymever\\InactiveMembers.txt";
        String outFilePathStringThree = "src\\bestgymever\\TrainingFrequency.txt";
        String namnEllerNr = "";
        List <Person> activeMembers = new ArrayList<>(); 
        List <Person> InactiveMembers = new ArrayList<>();
        List <Person> personList = InputOutput.readDataFromFile(filePath);
        List <Person> trainingFrequency = new ArrayList<>();

        activeMembers = MemberChecker.getAllActiveMembers(personList);

        InactiveMembers = MemberChecker.getAllInactiveMembers(personList);
        
        boolean switchCase = true;
        boolean menuCase = true;
        String menuSelection = "";
        
        while (menuCase)
        {
            menuSelection = JOptionPane.showInputDialog("[1] Kolla upp medlemsskap\n"+
                                                        "[2] Registrering av ankomst\n"+
                                                        "[3] Exit");
            if (menuSelection == null) { System.exit(0); }
            else
            {
                switch (menuSelection)
                {
                    case "1":
                        //menuCase = false;
                        namnEllerNr = JOptionPane.showInputDialog("fyll i ditt namn eller personnummer:");
                        try{
                        MemberChecker.isMembershipActive(namnEllerNr.trim(), activeMembers, InactiveMembers); //är input en medlem?
                        }
                        catch(NullPointerException e)
                        {
                            //för att inte utlösa error vid avbryt/kryss test
                        }     
                        break;
                    case "2":
                        menuCase = false;
                        while (switchCase) //verkar inte addera till listan
                        {
                            namnEllerNr = JOptionPane.showInputDialog("fyll i ditt namn eller personnummer:");
                            if (namnEllerNr == null) 
                            { 
                                //användaren har klickat kryss eller avbryt
                                switchCase = false;
                            }
                            try{
                                Person ourGuy = MemberChecker.whoIsTraining(namnEllerNr.trim(), activeMembers);
                                if (ourGuy == null)
                                {
                                    System.out.println("Namnet eller numret som angavs stämmer inte"
                                                     + ", kommer därför inte sparas.");
                                }
                                else if (ourGuy != null)
                                {
                                    Person kund = FrequencyChecker.addOccasion(ourGuy);
                                    trainingFrequency.add(kund);
                                    System.out.println("Träningstid logförd");
                                    InputOutput.writeDataToFile(outFilePathStringThree, trainingFrequency);
                                }
                            }
                            catch(NullPointerException e) //om inget skrivs in eller om det var för krysset
                            {
                                 //för att inte utlösa error vid avbryt/kryss
                            }
                        }
                        
                        break;
                    case "3":
                        System.out.println("programmet avslutas");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("felaktigt val");
                        break;
                }
            }
        }
    }
}
