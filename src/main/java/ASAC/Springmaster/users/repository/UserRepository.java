package ASAC.Springmaster.users.repository;

import ASAC.Springmaster.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, Long> {
}
