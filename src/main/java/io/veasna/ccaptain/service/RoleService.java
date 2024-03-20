package io.veasna.ccaptain.service;

import io.veasna.ccaptain.domain.Role;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;


public interface RoleService {
    Role getRoleByUserId(Long id);
    Collection<Role> getRoles();
}
