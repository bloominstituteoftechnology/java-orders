package lambda.orders.controllers;

import lambda.orders.models.Customer;
import lambda.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
	@Autowired
	private CustomerService customerService;

	//localhost:2019/customer/all
	@GetMapping(value = "/all",
				produces = {"application/json"})
	public ResponseEntity<?> listAllCustomers()
	{
		List<Customer> myCustomers = customerService.findAll();
		return new ResponseEntity<>(myCustomers, HttpStatus.OK);
	}

	//localhost:2019/customer/{custname}
	@GetMapping(value = "/{custname}",
				produces = {"application/json"})
	public ResponseEntity<?> getCustomerByName(
			@PathVariable
					String custname)
	{
		Customer c = customerService.findCustomerByName(custname);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}

	//localhost:2019/customer/data/new
	@PostMapping(value = "/data/new",
				 consumes = {"application/json"},
				 produces = {"application/json"})
	public ResponseEntity<?> addNewCustomer(@Valid
											@RequestBody
													Customer newCustomer) throws URISyntaxException
	{
		newCustomer = customerService.save(newCustomer);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/custcode").
				buildAndExpand(newCustomer.getCustcode()).toUri();
		responseHeaders.setLocation(newCustomerURI);

		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}

	//localhost:2019/customer/data/customer/update/{custcode}
	@PutMapping(value = "/data/customer/update/{custcode}")
	public ResponseEntity<?> updateCustomer(
			@RequestBody
					Customer updateCustomer,
			@PathVariable
					long custcode)
	{
		customerService.update(updateCustomer, custcode);
		return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
	}

	//localhost:2019/customer/data/customer/delete/{custcode}
	@DeleteMapping(value = "/data/customer/delete/{custcode}")
	public ResponseEntity<?> deleteCustomer(
			@PathVariable
					long custcode)
	{
		customerService.delete(custcode);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}