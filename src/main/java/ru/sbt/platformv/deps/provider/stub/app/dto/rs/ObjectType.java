package ru.sbt.platformv.deps.provider.stub.app.dto.rs;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ObjectType {
    private Boolean canBeSrcObject;
    private String id;
    private String name;
    private List<Object> objectDictionary;
}
