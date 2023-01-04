package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {

        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer(){

        //given
        BeerDto beerDto = BeerDto.builder().beerName("Beer Name").build();
        URI uri = breweryClient.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());

    }

    @Test
    void updateBeer(){
        //given
        BeerDto beerDto = BeerDto.builder().beerName("Beer Name").build();

        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteBeer(){
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {

        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {

        CustomerDto customerDto = CustomerDto.builder().name("Customer name").build();
        URI uri = breweryClient.saveNewCustomer(customerDto);
        assertNotNull(uri);

    }

    @Test
    void updateCustomer() {

        CustomerDto customerDto = CustomerDto.builder().name("Customer name").build();
        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);

    }

    @Test
    void deleteCustomer() {

        breweryClient.deleteCustomer(UUID.randomUUID());
    }

    @Test
    void setApiHost() {
    }
}