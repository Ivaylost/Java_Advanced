package barracksWars2.core;

import barracksWars2.annotations.Inject;
import barracksWars2.interfaces.CommandInterpreter;
import barracksWars2.interfaces.Executable;
import barracksWars2.interfaces.Repository;
import barracksWars2.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMAND_PACKAGE_NAME = "barracksWars.core.commands.";

    private final Repository repository;
    private final UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Executable interpretCommand(String[] data, String commandName) {

        final String commandFromConsole = commandName.toUpperCase().charAt(0) + commandName.substring(1);
        Executable command = null;

        try {
            final Class<? extends Executable> commandClass = (Class<? extends Executable>) Class.forName(COMMAND_PACKAGE_NAME + commandFromConsole);

            final Constructor<? extends Executable> constructor = commandClass.getDeclaredConstructor(String[].class);

            command = constructor.newInstance(new Object[]{data});

            final Field[] commandFields =
                    Arrays.stream(command.getClass().getDeclaredFields()).
                    peek(field -> field.setAccessible(true)).toArray(Field[]::new);

            final Map<String, Field> thisFields =
                    Arrays.stream(this.getClass().getDeclaredFields()).
                            collect(Collectors.toMap(field -> field.getType().toString(), field -> field));

            for (Field commandField : commandFields) {
                if (commandField.isAnnotationPresent(Inject.class)) {
                    Field commandImplField = thisFields.get(commandField.getType().toString());
                    commandField.set(command, commandImplField.get(this));
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return command;
    }
}