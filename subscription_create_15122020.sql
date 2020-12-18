SET FOREIGN_KEY_CHECKS=0
; 

/* Create Tables */

CREATE TABLE `Coupon`
(
	`coupon_id` INT NOT NULL AUTO_INCREMENT,
	`coupon_type` VARCHAR(50) NULL,
	`coupon_detail` VARCHAR(50) NULL,
	`coupon_start_code` INT NULL,
	`coupon_partner` VARCHAR(200) NULL,
	`no_of_coupons` INT NULL,
	`coupon_validity` VARCHAR(200) NULL,
	`coupon_discount` VARCHAR(200) NULL,
	`sys_created_date` TIMESTAMP NULL,
	`sys_updated_date` TIMESTAMP NULL,
	CONSTRAINT `PK_Coupon` PRIMARY KEY (`coupon_id` ASC)
)

;

CREATE TABLE `Discount`
(
	`discount_id` INT NOT NULL AUTO_INCREMENT,
	`discount` VARCHAR(100) NULL,
	`sys_created_date` TIMESTAMP NULL,
	`sys_updated_date` TIMESTAMP NULL,
	CONSTRAINT `PK_Discount` PRIMARY KEY (`discount_id` ASC)
)

;

CREATE TABLE `Plan_Type`
(
	`plan_type_id` INT NOT NULL AUTO_INCREMENT,
	`plan_name` VARCHAR(200) NULL,
	`plan_type` VARCHAR(200) NULL,
	`plan_active` CHAR(1) NULL,
	`discount_id` INT NULL,
	`sys_created_date` TIMESTAMP NULL,
	`sys_updated_date` TIMESTAMP NULL,
	CONSTRAINT `PK_Plan_Type` PRIMARY KEY (`plan_type_id` ASC)
)

;

CREATE TABLE `Product`
(
	`product_id` INT NOT NULL AUTO_INCREMENT,
	`product_name` VARCHAR(200) NULL,
	`category_id` INT NULL,
	`level_id` INT NULL,
	`payment_freq_id` INT NULL,
	`exam_flag` CHAR(1) NULL,
	`exam_day` VARCHAR(50) NULL,
	`price` DOUBLE(10,2) NULL,
	`exam_quantity` INT NULL,
	`sys_created_date` TIMESTAMP NULL,
	`sys_updated_date` TIMESTAMP NULL,
	CONSTRAINT `PK_Product` PRIMARY KEY (`product_id` ASC)
)

;

CREATE TABLE `Product_Category`
(
	`category_id` INT NOT NULL AUTO_INCREMENT,
	`category_name` VARCHAR(50) NULL,
	`sys_created_date` TIMESTAMP NULL,
	`sys_updated_date` TIMESTAMP NULL,
	CONSTRAINT `PK_Table A` PRIMARY KEY (`category_id` ASC)
)

;

CREATE TABLE `Product_Level`
(
	`level_id` INT NOT NULL AUTO_INCREMENT,
	`level_name` VARCHAR(50) NULL,
	`Product_name` VARCHAR(200) NULL,
	`level_no` DOUBLE(10,2) NULL,
	`sys_created_date` TIMESTAMP NULL,
	`sys_updated_date` TIMESTAMP NULL,
	CONSTRAINT `PK_Product_Level` PRIMARY KEY (`level_id` ASC)
)

;

CREATE TABLE `Product_Services`
(
	`product_service_id` INT NOT NULL AUTO_INCREMENT,
	`product_id` INT NOT NULL,
	`service_id` INT NOT NULL,
	`sys_created_date` TIMESTAMP NULL,
	`sys_updated_date` TIMESTAMP NULL,
	CONSTRAINT `PK_Product_Services` PRIMARY KEY (`product_service_id` ASC)
)

;

CREATE TABLE `Service_Master`
(
	`service_id` INT NOT NULL AUTO_INCREMENT,
	`service_name` VARCHAR(100) NULL,
	`service_desc` VARCHAR(500) NULL,
	`sys_created_date` TIMESTAMP NULL,
	`sys_updated_date` TIMESTAMP NULL,
	CONSTRAINT `PK_Service_Master` PRIMARY KEY (`service_id` ASC)
)

;

