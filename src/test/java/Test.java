import org.junit.Assert;

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

        int a = 2;
        int b = 3;
        int c = 4;

        a = b= c;

        System.out.println(a);
        System.out.println(b);
    }

    @org.junit.Test
    public void test(){
        Integer a = new Integer(128);
        Integer b = new Integer(128);
        System.out.println(a==b);
    }

}
