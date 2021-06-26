package com.example.test.demo.SoftwareSeni.Service;

import com.example.test.demo.SoftwareSeni.Entity.Product;
import com.example.test.demo.SoftwareSeni.Entity.Product;
import com.example.test.demo.SoftwareSeni.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Product saveProduct (Product product){
        return  productRepo.save(product);

    }
    public List<Product> getAllTRX(){
        return productRepo.findAll();
    }

    public List<Product> getAllTRXByID(Integer Id){

        return productRepo.findAllById(Id);
    }

    public List<Product> getByName(String name){
        return productRepo.findTypeProductContaining(name);
    }

    public Product updateProduct(Product product) {
        Product product1 = productRepo.findById(product.getId()).orElse(null);
        product1.setId(product.getId());
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());
        product1.setCategory_id(product.getCategory_id());
        product1.setModified(product.getModified());
        product1.setCreated(product.getCreated());
        return productRepo.save(product1);
    }

    public Integer countTransactionByParentId(Integer category_id){

        Integer totalSum = 0;
        try {
            List<Product> productList = this.productRepo.findByProductByCategorytId(category_id);
            Product product ;
            if(productList.size()>0){
                for (int i=0; i<productList.size();i ++){
                    product =(Product) productList.get(i);
                    Integer sum = product.getPrice().intValue();
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
