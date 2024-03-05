package ru.sbt.platformv.deps.provider.stub.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.sbt.platformv.deps.provider.stub.app.dto.rq.DependenciesFilter;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.Dependency;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.InformationSource;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.ObjectType;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.ObjectVersion;
import ru.sbt.platformv.deps.provider.stub.app.service.DependencyService;
import ru.sbt.platformv.deps.provider.stub.app.service.InformationSourceService;
import ru.sbt.platformv.deps.provider.stub.app.service.ObjectTypeService;
import ru.sbt.platformv.deps.provider.stub.app.service.ObjectVersionService;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DependencyController {

    private final DependencyService dependencyService;
    private final InformationSourceService informationSourceService;
    private final ObjectTypeService objectTypeService;
    private final ObjectVersionService objectVersionService;

    @QueryMapping("dependencies")
    public List<Dependency> dependencies(
            @Argument UUID after,
            @Argument DependenciesFilter filter,
            @Argument Integer first
    ) {
        // Реализация логики получения списка зависимостей,
        return dependencyService.getDependencies(after, filter, first);
    }

    @QueryMapping("informationSources")
    public List<InformationSource> informationSources() {
        // Реализация логики получения источников информации,
        return informationSourceService.getAllInformationSources();
    }

    @QueryMapping("objectTypes")
    public List<ObjectType> objectTypes() {
        // Реализация логики получения типов объектов,
        return objectTypeService.getAllObjectTypes();
    }

    @QueryMapping("srcObjectVersions")
    public List<String> srcObjectVersions(
            @Argument String objectLocalId,
            @Argument String objectTypeId)
    {
        // Реализация логики получения версий исходного объекта,
        return objectVersionService.getSrcObjectVersions(objectLocalId, objectTypeId);
    }
}
