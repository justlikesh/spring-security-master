package ASAC.Springmaster.security.service;


import ASAC.Springmaster.security.mapper.UrlRoleMapper;

import java.util.Map;
public class DynamicAuthorizationService {
    private final UrlRoleMapper delegate;
    public DynamicAuthorizationService(UrlRoleMapper delegate) {
        this.delegate = delegate;
    }
    public Map<String, String> getUrlRoleMappings() {
            return delegate.getUrlRoleMappings();
    }
}
