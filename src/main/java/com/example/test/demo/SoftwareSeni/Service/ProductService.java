package com.example.test.demo.SoftwareSeni.Service;

import com.example.test.demo.SoftwareSeni.Entity.Products;
import com.example.test.demo.SoftwareSeni.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Products saveProducts (Products products){
        return  productRepo.save(products);

    }
    public List<Products> getAllTRX(){
        return productRepo.findAll();
    }

    public List<Products> getAllTRXByID(Integer Id){

        return productRepo.findAllById(Id);
    }

    public List<Products> getByName(String name){
        return productRepo.findTypeProductsContaining(name);
    }

    public Products updateProducts(Products products) {
        Products products1 = productRepo.findById(products.getId()).orElse(null);
        products1.setId(products.getId());
        products1.setName(products.getName());
        products1.setDescription(products.getDescription());
        products1.setPrice(products.getPrice());
        products1.setCategory_id(products.getCategory_id());
        products1.setModified(products.getModified());
        products1.setCreated(products.getCreated());
        return productRepo.save(products1);
    }

    public Integer countProductByCategoryId(Integer category_id){

        Integer totalSum = 0;
        try {
            List<Products> productsList = this.productRepo.findByProductsByCategorytId(category_id);
            Products products;
            if(productsList.size()>0){
                for (int i = 0; i< productsList.size(); i ++){
                    products =(Products) productsList.get(i);
                    Integer sum = products.getPrice().intValue();
                    totalSum += sum;
                }
            }
            System.out.println("totalSum = " + totalSum);
        }catch (Exception e){
            e.printStackTrace();
        }

        return totalSum;
    }
}
