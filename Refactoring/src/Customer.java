import java.util.Enumeration;
import java.util.Vector;


public class Customer {
   private String _name;
   private Vector _rentals = new Vector();
   
   public Customer(String name){
	   this._name = name;
   }
   
   public void addRental(Rental rental){
	   _rentals.add(rental);
   }
   
   public String getName(){
	   return this._name;
   }
   
   public String Statement(){
	   double totalAmount = 0;
	   int frequentRentalPoints = 0;
	   Enumeration rentals = _rentals.elements();
	   String result = "Rental record for "+ getName() + "\n";
	   while(rentals.hasMoreElements()){
		   double thisAmount = 0;
		   Rental each = (Rental) rentals.nextElement();
		   
		   thisAmount = amountFor(each);
		   // add frequent rental points
		   frequentRentalPoints++;
		   // add bonus for two day new release rental
		   if(each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1)
			   frequentRentalPoints++;
		   
		   // show figures for this rental
		   result+= "\t" + each.getMovie().getTitle() +"\t"+ String.valueOf(thisAmount) + "\n";
		   totalAmount += thisAmount;
	   }
	   
	   // add footer lines
	   result += "Amount owed is "+ String.valueOf(totalAmount) + "\n";
	   result += "you earned "+ String.valueOf(frequentRentalPoints) + " Frequent renter points";
	   return result;
   }
   
   private double amountFor(Rental aRental){
	   double result = 0;
		   switch (aRental.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				 result += 2;
				 if(aRental.getDaysRented() > 2)
					 result += (aRental.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				result += aRental.getDaysRented() * 3;
				break;
			case Movie.CHILDERNS:
				result += 1.5;
				if(aRental.getDaysRented() > 3)
					result+= (aRental.getDaysRented() -3) * 1.5;
			default:
				break;
       }
        return result;		   
   }
}
