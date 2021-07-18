package com.aisha.adminModule.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.adminModule.Entity.Categories;
@Repository
public interface CategoryRepository extends JpaRepository<Categories, String>{

}
