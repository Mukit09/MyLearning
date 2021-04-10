package service.a;

public interface L {
	void eat();
}

/*

javac --module-path . -d service service/service/a/*.java service/module-info.java
javac --module-path . -d provider provider/provider/b/*.java provider/module-info.java
javac --module-path . -d application application/application/c/*.java application/module-info.java

java --module-path . -m application/application.c.Main

*/