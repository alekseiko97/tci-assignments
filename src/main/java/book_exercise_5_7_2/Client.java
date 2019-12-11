package book_exercise_5_7_2;

public class Client {

    private SubscriptionCategory category;

    public Client() {

    }

    public void receive(Message message) {

    }

    public void subscribeToCategory(SubscriptionCategory category) {
        this.category = category;
    }

    public SubscriptionCategory getCategory() {
        return this.category;
    }
}
