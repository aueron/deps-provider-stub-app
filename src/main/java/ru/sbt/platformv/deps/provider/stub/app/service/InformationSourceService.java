package ru.sbt.platformv.deps.provider.stub.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbt.platformv.deps.provider.stub.app.dto.rs.InformationSource;
import ru.sbt.platformv.deps.provider.stub.app.util.InitInformationSource;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InformationSourceService {

    private final InitInformationSource initInformationSource;
    private List<InformationSource> informationSourceList;

    @PostConstruct
    public void init() {
        informationSourceList = initInformationSource.init();
    }

    public List<InformationSource> getAllInformationSources() {
        return informationSourceList;
    }
}
