package ru.sbt.platformv.deps.provider.stub.app.dto.rq;

import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class DependenciesFilter {
    private Optional<DstObjectVersionFilterInput> dstObjectVersionFilter;
    private Optional<Boolean> hasAlternatives;
    private List<Integer> informationSourcesIn;
    private Optional<Boolean> isInMandatoryGroup;
    private Optional<SrcObjectVersionFilterInput> srcObjectVersionFilter;
}
