package ru.sbt.platformv.deps.provider.stub.app.util;

import org.springframework.stereotype.Component;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.Dependency;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.ObjectVersion;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class InitDependency {

    public List<Dependency> getListDependency() {
        List<Dependency> dependencyList = new ArrayList<>();

        dependencyList.add(Dependency.builder()
                .cursor(UUID.randomUUID())
                .dstObjectVersion(ObjectVersion.builder()
                        .objectLocalId("1")
                        .version("1.0")
                        .objectTypeId("1000")
                        .build()
                )
                .inMandatoryGroup(true)
                .informationSourceId(1000)
                .numberOfAlternatives(0)
                .srcObjectVersion(ObjectVersion.builder()
                        .objectLocalId("2")
                        .version("1.0")
                        .objectTypeId("2000")
                        .build()
                )
                .build()
        );
        dependencyList.add(Dependency.builder()
                .cursor(UUID.randomUUID())
                .dstObjectVersion(ObjectVersion.builder()
                        .objectLocalId("3")
                        .version("2.0")
                        .objectTypeId("1000")
                        .build()
                )
                .inMandatoryGroup(true)
                .informationSourceId(1000)
                .numberOfAlternatives(0)
                .srcObjectVersion(ObjectVersion.builder()
                        .objectLocalId("4")
                        .version("2.0")
                        .objectTypeId("2000")
                        .build()
                )
                .build()
        );
        dependencyList.add(Dependency.builder()
                .cursor(UUID.randomUUID())
                .dstObjectVersion(ObjectVersion.builder()
                        .objectLocalId("5")
                        .version("3.0")
                        .objectTypeId("1000")
                        .build()
                )
                .inMandatoryGroup(true)
                .informationSourceId(1000)
                .numberOfAlternatives(0)
                .srcObjectVersion(ObjectVersion.builder()
                        .objectLocalId("6")
                        .version("3.0")
                        .objectTypeId("2000")
                        .build()
                )
                .build()
        );
        return dependencyList;
    }
}
