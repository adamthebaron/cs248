#Classes and Objects
###Class:
    - Primitive datatypes: int, char, void
    - A class is a complex datatype: String, FileWriter
###Object
    - Instance of a class

###Each object has 2 things:
    - Data
    - Methods that operate on data
###There are 4 types of methods
    - Constructors
        Used to define an instance of a class
    - Observers (Accessors)
        Doesn't mutate data, just shows or retrieves data
    - Mutators (Transformers)
        Mutates data in object
    - Iterators
        Used with collections

##Example Class
```java
class Fish {
    String name;
    String species;
    int fins;
    String color;

    public Fish(String Name, String Species, int Fins, String Color) {
        name = Name;
        Species = Species;
        fins = Fins;
        color = Color;
    }
}
```
At this point, you could use the class in a project, by creating an instance. It
doesn't do anything, but it will work.
```java
Fish fish = new Fish("Nemo", "clownfish", 7, "orange");
```
Inside the class definition, you can write methods anywhere (may make sense to
write them after the constructor for readability).
```java
/* return a string containing all constructor variables */
public String toString() {
    return "Name = " + name + "\n" + "Species = " + species + "\n" + "Fins = " +
    fins + "\n" + "Color = " + color + "\n";
}
