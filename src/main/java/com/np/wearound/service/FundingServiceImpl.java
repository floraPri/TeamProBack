package com.np.wearound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.wearound.entities.Funding;
import com.np.wearound.repository.FundingRepository;
import com.np.wearound.repository.UserRepository;

@Service
public class FundingServiceImpl implements FundingService{
	
	@Autowired
	private UserRepository user;
	
	@Autowired
	private FundingRepository funding;

	
	@Override
	public List<Funding> fundinglist() {
		System.out.println(" FundingService - fundinglist ");
		
		System.out.println(funding.findAll());
				
		return funding.findAll();
	}

	@Override
	public Optional<Funding> FundingDetail(int fundingcode) {
		System.out.println(" service - detail ");
		
		return funding.findById(fundingcode);
	}

	@Override
	public void ContributeFunding(int userno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Funding> OrganizerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funding> Participantlist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void FundingAdd(Funding dto) {
		System.out.println(" FundingService - fundingAdd ");
		System.out.println("funding " + dto);
		
		funding.save(dto);
	}


}

