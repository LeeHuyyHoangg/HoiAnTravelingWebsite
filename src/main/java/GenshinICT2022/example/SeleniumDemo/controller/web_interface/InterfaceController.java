package GenshinICT2022.example.SeleniumDemo.controller.web_interface;

import GenshinICT2022.example.SeleniumDemo.service.WebNewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "http://localhost:8081")
@Controller
@RequiredArgsConstructor
public class InterfaceController {
    private final WebNewService webNewService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("articles", webNewService.getNewList());
        return "index";
    }

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("articles", webNewService.getNewList());
        return "index";
    }

    @RequestMapping("/hoiAn360")
    public String hoiAn360(){
        return "hoiAn360";
    }

    @RequestMapping("/destination")
    public String destination(){
        return "destination";
    }

    @RequestMapping("/cuisine")
    public String cuisine(){
        return "cuisine";
    }
}
