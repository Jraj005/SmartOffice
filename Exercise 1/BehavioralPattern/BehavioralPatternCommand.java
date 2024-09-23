import java.util.ArrayList;
import java.util.List;
// Command Interface
interface Command {
    void execute();
}

// Receiver class
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Concrete Command classes
class TurnOnCommand implements Command {
    private Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class TurnOffCommand implements Command {
    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Invoker class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Usage
public class BehavioralPatternCommand {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command turnOn = new TurnOnCommand(livingRoomLight);
        Command turnOff = new TurnOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();
        
        // Turning the light on
        remote.setCommand(turnOn);
        remote.pressButton();

        // Turning the light off
        remote.setCommand(turnOff);
        remote.pressButton();
    }
}
