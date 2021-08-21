package com.group3.fundmgt.position;

import com.group3.fundmgt.Securities.Security;
import com.group3.fundmgt.Securities.SecurityRepository;
import com.group3.fundmgt.exception.BadRequestException;
import com.group3.fundmgt.exception.NotFoundException;
import com.group3.fundmgt.manager.Manager;
import com.group3.fundmgt.manager.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PositionService {


    private final PositionRepository positionRepository;
    private final SecurityRepository securityRepository;


    @Autowired
    public PositionService(PositionRepository positionRepository,SecurityRepository securityRepository) {
        this.positionRepository = positionRepository;
        this.securityRepository=securityRepository;
    }

    public List<Position> getPositionsByFundID(Long fundID){
        return positionRepository.getPositionByFundID(fundID);
    }

    public Position getPosition(Long id){
        Optional<Position> position = positionRepository.findById(id);
        //查Position是否存在
        if(position.isEmpty()){
            throw new NotFoundException("Position with position id " + id + " not found.");
        }
        return position.get();
    }

    public void addPosition(Position position){

        //查security是否存在
        Optional<Security> security=securityRepository.findSecuritiesBySymbol(position.getSecuritySymbol());
        if(security.isEmpty()){
            throw new BadRequestException("security with symbol "+position.getSecuritySymbol()+" not found");
        }
        positionRepository.save(position);
//        String symble=securityRepository.getById()
//        if(position.getSecuritySymbol())

    }

    public void deletePosition(Long id){
        if(positionRepository.existsById(id)){
            positionRepository.deleteById(id);
        }
        else{
            throw new NotFoundException("Position with position id " + id + " not found.");
        }
    }

    @Transactional
    public void updatePosition(Long id, Position updatePosition){
        Optional<Position> positionOptional = positionRepository.findById(id);
        if(positionOptional.isEmpty()){
            throw new NotFoundException("Position with position id " + id + " not found.");
        }
        Position position=positionOptional.get();
        //check id
        if (updatePosition.getId() != null && updatePosition.getId() != position.getId()){
            //TODO USe custom exception.
            throw new IllegalStateException("Position ID in path and in request body are different.");
        }

        //securitySymble
        if (updatePosition.getSecuritySymbol() != null &&
                !Objects.equals(updatePosition.getSecuritySymbol(), position.getSecuritySymbol()) &&
                updatePosition.getSecuritySymbol().length() > 0){
            position.setSecuritySymbol(updatePosition.getSecuritySymbol());
        }
        //quantity
        position.setQuantity(updatePosition.getQuantity());
        //purchase date
        position.setDatePurchased(updatePosition.getDatePurchased());
    }
}
