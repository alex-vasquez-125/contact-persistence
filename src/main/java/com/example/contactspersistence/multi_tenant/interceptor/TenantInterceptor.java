package com.example.contactspersistence.multi_tenant.interceptor;

import com.example.contactspersistence.multi_tenant.util.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

@Component
public class TenantInterceptor implements WebRequestInterceptor {
    private final String defaultTenant;

    @Autowired
    public TenantInterceptor(@Value("${multitenancy.tenant.default-tenant:#{null}}") String defaultTenant) {
        this.defaultTenant = defaultTenant;
    }

    @Override
    public void preHandle(WebRequest webRequest) throws Exception {
        String tenantId;

        if (webRequest.getHeader("X-TENANT-ID") != null) {
            tenantId = webRequest.getHeader("X-TENANT-ID");
        } else if (this.defaultTenant != null) {
            tenantId = this.defaultTenant;
        } else {
            tenantId = null;
        }

        TenantContext.setTenant(tenantId);
    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {
        TenantContext.clear();
    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {
        // noop
    }
}
