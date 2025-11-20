package com.marketappbackend.domain.model.common;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.GeneratedValue;
@MappedSuperclass
@EntityListeners(AuditEntityListener.class) // implement to set audit timestamps
public abstract class BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Version
    @Column(name = "version")
    private Long version;

    @Embedded
    private AuditInfo audit = new AuditInfo();

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @Column(name = "deleted_at")
    private java.time.OffsetDateTime deletedAt;

    // getters/setters
}