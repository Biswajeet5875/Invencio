package dev.invencio.Invencio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminResponse {

    private String adminId;
    private String fullName;
    private String role;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String brn;
    private String tin;
    private String address;
}
