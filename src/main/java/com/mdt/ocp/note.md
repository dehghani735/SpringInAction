# OCP

## Chapter 1: Advanced Class Design

### Reviewing OCA Concepts

#### Access Modifiers

- private, only same class
- default, same package

  - Remember that there was a default keyword introduced in Java 8 for
interfaces. That keyword is not an access modifier.

- protected, same package and subclasses; tricky note is subclasses is allowed through inheritance, not variable
- public, any code

#### Overloading and Overriding

- method signature is the method name and the parameter list.
- In overriding, if the return type is different, it wouldn't compile.

#### Abstract Classes

An abstract class is not required to have any methods in it, let alone any abstract
ones.

An abstract class may contain any number of methods including zero. The methods can
be abstract or concrete. Abstract methods may not appear in a class that is not abstract.
The first concrete subclass of an abstract class is required to implement all abstract
methods that were not implemented by a superclass.

#### *Static* and *Final*

- final prevents a variable from changing or a method from being overridden.
  static makes a variable shared at the class level and uses the class name to refer to a
  method
- Using final on a class means that it cannot be subclassed
- As with methods, a class cannot be both abstract and final.
- In the Java core classes, String is final.

#### Imports

- import java.lang.*: This package is always imported
  whether you specify it or not.
- Since sort() is a static method on Collections, you definitely
    need a static import.

### Using instanceof

In a instanceof B, the expression returns true if the reference to which a points is an
instance of class B, a subclass of B (directly or indirectly), or a class that **implements** the B
interface (directly or indirectly).

All Java classes inherit from Object, which means that x instanceof Object is usually
true, except for one case where it is false. If the literal null or a variable reference pointing
to null is used to check instanceof, the result is false. null is not an Object.

<div dir="rtl">

کامپایلر نگاه می کند که variable reference چیه. اگر امکانش باشه که در زمان اجرا به هم ربط داشته باشند، خطا نمی دهد. ولی اگر هیچ امکانی نداشته باشد که به هم ربط داشته باشند، خطای کامپایلی میدهد

</div>

The compilation check only applies when instanceof is called on a class. When checking
whether an object is an instanceof an interface, Java waits until runtime to do the
check. The reason is that a subclass could implement that interface and the compiler
wouldn’t know it.

The instanceof operator is commonly used to determine if an instance is a subclass of
a particular object before applying an explicit cast.

### Understanding Virtual Method Invocation

### Annotating Overridden Methods

An annotation is extra information about the program, and it is a type of metadata. It can be used by the compiler or even at runtime

@Override: you, the programmer, intend for this method to override one in a **superclass** or implement one from an **interface**. 
**implementing an interface is actually an override.**

It so happens that the method being overridden is an **abstract** one.

@Override is helpful because the compiler now has enough information to tell you when you’ve messed up.
Or it could be that the superclass or interface changed without your knowledge.

It is a great idea to get in the habit of using @Override in order to avoid accidentally overloading a method.

@Override is allowed only when referencing a method. Just as there is no such thing as overriding a field, the annotation cannot be used on a field either.

@Override on exam:

- Implementing a method from an interface
- Overriding a superclass method of a class shown in the example
- Overriding a method declared in Object, such as hashCode, equals, or toString

### Coding equals, hashCode, and toString

all classes inherit any methods defined in Object.

Three of these methods are common for subclasses to override with a custom implementation.

#### *toString*

- Java automatically calls the toString() method if you try to print out an object
- Some classes supply a human-readable implementation of toString() and others do not. E.g. **ArrayList** does and **array** does not.
- The Easy Way to Write toString() Methods: Apache Commons Lang. It uses Reflection.

```java
public String toString() {
  return ToStringBuilder.reflectionToString(this);
}
```

#### *equals*

- Checking if two objects are equivalent uses the equals() method, or at least it does if the developer implementing the method overrides equals().
- **String** does have an equals() method. It checks that the values are the same.
- **StringBuilder** uses the implementation of equals() provided by Object, which simply checks if the two objects **being referred** to are the same.

The equals() method implements an equivalence relation on non‐null object references:

- It is **reflexive**: For any non‐null reference value x, x.equals(x) should return true.
- It is **symmetric**: For any non‐null reference values x and y, x.equals(y) should return
true if and only if y.equals(x) returns true.
- It is **transitive**: For any non‐null reference values x, y, and z, if x.equals(y) returns
true and y.equals(z) returns true, then x.equals(z) should return true.
- It is **consistent**: For any non‐null reference values x and y, multiple invocations of
x.equals(y) consistently return true or consistently return false, provided no
information used in equals comparisons on the objects is modified.
- For any non‐null reference value x, x.equals(null) should return **false** rather than throw a **NullPointerException**.

```java
public boolean equals(Lion obj) {
  if(obj == null) return false;
    return this.idNumber == obj.idNumber;
}
```

Above code does not override equals. It **overloads** it.

#### *hashCode*

The hash code is used when storing the object as a key in a map

A *hash code* is a number that puts instances of a class into a finite number of categories.

3 contracts for hashCode():

- Within the same program, the result of hashCode() **must** not change. This means that you shouldn’t include variables that change in figuring out the hash code. In our hippo example, including the name is fine. Including the weight is not because hippos change weight regularly.
- If equals() returns true when called with two objects, calling hashCode() on each of those objects **must** return the **same result**. This means hashCode() can use a subset of the variables that equals() uses. You saw this in the card example. We used only one of the variables to determine the hash code.
- If equals() returns false when called with two objects, calling hashCode() on each of those objects does not have to return a different result. This means hashCode() results do not need to be **unique** when called on unequal objects.

