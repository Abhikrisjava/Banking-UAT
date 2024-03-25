@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private double balance;
    // Other properties, getters, and setters
}

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // Custom queries if needed
}
