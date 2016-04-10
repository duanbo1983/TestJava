/**
 * Created by bod on 3/28/16.
 */
public class GenericFactory<T> {
    T data;
    String name;

    public GenericFactory(T data) {
        this.data = data;
    }

    public GenericFactory(String name) {
        this.name = name;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] strings) {
        GenericFactory<String> genericFactory = new GenericFactory("test");
        System.out.println(genericFactory.getData());
    }
}
