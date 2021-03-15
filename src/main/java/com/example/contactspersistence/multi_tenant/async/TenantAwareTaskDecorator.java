package com.example.contactspersistence.multi_tenant.async;

import com.example.contactspersistence.multi_tenant.util.TenantContext;
import org.springframework.core.task.TaskDecorator;
import org.springframework.lang.NonNull;

public class TenantAwareTaskDecorator implements TaskDecorator {
    @Override
    @NonNull
    public Runnable decorate(@NonNull Runnable runnable) {
        String tenantId = TenantContext.getTenantId();

        return () -> {
            try {
                TenantContext.setTenant(tenantId);
                runnable.run();
            } finally {
                TenantContext.setTenant(null);
            }
        };
    }
}
