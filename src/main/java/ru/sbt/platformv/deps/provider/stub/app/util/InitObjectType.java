package ru.sbt.platformv.deps.provider.stub.app.util;

import org.springframework.stereotype.Component;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.Object;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.ObjectType;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class InitObjectType {

    public List<ObjectType> init() {
        return List.of(
                ObjectType.builder()
                        .id("prod:int")
                        .name("Внутренний продукт")
                        .canBeSrcObject(true)
                        .objectDictionary(List.of(
                                Object.builder()
                                        .localId("pvm")
                                        .name("Platform V Monitor")
                                        .build(),
                                Object.builder()
                                        .localId("iam")
                                        .name("Platform V IAM")
                                        .build())
                        )
                        .build(),
                ObjectType.builder()
                        .id("prod:ext")
                        .name("Внешний продукт")
                        .canBeSrcObject(false)
                        .objectDictionary(List.of(
                                Object.builder()
                                        .localId("postgresql")
                                        .name("PostgreSQL")
                                        .build())
                        )
                        .build(),
                ObjectType.builder()
                        .id("prod:maven")
                        .name("Пакет maven")
                        .canBeSrcObject(false)
                        .objectDictionary(Collections.emptyList())
                        .build()
        );
    }
}
