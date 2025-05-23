package App.repository;

import App.model.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author
 */
@Repository
public interface TraderRepository extends JpaRepository<Trader, String> {
    Optional<Trader> findBytrader(String trader);
}
