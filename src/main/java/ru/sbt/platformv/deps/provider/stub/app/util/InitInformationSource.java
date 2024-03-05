package ru.sbt.platformv.deps.provider.stub.app.util;

import org.springframework.stereotype.Component;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.InformationSource;

import java.util.List;

@Component
public class InitInformationSource {

    public List<InformationSource> init() {
        return List.of(
                InformationSource.builder()
                        .id(1)
                        .name("SBOM")
                        .build(),
                InformationSource.builder()
                        .id(2)
                        .name("RQSW")
                        .build()
        );
    }
}
