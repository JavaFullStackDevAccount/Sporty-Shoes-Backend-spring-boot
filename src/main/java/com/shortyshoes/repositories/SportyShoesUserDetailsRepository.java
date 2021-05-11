package com.shortyshoes.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shortyshoes.models.SportyShoesUserDetails;

public interface SportyShoesUserDetailsRepository extends JpaRepository<SportyShoesUserDetails, Integer> {
	
	public SportyShoesUserDetails findByEmail(String email);

	@Query("SELECT e FROM SportyShoesUserDetails e WHERE e.username LIKE ?1")
	public List<SportyShoesUserDetails> findByUsernameMatch(String username);

	
}
