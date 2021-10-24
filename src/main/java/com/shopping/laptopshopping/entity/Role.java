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
@Table(name = "role")
public class Role {

  @Id private Integer id;

  private String type;

  @CreationTimestamp private LocalDateTime createdDatetime;

  @UpdateTimestamp private LocalDateTime updatedDatetime;
}
