/**
 *
 */
package org.suren.test.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author suren
 *
 */
public class SuRen {

	/**
	 * @param args
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws IllegalArgumentException
	 */
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Class<Runner> runnerClass = Runner.class;

		Constructor<Runner> constructor = runnerClass.getConstructor();
		Runner runner = constructor.newInstance();

		Field[] fields = runnerClass.getDeclaredFields();

		fields[0].setAccessible(true);
		System.out.println(fields[0].get(runner));
		fields[0].set(runner, "ni hao");

		System.out.println();

		Runner.main(null);
	}

}
