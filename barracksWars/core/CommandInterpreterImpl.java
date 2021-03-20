package barracksWars.core;

import barracksWars.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMANDS_PATH = "barracksWars.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data) {
        Executable command = null;
        String commandName = data[0];
        commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);

        try {
            // getting class and its contructor with reflection
            Class<?> clazz = Class.forName(COMMANDS_PATH + commandName);
            Constructor<?> ctor = clazz.getDeclaredConstructor(String[].class);
            ctor.setAccessible(true);

            /* creating instance of Executable passing data as Object[]
            passing only data to newInstance() leads to:
            Confusing argument 'data', unclear if a varargs or non-varargs call is desired */
            command = (Executable) ctor.newInstance(new Object[]{data});

            // get command fields - data/repository/unitFactory
            Field[] executableFields = command.getClass().getDeclaredFields();
            // get this fields - repository/unitFactory
            Field[] localFields = this.getClass().getDeclaredFields();

            /* since commands' fields repository and unitFactory are annotated with @Inject (data is passed in constructor),
            they need to be passed, inject, set */
            for (Field executableField : executableFields) {
                if (executableField.isAnnotationPresent(Inject.class)) {
                    for (Field localField : localFields) {
                        if (executableField.getType().equals(localField.getType())) {
                            executableField.setAccessible(true);
                            // on command instance's field (annotated repository/unitFactory) a local field is set
                            executableField.set(command, localField.get(this));
                        }
                    }
                }
            }

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return command;
    }
}