- It is easier to code your own. Just pick the key fields that identify your object (and don’t change during the program) and combine them:

```java
public int hashCode() {
  return keyField + 7 * otherKeyField.hashCode();
}
```

- It is common to multiply by a **prime** number when combining multiple fields in the hash code. This makes the hash code more unique, which helps when distributing objects into buckets.

### Working with Enums

- it is common to have a **type** that can only have a finite set of values.
- An *enumeration* is like a fixed set of constants.
- In Java, an *enum* is a class that represents an enumeration.
- It is much better than a bunch of constants because it provides type‐safe checking.
- With numeric constants, you can pass an invalid value and not find out until **runtime**. 
- With *enums*, it is impossible to create an invalid enum type without introducing a **compiler** error.
- Enumerations show up whenever you have a set of items whose types are known at compile time.
- Since an enum is like a set of constants, use the uppercase letter convention that you used for constants.
- Behind the scenes, an enum is a type of **class** that mainly contains **static members**. It also includes some helper methods like name() that you will see shortly.
- enums print the name of the enum when toString() is called.
- They are also comparable using == because they are like ```static final``` constants.
- An enum provides a method to get an array of all of the values. You can use this like any normal array, including in a loop: ```Season.values()```
- ```ordinal()``` method to get the int order of enum
- You can’t compare an int and enum value directly anyway. Remember that an enum is a type and not an int. => **compile error**
- You can also create an enum from a String. This is helpful when working with older code. The String passed in must match exactly, though. Java throws up its hands in defeat and throws an **IllegalArgumentException**.
- Another thing that you can’t do is extend an enum. The values in an enum are all that are allowed. You cannot add more at runtime by extending the enum.

#### Using Enums in Switch Statements

- In fact, if you were to type case Season.WINTER in ```case``` statement, it would not **compile**. Keep in mind that an enum type is not an ```int```.
- You can’t compare an int with an enum.

#### Adding Constructors, Fields, and Methods

### Creating Nested Classes

- A nested class is a class that is defined within another class
- A nested class that is **not static** is called an **inner class**.
- There are four of types of nested classes:
  - A **member inner class** is a class defined at the same level as instance variables. It is not static. Often, this is just referred to as an inner class without explicitly saying the type.
  - A **local inner class** is defined within a method.
  - An **anonymous inner class** is a special case of a **local inner class** that does not have a name.
  - A **static nested class** is a static class that is defined at the same level as **static variables**.
- benefits: . They can encapsulate helper classes by
restricting them to the containing class. They can make it easy to create a class that will be used in only one place. They can make the code easier to read.

#### Member Inner Classes

A member inner class is defined at the member level of a class (the same level as the methods, instance variables, and constructors).

- Can be declared public, private, or protected or use default access
- Can extend any class and implement interfaces
- Can be **abstract** or **final**
- Cannot declare **static** fields or methods
- Can access members of the outer class including **private** members

The last property is actually pretty cool. It means that the inner class can access the outer class without doing anything special.

- Since a member inner class is not static, it has to be used with an instance of the outer class.
- .class Files for Inner Classes: Compiling the Outer.java class with which we have been working creates two class files. **Outer.class** you should be expecting. For the inner class, the compiler creates **Outer$Inner.class**.
- interesting instantiate

```java
Outer outer = new Outer();
Inner inner = outer.new Inner();
```

- Private Interfaces

```java
public class CaseOfThePrivateInterface {
  private interface Secret {
    public void shh();
  }
  class DontTell implements Secret {
    public void shh() { }
    } 
  }
```
The rule that all methods in an **interface** are **public** still applies. A class that implements the interface **must** define that method as **public**.
The interface itself does not have to be **public**, though. Just like any inner class, an inner interface can be **private**. **This means that the interface can only be referred to within the current outer class.**

#### Local Inner Classes

- A local inner class is a nested class defined **within a method**.
- Like local variables, a local inner class declaration does not exist until the method is invoked, and it goes out of scope when the method returns.
- This means that you can create instances only from within the method. Those instances can still be returned from the method.
- Properties:
  - They do not have an access specifier.
  - They cannot be declared static and cannot declare static fields or methods.
  - They have access to all fields and methods of the enclosing class.
  - They do not have access to local variables of a method unless those variables are final or **effectively final**.

    - The compiler is generating a class fi le from your inner class. **A separate class has no way to refer to local variables.** If the local variable is final , Java can handle it by passing it to the constructor of the inner class or by storing it in the class file. If it weren’t **effectively final**, these tricks wouldn’t work because the value **could change** after the copy was made. Up until Java 7, the programmer actually had to type the **final** keyword. In Java 8, the “**effectively final**” concept was introduced. If the code could still compile with the keyword final inserted before the local variable, the variable is effectively final.
    - objects or primitive values are effectively final if we do not change their values after initialization. In the case of objects, if we do not change the **reference** of an object, then it is effectively final — even if a change occurs in the **state** of the referenced object.
    - Prior to its introduction, we could not use a non-final local variable in an anonymous class. We still cannot use variables that have more than one value assigned to them inside **anonymous classes, inner classes, and lambda expressions**. The introduction of this feature allows us to not have to use the final modifier on variables that are effectively final, saving us a few keystrokes.

#### Anonymous Inner Classes

