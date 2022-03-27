package principal;

import controller.ChamadoController;
import controller.ColaboradorController;
import controller.VeiculoController;
import models.Chamado;
import models.Colaborador;
import models.Veiculo;

public class Principal {

	public static void main(String[] args) {

		testeColaborador();
		testeChamado();
		testeVeiculo();
	}

	public static void testeColaborador() {
		Colaborador c1 = new Colaborador();
		c1.setId(1);
		c1.setNome("Maria Eduarda");
		c1.setCpf("123.123.123-45");
		c1.setEndereco("Rua Metrópole, 255");

		Colaborador c2 = new Colaborador();
		c2.setId(2);
		c2.setNome("Afonso da Silva");
		c2.setCpf("123.456.789-10");
		c2.setEndereco("Rua 15 de Março, 1600");

		ColaboradorController controller = new ColaboradorController();
		try {
			controller.salvar(c1);
			controller.salvar(c2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for (Colaborador c : controller.listar()) {
			System.out.println(c.toString());
		}
	}

	public static void testeVeiculo() {
		Veiculo v1 = new Veiculo();
		v1.setId(1);
		v1.setPlaca("AEJ3333");
		v1.setAutonomiaLitro(14);
		v1.setDisponibilidade(true);

		Veiculo v2 = new Veiculo();
		v2.setId(2);
		v2.setPlaca("LIL3535");
		v2.setAutonomiaLitro(12);
		v2.setDisponibilidade(true);

		VeiculoController controller = new VeiculoController();
		try {
			controller.salvar(v1);
			controller.salvar(v2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for (Veiculo v : controller.listar()) {
			System.out.println(v.toString());
		}
	}
	
	public static void testeChamado() {
		Veiculo v1 = new Veiculo();
		v1.setAutonomiaLitro(10);
		
		Chamado chamado1 = new Chamado(15d, v1); 
		
		chamado1.setNumeroProtocolo(1);
		chamado1.setEnderecoAtendimento("Rua Metrópole, 255");
		
		Veiculo v2 = new Veiculo();
		v2.setAutonomiaLitro(11);

		Chamado chamado2 = new Chamado(13d, v2); 
		chamado2.setNumeroProtocolo(2);
		chamado2.setEnderecoAtendimento("Rua 15 de Março, 1600");

		ChamadoController controller = new ChamadoController();

		try {
			controller.salvar(chamado1);
			controller.salvar(chamado2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		for (Chamado chamado : controller.listar()) {
			System.out.println(chamado.toString());
		}
	}

}
