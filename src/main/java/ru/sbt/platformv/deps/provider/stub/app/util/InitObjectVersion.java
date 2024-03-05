package ru.sbt.platformv.deps.provider.stub.app.util;

import org.springframework.stereotype.Component;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.ObjectVersion;

import java.util.List;

@Component
public class InitObjectVersion {

    public List<ObjectVersion> init() {
        return List.of(
                ObjectVersion.builder()
                        .objectLocalId("1")
                        .version("1.0")
                        .objectTypeId("prod:int")
                        .build(),
                ObjectVersion.builder()
                        .objectLocalId("2")
                        .version("1.1")
                        .version("prod:int")
                        .build(),
                ObjectVersion.builder()
                        .objectLocalId("3")
                        .version("1.2.1")
                        .objectTypeId("prod:ext")
                        .build(),
                ObjectVersion.builder()
                        .objectLocalId("4")
                        .version("2.0.1")
                        .objectTypeId("prod:ext")
                        .build(),
                ObjectVersion.builder()
                        .objectLocalId("5")
                        .version("1.0")
                        .objectTypeId("prod:maven")
                        .build()
        );
    }
}
