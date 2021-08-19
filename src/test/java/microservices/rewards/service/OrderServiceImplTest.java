package microservices.rewards.service;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import microservices.rewards.domain.Order;
import microservices.rewards.repository.IOrderRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderServiceImplTest {
	private static Logger log = LoggerFactory.getLogger(OrderServiceImplTest.class);

	private IOrderService service;

	@Autowired
	private IOrderRepository repo;

	@SuppressWarnings("deprecation")
	@BeforeAll
	public void setUp() {
		if (null != repo)
			service = new OrderServiceImpl(repo);
		else
			log.error("missing repository: repo=" + repo);
	}

	@Test
	public void getOrdersforCurrentMonthTest() {
		List<Order> orders = service.getOrdersForPeriod(Date.from(LocalDateTime.now().minusMonths(1).toInstant(ZoneOffset.UTC)), 
				Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
		assertTrue(orders.isEmpty());
	}
}
