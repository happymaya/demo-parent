package cn.happymaya.customer.service;

import cn.happymaya.customer.entity.Customer;
import cn.happymaya.customer.exception.CustomerException;
import cn.happymaya.support.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.not;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

/**
 * @author fangang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    private CustomerService service;

    @Test
    public void testSaveAndDelete() {
        String id = "101";
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Elizabeth");
        customer.setSex("woman");
        customer.setBirthday(DateUtils.getDate("1999-01-01", "yyyy-MM-dd"));
        customer.setIdentification("110112199901016666");
        customer.setPhoneNumber("16912345678");
        service.create(customer);
        Customer saved = service.get(id);
        assertThat("create the customer failed!", id, equalTo(saved.getId()));

        saved.setName("Mary");
        service.modify(saved);
        assertThat("modify the customer failed!", "Mary", equalTo(saved.getName()));

        service.delete(id);
        Customer deleted = service.get(id);
        assertNull("delete the customer failed!", deleted);
    }

    @Test(expected = CustomerException.class)
    public void testSaveWithNullOfId() {
        Customer customer = new Customer();
        service.create(customer);
    }

    @Test
    public void testListOfAll() {
        Collection<Customer> list = service.listOfAll();
        assertThat("list of customers failed!", list.size(), is(not(equalTo(0))));
    }
}
