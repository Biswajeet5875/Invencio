package dev.invencio.Invencio.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.invencio.Invencio.model.Admin;
import dev.invencio.Invencio.model.Stock;
import dev.invencio.Invencio.repository.InvencioAdminRepo;
import dev.invencio.Invencio.repository.InvencioRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvencioService {

    public final InvencioRepo invencioRepo;
    public final InvencioAdminRepo invencioAdminRepo;

    public void createNewStock(Stock invencio) {

        invencioRepo.save(invencio);
    }

    public void createAdmin(Admin admin) {
        invencioAdminRepo.save(admin);
    }

}
