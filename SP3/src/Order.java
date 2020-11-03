//Johan
import java.util.LinkedList;


public class Order {
    int id;
    long created;
    boolean ready, delivered, remote;
    LinkedList<Pizza> items;
    Customer customer;

    Order(int _id, boolean _remote, LinkedList<Pizza> _items, Customer _customer) {
        this.id = _id;
        this.created = System.currentTimeMillis();
        this.remote = _remote; // True: Ordered by phone; False: Ordered in-store
        this.items = _items; // pizza objects
        this.customer = _customer;
    }

    public double getPrice() {
        double price = 0;
        for (Pizza item : items) {
            price += item.getPrice(); // pizza need .getPrice() function
        }
        return price;
    }

    public int getId() {
        return id;
    }

    public long getCreated() {
        return created;
    }

    public boolean isReady() {
        return ready;
    }

    public boolean isRemote() {
        return remote;
    }

    public LinkedList<Pizza> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }
}