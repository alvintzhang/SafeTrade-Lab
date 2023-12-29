import java.util.TreeMap;

//Authors: Joey, Oliver, and Alvin
//Date: 11/16/23
//Creates the Brokerage class with methods adduser, login, logout, getQuote, and placeOrder

public class Brokerage extends Object implements Login
{
	//Instance variables
	private StockExchange exchange;
	private TreeMap<String, Trader> traders;
	private TreeMap<String, Trader> loggedIn;
	
	//Constructor
	public Brokerage(StockExchange exchange)
	{
		this.exchange = exchange;
		traders = new TreeMap<String, Trader>();
		loggedIn = new TreeMap<String, Trader>();
	}

	//If name and password are available / permitted, creates and adds
	//a trader object to the map of all traders (using screen name as key)
	public int addUser(String name, String password)
	{
		//screen name is already taken
		if(traders.containsKey(name))
			return -3;
		//invalid password (must be 2-10 chars)
		else if(password.length() < 2 || password.length() > 10)
			return -2;
		//invalid screen name (must be 4-10 chars)
		else if(name.length() < 4 || name.length() >10)
			return -1;
		//successfully adds user
		traders.put(name, new Trader(this, name, password));
		return 0;
	}
	
	//Tries to login a trader with a given screen name and password
	//If no messages waiting for Trader, sends "Welcome to SafeTrade!"
	//message to Trader's mailbox
	public int login(String name, String password) 
	{
		// Screen name not found
		if(!traders.containsKey(name))
			return -1;
		Trader t = traders.get(name);
		// invalid password
		if(!t.getPassword().equals(password))
			return -2;
		//user is already logged in
		if(loggedIn.containsKey(name))
			return -3;
		//successful login
		loggedIn.put(name, t);
		if(!t.hasMessages())
			t.receiveMessage("Welcome to SafeTrade!");
		t.openWindow();
		return 0;
	}
	
	//Removes trader from TreeMap of logged-in Traders
	
	public void logout(Trader trader)
	{
		loggedIn.remove(trader.getName());
	}
	
	//Calls the getQuote method in Trader, passing it along to the trader's mailbox
	public void getQuote(String symbol, Trader trader)
	{
		trader.receiveMessage(exchange.getQuote(symbol));

	}
	
	//Calls Brokerage's placeOrder method
	public void placeOrder(TradeOrder order)
	{
		exchange.placeOrder(order);
	}
}
