package com.study.springrest.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.study.springrest.domain.RestVO;
import com.study.springrest.service.RestService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/rest")
public class Rest {
	
	private static final Logger logger = LoggerFactory.getLogger(Rest.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Inject
	private RestService service;
	
	// 				/¿Ø¥÷/ ∏Ò∑œ
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView list(Locale locale, Model model) {
		ModelAndView aaa = new ModelAndView();
		aaa.setViewName("list");
		List<RestVO> list = service.getList();
		aaa.addObject("list", list);
		return aaa;
	}
	
	// 				/¿Ø¥÷/	±€π¯»£
	@RequestMapping(value = "/{board_no}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("board_no") Integer board_no) {
		ModelAndView aaa = new ModelAndView();
		aaa.setViewName("detail");
		RestVO vo = service.get(board_no);
		aaa.addObject("vo", vo);
		return aaa;
	}
	
	
	// /¿Ø¥÷/new ±€æ≤±‚ ∆‰¿Ã¡ˆ
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView write(){
		return new ModelAndView("write");
	}
	
	// /¿Ø¥÷/ method=post
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView insert(RestVO vo) {
		service.insert(vo);
		return new ModelAndView("redirect:/rest");
	}
	
	// /¿Ø¥÷/π¯»£ ªË¡¶ method=post
	@RequestMapping(value = "/{board_no}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable("board_no") Integer board_no){
		System.out.println("asdfjhsadfhsadjkfhasdfjkasdhfjkasdhfjkafhjkasdfhkjasdfhaskjlf");
		service.delete(board_no);
		return new ModelAndView("redirect:/rest");
	}
}
