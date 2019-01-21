package e.g.spitter.controller;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import e.g.spitter.domain.Spitter;
import e.g.spitter.store.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	
	private SpitterRepository spitterRepository;
	
	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	 public String showRegistrationForm(Model model) {
		  model.addAttribute(new Spitter());
		  return "registerForm";
	 }
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processingRegistration(@Valid Spitter spitter, Errors errors, MultipartHttpServletRequest req, RedirectAttributes model) throws IllegalStateException, IOException { // Errors 파라미터가 검증될 @Valid 애너테이션이 붙어있는 파라미터 바로 다음에 있어야함
		if(errors.hasErrors()) {
			return "registerForm";
		}
		spitterRepository.save(spitter);
		String root = req.getSession().getServletContext().getRealPath("\\");
        String url = root+"\\profilePicture\\" + spitter.getUsername() + ".jpg";
        MultipartFile file = req.getFile("profilePicture");
		uploadFile(file, url);
		model.addAttribute("username", spitter.getUsername());
		model.addFlashAttribute("spitter", spitter); // redirect시 username을 키로 넘겨주고  spitter 객체를 값으로 넘겨주어 addFlashAttribute()를 호출
		return "redirect:/spitter/{username}";
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {
		Spitter spitter = spitterRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
	
	private void uploadFile(MultipartFile profilePicture, String url) throws IllegalStateException, IOException {
		System.out.println(url);
		profilePicture.transferTo(new File(url));
	}
}
