package book_exercise_5_7_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class RaceResultsService {

    // HashSet doesn't allow duplicates
    private Collection<Client> clients = new HashSet<>();

    public void addSubscriber(Client client) {
        clients.add(client);
    }

    public void send(Message message) {
        for (Client client: clients) {
            client.receive(message);
        }
    }

    public void removeSubscriber(Client clientA) {
    }
}
