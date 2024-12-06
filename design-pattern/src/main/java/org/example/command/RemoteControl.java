package org.example.command;

public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton(){
        if (command != null){
            command.execute();
        }else {
            System.out.println("no command here");
        }
    }
}
