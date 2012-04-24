package org.suren.test.jni;

public class Hello {

	private native void say();

	private native Person get(String name);
}

class Person{
	private String name;
}