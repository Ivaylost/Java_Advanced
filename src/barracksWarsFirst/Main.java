package barracksWarsFirst;

import barracksWarsFirst.interfaces.Repository;
import barracksWarsFirst.interfaces.Runnable;
import barracksWarsFirst.interfaces.UnitFactory;
import barracksWarsFirst.core.Engine;
import barracksWarsFirst.core.factories.UnitFactoryImpl;
import barracksWarsFirst.data.UnitRepository;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
