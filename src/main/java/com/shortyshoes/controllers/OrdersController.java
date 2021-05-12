package com.shortyshoes.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shortyshoes.models.Orders;
import com.shortyshoes.models.Product;
import com.shortyshoes.models.SportyShoesUserDetails;
import com.shortyshoes.repositories.OrderRepository;
import com.shortyshoes.repositories.ProductRepository;
import com.shortyshoes.repositories.SportyShoesUserDetailsRepository;
import com.shortyshoes.templates.OrdersRequestTemplate;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrdersController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private SportyShoesUserDetailsRepository userRepo;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/get")
	public List<Orders> getAllOrders() {
		try {
			return orderRepository.findAll();

		} catch (Exception e) {

			return null;
		}
	}

	@PostMapping("/add")
	public String appendOrders(@RequestBody OrdersRequestTemplate orders) {
		try {

			System.out.println(orders);

			SportyShoesUserDetails userWhoHasOrdered = userRepo.findById(orders.getUserId()).get();

			List<Orders> allOrdersByUser = orders.getProductsPurchaseByUser().stream().map(productId -> {

				Orders order = new Orders();

				Product existingProduct = productRepository.findById(productId).get();

				order.setProducts(existingProduct);

				order.setSportyShoesUserDetails(userWhoHasOrdered);
				
				order.setPurchaseDate(new Date());

				return order;
				
			}).collect(Collectors.toList());
			
			System.out.println("-------------------- Orders --------------------------");
			System.out.println("User who ordered -> "+ userWhoHasOrdered);
			System.out.println(allOrdersByUser);

			this.orderRepository.saveAll(allOrdersByUser);

			return orders.getUserId() + "";

		} catch (Exception e) {

			return null;
		}
	}

}
