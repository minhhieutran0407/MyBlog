package hust.hieutm.dao;

import java.util.List;

public interface Skill {
    public List<Skill> getAllSkill();

    public void addSkill(Skill skill);

    public int updateSkill(Skill skill);
}
