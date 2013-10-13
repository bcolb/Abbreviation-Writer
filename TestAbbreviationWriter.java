import java.io.*;

/**
 * Class name: TestAbbreviationWriter
 * Description: The TestAbbreviationWriter class takes as input two arguments
 * from the command line - The name of a file where abbreviations are defined
 * and the name of the text file to be read/written to.
 * Two Writer objects are created and wrapped in the AbbreviationWriter.
 */
public class TestAbbreviationWriter{
    
    // Fields
    private BufferedWriter bufferedWriter;
    private StringWriter stringWriter;
    
    /**
     * Method name: TestAbbreviationWriter
     */
    public TestAbbreviationWriter(){
	// bufferedWriter = new BufferedWriter();
	stringWriter = new StringWriter();
    }
    
    /**
     * Method name: printUsageAndExit
     */
    public static void printUsageAndExit(){
	System.out.println("***** TestAbbreviationWriter *****");
	System.out.println("Requires two command line arguments:");
	System.out.println("- First argument is a file containg a list of abbreviations");
	System.out.println("- Second argument is the name of the text file to be written/read");
	System.out.println("Example: java TestAbbreviationWriter abbreviations.txt testfile.txt");
    }

    public static void main(String[] args){
	printUsageAndExit();
    }
}