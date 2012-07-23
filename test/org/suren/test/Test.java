package org.suren.test;

import java.util.List;

public class Test
{

	public static native List<SDR> getSensor(String host, String user,
			String pwd);

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		C c = new C();
		for(int i = 0; i < 6; i++)
		{
//			new Thread(new B(c, i)).start();
//
//			new Thread(new B_B(c, i)).start();

			new Thread(new B_D(i)).start();

			new Thread(new B_B_D(i)).start();
		}

		System.out.println(Test.class.getSimpleName());
	}

}

class B extends Thread
{
	private int c;
	private static final C cObj = new C();
	private C theC;

	public B(int c)
	{
		this.c = c;
	}

	public B(C theC, int c)
	{
		this.theC = theC;
		this.c = c;
	}

	@Override
	public void run()
	{
		theC.hi(c);
	}

}

class B_B extends Thread
{
	private int c;
	private static final C cObj = new C();
	private C theC;

	public B_B(int c)
	{
		this.c = c;
	}

	public B_B(C theC, int c)
	{
		this.theC = theC;
		this.c = c;
	}

	@Override
	public void run()
	{
		theC.say(c);
	}

}

class B_D extends Thread
{
	private int c;

	public B_D(int c)
	{
		this.c = c;
	}

	@Override
	public void run()
	{
		D.hi(c);
	}

}

class B_B_D extends Thread
{
	private int c;

	public B_B_D(int c)
	{
		this.c = c;
	}

	@Override
	public void run()
	{
		D.say(c);
	}

}

class C
{
	private static int count = 0;

	public synchronized void hi(int c)
	{
		count = c;

		System.out.println("hi==begin:" + count + "==time:" + System.nanoTime() + "===thread" + Thread.currentThread().getId());

		for(int i = 0; i < 10000000; i++)
		{
			;
		}

		System.out.println("hi==end:" + count + "==time:" + System.nanoTime() + "===thread" + Thread.currentThread().getId());
	}

	public synchronized void say(int c)
	{
		count = c;

		System.out.println("say==begin:" + count + "==time:" + System.nanoTime() + "===thread" + Thread.currentThread().getId());

		for(int i = 0; i < 10000000; i++)
		{
			;
		}

		System.out.println("say==end:" + count + "==time:" + System.nanoTime() + "===thread" + Thread.currentThread().getId());
	}
}

class D
{
	private static int count = 0;

	public static synchronized void hi(int c)
	{
		count = c;

		System.out.println("hi==begin:" + count + "==time:" + System.nanoTime() + "===thread" + Thread.currentThread().getId());

		for(int i = 0; i < 10000000; i++)
		{
			;
		}

		System.out.println("hi==end:" + count + "==time:" + System.nanoTime() + "===thread" + Thread.currentThread().getId());
	}

	public static synchronized void say(int c)
	{
		count = c;

		System.out.println("say==begin:" + count + "==time:" + System.nanoTime() + "===thread" + Thread.currentThread().getId());

		for(int i = 0; i < 10000000; i++)
		{
			;
		}

		System.out.println("say==end:" + count + "==time:" + System.nanoTime() + "===thread" + Thread.currentThread().getId());
	}
}