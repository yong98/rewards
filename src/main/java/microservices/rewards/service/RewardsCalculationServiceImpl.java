package microservices.rewards.service;

import org.springframework.stereotype.Service;

import microservices.rewards.domain.RewardsCalculator;

@Service
public class RewardsCalculationServiceImpl implements IRewardsCalculationService {

	@Override
	public RewardsCalculator calculateRewards(Double price) {
		RewardsCalculator val = new RewardsCalculator(price);
		return val;
	}

}
