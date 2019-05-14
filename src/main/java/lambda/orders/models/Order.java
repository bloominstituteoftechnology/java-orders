package lambda.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ordnum;

	private double ordamount;
	private double advanceamount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custcode", nullable = false)
	@JsonIgnoreProperties({"agent", "orders"})
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agentcode", nullable = false)
	@JsonIgnoreProperties({"customer", "orders"})
	private Agent agent;

	private String orddescription;

	public Order()
	{
	}

	public Order(double ordamount, double advanceamount, Customer customer, Agent agent, String orddescription)
	{
		this.ordamount = ordamount;
		this.advanceamount = advanceamount;
		this.customer = customer;
		this.agent = agent;
		this.orddescription = orddescription;
	}

	public long getOrdnum()
	{
		return ordnum;
	}

	public void setOrdnum(long ordnum)
	{
		this.ordnum = ordnum;
	}

	public double getOrdamount()
	{
		return ordamount;
	}

	public void setOrdamount(double ordamount)
	{
		this.ordamount = ordamount;
	}

	public double getAdvanceamount()
	{
		return advanceamount;
	}

	public void setAdvanceamount(double advanceamount)
	{
		this.advanceamount = advanceamount;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public Agent getAgent()
	{
		return agent;
	}

	public void setAgent(Agent agent)
	{
		this.agent = agent;
	}

	public String getOrddescription()
	{
		return orddescription;
	}

	public void setOrddescription(String orddescription)
	{
		this.orddescription = orddescription;
	}
}


//		ORDNUM primary key, not null Long
//		ORDAMOUNT double
//		ADVANCEAMOUNT double
//		CUSTCODE Long foreign key (one customer to many orders) not null
//		AGENTCODE Long foreign key (one agent to many orders) not null
//		ORDDESCRIPTION