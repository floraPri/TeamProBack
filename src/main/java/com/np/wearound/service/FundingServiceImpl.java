package com.np.wearound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.np.wearound.dto.FundingDTO;
import com.np.wearound.entities.Funding;
import com.np.wearound.entities.FundingPledges;
import com.np.wearound.entities.FundingRewards;
import com.np.wearound.entities.FundingView;
import com.np.wearound.entities.PledgesView;
import com.np.wearound.repository.FundingPledgesRepository;
import com.np.wearound.repository.FundingRepository;
import com.np.wearound.repository.FundingRewardsRepository;
import com.np.wearound.repository.FundingViewRepository;
import com.np.wearound.repository.PledgesViewRepository;
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
	
	@Autowired
	private PledgesViewRepository pledgesView;
	
	@Override
	public List<Funding> FundingList() {
		System.out.println(" FundingService - fundingList ");
		
				
		return funding.findAll(Sort.by("fundingcode").descending());
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
		
		return reward.findByFundingcodeOrderByRewardscodeAsc(fundingcode);
	}
	
	@Override
	public Optional<FundingRewards> RewardsDetail(int rewardscode){
		System.out.println("service - rewardsDetail");
		
		return reward.findById(rewardscode);
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
	
//	@Override
//	public void UpdateNowAmount(int fundingcode, int nowamount) {
//		Optional<Funding> findfunding = funding.findById(fundingcode);
//
//	    if (findfunding.isPresent()) {
//	        Funding getAmount = findfunding.get();
//	        // set
//	        getAmount.setNowAmount(nowamount);
//	        // update
//	        funding.save(getAmount);
//	    } else {
//	        System.out.println("error");
//	    }
//	}
	//test
	@Override
	public void UpdateNowAmount(int fundingcode, int nowamount) {
	    Optional<Funding> findfunding = funding.findById(fundingcode);

	    if (findfunding.isPresent()) {
	        Funding getAmount = findfunding.get();
	        
	        // 기존의 nowAmount 값에 nowamount를 누적해서 더함
	        int updatedAmount = getAmount.getNowamount() + nowamount;
	        
	        // set
	        getAmount.setNowAmount(updatedAmount);
	        
	        // update
	        funding.save(getAmount);
	    } else {
	        System.out.println("error");
	    }
	}

	@Override
	public List<Funding> MyOrganizeList(int userno) {
		System.out.println("service - MyOrganizeList");
		return funding.findByUserno(userno);
	}			

	@Override
	public List<PledgesView> MyPledgedList(int userno) {
		System.out.println("service - MyPledgedList");

		return pledgesView.findByUsernoOrderByRegdateDesc(userno);
	}
	
	

	@Override
	public Funding FundingAdd(Funding ent) {
		System.out.println(" FundingService - FundingAdd ");
		System.out.println("funding " + ent);
		
		Funding add = funding.save(ent);
		System.out.println("fund" + add);
		return add;
	}

	@Override
	public Funding FundingEdit(Funding ent) {
		System.out.println(" FundingService - FundingEdit ");
		System.out.println(ent);
		
		Funding edit = funding.save(ent);
		return edit;
	}
	
	@Override
	public void RewardAdd(FundingRewards ent) {
		System.out.println(" FundingService - RewardAdd ");
		System.out.println(" reward " + ent );
		
		reward.save(ent);
	}
	
	@Override
	public void RewardEdit(FundingRewards edit) {
		System.out.println(" FundingService - rewardEdit ");
		System.out.println(" reward " + edit );
		
		reward.save(edit);
	}
	



}

