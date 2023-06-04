package pl.coderslab.controller.tablesControllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PatientDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.VisitDao;
import pl.coderslab.dto.UserDTO;
import pl.coderslab.model.Patient;
import pl.coderslab.model.User;
import pl.coderslab.model.Visit;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.faces.context.FacesContext;
import java.awt.print.Book;
import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("logged/patient/logged/visit")
public class VisitController {

    private final VisitDao visitDao;
    private final PatientDao patientDao;
    private final UserDao userDao;
    @Autowired
    private final HttpServletRequest request;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    HttpSession session;
    @Autowired
    private final UserDTO userDTO;
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
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("loggedUser");
        Long id = userDTO.getId();
//        String login = (String) session.getAttribute("loggedUser");

        User user = userDao.findById(id);



        Visit visit = new Visit();
        visit.setPatientId(patientId);
        Patient patient = patientDao.findById(patientId);
        String patientDetails = patient.getFirstName() + " " + patient.getLastName();
        String doctorDetails = user.getFirstName() + " " + user.getLastName();

        visit.setPatientDetails(patientDetails);
        visit.setDoctorDetails(doctorDetails);
        System.out.println(visit.getPatientDetails());
        model.addAttribute("visitForm", visit);
        model.addAttribute("patient", patient);
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

    @GetMapping("/delete/{id}")
    public String deleteVisit (@PathVariable Long id) {
        Visit visit = new Visit();
        visit.setId(id);
        visitDao.delete(visit);
        return "redirect:/logged/visit/all";
    }

    @ModelAttribute("users")
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

}
