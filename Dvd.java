import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.Duration;
import java.time.Period;
 
public class Dvd extends LibraryItem{
    //instance variable
    private String rating;

    //class constructors
    public Dvd(String argID,String argTitle,String argRating){
        super(argID,argTitle);
        this.SetRating(argRating);
    }

    public Dvd(String argID,String argTitle,LocalDate argDateCheckedOut,String argRating){
        super(argID,argTitle,argDateCheckedOut);
        this.SetRating(argRating);
    }

    public Dvd(String argID,String argTitle,LocalDate argDateCheckedOut,LocalDate argDateReturned,String argRating){
        super(argID,argTitle,argDateCheckedOut,argDateReturned);
        this.SetRating(argRating);
    }

    //set and get methods
    public void SetRating(String argRating){
        rating=argRating;
    }

    public String GetRating(){
        return rating;
    }
     //class methods
    public LocalDate GetDueDate(){
        LocalDate dueDate;
        LocalDate neverDue= LocalDate.of(3000, Month.JANUARY, 1);
        if(super.IsCheckedOut()){
            dueDate=super.GetDateCheckedOut().plus(1,ChronoUnit.WEEKS);
            
        }
        else{
            dueDate=neverDue;
        }
        return dueDate;
    }

    public boolean IsOverdue(){
        boolean overDue=false;
        LocalDate today=LocalDate.now();
        if(super.IsCheckedOut()){
            if(GetDueDate().compareTo(today)<0){
                overDue=true;
            }
            else{
                overDue=false;
            }

        }
        return overDue;
    }
     public double GetFine(){
         double fine=0;
         LocalDate today=LocalDate.now();

         if(IsOverdue()){
             Period period=Period.between(GetDueDate(),today);
             fine=period.getDays();
         }
         return fine;

     }

}