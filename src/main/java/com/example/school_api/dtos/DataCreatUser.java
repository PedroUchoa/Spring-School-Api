package com.example.school_api.dtos;

import com.example.school_api.enums.Role;

public record DataCreatUser(String login, String password, Role role) {
}
