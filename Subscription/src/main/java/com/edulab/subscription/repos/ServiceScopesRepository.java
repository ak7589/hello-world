package com.edulab.subscription.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edulab.subscription.entity.ServiceScopes;

public interface ServiceScopesRepository extends JpaRepository<ServiceScopes, Long> {

}
