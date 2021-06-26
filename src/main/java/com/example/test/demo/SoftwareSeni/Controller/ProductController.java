package com.example.test.demo.SoftwareSeni.Controller;


import com.example.test.demo.SoftwareSeni.Entity.Products;
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

    @GetMapping("/getAllProducts")
    public List<Products> findAllProducts() {
        return productService.getAllTRX();
    }

    @GetMapping("/product/{id}")
    List<Map> findAllProductsById(@PathVariable Integer id) {
        List<Map> mapList = new ArrayList<>();
        List returnList = this.productService.getAllTRXByID(id);
        if(returnList !=null){
            Products products;
            for(int i = 0; i < returnList.size(); i++){
                Map resultMap = new HashMap();
                products =(Products) returnList.get(i);
                resultMap.put("price", products.getPrice());
                resultMap.put("name", products.getName());
                resultMap.put("description", products.getDescription());
                mapList.add(resultMap);
            }
        }
        return mapList;
    }

    @GetMapping("/name/{name}")
    public List<Products> getListName(@PathVariable String name){
        return productService.getByName(name);
    }

    @PostMapping("/saveProducts")
    public Products saveProducts(@RequestBody Products products){
        try {
            this.productService.saveProducts(products);
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    @PutMapping("/product/{id}")
    public Products updateProducts(@RequestBody Products products) {
        return productService.updateProducts(products);
    }


    @GetMapping("/sumProduct/{category_id}")
    public Map sumProductsByCategory(@PathVariable Integer category_id){
        Integer sum = this.productService.countProductByCategoryId(category_id);
        Map map = new HashMap();
        map.put("totalProduct", sum);

        return map;
    }

    @PostMapping("/detailProducts/{name}")
    public List<Map> saveProducts(@PathVariable String name){
        List<Map> detailList = null;
        try {
            detailList =this.productService.showDetailProduct(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return detailList;
    }




}
