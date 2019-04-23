package com.cognizant.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.BranchAdminModel;
import com.cognizant.service.BranchAdminService;

@RestController
@RequestMapping("AdminController")
public class AdminController {
	
	@Autowired
	private BranchAdminService branchAdminService;
	
	@GetMapping("allbranchadmins")
	public ResponseEntity<List<BranchAdminModel>> getAllStudents(){
		List<BranchAdminModel> branchdmins=branchAdminService.getBranchAdminDetails();
		ResponseEntity<List<BranchAdminModel>> response=
				new ResponseEntity<List<BranchAdminModel>>(branchdmins,HttpStatus.OK);
		
		return response;
	}

}
