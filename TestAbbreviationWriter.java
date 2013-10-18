/**
 * TestAbbreviationWriter.java
 *
 * @author Brice Colbert
 * @version 16 OCT 2013
 */

import java.util.Scanner;
import java.util.HashMap;
import java.io.*;

/**
 * Class name: TestAbbreviationWriter
 * Inheritance: none
 * Functionality: The TestAbbreviationWriter class takes as input two arguments
 *                from the command line - The name of a file where abbreviations
 *                are defined and the name of the text file to be read/written 
 *                to. Two Writer objects are created and wrapped in the 
 *                AbbreviationWriter.
 * Visibility: public
 */
public class TestAbbreviationWriter{

    final String OUTPUT_FILE_NAME = "outfile.txt"; // File to be written out
    private HashMap<String, String> abbMap; // abbreviation definitions
    private Scanner abbScan; // Abbreviations File Scanner
    private Scanner inScan;  // Input File Scanner

    /**
     * Method name: TestAbbreviationWriter
     * Functionality: Initializes the Test environment state and runs the
     *                accompanying test. All additional methods in the 
     *                class are simple helper methods for this constructor
     *                to make the class more readable.
     * @param String abbFile
     * @param String inFile
     */
    public TestAbbreviationWriter(String abbFile, String inFile){
	// Open up the scanners and initialize the hashmap
	try { 
	    abbScan = new Scanner(new BufferedReader(new FileReader(abbFile)));
	    inScan = new Scanner(new BufferedReader(new FileReader(inFile)));
	    abbMap = populateHashMap(abbScan, "@");
	    abbScan.close();
	} catch (FileNotFoundException e) {
	    printUsageAndExit();
	} 
	
	// Initializes the writers, reads the input by line, writes the output 
	try {
	    File file = new File(OUTPUT_FILE_NAME);
	    if(!file.exists()) file.createNewFile();
	    AbbreviationWriter abbWriter1 = new AbbreviationWriter(new BufferedWriter(new FileWriter(file.getAbsoluteFile())), abbMap);
	    StringWriter stringWriter = new StringWriter();
	    AbbreviationWriter abbWriter2 = new AbbreviationWriter(stringWriter, abbMap); 
	    while(inScan.hasNext()) {             
		String line = inScan.nextLine();  // Reads input from the file line by line
		abbWriter1.write(line);           // Writes to the FileWriter
		abbWriter2.write(line);           // Writes to the StringWriter
	    }
	    System.out.println("" + stringWriter.toString());
	    abbWriter1.close();
	    abbWriter2.close();
	    inScan.close();
	} catch (IOException e){
	    e.printStackTrace();
	}
    }

    /**
     * Method name: populateHashMap
     * Functionality: Scans a file for abbreviations in the format 
     *                ABB abbreviation
     *                Populates a HashMap with the abbreviations as keys
     *                and the expansions as values. Prefixes the keys with
     *                the provided String delimiter.
     * Visibility: private
     * @param Scanner scan
     * @param String delimiter
     * @return HashMap<String, String>
     */
    private HashMap<String, String> populateHashMap(Scanner scan, String delimiter){
	HashMap<String, String> newMap = new HashMap<String, String>();
	while(scan.hasNext()){
	    String[] parts = (scan.nextLine()).split("\\s+", 2);
	    newMap.put((delimiter+parts[0]).toLowerCase(), parts[1]);
	}
	return newMap;
    }    
    
    /**
     * Method name: printUsageAndExit
     * Functionality: Prints instructions for using the test class.
     * Visibility: public
     */
    public static void printUsageAndExit(){
	System.out.println("***** TestAbbreviationWriter *****");
	System.out.println("Requires two command line arguments:");
	System.out.println("1) The name of a file containg a list of abbreviations.");
	System.out.println("2) The name of the file to be read/written to.");
	System.out.println("Example: java TestAbbreviationWriter chatacronyms.txt chat.txt");
	System.exit(0);
    }

    /**
     * Method name: main
     * Inheritance: none
     * Functionality: Checks that at least two arguments were passed. Creates
     *                a new test object to start the testing of AbbreviationWriter
     * @param String[] args
     */
    public static void main(String[] args){
	if(args.length < 2) printUsageAndExit();
	TestAbbreviationWriter testWriter = new TestAbbreviationWriter(args[0], args[1]);
    }
}