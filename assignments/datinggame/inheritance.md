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

#Example
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
