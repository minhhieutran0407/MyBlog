package hust.hieutm;

import hust.hieutm.dao.BlogDao;
import hust.hieutm.daoImpl.BlogDaoImpl;
import hust.hieutm.model.Blog;

import java.sql.SQLException;
import java.util.List;

public class test {
    public static void main(String... args) throws SQLException {
        BlogDao blogDao = new BlogDaoImpl();
        List<Blog> blogs = blogDao.getAllBlock();
        System.out.println(blogs);
    }
}
