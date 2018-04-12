import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.opet.util.Reader;

public class Main {

	public static ArrayList<ContaCorrente> listCliente = new ArrayList<>();

	public static ArrayList<ContaPoupanca> clientePoupanca = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);

		int op = -1;
		boolean aux = true;

		while (op != 0) {

			System.out.println("\t-------------------");
			System.out.println("\t      MENU         ");
			System.out.println("\t--------------------");
			System.out.println("_____________________________________________");
			System.out.println("|\tDIGITE [1] PARA CADASTRAR CONTA      |");
			System.out.println("|\tDIGITE [2] PARA LISTAR CONTA CORRENTE|");
			System.out.println("|\tDIGITE [3] PARA DELETAR UMA CONTA    |");
			System.out.println("|\tDIGITE [4] PARA EDITAR CONTA         |");
			System.out.println("|\tDIGITE [5] PARA FAZER OUTRA OPERAÇÃO |");
			System.out.println("|\tDIGITE [6] PARA LISTAR CONTA POUPANÇA|");
			System.out.println("|\tDIGITE [0] PARA SAIR                 | ");
			System.out.println("|____________________________________________|");
			try {
				System.out.println("INFORME OPERAÇÃO ");
				op = Reader.readInt();
			} catch (NumberFormatException e) {
				System.out.println("DIGITO INVALIDO. DIGITE  APENAS NUMEROS ");
			}

			switch (op) {
			case 1:
				cadastroDeContas();
				break;

			case 2:
				if (listCliente.size() != 0) {
					System.out.println("\t-----------------------------");
					System.out.println("\t LISTA DE CONTAS CORRENTE    ");
					System.out.println("\t-----------------------------");

					for (int i = 0; i < listCliente.size(); i++) {

						System.out.println("NOME : " + listCliente.get(i).getNomeCliente()
								+ "\nNUMERO DA CONTA CORRENTE : " + listCliente.get(i).getNumContaCorrente()
								+ "\nSALDO CONTA CORRENTE : " + listCliente.get(i).getSaldoCc() + "  R$");
						System.out.println("\nDATA ABERTURA DA CC : " + sdf.format(listCliente.get(i).getData()));
						System.out.println("__________________________________________");
						System.out.println("\n");
					}
				} else {
					System.out.println("NÃO EXISTE CONTAS CADASTRADAS PARA PODER LISTAR");
				}

				break;

			case 3:
				removerContas();
				break;

			case 4:
				editarContas();

				break;

			case 5:

				System.out.println("\t--------------------");
				System.out.println("\t       MENU         ");
				System.out.println("\tDEPOSITOS/SALDO/TRANFERÊNCIA");
				System.out.println("\t--------------------");

				System.out.println("DIGITE [1] PARA DEPOSITAR ");
				System.out.println("DIGITE [2] PARA LISTAR SALDO ");
				System.out.println("DIGITE [3] PARA TRANSFERÊNCIA");
				System.out.println("DIGITE [0] PARA SAIR ");

				System.out.println("INFORME OP ");
				int o_p = -1;
				try {
					o_p = Reader.readInt();
				} catch (NumberFormatException e) {
					System.out.println("VOCÊ DIGITOU DIGITO ERRADO PARA OPÇÃO DO [MENU] ");
				}
				switch (o_p) {
				case 1:

					menuDeposito();
					break;

				case 2:
					listandoSaldos();

					break;
				case 3:

					System.out.println("\t--------------------");
					System.out.println("\t TRANSFERÊNCIA      ");
					System.out.println("\t--------------------");

					System.out.println("DIGITE[1] PARA CONTA CORRENTE ");
					System.out.println("DIGITE[2] PARA CONTA  POUPANÇA");
					System.out.println("DIGITE[0] PARA SAIR");

					System.out.println("DIGITE OPÇÃO ");
					int opc = Reader.readInt();

					switch (opc) {
					case 1:
						transferenciaContaCorrente();

						break;
					case 2:
						transferenciaContaPoupanca();

						break;

					case 0:
						System.out.println("VOCÊ SAIU ");
						break;

					default:
						System.out.println("OPÇÃO INVALIDA");
						break;
					}

					break;
				case 0:
					System.out.println("VOCÊ SAIU ***");
					break;

				default:

					System.out.println("OPÇÃO INVALIDA");
					break;
				}

				break;
			case 6:

				System.out.println("\t-----------------------------");
				System.out.println("\t LISTA DE CONTAS POUPANÇA    ");
				System.out.println("\t-----------------------------");

				for (int i = 0; i < clientePoupanca.size(); i++) {

					if (clientePoupanca.size() != 0) {
						aux = true;
						System.out.println("NOME : " + clientePoupanca.get(i).getNomeCliente()
								+ "\nNUMERO DA CONTA POUPANÇA : " + clientePoupanca.get(i).getNumeroContaPoupanca()
								+ "\nSALDO CONTA POUPANÇA : " + clientePoupanca.get(i).getSaldoCp() + "  R$");
						System.out.println("\nDATA ABERTURA DA CP : " + sdf.format(clientePoupanca.get(i).getData()));
						System.out
								.println("\nANIVERSARIO : " + sdf.format(clientePoupanca.get(i).getDataAniversario()));
						System.out.println("______________________________________________________");
					}
				}
				if (clientePoupanca.size() == 0) {
					System.out.println("NÃO EXISTE CONTAS CADASTRADAS ");
				}

				break;

			case 0:
				System.out.println("**** VOCÊ SAIU ****");
				break;
			default:
				System.out.println("OPÇÃO INVALIDA ");
				break;

			}

		}
	}

	public static void cadastroDeContas() throws Exception {
		int opcao = -1;
		String dataAbertura = "";
		String dataAniver = "";
		double saldoCp = 0;
		String dataAberturaCc = "";

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("\t--------------------");
		System.out.println("\t CADASTRO DE CONTA  ");
		System.out.println("\t--------------------");

		System.out.println("DIGITE [1] PARA CONTA POUPANÇA  ");
		System.out.println("DIGITE [2] PARA CONTA CORRENTE ");
		System.out.println("DIGITE [0] PARA SAIR ");
		System.out.println("INFORME OPERAÇÃO ");

		try {
			opcao = Reader.readInt();
		} catch (NumberFormatException e) {
			System.out.println("VOCÊ DIGITOU LETRA EM VEZ DE NUMERO");
		}

		switch (opcao) {

		case 1:
			System.out.println("\t--------------------");
			System.out.println("\t CADASTRO DE POUPANÇA ");
			System.out.println("\t--------------------");
			try {
				System.out.println("DIGITE NOME CLIENTE");
				String nome = Reader.readString();
				System.out.println("DIGITE DATA ABERTURA DE CONTA");
				dataAbertura = Reader.readString();
				System.out.println("DIGITE NUMERO CONTA POUPANÇA");
				int contaP = Reader.readInt();
				System.out.println("DIGITE DATA ANIVERSARIO");
				dataAniver = Reader.readString();
				System.out.println("DIGITE SALDO");
				saldoCp = Reader.readDouble();
				double saldocc = 0;
				Date dat = sdf.parse(dataAbertura);
				Date datCp = sdf.parse(dataAniver);
				ContaPoupanca conta1 = new ContaPoupanca(nome, dat, saldocc, contaP, datCp, saldoCp);
				clientePoupanca.add(conta1);

				System.out.println("CADASTRO FEITO COM SUCESSO");
			} catch (ParseException e) {
				System.out.println(
						"VOCÊ DIGITOU DATA DE FORMA ERRADA .REFAÇA CADASTRO [DATAS TEM QUE TER dia/numero mes/ano com 4 digitos]");
			} catch (NumberFormatException e) {
				System.out.println(
						"VOCÊ DIGITOU NUMERO CONTA POUPANÇA OU O SALDO ERRAD0S.CAMPOS DE SALDO SO PODEM NUMEROS . REFAÇA CADASTRO");
			} catch (Exception e) {
				System.out.println("VOCÊ DIGITOU NUMERO CONTA OU O SALDO ERRADO. CADASTRE OUTRA VEZ");
			}
			break;

		case 2:

			System.out.println("\t----------------------------");
			System.out.println("\t CADASTRO DE CONTA CORRENTE ");
			System.out.println("\t----------------------------");
			try {
				System.out.println("DIGITE NOME CLIENTE");
				String nomeClie = Reader.readString();
				System.out.println("DIGITE DATA ABERTURA DE CONTA");
				dataAberturaCc = Reader.readString();
				System.out.println("DIGITE NUMERO CONTA CORRENTE");
				int contaC = Reader.readInt();
				System.out.println("DIGITE SALDO CC");
				double saldoCc = Reader.readDouble();
				Date data = sdf.parse(dataAberturaCc);

				listCliente.add(new ContaCorrente(nomeClie, data, contaC, saldoCc));

				System.out.println("\n***CADASTRO FEITO COM SUCESSO ***");
			} catch (ParseException e) {
				System.out.println(
						"VOCÊ DIGITOU DATA DE FORMA ERRADA .REFAÇA CADASTRO [DATAS TEM QUE TER dia/numero mes/ano com 4 digitos]");
			} catch (NumberFormatException e) {
				System.out.println(
						"VOCÊ DIGITOU NUMERO CONTA CORRENTE OU O SALDO ERRAD0S.CAMPOS DE SALDO SO PODEM NUMEROS . REFAÇA CADASTRO");
			} catch (Exception e) {
				System.out.println("VOCÊ DIGITOU NUMERO CONTA OU O SALDO ERRADO. CADASTRE OUTRA VEZ");
			}
			break;

		case 0:
			System.out.println("SAIU");
			break;
		default:
			System.out.println("op invalida ");
			break;

		}

	}

	public static void depositosCc() throws Exception {
		if (listCliente.size() != 0) {
		int contaParaDeposito = 0;
		double valorDeposito = 0;
		
		System.out.println("\t--------------------");
		System.out.println("\tDEPOSITO CONTA CORRENTE");
		System.out.println("\t--------------------");

			System.out.println("DIGITE NOME DEPOSITANTE");
			String nomeDepositante = Reader.readString();
			System.out.println("DIGITE NUMERO CONTA CORRENTE QUE VAI DEPOSITAR");
			contaParaDeposito = Reader.readInt();
			System.out.println("DIGITE VALOR DO DEPOSITO");
			valorDeposito = Reader.readDouble();

			for (int i = 0; i < listCliente.size(); i++) {

				if (listCliente.get(i).getNumContaCorrente() == contaParaDeposito) {

					listCliente.get(i).setSaldoCc(listCliente.get(i).getSaldoCc() + valorDeposito);
					System.out.println("** DEPOSITO EM CONTA CORRENTE FEITO COM SUCESSO **");

				} else {
					System.out.println("CONTA CORRENTE NÃO ENCONTRADA ");
				}			
		    }
	    }else
	       {
		   System.out.println("NÃO EXISTE CONTAS CORRENTE CADASTRADAS");
	      }
	}

	public static void depositosCp() throws Exception {
		int contaParaDepositoPp = 0;
		double valorDepositoPp = 0;

		if (clientePoupanca.size() != 0) {
			System.out.println("\t--------------------");
			System.out.println("\tDEPOSITO CONTA POUPANÇA");
			System.out.println("\t--------------------");

			System.out.println("DIGITE NOME DEPOSITANTE");
			String nomeDepositantePp = Reader.readString();

			System.out.println("DIGITE NUMERO CONTA POUPANÇA QUE VAI DEPOSITAR");
			try {
				contaParaDepositoPp = Reader.readInt();
			} catch (NumberFormatException e) {
				System.out.println("você digitou letra em vez de numero");
			}

			for (int i = 0; i < clientePoupanca.size(); i++) {

				if (clientePoupanca.get(i).getNumeroContaPoupanca() == contaParaDepositoPp) {

					System.out.println("DIGITE VALOR DO DEPOSITO");
					try {
						valorDepositoPp = Reader.readDouble();
					} catch (NumberFormatException e) {
						System.out.println("você digitou letra em vez de numero");
					}

					clientePoupanca.get(i).setSaldoCp(clientePoupanca.get(i).getSaldoCp() + valorDepositoPp);

					System.out.println("** DEPOSITO EM CONTA POUPANÇA FEITO COM SUCESSO **");
					System.out.println("valor que esse saldo ficou ==== " + clientePoupanca.get(i).getSaldoCp());
				} else {
					System.out.println("NUMERO DE CONTA ERRADA ");
				}

			}
		} else {
			System.out.println("NÃO EXISTE CONTAS POUPANÇA CADASTRADAS ");
		}

	}

	public static void menuDeposito() throws Exception {
		int opic_ao = -1;
		System.out.println("\t--------------------");
		System.out.println("\t    DEPOSITO        ");
		System.out.println("\t--------------------");

		System.out.println("DIGITE[1] PARA CONTA CORRENTE ");
		System.out.println("DIGITE[2] PARA CONTA  POUPANÇA");
		System.out.println("DIGITE[0] PARA SAIR");

		System.out.println("DIGITE OPÇÃO");
		try {
			opic_ao = Reader.readInt();
		} catch (NumberFormatException e) {
			System.out.println("você digiou letra em vez de numero como opção");
		}
		switch (opic_ao) {
		case 1:

			depositosCc();

			break;

		case 2:
			depositosCp();

			System.out.println(" DIGITE [0] PARA FINALIZAR ");
			try {
				opic_ao = Reader.readInt();
			} catch (NumberFormatException e) {
				System.out.println("VOCÊ DIGITOU LETRA EM VEZ DE NUMERO");
			}
			break;

		case 0:

			System.out.println("voce saiu ");
			break;
		default:
			System.out.println("opção invalida");
			break;
		}

	}

	public static void transferenciaContaCorrente() throws Exception {
		boolean aux = true;
		int numConta = 0;
		int contaParaTransferencia = 0;
		double valorTransferencia = 0;

		System.out.println("\t-----------------------------------");
		System.out.println("\t TRANSFERÊNCIA ENTRE CONTAS CORRENTE   ");
		System.out.println("\t-----------------------------------");

		if (listCliente.size() != 0) {
			aux = true;

			System.out.println("DIGITE NUMERO DA SUA CONTA : ");
			numConta = Reader.readInt();
			System.out.println("DIGITE NUMERO DA CONTA QUE QUER TRANFERIR");
			contaParaTransferencia = Reader.readInt();
			System.out.println("VALOR PARA TRANSFERENCIA");
			valorTransferencia = Reader.readDouble();

			for (int i = 0; i < listCliente.size(); i++) {

				if (listCliente.get(i).getNumContaCorrente() == contaParaTransferencia) {
					// ESSE PRINT E PARA TESTE
					// System.out.println("saldo que tem nessa cc : " +
					// listCliente.get(i).getSaldoCc());
					listCliente.get(i).setSaldoCc(listCliente.get(i).getSaldoCc() + valorTransferencia);
					// TESTE System.out.println("ok deu certo recebeu : " +
					// listCliente.get(i).getSaldoCc());
				}

				if (listCliente.get(i).getNumContaCorrente() == numConta) {
					// ESSE PRINT E PARA TESTE
					// System.out.println("saldo que tem nessa cc : " +
					// listCliente.get(i).getSaldoCc());

					if (listCliente.get(i).getNumContaCorrente() == numConta) {
						int num = 1;
						do {
							num = 1;

							// VALOR QUE TEM MENOS O VALOR DA TRANSFERENCIA
							// listCliente.get(i).getSaldoCc() -
							// valorTransferencia;
							// SETA O VALOR PARA DIMINUIR
							listCliente.get(i).setSaldoCc(listCliente.get(i).getSaldoCc() - valorTransferencia);
							// VALOR ATUALIZADO COM DESCONTO DA TRANSFERENCIA
							// MENOS TAXA(0.01)
							listCliente.get(i).setSaldoCc(listCliente.get(i).getSaldoCc() - 0.01);

							System.out.println("DIGITE[1] CONTINUAR DEPOSITANDO OU [0] PARA CONFIRMAR ");
							num = Reader.readInt();
							if (num == 1) {
								transferenciaContaCorrente();
							}

						} while (num == 1);

						System.out.println("TRANSFERENCIA FEITA COM SUCESSO");
						// ESSE PRINT EH PARA TESTE
						// System.out.println("ESSA CONTA CC POSSUI : " +
						// listCliente.get(i).getSaldoCc() + " R$");

					} else {
						System.out.println("VOCÊ NÃO POSSUI CONTA NESTE BANCO PARA TRANSEFERÊNCIA");
					}

				}

			}
		} else {
			System.out.println("NÃO EXISTE CONTAS CADASTRADAS");
		}

	}

	public static void transferenciaContaPoupanca() throws Exception {
		int numContaP = 0;
		int contaPpParaTransferencia = 0;
		double valorTransferenciaPp = 0;
		boolean aux = true;
		System.out.println("\t-----------------------------------");
		System.out.println("\t TRANSFERÊNCIA ENTRE CONTAS POUPANÇA  ");
		System.out.println("\t-----------------------------------");

		if (clientePoupanca.size() != 0) {
			aux = true;

			System.out.println("DIGITE NUMERO DA SUA CONTA : ");
			numContaP = Reader.readInt();
			System.out.println("DIGITE NUMERO DA CONTA QUE QUER TRANFERIR");
			contaPpParaTransferencia = Reader.readInt();
			System.out.println("VALOR PARA TRANSFERENCIA");
			valorTransferenciaPp = Reader.readDouble();

			for (int i = 0; i < clientePoupanca.size(); i++) {

				if (clientePoupanca.get(i).getNumeroContaPoupanca() == contaPpParaTransferencia) {

					clientePoupanca.get(i).setSaldoCp((clientePoupanca.get(i).getSaldoCp() + valorTransferenciaPp));

				}

				if (clientePoupanca.get(i).getNumeroContaPoupanca() == numContaP) {

					if (clientePoupanca.get(i).getNumeroContaPoupanca() == numContaP) {
						int num = 1;
						do {
							num = 1;

							clientePoupanca.get(i)
									.setSaldoCp(clientePoupanca.get(i).getSaldoCp() - valorTransferenciaPp);

							clientePoupanca.get(i).setSaldoCp(clientePoupanca.get(i).getSaldoCp() - 0.01);

							System.out.println("DIGITE[1] CONTINUAR DEPOSITANDO OU [0] PARA CONFIRMAR ");
							num = Reader.readInt();
							if (num == 1) {
								transferenciaContaCorrente();
							}

						} while (num == 1);

						System.out.println("TRANSFERENCIA FEITA COM SUCESSO");

					} else {
						System.out.println("VOCÊ NÃO POSSUI CONTA NESTE BANCO PARA TRANSEFERÊNCIA");
					}

				} else {
					System.out.println("CONTA DIGITADA ERRADA");
				}
			}
		} else {
			System.out.println("NÃO EXISTE CONTAS CADASTRADAS");
		}
	}

	public static void removerContas() throws Exception {
		int numCc = 0;
		int optyon = -1;
		boolean aux = true;

		System.out.println("\t--------------------");
		System.out.println("\t REMOVER  CONTAS    ");
		System.out.println("\t--------------------");

		System.out.println("DIGITE[1] PARA REMOVER CONTA CORRENTE ");
		System.out.println("DIGITE[2] PARA REMOVER CONTA  POUPANÇA");
		System.out.println("DIGITE[0] PARA SAIR");

		System.out.println("QUAL OPÇÃO DESEJA :");
		try {
			optyon = Reader.readInt();
		} catch (NumberFormatException e) {
			System.out.println("VOCÊ DIGITOU LETRA EM VEZ DE NUMERO");
		}
		switch (optyon) {

		case 1:

			if (listCliente.size() != 0) {
				System.out.println("\t------------------------");
				System.out.println("\t REMOVER  CONTA CORRENTE");
				System.out.println("\t------------------------");

				System.out.println("INFORME NUMERO DA CONTA PARA DELETAR :");
				try {
					numCc = Reader.readInt();
				} catch (NumberFormatException e) {
					System.out.println("VOCÊ DIGITOU LETRAS EM VEZ  NUMERO DA CONTA ");
				}

				for (int i = 0; i < listCliente.size(); i++) {
					if (listCliente.get(i).getNumContaCorrente() == numCc) {
						aux = true;

						listCliente.remove(i);
						System.out.println("CONTA REMOVIDA COM SUCESSO");
					}
				}

				if (aux == false) {
					System.out.println("NUMERO DE CONTA C.C NÃO ENCONTRADA");
				}

			} else {
				System.out.println("NÃO EXISTE CONTAS CADASTRADAS PARA REMOÇÃO");
			}
			break;

		case 2:

			if (clientePoupanca.size() != 0) {
				System.out.println("\t------------------------");
				System.out.println("\t REMOVER  CONTA POUPANÇA");
				System.out.println("\t------------------------");

				System.out.println("INFORME NUMERO DA CONTA PARA DELETAR :");
				try {
					numCc = Reader.readInt();
				} catch (NumberFormatException e) {
					System.out.println("VOCÊ DIGITOU LETRAS EM VEZ  NUMERO DA CONTA ");
				}

				for (int i = 0; i < clientePoupanca.size(); i++) {
					if (clientePoupanca.get(i).getNumeroContaPoupanca() == numCc) {
						aux = true;

						clientePoupanca.remove(i);
						System.out.println("CONTA REMOVIDA COM SUCESSO");
					}
				}
				if (aux == false) {
					System.out.println("NUMERO DE CONTA P.P. NÃO ENCONTRADA");
				}

			} else {
				System.out.println("NÃO EXISTE CONTAS CADASTRADAS PARA REMOÇÃO");
			}

			break;
		case 0:
			System.out.println("VOCÊ SAIU");
			break;
		default:
			System.out.println("OPÇÃO INVALIDA");
			break;
		}

	}

	public static void editarContas() throws Exception {
		System.out.println("\t----------------------");
		System.out.println("\t EDITAR CONTAS");
		System.out.println("\t----------------------");

		System.out.println("DIGITE [1] PARA EDITAR CONTA CORRENTE");
		System.out.println("DIGITE [2] PARA EDITAR CONTA POUPANÇA");
		System.out.println("DIGITE [0] PARA SAIR");

		System.out.println("DIGITE OPÇÃO :");
		int opc = -1;
		try {
			opc = Reader.readInt();
		} catch (NumberFormatException e) {
			System.out.println("VOCÊ DIGITOU LETRA EM VEZ DE NUMERO PARA OPÇÃO");
		}

		switch (opc) {
		case 1:
			if (listCliente.size() != 0) {

				System.out.println("INFORME NUMERO DA CONTA QUE QUER EDITAR :");
				int numEditar = 0;
				try {
					numEditar = Reader.readInt();
				} catch (NumberFormatException e) {
					System.out.println("VOCÊ DIGITOU DIGITOS INVALIDOS EM VEZ DE NUMERO DA CONTA ");
				}

				for (int i = 0; i < listCliente.size(); i++) {

					if (listCliente.get(i).getNumContaCorrente() == numEditar) {

						System.out.println("DIGITE NOME NOVO : ");
						String nomeNovo = Reader.readString();

						listCliente.get(i).setNomeCliente(nomeNovo);
						System.out.println("CLIENTE DE CC NUMERO = " + listCliente.get(i).getNumContaCorrente());
						System.out.println(listCliente.get(i).nomeCliente = nomeNovo);

						System.out.println("***ALTERADO COM SUCESSO *** ");
					} else {
						System.out.println("NUMERO DE CONTA CORRENTE NÃO ENCONTRADO");
					}
				}
			} else {
				System.out.println("NÃO EXISTE CONTAS CORRENTE CADASTRADAS PARA EDITAR");
			}
			break;

		case 2:
			if (clientePoupanca.size() != 0) {

				System.out.println("INFORME NUMERO DA CONTA POUPANÇA QUE QUER EDITAR :");
				int numEditar = 0;
				try {
					numEditar = Reader.readInt();
				} catch (NumberFormatException e) {
					System.out.println("VOCÊ DIGITOU DIGITOS INVALIDOS EM VEZ DE NUMERO DA CONTA ");
				}

				for (int i = 0; i < clientePoupanca.size(); i++) {

					if (clientePoupanca.get(i).getNumeroContaPoupanca() == numEditar) {

						System.out.println("DIGITE NOME NOVO : ");
						String nomeNovo = Reader.readString();

						clientePoupanca.get(i).setNomeCliente(nomeNovo);
						System.out.println("CLIENTE DE CC NUMERO = " + clientePoupanca.get(i).getNumeroContaPoupanca());
						System.out.println(clientePoupanca.get(i).nomeCliente = nomeNovo);

						System.out.println("***ALTERADO COM SUCESSO *** ");
					}
				}
			} else {
				System.out.println("NÃO EXISTE CONTAS POUPANÇA CADASTRADAS PARA EDITAR");
			}

			break;
		case 0:
			System.out.println("VOCÊ SAIU ");
			break;
		default:
			System.out.println("OPÇÃO INVALIDA");
			break;

		}
	}

	public static void listandoSaldos() throws Exception {
		boolean aux = true;

		System.out.println("\t--------------------");
		System.out.println("\t LISTAR SALDOS  ");
		System.out.println("\t--------------------");

		System.out.println("DIGITE [1] PARA LISTAR SALDO CONTA CORRENTE");
		System.out.println("DIGITE [2] PARA LISTAR SALDO CONTA POUPANÇA");
		System.out.println("DIGITE [0] PARA SAIR");

		System.out.println("INFORME OPÇÃO : ");
		int optando = -1;

		try {
			optando = Reader.readInt();
		} catch (NumberFormatException e) {
			System.out.println("VOCÊ DIGITOU LETRA EM VEZ DE NUMERO PARA OPÇÃO ");
		}

		switch (optando) {
		case 1:

			if (listCliente.size() != 0) {
				System.out.println("\t--------------------");
				System.out.println("\t CONTAS CORRENTE ");
				System.out.println("\t--------------------");

				aux = true;

				System.out.println("INFORME NUMERO DA CONTA CORRENTE : ");
				int contaParaSaldo = Reader.readInt();

				for (int i = 0; i < listCliente.size(); i++) {

					if (listCliente.get(i).getNumContaCorrente() == contaParaSaldo) {

						if (listCliente.get(i).getNumContaCorrente() == contaParaSaldo) {

							System.out.println("NOME : " + listCliente.get(i).nomeCliente);

							System.out.println("SALDO CC : " + listCliente.get(i).getSaldoCc() + "   R$");
							System.out.println("_____________________________________________");
						}
					} else {
						System.out.println("NUMERO DA CONTA CORRENTE INVALIDO ");
					}
				}

			} else {
				System.out.println("NÃO EXISTE CLIENTES CADASTRADOS PARA LISTAR");
			}
			break;
		case 2:

			if (clientePoupanca.size() != 0) {
				System.out.println("\t--------------------");
				System.out.println("\t CONTAS POUPANÇA ");
				System.out.println("\t--------------------");

				aux = true;

				System.out.println("INFORME NUMERO DA CONTA POUPANÇA : ");
				int contaParaSaldo = Reader.readInt();

				for (int i = 0; i < clientePoupanca.size(); i++) {

					if (clientePoupanca.get(i).getNumeroContaPoupanca() == contaParaSaldo) {

						if (clientePoupanca.get(i).getNumeroContaPoupanca() == contaParaSaldo) {

							System.out.println("NOME : " + clientePoupanca.get(i).nomeCliente);

							System.out.println("SALDO CC : " + clientePoupanca.get(i).getSaldoCp() + "  R$");
							System.out.println("_____________________________________________");
						}
					} else {
						System.out.println("NUMERO DA CONTA POUPANÇA INVALIDO ");
					}
				}

			} else {
				System.out.println("NÃO EXISTE CLIENTES CADASTRADOS PARA LISTAR");
			}

			break;
		case 0:
			System.out.println("VOCÊ SAIU");
			break;
		default:
			System.out.println("OPÇÃO INVALIDA ");
			break;

		}

	}

}
