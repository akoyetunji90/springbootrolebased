
  package com.zeedlabs.productmanager.crud;
  
  import org.springframework.beans.factory.annotation.Autowired;
import
  org.springframework.security.core.userdetails.UserDetails;
import
  org.springframework.security.core.userdetails.UserDetailsService;
import
  org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zeedlabs.productmanager.crud.model.User;
import com.zeedlabs.productmanager.crud.repository.UserRepository;
  
  public class UserDetailsServiceImpl implements UserDetailsService {
  
  @Autowired 
  UserRepository Repo;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws
  UsernameNotFoundException {
  
  User user = Repo.getUserByUsername(username); 
  if (user == null) {
  throw new UsernameNotFoundException("Could not find user");
  } 
  return new  MyUserDetails(user);
  } 
 }
  
 