package io.veasna.ccaptain.utils;

import io.veasna.ccaptain.domain.UserPrincipal;
import io.veasna.ccaptain.dto.UserDTO;
import org.springframework.security.core.Authentication;


public class UserUtils {

    public static UserDTO getAuthenticatedUser(Authentication authentication){
        return ((UserDTO) authentication.getPrincipal());
    }
    public static UserDTO getLoggedInUser (Authentication authentication){
        return ((UserPrincipal) authentication.getPrincipal()).getUser();
    }
}
