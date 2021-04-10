package application.c;

import service.a.L;

import java.util.ServiceLoader;

public class Main {
	public static void main(String[] args) {
		ServiceLoader<L> sl = ServiceLoader.load(L.class);
		L l = sl.findFirst().get();
		
		l.eat();
		System.out.println("Hi! Mukit!");
	}
}