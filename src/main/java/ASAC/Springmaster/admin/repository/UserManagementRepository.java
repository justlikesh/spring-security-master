package ASAC.Springmaster.admin.repository;

import ASAC.Springmaster.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagementRepository extends JpaRepository<Account, Long> { }
