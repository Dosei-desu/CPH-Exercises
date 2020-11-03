import java.util.LinkedList;

public class OrderHistory {
    private LinkedList<Order> orderHistory;

    public OrderHistory() {
        orderHistory = new LinkedList<>();
    }

    public void addOrder(Order _order) {
        orderHistory.addFirst(_order);
    }

    public LinkedList<Order> getOrderHistory() {
        return orderHistory;
    }
}
