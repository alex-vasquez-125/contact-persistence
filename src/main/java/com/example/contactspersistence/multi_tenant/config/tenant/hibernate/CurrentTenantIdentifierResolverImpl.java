package com.example.contactspersistence.multi_tenant.config.tenant.hibernate;

import com.example.contactspersistence.multi_tenant.util.TenantContext;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component("currentTenantIdentifierResolver")
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenantId = TenantContext.getTenantId();

        if (tenantId != null) {
            return tenantId;
        } else {
            return "public";
        }
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
