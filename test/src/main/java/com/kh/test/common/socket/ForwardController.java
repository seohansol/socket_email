package com.kh.test.common.socket;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForwardController {
	
	@GetMapping("test-page")
	public ResponseEntity<?> testPage() {
		return null;
	}
	
	@GetMapping("group")
	public ResponseEntity<?> groupPage(){
		return null;
	}

}
