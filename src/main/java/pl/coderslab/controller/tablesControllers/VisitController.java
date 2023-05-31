package pl.coderslab.controller.tablesControllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PatientDao;
import pl.coderslab.dao.VisitDao;
import pl.coderslab.model.Patient;
import pl.coderslab.model.Visit;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Book;
import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("logged/patient/logged/visit")
public class VisitController {

    private final VisitDao visitDao;
    private final PatientDao patientDao;
    private static final String ADD_VISIT = "views/addVisit";

//    @GetMapping("/add")
//    public String showAddVisitForm (HttpServletRequest request, Model model) {

////        HttpSession session = request.getSession();
////        Object attributeValue = session.getAttribute("attributeName");
//        VisitDao visitDao = new VisitDao();
//        model.addAttribute("visitForm", new Visit());
//        return ADD_VISIT;
//    }



    @GetMapping("/add/{patientId}")
    public String showAddVisitForm (@PathVariable Long patientId, Model model) {
        Visit visit = new Visit();
        visit.setPatientId(patientId);
        Patient patient = patientDao.findById(patientId);
        System.out.println("PATIENT " + patient);
        String patientDetails = patient.getFirstName() + " " + patient.getLastName();
        visit.setPatientDetails(patientDetails);
        System.out.println(visit.getPatientDetails());
        model.addAttribute("visitForm", visit);
        model.addAttribute("patient", patient);

//        Visit visit = new Visit();
//        PatientDao patientDao = new PatientDao();
//        Patient patient = patientDao.findById(patientId);
//        visit.setPatientId(patientId);
//        visit.setPatientDetails(patient.getFirstName() + " " + patient.getLastName());
//        model.addAttribute("visitForm", visit);
        return ADD_VISIT;
    }

    @PostMapping("/add")
    public String addVisit (@ModelAttribute ("visitForm")  Visit visit,
                            BindingResult result) {

        if (result.hasErrors()) {
            return ADD_VISIT;
        }
        if (visit.getId() != null) {
            visitDao.edit(visit);
        } else {
            visitDao.save(visit);
        }
        return "redirect:/logged/visit/all";
    }

}
