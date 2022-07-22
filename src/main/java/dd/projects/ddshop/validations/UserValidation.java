package dd.projects.ddshop.validations;

import dd.projects.ddshop.dtos.UserCreationDTO;
import dd.projects.ddshop.entities.User;
import dd.projects.ddshop.exceptions.AlreadyExists;
import dd.projects.ddshop.exceptions.IncorrectInput;
import dd.projects.ddshop.repositories.UserRepository;
import dd.projects.ddshop.utils.Util;

public class UserValidation {

    private final UserRepository userRepository;

    public UserValidation (final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void userValidation (final UserCreationDTO userCreationDTO) {
        checkEmptyFields(userCreationDTO);
        checkEmail(userCreationDTO);
        checkPhoneNumber(userCreationDTO.getPhoneNumber());
        checkPassword(userCreationDTO.getPassword());

    }
    public void checkEmptyFields (final UserCreationDTO userCreationDTO) {
        if(userCreationDTO.getFirstName().isEmpty() || userCreationDTO.getLastName().isEmpty() ||
        userCreationDTO.getEmail().isEmpty() || userCreationDTO.getPhoneNumber().isEmpty() || userCreationDTO.getPassword().isEmpty()) {
            throw new IncorrectInput(Util.getMessage("api.error.empty.field",null));
        }
    }
    public void checkPhoneNumber(final String phoneNumber) {
        if(phoneNumber.length()!=10)
            throw new IncorrectInput(Util.getMessage("api.error.user.phone",null));
    }
    public void checkEmail (final UserCreationDTO userCreationDTO) {
        for(final User user : userRepository.findAll()){
            if(user.getEmail().equals(userCreationDTO.getEmail()))
                throw new AlreadyExists(Util.getMessage("api.error.user.email",null));
        }

    }
    public void checkPassword (final String password) {
        if(password.length()<8)
            throw new IncorrectInput(Util.getMessage("api.error.user.password",null));
    }

}
