//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package lambda.orders;

import lambda.orders.models.Agent;
import lambda.orders.models.Customer;
import lambda.orders.models.Order;
import lambda.orders.repos.AgentsRepo;
import lambda.orders.repos.CustomerRepo;
import lambda.orders.repos.OrdersRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
	private CustomerRepo custrepos;
	private AgentsRepo agentrepos;
	private OrdersRepo ordersrepos;

	public SeedData(CustomerRepo custrepos, AgentsRepo agentrepos, OrdersRepo ordersrepos) {
		this.custrepos = custrepos;
		this.agentrepos = agentrepos;
		this.ordersrepos = ordersrepos;
	}

	public void run(String[] args) throws Exception {
		Agent a01 = new Agent("Ramasundar", "Bangalore", 0.15D, "077-25814763", "");
		Agent a02 = new Agent("Alex ", "London", 0.13D, "075-12458969", "");
		Agent a03 = new Agent("Alford", "New York", 0.12D, "044-25874365", "");
		Agent a04 = new Agent("Ravi Kumar", "Bangalore", 0.15D, "077-45625874", "");
		Agent a05 = new Agent("Santakumar", "Chennai", 0.14D, "007-22388644", "");
		Agent a06 = new Agent("Lucida", "San Jose", 0.12D, "044-52981425", "");
		Agent a07 = new Agent("Anderson", "Brisban", 0.13D, "045-21447739", "");
		Agent a08 = new Agent("Subbarao", "Bangalore", 0.14D, "077-12346674", "");
		Agent a09 = new Agent("Mukesh", "Mumbai", 0.11D, "029-12358964", "");
		Agent a10 = new Agent("McDen", "London", 0.15D, "078-22255588", "");
		Agent a11 = new Agent("Ivan", "Torento", 0.15D, "008-22544166", "");
		Agent a12 = new Agent("Benjamin", "Hampshair", 0.11D, "008-22536178", "");
		Customer c01 = new Customer("Holmes", "London", "London", "UK", "2", 6000.0D, 5000.0D, 7000.0D, 4000.0D,
				"BBBBBBB",
				a03);
		Customer c02 = new Customer("Micheal", "New York", "New York", "USA", "2", 3000.0D, 5000.0D, 2000.0D, 6000.0D,
				"CCCCCCC", a08);
		Customer c03 = new Customer("Albert", "New York", "New York", "USA", "3", 5000.0D, 7000.0D, 6000.0D, 6000.0D,
				"BBBBSBB", a08);
		Customer c04 = new Customer("Ravindran", "Bangalore", "Bangalore", "India", "2", 5000.0D, 7000.0D, 4000.0D,
				8000.0D
				, "AVAVAVA", a11);
		Customer c05 = new Customer("Cook", "London", "London", "UK", "2", 4000.0D, 9000.0D, 7000.0D, 6000.0D,
				"FSDDSDF",
				a06);
		Customer c06 = new Customer("Stuart", "London", "London", "UK", "1", 6000.0D, 8000.0D, 3000.0D, 11000.0D,
				"GFSGERS"
				, a03);
		Customer c07 = new Customer("Bolt", "New York", "New York", "USA", "3", 5000.0D, 7000.0D, 9000.0D, 3000.0D,
				"DDNRDRH", a08);
		Customer c08 = new Customer("Fleming", "Brisban", "Brisban", "Australia", "2", 7000.0D, 7000.0D, 9000.0D,
				5000.0D,
				"NHBGVFC", a05);
		Customer c09 = new Customer("Jacks", "Brisban", "Brisban", "Australia", "1", 7000.0D, 7000.0D, 7000.0D,
				7000.0D,
				"WERTGDF", a05);
		Customer c10 = new Customer("Yearannaidu", "Chennai", "Chennai", "India", "1", 8000.0D, 7000.0D, 7000.0D,
				8000.0D,
				"ZZZZBFV", a10);
		Customer c11 = new Customer("Sasikant", "Mumbai", "Mumbai", "India", "1", 7000.0D, 11000.0D, 7000.0D, 11000.0D,
				"147-25896312", a02);
		Customer c12 = new Customer("Ramanathan", "Chennai", "Chennai", "India", "1", 7000.0D, 11000.0D, 9000.0D,
				9000.0D,
				"GHRDWSD", a10);
		Customer c13 = new Customer("Avinash", "Mumbai", "Mumbai", "India", "2", 7000.0D, 11000.0D, 9000.0D, 9000.0D,
				"113" +
				"-12345678", a02);
		Customer c14 = new Customer("Winston", "Brisban", "Brisban", "Australia", "1", 5000.0D, 8000.0D, 7000.0D,
				6000.0D,
				"AAAAAAA", a05);
		Customer c15 = new Customer("Karl", "London", "London", "UK", "0", 4000.0D, 6000.0D, 7000.0D, 3000.0D,
				"AAAABAA",
				a06);
		Customer c16 = new Customer("Shilton", "Torento", "Torento", "Canada", "1", 10000.0D, 7000.0D, 6000.0D,
				11000.0D,
				"DDDDDDD", a04);
		Customer c17 = new Customer("Charles", "Hampshair", "Hampshair", "UK", "3", 6000.0D, 4000.0D, 5000.0D, 5000.0D,
				"MMMMMMM", a09);
		Customer c18 = new Customer("Srinivas", "Bangalore", "Bangalore", "India", "2", 8000.0D, 4000.0D, 3000.0D,
				9000.0D,
				"AAAAAAB", a07);
		Customer c19 = new Customer("Steven", "San Jose", "San Jose", "USA", "1", 5000.0D, 7000.0D, 9000.0D, 3000.0D,
				"KRFYGJK", a12);
		Customer c20 = new Customer("Karolina", "Torento", "Torento", "Canada", "1", 7000.0D, 7000.0D, 9000.0D,
				5000.0D,
				"HJKORED", a04);
		Customer c21 = new Customer("Martin", "Torento", "Torento", "Canada", "2", 8000.0D, 7000.0D, 7000.0D, 8000.0D,
				"MJYURFD", a04);
		Customer c22 = new Customer("Ramesh", "Mumbai", "Mumbai", "India", "3", 8000.0D, 7000.0D, 3000.0D, 12000.0D,
				"Phone" +
				" No", a02);
		Customer c23 = new Customer("Rangarappa", "Bangalore", "Bangalore", "India", "2", 8000.0D, 11000.0D, 7000.0D,
				12000.0D, "AAAATGF", a01);
		Customer c24 = new Customer("Venkatpati", "Bangalore", "Bangalore", "India", "2", 8000.0D, 11000.0D, 7000.0D,
				12000.0D, "JRTVFDD", a07);
		Customer c25 = new Customer("Sundariya", "Chennai", "Chennai", "India", "3", 7000.0D, 11000.0D, 7000.0D,
				11000.0D,
				"PPHGRTS", a10);
		Order o01 = new Order(1000.0D, 600.0D, c13, a03, "SOD");
		Order o02 = new Order(3000.0D, 500.0D, c19, a10, "SOD");
		Order o03 = new Order(4500.0D, 900.0D, c07, a10, "SOD");
		Order o04 = new Order(2000.0D, 400.0D, c16, a07, "SOD");
		Order o05 = new Order(4000.0D, 600.0D, c22, a02, "SOD");
		Order o06 = new Order(2000.0D, 300.0D, c12, a12, "SOD");
		Order o07 = new Order(3500.0D, 2000.0D, c02, a08, "SOD");
		Order o08 = new Order(2500.0D, 400.0D, c03, a04, "SOD");
		Order o09 = new Order(500.0D, 100.0D, c23, a06, "SOD");
		Order o10 = new Order(4000.0D, 700.0D, c07, a10, "SOD");
		Order o11 = new Order(1500.0D, 600.0D, c08, a04, "SOD");
		Order o12 = new Order(2500.0D, 400.0D, c25, a11, "SOD");
		this.agentrepos.save(a01);
		this.agentrepos.save(a02);
		this.agentrepos.save(a03);
		this.agentrepos.save(a04);
		this.agentrepos.save(a05);
		this.agentrepos.save(a06);
		this.agentrepos.save(a07);
		this.agentrepos.save(a08);
		this.agentrepos.save(a09);
		this.agentrepos.save(a10);
		this.agentrepos.save(a11);
		this.agentrepos.save(a12);
		this.custrepos.save(c01);
		this.custrepos.save(c02);
		this.custrepos.save(c03);
		this.custrepos.save(c04);
		this.custrepos.save(c05);
		this.custrepos.save(c06);
		this.custrepos.save(c07);
		this.custrepos.save(c08);
		this.custrepos.save(c09);
		this.custrepos.save(c10);
		this.custrepos.save(c11);
		this.custrepos.save(c12);
		this.custrepos.save(c13);
		this.custrepos.save(c14);
		this.custrepos.save(c15);
		this.custrepos.save(c16);
		this.custrepos.save(c17);
		this.custrepos.save(c18);
		this.custrepos.save(c19);
		this.custrepos.save(c20);
		this.custrepos.save(c21);
		this.custrepos.save(c22);
		this.custrepos.save(c23);
		this.custrepos.save(c24);
		this.custrepos.save(c25);
		this.ordersrepos.save(o01);
		this.ordersrepos.save(o02);
		this.ordersrepos.save(o03);
		this.ordersrepos.save(o04);
		this.ordersrepos.save(o05);
		this.ordersrepos.save(o06);
		this.ordersrepos.save(o07);
		this.ordersrepos.save(o08);
		this.ordersrepos.save(o09);
		this.ordersrepos.save(o10);
		this.ordersrepos.save(o11);
		this.ordersrepos.save(o12);
	}
}
