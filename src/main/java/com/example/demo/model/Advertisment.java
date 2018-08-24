package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "advertisment")
public class Advertisment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private int price;
    @Column
    private Date date;
    @ManyToOne
    private Category category;
    @Column(name = "pic_url")
    private String picUrl;
}
