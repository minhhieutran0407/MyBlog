package hust.hieutm.dao;

import hust.hieutm.model.Service;

import java.util.List;

public interface ServiceDao {
    public List<Service> getAllService();

    public int updateService(Service service);
}
