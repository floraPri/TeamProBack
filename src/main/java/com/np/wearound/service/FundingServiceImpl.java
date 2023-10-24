package com.np.wearound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.wearound.entities.Funding;
import com.np.wearound.entities.FundingRewards;
import com.np.wearound.repository.FundingRepository;
import com.np.wearound.repository.FundingRewardsRepository;
import com.np.wearound.repository.UserRepository;

@Service
public class FundingServiceImpl implements FundingService{
	
	@Autowired
	private UserRepository user;
	
	@Autowired
	private FundingRepository funding;

	@Autowired
	private FundingRewardsRepository reward;
	
	@Override
	public List<Funding> fundinglist() {
		System.out.println(" FundingService - fundinglist ");
		
		System.out.println(funding.findAll());
				
		return funding.findAll();
	}

	@Override
	public Optional<Funding> FundingDetail(int fundingcode) {
		System.out.println(" service - FundingDetail ");
		
		return funding.findById(fundingcode);
	}
	
	@Override
	public List<FundingRewards> Rewardslist(int fundingcode) {
		System.out.println(" service - Rewardslist");
		System.out.println(fundingcode);
		
		return reward.findByFundingcode(fundingcode);
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
	public Funding FundingAdd(Funding ent) {
		System.out.println(" FundingService - FundingAdd ");
		System.out.println("funding " + ent);
		
		 Funding fund= funding.save(ent);
		System.out.println("fund" + fund);
		return fund;
	}

	@Override
	public void RewardAdd(FundingRewards ent) {
		System.out.println(" service - RewardAdd ");
		System.out.println(" reward " + ent );
		
		reward.save(ent);
	}



}

