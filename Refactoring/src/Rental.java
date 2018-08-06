import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;


public class Rental {
   private Movie _movie;
   private int _daysRented;
   
   public Rental(Movie movie, int daysRented){
	   this._movie = movie;
	   this._daysRented = daysRented;
   }
   
   public int getDaysRented(){
	   return this._daysRented;
   }
   
   public Movie getMovie(){
	   return this._movie;
   }
   
   public double getCharge(){
	   double result = 0;
		   switch (getMovie().getPriceCode()) {
			case Movie.REGULAR:
				 result += 2;
				 if(getDaysRented() > 2)
					 result += (getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				result += getDaysRented() * 3;
				break;
			case Movie.CHILDERNS:
				result += 1.5;
				if(getDaysRented() > 3)
					result+= (getDaysRented() -3) * 1.5;
			default:
				break;
       }
        return result;		   
   }
   
   public int getFrequentRentalPoints(){
	   if(getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1)
		   return 2;
	   else
		   return 1;
   }
}
