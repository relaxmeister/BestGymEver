/*
 * JavaUtveckling 2018
 */
package bestgymever;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class InputOutputTest {
    
    
    /**
     * Test of readDataFromFile method, of class InputOutput.
     */
    @Test
    public void readDataFromFileTest() throws Exception {
        //try{
        TestCase.assertNotNull(InputOutput.readDataFromFile("src\\bestgymever\\customers.txt")); 
        //påvisar att vi fått ut någonting, vår lista
        //vår funktion ger oss en lista som vi efterfrågar
        System.out.println(InputOutput.readDataFromFile("src\\bestgymever\\customers.txt"));
    
    }

    /**
     * Test of writeDataToFile method, of class InputOutput.
     */
    @Test
    public void writeDataToFileTest() {
        
    }
    
}
