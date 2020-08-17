package hust.hieutm.service;

import hust.hieutm.dao.OverviewDao;
import hust.hieutm.daoImpl.OverviewDaoImpl;
import hust.hieutm.model.Overview;

public class OverviewSerivce {
    OverviewDao overviewDao = new OverviewDaoImpl();

    public Overview getOverview(){
        return overviewDao.getOverview();
    }

    public int updateOverview(Overview overview){
        return overviewDao.updateOverview(overview);
    }

}
