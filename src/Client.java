public class Client {
    String name, phone;
    Car car;
    ClientType clientType = ClientType.STANDARD;
    int washCount;

    public Client(String name, String phone, Car car) {
        this.name = name;
        this.phone = phone;
        this.car = car;
    }

    public void increaseWashCount() {
        washCount++;
    }
}
