package ru.sbt.platformv.deps.provider.stub.app.dto.rq;

import lombok.Data;

import java.util.Optional;

@Data
public class DstObjectVersionFilterInput {
    private Optional<String> withDstObjectLocalIdLike;
    private Optional<String> withDstObjectTypeId;
    private Optional<String> withDstObjectVersionLike;
}
