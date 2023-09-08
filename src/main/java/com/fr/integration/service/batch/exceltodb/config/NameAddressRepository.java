package com.fr.integration.service.batch.exceltodb.config;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NameAddressRepository extends JpaRepository<NameAddressDTO, Integer> {
}
