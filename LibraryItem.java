import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LibraryItem{
    //instance variables
    private String ID;
    private String title;
    private LocalDate dateCheckedOut;
    private LocalDate dateReturned;

    //default date
    LocalDate defaultDate = LocalDate.of(1900, Month.JANUARY, 1);

    //class constructor
    public LibraryItem(String argID,String argTitle){
        this.SetID(argID);
        this.SetTitle(argTitle);
        this.SetDateCheckedOut(defaultDate);
        this.SetDateReturned(defaultDate);
    }
    public LibraryItem(String argID,String argTitle,LocalDate argDateCheckedOut){
        this.SetID(argID);
        this.SetTitle(argTitle);
        this.SetDateCheckedOut(argDateCheckedOut);
        this.SetDateReturned(defaultDate);
    }
    public LibraryItem(String argID,String argTitle,LocalDate argDateCheckedOut,LocalDate argDateReturned){
        this.SetID(argID);
        this.SetTitle(argTitle);
        this.SetDateCheckedOut(argDateCheckedOut);
        this.SetDateReturned(argDateReturned);
    }

    
    //set and get methods
    public void SetID(String argID){
        ID=argID;
    }
    public void SetTitle(String argTitle){
        title=argTitle;
    }
    public void SetDateCheckedOut(LocalDate argDateCheckedOut){
        dateCheckedOut=argDateCheckedOut;
    }
    public void SetDateReturned(LocalDate argDateReturned){
        dateReturned=argDateReturned;

    }
    public String GetID(){
        return ID;
    }
    public String GetTitle(){
        return title;
    }
    public LocalDate GetDateCheckedOut(){
        return dateCheckedOut;
    }

    public LocalDate GetDateReturned(){
        return dateReturned;
    }

    //method to check if an item is checked out
    public boolean IsCheckedOut(){
        boolean checkedOut=true;

        LocalDate today=LocalDate.now();
        if (this.GetDateCheckedOut().equals(defaultDate)){
            checkedOut=false;
        }
        else if(this.GetDateReturned().equals(defaultDate)){
            checkedOut=true;
        }
        else if(this.GetDateReturned().compareTo(today)<0){
            checkedOut=false;
        }
        return checkedOut;
    }


}