package hust.hieutm.daoImpl;

import hust.hieutm.DBUtils.MySQLUtils;
import hust.hieutm.dao.ProductDao;
import hust.hieutm.model.Overview;
import hust.hieutm.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> getAllProduct() {
        List<Product> productList = new ArrayList<>();

        Connection connection = MySQLUtils.getConnection();
        String sql = "select * from product";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()){
                String name = rs.getString("name");
                String productType = rs.getString("product_type");
                Date date = rs.getDate("release_date");
                String image = rs.getString("image");
                Product product = new Product(name, productType, date, image);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            MySQLUtils.rollback(connection);
            throwables.printStackTrace();
        }
        MySQLUtils.closeConnection(connection);
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        Connection connection = MySQLUtils.getConnection();
        String sql = "insert into product(name, product_type, release_date, image) values (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setString(2, product.getProductType());
            ps.setDate(3, product.getReleaseDate());
            ps.setString(4, product.getImage());

            ps.execute();
        } catch (SQLException throwables) {
            MySQLUtils.rollback(connection);
            throwables.printStackTrace();
        }
        MySQLUtils.closeConnection(connection);
    }
}
