package br.com.uri.SpringDemo.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class HelloEntity implements Serializable {

    @Id
    private Long id;

    @Column
    private String message;

}
