package ASAC.Springmaster.admin.service;

import ASAC.Springmaster.domain.dto.AccountDto;
import ASAC.Springmaster.domain.entity.Account;

import java.util.List;

public interface UserManagementService {

    void modifyUser(AccountDto accountDto);

    List<Account> getUsers();
    AccountDto getUser(Long id);

    void deleteUser(Long idx);
}
