package com.marketappbackend.domain.model.common;

import java.time.OffsetDateTime;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditEntityListener {
    @PrePersist
    public void prePersist(Object target) {
        if (target instanceof BaseEntity) {
            BaseEntity be = (BaseEntity) target;
            OffsetDateTime now = OffsetDateTime.now();
            be.getAudit().setCreatedAt(now);
            be.getAudit().setUpdatedAt(now);
            // set createdBy/updatedBy from SecurityContext in real impl
        }
    }

    @PreUpdate
    public void preUpdate(Object target) {
        if (target instanceof BaseEntity) {
            BaseEntity be = (BaseEntity) target;
            be.getAudit().setUpdatedAt(OffsetDateTime.now());
            // set updatedBy from SecurityContext
        }
    }
}