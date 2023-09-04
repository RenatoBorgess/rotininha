package com.borges.Rotininha.dto;

import com.borges.Rotininha.model.RoleModel;
import com.borges.Rotininha.model.RoleName;

public record RegisterDTO(String login, String password, RoleModel role) {
}
