package dd.projects.ddshop.controllers;


import dd.projects.ddshop.dtos.UserCreationDTO;
import dd.projects.ddshop.dtos.UserDTO;
import dd.projects.ddshop.entities.User;
import dd.projects.ddshop.mappers.UserCreationMapper;
import dd.projects.ddshop.mappers.UserMapper;
import dd.projects.ddshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    UserCreationMapper userCreationMapper = new UserCreationMapper() ;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity <Object> createUser (@RequestBody UserCreationDTO userCreationDTO){
        userService.createUser(userCreationMapper.sourceToDestination(userCreationDTO));
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Object> updateUser (@PathVariable Integer id, @RequestBody User newUser) {
        userService.updateUser(id,newUser);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserById/{id}")
    void deleteAddressById (@PathVariable Integer id) {
        userService.deleteUserById(id);
    }
}
