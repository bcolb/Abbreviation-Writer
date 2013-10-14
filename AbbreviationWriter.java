import java.io.*;
import java.util.HashMap;

public class AbbreviationWriter extends FilterWriter{

    private HashMap map;

    public AbbreviationWriter(Writer out, HashMap map){
	super(out);
	this.map = map;
    }

    public void write(String str) throws IOException {
	out.write(str);
	// Overwrites FilterWriter's write(String str) method
    }
}