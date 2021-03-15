package com.example.contactspersistence.multi_tenant.service;

import com.example.contactspersistence.multi_tenant.pojo.Tenant;
import org.springframework.data.repository.query.Param;

public interface TenantService {
    Tenant findByTenantId(@Param("tenantId") String tenantId);
}

