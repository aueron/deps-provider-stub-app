package ru.sbt.platformv.deps.provider.stub.app.dto.rs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InformationSource {
    private Integer id;
    private String name;
}
