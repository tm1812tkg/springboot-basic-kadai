package com.example.springkadaiform.controller;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {

	@GetMapping("/form")
	public String showForm(Model model) {
		if (!model.containsAttribute("contactForm")) {
            // ビューにフォームクラスのインスタンスを渡す
            model.addAttribute("contactForm", new ContactForm());
        }
		return "contactFormView";
	}

	@PostMapping("/confirm")
	public String confirm(
			Model model,
			@Validated ContactForm contactForm,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		// バリデーションNG → フォームに戻す
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("contactForm", contactForm);
			// バリデーション結果をビューに受け渡す
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX
					+ Conventions.getVariableName(contactForm), bindingResult);

			return "redirect:/form";

		}
		
		model.addAttribute("contactForm", contactForm);
		// OK → 確認画面へ
		return "confirmView";
	}
}