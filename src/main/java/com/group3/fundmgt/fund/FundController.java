package com.group3.fundmgt.fund;

import com.group3.fundmgt.manager.Manager;
import com.group3.fundmgt.position.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/funds")
public class FundController {
    private final FundService fundService;

    @Autowired
    public FundController(FundService fundService) {
        this.fundService = fundService;
    }

    // 1.查：获取所有数据
    @GetMapping
    public List<Fund> getFund(){return fundService.getFund();}

    // 2.查：根据id查询记录
    @GetMapping(value = "{fundId}")
    public Fund getFund(@PathVariable("fundId") Long fundId){
        System.out.println(fundService.getFund(fundId).toString());
        return fundService.getFund(fundId);
    }

    // 3.增加记录
    @PostMapping
    public void addFund(@RequestBody Fund fund){

        System.out.println(fund.toString());
        fundService.addFund(fund);
    }


    // 4.根据id，删除记录
    @DeleteMapping(value = "{fundId}")
    public void deleteById(@PathVariable("fundId") Long fundId){
         fundService.deleteById(fundId);
    
    }

    @PutMapping("{fundId}")
    public void updateFund(@PathVariable("fundId") Long id,
                              @RequestBody Fund fund) {
        fundService.updateFund(id, fund);
    }
}
