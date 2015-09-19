/**
 * Created by bod on 9/19/15.
 */
public class HideStatic {

    public static void main(String[] strings) {

        Sub sub = new Sub();

        Base base = sub;

        base.printOut();
        base.sMethod();
        Base.sMethod();

        sub.printOut();
        sub.sMethod();
        Sub.sMethod();
    }

    static class Base {
        static void sMethod() {
            System.out.println("sMethod Base");
        }

        static void s2Method(String str) {
            System.out.println("s2 Method Base");
        }

        void printOut() {
            System.out.println("printOut Base");
        }
    }

    static class Sub extends Base {
        static void sMethod() {
            System.out.println("sMethod Sub");
        }

        void printOut() {
            System.out.println("printOut Sub");
        }

//        void s2Method(String str) {
//
//        }
    }

    class A {
//        static String A = "abc";

        //static void test();
    }
}
