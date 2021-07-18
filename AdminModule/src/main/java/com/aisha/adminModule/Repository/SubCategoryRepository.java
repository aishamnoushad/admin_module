package com.aisha.adminModule.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.adminModule.Entity.SubCategory;
import com.aisha.adminModule.Entity.SubCategoryIdentity;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, SubCategoryIdentity>{

}
