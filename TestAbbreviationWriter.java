import java.util.Scanner;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class name: TestAbbreviationWriter
 * Description: The TestAbbreviationWriter class takes as input two arguments
 * from the command line - The name of a file where abbreviations are defined
 * and the name of the text file to be read/written to.
 * Two Writer objects are created and wrapped in the AbbreviationWriter.
 */
public class TestAbbreviationWriter{

    final String OUTPUT_FILE_NAME = "output.txt";
    HashMap<String, String> abbMap;
    Scanner abbScan; // Abbreviations File Scanner
    Scanner inScan;  // Input File Scanner
    
    /**
     * Method name: TestAbbreviationWriter
     */
    public TestAbbreviationWriter(String abbFile, String inFile){
	abbMap = new HashMap<String, String>();

	// Opening up the abbreviations file scanner
	try { 
	    abbScan = new Scanner(new BufferedReader(new FileReader(abbFile)));
	} catch (FileNotFoundException e) {
	    printUsageAndExit();
	} 

	// Creating a hashmap from the abbreviations scanner
	while(abbScan.hasNext()){
	    String[] parts = (abbScan.nextLine()).split("\\s+", 2);
	    abbMap.put(parts[0], parts[1]);
	}
	abbScan.close();

	// Opening up the text file
	try {
	    inScan = new Scanner(new BufferedReader(new FileReader(inFile)));
	} catch (FileNotFoundException e) {
	    printUsageAndExit();
	}

	try {
	    File file = new File(OUTPUT_FILE_NAME);
	    if(!file.exists()) file.createNewFile();
	    BufferedWriter buffWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
	    AbbreviationWriter abbWriter = new AbbreviationWriter(buffWriter, abbMap);
	    // Conduct testing of the AbbreviationWriter
	    while(inScan.hasNext()) {
		String line = inScan.nextLine();
		abbWriter.write(line);
	    }
	    abbWriter.close();
	} catch (IOException e){
	    e.printStackTrace();
	}
	inScan.close();
    }
    
    /**
     * Method name: printUsageAndExit
     */
    public static void printUsageAndExit(){
	System.out.println("***** TestAbbreviationWriter *****");
	System.out.println("Requires two command line arguments:");
	System.out.println("1) The name of a file containg a list of abbreviations.");
	System.out.println("2) The name of the file to be read/written to.");
	System.out.println("Example: java TestAbbreviationWriter abbreviations.txt paragraph.txt");
	System.exit(0);
    }

    /**
     *
     */
    public static void main(String[] args){
	if(args.length < 2) printUsageAndExit();
	TestAbbreviationWriter testWriter = new TestAbbreviationWriter(args[0], args[1]);
    }
}