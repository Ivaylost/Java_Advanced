package barracksWars2.interfaces;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Runnable {

	void run() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException;
}