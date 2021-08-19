package microservices.rewards.service;

import microservices.rewards.domain.RewardsCalculator;

public interface IRewardsCalculationService {

	RewardsCalculator calculateRewards(Double price);
}
