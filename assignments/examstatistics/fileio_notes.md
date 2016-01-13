#File Input/Output
- Declare Scanner instance using different constructor parameter
    Ex: Scanner scanner = new Scanner(new FileReader(name_of_file));
    Where name_of_file is either a new or existing file
- To write to the file, use the PrintWriter object
    Ex: PrintWriter write = new PrintWriter(new FileWriter(name_of_file));
    Then use the object's methods to write strings to the file
    Ex: write.println("some_string");
