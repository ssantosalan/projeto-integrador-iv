package com.projeto.sustentaculo.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto.sustentaculo.domain.Chamado;
import com.projeto.sustentaculo.domain.Cliente;
import com.projeto.sustentaculo.domain.Tecnico;
import com.projeto.sustentaculo.domain.enums.Perfil;
import com.projeto.sustentaculo.domain.enums.Prioridade;
import com.projeto.sustentaculo.domain.enums.Status;
import com.projeto.sustentaculo.repositories.ChamadoRepository;
import com.projeto.sustentaculo.repositories.PessoaRepository;

@Service
public class DBService {

	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Alan No Zera", "550.482.150-95", "alan@gmail.com", encoder.encode("456"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Cauê Mandrake", "903.347.070-56", "caue@gmail.com", encoder.encode("456"));
		Tecnico tec3 = new Tecnico(null, "Rôaquático", "271.068.470-54", "ro@gmail.com", encoder.encode("456"));
		Tecnico tec4 = new Tecnico(null, "Idas, O Gô", "162.720.120-39", "idalgo@gmail.com", encoder.encode("456"));
		Tecnico tec5 = new Tecnico(null, "Solla Sola O Mento", "778.556.170-27", "solla@gmail.com", encoder.encode("456"));
		Tecnico tec6 = new Tecnico(null, "Jorginho Gamer Rx", "111.661.890-74", "jorge.sol@gmail.com", encoder.encode("456"));

		Cliente cli1 = new Cliente(null, "Jorginho Gamer Rx", "111.661.890-74", "jorge.sol.cli@gmail.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Marie Curie", "322.429.140-06", "curie@mail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Max Planck", "081.399.300-83", "planck@mail.com", encoder.encode("123"));
 
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
		Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cli3);
		Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
		Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 7", "Teste chamado 6", tec1, cli5);

		pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
	}
}
