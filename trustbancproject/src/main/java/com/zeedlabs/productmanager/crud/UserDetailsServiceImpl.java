/*
 * package com.zeedlabs.productmanager.crud;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * 
 * import com.zeedlabs.productmanager.crud.entity.Staff; import
 * com.zeedlabs.productmanager.crud.repository.StaffRepository;
 * 
 * public class UserDetailsServiceImpl implements UserDetailsService {
 * 
 * @Autowired StaffRepository Repo;
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException {
 * 
 * Staff staff = Repo.getUserByUsername(username); if (staff == null) { throw
 * new UsernameNotFoundException("Could not find user"); } return new
 * MyUserDetails(staff); } }
 * 
 */