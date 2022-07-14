package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.ProductDTO;
import dd.projects.ddshop.dtos.UserCreationDTO;
import dd.projects.ddshop.dtos.UserDTO;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.entities.User;
import dd.projects.ddshop.mappers.UserCreationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dd.projects.ddshop.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser (User user) {
        userRepository.save(user);
    }

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDtos = new ArrayList<>();

        for(User user : users) {
            usersDtos.add(new UserDTO(user));
        }
        return usersDtos;
    }

    public void updateUser (int userId, User newUser) {
        User user = userRepository.findById(userId).get();
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setPhoneNumber(newUser.getPhoneNumber());
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }
    public void deleteUserById (int id) {
        userRepository.deleteById(id);
    }

}