- An anonymous inner class is a local inner class that does not have a name.
- Anonymous inner classes are required to extend an existing class or implement an existing interface.
- They are useful when you have a short implementation that will not be used anywhere else.
- But what if we want to implement both an interface and extend a class? You can’t with an anonymous inner class, unless the class to extend is java.lang.Object. Object is a special class, so it doesn’t count in the rule. **Remember that an anonymous inner class is just an unnamed local inner class.** You can write a local inner class and give it a name if you have this problem. Then you can extend a class and implement as many interfaces as you like.
- There is one more thing that you can do with anonymous inner classes. You can define them right where they are needed, even if that is an argument to another method.

#### Static Nested Classes

- The final type of nested class is not an inner class. A static nested class is a static class defined at the member level.
- It can be instantiated without an object of the enclosing class, so it can’t access the instance variables without an explicit object of the enclosing class.
- For example, new OuterClass().var allows access to the instance variable var.
- it is like a regular class except for the following:

  - The nesting creates a **namespace** because the enclosing class name must be used to refer
to it.
  - It can be made ```private``` or use one of the other access modifiers to encapsulate it.
  - The enclosing class can refer to the fields and methods of the ```static``` nested class.

- Importing a static Nested Class: Importing a static nested class is interesting. You can import it using a regular import.

```java
package bird;
public class Toucan {
  public static class Beak {}
}
package watcher;
import bird.Toucan.Beak; // regular import ok
  public class BirdWatcher {
    Beak beak;
}
```

### Summary

read in the book

## Chapter 2: Design Patterns and Principles

- teach you best practices for designing Java classes and writing applications that lead to code that is easier to understand, more maintainable, and that you and other developers can leverage in future projects.
- Adhering to the design principles and design patterns enables you to create complex class models that smoothly interact with other developers’ applications.

### Designing an Interface

