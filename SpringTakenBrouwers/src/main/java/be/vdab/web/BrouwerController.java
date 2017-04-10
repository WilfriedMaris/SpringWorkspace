package be.vdab.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BEGIN_NAAM_VIEW = "brouwers/beginnaam";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private static final String ALFABET_VIEW = "brouwers/opalfabet";
	private final static String REDIRECT_NA_TOEVOEGEN = "redirect:/";
	private final BrouwerService brouwerService;
	private final char[] alfabet = new char['Z' - 'A' + 1];
	// new char[90 - 65 + 1] = 26 
	
	public BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
		for(char letter = 'A'; letter <= 'Z' ; letter++){
			alfabet[letter - 'A'] = letter;
		}
		// als de letter kleiner is in ACII dan 'Z' gaan we na de lus, letter + 1 doen
		//in de lus doen we alfabet[ASCIIwaarde van letter - ASCIIwaarde'A'] = letter
	}
	
	@InitBinder("brouwer")
	void initBinderAdres(WebDataBinder binder){
		binder.initDirectFieldAccess();
	}

	@GetMapping
	ModelAndView brouwers(){
		return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
	}
	
	@GetMapping("beginnaam")
	ModelAndView beginNaamForm(){
		return new ModelAndView(BEGIN_NAAM_VIEW).addObject(new BeginNaamForm());
	}
	
	@GetMapping(params = "beginnaam")
	ModelAndView beginNaam(@Valid BeginNaamForm form, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView(BEGIN_NAAM_VIEW);
		if(! bindingResult.hasErrors()){
			modelAndView.addObject("brouwers", brouwerService.findByNaam(form.getBeginnaam()));
		}
		return modelAndView;
	}	
	
	@GetMapping("toevoegen")
	ModelAndView toevoegenForm(){
		return new ModelAndView(TOEVOEGEN_VIEW).addObject(new Brouwer());
	}
	
	@GetMapping("opalfabet")
	ModelAndView opalfabetForm(){
		return new ModelAndView(ALFABET_VIEW, "alfabet", alfabet);
	}
	
	@GetMapping(params = "letter")
	ModelAndView opalfabet(@RequestParam char letter){
		return new ModelAndView(ALFABET_VIEW)
				.addObject("alfabet", alfabet)
				.addObject("brouwers", brouwerService.findByNaam(String.valueOf(letter)));
	}
	
	@PostMapping
	String toevoegen(@Valid Brouwer brouwer, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return TOEVOEGEN_VIEW;
		}
		brouwerService.create(brouwer);
		return REDIRECT_NA_TOEVOEGEN;
	}
	
}