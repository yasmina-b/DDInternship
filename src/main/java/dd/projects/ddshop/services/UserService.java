package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.UserCreationDTO;
import dd.projects.ddshop.dtos.UserDTO;
import dd.projects.ddshop.entities.User;
import dd.projects.ddshop.mappers.UserCreationMapperImpl;
import dd.projects.ddshop.mappers.UserMapperImpl;
import dd.projects.ddshop.utils.Password;
import dd.projects.ddshop.validations.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dd.projects.ddshop.repositories.UserRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserCreationMapperImpl userCreationMapper;

    private final UserMapperImpl userMapper;

    private final UserValidation userValidation;

    @Autowired
    public UserService (final UserRepository userRepository, final UserCreationMapperImpl userCreationMapper, final UserMapperImpl userMapper) {
        this.userRepository = userRepository;
        this.userCreationMapper = userCreationMapper;
        this.userMapper = userMapper;
        this.userValidation = new UserValidation(userRepository);
    }
    public void createUser (final UserCreationDTO userCreationDTO) {
        userValidation.userValidation(userCreationDTO);
        final User user = userMapper.toUser(userCreationDTO);
        user.setPassword(Password.getMD5EncryptedValue(user.getPassword()));
        userRepository.save(user);
    }
    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserDTO)
                .collect(toList());
    }
    public void updateUser (int userId, UserCreationDTO newUser) {
        User user = userRepository.findById(userId).get();
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setPhoneNumber(newUser.getPhoneNumber());
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }
    public void deleteUserById (final int id) {
        userRepository.deleteById(id);
    }

}
