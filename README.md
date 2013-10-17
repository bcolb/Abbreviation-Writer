Abbreviation Writer
===================

A decorator class for Java writer objects.

## Description
AbbreviationWriter is a decorator for subclasses of (Java's abstract Writer class)[http://docs.oracle.com/javase/7/docs/api/java/io/Writer.html]. The class AbbreviationWriter.java extends FilterWriter. Its only constructor accepts two parameters, a HashMap with data types String, String, and a Writer object (the object that the AbbreviationWriter is decorating).

AbbreviationWriter overrides the method Write(String str) in FilterWriter. The Write method split's the String parameter on whitespaces into a String array. The HashMap contains method checks for a key corresponding to a particular substring. If a match is found, that piece of the original String is replaced by the corresponding value in the HashMap. 

## Example

Say that our HashMap contained the following key/value pairs:
>{PBS=Public Broadcasting Service,
>EFF=Electronic Frontier Foundation}

And the following String was passed to the write method:
>String str = "Last night PBS ran a good piece on the work the EFF is doing.";

Then the write method would write out the following:
>Last night Public Broadcasting Service ran a good piece on the work the Electronic Frontier Foundation is doing.

## Usage
Included is a test class, TestAbbreviationWriter.java, that can also act as a usage example. The test program requires two arguments. The first argument is the name (or path) of a file containing a list of abbreviations. The second argument is the name (or path) of a file containing text to be filtered. 

The test class reads in the list of abbreviations and passes them into a HashMap with the abbreviations as keys and the expanded meanings as values. Two separate instances of AbbreviationWriter are then created. One decorates an instance of StringWriter and the other decorates an instance of BufferedWriter, which in turn is decorating a FileWriter. 

The input file is read line by line and passed to the write methods of the two abbreviation writers. Once the end of file is reached the contents of StringWriter and printed to the terminal window. FileWriter prints to a file name outfile.txt.

## Todo
- Resolve the removal of newline characters issue
- Rewrite the AbbreviationWriter.java method write(String str) to include punctuation as a delimiter(currently abbreviations are delimited by whitespace)
- Upload a UML diagram for Writer classes
