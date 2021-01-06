package classloader;

public class SubClass  extends SuperClass {
    static {
        System.out.println("subclass init");
    }

    static int subInt = 112;
}
