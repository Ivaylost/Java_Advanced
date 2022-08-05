package barracksWars2.core.commands;

import barracksWars2.annotations.Inject;
import barracksWars2.interfaces.Repository;
import barracksWars2.interfaces.Unit;
import barracksWars2.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command {

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String unitType = super.getData()[1];

        Unit unitToAdd = this.unitFactory.createUnit(unitType);

        this.repository.addUnit(unitToAdd);

        return unitType + " added!";
    }
}
