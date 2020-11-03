//Johan
import java.util.LinkedList;


public class ActiveOrders extends IdGenerator {
    OrderHistory orderHistory;
    private LinkedList<Order> activeOrders;
    int id;

    public ActiveOrders(OrderHistory _orderHistory) {
        super.initIdGenerator();
        activeOrders = new LinkedList<>();
        orderHistory = _orderHistory;
    }

    public void addOrder(boolean _remote, LinkedList<Pizza> _items, Customer _customer) {
        id = super.getRandomId();
        activeOrders.addLast(new Order(id, _remote, _items, _customer));
    }

    public void processOrder(Order _order) {
        int pId = _order.getId();
        int index = 0;
        for (Order order : activeOrders) {
            if (order.getId() == pId) {
                activeOrders.remove(index);
                orderHistory.addOrder(order);
            }
            ++index;
        }
    }

    public void processOrder(int _id) {
        int index = 0;
        for (Order order : activeOrders) {
            if (order.getId() == _id) {
                activeOrders.remove(index);
                orderHistory.addOrder(order);
            }
            ++index;
        }
    }

    public void processOrder(Customer _customer) {
        int index = 0;
        for (Order order : activeOrders) {
            if (order.getCustomer() == _customer) {
                activeOrders.remove(index);
                orderHistory.addOrder(order);
            }
            ++index;
        }
    }

    public int getLastOrderId() {
        return id;
    }

    public int getLength() {
        return activeOrders.size();
    }

    public LinkedList<Order> getActiveOrders() {
        return activeOrders;
    }
}
