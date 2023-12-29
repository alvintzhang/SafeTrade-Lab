//Authors: Joey, Oliver, and Alvin
//Date: 11/16/23
//Creates the PriceComparator class with the method compare

public class PriceComparator extends java.lang.Object implements java.util.Comparator<TradeOrder>
{
	private boolean ascending;
	
	public PriceComparator() 
	{
		ascending = true;
	}
	//compares in ascending order
	public PriceComparator(boolean asc)
	{
		ascending = asc;
	}
	
	
	//Compares two orders 
	public int compare(TradeOrder order1, TradeOrder order2)
	{
		//if both orders are market orders
		if(order1.isMarket() && order2.isMarket())
			return 0;
		//if order1 is a market order and order2 limit order
		else if(order1.isMarket() && order2.isLimit())
			return -1;
		//if order1 is a limit order and order2 is a market order
		else if(order1.isLimit() && order2.isMarket())
			return 1;
		else
		//If both are limit orders
			if(ascending)
				return (int)(100*(order1.getPrice() - order2.getPrice()));
			return (int)(100*(order2.getPrice() - order1.getPrice()));
	}

}