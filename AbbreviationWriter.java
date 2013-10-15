import java.io.*;
import java.util.HashMap;

public class AbbreviationWriter extends FilterWriter{

    private HashMap<String, String> map;

    public AbbreviationWriter(Writer out, HashMap<String, String> map){
	super(out);
	this.map = map;
	System.out.println(map);
    }

    public void write(String str) throws IOException {
	String[] parts = str.split("\\s+");
	for(int i = 0; i < parts.length; i++){
	    if(map.containsKey(parts[i])){
		out.write(map.get(parts[i]) + " ");
	    } else {
		out.write(parts[i] + " ");
	    }
	}
	out.write("\n");
    }
}