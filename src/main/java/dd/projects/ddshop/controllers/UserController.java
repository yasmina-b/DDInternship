package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.UserCreationDTO;
import dd.projects.ddshop.dtos.UserDTO;
import dd.projects.ddshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity <Object> createUser (@RequestBody final UserCreationDTO userCreationDTO){
        userService.createUser(userCreationDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Object> updateUser (@PathVariable Integer id, @RequestBody UserCreationDTO newUser) {
        userService.updateUser(id,newUser);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserById/{id}")
    void deleteAddressById (@PathVariable final Integer id) {
        userService.deleteUserById(id);
    }
}