CREATE TABLE `Subscription_Plan`
(
	`plan_id` INT NOT NULL AUTO_INCREMENT,
	`plan_type_id` INT NULL,
	`price` DOUBLE(10,2) NULL,
	`price_mode` VARCHAR(50) NULL,
	`credit` INT NULL,
	`credit_mode` VARCHAR(50) NULL,
	`free_period` VARCHAR(50) NULL,
	`discount` DOUBLE(10,2) NULL,
	`plan_start_date` TIMESTAMP NULL,
	`sys_created_date` TIMESTAMP NULL,
	`sys_updated_date` TIMESTAMP NULL,
	CONSTRAINT `PK_Plan` PRIMARY KEY (`plan_id` ASC)
)

;

CREATE TABLE `Subscription_Plan_Prod`
(
	`subs_plan_prod_id` INT NOT NULL AUTO_INCREMENT,
	`plan_id` INT NOT NULL,
	`product_id` INT NOT NULL,
	`product_service_id` INT NULL,
	`sys_created_date` TIMESTAMP NULL,
	`sys_updated_date` TIMESTAMP NULL,
	CONSTRAINT `PK_Plan_Prod` PRIMARY KEY (`subs_plan_prod_id` ASC)
)

;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE `Discount` 
 ADD INDEX `IXFK_Discount_Plan_Type` ()
;

ALTER TABLE `Plan_Type` 
 ADD INDEX `IXFK_Plan_Type_Discount` (`discount_id` ASC)
;

ALTER TABLE `Product` 
 ADD INDEX `IXFK_Product_Payment_Frequency` (`payment_freq_id` ASC)
;

ALTER TABLE `Product` 
 ADD INDEX `IXFK_Product_Product_Category` (`category_id` ASC)
;

ALTER TABLE `Product` 
 ADD INDEX `IXFK_Product_Product_Level` (`level_id` ASC)
;

ALTER TABLE `Product_Services` 
 ADD INDEX `IXFK_Product_Services_Product` (`product_id` ASC)
;

ALTER TABLE `Product_Services` 
 ADD INDEX `IXFK_Product_Services_Service_Master` (`service_id` ASC)
;

ALTER TABLE `Subscription_Plan` 
 ADD INDEX `IXFK_Subscription_Plan_Plan_Type` (`plan_type_id` ASC)
;

ALTER TABLE `Subscription_Plan_Prod` 
 ADD INDEX `IXFK_Plan_Prod_Plan` (`plan_id` ASC)
;

ALTER TABLE `Subscription_Plan_Prod` 
 ADD INDEX `IXFK_Plan_Prod_Product` (`product_id` ASC)
;

ALTER TABLE `Subscription_Plan_Prod` 
 ADD INDEX `IXFK_Subscription_Plan_Prod_Product_Services` (`product_service_id` ASC)
;

/* Create Foreign Key Constraints */

ALTER TABLE `Plan_Type` 
 ADD CONSTRAINT `FK_discount_id`
	FOREIGN KEY (`discount_id`) REFERENCES `Discount` (`discount_id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Product` 
 ADD CONSTRAINT `FK_category_id`
	FOREIGN KEY (`category_id`) REFERENCES `Product_Category` (`category_id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Product` 
 ADD CONSTRAINT `FK_level_id`
	FOREIGN KEY (`level_id`) REFERENCES `Product_Level` (`level_id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Product_Services` 
 ADD CONSTRAINT `FK_product_id`
	FOREIGN KEY (`product_id`) REFERENCES `Product` (`product_id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Product_Services` 
 ADD CONSTRAINT `FK_service_id`
	FOREIGN KEY (`service_id`) REFERENCES `Service_Master` (`service_id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Subscription_Plan` 
 ADD CONSTRAINT `FK_plan_type_id`
	FOREIGN KEY (`plan_type_id`) REFERENCES `Plan_Type` (`plan_type_id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Subscription_Plan_Prod` 
 ADD CONSTRAINT `FK_plan_id`
	FOREIGN KEY (`plan_id`) REFERENCES `Subscription_Plan` (`plan_id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Subscription_Plan_Prod` 
 ADD CONSTRAINT `FK_product_id`
	FOREIGN KEY (`product_id`) REFERENCES `Product` (`product_id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Subscription_Plan_Prod` 
 ADD CONSTRAINT `FK_product_service_id`
	FOREIGN KEY (`product_service_id`) REFERENCES `Product_Services` (`product_service_id`) ON DELETE Restrict ON UPDATE Restrict
;

SET FOREIGN_KEY_CHECKS=1
; 
