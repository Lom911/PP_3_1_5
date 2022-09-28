package com.example.pp_3_1_5_rest_api;

import com.example.pp_3_1_5_rest_api.controller.Connection;
import com.example.pp_3_1_5_rest_api.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pp315RestApiApplication {

    static Connection connection = new Connection();

    public static void main(String[] args) {
        SpringApplication.run(Pp315RestApiApplication.class, args);

        connection.getUsers();
        User user = new User(3L, "James", "Brown", (byte)34);
        System.out.println(connection.createUser(user));
        user.setName("Thomas");
        user.setLastName("Shelby");
        System.out.println(connection.updateUser(user));
        System.out.println(connection.deleteUser(3L));
    }

}
