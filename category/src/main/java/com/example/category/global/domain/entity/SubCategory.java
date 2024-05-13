package com.example.category.global.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CAFE_SUB_CATEGORIES"
//        ,indexes = {@Index(columnList = "SUB_CATEGORY_ID")}
)
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUB_CATEGORY_ID")
    private Long id;
    @Column(name = "SUB_CATEGORY_NAME")
    @Setter
    private String name;
    @Column(name = "IS_DELETE")
    @Setter
    private Boolean isDelete;
    @Column(name = "CATEGORY_ID")
    private Long categoryId;
}