package com.group3.fundmgt.Securities;

import com.group3.fundmgt.position.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Integer> {
    @Query(value = "SELECT s FROM Security s WHERE symbol=?1")
    public Optional<Security> findSecuritiesBySymbol(String symbol);
}
