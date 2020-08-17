package hust.hieutm.service;

import hust.hieutm.dao.BlogDao;
import hust.hieutm.daoImpl.BlogDaoImpl;
import hust.hieutm.model.Blog;

import java.util.List;

public class BlogService {
    BlogDao blogDao = new BlogDaoImpl();

    public List<Blog> getAllBlog(){
        return blogDao.getAllBlock();
    }

    public void addBlog(Blog blog){
        blogDao.addBlog(blog);
    }
}
