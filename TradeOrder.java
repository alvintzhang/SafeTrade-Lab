/*
 * 
 * Brokerage: Creates a TradeOrder class with get methods
 * and subtractShares methods
 * Authors: Oliver, Joey, Alvin
 * 
 */

public class TradeOrder extends java.lang.Object
{
	//Instance variables
	private Trader trader;
	private String symbol;
	private boolean buyOrder;
	private boolean marketOrder;
	private int numShares;
	private double price;
	
	//Constructor
	public TradeOrder(Trader trader, String symbol, boolean buyOrder, boolean marketOrder, int numShares, double price)
	{
		this.trader = trader;
		this.symbol = symbol;
		this.buyOrder = buyOrder;
		this.marketOrder = marketOrder;
		this.numShares = numShares;
		this.price = price;
	}
	
	/*
	 * GET METHODS
	 */
	
	public Trader getTrader()
	{
		return trader;
	}
	
	public String getSymbol()
	{
		return symbol;
	}
	
	public boolean isBuy()
	{
		return buyOrder;
	}
	
	public boolean isSell()
	{
		return !buyOrder;
	}
	
	public boolean isMarket()
	{
		return marketOrder;
	}
	
	public boolean isLimit()
	{
		return !marketOrder;
	}
	
	public int getShares()
	{
		return numShares;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	//Subtracts shares from the total shares in this TradeOrder
	public void subtractShares(int shares)
	{
		if(shares > numShares)
			throw new IllegalArgumentException("Error");
		else
			numShares -= shares;
	}
}
	
	