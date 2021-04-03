package com.app.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.ERole;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.security.payload.request.LoginRequest;
import com.app.security.payload.request.SignupRequest;
import com.app.security.payload.response.JwtResponse;
import com.app.security.payload.response.MessageResponse;
import com.app.security.service.MyUserDetailsService;
import com.app.security.service.UserDetailsPojos;
import com.app.security.service.jwtUtil.JwtUtils;
import com.app.service.IRoleService;
import com.app.service.IUserService;


//controller for the rest full services this is controller + Response Body 
//for marshaling and unmarshaling or serilization and deserilization 
//java-->json marshalling and vicevesa

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired//depenency injuction SERVICE OBJ automaticaly
	private IUserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private MyUserDetailsService myUserDetailService;
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private IRoleService roleService;
 	
	public UserController()
	{
		System.out.println("in cntr of "+getClass().getName());
	} 

	
	@GetMapping("/allUsers")
	public List<User> getAllUsers()
	{
		System.out.println("in GetAllUsers controller");
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserByid(@PathVariable int id)
	{
		return userService.getUserById(id);
	}
	
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsPojos userDetails = (UserDetailsPojos) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 	
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userService.existsByUserName(signUpRequest.getUserName())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userService.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}


		
		
		User user = new User(signUpRequest.getUserName(), 
							 signUpRequest.getFirstName(),
							 signUpRequest.getLastName(),
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),
							 signUpRequest.getMobileNo(),
							 signUpRequest.isActiveStatus(),
							 signUpRequest.isSeller());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		
		if (strRoles == null) {
			Role userRole = roleService.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleService.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				default:
					Role userRole = roleService.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userService.createNewUser(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	@PutMapping("/Update")
	public ResponseEntity<?> updateUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userService.existsByUserName(signUpRequest.getUserName())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userService.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}


		
		
		User user = new User(signUpRequest.getUserName(), 
							 signUpRequest.getFirstName(),
							 signUpRequest.getLastName(),
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),
							 signUpRequest.getMobileNo(),
							 signUpRequest.isActiveStatus(),
							 signUpRequest.isSeller());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		
		if (strRoles == null) {
			Role userRole = roleService.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleService.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				default:
					Role userRole = roleService.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userService.createNewUser(user);

		return ResponseEntity.ok(new MessageResponse("User Updated successfully!"));
	}
	
	@DeleteMapping("/{cid}")
	public ResponseEntity<?>deleteUser(@PathVariable int cid)	{
		
	    try {
	   return new ResponseEntity<>(userService.deleteCustomer(cid),HttpStatus.OK);
	    }
	    catch(RuntimeException e)
	    {
	    	return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	   
	}
	
}
