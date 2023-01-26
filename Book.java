import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.Duration;
import java.time.Period;

public class Book extends LibraryItem{
    //instance variables
    private String author;

    //class constructors
    public Book(String argID,String argTitle,String argAuthor){
        super(argID,argTitle);
        this.SetAuthor(argAuthor);
    }

    public Book(String argID,String argTitle,LocalDate argDateCheckedOut,String argAuthor){
        super(argID,argTitle,argDateCheckedOut);
        this.SetAuthor(argAuthor);
    }

    public Book(String argID,String argTitle,LocalDate argDateCheckedOut,LocalDate argDateReturned,String argAuthor){
        super(argID,argTitle,argDateCheckedOut,argDateReturned);
        this.SetAuthor(argAuthor);
    }

    //set and get methods
    public void SetAuthor(String argAuthor){
        author=argAuthor;
    }

    public String GetAuthor(){
        return author;
    }

    //class methods
    public LocalDate GetDueDate(){
        LocalDate dueDate;
        LocalDate neverDue= LocalDate.of(3000, Month.JANUARY, 1);
        if(super.IsCheckedOut()){
            dueDate=super.GetDateCheckedOut().plus(4,ChronoUnit.WEEKS);
            
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
             fine=period.getDays()*.25;
         }
         return fine;

     }
    
}