package przyklad1;
import java.util.Date;
import java.sql.Timestamp;

public class MailGenerator {
    public String MailGenerator(String Imie, String Nazwisko){
        Date date= new Date();

        long time = date.getTime();
        return(Imie+"."+Nazwisko+"."+time+"@"+"wp.pl");
    }
}



