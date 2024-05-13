package com.example.auth_service.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "modular_diary")
public class ModularDiary {
    @EmbeddedId
    private ModularDiaryPK modularDiaryPK;

}
