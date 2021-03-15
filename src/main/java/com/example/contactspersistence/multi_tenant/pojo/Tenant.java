package com.example.contactspersistence.multi_tenant.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tenant {
    @Id
    private String id;
    private String schema;

    public Tenant(String tenantId, String schema) {
        this.id = tenantId;
        this.schema = schema;
    }

    public Tenant() {

    }

    public String getId() {
        return id;
    }

    public void setId(String tenantId) {
        this.id = tenantId;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
