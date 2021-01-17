import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class parser {
    final String prefix = "ASLIAG_";
    final String dataStr;
    String[] data ;

    public parser(String[] data){
        this.data = data;
        dataStr = new SimpleDateFormat("yyyymmdd").format(new Date());
    }

    public String parseToString(){
        StringBuilder sb = new StringBuilder();
        for (String d:data) {
            StringBuilder s = new StringBuilder(prefix);
            for (int i = d.length() -1  ; i>-1 ; i--){
                Character c = d.charAt(i);
                if(!Character.isDigit(c))
                    s.append(c.toString().toUpperCase());
            }
            s.append(dataStr);
            sb.append(s.toString() + "\n");
        }
        return sb.toString() + "  ";
    }

    private String eraseNumeric(String string){
        return string.replaceAll("[0123456789]","");
    }

}
