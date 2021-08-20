package microservices.rewards.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import microservices.rewards.domain.Order;

public interface IOrderRepository extends JpaRepository<Order, Long> {

	@Query("select o from Order o where o.orderDate between :startdate and :enddate")
	List<Order> findOrdersByPeriod(@Param("startdate") Date startDate, @Param("enddate") Date endDate);
}
