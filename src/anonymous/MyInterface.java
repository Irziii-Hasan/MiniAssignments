package anonymous;

@FunctionalInterface
public interface MyInterface {
    void printValues(int value);
    default void testing(){
        System.out.println("hello world but this method is default");
        MyInterface.MyCall();
    }

    private static void MyCall(){
        System.out.println("Hello! this is MyCall speaking. I can only call from inside MyInterface");
    }

}
