package book_exercise_5_7_2;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class RaceResultsService {

    private Logger logger;

    public RaceResultsService(Logger logger) {
        this.logger = logger;
    }

    // HashSet doesn't allow duplicates
    private Collection<Client> clients = new HashSet<>();

    public void addSubscriber(Client client, SubscriptionCategory subscriptionCategory) {
        clients.add(client);
        client.subscribeToCategory(subscriptionCategory);
    }

    public void send(Message message, int nrOfMessages) {
        for (Client client: clients) {
            for (int i = 0; i < nrOfMessages; i++) {
                if (client.getCategory() == message.getCategory()) {
                    client.receive(message);
                    logger.printLog(message.getMessage(), message.getDate());
                }
            }
        }
    }

    public void removeSubscriber(Client client) throws Exception {
        if (clients.contains(client)) {
            clients.remove(client);
        } else {
            throw new Exception("Cannot unsubscribe an unsubscribed client");
        }
    }
}
