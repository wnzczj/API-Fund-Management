package com.group3.fundmgt.position;

import com.group3.fundmgt.exception.BadRequestException;
import com.group3.fundmgt.manager.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping
    public void addPosition(@RequestBody Position position){
        if(position.getQuantity()<=0){
            throw new BadRequestException("quantity can't be negative");
        }
        positionService.addPosition(position);
    }

    @GetMapping
    public List<Position> getPositionsByFundID(@RequestParam Long fundID){
        List<Position> positions=positionService.getPositionsByFundID(fundID);
//        for(Position p:positions){
//            System.out.println(p.toString());
//        }
        return positions;
    }

    @GetMapping(path="{positionId}")
    public Position getPositions(@PathVariable("positionId") Long id){
        Position position=positionService.getPosition(id);
        System.out.println(position.toString());
        return position;
    }

    @DeleteMapping(path="{positionId}")
    public void deletePosition(@PathVariable("positionId") Long id){
        System.out.println("delete");
        positionService.deletePosition(id);
    }

    @PutMapping("{positionId}")
    public void updatePosition(@PathVariable("positionId") Long positionId,
                              @RequestBody Position position) {
        if(position.getQuantity()<=0){
            throw new BadRequestException("quantity can't be negative");
        }
        positionService.updatePosition(positionId, position);
    }
}
