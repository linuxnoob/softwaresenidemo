package com.example.test.demo.SoftwareSeni.Controller;


import com.example.test.demo.SoftwareSeni.Entity.Transcation;
import com.example.test.demo.SoftwareSeni.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/getAlltransactions")
    public List<Transcation> findAllTranscations() {
        return transactionService.getAllTRX();
    }

    @GetMapping("/transaction/{id}")
    List<Map> findAllTranscationsById(@PathVariable Integer id) {
        List<Map> mapList = new ArrayList<>();
        List returnList = this.transactionService.getAllTRXByID(id);
        if(returnList !=null){
            Transcation transcation;
            for(int i = 0; i < returnList.size(); i++){
                Map resultMap = new HashMap();
                transcation =(Transcation) returnList.get(i);
                resultMap.put("amount", transcation.getAmount());
                resultMap.put("type", transcation.getType());
                resultMap.put("parent_id", transcation.getParent_id());
                mapList.add(resultMap);
            }
        }
        return mapList;
    }

    @GetMapping("/types/{type}")
    public List<Long> getListType(@PathVariable String type){
        return transactionService.getType(type);
    }

    @PostMapping("/saveTransaction")
    public Transcation saveTransaction(@RequestBody Transcation transcation){
        try {
            this.transactionService.saveTRX(transcation);
        }catch (Exception e){
            e.printStackTrace();
        }
        return transcation;
    }

    @PutMapping("/transaction/{id}")
    public Transcation updateProducts(@RequestBody Transcation transcation) {
        return transactionService.updateTransaction(transcation);
    }


    @GetMapping("/sum/{parent_id}")
    public Map sumAllTransaction(@PathVariable Long parent_id){
        Integer sum = this.transactionService.countTransactionByParentId(parent_id);
        Map map = new HashMap();
        map.put("sum", sum);

        return map;
    }



}
