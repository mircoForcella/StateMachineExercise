package com.statemachine.demo.entities;

import jakarta.persistence.*;


import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;


    @Entity
    @Table(name="users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(unique = true)
        private String username;

        private String password;

        private boolean enabled;

        @ElementCollection(fetch = FetchType.EAGER)
        @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
        @Column(name = "role")
        private Set<Role> roles = new HashSet<>();
        public User(){}

        public User(Long id, String username, String password, boolean enabled, Set<Role> roles) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.enabled = enabled;
            this.roles = roles;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public Set<Role> getRoles() {
            return roles;
        }

        public void setRoles(Set<Role> roles) {
            this.roles = roles;
        }
}