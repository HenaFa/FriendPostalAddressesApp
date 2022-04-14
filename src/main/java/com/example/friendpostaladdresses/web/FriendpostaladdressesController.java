package com.example.friendpostaladdresses.web;

import java.util.List;
import java.util.Optional;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.friendpostaladdresses.domain.Friend;
import com.example.friendpostaladdresses.domain.FriendRepository;

@CrossOrigin
@Controller
public class FriendpostaladdressesController {
	@Autowired
	private FriendRepository frepository;

	// listaa
	@RequestMapping(value = { "/", "/friendlist" })
	public String friendList(Model model) {
		model.addAttribute("friends", frepository.findAll());
		System.out.println("FINALLY WORKING");
		return "Friendlist";
	}

	/*
	 * // Listaa kaikki kirjat REST avulla
	 * 
	 * @RequestMapping(value = "/friends", method = RequestMethod.GET)
	 * public @ResponseBody List<Friend> friendListRest() {
	 * return (List<Friend>) frepository.findAll();
	 * }
	 * 
	 * // Listaa kirja RESTful ja ID avulla
	 * 
	 * @RequestMapping(value = "/friend/{id}", method = RequestMethod.GET)
	 * public @ResponseBody Optional<Friend> findFriendRest(@PathVariable("id") Long
	 * friendId) {
	 * return frepository.findById(friendId);
	 * }
	 */
	// lisää kirja
	@RequestMapping(value = "/add")
	public String addFriend(Model model) {
		model.addAttribute("friend", new Friend());
		return "addFriend";
	}

	// tallentaa
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Friend friend) {
		System.out.println("TEST" + friend);
		frepository.save(friend);
		return "redirect:friendlist";
	}

	// delete
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteFriend(@PathVariable("id") Long friendId, Model model) {
		frepository.deleteById(friendId);
		return "redirect:../friendlist";
	}

	// edittaus
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editFriend(@PathVariable("id") Long friendId, Model model) {
		System.out.println("I GOT HERE");
		model.addAttribute("friend", frepository.findById(friendId));
		return "editFriend.html";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login_success_handler")
	public String loginSuccessHandler(Model model) {
		model.addAttribute("friends", frepository.findAll());
		System.out.println("Logging user login success...");

		return "Friendlist";
	}

	@PostMapping("/login_failure_handler")
	public String loginFailureHandler() {
		System.out.println("Login failure handler....");

		return "login";
	}

}
