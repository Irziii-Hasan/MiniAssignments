package anonymous;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Messenger messenger = new Messenger() {
            @Override
            void getNotification() {
                System.out.println("This message is coming from an anonymous class...");
            }
        };

        messenger.getNotification();
        System.out.println();
        System.out.println("=============");


        ATM atm = new ATM();
        atm.withdraw(3500, new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("Sending SMS: "+message);
            };
        });

        System.out.println();

        atm.withdraw(3500, new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("Sending Email: "+message);
            };
        });


        MyInterface myInterface1 =(int value) -> System.out.println("Hello "+value);

        myInterface1.printValues(7);
        myInterface1.testing();
        myInterface1.testing();
        myInterface1.testing();

        MyInterface myInterface = (int value) ->{
                for (int i =0; i<5; i++){
                    int b = i;
                    Runnable runnable = ()-> System.out.println("Hello "+b);
                    new Thread(runnable).start();
                }
        };


        myInterface.printValues(7);
        myInterface.toString();


        System.out.println();
        System.out.println("=== Built in Interfaces implementation ===");
        System.out.println();
        System.out.println("---Consumer Interface");

        Consumer<String> consumer = (name)->{
            System.out.println("Assalam u Alaiakum. My name is "+ name);
        };
        consumer.accept("Irza");

        System.out.println();
        System.out.println("---BiFunction Interface");
        BiFunction<Integer , String , String> biFunction = (value, name)->{
            return (value + " "+ name);
        };

        System.out.println(biFunction.apply(37, "Irziii Pirziii"));

        System.out.println();
        System.out.println("---ForEach loop in list");

        List<String> myList = Arrays.asList("aaa","aab", "aba", "abb","baa","bab","bba","bbb");
        myList.forEach(System.out::println);
        System.out.println();
        System.out.println("---Streams API");

        myList.stream().filter(name -> name.startsWith("a")).unordered().forEach(System.out :: println);

        myList.sort(( o1,  o2)-> o1.compareTo(o2));
        myList.sort(String::compareTo);

        System.out.println();

        Utils utils = new Utils();

        System.out.println("-- Lambda expression --");
        myList.forEach(name ->utils.greet(name));

        System.out.println();
        System.out.println("-- lambda with method reference");
        myList.forEach(utils::greet);


    }
}
