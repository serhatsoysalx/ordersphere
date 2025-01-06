package com.ordersphere.ordersphere.entity;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "status")
    private Boolean status;

    @PrePersist
    public void prePersist() {
        if (this.status == null) {
            this.status = Boolean.TRUE;
        }
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

