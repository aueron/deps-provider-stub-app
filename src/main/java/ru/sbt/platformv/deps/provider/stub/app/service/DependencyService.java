package ru.sbt.platformv.deps.provider.stub.app.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbt.platformv.deps.provider.stub.app.dto.rq.DependenciesFilter;
import ru.sbt.platformv.deps.provider.stub.app.dto.rq.DstObjectVersionFilterInput;
import ru.sbt.platformv.deps.provider.stub.app.dto.rq.SrcObjectVersionFilterInput;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.Dependency;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.ObjectVersion;
import ru.sbt.platformv.deps.provider.stub.app.util.InitDependency;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DependencyService {

    private final InitDependency initDependency;
    private List<Dependency> dependencyList;

    @PostConstruct
    public void init() {
        dependencyList = initDependency.getListDependency();
    }

    public List<Dependency> getFirstPageDependencies(DependenciesFilter filter, Integer first) {
        return null;
    }

    public List<Dependency> getNextPageDependencies(DependenciesFilter filter, Integer first, UUID after) {
        return null;
    }

    public List<Dependency> getPreviousPageDependencies(DependenciesFilter filter, Integer last, UUID before) {
        return null;
    }

    public List<Dependency> getDependencies(UUID after, DependenciesFilter filter, Integer first) {
        if (first == null) {
            first = 250;
        }

        Stream<Dependency> filteredDependencies = dependencyList.stream();

        // Фильтрация по версии объекта назначения
        if (filter.getDstObjectVersionFilter().isPresent()) {
            DstObjectVersionFilterInput dstFilter = filter.getDstObjectVersionFilter().get();
            filteredDependencies = filteredDependencies.filter(dep ->
                    (!dstFilter.getWithDstObjectLocalIdLike().isPresent() ||
                            dep.getDstObjectVersion().getObjectLocalId().contains(dstFilter.getWithDstObjectLocalIdLike().get())) &&
                            (!dstFilter.getWithDstObjectTypeId().isPresent() ||
                                    dep.getDstObjectVersion().getObjectTypeId().equals(dstFilter.getWithDstObjectTypeId().get())) &&
                            (!dstFilter.getWithDstObjectVersionLike().isPresent() ||
                                    dep.getDstObjectVersion().getVersion().contains(dstFilter.getWithDstObjectVersionLike().get()))
            );
        }

        // Фильтрация по наличию альтернатив
        if (filter.getHasAlternatives().isPresent()) {
            Boolean hasAlternatives = filter.getHasAlternatives().get();
            filteredDependencies = filteredDependencies.filter(dep ->
                    hasAlternatives.equals(dep.getNumberOfAlternatives() != null && dep.getNumberOfAlternatives() > 0)
            );
        }

        // Фильтрация по источникам информации
        if (!filter.getInformationSourcesIn().isEmpty()) {
            List<Integer> informationSources = filter.getInformationSourcesIn();
            filteredDependencies = filteredDependencies.filter(dep ->
                    informationSources.contains(dep.getInformationSourceId())
            );
        }

        // Фильтрация по наличию в обязательной группе
        if (filter.getIsInMandatoryGroup().isPresent()) {
            Boolean isInMandatoryGroup = filter.getIsInMandatoryGroup().get();
            filteredDependencies = filteredDependencies.filter(dep ->
                    isInMandatoryGroup.equals(dep.getInMandatoryGroup())
            );
        }

        // Фильтрация по версии объекта источника
        if (filter.getSrcObjectVersionFilter().isPresent()) {
            SrcObjectVersionFilterInput srcFilter = filter.getSrcObjectVersionFilter().get();
            filteredDependencies = filteredDependencies.filter(dep ->
                    (!srcFilter.getWithSrcObjectLocalId().isPresent() ||
                            dep.getSrcObjectVersion().getObjectLocalId().equals(srcFilter.getWithSrcObjectLocalId().get())) &&
                            (!srcFilter.getWithSrcObjectTypeId().isPresent() ||
                                    dep.getSrcObjectVersion().getObjectTypeId().equals(srcFilter.getWithSrcObjectTypeId().get())) &&
                            (!srcFilter.getWithSrcObjectVersion().isPresent() ||
                                    dep.getSrcObjectVersion().getVersion().equals(srcFilter.getWithSrcObjectVersion().get()))
            );
        }

        // Ограничение количества результатов, если необходимо
        return filteredDependencies.limit(first).collect(Collectors.toList());
    }

}
