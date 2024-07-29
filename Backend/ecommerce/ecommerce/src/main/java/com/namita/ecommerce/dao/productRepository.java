/**
 * Copyright Namita Sehgal 2023
 * 
 * The copyright of the computer program is with Namita Sehgal.
 * The program code is solely can be used for learning purpose only.
 * This project is neither inspired nor copied from any other programmer or learning sites.
 */

/**
 * 
 */
package com.namita.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.namita.ecommerce.entity.product;

/**
 * @author namit
 *
 */
// Allow the url to connect with the backend application with different origin
@CrossOrigin(origins = "http://localhost:4200")
public interface productRepository extends JpaRepository<product, Long> // Jpa Repository provide CRUD operation with paging and sorting, < Domain type , ID >
{
	

}
