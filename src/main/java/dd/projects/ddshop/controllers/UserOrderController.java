package dd.projects.ddshop.controllers;


import dd.projects.ddshop.entities.UserOrder;
import dd.projects.ddshop.services.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserOrderController {

    private final UserOrderService userOrderService;

    @Autowired
    public UserOrderController(UserOrderService userOrderService) {
       this.userOrderService = userOrderService;
    }

    @GetMapping("/getUserOrder")
    public ResponseEntity<List<UserOrder>> getUserOrder() {
        return new ResponseEntity<>(userOrderService.getUserOrder(), HttpStatus.OK);
    }

    @PostMapping("/createUserOrder")
    public ResponseEntity <Object> createUser (@RequestBody UserOrder userOrder){
        userOrderService.createUserOrder(userOrder);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @PutMapping("/updateUserOrder/{id}")
    public ResponseEntity<Object> updateUserOrder (@PathVariable Integer id, @RequestBody UserOrder newUserOrder) {
        userOrderService.updateUserOrder(id,newUserOrder);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserOrderById/{id}")
    void deleteUserOrderById (@PathVariable Integer id) {
        userOrderService.deleteUserOrderById(id);
    }
}
