package br.com.brasfoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.brasfoot.dao.PersonRepository;

// * ---------------------------------------------------------------------- * //

@Controller
public class PersonController {
  @Autowired
  PersonRepository repository;
}
