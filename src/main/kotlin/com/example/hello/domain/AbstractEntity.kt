package com.example.hello.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.ZonedDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class AbstractEntity {
    @CreationTimestamp
    private lateinit var createdAt: ZonedDateTime

    @UpdateTimestamp
    private lateinit var updatedAt: ZonedDateTime

}