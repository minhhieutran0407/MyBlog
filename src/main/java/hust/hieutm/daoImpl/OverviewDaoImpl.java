package hust.hieutm.daoImpl;

import hust.hieutm.DBUtils.MySQLUtils;
import hust.hieutm.dao.OverviewDao;
import hust.hieutm.model.Infos;
import hust.hieutm.model.Overview;
import sun.awt.OverrideNativeWindowHandle;

import java.sql.*;

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
                overview = new Overview(worldsComplete, experience, totalClients, awardWon);
            }
        } catch (SQLException throwables) {
            MySQLUtils.rollback(connection);
            throwables.printStackTrace();
        }
        MySQLUtils.closeConnection(connection);
        return overview;
    }

    @Override
    public int updateOverview(Overview overview) {

        int result = 0;
        Connection connection = MySQLUtils.getConnection();
        String sql = "update overview set worlds_complete = ?, experience = ?, total_clients = ?, award_won = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, overview.getWorldsComplete());
            ps.setInt(2, overview.getExperience());
            ps.setInt(3, overview.getTotalClients());
            ps.setInt(4, overview.getAwardWon());

            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            MySQLUtils.rollback(connection);
            throwables.printStackTrace();
        }
        MySQLUtils.closeConnection(connection);

        return result;
    }
}
