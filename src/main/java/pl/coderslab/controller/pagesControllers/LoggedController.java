package pl.coderslab.controller.pagesControllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.PatientDao;
import pl.coderslab.dao.VisitDao;
import pl.coderslab.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("logged")
public class LoggedController {

    @Autowired
    HttpSession session;
    @Autowired
    private final HttpServletRequest request;
    private static final String ALL_PATIENTS = "views/allPatients";
    private static final String ALL_VISITS = "views/allVisits";
    private static final String MY_PROFILE = "views/myProfile";

    private final PatientDao patientDao;
    private final VisitDao visitDao;



    @GetMapping("patient/all")
    public String showAllPatients(Model model) {
        model.addAttribute("patients", patientDao.findAll());
        return ALL_PATIENTS;
    }

    @GetMapping("visit/all") //wszystkie wizyty zalogowanego użytkownika
    public String showAllVisits(Model model) {
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("loggedUser");
        Long id = userDTO.getId();
        model.addAttribute("visits", visitDao.findAllByUserID(id));
        return ALL_VISITS;
    }

    @GetMapping("user/profile")
    public String showUserProfile(Model model) {
        model.addAttribute("profile", patientDao.findAll());
        return MY_PROFILE;
    }

}
