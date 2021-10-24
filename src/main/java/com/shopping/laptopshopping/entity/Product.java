package com.shopping.laptopshopping.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

  @Id private Integer id;

  private String name;

  private String price;

  private String description;

  private String dimensions;

  private String url;

  private Integer expectedDeliveryDays;

  private String warranty;

  @CreationTimestamp private LocalDateTime createdDatetime;

  @UpdateTimestamp private LocalDateTime updatedDatetime;
}
