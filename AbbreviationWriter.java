import java.io.*;

public class AbbreviationWriter extends FilterWriter{
    
    public AbbreviationWriter(Writer out){
	super(out);
    }

    public void write(String str){
	// Overwrites FilterWriter's write(String str) method
    }
}