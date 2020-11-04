# OCP

## Chapter 1: Advanced Class Design

### Access Modifiers
- private, only same class
- default, same package
    - Remember that there was a default keyword introduced in Java 8 for
interfaces. That keyword is not an access modifier.
- protected, same package and subclasses; tricky note is subclasses is allowed through inheritance, not variable
- public, any code

### Overloading and Overriding

- method signature is the method name and the parameter list.

### Abstract Classes

An abstract class is not required to have any methods in it, let alone any abstract
ones.

An abstract class may contain any number of methods including zero. The methods can
be abstract or concrete. Abstract methods may not appear in a class that is not abstract.
The first concrete subclass of an abstract class is required to implement all abstract
methods that were not implemented by a superclass.

### *Static* and *Final*