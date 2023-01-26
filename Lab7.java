import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Lab7{
    public static void main(String[] args){
         //create a LocalDateTime object and assign it to a LocalDate object
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDate date1=currentTime.toLocalDate();
        LocalDate date2=date1.plus(1, ChronoUnit.MONTHS);
        LocalDate date3=date1.plus(5,ChronoUnit.MONTHS);
        LocalDate date4=date1.plus(1,ChronoUnit.WEEKS);
        LocalDate date5=date1.plus(3,ChronoUnit.WEEKS);
        LocalDate date6=date1.minus(3,ChronoUnit.WEEKS);
        LocalDate date7=date1.minus(2,ChronoUnit.MONTHS);
        LocalDate date8=date1.minus(1,ChronoUnit.MONTHS);

        ArrayList<LibraryItem> itemList=new ArrayList<LibraryItem>();
        ArrayList<Book> bookList=new ArrayList<Book>();
        ArrayList<Dvd> dvdList=new ArrayList<Dvd>();

        //create LibraryItem objects using the two constructors
        LibraryItem item1=new LibraryItem("123CS","Java");
        itemList.add(item1);
        LibraryItem item2=new LibraryItem("145CS","C#",date1);
        itemList.add(item2);
        LibraryItem item3=new LibraryItem("190ART","Art History",date1,date5);
        itemList.add(item3);
        LibraryItem item4=new LibraryItem("180ART","Art World",date4,date6);
        itemList.add(item4);
        Book item5=new Book("269COOK","Breakfast Recipes","Jones");
        bookList.add(item5);
        Book item6=new Book("200COOK","Today's Recipes",date6,"Lukas");
        bookList.add(item6);
        Book item7=new Book("269COOK","Breakfast Recipes",date7,date1,"Aaron");
        bookList.add(item7);
        Book item8=new Book("211COOK","Baking",date6,date3,"Aaron");
        bookList.add(item8);
        Dvd item9=new Dvd("tre325","Stars","PG");
        dvdList.add(item9);
        Dvd item10=new Dvd("iyo383","Song in the Mourning",date6,"PG-13");
        dvdList.add(item10);
        Dvd item11=new Dvd("khh234","Two Lands",date7, date1, "PG");
        dvdList.add(item11);
        Dvd item12=new Dvd("ity667","Fall",date6, date4,"G");
        dvdList.add(item12);



        //test the IsCheckedOut method
        for(LibraryItem item: itemList){

             System.out.println( item.GetTitle()+" is checked out:"+item1.IsCheckedOut());
        }
        for(Book b:bookList){
              System.out.println( b.GetTitle()+" is checked out:"+b.IsCheckedOut()+" ; due date :" +b.GetDueDate() +" and the item is overdue : " +b.IsOverdue()+
             " and the fine is :"+ b.GetFine());

        }
       for(Dvd d:dvdList){
             System.out.println( d.GetTitle()+" is checked out:"+d.IsCheckedOut()+" ; due date :" +d.GetDueDate() +" and the item is overdue : " +d.IsOverdue()+
             " and the fine is :"+ d.GetFine());
       }
       
    }
}