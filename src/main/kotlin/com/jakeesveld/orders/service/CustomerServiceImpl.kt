package com.jakeesveld.orders.service

import com.jakeesveld.orders.Customer
import com.jakeesveld.orders.CustomersRepository
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.EntityNotFoundException

class CustomerServiceImpl: CustomerService {

    @Autowired
    var repo: CustomersRepository? = null

    override fun delete(id: Long) {
        if(repo!!.findById(id).isPresent){
            repo!!.deleteById(id)
        }else{
            throw EntityNotFoundException()
        }
    }

    override fun create(customer: Customer): Customer {
        val newCustomer = Customer(name = customer.name, city = customer.city, workingArea = customer.workingArea, country = customer.country,
                grade = customer.grade, openingAmt = customer.openingAmt, receiveAmt = customer.receiveAmt, paymentAmt = customer.paymentAmt,
                outstandingAmt = customer.outstandingAmt, phone = customer.phone, agentCode = customer.agentCode)

        return repo!!.save(newCustomer)
    }


    override fun update(customer: Customer, id: Long) {
        val currentCustomer: Customer = repo!!.findById(id).orElseThrow()
        customer.name.let { currentCustomer.name = customer.name }
        customer.city.let { currentCustomer.city = customer.city }
        customer.workingArea.let { currentCustomer.workingArea = customer.workingArea }
        customer.country.let { currentCustomer.country = customer.country }
        customer.grade.let { currentCustomer.grade = customer.grade }
        customer.openingAmt.let { currentCustomer.openingAmt = customer.openingAmt }
        customer.receiveAmt.let { currentCustomer.receiveAmt = customer.receiveAmt }
        customer.paymentAmt.let { currentCustomer.paymentAmt = customer.paymentAmt }
        customer.outstandingAmt.let { currentCustomer.outstandingAmt = customer.outstandingAmt }
        customer.phone.let { currentCustomer.phone = customer.phone }
        customer.agentCode.let { currentCustomer.agentCode = customer.agentCode }

        repo!!.save(currentCustomer)
    }
}