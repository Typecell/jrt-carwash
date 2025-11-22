import java.time.LocalDateTime;

public class Ticket {
    Client client;
    Car car;
    WashType washType;
    double cost;
    LocalDateTime startTime, finishTime;

    public Ticket(Client client, Car car, WashType washType) {
        this.client = client;
        this.car = car;
        this.washType = washType;
    }
}
