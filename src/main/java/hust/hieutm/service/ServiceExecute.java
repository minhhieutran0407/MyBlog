package hust.hieutm.service;

import hust.hieutm.dao.ServiceDao;
import hust.hieutm.daoImpl.ServiceDaoImpl;
import hust.hieutm.model.Service;

import java.util.List;

public class ServiceExecute {
    ServiceDao serviceDao = new ServiceDaoImpl();

    public List<Service> getAllService(){
        return serviceDao.getAllService();
    }

    public int updateService(Service service){
        return serviceDao.updateService(service);
    }
}
