package com.ibm.sba.service.impl;

import com.ibm.sba.domain.Technologies;
import com.ibm.sba.domain.TechnologiesCriteria;
import com.ibm.sba.repository.TechnologiesRepository;
import com.ibm.sba.service.TechnologiesService;
import liquibase.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TechnologiesServiceImpl implements TechnologiesService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private TechnologiesRepository technologiesRepository;

    @Override
    public List<TechnologiesCriteria> searchTrainings() {
        Map<String, Object> params = new HashMap<>();
        StringBuffer sql = new StringBuffer();

        sql.append("select TECH_NAME, USER_NAME, PRICE, LINKEDIN_URL, MENTOR_PROFILE, EXP_YEAR from technologies t, users u, mentor_skills ms where u.USER_ID = ms.USER_ID and t.TECH_ID = ms.TECH_ID order by TECH_NAME;");
        Query query = em.createNativeQuery(sql.toString());
        this.setParameters(query, params);
        List<Object[]> list = query.getResultList();
        return transformList(list);
    }

    @Override
    public List<Technologies> searchTechnologies() {
        List<Technologies> technologiesList = this.technologiesRepository.findAll();
        return technologiesList;
    }

    @Override
    public Technologies addTechnologies(Technologies technologies) {
        this.technologiesRepository.save(technologies);
        return technologies;
    }

    @Override
    public Technologies updateTechnologies(Technologies technologies) {
        Technologies technologiesNew = this.technologiesRepository.findById(technologies.getTechId()).orElse(null);
        technologiesNew.setTechName(technologies.getTechName());
        technologiesNew.setType(technologies.getType());
        technologiesNew.setPrice(technologies.getPrice());
        this.technologiesRepository.save(technologiesNew);
        return technologiesNew;
    }

    @Override
    public Technologies deleteTechnologies(int techId) {
        Technologies technologies = this.technologiesRepository.findById(techId).orElse(null);
        technologies.setActive(0);
        this.technologiesRepository.save(technologies);
        return technologies;
    }

    private List<TechnologiesCriteria> transformList(List<Object[]> list){
        List<TechnologiesCriteria> technologiesCriteriaList = new ArrayList<>();
        list.forEach(objects -> {
            TechnologiesCriteria technologiesCriteria = new TechnologiesCriteria();
            String techName = StringUtils.isEmpty(String.valueOf(objects[0])) ? "" : String.valueOf(objects[0]);
            String userName = StringUtils.isEmpty(String.valueOf(objects[1])) ? "" : String.valueOf(objects[1]);
            int price = Integer.parseInt(StringUtils.isEmpty(String.valueOf(objects[2])) ? "" : String.valueOf(objects[2]));
            String linkedinUrl = StringUtils.isEmpty(String.valueOf(objects[3])) ? "" : String.valueOf(objects[3]);
            String mentorProfile = StringUtils.isEmpty(String.valueOf(objects[4])) ? "" : String.valueOf(objects[4]);
            Integer expYear = Integer.valueOf(StringUtils.isEmpty(String.valueOf(objects[5])) ? "" : String.valueOf(objects[5]));
            technologiesCriteria.setTechName(techName);
            technologiesCriteria.setUserName(userName);
            technologiesCriteria.setPrice(price);
            technologiesCriteria.setLinkedinUrl(linkedinUrl);
            technologiesCriteria.setMentorProfile(mentorProfile);
            technologiesCriteria.setExpYear(expYear);
            technologiesCriteriaList.add(technologiesCriteria);
        });
        return technologiesCriteriaList;
    }

    private void setParameters(Query query, Map<String, Object> params) {
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
}
