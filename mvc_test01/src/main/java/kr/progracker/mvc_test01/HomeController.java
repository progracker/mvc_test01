package kr.progracker.mvc_test01;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.progracker.mvc_test01.dao.UserDaoImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@RequestMapping("/join.pro")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView("main");
		mav.setViewName("user/joinForm");
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "test");
		map.put("password", "1234");
		
		if(userDaoImpl.getLoginResult(map) == 1) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		
		return mav;
	}
	
}
