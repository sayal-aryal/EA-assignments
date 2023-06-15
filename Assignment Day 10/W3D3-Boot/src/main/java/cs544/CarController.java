package cs544;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping("/")
	public String redirectRoot() {
		return "redirect:/cars";
	}
	
	@GetMapping("/cars")
	public String getAll(Model model) {
		model.addAttribute("cars", carService.getAll());
		return "carList";
	}
	
	@PostMapping("/cars")
	public String add(@Valid Car car, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.car", result);
			attr.addFlashAttribute("car", car);
			return "redirect:/cars/add";
		} else {
			carService.update(car); // car.id already set by binding
			return "redirect:/cars";
		}
	}

	@GetMapping("/cars/add")
	public String viewAdd(@ModelAttribute Car car, Model model) {
		if(!model.containsAttribute("car")){
			model.addAttribute("car", new Car());
		}
		model.addAttribute("msg", "Add");
		model.addAttribute("action", "/cars");
		return "carDetail";
	}

	@GetMapping("/cars/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		if(!model.containsAttribute("car")){
			model.addAttribute("car", new Car());
		}
		model.addAttribute("car", carService.get(id));
		model.addAttribute("msg", "Update");
		return "carDetail";
	}

	@GetMapping("/cars/{id}")
	public String viewEdit(@PathVariable("id") int id, Model model) {
		try{
			Car car=carService.get(id);
			model.addAttribute("car",car );
			model.addAttribute("msg","Update");
			model.addAttribute("action", "/cars/" + car.getId());
		}catch(Exception e){
			e.printStackTrace();
		}
		return "carDetail";
	}

	@PostMapping("/cars/{id}")
	public String update(@Valid Car car, BindingResult result, RedirectAttributes attr, @PathVariable("id") int id) {
		if (result.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.car", result);
			attr.addFlashAttribute("car", car);
			return "redirect:/cars/{id}/edit";
		} else {
			carService.update(car); // car.id already set by binding
			return "redirect:/cars";
		}
	}
	
	@PostMapping("/cars/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		carService.delete(id);
		return "redirect:/cars";
	}
}
