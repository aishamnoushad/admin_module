package com.aisha.adminModule.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.adminModule.Entity.WhatsappClickClass;
import com.aisha.adminModule.Repository.whatsappClickRepository;

@Service
public class GenericService {
	@Autowired
	private whatsappClickRepository whatsappRepository;
	
	
	public List<WhatsappClickClass> getAllWhatsappClicks(){
		return whatsappRepository.findAll();
	}
	
//	public List<WhatsappClickClass> getAllDates(){
//		return whatsappRepository.findAllByClickdate();
//	}
}
