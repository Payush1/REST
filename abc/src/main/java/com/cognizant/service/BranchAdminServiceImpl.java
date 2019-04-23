package com.cognizant.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cognizant.dao.BranchAdminDAO;
import com.cognizant.entity.BranchAdmin;

import com.cognizant.model.BranchAdminModel;


@Service
public class BranchAdminServiceImpl implements BranchAdminService{

	@Autowired
	private BranchAdminDAO branchAdminDAO;
	@Autowired
	private BranchAdminModel branchAdminModel;
	private static Logger logger=LoggerFactory.getLogger(BranchAdminServiceImpl.class);
	public boolean insertBranchAdminDetails(BranchAdminModel branchAdmin) {
		// TODO Auto-generated method stub
				logger.info("----------INSERT BRANCHADMIN SERVICE---------------");
		BranchAdmin branchAdminObj=branchAdminModel.branchAdminModelToEntity(branchAdmin);
		
		return branchAdminDAO.insertBranchAdmin(branchAdminObj);
	}

	public List<BranchAdminModel> getBranchAdminDetails() {
		// TODO Auto-generated method stub
		logger.info("----------GET ALL BRANCHADMIN SERVICE---------------");
		List<BranchAdmin> branchAdminList=branchAdminDAO.getBranchAdmin();
		
		List <BranchAdminModel> BranchAdminModel=branchAdminModel.branchAdminEntityToModelList(branchAdminList);
		if(branchAdminList.isEmpty()){
			
		}
		return BranchAdminModel;
	}

	public int checkBranchAdminDetails(BranchAdminModel branchAdmin) {
		// TODO Auto-generated method stub
		logger.info("----------CHECK  BRANCHADMIN CONTACT AND EMAIL SERVICE---------------");
		BranchAdmin branchAdminObj =branchAdminModel.branchAdminModelToEntity(branchAdmin);
		return branchAdminDAO.checkBranchAdmin(branchAdminObj);
	}

	public boolean updateBranchAdminDetails(BranchAdminModel branchAdmin) {
		// TODO Auto-generated method stub
	logger.info("----------UPDATE BRANCHADMIN SERVICE---------------");
		BranchAdmin branchadmin=branchAdminModel.branchAdminModelToEntity(branchAdmin);
		
		return branchAdminDAO.updateBranchAdmin(branchadmin);
	}

	public BranchAdminModel getBranchAdminInfo(String branchAdminId) {
		// TODO Auto-generated method stub
		
		logger.info("----------GET BRANCHADMIN OBJECT SERVICE---------------");
		BranchAdmin branchAdmin= branchAdminDAO.fetchBranchAdminInfo(branchAdminId);
		
		BranchAdminModel BranchAdminModel=branchAdminModel.branchAdminEntityToModel(branchAdmin);
		
		return BranchAdminModel;
	}

	
}
