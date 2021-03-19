package com.digitrack.demo.repository;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.digitrack.demo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
		
	@Query("SELECT COUNT(0) FROM Person p WHERE p.cpf = :cpf and (:id is null or p.id != :id) ")
	int findCpf(@Param("cpf") String cpf,@Param("id") Long id);

	@Query("SELECT p FROM Person p WHERE (:sex is null or lower(p.sex) LIKE lower(CONCAT('%',:sex,'%'))) and (:birthDate is null or p.birthDate LIKE CONCAT('%',:birthDate,'%')) ORDER BY p.id")
	Page<Person> findAll(@Param("sex") String sex,@Param("birthDate") String birthDate, Pageable pageable);
		
}
