package microservices.rewards.domain;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class RewardsCalculatorTest {
	@Test
	void calculate0RewardsTest() {
		RewardsCalculator cal = new RewardsCalculator(0d);
		assertTrue(cal.getRewards() == 0);
	}
	@Test
	void calculateLessThan50RewardsTest() {
		RewardsCalculator cal = new RewardsCalculator(49.99);
		assertTrue(cal.getRewards() == 0);
	}
	@Test
	void calculate50RewardsTest() {
		RewardsCalculator cal = new RewardsCalculator(50d);
		assertTrue(cal.getRewards() == 50);
	}
	@Test
	void calculateMoreThan50RewardsTest() {
		RewardsCalculator cal = new RewardsCalculator(99.99);
		assertTrue(cal.getRewards() == 50);
	}
	@Test
	void calculateLessThan100RewardsTest() {
		RewardsCalculator cal = new RewardsCalculator(100d);
		assertTrue(cal.getRewards() == 50);
	}
	@Test
	void calculateMoreThan100RewardsTest() {
		RewardsCalculator cal = new RewardsCalculator(120d);
		assertTrue(cal.getRewards() == 90);
	}
	@Test
	void calculateMoreThan120RewardsTest() {
		RewardsCalculator cal = new RewardsCalculator(140d);
		assertTrue(cal.getRewards() == 130);
	}
}
