package com.ehome.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehome.entities.Order;
import com.ehome.entities.Product;
import com.ehome.entities.User;
import com.ehome.payload.OrderDto;
import com.ehome.repository.OrderRepository;
import com.ehome.repository.ProductRepository;
import com.ehome.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private ModelMapper modelmapper;
	@Autowired
	private ObjectMapper objectMapper;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Integer id) {
		Optional<Order> product = repository.findById(id);
		return product.get();
	}
	
	public OrderDto insert(Integer userid,OrderDto order) {
		
		User user = userrepository.findById(userid).get();
		Order orderinfo = modelmapper.map(order,Order.class);
		orderinfo.setUser(user);
		Order neworder = repository.save(orderinfo);
		return modelmapper.map(neworder,OrderDto.class);
	}

}
