package ru.sbt.platformv.deps.provider.stub.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.ObjectVersion;
import ru.sbt.platformv.deps.provider.stub.app.util.InitObjectVersion;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObjectVersionService {
    private final InitObjectVersion initObjectVersion;
    private List<ObjectVersion> objectVersionList;

    @PostConstruct
    public void init() {
        objectVersionList = initObjectVersion.init();
    }

    public List<String> getSrcObjectVersions(String objectLocalId, String objectTypeId) {
        return objectVersionList.stream()
                .filter(e -> e.getObjectLocalId().equals(objectLocalId) && e.getObjectTypeId().equals(objectTypeId))
                .map(ObjectVersion::getVersion)
                .collect(Collectors.toList());
    }
}
