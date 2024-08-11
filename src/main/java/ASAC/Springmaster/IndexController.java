package ASAC.Springmaster;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String index(String customParam){
        if(customParam != null){
            return "customPage";
        } else {
            return "index";
        }
    }

    @GetMapping("/loginPage")
    public String loginPage(){
        return "loginPage";
    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/anonymous")
    public String anonymous(){
        return "anonymous";
    }

    @GetMapping("/authentication")
    public String authentication(Authentication authentication){
        if(authentication instanceof AnonymousAuthenticationToken){
            return "anonymous";
        } else {
            return "not anonymous";
        }
    }

    @GetMapping("/anonymousContext")
    public String anonymousContext(@CurrentSecurityContext SecurityContext context){     //null 이 아닌 실제 익명객체를 참조하고싶다
        return context.getAuthentication().getName();           // 익명객체의 이름을 리턴할수잇다.
    }

    @GetMapping("/logoutSuccess")
    public String logoutSuccess(){
        return "logoutSuccess";
    }
}
