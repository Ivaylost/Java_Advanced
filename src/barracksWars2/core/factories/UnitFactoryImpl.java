package barracksWars2.core.factories;

import barracksWars2.interfaces.Unit;
import barracksWars2.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // TODO: implement for problem 3

        Class<?> reflection = Class.forName(UNITS_PACKAGE_NAME + unitType);

        return (Unit) reflection.getDeclaredConstructor().newInstance();
    }
}