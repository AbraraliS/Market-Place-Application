package com.marketappbackend.domain.model.common;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.OffsetDateTime;

@Embeddable
public class AuditInfo {
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "created_by", nullable = true, updatable = false)
    private String createdBy;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @Column(name = "updated_by", nullable = true)
    private String updatedBy;

    // constructors, getters, setters
}