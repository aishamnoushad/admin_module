package com.aisha.adminModule.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.adminModule.Entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

}
