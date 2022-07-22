package dd.projects.ddshop.services;

import dd.projects.ddshop.entities.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dd.projects.ddshop.repositories.UserOrderRepository;

import java.util.List;

@Service
public class UserOrderService {
    private final UserOrderRepository userOrderRepository;

    @Autowired
    public UserOrderService (final UserOrderRepository userOrderRepository){
        this.userOrderRepository = userOrderRepository;
    }
    public void createUserOrder (final UserOrder userOrder) {
        userOrderRepository.save(userOrder);
    }

    public List<UserOrder> getUserOrder() {
        return userOrderRepository.findAll();
    }

    public void updateUserOrder (int orderId, UserOrder newOrder) {
        UserOrder order = userOrderRepository.findById(orderId).get();
        order.setOrderDate(newOrder.getOrderDate());
        order.setTotalPrice(newOrder.getTotalPrice());
        order.setPaymentType(newOrder.getPaymentType());
        userOrderRepository.save(order);
    }
    public void deleteUserOrderById (final int id) {
        userOrderRepository.deleteById(id);
    }
}
