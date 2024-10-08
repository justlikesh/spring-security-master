package ASAC.Springmaster.domain.dto;

import lombok.*;

import java.util.List;
import java.util.Set;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String id;
    private String username;
    private String password;
    private int age;
    private List<String> roles;
}
