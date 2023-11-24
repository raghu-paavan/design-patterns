The **Facade** design pattern is a structural pattern that provides a simplified interface to a complex system, hiding its complexity from the client. It acts as a unified interface to a set of interfaces in a subsystem, making the subsystem easier to use.

### Structure:
- **Facade**: Provides a simplified interface to the subsystem, hiding its complexities. It delegates client requests to appropriate subsystem objects.
- **Subsystems**: Consist of multiple classes/interfaces, each handling specific parts of the system's functionality.
- **Client**: Interacts with the Facade to access the subsystem. It's shielded from the complexities of the subsystem.

### Example in Java:
Consider a multimedia system with multiple components like the projector, audio system, and screen. The Facade pattern can simplify their usage:

```java
// Subsystem: Projector
class Projector {
    public void on() {
        System.out.println("Projector is on");
    }

    public void off() {
        System.out.println("Projector is off");
    }

    public void setInput(String input) {
        System.out.println("Setting input to: " + input);
    }
}

// Subsystem: Audio System
class AudioSystem {
    public void on() {
        System.out.println("Audio System is on");
    }

    public void off() {
        System.out.println("Audio System is off");
    }

    public void setVolume(int volume) {
        System.out.println("Setting volume to: " + volume);
    }
}

// Subsystem: Screen
class Screen {
    public void up() {
        System.out.println("Screen is up");
    }

    public void down() {
        System.out.println("Screen is down");
    }
}

// Facade: MultimediaFacade
class MultimediaFacade {
    private Projector projector;
    private AudioSystem audioSystem;
    private Screen screen;

    public MultimediaFacade() {
        this.projector = new Projector();
        this.audioSystem = new AudioSystem();
        this.screen = new Screen();
    }

    public void watchMovie() {
        projector.on();
        projector.setInput("DVD");
        audioSystem.on();
        audioSystem.setVolume(10);
        screen.down();
    }

    public void endMovie() {
        projector.off();
        audioSystem.off();
        screen.up();
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        MultimediaFacade multimediaFacade = new MultimediaFacade();

        // Start watching movie using the facade
        multimediaFacade.watchMovie();

        // End movie using the facade
        multimediaFacade.endMovie();
    }
}
```

### When to Use:
- **Simplify Interface**: Use when you need to provide a simple interface to a complex system or set of interfaces.
- **Decouple from Subsystems**: When you want to decouple the client code from the complex subsystems.

### Important Points:
- **Abstraction**: Facade promotes abstraction by providing a simplified interface, hiding implementation details.
- **Ease of Use**: Simplifies interactions with complex subsystems, improving usability.
- **Encapsulation**: Encapsulates the subsystems, preventing clients from directly interacting with them.

Use the Facade pattern to provide a unified and simplified interface to a complex system, reducing dependencies and making it easier for clients to use the system without dealing with its complexities.