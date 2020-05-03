package com.ibm.sba.service.impl;

import com.ibm.sba.domain.SkillsCriteria;
import com.ibm.sba.domain.TechnologiesCriteria;
import com.ibm.sba.service.MentorSkillsService;
import liquibase.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MentorSkillsServiceImpl implements MentorSkillsService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<SkillsCriteria> searchSkills() {
        Map<String, Object> params = new HashMap<>();
        StringBuffer sql = new StringBuffer();

        sql.append("select u.USER_NAME, t.TECH_NAME, t.TYPE, t.PRICE from users u, technologies t, mentor_skills ms where u.USER_ID = ms.USER_ID and t.TECH_ID = ms.TECH_ID order by TECH_NAME;");
        Query query = em.createNativeQuery(sql.toString());
        this.setParameters(query, params);
        List<Object[]> list = query.getResultList();
        return transformList(list);
    }

    private List<SkillsCriteria> transformList(List<Object[]> list){
        List<SkillsCriteria> skillsCriteriaList = new ArrayList<>();
        list.forEach(objects -> {
            SkillsCriteria skillsCriteria = new SkillsCriteria();
            String userName = StringUtils.isEmpty(String.valueOf(objects[0])) ? "" : String.valueOf(objects[0]);
            String techName = StringUtils.isEmpty(String.valueOf(objects[1])) ? "" : String.valueOf(objects[1]);
            String type = StringUtils.isEmpty(String.valueOf(objects[2])) ? "" : String.valueOf(objects[2]);
            int price = Integer.parseInt(StringUtils.isEmpty(String.valueOf(objects[3])) ? "" : String.valueOf(objects[3]));
            skillsCriteria.setTechName(techName);
            skillsCriteria.setUserName(userName);
            skillsCriteria.setPrice(price);
            skillsCriteria.setType(type);
            skillsCriteriaList.add(skillsCriteria);
        });
        return skillsCriteriaList;
    }

    private void setParameters(Query query, Map<String, Object> params) {
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
}
