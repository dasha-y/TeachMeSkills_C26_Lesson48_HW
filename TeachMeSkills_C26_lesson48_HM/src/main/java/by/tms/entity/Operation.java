package by.tms.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double num1;
    private double num2;
    private String operationType;
    private double result;

    @ToString.Exclude
    @ManyToOne
    private NewUser user;
}
