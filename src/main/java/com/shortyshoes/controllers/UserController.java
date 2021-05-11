package com.shortyshoes.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shortyshoes.models.ShoppingCart;
import com.shortyshoes.models.SportyShoesUserDetails;
import com.shortyshoes.repositories.ShoppingCartRepository;
import com.shortyshoes.repositories.SportyShoesUserDetailsRepository;
import com.shortyshoes.templates.AuthenticationRequestTemplate;
import com.shortyshoes.templates.CredentialsUpdateRequestTemplate;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

	/** The user repository. */
	@Autowired
	private SportyShoesUserDetailsRepository sportyShoesUserDetailsRepository;

	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	

	@PostMapping(value = "/authenticate")
	public SportyShoesUserDetails authenticateSsUser(@RequestBody AuthenticationRequestTemplate userToAuthenticate) {

		System.out.println(userToAuthenticate);
		SportyShoesUserDetails registeredUser = this.get(userToAuthenticate.getEmail());
		if (registeredUser != null) {
			if (registeredUser.getPassword().equalsIgnoreCase(userToAuthenticate.getPassword())) {
				registeredUser.setPassword(null);
				return registeredUser;
			}
		}
		return null;

	}

	/**
	 * Gets all users
	 */
	@GetMapping(value = "/all")
	public List<SportyShoesUserDetails> getAll() {
		return sportyShoesUserDetailsRepository.findAll();
	}

	/**
	 * Gets user.
	 *
	 */
	@GetMapping(value = "/{username}")
	public SportyShoesUserDetails get(@PathVariable String username) {
		System.out.println("username : " + username);
		System.out.println("user found : " + sportyShoesUserDetailsRepository.findByEmail(username));
		return sportyShoesUserDetailsRepository.findByEmail(username);

	}

	@GetMapping(value = "/search-for/{credential}")
	public List<SportyShoesUserDetails> searchForUserWith(@PathVariable String credential) {

		SportyShoesUserDetails userByEmail = sportyShoesUserDetailsRepository.findByEmail(credential);

		if (userByEmail != null) {

			ArrayList<SportyShoesUserDetails> fetchedUser = new ArrayList<SportyShoesUserDetails>();

			fetchedUser.add(userByEmail);

			return fetchedUser;

		} else {

			List<SportyShoesUserDetails> userByUsername = sportyShoesUserDetailsRepository
					.findByUsernameMatch("%" + credential + "%");

			return userByUsername;

		}

	}

	/**
	 * Persist user.
	 *
	 */
	@PostMapping(value = "/add")
	public SportyShoesUserDetails persist(@RequestBody final SportyShoesUserDetails user) {

		if (sportyShoesUserDetailsRepository.findByEmail(user.getEmail()) == null) {

			ShoppingCart newUsersNewCart = new ShoppingCart();

			SportyShoesUserDetails savedUser = sportyShoesUserDetailsRepository.save(user);

			newUsersNewCart.setSportyShoesUserDetails(user);

			shoppingCartRepository.save(newUsersNewCart);

			return savedUser;
		}

		return null;
	}

	/**
	 * Delete user.
	 *
	 */
	@DeleteMapping(value = "/delete")
	public List<SportyShoesUserDetails> delete(@PathVariable String username) {
		SportyShoesUserDetails userToDelete = sportyShoesUserDetailsRepository.findByEmail(username);
		sportyShoesUserDetailsRepository.deleteById(userToDelete.getId());
		return sportyShoesUserDetailsRepository.findAll();
	}

	/**
	 * Put user.sportyShoesUserDetailsRepository
	 *
	 */
	@PutMapping(value = "/{username}/put")
	public List<SportyShoesUserDetails> put(@PathVariable String username, @RequestBody SportyShoesUserDetails user) {
		if (sportyShoesUserDetailsRepository
				.existsById(sportyShoesUserDetailsRepository.findByEmail(username).getId())) {
			sportyShoesUserDetailsRepository.deleteById(sportyShoesUserDetailsRepository.findByEmail(username).getId());
			sportyShoesUserDetailsRepository.save(user);
		}

		return sportyShoesUserDetailsRepository.findAll();
	}

	@PutMapping(value = "/update-pass")
	public SportyShoesUserDetails updatePassword(@RequestBody CredentialsUpdateRequestTemplate adminUpdate) {

		System.out.println("Received admin to update -> " + adminUpdate);

		SportyShoesUserDetails existingAdmin = sportyShoesUserDetailsRepository.findById(adminUpdate.getId()).get();

		System.out.println(existingAdmin);

		if (existingAdmin != null) {

			existingAdmin.setPassword(adminUpdate.getNewPassword());

			System.out.println("Updated pass -> " + existingAdmin);

			sportyShoesUserDetailsRepository.saveAndFlush(existingAdmin);

			return existingAdmin;

		} else {

			return null;
		}

	}
	
	
}
