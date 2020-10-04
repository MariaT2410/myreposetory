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

    @Override public String toString() {
        return String.format("%s (age: %d)", name, id);
    }


}
