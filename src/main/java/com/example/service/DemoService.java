package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.AutoClaim;
import com.example.repository.AutoClaimRepository;



@Service
public class DemoService {

	@Autowired
	AutoClaimRepository claimRepository;

	public AutoClaim getlist(){
		return claimRepository.findOne(20174561L);
	}

	public  void  save(AutoClaim autoClaim){
		claimRepository.save(autoClaim);
	}


	public  boolean delete(Long id){
		AutoClaim claim = claimRepository.findOne(id);
		try{
			claimRepository.delete(claim);
			return true;
		}catch(Exception e){
			return false;
		}

	}

}
