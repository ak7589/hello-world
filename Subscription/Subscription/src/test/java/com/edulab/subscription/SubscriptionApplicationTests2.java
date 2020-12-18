package com.edulab.subscription;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edulab.subscription.entity.Product;
import com.edulab.subscription.entity.ProductCategory;
import com.edulab.subscription.entity.ProductLevel;
import com.edulab.subscription.entity.ProductServices;
import com.edulab.subscription.entity.ServiceMaster;
import com.edulab.subscription.entity.SubscriptionPlan;
import com.edulab.subscription.entity.SubscriptionPlanProd;
import com.edulab.subscription.repos.ProductRepository;
import com.edulab.subscription.repos.ProductServicesRepository;
import com.edulab.subscription.repos.SubscriptionPlanProdRepository;
import com.edulab.subscription.repos.SubscriptionPlanRepository;

@SpringBootTest
class SubscriptionApplicationTests2 {

	@Autowired
	ProductServicesRepository prodServiceRepository;
	
	@Autowired
	SubscriptionPlanRepository subsPlanRepository;
	
	@Autowired
	ProductRepository prodRespository;
	
	@Autowired
	SubscriptionPlanProdRepository subsPlanProdRepository;

	@Test
	void contextLoads() {
	}

	/*
	 * Below tes addresses Service_Master, Product_Services, Product and Product 
	 * Related tables.
	 */
	
	/*
	 * Hibernate: insert into product_category (category_name, sys_created_date,
	 * sys_updated_date) values (?, ?, ?) Hibernate: insert into product_level
	 * (level_name, level_no, product_name, sys_created_date, sys_updated_date)
	 * values (?, ?, ?, ?, ?) Hibernate: insert into product (exam_day, exam_flag,
	 * exam_quantity, price, category_id, level_id, product_name, sys_created_date,
	 * sys_updated_date) values (?, ?, ?, ?, ?, ?, ?, ?, ?) Hibernate: insert into
	 * service_master (service_desc, service_name, sys_created_date,
	 * sys_updated_date) values (?, ?, ?, ?) Hibernate: insert into product_services
	 * (product_id, service_id, sys_created_date, sys_updated_date) values (?, ?, ?,
	 * ?) 2020-12-15 23:28:16.673 INFO 15092 --- [extShutdownHook]
	 * j.LocalContainerEntityManagerFactoryBean :
	 */
	
	@Test
	public void testCreateProductServices() {

		ProductServices prodSvc = new ProductServices();

		LocalDateTime now = LocalDateTime.now();

		// Product start
		Product product = new Product();

		product.setProductName("Study Gear For Suken");
		product.setExamFlag('Y');
		product.setExamDay("Monday");
		product.setPrice(354.23);
		product.setExamQuantity(4);

		
		product.setSysCreatedDate(now);
		product.setSysUpdatedDate(now);

		// Product Category
		ProductCategory prdCategoryExam = new ProductCategory();

		prdCategoryExam.setCategoryName("StudyAndExam");
		prdCategoryExam.setSysCreatedDate(now);
		prdCategoryExam.setSysUpdatedDate(now);

		product.setProdCategory(prdCategoryExam);

		// Product Level

		ProductLevel kankenProdLevelOne = new ProductLevel();

		kankenProdLevelOne.setLevelName("Level 4");
		kankenProdLevelOne.setLevelNo(4.0);
		kankenProdLevelOne.setProductName("Study Gear For Suken");
		kankenProdLevelOne.setSysCreatedDate(now);
		kankenProdLevelOne.setSysUpdatedDate(now);

		product.setProdLevel(kankenProdLevelOne);
		// Product end
		
		prodSvc.setProduct(product);
		
		//Service start
		ServiceMaster svcMaster = new ServiceMaster();
		
		svcMaster.setServiceName("Partial");
		svcMaster.setServiceDesc("Partial_Access");
		svcMaster.setSysCreatedDate(now);
		svcMaster.setSysUpdatedDate(now);
		
		prodSvc.setServiceMaster(svcMaster);
		
		//Service end
		
		//Save data
		prodServiceRepository.save(prodSvc);
	}
	
	//Test method for inserting into the Subscription_Plan_Prod table
	@Test
	public void testCreateSubsPlanProd() {
		
		//SubscriptionPlanProd subsPlanProd = new SubscriptionPlanProd();
				
		//Get Plan Id
		long subsPlanId = 4;
		
		Optional<SubscriptionPlan> subsPlanOptional =  subsPlanRepository.findById(subsPlanId);
		SubscriptionPlan subsPlan = null;
		
		if(subsPlanOptional.isPresent()) {
			subsPlan = subsPlanOptional.get();
			
			System.out.println("Subs plan  present: ");
			
			System.out.println("Subscriber Plan Details Start -----");
			
			System.out.println("Plan_ID : " + subsPlan.getPlanId());
			System.out.println("Plan Name : " + subsPlan.getPlanType().getPlanName());
			System.out.println("Plan Active : " + subsPlan.getPlanType().getPlanActive());
			System.out.println("Plan Price : " + subsPlan.getPrice());
			//System.out.println("Associate Service : " + subsPlan);
			
			
			System.out.println("Subscriber Plan Details End -----");
			
			
		}
		else {
			System.out.println("Subs plan not present ---- ");
		}
		
		//subsPlanProd.setSubsPlan(subsPlan);
		
		
	}
	
