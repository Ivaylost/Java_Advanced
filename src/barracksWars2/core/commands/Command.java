package barracksWars2.core.commands;

import barracksWars2.interfaces.Executable;

public abstract class Command implements Executable {
    private final String[] data;

    protected Command(String[] data) {

        this.data = data;
    }

    protected String[] getData() {

        return data;
    }
}