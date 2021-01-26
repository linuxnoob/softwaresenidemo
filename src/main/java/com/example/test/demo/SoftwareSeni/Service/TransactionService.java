package com.example.test.demo.SoftwareSeni.Service;

import com.example.test.demo.SoftwareSeni.Entity.Transcation;
import com.example.test.demo.SoftwareSeni.Repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService extends HibernateDaoSupport {

    @Autowired
    TransactionRepo transactionRepo;

    public Transcation saveTRX (Transcation transcation){
        return transactionRepo.save(transcation);

    }
    public List<Transcation> getAllTRX(){
        return transactionRepo.findAll();
    }

    public List<Transcation> getAllTRXByID(String id){
        return transactionRepo.findAllById(id);
    }

    public List<String> getType(String type){
        return transactionRepo.findTypeTransactionContaining(type);
    }
}
