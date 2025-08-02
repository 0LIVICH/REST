package com.example;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

@Repository
public class UserRepository {
    
    public List<Authorities> getUserAuthorities(String user, String password) {
        // Простая реализация для демонстрации
        // В реальном приложении здесь была бы проверка в базе данных
        
        if ("admin".equals(user) && "password".equals(password)) {
            return Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if ("user".equals(user) && "password".equals(password)) {
            return Arrays.asList(Authorities.READ, Authorities.WRITE);
        } else if ("guest".equals(user) && "password".equals(password)) {
            return Arrays.asList(Authorities.READ);
        }
        
        // Если пользователь не найден или пароль неверный, возвращаем пустой список
        return new ArrayList<>();
    }
} 