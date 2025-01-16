package dev.invencio.Invencio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.invencio.Invencio.model.Admin;

public interface InvencioAdminRepo extends JpaRepository<Admin, String> {

}
