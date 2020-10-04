import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Autor {

    @Getter
    @Setter
    public String name;
    @Getter
    @Setter
    public int id;

}
