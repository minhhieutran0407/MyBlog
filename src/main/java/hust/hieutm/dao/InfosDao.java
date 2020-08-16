package hust.hieutm.dao;

import hust.hieutm.model.Infos;

public interface InfosDao {
    public Infos getInfo();
    public int changeInfo(Infos infos);
}
