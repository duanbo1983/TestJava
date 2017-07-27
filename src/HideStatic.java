/**
 * Created by bod on 9/19/15.
 */
public class HideStatic {

    public static void main(String[] strings) {

        String a = "/";

        System.out.println("start" + a.substring(1) + ".");

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

        static {
            System.out.println("static block in base");
        }

        static void sMethod() {
            System.out.println("sMethod Base");
        }

        void printOut() {
            System.out.println("printOut Base");
        }
    }

    static class Sub extends Base {

        static {
            System.out.println("static block in Sub");
        }

        static void sMethod() {
            System.out.println("sMethod Sub");
        }

        void printOut() {
            System.out.println("printOut Sub");
        }
    }
}
