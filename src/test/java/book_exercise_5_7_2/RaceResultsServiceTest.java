package book_exercise_5_7_2;

import org.junit.Test;

import java.util.Date;

import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {

    // set up
    private Logger logger = mock(Logger.class);
    private RaceResultsService raceResults = new RaceResultsService(logger);
    private Message message = mock(Message.class);
    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");
    private SubscriptionCategory subscriptionCategory = SubscriptionCategory.BOAT_RACES;

    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {
        raceResults.send(message, 1);

        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test
    public void subscribedClientShouldReceiveMessage() {
        raceResults.addSubscriber(clientA, subscriptionCategory);
        raceResults.send(message, 1);

        verify(clientA).receive(message);
    }

    @Test
    public void allSubscribedClientsShouldReceiveMessages() {
        raceResults.addSubscriber(clientA, subscriptionCategory);
        raceResults.addSubscriber(clientB, subscriptionCategory);

        raceResults.send(message, 1);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    public void clientSubscribedTwiceShouldGetMessagesOnlyOnce() {
        raceResults.addSubscriber(clientA, subscriptionCategory);
        raceResults.addSubscriber(clientA, subscriptionCategory);
        raceResults.send(message, 1);

        verify(clientA, times(1)).receive(message);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveMessages() {
        raceResults.addSubscriber(clientA, subscriptionCategory);

        try {
            raceResults.removeSubscriber(clientA);
        } catch (Exception e) {
            e.printStackTrace();
        }

        raceResults.send(message, 1);

        verify(clientA, never()).receive(message);
    }

    @Test
    public void shouldSendMessageWithResultOfDifferentCategory() {
        // arrange
        Message message = new Message("message", subscriptionCategory);

        // act
        clientA.subscribeToCategory(subscriptionCategory);
        raceResults.send(message, 1);

        // assert
        verify(clientA).receive(message);
    }

    @Test
    public void sentMessageShouldBeLogged() {
        // arrange
        Message message1 = new Message("message" , subscriptionCategory);

        // act
        raceResults.send(message1, 1);

        // assert
        verify(logger).printLog(message1.getMessage(), message1.getDate());
    }

    @Test
    public void subscriberShouldReceiveMultipleMessages() {
        // arrange
        raceResults.addSubscriber(clientA, subscriptionCategory);

        // act
        raceResults.send(message, 3);

        // assert
        verify(clientA).receive(message);
        verify(clientA).receive(message);
        verify(clientA).receive(message);
    }

    @Test (expected = Exception.class)
    public void unsubscribedClientTryingToUnsubscribeShouldFail() throws Exception {
        raceResults.removeSubscriber(clientA);
    }
}
