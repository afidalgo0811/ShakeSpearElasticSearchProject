package resource;

import model.ShakeSpearModel;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@ComponentScan
@RestController
@RequestMapping("/shakespeare")
public class ShakeSpearController {


    @GetMapping("/{id}")
    public ShakeSpearModel getInfo(@PathVariable("id") final int id){

        ShakeSpearModel shakeSpearModel = new ShakeSpearModel();
        shakeSpearModel.setLine_id(id);
        return shakeSpearModel;
    }
}
