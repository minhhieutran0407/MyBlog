package hust.hieutm.dao;

import hust.hieutm.model.Overview;

public interface OverviewDao {
    public Overview getOverview();

    public int updateOverview(Overview overview);
}
