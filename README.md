Abbreviation-Writer acts as a decorator for the writer class. The main class, TestAbbreviationWriter, takes as input two command line arguments:
 1. The name of a file where abbrevations are defined
 2. The name of the text file to be read/written using the decorator

The main class TestAbbreviationWriter reads the file where the abbreviations are defined and creates a HashMap that maps the abbrevation to the expansion. The abbreviations file will contain the definitions, one per line in the following format:

PBS Public Broadcast System

The above lines defines PBS as an abbreviation to be expanded to "Public Broadcast System". When a Writer object has the Abbreviation-Writer decorator added, any occurence of @PBS (Delimited by a white space) will output the result "Public Broadcast System".

The AbbreviationWriter class extends FilterWriter and can be added as a decorator to Writer objects. AbbreviationWriter has its own constructor and overrides FilterWriter's write(String str) method.

The test class TestAbbreviationWriter contains the main method. The main method accepts two command line arugments, opens and reads the abbreviations definitions, uses a Scanner to open the input text file and reads the output one line at a time. It writes each line using two instances of the AbbreviationWriter class (One to StringWriter and then to the Terminal Window, The other to a file named outfile.txt, using a BufferedWriter).