package microservices.rewards.service;

import java.util.Date;
import java.util.List;

import microservices.rewards.domain.Order;

public interface IOrderService {

	List<Order> getOrdersForPeriod(final Date startDate, final Date endDate);
}
