package pl.coderslab.controller.tablesControllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PatientDao;
import pl.coderslab.model.Patient;
import pl.coderslab.model.Visit;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("logged/patient")
public class PatientController {

    private static final String ADD_PATIENT = "views/addPatient";
    private final PatientDao patientDao;
    @GetMapping("add")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patientForm", new Patient());
        return ADD_PATIENT;
    }

    @PostMapping("add")
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

    @GetMapping("/logged/patient/delete/{id}")
    public String deleteVisit (@PathVariable Long id) {
        Patient patient = new Patient();
        patient.setId(id);
        patientDao.delete(patient);
        return "redirect:/logged/patient/all";
    }
}
