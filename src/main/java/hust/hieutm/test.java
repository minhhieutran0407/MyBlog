package hust.hieutm;

import hust.hieutm.dao.BlogDao;
import hust.hieutm.dao.InfosDao;
import hust.hieutm.dao.OverviewDao;
import hust.hieutm.daoImpl.BlogDaoImpl;
import hust.hieutm.daoImpl.InfosDaoImpl;
import hust.hieutm.daoImpl.OverviewDaoImpl;
import hust.hieutm.model.Blog;
import hust.hieutm.model.Infos;
import hust.hieutm.model.Overview;

import java.sql.SQLException;
import java.util.List;

public class test {
    public static void main(String... args) throws SQLException {
//        BlogDao blogDao = new BlogDaoImpl();
//        List<Blog> blogs = blogDao.getAllBlock();
//        System.out.println(blogs);

//        InfosDao infosDao = new InfosDaoImpl();
//        Infos infos = infosDao.getInfo();
//        System.out.println(infos);

        OverviewDao overviewDao = new OverviewDaoImpl();
        Overview overview = overviewDao.getOverview();
        System.out.println(overview);
    }
}
