package pl.coderslab.controller.pagesControllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.PatientDao;
import pl.coderslab.dao.VisitDao;
import pl.coderslab.model.Patient;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("logged")
public class LoggedController {


    private static final String ADD_PATIENT = "views/addPatient";
    private static final String ALL_PATIENTS = "views/allPatients";
    private static final String ALL_VISITS = "views/allVisits";
    private static final String MY_PROFILE = "views/myProfile";

    private final PatientDao patientDao;
    private final VisitDao visitDao;

    @GetMapping("patient/add")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patientForm", new Patient());
        return ADD_PATIENT;
    }

    @PostMapping("patient/add")
    public String addPatient(@ModelAttribute("patientForm") @Valid Patient patient,
                             BindingResult result) {
        if (result.hasErrors()) {
            return ADD_PATIENT;
        }
        if (patient.getId() != null) {
            patientDao.edit(patient);
        } else {
            patientDao.save(patient);
        }
        return "redirect:/logged/patient/all";
    }

    @GetMapping("patient/all")
    public String showAllPatients(Model model) {
        model.addAttribute("patients", patientDao.findAll());
        return ALL_PATIENTS;
    }

    @GetMapping("visit/all")
    public String showAllVisits(Model model) {
        model.addAttribute("visits", visitDao.findAll());
        return ALL_VISITS;
    }

    @GetMapping("user/profile")
    public String showUserProfile(Model model) {
        model.addAttribute("profile", patientDao.findAll());
        return MY_PROFILE;
    }

}
