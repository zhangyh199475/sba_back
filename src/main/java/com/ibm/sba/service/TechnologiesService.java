package com.ibm.sba.service;

import com.ibm.sba.domain.Technologies;
import com.ibm.sba.domain.TechnologiesCriteria;

import java.util.List;

public interface TechnologiesService {
    List<TechnologiesCriteria> searchTrainings();

    List<Technologies> searchTechnologies();

}
