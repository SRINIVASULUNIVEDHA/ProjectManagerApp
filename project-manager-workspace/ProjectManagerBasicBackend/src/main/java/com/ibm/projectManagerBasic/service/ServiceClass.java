package com.ibm.projectManagerBasic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ibm.projectManagerBasic.entity.UserDetails;
import com.ibm.projectManagerBasic.repository.RepositoryInterface;

@Service
public class ServiceClass {

	@Autowired
	RepositoryInterface repo;
	
	public boolean addNewUser(UserDetails user) {
		boolean isPhoneNumUsed = false;
		List<String> listOfPhoneNum = repo.getAllPhoneNum();
		if(listOfPhoneNum.size() > 1) {
			for(String phoneNum: listOfPhoneNum) {
				if(phoneNum.equals(user.getUserPhoneNum())) {
					isPhoneNumUsed = true;
				}
			}
		}
		if(!isPhoneNumUsed) {
			repo.save(user);
		}
		return isPhoneNumUsed;
	}
	

	public void updateUserDetails(UserDetails user, Integer id) {
		repo.updateUserDetails(user.getUserName(), user.getUserPassword(), user.getUserDesignation(), id);
	}
	
	public void deleteUserById(Integer id) {
		repo.deleteById(id);
	}
}
   