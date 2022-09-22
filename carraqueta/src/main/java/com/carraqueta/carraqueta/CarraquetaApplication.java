package com.carraqueta.carraqueta;

import com.carraqueta.carraqueta.entity.Locacao;
import com.carraqueta.carraqueta.entity.Veiculo;
import com.carraqueta.carraqueta.enumeration.EnumMarca;
import com.carraqueta.carraqueta.service.LocacaoService;
import com.carraqueta.carraqueta.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class CarraquetaApplication {
	@Autowired
	VeiculoService veiculoService;

	@Autowired
	LocacaoService locacaoService;

	public static void main(String[] args) {
		SpringApplication.run(CarraquetaApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void tudoDandoCertoListagem() {
		Veiculo veiculo1 = new Veiculo("Modelo 1", EnumMarca.FORD,"ASD12D3",2010);
		Veiculo veiculo2 = new Veiculo("Modelo 2", EnumMarca.RENAULT,"ASD12D4",2010);
		Veiculo veiculo3 = new Veiculo("Modelo 3", EnumMarca.TOYOTA,"ASD12D5",2010);
		Veiculo veiculo4 = new Veiculo("Modelo 4", EnumMarca.FORD,"ASD12D6",2010);
		Veiculo veiculoNaoLocado = new Veiculo("Modelo 4", EnumMarca.FORD,"ASD12D7",2010);

		veiculoService.cadatrar(veiculo1);
		veiculoService.cadatrar(veiculo2);
		veiculoService.cadatrar(veiculo3);
		veiculoService.cadatrar(veiculo4);
		veiculoService.cadatrar(veiculoNaoLocado);

		Locacao locacaoVeiculo1 = new Locacao("Nome1","11111111111", LocalDateTime.now(), BigDecimal.valueOf(1000),veiculo1);
		Locacao locacaoVeiculo2 = new Locacao("Nome2","22222222222", LocalDateTime.now(), BigDecimal.valueOf(1000),veiculo2);
		Locacao locacaoVeiculo3 = new Locacao("Nome3","33333333333", LocalDateTime.now(), BigDecimal.valueOf(1000),veiculo3);
		Locacao locacaoVeiculo4 = new Locacao("Nome4","44444444444", LocalDateTime.now(), BigDecimal.valueOf(1000),veiculo4);

		locacaoService.locar(locacaoVeiculo1);
		locacaoService.locar(locacaoVeiculo2);
		locacaoService.locar(locacaoVeiculo3);
		locacaoService.locar(locacaoVeiculo4);

		locacaoService.retornar(locacaoVeiculo3);


	}
	private void cadastrarVeiculos(){

	}

}
