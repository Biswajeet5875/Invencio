package dev.invencio.Invencio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.invencio.Invencio.model.Admin;

@Repository
public interface InvencioAdminRepo extends JpaRepository<Admin, String> {

    Admin findByUsernameAndPassword(String username, String password);

}
