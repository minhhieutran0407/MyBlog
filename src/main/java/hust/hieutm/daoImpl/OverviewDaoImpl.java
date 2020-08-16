package hust.hieutm.daoImpl;

import hust.hieutm.DBUtils.MySQLUtils;
import hust.hieutm.dao.OverviewDao;
import hust.hieutm.model.Infos;
import hust.hieutm.model.Overview;
import sun.awt.OverrideNativeWindowHandle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OverviewDaoImpl implements OverviewDao {
    @Override
    public Overview getOverview() {
        Overview overview = null;
        Connection connection = MySQLUtils.getConnection();
        String sql = "select * from overview where id = 1";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()){
                int worldsComplete = rs.getInt("worlds_complete");
                int experience = rs.getInt("experience");
                int totalClients = rs.getInt("total_clients");
                int awardWon = rs.getInt("award_won");
            }
        } catch (SQLException throwables) {
            MySQLUtils.rollback(connection);
            throwables.printStackTrace();
        }
        MySQLUtils.closeConnection(connection);
        return overview;
    }

    @Override
    public int updateOverview() {
        return 0;
    }
}
