package com.example.test.demo.SoftwareSeni.Service;

import com.example.test.demo.SoftwareSeni.Entity.Transcation;
import com.example.test.demo.SoftwareSeni.Repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService  {

    @Autowired
    TransactionRepo transactionRepo;

    public Transcation saveTRX (Transcation transcation){
        return transactionRepo.save(transcation);

    }
    public List<Transcation> getAllTRX(){
        return transactionRepo.findAll();
    }

    public List<Transcation> getAllTRXByID(Integer Id){

        return transactionRepo.findAllById(Id);
    }

    public List<Long> getType(String type){
        return transactionRepo.findTypeTransactionContaining(type);
    }

    public Transcation updateTransaction(Transcation transcation) {
        Transcation existTrans = transactionRepo.findById(transcation.getId()).orElse(null);
        existTrans.setAmount(transcation.getAmount());
        existTrans.setParent_id(transcation.getParent_id());
        existTrans.setType(transcation.getType());
        return transactionRepo.save(existTrans);
    }

    public Integer countTransactionByParentId(Long parent_id){

        Integer totalSum = 0;
        try {
            List<Transcation> transcationList = this.transactionRepo.findByTransactionByParentId(parent_id);
            Transcation transcation ;
            if(transcationList.size()>0){
                for (int i=0; i<transcationList.size();i ++){
                    transcation =(Transcation) transcationList.get(i);
                    Integer sum = transcation.getAmount().intValue();
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
