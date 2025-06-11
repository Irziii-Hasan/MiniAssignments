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
    }
}
