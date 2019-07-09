package com.example.dbserver.DBDataServer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dbserver.DBDataServer.domain.*;
import java.util.*;

@Repository
public interface DBRepository extends JpaRepository<Product, String>{

    public Product getOneById(String id);
	
	public List<Product> getProductsByName(String name);
	
	public List<Product> findAll();
	
	public List<Product> getProductsByPrice(Integer p);
	
	
}
