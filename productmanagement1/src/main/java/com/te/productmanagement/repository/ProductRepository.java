package com.te.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.te.productmanagement.beans.ProductBean;

@Repository
public interface ProductRepository extends JpaRepository<ProductBean, Integer>{
	
	
	@Query("from ProductBean where pid=:pid and password=:pwd")
	public ProductBean authenticate(int pid , String pwd) ;
	
	@Query("select count(*) from ProductBean")
	public int countOfEmployees();

}
