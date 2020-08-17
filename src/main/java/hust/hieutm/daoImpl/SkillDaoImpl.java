package hust.hieutm.daoImpl;

import hust.hieutm.DBUtils.MySQLUtils;
import hust.hieutm.dao.SkillDao;
import hust.hieutm.model.Skill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl implements SkillDao {
    @Override
    public List<Skill> getAllSkill() {
        List<Skill> skillList = new ArrayList<>();

        Connection connection = MySQLUtils.getConnection();
        String sql = "select * from skill";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString("name");
                String percent = rs.getString("percent");
                Skill skill = new Skill(name, percent);

                skillList.add(skill);
            }
        } catch (SQLException throwables) {
            MySQLUtils.rollback(connection);
            throwables.printStackTrace();
        }
        MySQLUtils.closeConnection(connection);
        return skillList;
    }

    @Override
    public void addSkill(Skill skill) {
        Connection connection = MySQLUtils.getConnection();
        String sql = "insert into skill(name, percent) values (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, skill.getName());
            ps.setString(2, skill.getPercent());
            ps.execute();
        } catch (SQLException throwables) {
            MySQLUtils.rollback(connection);
            throwables.printStackTrace();
        }

        MySQLUtils.closeConnection(connection);
    }

    @Override
    public int updateSkill(Skill skill) {
        int result = 0;
        
        Connection connection = MySQLUtils.getConnection();
        String sql = "update skill set name = ?, percent = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, skill.getName());
            ps.setString(2, skill.getPercent());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            MySQLUtils.rollback(connection);
            throwables.printStackTrace();
        }

        MySQLUtils.closeConnection(connection);

        return result;
    }
}
