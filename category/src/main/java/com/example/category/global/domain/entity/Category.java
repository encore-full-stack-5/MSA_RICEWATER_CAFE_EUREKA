package com.example.category.global.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CAFE_CATEGORIES"
//        ,indexes = {@Index(columnList = "CATEGORY_ID")}
)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long id;
    @Column(name = "CATEGORY_NAME")
    @Setter
    private String name;
    @Column(name = "IS_DELETE")
    @Setter
    private Boolean isDelete;
    @Column(name = "CAFE_ID")
    private Long cafeId;
}