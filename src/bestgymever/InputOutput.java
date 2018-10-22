/*
 * JavaUtveckling 2018
 */

package bestgymever;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class InputOutput {

    public static List<Person> readDataFromFile(String readFromFile) throws ParseException {

        String firstLine;
        String secondLine;
        Path inFilePath;
        List<Person> personList = new ArrayList<>();
        String[] personDataPartsFirstLine = new String[3];
        Date date1 = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        inFilePath = Paths.get(readFromFile);

        try(Scanner fileScanner = new Scanner(inFilePath)){   

            while(fileScanner.hasNext()){

                firstLine = fileScanner.nextLine();
                personDataPartsFirstLine = firstLine.split(",");
                
                if (fileScanner.hasNext()){
                    secondLine = fileScanner.nextLine().trim();
                    date1 = formatter1.parse(secondLine);
                }

                Person p = new Person(personDataPartsFirstLine[0].trim(),
                                      personDataPartsFirstLine[1].trim(), 
                                      date1);
                personList.add(p);
            }
        }

        catch (IOException e){
            System.out.println("Fel inträffade vid läsning från fil");
            e.printStackTrace();
            System.exit(0);
        }
        return personList;
        //finally behövs inte när vi har try-with-resources
    }

    

    public static void writeDataToFile(String writeToFile, List<Person> prunedDownPersonList){

        Path outFilePath = Paths.get(writeToFile);

        try(PrintWriter w = new PrintWriter(Files.newBufferedWriter(outFilePath, UTF_8))){
            //standardOpenOption.APPEND, värt att kika på?
            w.println("Träningsdag:\tPersonnummer:\tNamn:");
            for ( Person p : prunedDownPersonList){
                //System.out.println("name: " + p.getName()); //printern uppdaterar steget efter
                w.println(p.getDate() + "\t" + p.getPersonNummer() + "\t" + p.getName() + "\n\t");
            }
        }
        catch (FileNotFoundException e){

            System.out.println("Filen kunde inte hittas");
            e.printStackTrace();
            System.exit(0);
        }
        catch (IOException e){

            System.out.println("Det gick inte att skriva till fil");
            e.printStackTrace();
            System.exit(0);
        }
        catch (Exception e){

            System.out.println("Något gick fel");
            e.printStackTrace();
            System.exit(0);
        }
    }
}
