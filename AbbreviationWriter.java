/**
 * AbbreviationWriter.java
 * 
 * @author Brice Colbert
 * @version 16 OCT 2013
 */
import java.io.IOException;
import java.io.Writer;
import java.io.FilterWriter;
import java.util.HashMap;

/**
 * Class name: AbbreviationWriter
 * Inheritance: FilterWriter
 * Attributes: HashMap<String, String> map
 * Methods: AbbreviationWriter(Writer out, HashMap map), Write(String str)
 * Functionality: A decorator class that can wrap any java Writer class,
 *                AbbreviationWriter checks each input string passed to
 *                the the Write method against keys in its HashMap. If the
 *                key is found in the Hashmap, then that value in the String
 *                is replaced by associated value in the HashMap and written
 *                out. 
 * Visibility: public	  
 */
public class AbbreviationWriter extends FilterWriter{

    private HashMap<String, String> map;

    /**
     * Name: AbbreviationWriter
     * Functionality: Initializes the AbbreviationWriter from the 
     *                Writer and HashMap that are passed in as parameters
     * Visibility: public
     * @param Writer out
     * @param HashMap<String, String> map
     */
    public AbbreviationWriter(Writer out, HashMap<String, String> map){
	super(out);
	this.map = map;
    }

    /**
     * Name: write
     * Inheritance: Uses the write(String str) method from the writer
     *              object it is decorating.
     * Functionality: Filters the String passed in as a parameter by checking
     *                for any of the abbreviations in the hashmap. If an 
     *                abbreviation is found, it is replaced by its  
     *                corresponding value.   
     * @param String str
     */
    public void write(String str) throws IOException {
	String[] parts = str.split("(\\s+)");
	for(int i = 0; i < parts.length; i++){
	    String key = parts[i].toLowerCase();
	    if(map.containsKey(key)){
		out.write(map.get(key) + " ");
	    } else {
		out.write(parts[i] + " ");
	    }
	}
	out.write("\n");
    }

}