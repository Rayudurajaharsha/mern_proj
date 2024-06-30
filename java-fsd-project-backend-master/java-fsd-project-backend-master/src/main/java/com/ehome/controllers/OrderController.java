package com.ehome.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ehome.entities.Order;
import com.ehome.entities.Product;
import com.ehome.entities.User;
import com.ehome.payload.OrderDto;
import com.ehome.services.OrderService;


@RestController
@RequestMapping(value = "/api/ehome/orders")

public class OrderController {
	
	@Autowired
	private OrderService service;
	
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> orders = service.findAll();
		return new ResponseEntity<>(orders,HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable Integer id){
		 Order order = service.findById(id);
		 return ResponseEntity.ok().body(order);
	}
	
	@PostMapping("/{userid}/newOrder")
	public ResponseEntity<OrderDto> saveOrder(@PathVariable int userid,@RequestBody OrderDto order)
	{
		return new ResponseEntity<>(service.insert(userid,order),HttpStatus.CREATED);
		
	}
	
}
