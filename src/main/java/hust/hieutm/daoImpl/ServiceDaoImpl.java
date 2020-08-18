package hust.hieutm.daoImpl;

import hust.hieutm.DBUtils.MySQLUtils;
import hust.hieutm.dao.ServiceDao;
import hust.hieutm.model.Product;
import hust.hieutm.model.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDaoImpl implements ServiceDao {
    @Override
    public List<Service> getAllService() {
        List<Service> serviceList = new ArrayList<>();

        Connection connection = MySQLUtils.getConnection();
        String sql = "select * from service";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()){
                String name = rs.getString("name");
                String description = rs.getString("description");
                Service service = new Service(name, description);

                serviceList.add(service);
            }
        } catch (SQLException throwables) {
            MySQLUtils.rollback(connection);
            throwables.printStackTrace();
        }
        MySQLUtils.closeConnection(connection);
        return serviceList;
    }

    @Override
    public int updateService(Service service) {

        int result = 0;
        Connection connection = MySQLUtils.getConnection();
        String sql = "update service set name = ?, description = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, service.getName());
            ps.setString(2, service.getDescription());

            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }
}
