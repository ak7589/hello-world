package com.edulab.subscription.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edulab.subscription.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
