package com.group3.fundmgt.position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position,Long> {
    @Query("SELECT p from Position p where p.fund.fundId=?1")
    public List<Position> getPositionByFundID(Long fundID);
}
