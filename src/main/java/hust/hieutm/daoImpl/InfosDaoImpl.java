package hust.hieutm.daoImpl;

import hust.hieutm.DBUtils.MySQLUtils;
import hust.hieutm.dao.InfosDao;
import hust.hieutm.model.Infos;

import java.sql.*;

public class InfosDaoImpl implements InfosDao {
    @Override
    public Infos getInfo() {
        Infos infos = null;
        Connection connection = MySQLUtils.getConnection();
        String sql = "select * from infos where id = 1";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()){
                String name = rs.getString("name");
                String profile = rs.getString("my_profile");
                String avatar = rs.getString("avatar");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String about = rs.getString("about");
                String introTitle = rs.getString("introTitle");
                String introSubTitle = rs.getString("introSubtitle");
                infos = new Infos(name, profile, avatar, email, phone, about, introTitle, introSubTitle);
            }
        } catch (SQLException throwables) {
            MySQLUtils.rollback(connection);
            throwables.printStackTrace();
        }
        MySQLUtils.closeConnection(connection);
        return infos;
    }

    @Override
    public int changeInfo(Infos infos) {

        int result = 0;

        Connection connection = MySQLUtils.getConnection();
        String sql = "update infos set name = ?, avatar = ?, email = ?, phone = ?, about = ?, introTitle = ?, introSubtitle = ?, my_profile = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, infos.getName());
            ps.setString(2, infos.getAvatar());
            ps.setString(3, infos.getEmail());
            ps.setString(4, infos.getPhone());
            ps.setString(5, infos.getAbout());
            ps.setString(6, infos.getIntroTitle());
            ps.setString(7, infos.getIntroSubtitle());
            ps.setString(8, infos.getProfile());
            ps.setInt(9, infos.getId());

            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            MySQLUtils.rollback(connection);
            throwables.printStackTrace();
        }
        MySQLUtils.closeConnection(connection);

        return result;
    }
}
