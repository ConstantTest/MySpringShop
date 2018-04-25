package com.alex.spring.main;

import com.alex.spring.services.OrderService;
import com.alex.spring.services.ProductService;
import com.alex.spring.services.UserService;
import com.alex.spring.services.dto.OrderDto;
import com.alex.spring.services.dto.ProductDto;
import com.alex.spring.services.dto.UserDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 24.04.2018.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("context-services.xml");

        // create services
        UserService userService = context.getBean(UserService.class);
        ProductService productService = context.getBean(ProductService.class);
        OrderService orderService = context.getBean(OrderService.class);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                String input = bufferedReader.readLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                String[] inputs = input.split(" ");

                if ("U".equals(inputs[0])) {
                    // fill the user
                    doUserActions(userService, inputs);
                } else if ("P".equals(inputs[0])) {
                    // fill product
                    doProductActions(productService, inputs);
                } else if ("O".equals(inputs[0])) {
                    // create order
                    doOrderActions(orderService, inputs);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void doUserActions(UserService userService, String[] inputs) {
        if ("C".equals(inputs[1])) {
            UserDto userDto = new UserDto(inputs[2], inputs[3], inputs[4]);
            userService.register(userDto);
            System.out.format("User \'%s\' has been created successfully!%n", userDto.getFirstName());
        } else if ("L".equals(inputs[1])) {
            List<UserDto> userDtos = userService.findAll();
            System.out.println("List of users:");
            printList(userDtos);
        }
    }

    private static void doProductActions(ProductService productService, String[] inputs) {
        if ("C".equals(inputs[1])) {
            ProductDto dto = new ProductDto(inputs[2], inputs[3], inputs[4], inputs[5], inputs[6]);
            productService.create(dto);
            System.out.format("Product \"%s\" has been added successfully!%n", dto.getName());
        } else if ("L".equals(inputs[1])) {
            System.out.println("List of products");
            printList(productService.findAll());
        }
    }

    private static void doOrderActions(OrderService orderService, String[] inputs) {
        if ("C".equals(inputs[1])) {
            OrderDto dto = new OrderDto(inputs[2], inputs[3], inputs[4]);
            orderService.confirm(dto);
            System.out.format("Order has been added successfully!%n");
        }
        else if ("L".equals(inputs[1])) {
            System.out.println("List of orders:");
            printList(orderService.findAll());
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
        if (list.get(0) instanceof OrderDto) {
            for (Object o: list) {
                OrderDto dto = (OrderDto)o;
                System.out.format("%nOrder:%n----- user: %s %s %s%n", dto.getUserId(), dto.getUserFirstName(), dto.getUserLastName());
                Map<ProductDto, Integer> maps = dto.getProducts();
                for (Map.Entry<ProductDto, Integer> entry: maps.entrySet()) {
                    System.out.format("----- product: %s %s %s %s %s, amount: %d%n%s",
                            entry.getKey().getName(),
                            entry.getKey().getPrice(),
                            entry.getKey().getSize(),
                            entry.getKey().getColor(),
                            entry.getKey().getGender(),
                            entry.getValue(),
                            "--------------------------------");
                }
            }
        }
    }
}
