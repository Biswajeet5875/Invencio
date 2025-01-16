package dev.invencio.Invencio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String adminId;
    public String fullName;
    public String role;
    public String email;
    public String phone;
    public String username;
    public String password;
    public String brn;
    public String tin;

    @Lob
    public String address;

}
