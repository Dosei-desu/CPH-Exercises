/**
 * @author Johan, reworked by Kris
 */

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;


public class Order {
    int id;
    long created;
    Timestamp created_at;
    boolean ready, delivered, remote;
    LinkedList<Pizza> items;
    Customer customer;

    Order(int _id, boolean _remote, LinkedList<Pizza> _items, Customer _customer) {
        this.id = _id;
        this.created_at = new Timestamp(System.currentTimeMillis());
        this.remote = _remote; // True: Ordered by phone; False: Ordered in-store
        this.items = _items; // pizza objects
        this.customer = _customer;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Order #");
        string.append(id);
        if (ready) string.append(" READY: ");
        else if (delivered) string.append(" DELIVERED: ");
        else string.append(" IN PROGRESS: ");
        for (Pizza pizza : this.items) {
            string.append(pizza.getName());
            string.append(";");
        }
        string.append(" -- Total: ");
        string.append(getPrice());
        string.append(",-");
        return string.toString();
    }

    public double getPrice() {
        double price = 0;
        for (Pizza item : items) {
            price += item.getPrice(); // pizza need .getPrice() function
        }
        return price;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public int getId() {
        return id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    //not in use
    public String getCreated() {
        Date currentDate = new Date(this.created);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
        String date = dateFormat.format(currentDate);
        return date;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setReady(boolean flag){
        this.ready = flag;
    }

    public boolean isReady() {
        return ready;
    }

    public LinkedList<Pizza> getItems() {
        return items;
    }
}