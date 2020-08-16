package hust.hieutm.dao;

import hust.hieutm.model.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getAllProduct();

    public void addProduct(Product product);
}
