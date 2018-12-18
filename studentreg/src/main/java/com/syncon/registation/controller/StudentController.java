package com.syncon.registation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.syncon.registation.model.Student;
import com.syncon.registation.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private IStudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView load() {

		ModelAndView view = new ModelAndView("saveReg");
		List<Student> stulist = studentService.findAll();
		view.addObject("list", stulist); // list is key which will configured in jsp table.
		return view;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Student student) {
		System.out.println("Calling Save student method..");
		System.out.println(student);
		ModelAndView view = new ModelAndView("saveReg");
		Integer idVal = student.getId();
		try {
			studentService.save(student);	
			if(idVal == null) {
				view.addObject("message", "Successfully Saved student...");
			}else {
				view.addObject("message", "Updated successfully student...");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			view = new ModelAndView("editReg");
			view.addObject("errorMessage", e.getMessage());
			view.addObject("student", student);
		}

		List<Student> stulist = studentService.findAll();
		view.addObject("list", stulist); // list is key which will configured in jsp table.
		return view;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(value = "id", required = true) int id) {
		Student stu = studentService.findById(id);
		ModelAndView modelView = new ModelAndView("editReg");
		modelView.addObject("student", stu);
		List<Student> stulist = studentService.findAll();
		modelView.addObject("list", stulist);
		return modelView;
	}

	@RequestMapping(value = "/delete/{idVal}")
	public ModelAndView delete(@PathVariable(value = "idVal") int id) {
		ModelAndView view = new ModelAndView("saveReg");
		try{
			int val =studentService.delete(id);
			view.addObject("message", "Successfully deleted student with id : " + id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			view.addObject("errorMessage",e.getMessage());
		}
		List<Student> stulist = studentService.findAll();
		view.addObject("list", stulist);
		return view;
	}
}
 