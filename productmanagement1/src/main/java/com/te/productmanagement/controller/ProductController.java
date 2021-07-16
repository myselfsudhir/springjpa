package com.te.productmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.productmanagement.beans.ProductBean;
import com.te.productmanagement.beans.ProductResponse;
import com.te.productmanagement.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private  ProductRepository repo;
	@PostMapping("/add")
	public ProductResponse storeData(@RequestBody ProductBean infoBean) {
		ProductResponse response = new ProductResponse();
		Optional<ProductBean> optional = repo.findById(infoBean.getPid());

		if (optional.isPresent()) {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data is already Present for Pid : " + infoBean.getPid());
		} else {
			repo.save(infoBean);// store the record
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data is Stored for Pid : " + infoBean.getPid());
		}

		return response;
	}
	
	@PostMapping("/login")
	public ProductResponse authenticate(int pid , String password) {
		ProductResponse response = new ProductResponse();
	    ProductBean infoBean =	repo.authenticate(pid, password);
	    int count = repo.countOfEmployees();
		if (infoBean != null) {
			response.setStatusCode(200);
			response.setMsg("Success Number of Employees "+ count);
			response.setDescription("Logged in Successfully");
			response.setProduct(infoBean);
		} else {
			
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("Invalid Crendentials");
		}

		return response;
	}
	
	@GetMapping("/get/{id}")
	public ProductResponse getData(@PathVariable int pid) {
		ProductResponse response = new ProductResponse();
		Optional<ProductBean> optional = repo.findById(pid);
		if (optional.isPresent()) {

			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data is Found for Pid : " + pid);
			response.setProduct(optional.get());

		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Data Not Found for Id : " + pid);

		}
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public ProductResponse deleteData(@PathVariable int pid) {
		ProductResponse response = new ProductResponse();
		Optional<ProductBean> optional = repo.findById(pid);

		if (optional.isPresent()) {
			repo.deleteById(pid);
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Deleted for Id : " + pid);

		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Data Not Found for Id : " + pid);

		}
		return response;
	}

	@PutMapping("/update")
	public ProductResponse updateData(@RequestBody ProductBean infoBean) {
		ProductResponse response = new ProductResponse();
		Optional<ProductBean> optional = repo.findById(infoBean.getPid());

		if (optional.isPresent()) {
			repo.save(infoBean);
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data updated Successfully");
		} else {
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("Data not found");
		}

		return response;
	}

	@GetMapping("/getall")
	public ProductResponse getAll() {
		ProductResponse response = new ProductResponse();

		List<ProductBean> infoBeans = repo.findAll();
		response.setStatusCode(200);
		response.setMsg("Success");
		response.setDescription("Data Found");
		response.setProducts(infoBeans);
		return response;
	}
	
	
}
