package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.entity.Topico;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
@RequestMapping(path = "topicos")
public class TopicoController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@GetMapping
	public List<Topico> todosOsTopicos(){
		return topicoRepository.findAll();
	}
	
	@GetMapping("porTituloJPQL")
	public List<Topico> todosOsTopicosJQPL(String titulo){
		return topicoRepository.topicoPorTituloJPQL(titulo);
	}
	
	@GetMapping("porTituloSQL")
	public List<Topico> todosOsTopicosSQL(String titulo){
		return topicoRepository.topicoPorTituloSQL(titulo);
	}
	
	@GetMapping("porTitulo")
	public List<Topico> todosOsTopicosPorTitulo(String titulo){
		return topicoRepository.findByTitulo(titulo);
	}
	
}
