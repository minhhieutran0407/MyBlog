package hust.hieutm.dao;

import hust.hieutm.model.Skill;

import java.util.List;

public interface SkillDao {
    public List<Skill> getAllSkill();

    public void addSkill(Skill skill);

    public int updateSkill(Skill skill);
}
