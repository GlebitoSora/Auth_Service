package com.example.auth_service.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;
@Data
@Embeddable
public class ModularDiaryPK  implements Serializable {
    private long student;
    private long discipline;
}
