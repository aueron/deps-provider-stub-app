package ru.sbt.platformv.deps.provider.stub.app.dto.rs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObjectVersion {
    private String objectLocalId;
    private String objectTypeId;
    private String version;
}
