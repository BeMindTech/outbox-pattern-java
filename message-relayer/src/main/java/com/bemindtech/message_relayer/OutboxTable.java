package com.bemindtech.message_relayer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "outbox")
@Data
@ToString
public class OutboxTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_to_integrate", nullable = false)
    private String dataToIntegrate;

    @Enumerated(EnumType.STRING)
    private Integrated integrated;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Builder
    public OutboxTable(String dataToIntegrate) {
        this.dataToIntegrate = dataToIntegrate;
        integrated = Integrated.N;
    }

    public OutboxTable() {
        integrated = Integrated.N;
    }
}
