/*
 * package com.zeedlabs.productmanager.crud.entity;
 * 
 * import java.util.*;
 * 
 * import javax.persistence.*;
 * 
 * @Entity
 * 
 * @Table(name = "staff") public class Staff {
 * 
 * @Id
 * 
 * @Column(name = "staff_id")
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
 * 
 * private String username; private String password; private boolean enabled;
 * 
 * @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
 * 
 * @JoinTable(name = "staffs_roles", joinColumns = @JoinColumn(name =
 * "staff_id"), inverseJoinColumns = @JoinColumn(name = "duties_id"))
 * 
 * private Set<Duties> duties = new HashSet<>();
 * 
 * public Integer getId() { return id; }
 * 
 * public void setId(Integer id) { this.id = id; }
 * 
 * public String getUsername() { return username; }
 * 
 * public void setUsername(String username) { this.username = username; }
 * 
 * public String getPassword() { return password; }
 * 
 * public void setPassword(String password) { this.password = password; }
 * 
 * public boolean isEnabled() { return enabled; }
 * 
 * public void setEnabled(boolean enabled) { this.enabled = enabled; }
 * 
 * public Set<Duties> getDuties() { return duties; }
 * 
 * public void setDuties(Set<Duties> duties) { this.duties = duties; } }
 */