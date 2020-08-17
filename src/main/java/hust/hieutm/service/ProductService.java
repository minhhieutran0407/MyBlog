package hust.hieutm.service;

import hust.hieutm.dao.ProductDao;
import hust.hieutm.daoImpl.ProductDaoImpl;
import hust.hieutm.model.Product;

import java.util.List;

public class ProductService {
    ProductDao productDao = new ProductDaoImpl();

    public List<Product> getAllProduct(){
        return productDao.getAllProduct();
    }
}
