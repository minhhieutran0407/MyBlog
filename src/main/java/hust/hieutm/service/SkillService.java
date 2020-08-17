package hust.hieutm.service;

import hust.hieutm.dao.SkillDao;
import hust.hieutm.daoImpl.SkillDaoImpl;
import hust.hieutm.model.Skill;

import java.util.List;

public class SkillService {
    SkillDao skillDao = new SkillDaoImpl();

    public List<Skill> getAllSkill(){
        return skillDao.getAllSkill();
    }

    public void addSkill(Skill skill){
        skillDao.addSkill(skill);
    }

    public int updateSkill(Skill skill){
        return skillDao.updateSkill(skill);
    }
}
