package GenshinICT2022.example.SeleniumDemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
public class VnExpressNew {
    private String title;
    private String link;
    private String description;
    private String imageLink;
    private Date date;

    public String getMonth(){
        return new SimpleDateFormat("MMMM").format(date);
    }

    public String getDay(){
        return new SimpleDateFormat("dd").format(date);
    }
}
