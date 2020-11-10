/**
 * @author Johan
 */

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

    public void archiveOrder(int _id) { //could just be a for i loop (enhanced not necessary)
        int index = 0;
        for (Order order : activeOrders) {
            if (order.getId() == _id) {
                activeOrders.remove(index);
                orderHistory.addOrder(order);
            }
            ++index;
        }
    }

    public LinkedList<Order> getActiveOrders() {
        return activeOrders;
    }
}
