package io.veasna.ccaptain.service.impl;

import io.veasna.ccaptain.domain.Role;
import io.veasna.ccaptain.domain.User;
import io.veasna.ccaptain.dto.UserDTO;
import io.veasna.ccaptain.form.UpdateForm;
import io.veasna.ccaptain.repository.RoleRepository;
import io.veasna.ccaptain.repository.UserRepository;
import io.veasna.ccaptain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static io.veasna.ccaptain.dtomapper.UserDTOMapper.fromUser;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository<User> userRepository;
    private final RoleRepository<Role> roleRoleRepository;

    @Override
    public UserDTO createUser(User user) {
        return maptoUserDTO(userRepository.create(user));
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return maptoUserDTO(userRepository.getUserByEmail(email));
    }

    @Override
    public void sendVerificationCode(UserDTO user) {
        userRepository.sendVerificationCode(user);
    }
//
//    @Override
//    public User getUser(String email) {
//        return userRepository.getUserByEmail(email);
//    }

    @Override
    public UserDTO verifyCode(String email, String code) {
        return maptoUserDTO(userRepository.verifyCode(email,code));
    }

    @Override
    public void resetPassword(String email) {
        userRepository.resetPassword(email);
    }

    @Override
    public UserDTO verifyPasswordKey(String key) {
        return maptoUserDTO(userRepository.verifyPasswordKey(key));
    }

    @Override
    public UserDTO updateUserDetails(UpdateForm user) {
        return maptoUserDTO(userRepository.updateUserDetails(user));
    }

    @Override
    public UserDTO getUserById(Long userId) {
        return maptoUserDTO(userRepository.get(userId));
    }

    @Override
    public void renewPassword(String key, String password, String comfirmpassword) {
        userRepository.renewPassword(key,password,comfirmpassword);
    }

    @Override
    public UserDTO verifyAccountKey(String key) {
        return maptoUserDTO(userRepository.verifyAccountKey(key));
    }

    @Override
    public void updatePassword(Long id, String currentPassword, String newPassword, String comfirmNewPassword) {
        userRepository.updatePassword(id,currentPassword,newPassword,comfirmNewPassword);
    }

    @Override
    public void updateUserRole(Long userId, String roleName) {
        roleRoleRepository.updateUserRole(userId,roleName);
    }

    @Override
    public void updateAccountSettings(Long id, Boolean enabled, Boolean notLocked) {
        userRepository.updateAccountSettings(id,enabled,notLocked);
    }

    @Override
    public UserDTO toggleMfa(String email) {
        return maptoUserDTO(userRepository.toggleMfa(email));
    }

    @Override
    public void updateImage(UserDTO user, MultipartFile image) {
        userRepository.updateImage(user,image);
    }

    private UserDTO maptoUserDTO(User user) {
        return fromUser(user,roleRoleRepository.getRoleByUserId(user.getId()));
    }
}
