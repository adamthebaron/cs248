#Inheritance
In general, there are two types of inheritance
 - interface inheritance
 - data inheritance (most common)

##Interface
 - "A list of functions (signatures; comparable to prototypes)"
 - A class implements an interface if it has all functions listed
   the interface
 - Interfaces are capable of operating on different data types using
   the same methods (functions)
 - Interfaces can be used as function arguments

##Example
```java
public interface Comparable {
    /** @param x the object to compare
      * @return comparison result:
      *   -1 if < x, 0 if == x, +1 if > x */
    public int compareTo(Object x);
}
```
Each class that uses the interface must implement their own version
of the function signature. The interface contains no mutable data
or function definitions.
```java
public class Class 
```

#"Extends" keyword
- Used to create new class with specific variables/methods from exisiting
class. Only the differences from the parent class need to be defined.

- An object of a derived class can still act as an object of the parent
class.

##Example
```java
class ParentClass {
    String stuff;
    String otherStuff;
    String stillGotSomeStuff;

    public ParentClass(String s, String o, String s2) {
        stuff = s;
        otherStuff = o;
        stillGotSomeStuff = s2;
    }

    public String getStuff() {
        return stuff;
    }

    public String getOtherStuff() {
        return otherStuff;
    }
}

class ChildClass extends ParentClass {
    /* Everything from ParentClass is already here */
    int numberOfThings;

    public ChildClass(String s, String o, String s2, int n) {
        stuff = s;
        otherStuff = o;
        stillGotSomeStuff = s2;
        numberOfThings = n;
    }

    public int getNumberOfThings() {
        return numberOfThings;
    }
}
```
The 'super' keyword will hold data relative to the method it is used
in. It can be used to return data or access data from the parent class.
