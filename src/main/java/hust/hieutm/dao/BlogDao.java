package hust.hieutm.dao;

import hust.hieutm.DBUtils.MySQLUtils;
import hust.hieutm.model.Blog;

import java.sql.*;
import java.util.List;

public interface BlogDao {
    public List<Blog> getAllBlock();

    public void addBlog(Blog blog);
}
