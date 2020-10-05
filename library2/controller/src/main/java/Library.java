import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Library {
    @Getter
    @Setter
    @NonNull
    private   int id;

    @Getter
    @Setter
    private   String name;




}
