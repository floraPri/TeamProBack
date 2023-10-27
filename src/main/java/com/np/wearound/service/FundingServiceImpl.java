package com.np.wearound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.wearound.dto.FundingDTO;
import com.np.wearound.entities.Funding;
import com.np.wearound.entities.FundingPledges;
import com.np.wearound.entities.FundingRewards;
import com.np.wearound.entities.FundingView;
import com.np.wearound.repository.FundingPledgesRepository;
import com.np.wearound.repository.FundingRepository;
import com.np.wearound.repository.FundingRewardsRepository;
import com.np.wearound.repository.FundingViewRepository;
import com.np.wearound.repository.UserRepository;

@Service
public class FundingServiceImpl implements FundingService{
	
	@Autowired
	private UserRepository user;
	
	@Autowired
	private FundingRepository funding;

	@Autowired
	private FundingRewardsRepository reward;
	
	@Autowired
	private FundingPledgesRepository plg;
	
	@Autowired
	private FundingViewRepository view;
	
	@Override
	public List<Funding> Fundinglist() {
		System.out.println(" FundingService - fundinglist ");
		
				
		return funding.findAll();
	}
	
	@Override
	public List<Funding> SelectFundingList(String category) {
		System.out.println(" FundingService - SelectFundingList ");
		
		
		return funding.findByCategory(category);
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
	public Optional<FundingView> FundingInfo(int fundingcode, int rewardscode){
	
		return view.findByFundingcodeAndRewardscode(fundingcode, rewardscode);
	}
	
	@Override
	public FundingPledges ContributeFunding(FundingPledges ent) {
		System.out.println(" FundingService - FundingPledges ");
		System.out.println(ent);
		
		FundingPledges newplg = plg.save(ent);
		return newplg;
	}
	
	@Override
	public void UpdateNowAmount(int fundingcode, int nowamount) {
		Optional<Funding> findfunding = funding.findById(fundingcode);

	    if (findfunding.isPresent()) {
	        Funding existingFunding = findfunding.get();
	        // set
	        existingFunding.setNowAmount(nowamount);
	        // update
	        funding.save(existingFunding);
	    } else {
	        System.out.println("error");
	    }
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
		System.out.println(" FundingService - RewardAdd ");
		System.out.println(" reward " + ent );
		
		reward.save(ent);
	}



}

