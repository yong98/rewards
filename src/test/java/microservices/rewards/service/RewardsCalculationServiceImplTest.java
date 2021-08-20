package microservices.rewards.service;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RewardsCalculationServiceImplTest {
	@Autowired
	IRewardsCalculationService service;

	@Test
	void calculate0RewardsTest() {
		assertTrue(service.calculateRewards(0d).getRewards() == 0);
	}
	@Test
	void calculateLessThan50RewardsTest() {
		assertTrue(service.calculateRewards(49.99).getRewards() == 0);
	}
	@Test
	void calculate50RewardsTest() {
		assertTrue(service.calculateRewards(50d).getRewards() == 50);
	}
	@Test
	void calculateMoreThan50RewardsTest() {
		assertTrue(service.calculateRewards(99.99).getRewards() == 50);
	}
	@Test
	void calculateLessThan100RewardsTest() {
		assertTrue(service.calculateRewards(100d).getRewards() == 50);
	}
	@Test
	void calculateMoreThan100RewardsTest() {
		assertTrue(service.calculateRewards(120d).getRewards() == 90);
	}
	@Test
	void calculateMoreThan120RewardsTest() {
		assertTrue(service.calculateRewards(140d).getRewards() == 130);
	}
}
