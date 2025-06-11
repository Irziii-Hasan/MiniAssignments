package anonymous;

public class ATM {
    public void withdraw(int amount, Notifier notifier){
        System.out.println("withdrawing "+amount+"  rupees.");
        notifier.send("Alert Rs. "+amount+" withdraw from your account");

    }
}
