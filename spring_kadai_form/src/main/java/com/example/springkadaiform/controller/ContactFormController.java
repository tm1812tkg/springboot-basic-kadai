package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {

	@GetMapping("/form")
	public String showForm(ContactForm contactForm) {
		return "contactFormView";
	}

	@PostMapping("/confirm")
	public String confirm(
			@Validated ContactForm contactForm,
			BindingResult bindingResult) {

		// バリデーションNG → フォームに戻す
		if (bindingResult.hasErrors()) {
			return "contactFormView";
		}

		// OK → 確認画面へ
		return "confirmView";
	}
}