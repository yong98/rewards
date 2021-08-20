package microservices.rewards.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import microservices.rewards.domain.Order;
import microservices.rewards.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {
	private static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	private IOrderRepository orderRepository;

	@Autowired
	public OrderServiceImpl(IOrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Transactional
	@Override
	public List<Order> getOrdersForPeriod(final Date startDate, final Date endDate) {
		log.info("start date = " + startDate);
		log.info("end date = " + endDate);
		if (null != startDate && null != endDate) {
			List<Order> orders = this.orderRepository.findOrdersByPeriod(startDate, endDate);
			log.info("orders counts " + orders.size());
			return orders;
		}
		return null;
	}

}
