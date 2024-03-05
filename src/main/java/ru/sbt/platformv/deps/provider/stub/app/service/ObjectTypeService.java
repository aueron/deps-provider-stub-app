package ru.sbt.platformv.deps.provider.stub.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.InformationSource;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.ObjectType;
import ru.sbt.platformv.deps.provider.stub.app.util.InitObjectType;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ObjectTypeService {

    private final InitObjectType initObjectType;
    private List<ObjectType> objectTypeList;

    @PostConstruct
    public void init() {
        objectTypeList = initObjectType.init();
    }

    public List<ObjectType> getAllObjectTypes() {
        return objectTypeList;
    }
}
