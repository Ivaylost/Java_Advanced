package barracksWars2;

import barracksWars2.core.CommandInterpreterImpl;
import barracksWars2.interfaces.CommandInterpreter;
import barracksWars2.interfaces.Repository;
import barracksWars2.interfaces.Runnable;
import barracksWars2.interfaces.UnitFactory;
import barracksWars2.core.Engine;
import barracksWars2.core.factories.UnitFactoryImpl;
import barracksWars2.data.UnitRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}