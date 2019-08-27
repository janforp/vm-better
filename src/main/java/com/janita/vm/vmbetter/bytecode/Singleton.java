package com.janita.vm.vmbetter.bytecode;

public class Singleton {
	private Singleton() {}
	private static class SingletonHolder{
		private static Singleton instance = new Singleton();
	}
	public static Singleton getInstance() {
		return SingletonHolder.instance;
	}
}
