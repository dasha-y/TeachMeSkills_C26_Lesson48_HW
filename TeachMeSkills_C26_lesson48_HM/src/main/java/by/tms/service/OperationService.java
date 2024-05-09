package by.tms.service;

import by.tms.dao.OperationDao;
import by.tms.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
    @Autowired
    private OperationDao operationDao;

    public Operation calculate(Operation operation){


        switch (operation.getOperationType()){
            case "+":

                 operation.setResult(operation.getNum1()+operation.getNum2());

                 return operation;
            case "-":

                operation.setResult(operation.getNum1()-operation.getNum2());

                return operation;
            case "*":

                operation.setResult(operation.getNum1()*operation.getNum2());

                return operation;
            case "/":

                 operation.setResult(operation.getNum1()/operation.getNum2());

                return operation;


        }

        throw  new IllegalArgumentException();
    }
}
