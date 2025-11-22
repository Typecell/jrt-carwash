import java.time.LocalDateTime;
import java.util.ArrayList;

public class WashCar {
    ArrayList<Ticket> queue = new ArrayList<>();

    public void checkInCustomer(Client client, WashType washType) {
        double carCost = 0.0, multiplier = 0.0;

        switch (client.car.carType) {
            case CarType.SEDAN -> carCost = 100;
            case CarType.COUPE -> carCost = 200;
            case CarType.SPORT -> carCost = 300;
            case CarType.SUPER -> carCost = 400;
        }

        switch (washType) {
            case WashType.SIMPLE -> multiplier = 2;
            case WashType.ADVANCED -> multiplier = 3;
            case WashType.FULL -> multiplier = 4;
        }

        Ticket ticket = new Ticket(client, client.car, washType);

        if (client.washCount == 10) {
            ticket.cost = (carCost * multiplier) * 0.9;
        } else {
            ticket.cost = carCost * multiplier;
        }

        ticket.startTime = LocalDateTime.now();
        ticket.finishTime = ticket.startTime.plusHours(1);

        if (client.clientType == ClientType.VIP) {
            queue.addFirst(ticket);
        } else {
            queue.add(ticket);
        }
    }

    public void finishWashing(Client client) {
        client.increaseWashCount();

        if (client.washCount >= 100) {
            client.clientType = ClientType.VIP;
        }
    }
}
