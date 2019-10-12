package com.syncon.registation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private Logger logger = LoggerFactory.getLogger(StudentController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView load() {
		
		
		logger.info("Calling load method....");
		logger.info("Calling load method Git Hub....");
		logger.info("Calling load method Git Hub 3....");
		logger.info("Calling load method Git Hub 4....");
		
		ModelAndView view = new ModelAndView("saveReg");
		List<Student> stulist = studentService.findAll();
		view.addObject("list", stulist); // list is key which will configured in jsp table.
		return view;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Student student) {
		logger.info("Calling Save student method..");
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
			logger.error(e.getMessage());
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
		logger.info("Calling edit method..");
		Student stu = studentService.findById(id);
		ModelAndView modelView = new ModelAndView("editReg");
		modelView.addObject("student", stu);
		List<Student> stulist = studentService.findAll();
		modelView.addObject("list", stulist);
		return modelView;
	}

	@RequestMapping(value = "/delete/{idVal}")
	public ModelAndView delete(@PathVariable(value = "idVal") int id) {
		logger.info("Calling delete method....");
		ModelAndView view = new ModelAndView("saveReg");
		try{
			int val =studentService.delete(id);
			view.addObject("message", "Successfully deleted student with id : " + id);
		}catch(Exception e) {
			logger.error(e.getMessage());
			view.addObject("errorMessage",e.getMessage());
		}
		List<Student> stulist = studentService.findAll();
		view.addObject("list", stulist);
		return view;
	}
}
 