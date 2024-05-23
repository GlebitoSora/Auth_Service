package com.example.auth_service.dto;

import com.example.auth_service.entity.ModularDiaryPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModularDiaryDto {
    private int firstModule;
    private int secondModule;
    private int exam;
    private String studentName;
    private String group;
    private String disciplineName;

}
