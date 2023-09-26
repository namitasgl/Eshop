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
package com.namita.ecommerce.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.namita.ecommerce.entity.product;
import com.namita.ecommerce.entity.productCategory;

/**
 * @author namit
 *
 */
// scanned via the spring to create bean
@Configuration
public class restConfiguration implements RepositoryRestConfigurer{
	
	//method which we do not wants to expose or used in product.class (domain type)
	// withItemExposure - single item
	//withCollectionExposure - collection item
	
	HttpMethod[] removeExposureMthd = { HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.POST};
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		ExposureConfiguration configuration = config.getExposureConfiguration();
		//disable PUT, POT and delete http methods from product class
		configuration.forDomainType(product.class)
				.withItemExposure((metadata, httpMthds) -> httpMthds.disable(removeExposureMthd))
				.withCollectionExposure((metadata, httpMthds) -> httpMthds.disable(removeExposureMthd));
	
		//disable PUT, POT and delete http methods from productCategory class
		configuration.forDomainType(productCategory.class)
		.withItemExposure((metadata, httpMthds) -> httpMthds.disable(removeExposureMthd))
		.withCollectionExposure((metadata, httpMthds) -> httpMthds.disable(removeExposureMthd));

	}

}
