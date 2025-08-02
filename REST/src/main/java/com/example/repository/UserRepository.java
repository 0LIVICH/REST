package com.example.repository;

import com.example.domain.Authorities;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    
    private final Map<String, UserData> users;
    
    public UserRepository() {
        this.users = new HashMap<>();
        initializeUsers();
    }
    
    private void initializeUsers() {
        users.put("admin", new UserData("admin", "password", 
            Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
        users.put("user", new UserData("user", "password", 
            Arrays.asList(Authorities.READ, Authorities.WRITE)));
        users.put("guest", new UserData("guest", "password", 
            Arrays.asList(Authorities.READ)));
    }
    
    public List<Authorities> getUserAuthorities(String user, String password) {
        UserData userData = users.get(user);
        if (userData != null && userData.getPassword().equals(password)) {
            return userData.getAuthorities();
        }
        return new ArrayList<>();
    }
    
    private static class UserData {
        private final String username;
        private final String password;
        private final List<Authorities> authorities;
        
        public UserData(String username, String password, List<Authorities> authorities) {
            this.username = username;
            this.password = password;
            this.authorities = authorities;
        }
        
        public String getPassword() {
            return password;
        }
        
        public List<Authorities> getAuthorities() {
            return authorities;
        }
    }
} 