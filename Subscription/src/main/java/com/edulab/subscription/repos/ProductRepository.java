package com.edulab.subscription.repos;


import java.util.Optional;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edulab.subscription.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public Optional<Product> findByProductCode(String prodCode);
	
	@Query("SELECT e FROM Product e where e.productCode IN (:productCodes )")
	public List<Product> findByProductCodeIn(@Param("productCodes")List<String> productCodes);
	
	//public List<Product> findByProductCode(List<String> productCodeList);
	
	@Query(value = "SELECT * FROM product p where p.id not in\r\n" + 
			"		(select od.product_id from orders o, order_detail od \r\n" + 
			"           where  o.id = od.order_id and  o.member_id =:member_id )", nativeQuery = true)
	public List<Product> getproductsNotPurchasedDetails(@Param("member_id") String member_id);

}
