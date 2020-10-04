import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book {
    public int id;
    public String name;
    public int authorId;


}
