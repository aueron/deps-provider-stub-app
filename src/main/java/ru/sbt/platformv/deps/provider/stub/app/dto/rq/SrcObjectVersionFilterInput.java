package ru.sbt.platformv.deps.provider.stub.app.dto.rq;

import lombok.Data;

import java.util.Optional;

@Data
public class SrcObjectVersionFilterInput {
    private Optional<String>  withSrcObjectLocalId;
    private Optional<String> withSrcObjectTypeId;
    private Optional<String> withSrcObjectVersion;
}
