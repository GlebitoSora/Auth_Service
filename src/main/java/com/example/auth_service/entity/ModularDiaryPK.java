package com.example.auth_service.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Builder
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ModularDiaryPK  implements Serializable {
    private long student;
    private long discipline;

}
