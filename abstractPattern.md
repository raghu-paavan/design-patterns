The **Abstract Factory** is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. It's used when you want to create a set of related objects without coupling the code to specific implementations, enabling interchangeability of object families.

### Structure:
- **Abstract Factory**: Declares the interface to create the families of related objects.
- **Concrete Factory**: Implements the Abstract Factory interface to produce sets of related objects.
- **Abstract Product**: Declares interfaces for a set of distinct but related products.
- **Concrete Product**: Implements the Abstract Product interfaces, defining the objects to be created by the corresponding Concrete Factory.

### Example in Java:
Consider a game where you have different characters (Warriors, Mages) belonging to different factions (Human, Orc). Here's an abstract factory implementation :

```java
// Abstract Product: Character
interface Character {
    void display();
}

// Concrete Products: HumanWarrior, HumanMage, OrcWarrior, OrcMage
class HumanWarrior implements Character {
    public void display() {
        System.out.println("Human Warrior");
    }
}

class HumanMage implements Character {
    public void display() {
        System.out.println("Human Mage");
    }
}

class OrcWarrior implements Character {
    public void display() {
        System.out.println("Orc Warrior");
    }
}

class OrcMage implements Character {
    public void display() {
        System.out.println("Orc Mage");
    }
}

// Abstract Factory: FactionFactory
interface FactionFactory {
    Character createWarrior();
    Character createMage();
}

// Concrete Factories: HumanFactory, OrcFactory
class HumanFactory implements FactionFactory {
    public Character createWarrior() {
        return new HumanWarrior();
    }

    public Character createMage() {
        return new HumanMage();
    }
}

class OrcFactory implements FactionFactory {
    public Character createWarrior() {
        return new OrcWarrior();
    }

    public Character createMage() {
        return new OrcMage();
    }
}
```

### When to Use:
- **Multiple Related Objects**: Use when the system needs multiple related objects or product families.
- **Changing Object Families**: When you need to accommodate varying families of related objects interchangeably.

### Important Points:
- **Encapsulation**: Abstract Factory encapsulates the creation of product objects, providing an interface for clients.
- **Flexibility**: Allows changing the entire family of products at runtime by using a different factory.
- **Complexity**: Introduces additional complexity by creating hierarchies of factories and products.

Use the Abstract Factory pattern when you anticipate the need to create families of related or dependent objects, and you want to ensure that these families are compatible and interchangeable.


One of the classic examples of the Strategy pattern in Java's core libraries is the `java.util.Comparator` interface. This interface defines a strategy for comparing objects.

Here's how it works:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 20));

        // Using Comparator (Strategy pattern)
        Comparator<Person> byName = Comparator.comparing(Person::getName);
        Comparator<Person> byAge = Comparator.comparingInt(Person::getAge);

        // Sorting using different strategies
        Collections.sort(people, byName);
        System.out.println("Sorted by name: " + people);

        Collections.sort(people, byAge);
        System.out.println("Sorted by age: " + people);
    }
}
```

In this example:

- The `Comparator` interface represents the Strategy pattern. It defines a strategy for comparing objects.
- `Comparator` allows different comparison strategies to be defined (e.g., by name, by age) through lambda expressions or method references.
- `Collections.sort()` takes a list and a `Comparator` as arguments. It uses the provided `Comparator` strategy to sort the list accordingly.

The `Comparator` interface in Java's Collections framework is a prime example of the Strategy pattern. It encapsulates various comparison strategies, allowing them to be applied to different collections for sorting purposes without modifying the core sorting algorithm itself.