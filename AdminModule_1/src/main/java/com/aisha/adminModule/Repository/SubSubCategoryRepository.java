package com.aisha.adminModule.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.adminModule.Entity.SubSubCategory;
import com.aisha.adminModule.Entity.SubSubCategoryIdentity;
@Repository
public interface SubSubCategoryRepository extends JpaRepository<SubSubCategory, SubSubCategoryIdentity> {

}
