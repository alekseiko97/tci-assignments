package book_exercise_5_7_2;

import java.util.ArrayList;
import java.util.Collection;

public class RaceResultsService {

    private Collection<Client> clients = new ArrayList<Client>();

    public void addSubscriber(Client client) {
        clients.add(client);
    }

    public void send(Message message) {
        for (Client client: clients) {
            client.receive(message);
        }
    }
}
