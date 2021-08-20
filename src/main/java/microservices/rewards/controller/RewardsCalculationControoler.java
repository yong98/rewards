package microservices.rewards.controller;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import microservices.rewards.domain.Order;
import microservices.rewards.domain.RewardsCalculator;
import microservices.rewards.service.IOrderService;
import microservices.rewards.service.IRewardsCalculationService;

@RestController
@RequestMapping("/rewards")
public class RewardsCalculationControoler {
	private static Logger log = LoggerFactory.getLogger(RewardsCalculationControoler.class);
	private IRewardsCalculationService rewardService;
	private IOrderService orderService;
	
	@Autowired
	public RewardsCalculationControoler(IRewardsCalculationService rService, IOrderService oService) {
		this.rewardService = rService;
		this.orderService = oService;
	}
	
	@GetMapping("/{price}")
	RewardsCalculator calculateRewards(@PathVariable("price") Double price) {
		return rewardService.calculateRewards(price);
	}

	@GetMapping("")
	List<RewardsCalculator> calculateRewardsForOrders(@RequestParam("month") Integer month) {
		log.info("calculate rewards for orders in " + month + " months");
		if (null != month) {
			List<Order> orders = this.orderService.getOrdersForPeriod(Date.from(LocalDateTime.now().minusMonths(month).toInstant(ZoneOffset.UTC)), 
				Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
			if (null != orders)
				return orders.stream().map(order -> rewardService.calculateRewards(order.getPrice())).collect(Collectors.toList());
		}
		return null;
	}
}
