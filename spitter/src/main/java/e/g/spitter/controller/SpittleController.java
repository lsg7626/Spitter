package e.g.spitter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import e.g.spitter.store.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	
	/*@RequestMapping(method=RequestMethod.GET)
	public String spittles(Model model) {
		//model.addAllAttributes(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
		model.addAttribute("spittleList", spittleRepository.recentSpittles());
		return "spittles";
	}*/

	  @RequestMapping(method=RequestMethod.GET)
	  public String spittle(@RequestParam(value="index", defaultValue="1") int index, Model model) {
		  if(index == 1) model.addAttribute("spittleList", spittleRepository.recentSpittles());
		  else model.addAttribute("spittleList", spittleRepository.findSpittles(index));
	    return "spittles";
	  }
	  
	 /* @RequestMapping(value="/{spittleId}", method=RequestMethod.GET) // spittles/show?spittleid=11 => spittles/11
	  public String showSpittle(@PathVariable("spittleId")long spittleId, Model model) {
		  model.addAttribute("spittle", spittleRepository.findOne(spittleId));
		  return "spittle";
	  }*/
	  
	  //가장 깔끔하지만 플레이스홀더 ({, }) 와 파라미터 이름이 반드시 일치해야됨
	  @RequestMapping(value="/{spittleId}", method=RequestMethod.GET) // spittles/show?spittleid=11 => spittles/11
	  public String showSpittle(@PathVariable long spittleId, Model model) {
		  model.addAttribute("spittle", spittleRepository.findOne(spittleId));
		  return "spittle";
	  }
	  
	  
}
