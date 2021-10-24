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
@Table(name = "feature")
public class Feature {

  @Id private Integer id;

  // Add more fields

  @CreationTimestamp private LocalDateTime createdDatetime;

  @UpdateTimestamp private LocalDateTime updatedDatetime;
}
