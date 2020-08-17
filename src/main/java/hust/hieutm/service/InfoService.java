package hust.hieutm.service;

import hust.hieutm.dao.InfosDao;
import hust.hieutm.daoImpl.InfosDaoImpl;
import hust.hieutm.model.Infos;

public class InfoService {
    InfosDao infosDao = new InfosDaoImpl();

    public Infos getInfo(){
        return infosDao.getInfo();
    }

    public int updateInfo(Infos infos){
        return infosDao.changeInfo(infos);
    }
}
