package anonymous;

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

    }
}
