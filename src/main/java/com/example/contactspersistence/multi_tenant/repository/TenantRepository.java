package com.example.contactspersistence.multi_tenant.repository;

import com.example.contactspersistence.multi_tenant.pojo.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TenantRepository extends JpaRepository<Tenant, String> {
    @Query("select t from Tenant t where t.id = :tenantId")
    Optional<Tenant> findByTenantId(@Param("tenantId") String tenantId);
}
