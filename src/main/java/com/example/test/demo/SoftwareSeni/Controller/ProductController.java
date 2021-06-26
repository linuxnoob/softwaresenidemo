package com.example.test.demo.SoftwareSeni.Controller;


import com.example.test.demo.SoftwareSeni.Entity.Product;
import com.example.test.demo.SoftwareSeni.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAlltransactions")
    public List<Product> findAllProducts() {
        return productService.getAllTRX();
    }

    @GetMapping("/transaction/{id}")
    List<Map> findAllProductsById(@PathVariable Integer id) {
        List<Map> mapList = new ArrayList<>();
        List returnList = this.productService.getAllTRXByID(id);
        if(returnList !=null){
            Product product;
            for(int i = 0; i < returnList.size(); i++){
                Map resultMap = new HashMap();
                product =(Product) returnList.get(i);
                resultMap.put("price", product.getPrice());
                resultMap.put("name", product.getName());
                resultMap.put("description", product.getDescription());
                mapList.add(resultMap);
            }
        }
        return mapList;
    }

    @GetMapping("/name/{name}")
    public List<Product> getListName(@PathVariable String name){
        return productService.getByName(name);
    }

    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody Product product){
        try {
            this.productService.saveProduct(product);
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    @PutMapping("/transaction/{id}")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }


    @GetMapping("/sum/{category_id}")
    public Map sumProductByCategory(@PathVariable Integer parent_id){
        Integer sum = this.productService.countTransactionByParentId(parent_id);
        Map map = new HashMap();
        map.put("sum", sum);

        return map;
    }



}
