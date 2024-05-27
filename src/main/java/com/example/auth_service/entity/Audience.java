package com.example.auth_service.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "audience")
@Schema(name = "Аудитория")
public class Audience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audience_id")
    private long id;
    @Column(name = "audience_number")
    private int audienceNumber;
    @Column(name = "building")
    @Enumerated(EnumType.STRING)
    private Building building;
}
