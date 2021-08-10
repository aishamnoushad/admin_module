package com.aisha.adminModule.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.adminModule.Entity.WhatsappClickClass;
@Repository
public interface whatsappClickRepository extends JpaRepository<WhatsappClickClass, Integer> {

	
		
}
