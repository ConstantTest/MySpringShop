package com.alex.spring.main;

import com.alex.spring.services.ProductService;
import com.alex.spring.services.UserService;
import com.alex.spring.services.dto.ProductDto;
import com.alex.spring.services.dto.UserDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Alex on 24.04.2018.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("context-services.xml");

        // create services
        UserService userService = context.getBean(UserService.class);
        ProductService productService = context.getBean(ProductService.class);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                String input = bufferedReader.readLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                String[] inputs = input.split(" ");

                // fill the user
                doUserActions(userService, inputs);

                // fill product
                doProductActions(productService, inputs);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void doUserActions(UserService userService, String[] inputs) {
        if ("C".equals(inputs[0])) {
            UserDto userDto = new UserDto(inputs[1], inputs[2], inputs[3]);
            userService.register(userDto);
            System.out.format("User \'%s\' has been created successfully!%n", userDto.getFirstName());
        } else if ("L".equals(inputs[0])) {
            List<UserDto> userDtos = userService.findAll();
            System.out.println("List of users:");
            printList(userDtos);
        }
    }

    private static void doProductActions(ProductService productService, String[] inputs) {
        if ("P".equals(inputs[0])) {
            ProductDto dto = new ProductDto(inputs[1], inputs[2], inputs[3], inputs[4], inputs[5]);
            productService.create(dto);
            System.out.format("Product \"%s\" has been added successfully!%n", dto.getName());
        } else if ("PL".equals(inputs[0])) {
            System.out.println("List of products");
            printList(productService.findAll());
        }
    }

    private static void printList(List<?> list) {
        if (list.size() == 0) {
            return;
        }

        if (list.get(0) instanceof UserDto) {
            for (Object o : list) {
                UserDto u = (UserDto) o;
                System.out.println(u.toString());
            }
        }
        if (list.get(0) instanceof ProductDto) {
            for (Object o: list) {
                ProductDto p = (ProductDto)o;
                System.out.format("name: %s, price: %s, size: %s, color: %s, gender: %s%n",
                        p.getName(), p.getPrice(), p.getSize(), p.getColor(), p.getGender());
            }
        }
    }
}
