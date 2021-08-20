package microservices.rewards.domain;

public final class RewardsCalculator {
	private final Double orderPrice;
	private Integer rewards;
	
	public RewardsCalculator(Double price) {
		this.orderPrice = price;
		setRewards();
	}

	@Override
	public String toString() {
		return "RewardsCalculator [orderPrice=" + orderPrice + "dollars, rewards=" + rewards + "points]";
	}

	public Double getOrderPrice() {
		return orderPrice;
	}
	public Integer getRewards() {
		return rewards;
	}
	private void setRewards() {
		if (null != this.orderPrice) {
			if (this.orderPrice < 50)
				this.rewards = 0;
			else if (this.orderPrice >= 50)
				this.rewards = 50;
			
			if (this.orderPrice >= 100)
				this.rewards += (int)(this.orderPrice - 100) * 2;
		} else 
			this.rewards = 0;
	}

}
