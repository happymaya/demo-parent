package cn.happymaya.customer.web;

import cn.happymaya.customer.entity.Customer;
import cn.happymaya.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * The controller for customer.
 * @author fangang
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("show")
    public String show() {
        return "customer/index";
    }

    @PostMapping("register")
    @ResponseBody
    public void register(Customer customer) {
        service.create(customer);
    }

    @PostMapping("modify")
    @ResponseBody
    public void modify(Customer customer) {
        service.modify(customer);
    }

    @GetMapping("delete")
    @ResponseBody
    public void delete(String id) {
        service.delete(id);
    }

    @GetMapping("get")
    @ResponseBody
    public Customer get(String id) {
        return service.get(id);
    }

    @GetMapping("listOfAll")
    @ResponseBody
    public Collection<Customer> listOfAll() {
        return service.listOfAll();
    }
}
