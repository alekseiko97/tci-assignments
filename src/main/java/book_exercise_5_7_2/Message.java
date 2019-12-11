package book_exercise_5_7_2;

import java.util.Date;

public class Message {

    private String message;
    private Date date;
    private SubscriptionCategory category;

    public Message(String message, SubscriptionCategory category) {
        this.message = message;
        this.date = new Date();
        this.category = category;
    }


    public String getMessage() {
        return this.message;
    }

    public Date getDate() {
        return this.date;
    }

    public SubscriptionCategory getCategory() {
        return category;
    }
}