- So, if a new method is to be added in an interface, then its implementation code has to be provided in the class implementing the same interface. To overcome this issue, Java 8 has introduced the concept of **default methods** which allow the interfaces to have methods with implementation without affecting the classes that implement the interface.
- The default methods were introduced to provide backward compatibility so that existing interfaces can use the lambda expressions without implementing the methods in the implementation class. Default methods are also known as defender methods or virtual extension methods. (https://www.geeksforgeeks.org/default-methods-java/#:~:text=The%20default%20methods%20were%20introduced,methods%20or%20virtual%20extension%20methods.)
- an **important** note about interfaces: . The compiler automatically adds ```public``` to all interface methods and ```abstract``` to all **non‐static and non‐default** methods, if the developer does not provide them. By contrast, the class implementing the interface **must** provide the proper modifiers.
- An interface may extend another interface, and in doing so it inherits all of the abstract methods.
- Remember that an interface cannot extend a class, nor can a class extend an interface.
- implement multiple interfaces: 
- construct interfaces that have **neither methods nor class members**, traditionally referred to as **marker interfaces**. E.g. java.io.Serializable
- نکات بیشتر interface , overriding در OCA

#### Purpose of an Interface

- An interface provides a way for one individual to develop code that uses **another individual’s code**, without having access to the other individual’s **underlying implementation**.
- Interfaces can facilitate rapid application development by enabling development teams to create applications in parallel, rather than being directly dependent on each other.
  - For example, two teams can work together to develop a one‐page standard interface at the start of a project. One team then develops code that uses the interfaces while the other team develops code that implements the interface. The development teams can then combine their implementations toward the end of the project, and as long as both teams developed with the same interface, they will be compatible.
- Mock Objects: which simulates the real object that implements the interface with a simple implementation.
  
### Introducing Functional Programming

- Java defines a *functional interface* as an interface that contains a **single abstract method**. Functional interfaces are used as the basis for **lambda expressions** in functional programming.
- A lambda expression is a block of code that gets passed around, like an **anonymous method**.
  
#### Defining a Functional Interface

- @FunctionalInterface Annotation: While it is a good practice to mark a functional interface with the @FunctionalInterface annotation for clarity, it is not required with functional programming. The Java compiler implicitly assumes that any interface that contains exactly one abstract method is a functional interface. Conversely, if a class marked with the @FunctionalInterface annotation contains more than one abstract method, or no abstract methods at all, then the compiler will detect this error and not compile.

#### Implementing Functional Interfaces with Lambdas

- Recall that lambda expressions rely on the notion of **deferred execution**. Deferred execution means that code is **specified now but runs later**.
- Even though the execution is deferred, the compiler will still validate that the code syntax is properly formed.

##### Understanding Lambda Syntax

these two are the same

```java
a -> a.canHop()
(Animal a) -> { return a.canHop(); }
```

- left side (parameter list): It can be consumed by a **functional interface** whose abstract method has the same number of parameters and compatible data types.
- right side (body): It can be consumed by a functional interface whose abstract method returns a compatible data type.
- The parentheses () can be omitted in a lambda expression if there is exactly one input parameter and **the type is not explicitly stated in the expression**. This means that expressions that have zero or more than one input parameter will still require parentheses.

##### Spotting Invalid Lambdas

- {} is needed for multiple line
- when {} is used, ; must be used
- return is required if functional interface method returns a value. Alternatively, a return statement is optional when the return type of the method is void.
- parentheses can be omitted only if there is exactly one parameter and **the data type is not specified**.
- As mentioned, the data types for the input parameters of a lambda expression are optional. When one parameter has a data type listed, though, all parameters **must** provide a data type.
- Since Java doesn’t allow us to re‐declare a local variable, the
following is an issue:

```java
(a, b) -> { int a = 0; return 5;} // DOES NOT COMPILE
```

#### Applying the Predicate Interface

- Java has a facility for such an interface for other types called Predicate. It’s in the package java.util.function:

```java
public interface Predicate<T> {
  public boolean test(T t);
}
```

### Implementing Polymorphism

- *Polymorphism* is the ability of a single interface to support multiple underlying forms.
- this allows multiple types of objects to be passed to a single method or class.
- a Java object may be accessed using a reference with the same type as the object, a reference that is a superclass of the object, or a reference that defines an interface that the object implements, either directly or through a superclass. Furthermore, a cast is not required if the object is being reassigned to a supertype or interface of the object.
- The ability of the Lemur object to be passed as an instance of an interface it implements, HasTail, as well as an instance of one of its superclasses, Primate, is the nature of polymorphism.
- If you use a variable to refer to an object, then only the methods or variables that are part of the variable’s reference type can be called without an explicit cast.

#### Distinguishing between an Object and a Reference

- Two rules:
  - The type of the object determines which properties exist within the object in memory.
  - The type of the reference to the object determines which method and variables are accessible to the Java program.
- It therefore follows that successfully changing a reference of an object to a new reference type may give you access to new properties of the object, but those properties existed before the reference change occurred.

#### Casting Object References

- We can **reclaim** those references by casting the object back to the specific subclass it came from.
- Here are some basic rules to keep in mind when casting variables:
  - Casting an object from a subclass to a superclass doesn’t require an **explicit cast**.
  - Casting an object from a superclass to a subclass requires an **explicit cast**. => otherwise **compiler** error
  - The compiler will not allow casts to unrelated types. => otherwise **compiler** error
  - Even when the code compiles without issue, an **exception** may be thrown at runtime if the object being cast is **not actually an instance of that class**. => otherwise **ClassCastException**
    - to avoid such a situation, use ```instanceof``` operator
- When faced with a question on the exam that involves casting and polymorphism, be sure to remember what the instance of the object actually is. Then focus on whether the compiler will allow the object to be referenced with or without explicit casts.

### Understanding Design Principles

- A design principle is an established idea or best practice that facilitates the software design process.

#### Encapsulating Data

- encapsulation is the idea of combining fi elds and methods in a class such that the methods operate on the data, as opposed to the users of the class accessing the fi elds directly.
- In Java, it is commonly implemented with private instance members that have public methods to retrieve or modify the data, commonly referred to as getters and setters, respectively.
- The underlying idea of encapsulation is that no actor other than the class itself should have direct access to its data.
- The class is said to encapsulate the data it contains and prevent anyone from directly accessing it.
- With encapsulation, a class is able to maintain certain invariants about its internal data.
- An **invariant** is a property or truth that is maintained even after the data is modified.
- In “Exceptions and Assertions,” we will describe how to test these class invariants using assertions.
- First we need to make instance variables ```private```. This way, the class is the only one that can modify the data directly.
- Then we need to define constructors, getters, and setters that enforce these invariants.
- Anytime an instance of an Animal object is passed to a method, it can be used without requiring that its invariants be validated.
- Therefore, it is considered a good design practice always to **encapsulate all variables in a class**, even if **there are no established data rules**, as a way to protect the data when such rules may be added in the **future**.

#### Creating JavaBeans

- **Encapsulation** is so prevalent in Java that there is a standard for creating classes that store data, called **JavaBeans**.
- A JavaBean is a design principle for encapsulating data in an object in Java.
- it has some principles => go to book

#### Applying the Is‐a Relationship

use the multi‐inheritance properties of interfaces

#### Applying the Has‐a Relationship

- In object‐oriented design, we often want to test whether an object contains a particular property or value.
- The has‐a relationship is also known as the object composition test.
- If a parent has‐a object as a ```protected``` or ```public``` member, then any child of the parent must also have that object as a member. Note that this does not hold true for ```private``` members defined in parent classes, because **private members are not inherited in Java**.

#### Composing Objects

- In object‐oriented design, we refer to object composition as the property of constructing a class using references to other classes in order to reuse the functionality of the other classes.
- the class contains the other classes in the has‐a sense and may delegate
methods to the other classes.
- Object composition should be thought of as an alternate to inheritance and is often used to simulate polymorphic behavior that cannot be achieved via single inheritance.
- One of the advantages of **object composition** over **inheritance** is that it tends to promote greater **code reuse**.
- By using object composition, you gain access to other classes and methods that would be difficult to obtain via Java’s single‐inheritance model.
- Object composition still requires you to explicitly expose the underlying methods and values manually, whereas inheritance includes protected and public members automatically.
- both object composition and inheritance have their proper place in developing good code, and in many cases it may be difficult to decide which path to choose.

### Working with Design Patterns

- A design pattern is an established general solution to a commonly occurring software development problem.
- creational patterns. The problem with object creation, though, lies in how you create and manage objects in more complex systems.
- One thing to keep in mind as you read this section is that under the covers, the ```new``` keyword is still used to create objects in memory.
- The creational patterns simply apply a level of indirection to object creation by creating the object in some other class, rather than creating the object directly in your application. Level of indirection is a general term for solving a software design problem by conceptually separating the task into multiple levels.

#### Applying the Singleton Pattern

- Problem: How do we create an object in memory only once in an application and have it shared by multiple classes?
- Motivation: By creating a singleton HayManager object, we centralize the data and remove the need to pass it around the application.
- Solution The singleton pattern is a creational pattern focused on creating only one instance of an object in memory within an application, sharable by **all classes and threads** within the application. The globally available object created by the singleton pattern is referred to as a singleton.
- By marking the constructors ```private```, we have implicitly marked the class ```final```. Recall that every class requires at least one constructor, with the default no‐argument constructor being added if none are provided. Furthermore, the first line of any constructor is a call to a parent constructor with the super() command. If all of the constructors are declared ```private``` in the singleton class, then it is impossible to create a subclass with a valid constructor; therefore, the singleton class is effectively ```final```.
- Singletons are used in situations where we need access to a single set of data throughout an application. For example, application configuration data and reusable data caches are commonly implemented using singletons. Singletons may also be used to **coordinate access to shared resources, such as coordinating write access to a file**.

##### Applying Lazy Instantiation to Singletons

- سه روش ساخت داره سینگلتون
  - 1 = مستقیم شی بسازیم => در زمان لود کلاس ساخته میشه
  - 2 = با بلاک استاتیک => در زمان لود کلاس ساخته میشه
  - 3 = با استفاده از lazy instantiation => در زمان نیاز به آبجکت ساخته میشه
    - که ممکنه thread safe نباشه. یعنی چند تا همزمان بیان بسازن
    - باید synchronized اش کنی

##### Creating Unique Singletons

- because we used **lazy instantiation** in the VisitorTicketTracker class, the compiler won’t let us assign the ```final``` modifier to the ```static``` reference.
- Unfortunately, because we used lazy instantiation in the VisitorTicketTracker class, the compiler won’t let us assign the final modifier to the static reference.
- Singletons with Double‐Checked Locking: This solution has the problem that **every single call** to this method will require synchronization. In practice, this can be costly and can impact performance. Synchronization is only needed the first time that the object is created.

#### Creating Immutable Objects

- Problem: How do we create read‐only objects that can be shared and used by multiple classes?
- Solution: The immutable object pattern is a creational pattern based on the idea of creating objects whose state does not change after they are created and can be easily shared across multiple classes. Immutable objects go hand and hand with encapsulation, except that **no setter methods exist that modify the object**. Since the **state** of an immutable object never changes, they are inherently **thread‐safe**.
- example: String class is immutable

##### Applying an Immutable Strategy

5 rules:
1. Use a constructor to set all properties of the object.
2. Mark all of the instance variables ```private``` and ```final``` .
3. Don’t define any setter methods.
4. Don’t allow referenced mutable objects to be modified or **accessed** directly
   - You should never share **references** to a **mutable** object contained within an immutable object
5. Prevent methods from being **overridden**. 2 ways:
   - make class final
   - make the constructor private and apply the factory pattern

- notes: **Collections.unmodifiableList(List list)** see the example in web.
- Handling **Mutable Objects in the Constructors of Immutable Objects**: It is important when creating immutable objects that any mutable input arguments are copied to the instance instead of being used directly.

#### Using the Builder Pattern

- Problem: How do we create an object that requires numerous values to be set at the time the object is instantiated?
- Motivation: . Every time we add a parameter, the constructor grows! Users who reference our object would also be required to update their constructor calls each time that the object was modified, resulting in a class that would be difficult to use and maintain. Alternatively, we could add a new constructor each time we add a parameter, but having too many constructors can be quite difficult to manage in practice. One solution is to use setter methods instead of the constructor to configure the object, but this doesn’t work for immutable objects since they can’t be modifi ed after creation. For mutable objects, it could also lead to class invariants being temporarily broken.
  - The problem of a constructor growing too large actually has a name, referred to as the **telescoping constructor anti‐pattern**.
  - Design patterns are often written to help prevent anti‐patterns from forming
- Solution: The builder pattern is a creational pattern in which parameters are passed to a builder object, often through method chaining, and an object is generated with a final build call. It is often used with immutable objects, since immutable objects do not have setter methods and must be created with all of their parameters set, although it can be used with mutable objects as well.
- using the builder pattern is analogous to taking a **mutable** object and making it **read-only** (immutable).
- The next thing that you might notice is that all of the **setter methods** return an **instance of the builder object** ```this```.
- Although we could certainly write our build() method to throw an **exception** if certain required fields are not set. Alternatively, the build() method may also **set default values** for anything the user failed to specify on the builder object.
- The **primary advantage of the builder pattern** is that, over time, this approach leads to far more **maintainable** code.
- tight coupling vs loose coupling. توضیح بیشتر توی کتاب

#### Creating Objects with the Factory Pattern

- Problem: How do we write code that creates objects in which the precise type of the object may not be known until runtime?
- Motivation: complexity of object creation, including selecting which subclass to use, as well as loosely coupling the underlying creation implementation.
- Solution: **factory method pattern**, is a creational pattern based on the idea of using a factory class to produce instances of objects based on a set of input parameters. It is similar to the builder pattern, although it is focused on supporting **class polymorphism**.
- Factory patterns are often, although not always, implemented using ```static``` methods that return objects and do not require a pointer to an instance of the factory class.
- to postfix the class name with the word ```Factory```.
- Factory Pattern and Default Class Constructors.

## Chapter 3: Generics and Collections

This includes other lists, sets, queues, and maps.

You’ll learn how to customize searching and sorting using Comparable and Comparator.

We will end with some methods that use functional interfaces, such as forEach() and merge().

### Reviewing OCA Collections

- The *Java Collections Framework* includes classes that implement ```List```, ```Map```, ```Queue```, and ```Set```.
- an array (like int[]) is not part of the Collections Framework.

#### Array and ArrayList

- An ArrayList is an object that contains other **objects**. An ArrayList **cannot** contain **primitives**. An array is a built-in data structure that contains **other objects or primitives**.
- Arrays.asList(array): convert array to List.
- list.toArray(): convert List to array
- Implementations of ```List``` are allowed to add their own behavior. The implementation used when calling asList() has the added feature of **not being resizable** but honoring all of the other methods in the interface.

#### Searching and Sorting

- Arrays.sort(array)
- Arrays.binarySearch(array, x): prints the index at which a match is found.
  - prints one less than the negated index of where the requested value would need to be inserted. (example in code)
- Collections.sort(list)
- Collections.binarySearch()
  - We call sort() and binarySearch() on Collections rather than Collection.

#### Wrapper Classes and Autoboxing

- each **primitive** has a corresponding **wrapper class**.
- *Autoboxing* automatically converts a **primitive** to the corresponding **wrapper classes** when needed if the **generic type** is specified in the declaration.
- *Unboxing* automatically converts a wrapper class back to a primitive.
- Refer to Table 3 .1 Wrapper classes (**Important**)
- The remove() method is **overloaded**. One signature takes an **int** as the *index* of the element to remove. The other takes an **Object** that should be removed.

#### The Diamond Operator

- in Java 5:
  - List names = new ArrayList();
  - So we don't know which data type this list expects
- <> is called *diamond* operator
- for readablility of code after java 8

### Working with Generics

- Why do we need **generics**? Well, remember when we said that we had to hope the caller didn’t put something in the list that we didn’t expect?
- In Java 8, this code ```List names = new ArrayList();``` is called non-generic list.
- a non-generic list can contain anything.
- *Generics* can convert runtime error to compile error.

#### Generic Classes

- You can introduce generics into your own classes.
- The syntax for introducing a generic is to declare a *formal type parameter* in angle brackets.
- here, T is a **generic type variable**

```java
public class Crate<T> {
}
```

- The generic type T is available anywhere within the Crate class. When you instantiate the class, you tell the compiler what T should be for that particular instance.
- Naming Conventions for Generics:
  - E for an element
  - K for a map key
  - V for a map value
  - N for a number
  - T for a generic data type
  - S, U, V, and so forth for multiple generic types
- **Type Erasure**: 
  - Specifying a generic type allows the compiler to enforce proper use of the generic type. However, this is just for compile time. Behind the scenes, the compiler replaces all references to T in Crate with **Object**. In other words, after the code compiles, your generics are actually just **Object** types.

  ```java
  public class Crate {
    private Object contents;
    public Object emptyCrate() {
      return contents;
    }
    public void packCrate(Object contents) {
      this.contents = contents;
    }
  }
  ```

  - This means there is only **one class file**. There aren’t different copies for different parameterized types. (Some other languages work that way.)
  - This process of removing the generics syntax from your code is referred to as type erasure. Type erasure allows your code to be compatible with older versions of Java that do not contain generics.
  - The compiler adds the relevant casts for your code to work with this type of erased class.

#### Generic Interfaces

- Just like a class, an interface can declare a formal type parameter.
- 3 ways:
  - The first is to specify the generic type in the class.
  - The next way is to create a generic class.
  - The final way is to not use generics at all.

#### Generic Methods

- It is also possible to declare them on the method level.
- This is often useful for static methods since they aren’t part of an instance that can declare the type.
- However, it is also allowed on non-static methods as well.

```java
public static <T> Crate<T> ship(T t) {
  System.out.println("Preparing " + t);
  return new Crate<T>();
}
```

- Before the return type, we declare the formal type parameter of <T>.
- You can call a generic method normally, and the compiler will figure out which one you want.

#### Interacting with Legacy Code

- Legacy code is older code. It is usually code that is in a different style than you would write if you were writing the code today.
- Collections written without generics are also known as raw collections.
- Remember that using generics gives us **compile time safety**.
- At least it does when **all** of the code involved uses generics. When some code uses generics and other code does not, it is easy to get lulled into a false sense of security. lull آرامش یافتن
- Java knows that raw types are asking for trouble, and it presents a *compiler warning* for this case.
- The **compiler warning** is Java informing you that you should take a closer look at something.
- On the exam, you have to identify when a compiler warning will occur.
- To review, the lesson is to be careful when you see code that doesn’t use generics. Pay special attention to looking for compiler warnings, ClassCastExceptions, and compiler errors.

#### Bounds

- Unbounded Wildcards
  - ```List<String>``` cannot be assigned to ```List<Object>.```
  - List<?>
- Upper-Bounded Wildcards
  - We’ve established that a generic type can’t just use a subclass:
  - ```List<? extends Number> list = new ArrayList<Integer>();```
  - The upper-bounded wildcard says that any class that extends Number or Number itself can be used as the formal parameter type.
  - type erasure makes Java think that a generic type is an ```Object```.
  - Something interesting happens when we work with upper bounds or unbounded wildcards. The **list** becomes logically **immutable**. Immutable means that the object cannot be modified. (example in book)
- Lower-Bounded Wildcards

### Using Lists, Sets, Maps, and Queues

- A *collection* is a group of objects contained in a single object.
- The *Java Collections Framework* is a set of classes in ```java.util``` for storing collections.
- four main interfaces in the Java Collections Framework:
  - List: an ordered collection of elements that allows duplicate entries.
  - Set: a collection that does not allow duplicate entries.
  - Queue: a collection that orders its elements in a specific order for processing. A typical queue processes its elements in a first-in, first-out order, but other orderings are possible.
  - Map: collection that maps keys to values, with no duplicate keys allowed. The elements in a map are key/value pairs.

- Notice that ```Map``` doesn’t implement the Collection interface The reason why maps are treated differently is that they need different methods due to being key/value pairs.
![Map](map.png)

#### Common Collections Methods

- add(): inserts a new element into the Collection and returns whether it was successful. 
  - ```boolean add(E element)```
- remove(): removes a single matching value in the Collection and returns
whether it was successful.
  - ```boolean remove(Object object)```
  - the boolean return value tells us whether a match was removed.
  - Notice that it removes only one match.
  - Since calling remove() with an int uses the index, an index that doesn’t exist will throw an exception. IndexOutOfBoundsException.
- isEmpty() and size(): look at how many elements are in the Collection.
  - ```boolean isEmpty()```
  - ```int size()```
- clear(): provides an easy way to discard all elements of the Collection
  - ```void clear()```
- contains(): checks if a certain value is in the Collection.
  - ```boolean contains(Object object)```
  - This method calls equals() on each element of the ArrayList to see if there are any matches.

#### Using the List Interface

- The main thing that all List implementations have in common is that they are ordered and allow duplicates.

##### Comparing List Implementations

- An **ArrayList** is like a resizable array. When elements are added, the ArrayList automatically grows. When you aren’t sure which collection to use, use an ArrayList.
- The main benefit of an ArrayList is that you can look up any element in constant time.
- Adding or removing an element is slower than accessing an element. This makes an ArrayList a good choice when you are reading more often than (or the same amount as) writing to the ArrayList.
- Big O notation lets you compare the order of magnitude of performance rather than the exact performance.
- A **LinkedList** is special because it implements both ```List``` and ```Queue```.
- It also has additional methods to facilitate adding or removing from the beginning and/or end of the list.
- The main benefits of a LinkedList are that you can access, add, and remove from the beginning and end of the list in constant time.
- The tradeoff is that **dealing with an arbitrary index takes linear time**. This makes a LinkedList a good choice when you’ll be using it as **Queue**.

##### Working with List Methods

- The methods in the List interface are for working with indexes.

#### Using the Set Interface

##### Comparing Set Implementations

- A **HashSet** stores its elements in a hash table. This means that it uses the hashCode() method of the objects to retrieve them more efficiently.
- The main benefit is that adding elements and checking if an element is in the set both have constant time.
- The tradeoff is that you lose the order in which you inserted the
elements.
- A **TreeSet** stores its elements in a sorted tree structure. The main benefit is that the set is always in sorted order. The tradeoff is that adding and checking if an element is present are both O(log n).
- **TreeSet** implements a special interface called **NavigableSet**, which lets you slice up the collection.

##### Working with Set Methods

- Remember that the equals() method is used to determine equality.
- The hashCode() method is used to know which bucket to look in so that Java doesn’t have to look through the whole set to find out if an object is there. 
- The best case is that hash codes are unique, and Java has to call equal () on only **one** object. The worst case is that all implementations return the same hashCode(), and Java has to call equals() on **every** element of the set anyway.
- in TreeSet: printed out in their **natural sorted order**. یعنی مرتب می کند

##### The NavigableSet Interface

- TreeSet implements the NavigableSet interface.

#### Using the Queue Interface

- Queues are typically used for sorting elements prior to processing them.

##### Comparing Queue Implementations

- You saw **LinkedList** earlier in the List section. In addition to being a list, it is a double-ended queue. A double-ended queue is different from a regular queue in that you can insert and remove elements from both the front and back of the queue.
- The main benefit of a LinkedList is that it implements both the **List** and **Queue** interfaces. The tradeoff is that it isn’t as efficient as a “pure” queue.
- An **ArrayDeque** is a “pure” **double-ended** queue.
  - it stores its elements in a **resizable** array. The main benefit of an ArrayDeque is that it is more efficient than a LinkedList.

##### Working with Queue Methods

- ArrayeDeque methods in the book
- What if we want to insert an element at the other end, just as we could with a Stack? No problem. We just call the push() method. It works just like offer() except at the other end of the queue.
- When talking about LIFO (stack), people say push/poll/peek. When talking about FIFO (single-ended queue), people say offer/poll/peek.

#### Map

- You use a map when you want to identify values by a key.
- For example, when you use the contact list in your phone, you look up “George” rather than looking through each phone number in turn.
- You do need to know that **TreeMap** is sorted and navigable.

##### Comparing Map Implementations

- A HashMap stores the keys in a hash table. This means that it uses the hashCode() method of the keys to retrieve their values more efficiently.
- The main benefit is that adding elements and retrieving the element by key both have constant time.
- The tradeoff is that you lose the order in which you inserted the elements. Most of the time, you aren’t concerned with this in a map anyway. If you were, you could use LinkedHashMap.
- A TreeMap stores the keys in a sorted tree structure. The main benefit is that the keys are always in sorted order. The tradeoff is that adding and checking if a key is present are both O(log n).

##### Working with Map Methods

- Given that **Map doesn’t extend Collection**, there are more methods specified on the Map interface.
- Since there are both keys and values, we need generic type parameters for both. The class uses K for key and V for value.
- Refer to book to see the method lists
- Java uses the hashCode() of the **key** to determine the order. The order here happens to.
- in HashMap Java uses the hashCode() of the key to determine the order.
- The data structures that involve sorting do not allow nulls.
- which data structures allow nulls?
  - This means that **TreeSet** cannot contain null elements. It also means that **TreeMap** cannot contain null keys. Null values are OK.
  - Next comes **ArrayDeque**. You can’t put ```null``` in an ArrayDeque because methods like poll() use null as a special return value to indicate that the collection is empty. Since null has that meaning, Java forbids putting a null in there.
  - In handy list form, all data structures allow nulls except these:
    - TreeMap—no null keys
    - Hashtable—no null keys or values
    - TreeSet—no null elements
    - ArrayDeque—no null elements

### Comparator vs. Comparable

- We discussed “order” for the TreeSet and TreeMap classes.
- **numbers sort before letters and uppercase letters sort before lowercase letters.**
- You can also sort objects that you create. Java provides an interface called ```Comparable```. If your class implements Comparable, it can be used in these data structures that require comparison.
- There is also a class called ```Comparator```, which is used to specify that you want to use a different order than the object itself provides.

#### Comparable

```java
public interface Comparable<T> {
  public int compareTo(T o);
}
```

- There are three rules to know:
  - The number zero is returned when the current object is equal to the argument to compareTo().
  - A number less than zero is returned when the current object is smaller than the argument to compareTo().
  - A number greater than zero is returned when the current object is larger than the argument to compareTo().
- **compareTo() and equals() Consistency**:
  - If you write a class that implements Comparable, you introduce new business logic for determining equality. The compareTo() method returns 0 if two objects are equal, while your equals() method returns true if two objects are equal.
  - A natural ordering that uses compareTo() is said to be consistent with equals if, and only if, x equals(y) is true whenever x.compareTo(y) equals 0.
  - You are strongly encouraged to make your Comparable classes consistent with equals because not all collection classes behave predictably if the compareTo() and equals() methods are not consistent.

#### Comparator

- Sometimes you want to sort an object that did not implement Comparable, or you want to sort objects in different ways at different times.
- ```Comparator``` is a **functional interface** since there is only one abstract method to implement.
- Is Comparable a Functional Interface?
  - Comparable is also a functional interface since it also has a single abstract method. However, using a lambda for Comparable would be silly. The point of Comparable is to implement it inside the object being compared.
- Comparison of Comparable and Comparator table **important** refer to book
- An Easier Way of Comparing Multiple Fields
  - Java 8 makes this much easier. With the introduction of static and default methods on interfaces, there are now some new helper methods on Comparator.

### Searching and Sorting

- You already know the basics of searching and sorting. You now know a little more about ```Comparable``` and ```Comparator```.
- The sort method uses the compareTo() method to sort. It expects the objects to be sorted to be Comparable.
- ```sort()``` and ```binarySearch()``` allow you to pass in a Comparator object when you don’t want to use the natural order.

### Additions in Java 8

#### Using Method References

- *Method references* are a way to make the code shorter by reducing some of the code that can be inferred and simply mentioning the name of the method.
- Like lambdas, it takes time to get used to the new syntax.
- The :: operator tells Java to pass the parameters automatically into compareByWeight.
- DuckHelper::compareByWeight returns a functional interface and not an ```int```. Remember that :: is like **lambdas**, and it is typically used for **deferred execution**.
- There are four formats for method references:
  - Static methods
  - Instance methods on a particular instance
  - Instance methods on an instance to be determined at runtime
  - Constructors
- ```Predicate``` is a functional interface that takes a single parameter of any type and returns a boolean. 
- Another functional interface is ```Consumer```, which takes a single parameter of any type and has a void return type. 
- Finally, ```Supplier``` doesn’t take any parameters and returns any type.
- A *constructor reference* is a special type of method reference that uses ```new``` instead of a method, and it creates a new object.

#### Removing Conditionally

- Java 8 introduces a new method called ```removeIf```.
- Before this, we had the ability to remove a specified object from a collection or a specified index from a list. Now we can specify what should be deleted using a block of code.
- ```boolean removeIf(Predicate<? super E> filter)```
- It uses a Predicate, which is a lambda that takes one parameter and returns a boolean.
- Since **lambdas** use **deferred execution**, this allows specifying logic to run when that point in the code is reached.
- The most important thing to remember about ```removeIf``` is that it is one of two methods that are **on a collection** and it **takes a lambda parameter**.

#### Updating All Elements

- Another new method introduced on Lists is ```replaceAll```. Java 8 lets you pass a lambda expression and have it applied to each element in the list.
- ```void replaceAll(UnaryOperator<E> o)```
- It uses a ```UnaryOperator```, which takes one parameter and returns a value of the same type.

#### Looping through a Collection

- cats.forEach(c -> System.out.println(c));
- we’ve used a Consumer, which takes a single parameter and doesn’t return anything.

#### Using New Java 8 Map APIs

- Java 8 added a number of new methods on the Map interface.
- Only merge() is listed in the OCP objectives. Two others, computeIfPresent() and computeIfAbsent(), are added in the upgrade exam objectives.
- https://www.selikoff.net/java-ocp-8-programmer-ii-study-guide/
- Sometimes you need to **update** the value for a specific key in the map.
- putIfAbsent(), that you can call if you want to set a value in the map, but this method skips it if the value is already set to a non-null value.

##### merge

- If the specified key is not already associated with a value or the value is null, it associates the key with the given value.
- Otherwise, it replaces the value with the results of the given remapping function. If the result of the remapping function is null, it removes the result.
- uses a functional interface called a BiFunction.
- The mapping function is used only when there are two actual values to decide between.
- The final thing to know about merge() is what happens when the mapping function is called and returns ```null```. The key is removed from the map when this happens.

##### computeIfPresent and computeIfAbsent

- computeIfPresent() calls the BiFunction if the requested key is found.
- The function interface is a BiFunction again. However, this time the **key and value** are passed rather than two values.
- For computeIfAbsent(), the **functional interface** runs only when the key isn’t present or is ```null```.
- Since there is no value already in the map, a ```Function``` is used instead of a BiFunction. **Only the key** is passed as input.
  - ```Function<String, Integer> mapper4 = (k) -> 1;```
- If the mapping function is called and returns null, the key is removed from the map for computeIfPresent(). For computeIfAbsent(), the key is never added to the map in the first place.
- See The basics of the merge and compute methods table in the book

## Chapter 4: Functional Programming

