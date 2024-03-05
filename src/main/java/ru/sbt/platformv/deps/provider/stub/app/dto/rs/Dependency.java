package ru.sbt.platformv.deps.provider.stub.app.dto.rs;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Dependency {
    private UUID cursor;
    private ObjectVersion dstObjectVersion;
    private Boolean inMandatoryGroup;
    private Integer informationSourceId;
    private Integer numberOfAlternatives;
    private ObjectVersion srcObjectVersion;
}
