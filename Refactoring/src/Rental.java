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
}
