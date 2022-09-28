package com.projeto.sustentaculo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.sustentaculo.domain.Chamado;
import com.projeto.sustentaculo.repositories.ChamadoRepository;
import com.projeto.sustentaculo.services.exceptions.ObjectnotFoundException;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;

	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontradao! ID: " + id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

}