	/*
	 * Below test can be used for getting all plans from the system
	 * which can be returned to api
	 */
	@Test
	public void testGetAllSubscriberPlans() {
		
		List<SubscriptionPlan> subsPlan =  subsPlanRepository.findAll();
		
		subsPlan.forEach( subPlan -> {
			System.out.println("Plan Name : " + subPlan.getPlanType().getPlanName());
			System.out.println("Plan Type : " + subPlan.getPlanType().getPlanType());
			System.out.println("Plan Active : " + subPlan.getPlanType().getPlanActive());
			System.out.println("Plan Type : " + subPlan.getPlanType().getPlanType());
			System.out.println("Plan Price : " + subPlan.getPrice());
			System.out.println("Plan Price Mode : " + subPlan.getPriceMode());
			
			System.out.println("---------------------------------------------------------------");
		});
		
	}
	
	//Write test to get all Products
	@Test
	public void testGetAllProducts() {
		
		List<Product> products = prodRespository.findAll();
		
		products.forEach(prod -> {
			System.out.println("Product Name : " + prod.getProductName());
			System.out.println("Product Category : " + prod.getProdCategory().getCategoryName());
			System.out.println("Product Level : " + prod.getProdLevel().getLevelName());
			System.out.println("------------------------------------");
		});
		
	}
	
	//Write test to get product by name
	@Test
	public void testGetProdByName() {
		
		List<Product> products = prodRespository.findByProductName("Study Gear For Maths");
		products.forEach(prod -> {
			System.out.println("Product Name : " + prod.getProductName());
			System.out.println("Product Category : " + prod.getProdCategory().getCategoryName());
			System.out.println("Product Level : " + prod.getProdLevel().getLevelName());
			System.out.println("------------------------------------");
		});
	}
	
	//Write test to get all Subscriber_Plan_prod data
	@Test
	public void testGetAllSubscriberPlanProdById() {
		
		long subsPlanProdId = 1;
		
		Optional<SubscriptionPlanProd> subsPlanProdOptional =  subsPlanProdRepository.findById(subsPlanProdId);
		
		if(subsPlanProdOptional.isPresent()) {
			System.out.println("Subs_Plan_Prod record found ...");
			
			SubscriptionPlanProd tmp = subsPlanProdOptional.get();
			
			System.out.println("Subs_Plan_Prod_Id ::: " + tmp.getSubsPlanProdId());
			System.out.println("Plan Name : " + tmp.getSubsPlan().getPlanType().getPlanName());
			System.out.println("Plan_Active : " + tmp.getSubsPlan().getPlanType().getPlanActive() );
			System.out.println("Product Associated : " + tmp.getProduct().getProductName());
			System.out.println("Product Category : " + tmp.getProduct().getProdCategory().getCategoryName());
			System.out.println("Product Level : " + tmp.getProduct().getProdLevel().getLevelName());
			
			System.out.println("111111111-22222222222 : ");
			
			//Get Service List
			//List<ProductServices> prodServicesList = tmp.getProdServicesList();
			
			//System.out.println("Size of product service list : " + prodServicesList.size());
			
			//prodServicesList.forEach(tmp2 -> {
			//	System.out.println("Associated Service ::: " + tmp2.getServiceMaster().getServiceName());
				
			//});
			
			//System.out.println("Associated Product Service Name: " + tmp.getProdServicess().getServiceMaster().getServiceName());
			//System.out.println("Associated Product Service Description : " + tmp.getProdServicess().getServiceMaster().getServiceDesc());
		}
		else {
			System.out.println("Subs_Plan_Prod record not found ...");
		}
		
		
	}
	
	@Test
	public void testGetAllSubscriberPlanProd() {
		List<SubscriptionPlanProd> subsPlanProdList = subsPlanProdRepository.findAll();
		
		
		subsPlanProdList.forEach(tmp -> {
			
			System.out.println("Subs_Plan_Prod_Id ::: " + tmp.getSubsPlanProdId());
			System.out.println("Plan Name : " + tmp.getSubsPlan().getPlanType().getPlanName());
			System.out.println("Plan_Active : " + tmp.getSubsPlan().getPlanType().getPlanActive() );
			System.out.println("Product Associated : " + tmp.getProduct().getProductName());
			System.out.println("Product Level : " + tmp.getProduct().getProdLevel().getLevelName());
			System.out.println("Product Category : " + tmp.getProduct().getProdCategory().getCategoryName());
			System.out.println("Associated Product Service Name: " + tmp.getProductServices().getServiceMaster().getServiceName());
			System.out.println("Associated Product Service Description : " + tmp.getProductServices().getServiceMaster().getServiceDesc());
			
			System.out.println("----------------------------------------------------------------------------");
			
		});
		
	}
	
	// get for a planId
	@Test
	public void testGetSubscriberPlanProdForPlanId() {
		
		long planId =4;
		List<SubscriptionPlanProd> subsPlanProdList = subsPlanProdRepository.findByPlanId(planId);
		
		
		subsPlanProdList.forEach(tmp -> {
			
			System.out.println("Subs_Plan_Prod_Id ::: " + tmp.getSubsPlanProdId());
			System.out.println("Plan Name : " + tmp.getSubsPlan().getPlanType().getPlanName());
			System.out.println("Plan_Active : " + tmp.getSubsPlan().getPlanType().getPlanActive() );
			System.out.println("Product Associated : " + tmp.getProduct().getProductName());
			System.out.println("Product Level : " + tmp.getProduct().getProdLevel().getLevelName());
			System.out.println("Product Category : " + tmp.getProduct().getProdCategory().getCategoryName());
			System.out.println("Associated Product Service Name: " + tmp.getProductServices().getServiceMaster().getServiceName());
			System.out.println("Associated Product Service Description : " + tmp.getProductServices().getServiceMaster().getServiceDesc());
			
			System.out.println("----------------------------------------------------------------------------");
			
		});
		
	}
	//

}
