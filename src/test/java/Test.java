/**
 * Created by chenjun on 2020-02-23 22:11
 */
public class Test {
    public enum Singleton {
        INSTANCE;
        public void whateverMethod() {
            System.out.println("hello world");
        }
    }

    public static void main(String[] args) {
        Singleton.INSTANCE.whateverMethod();
    }



}
