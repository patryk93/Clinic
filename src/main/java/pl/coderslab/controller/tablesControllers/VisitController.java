package pl.coderslab.controller.tablesControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.VisitDao;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("logged/visit")
public class VisitController {

    private static final String ADD_VISIT = "views/addVisit";
    @GetMapping("/add")
    public String showAddVisitForm (Model model) {
        VisitDao visitDao = new VisitDao();
        model.addAttribute("visitForm", visitDao);
        return ADD_VISIT;
    }



//    @GetMapping("/addVisit/{patientId:[0-9]+}")
//    public String showAddVisitForm (@PathVariable Long patientId, Model model) {
//        VisitDao visitDao = new VisitDao();
//        visitDao.(patientId);
//        model.addAttribute("visitForm", visitDao);
//        return "Add_Visit_Form";
//    }
//    @PostMapping("/addVisit")
//    public String addVisit (@ModelAttribute("visitForm") @Valid VisitDTO form,
//                            BindingResult result) {
//        if (result.hasErrors()) {
//            return "Add_Visit_Form";
//        }
//        addVisitService.addVisit(form);
//        return "redirect:/visit/allVisits";
//    }
}
