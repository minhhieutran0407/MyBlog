package hust.hieutm.daoImpl;

import hust.hieutm.DBUtils.MySQLUtils;
import hust.hieutm.dao.BlogDao;
import hust.hieutm.model.Blog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDaoImpl implements BlogDao {
    @Override
    public List<Blog> getAllBlog(){
        List<Blog> blogs = new ArrayList<>();

        Connection connection = MySQLUtils.getConnection();
        String sql = "select * from blog";
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString("name");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String type = rs.getString("type");
                String description = rs.getString("description");
                String content = rs.getString("content");
                Date date = rs.getDate("create_date");
                Blog blog = new Blog(name, title, author, type, description, content, date);
                blogs.add(blog);
            }
        } catch (SQLException e){
            MySQLUtils.rollback(connection);
        }
        MySQLUtils.closeConnection(connection);
        return  blogs;
    }

    @Override
    public void addBlog(Blog blog){
        Connection connection = MySQLUtils.getConnection();
        String sql = "insert into blog(name, title, author, type, description, content, create date) values(?, ? , ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, blog.getName());
            ps.setString(2, blog.getTitle());
            ps.setString(3, blog.getAuthor());
            ps.setString(4, blog.getType());
            ps.setString(5, blog.getDescription());
            ps.setString(6, blog.getContent());
            ps.setDate(7, blog.getDate());
        } catch (SQLException throwables) {
            MySQLUtils.rollback(connection);
            throwables.printStackTrace();
        }
        MySQLUtils.closeConnection(connection);
    }
}
