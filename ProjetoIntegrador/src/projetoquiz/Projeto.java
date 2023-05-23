package projetoquiz;

import java.util.Scanner;

import java.util.concurrent.TimeUnit;

public class Projeto {

	static Scanner leitor = new Scanner(System.in);
	static Scanner leitorPerguntas = new Scanner(System.in);

	//Varriavel usada para tudo que envolve a escolha das opções do MENU ;
	static byte escolheMenu;

	//variaveis global e vetor que recebe a quantidade de jóia e o nome da jóia da modalidade VINGADORES;
	static byte joiaVingador = 0;
	static String vetorJoiaVingador[] = new String[6];//vetor do tipo string que recebe um um tamanho de 6

	//variaveis global e vetor que recebe a quantidade de jóia e o nome da jóia da modalidade THANOS;
	static byte joiaThanos = 0;
	static String vetorJoiaThanos[] = new String[6];

	//valor booleano que determina o fim do código caso seja FALSE;
	static boolean continua = true;
	
	//variaveis para trocar de modalidade, ou voltar para o MENU principal
	static byte trocaModalidade = 0;
	static byte voltaMenu;
	static long start = System.currentTimeMillis();

	public static void main(String[] args) {

		//MAIN que chama todas as funções principais formado pelo menu, perguntas, creditos etc;
		do {
			escolheMenu = montaMenu();
			switch (escolheMenu) {
			case 1:
				jogar();//mostra todas as perguntas
				break;

			case 2:
				instrucoes();//informa as instruções do quiz
				break;
			case 3:
				creditos();//mostra os créditos
				break;

			case 4:
				sair();//encerra todo o código
				break;

			}

		} while (escolheMenu > 4 || escolheMenu < 1);//laço que trata caso o usuario digite um numero fora do menu
	}

	//Função que monta a estrutura do Menu, e retorna somente um byte sendo associado a varialve "escolheMenu";
	public static byte montaMenu() {
		byte opcao = 0;
		System.out.println("|===========================|");
		System.out.println("|1 -        JOGAR           |");
		System.out.println("|2 -      INSTRUÇÕES        |");
		System.out.println("|3 -       CRÉDITOS         |");
		System.out.println("|4 -         SAIR           |");
		System.out.println("|===========================|");
		System.out.println("Escolha uma opção");
		escolheMenu = leitor.nextByte();
		if (escolheMenu >= 5 || escolheMenu <= 0) {
			System.err.println("!!!!ESCOLHA UMA OPÇÃO VÁLIDA!!!!");

		}
		return escolheMenu;

	}
	//Função que define a modalidade escolhida pelo jogaddor, esta função está presente em todo o código.
	public static byte escolheModalidade() {

		System.out.println("Escolha sua modalidade");
		System.out.println("1 - VINGADOR\n2 - THANOS");

		byte escolheModalidade = leitor.nextByte();

		return escolheModalidade;

	}

	//Função jogar que possui todas as estrturas de perguntas, de 1 a 6, das duas modalidades;
	public static void jogar() {

		byte escolheModalidade = escolheModalidade();//variavel criada para poder ser usada e anexada as perguntas
		pergunta1Vingador(escolheModalidade);
		pergunta1Thanos(escolheModalidade);

		pergunta2Vingador(escolheModalidade);
		pergunta2Thanos(escolheModalidade);

		pergunta3Vingador(escolheModalidade);
		pergunta3Thanos(escolheModalidade);

		pergunta4Vingador(escolheModalidade);
		pergunta4Thanos(escolheModalidade);

		pergunta5Vingador(escolheModalidade);
		pergunta5Thanos(escolheModalidade);

		pergunta6Vingador(escolheModalidade);
		pergunta6Thanos(escolheModalidade);

		mudaModalidade(escolheModalidade);
	}

	//Contém toda a instrução do QUIZ.
	public static void instrucoes() {
		System.out.println();
		System.out.println(
				"O jogo consiste em um QUIZ com o tema de 'Universo Marvel' tendo como base 2 tipos de modalidades, cada modalidade possui 6 perguntas.\n"
						+ "\n"
						+ "É possível jogar como 'VINGADOR' ou 'THANOS', a modalidade Vingador é um Quiz de maior dificuldade,\n"
						+ "já a modalidade 'THANOS' é de dificuldade mediana.\n"
						+ "\nO Quiz possui como referência, os filmes 'Vingadores - Guerra Infinita' e 'Vingadores - Ultimato'"
						+ "" + "\ntrazendo a temática das Jóias do infinito retratada no universo da MARVEL.\n"
						+ "A cada pergunta respondida corretamente o jogador ganha uma jóia.\n" + "\n"
						+ "Caso o jogador erre uma pergunta ele terá o direito de voltar no tempo e ter mais uma tentativa de responder corretamente a pergunta,"
						+ "\ne consequentemente recuperar a jóia perdida.\n"
						+ "Vale lembrar que, se mesmo voltando no tempo o jogador errar a pergunta, ele vai perder a jóia."
						+ "\n" + "\nMODALIDADE VINGADOR \r\n" + ""
						+ "Ao escolher a modalidade 'Vingador' seu objetivo será conseguir as 6 joias do infinito e impedir que o THANOS acabe com metade do universo."
						+ "\nEsta modalidade possui um nível de dificuldade maior, pois em tese, é necessário conseguir todas as 6 jóias, ou seja,"
						+ "\nresponder todas as 6 perguntas corretamente.\n " + "\nMODALIDADE THANOS \n"
						+ "\nComo THANOS seu objetivo é dizimar metade do universo com o 'estalo' ou derrotar os Vingadores."
						+ "\nEsta modalidade possui um nível de dificuldade menor, pois basta conseguir 3 jóias para vencer os Vingadores,"
						+ "\nse o jogador conseguir as 6 jóias, ele faz uma vitória perfeita.\n"
						+ "\nOBS: No final do quiz de cada modalidade será contabilizado a quantidade de jóias que o jogador conseguiu reunir."
						+ "\nSe o jogador conseguir 5 jóias(independente do tipo da modalidade) ele terá direito de responder uma pergunta extra,"
						+ "\ntendo uma chance de conseguir todas as 6 jóias!");

		System.out.println();

		//interação para voltar ao menu
		System.out.println("|----------------------------------|");
		System.out.println("|Aperte '1' para voltar para o Menu|");
		System.out.println("|----------------------------------|");
		voltaMenu = leitor.nextByte();

		//laço de repetição para tratar digitações de números que não seja 1.
		while (voltaMenu != 1) {
			System.err.println("|----------------------------------|");
			System.err.println("|Aperte '1' para voltar para o Menu|");
			System.err.println("|----------------------------------|");
			voltaMenu = leitor.nextByte();
		}

		//estrutura condicional com base na informação anterior, ele mostra pro usuário um menu com as opções;
		if (voltaMenu == 1) {
			System.out.println("|===========================|");
			System.out.println("|1 -        JOGAR           |");
			System.out.println("|2 -       CRÉDITOS         |");
			System.out.println("|3 -         SAIR           |");
			System.out.println("|===========================|");
			System.out.println("Escolha uma opção");
			escolheMenu = leitor.nextByte();
			switch (escolheMenu) {//switch case que recebe as funções principais do menu
			case 1:
				jogar();//mostra todas as perguntas
				break;
			case 2:
				creditos();//mostra os creditos
				break;
			case 3:
				sair();//encerra o código/quiz
				break;
			}
		}

	}

	//Função que mostra os creditos
	public static void creditos() {
		System.out.println();
		System.out.println();
		System.out.println("Obrigado por jogar nosso QUIZ - MARVEL!!");
		System.out.println();
		System.out.println("CAROLINE COSTA SALDANHA\n" + "\nDANIEL RODRIGUES AGUILLAR\n"
				+ "\nHENRIQUE SENA DE MENEZES\n" + "\nLUKAS RODRIGUES\n" + "\nSTEFANY DO NASCIMENTO FERREIRA ");

		System.out.println();

		System.out.println("|----------------------------------|");
		System.out.println("|Aperte '1' para voltar para o Menu|");
		System.out.println("|----------------------------------|");
		voltaMenu = leitor.nextByte();

		while (voltaMenu != 1) {
			System.err.println("|----------------------------------|");
			System.err.println("|Aperte '1' para voltar para o Menu|");
			System.err.println("|----------------------------------|");
			voltaMenu = leitor.nextByte();
		}

		//condicional para mostrar um menu com todas as funções, exceto "creditos" pois esta o usuario já está
		if (voltaMenu == 1) {
			System.out.println("|===========================|");
			System.out.println("|1 -        JOGAR           |");
			System.out.println("|2 -      INSTRUÇÕES        |");
			System.out.println("|3 -         SAIR           |");
			System.out.println("|===========================|");
			System.out.println("Escolha uma opção");
			escolheMenu = leitor.nextByte();
			switch (escolheMenu) {
			case 1:
				jogar();//novamente todas as funções que compoe o menu, sendo chamada(exceto a funcao creditos)
				break;
			case 2:
				instrucoes();
				break;
			case 3:
				sair();
				break;
			}
		}

	}

	//função que encerra todo o código de acordo com a variavel global booleana que começa como "true"
	public static void sair() {

		if (escolheMenu == 3 || escolheMenu == 4) {
			continua = false;//se a variavel escolheMenu for igual a 3 ou 4(de acordo com o menu) a variavel continua recebe false e encerra o codigo
			System.out.println("OBRIGADO POR JOGAR!!");

			System.out.println("Você saiu");

		}

	}

	public static void pergunta1Vingador(byte escolheModalidade) {
		//estrutura referente a modalidade VINGADOR
		int tentativasPergunta1 = 0;//número de tentativas referente a esta pergunta
		switch (escolheModalidade) {//switch case que recebe está de acordo com a modalidade que o usuario escolher
		case 1://Case 1 pois refere-se a modalidade VINGADOR
			boolean voltaPergunta1Vingador = true;//variavel booleana que controla para sair ou continuar no laço

			do {
				System.out.println(
						"\n1 - Para conseguir a jóia da ALMA é preciso fazer um determinado objetivo, qual é este?");
				System.out.println(
						"A)Sacrificar uma alma    B)Negociar com a morte\nC)Derrotar a morte       D)Vender sua alma ");
				char escolhaResposta1Vingador = leitorPerguntas.nextLine().toUpperCase().charAt(0);

				switch (escolhaResposta1Vingador) {
				case 'A':
					System.out.println("Correto!!");
					System.out.println("Você recebeu a jóia da ALMA");

					joiaVingador += 1;
					vetorJoiaVingador[0] = "ALMA";//vetor STRING
					voltaPergunta1Vingador = false;
					//se o usuario acertar, ele reccebe uma jóia, e o nome da jóia entra no vetor de acordo com a posição

					break;
				case 'C':
				case 'B':
				case 'D'://se o usuario digitar alguma dessas alternativas, o usuario poderá responder somente mais uma vez a pergunta
					tentativasPergunta1++;
					System.out.println("Incorreto!!\nVocê perdeu a jóia da ALMA para o THANOS");
					if (tentativasPergunta1 < 2) {
						System.out.println("Você voltou no tempo, tente responder novamente!");//mensagem de retorno da pergunta caso erre.
					}
					vetorJoiaVingador[0] = "PERDEU A JÓIA DA ALMA";//recebe esta frase no vetor, afim de mostrar que perdeu a joia no fim da partida

					break;

				default:
					System.out.println("Resposta invalida");
				}

			} while (tentativasPergunta1 < 2 && voltaPergunta1Vingador);//while de controle que faz o usuario voltar somente uma vez caso erre
			break;
		}
	}

	public static void pergunta1Thanos(byte escolheModalidade) {
		//toda estrutura referente a modalidade THANOS
		int tentativasPergunta1Thanos = 0;//número de tentativas referente a esta pergunta
		
		switch (escolheModalidade) {//switch case que recebe está de acordo com a modalidade que o usuario escolher
		case 2://case 2 pois 2 refere-se a modalidade THANOS
			
			boolean voltaPergunta1Thanos = true;//variavel booleana que controla para sair ou continuar no laço

			do {
				System.out.println("\n1 - Quem morreu pelas mãos do THANOS momentos antes dele pegar a jóia da ALMA ?");
				System.out.println("A)Peter Quill         B)Gamora\nC)Peter Parker        D)Nebulosa ");
				char escolhaResposta1Thanos = leitorPerguntas.nextLine().toUpperCase().charAt(0);

				switch (escolhaResposta1Thanos) {
				case 'B':
					System.out.println("Correto!!");
					System.out.println("Você recebeu a jóia da ALMA");

					joiaThanos += 1;
					vetorJoiaThanos[0] = "ALMA";//vetor STRING
					voltaPergunta1Thanos = false;
					//se o usuario acertar, ele reccebe uma jóia, e o nome da jóia entra no vetor de acordo com a posição
					break;
				case 'C':
				case 'A':
				case 'D':
					tentativasPergunta1Thanos++;
					System.out.println("Incorreto!!\nVocê perdeu a jóia da ALMA para os VINGADORES");
					if (tentativasPergunta1Thanos < 2) {
						System.out.println("Você voltou no tempo, tente recuperar a jóia!");//mensagem de retorno da pergunta caso erre.
					}

					vetorJoiaThanos[0] = "PERDEU A JÓIA DA ALMA";//recebe esta frase no vetor, afim de mostrar que perdeu a joia no fim da partida

					break;

				default:
					System.err.println("Resposta inválida");
				}

			} while (tentativasPergunta1Thanos < 2 && voltaPergunta1Thanos);
			break;
		}
	}

	public static void pergunta2Vingador(byte escolheModalidade) {
		//estrutura referente a modalidade VINGADOR
		int tentativasPergunta2 = 0;
		switch (escolheModalidade) {
		case 1:
			boolean voltaPergunta2Vingador = true;

			do {

				System.out.println("\n2 - Onde estava localizada a jóia do espaço de acordo com os filmes");
				System.out.println(
						"A)Em Morag         B)Estava com o visão\nC)No Tesseract     D)Estava com o Colecionador ");
				char escolhaResposta2Vingador = leitorPerguntas.nextLine().toUpperCase().charAt(0);

				switch (escolhaResposta2Vingador) {
				case 'C':
					System.out.println("Correto!!");
					System.out.println("Você recebeu a jóia do ESPAÇO");

					joiaVingador += 1;
					vetorJoiaVingador[1] = "ESPAÇO";//vetor STRING
					voltaPergunta2Vingador = false;

					break;
				case 'A':
				case 'B':
				case 'D':
					tentativasPergunta2++;
					System.out.println("Incorreto!!\nVocê perdeu a jóia do ESPAÇO para o THANOS");
					if (tentativasPergunta2 < 2) {
						System.out.println("Você voltou no tempo, tente responder novamente!");//mensagem de retorno da pergunta caso erre.
					}

					vetorJoiaVingador[1] = "PERDEU A JÓIA DO ESPAÇO";

					break;

				default:
					System.err.println("Resposta inválida");
				}

			} while (tentativasPergunta2 < 2 && voltaPergunta2Vingador);
			break;
		}
	}

	public static void pergunta2Thanos(byte escolheModalidade) {
		//toda estrutura referente a modalidade THANOS
		int tentativasPergunta2Thanos = 0;
		switch (escolheModalidade) {
		case 2:
			boolean voltaPergunta2Thanos = true;

			do {

				System.out.println("\n2 - Qual era o principal objetivo do Thanos ?");
				System.out.println(
						"A)Exterminar todo universo                  B)Destruir o planeta terra\nC)Exterminar 50% de toda vida do universo   D)Derrotar os vingadores ");
				char escolhaResposta2Thanos = leitorPerguntas.nextLine().toUpperCase().charAt(0);

				switch (escolhaResposta2Thanos) {
				case 'C':
					System.out.println("Correto!!");
					System.out.println("Você recebeu a jóia do PODER");

					joiaThanos += 1;
					vetorJoiaThanos[1] = "PODER";
					voltaPergunta2Thanos = false;

					break;
				case 'B':
				case 'A':
				case 'D':
					tentativasPergunta2Thanos++;
					System.out.println("Incorreto!!\nVocê perdeu a jóia do PODER para os VINGADORES!");
					if (tentativasPergunta2Thanos < 2) {
						System.out.println("Você voltou no tempo, tente recuperar a jóia!");
					}

					vetorJoiaThanos[1] = "PERDEU A JÓIA DO PODER";

					break;

				default:
					System.err.println("Resposta inválida");
				}

			} while (tentativasPergunta2Thanos < 2 && voltaPergunta2Thanos);
			break;
		}
	}

	public static void pergunta3Vingador(byte escolheModalidade) {
		int tentativasPergunta3 = 0;
		switch (escolheModalidade) {
		case 1:
			boolean voltaPergunta3Vingador = true;

			do {
				System.out.println("\n3 - Quantos finais o Dr Estranho previu em Guerra Infinita");
				System.out.println("A)12Milhões         B)14Milhões\nC)20Milhões         D)7Milhões ");
				char escolhaResposta3Vingador = leitorPerguntas.nextLine().toUpperCase().charAt(0);

				switch (escolhaResposta3Vingador) {
				case 'B':
					System.out.println("Correto!!");
					System.out.println("Você recebeu a jóia do TEMPO");

					joiaVingador += 1;
					vetorJoiaVingador[2] = "TEMPO";
					voltaPergunta3Vingador = false;

					break;
				case 'A':
				case 'C':
				case 'D':
					tentativasPergunta3++;
					System.out.println("Incorreto!!\nVocê perdeu a jóia do TEMPO para o THANOS");
					if (tentativasPergunta3 < 2) {
						System.out.println("Você voltou no tempo, tente responder novamente!");
					}

					vetorJoiaVingador[2] = "PERDEU A JÓIA DO TEMPO";

					break;

				default:
					System.err.println("Resposta inválida");
				}

			} while (tentativasPergunta3 < 2 && voltaPergunta3Vingador);
			break;
		}
	}

	public static void pergunta3Thanos(byte escolheModalidade) {
		int tentativasPergunta3Thanos = 0;
		switch (escolheModalidade) {
		case 2:
			boolean voltaPergunta3Thanos = true;

			do {
				System.out.println(
						"\n3 - Em 'Vingadores - Guerra Infinita, Thanos matou um personagem(na frente de Thor e Hulk) afim de pegar a jóia do ESPAÇO. Que Personoagem morreu?");
				System.out.println("A)Hela         B)Odin\nC)Loki         D)Colecionador ");
				char escolhaResposta3Thanos = leitorPerguntas.nextLine().toUpperCase().charAt(0);

				switch (escolhaResposta3Thanos) {
				case 'C':
					System.out.println("Correto!!");
					System.out.println("Você recebeu a jóia do ESPAÇO");

					joiaThanos += 1;
					vetorJoiaThanos[2] = "ESPAÇO";
					voltaPergunta3Thanos = false;

					break;
				case 'B':
				case 'A':
				case 'D':
					tentativasPergunta3Thanos++;
					System.out.println("Incorreto!!\nVocê perdeu a jóia do ESPAÇO para os VINGADORES");
					if (tentativasPergunta3Thanos < 2) {
						System.out.println("Você voltou no tempo, tente recuperar a jóia!");
					}

					vetorJoiaThanos[2] = "PERDEU A JÓIA DO ESPAÇO";

					break;

				default:
					System.err.println("Resposta inválida");
				}

			} while (tentativasPergunta3Thanos < 2 && voltaPergunta3Thanos);
			break;
		}
	}

	public static void pergunta4Vingador(byte escolheModalidade) {
		int tentativasPergunta4 = 0;
		switch (escolheModalidade) {
		case 1:
			boolean voltaPergunta4Vingador = true;

			do {
				System.out.println("\n4 - Quem construiu o Herói 'VISÃO' com a inteligência artificial J.A.R.V.I.S");
				System.out.println("A)Stephen Strange      B)Bruce Benner\nC)Tony Stark           D)Scott Lang");
				char escolhaResposta4Vingador = leitorPerguntas.nextLine().toUpperCase().charAt(0);

				switch (escolhaResposta4Vingador) {
				case 'C':
					System.out.println("Correto!!");
					System.out.println("Você recebeu a jóia da MENTE");

					joiaVingador += 1;
					vetorJoiaVingador[3] = "MENTE";
					voltaPergunta4Vingador = false;

					break;
				case 'B':
				case 'A':
				case 'D':
					tentativasPergunta4++;
					System.out.println("Incorreto!!\nVocê perdeu a jóia da MENTE para o THANOS");
					if (tentativasPergunta4 < 2) {
						System.out.println("Você voltou no tempo, tente responder novamente!");
					}

					vetorJoiaVingador[3] = "PERDEU A JÓIA DA MENTE";

					break;

				default:
					System.err.println("Resposta inválida");
				}

			} while (tentativasPergunta4 < 2 && voltaPergunta4Vingador);
			break;
		}
	}

	public static void pergunta4Thanos(byte escolheModalidade) {
		int tentativasPergunta4Thanos = 0;
		switch (escolheModalidade) {
		case 2:
			boolean voltaPergunta4Thanos = true;

			do {
				System.out.println(
						"\n4 - Quais dos heróis abaixo não foi transformado em pó por Thanos em 'Vingadores - Guerra Infinita'?");
				System.out.println("A)Capitão América      B)Pantera Negra\nC)Homem-Aranha         D)Mantis ");
				char escolhaResposta4Thanos = leitorPerguntas.nextLine().toUpperCase().charAt(0);

				switch (escolhaResposta4Thanos) {
				case 'A':
					System.out.println("Correto!!");
					System.out.println("Você recebeu a jóia da REALIDADE");

					joiaThanos += 1;
					vetorJoiaThanos[3] = "REALIDADE";
					voltaPergunta4Thanos = false;

					break;
				case 'B':
				case 'C':
				case 'D':
					tentativasPergunta4Thanos++;
					System.out.println("Incorreto!!\nVocê perdeu a jóia da REALIDADE para os VINGADORES");
					if (tentativasPergunta4Thanos < 2) {
						System.out.println("Você voltou no tempo, tente recuperar a jóia!");
					}

					vetorJoiaThanos[3] = "PERDEU A JÓIA DA REALIDADE";

					break;

				default:
					System.err.println("Resposta inválida");
				}

			} while (tentativasPergunta4Thanos < 2 && voltaPergunta4Thanos);
			break;
		}
	}

	public static void pergunta5Vingador(byte escolheModalidade) {
		int tentativasPergunta5 = 0;
		switch (escolheModalidade) {
		case 1:
			boolean voltaPergunta5Vingador = true;

			do {
				System.out.println(
						"\n5 - A jóia da REALIDADE teve sua primeira aparição no filme 'Thor: O Mundo Sombrio'. Neste filme, a jóia está com qual personagem?");
				System.out.println("A)Os Vingadores        B)Thor\nC)Asgardianos          D)Jane Foster");
				char escolhaResposta5Vingador = leitorPerguntas.nextLine().toUpperCase().charAt(0);

				switch (escolhaResposta5Vingador) {
				case 'D':
					System.out.println("Correto!!");
					System.out.println("Você recebeu a jóia da REALIDADE");

					joiaVingador += 1;
					vetorJoiaVingador[4] = "REALIDADE";
					voltaPergunta5Vingador = false;

					break;
				case 'B':
				case 'A':
				case 'C':
					tentativasPergunta5++;
					System.out.println("Incorreto!!\nVocê perdeu a jóia da REALIDADE para o THANOS");
					if (tentativasPergunta5 < 2) {
						System.out.println("Você voltou no tempo, tente responder novamente!");
					}

					vetorJoiaVingador[4] = "PERDEU A JÓIA DA REALIDADE";

					break;

				default:
					System.out.println("Resposta invalida");
				}

			} while (tentativasPergunta5 < 2 && voltaPergunta5Vingador);
			break;

		}
	}

	public static void pergunta5Thanos(byte escolheModalidade) {
		int tentativasPergunta5Thanos = 0;
		switch (escolheModalidade) {
		case 2:
			boolean voltaPergunta5Thanos = true;

			do {
				System.out.println(
						"\n5 - Dentre as motivações de Thanos, qual foi a maior motivação dele para dizimar metade do universo?");
				System.out.println(
						"A)Buscar Poder: Ele desejava se tornar o centro do universo.             B)Destruição: Thanos só se importava com si próprio.\nC)Ego: Thanos desejava provar para todo o universo seu próprio poder.    D)Superpopulação: Ele queria manter os recursos de todos os planetas a salvo. ");
				char escolhaResposta5Thanos = leitorPerguntas.nextLine().toUpperCase().charAt(0);

				switch (escolhaResposta5Thanos) {
				case 'D':
					System.out.println("Correto!!");
					System.out.println("Você recebeu a jóia do TEMPO");

					joiaThanos += 1;
					vetorJoiaThanos[4] = "TEMPO";
					voltaPergunta5Thanos = false;

					break;
				case 'B':
				case 'C':
				case 'A':
					tentativasPergunta5Thanos++;
					System.out.println("Incorreto!!\nVocê perdeu a jóia do TEMPO para os VINGADORES");
					if (tentativasPergunta5Thanos < 2) {
						System.out.println("Você voltou no tempo, tente recuperar a jóia!");
					}

					vetorJoiaThanos[4] = "PERDEU A JÓIA DO TEMPO";

					break;

				default:
					System.err.println("Resposta inválida");
				}

			} while (tentativasPergunta5Thanos < 2 && voltaPergunta5Thanos);
			break;
		}
	}

	/**
	 * @param escolheModalidade
	 */
	/**
	 * @param escolheModalidade
	 */
	public static void pergunta6Vingador(byte escolheModalidade) {
		int tentativasPergunta6 = 0;
		switch (escolheModalidade) {
		case 1:
			boolean voltaPergunta6Vingador = true;

			do {

				System.out.println("\n6 - Quem foi o responsável por encontrar a jóia do PODER?");
				System.out.println("A)Gamora         B)Peter Quill\nC)Rocket         D)Ronan");
				char escolhaResposta5Vingador = leitorPerguntas.nextLine().toUpperCase().charAt(0);

				switch (escolhaResposta5Vingador) {
				case 'B':
					System.out.println("Correto!!");
					System.out.println("Você recebeu a jóia do PODER");

					joiaVingador += 1;
					vetorJoiaVingador[5] = "PODER";
					voltaPergunta6Vingador = false;

					break;
				case 'D':
				case 'A':
				case 'C':
					tentativasPergunta6++;
					System.out.println("Incorreto!!\nVocê perdeu a jóia do PODER para o THANOS");
					if (tentativasPergunta6 < 2) {
						System.out.println("Você voltou no tempo, tente responder novamente!");
					}

					vetorJoiaVingador[5] = "PERDEU A JÓIA DO PODER";

					break;

				default:
					System.out.println("Resposta invalida");
				}

			} while (tentativasPergunta6 < 2 && voltaPergunta6Vingador);

		}

		/*Estrutura condicional presente no fim da pergunta 6, referente a modaliadde VINGADOR
		 Aqui está todas as condições de acordo com a quantidade de JÓIAS(perguntas) que o usuário acertou.
		 */
		if (joiaVingador == 1) {
			System.out.println();
			System.out.println("infelizmente você perdeu!! O Thanos conseguiu dizimar metade da população");
			System.out.println("" + "PLACAR: 1/6");
			System.out.println("LISTAS DE JÓIAS:");
			System.out.println();
			for (int i = 0; i < vetorJoiaVingador.length; i++) {//Laço que informa todas as jóias que o usuario pegou ou perdeu.Percorre o vetor.
				System.out.println(vetorJoiaVingador[i]);
			}
		} else if (joiaVingador == 2) {
			System.out.println();
			System.out.println("infelizmente você perdeu!! O Thanos conseguiu dizimar metade da população");
			System.out.println("\n" + "PLACAR: 2/6");
			System.out.println("LISTAS DE JÓIAS:");
			System.out.println();
			for (int i = 0; i < vetorJoiaVingador.length; i++) {
				System.out.println(vetorJoiaVingador[i]);//Laço que informa todas as jóias que o usuario pegou ou perdeu, percorre o vetor.
			}
		} else if (joiaVingador == 3) {
			System.out.println();
			System.out.println("infelizmente você perdeu!! O Thanos conseguiu dizimar metade da população");
			System.out.println("\n" + "PLACAR: 3/6");
			System.out.println("LISTAS DE JÓIAS:");
			System.out.println();
			for (int i = 0; i < vetorJoiaVingador.length; i++) {
				System.out.println(vetorJoiaVingador[i]);
			}
		} else if (joiaVingador == 4) {
			System.out.println();
			System.out.println("Você conseguiu um placar positivo de 4 jóias, faltando somente 2");
			System.out.println("Conseguindo uma vitória parcial em cima de THANOS\n" + "PLACAR:4/6");
			System.out.println("LISTAS DE JÓIAS:");
			System.out.println();
			for (int i = 0; i < vetorJoiaVingador.length; i++) {
				System.out.println(vetorJoiaVingador[i]);
			}
		} else if (joiaVingador == 5) {
			//se o usuario acertar somente 5/6 perguntas, ele terá direito a responder uma pergunta extra.
			System.out.println();
			System.out.println("Você conseguiu um placar positivo de 5 jóias, faltando somente uma!!");

			System.out.println("Aperte '1' para responder a pergunta extra!!");//interação para entrar na pergunta extra.
			byte perguntaExtraVingador = leitor.nextByte();

			if (perguntaExtraVingador == 1) {
				System.out.println(
						"Para conseguir a ultima jóia, você precisa responder corretamente a seguinte pergunta");

				System.out.println("Quem conseguiu derrotar o THANOS no final de VINGADORES - ULTIMATO?");
				System.out.println();
				System.out.println("A)Thor                  B)Hulk\nC)Capitã Marvel         D)Homem de Ferro");
				char escolhePerguntaExtraVingador = leitorPerguntas.nextLine().toUpperCase().charAt(0);

				switch (escolhePerguntaExtraVingador) {
				case 'D':
					System.out.println();
					System.out.println("Correto!!");
					System.out.println(
							"Você recebeu a última jóia que faltava, PARABÉNS você conseguiu impedir o THANOS!!.\n"
									+ "PLACAR: 6/6");
					joiaVingador += 1;//conseguiu recuperar a ultima jóia ficando 6/6

					break;
				case 'B':
				case 'A':
				case 'C':
					//errou a pergunta extra, portanto continou com 5 jóias
					tentativasPergunta6++;
					System.out.println();
					System.out.println(
							"Incorreto!!Você continuou com 5 jóias, porém conseguiu uma vitória parcial no THANOS! Parabéns!!");
					System.out.println("LISTAS DE JÓIAS:");
					System.out.println();
					for (int i = 0; i < vetorJoiaVingador.length; i++) {//laço que mostra as jóias que o usuario conseguiu, percorre o vetor.
						System.out.println(vetorJoiaVingador[i]);
					}

					break;

				default:
					System.out.println("Resposta invalida");
				}

			}
			//condional para caso o usuario acerte todas as 6 perguntas de primeira.
		} else if (joiaVingador == 6) {
			System.out.println(
					"PARABÉNS você reuniu todas as 6 jóias do infinito e conseguiu impedir o THANOS de dizimar metade do universo.\nPLACAR: 6/6\nLISTAS DE JÓIAS: ");
			System.out.println();
			for (int i = 0; i < vetorJoiaVingador.length; i++) {//listas de jóias que percorre o vetor
				System.out.println(vetorJoiaVingador[i]);
			}
		}
		joiaVingador = 0;//variavel zerada para caso o jogador queira jogar novamente esta modalidade, assim os valores se alteram e voltam a 0.
		for (int i = 0; i < vetorJoiaVingador.length; i++) {
			vetorJoiaVingador[i] = "0";//laço para alterar os valores do vetor, caso o usuario queira jogar novamente
		}
	}

	public static void pergunta6Thanos(byte escolheModalidade) {
		int tentativasPergunta6Thanos = 0;
		switch (escolheModalidade) {
		case 2:
			boolean voltaPergunta6Thanos = true;

			do {
				System.out.println(
						"\n6 - Para pegar a jóia da MENTE, Thanos precisou derrotar o guardião desta jóia. Quem era detentor da jóia da MENTE ?");
				System.out.println("A)Visão               B)Wanda\nC)Dr Estranho         D)Thor ");
				char escolhaResposta6Thanos = leitorPerguntas.nextLine().toUpperCase().charAt(0);

				switch (escolhaResposta6Thanos) {
				case 'A':
					System.out.println("Correto!!");
					System.out.println("Você recebeu a jóia da MENTE");

					joiaThanos += 1;
					vetorJoiaThanos[5] = "MENTE";
					voltaPergunta6Thanos = false;

					break;
				case 'B':
				case 'C':
				case 'D':
					tentativasPergunta6Thanos++;
					System.out.println("Incorreto!!\nVocê perdeu a jóia da MENTE para os VINGADORES");
					if (tentativasPergunta6Thanos < 2) {
						System.out.println("Você voltou no tempo, tente recuperar a jóia!");
					}

					vetorJoiaThanos[5] = "PERDEU A JÓIA DA MENTE";

					break;

				default:
					System.err.println("Resposta inválida");
				}

			} while (tentativasPergunta6Thanos < 2 && voltaPergunta6Thanos);
			break;
		}

		/*Estrutura condicional presente no fim da pergunta 6, referente a modaliadde THANPS
		 Está todas as condições de acordo com a quantidade de JÓIAS(perguntas) que o usuário acertou.
		 */
		if (joiaThanos == 1) {
			System.out.println();
			System.out.println("Você perdeu!! Os Vingadores conseguiram te parar");
			System.out.println("PLACAR: 1/6");
			System.out.println("LISTAS DE JÓIAS:");
			System.out.println();
			for (int i = 0; i < vetorJoiaThanos.length; i++) {
				System.out.println(vetorJoiaThanos[i]);//percorre o vetor, mostrando as joias que perdeu e ganhou.
			}
		} else if (joiaThanos == 2) {
			System.out.println();
			System.out.println("Você perdeu!! Os Vingadores conseguiram te parar");
			System.out.println("PLACAR: 2/6");
			System.out.println("LISTAS DE JÓIAS:");
			System.out.println();
			for (int i = 0; i < vetorJoiaThanos.length; i++) {
				System.out.println(vetorJoiaThanos[i]);
			}
		} else if (joiaThanos == 3) {
			System.out.println();
			System.out.println(
					"Você conseguiu o suficiente para vencer parcialmente. Porém não concluiu o objetivo principal: Destruir metade do universo");
			System.out.println("PLACAR: 3/6");
			System.out.println("LISTAS DE JÓIAS:");
			System.out.println();
			for (int i = 0; i < vetorJoiaThanos.length; i++) {
				System.out.println(vetorJoiaThanos[i]);
			}
		} else if (joiaThanos == 4) {
			System.out.println();
			System.out.println("4 jóias são o suficiente para Thanos, parabéns!!");
			System.out.println("Você Venceu completamente os Vingadores");
			System.out.println("LISTAS DE JÓIAS:");
			System.out.println();
			for (int i = 0; i < vetorJoiaThanos.length; i++) {
				System.out.println(vetorJoiaThanos[i]);
			}
		} else if (joiaThanos == 5) {
			System.out.println();
			System.out.println("Você conseguiu um placar positivo de 5 jóias, faltando somente uma.");

			System.out.println("Aperte '1' para responder a pergunta extra!!");
			byte perguntaExtraThanos = leitor.nextByte();

			if (perguntaExtraThanos == 1) {
				System.out.println();
				System.out.println(
						"Para conseguir a ultima jóia, você precisa responder corretamente a seguinte pergunta:");
				System.out.println();
				System.out.println("O que o Thanos fez após o 'ESTALO' destruindo metade do universo?");
				System.out.println(
						"A)Foi conquistar outros planetas                         B)Se matou pois já tinha completado seu objetivo\nC)Foi viver uma vida tranquila em um lugar pacífico      D)Conquistou o restante do Universo");
				char escolhePerguntaExtraVingador = leitorPerguntas.nextLine().toUpperCase().charAt(0);

				switch (escolhePerguntaExtraVingador) {
				case 'C':
					System.out.println();
					System.out.println("Correto!!");
					System.out.println(
							"Você recebeu a última jóia que faltava, PARABÉNS você completou seu objetivo e destruiu metade do universo\nPLACAR: 6/6");

					joiaThanos += 1;

					break;
				case 'B':
				case 'A':
				case 'D':
					tentativasPergunta6Thanos++;
					System.out.println(
							"Incorreto!!Você continuou com 5 jóias, porém foi o suficiente para dizimar tudo(exceto metade do universo). Parabéns!!");
					System.out.println("LISTAS DE JÓIAS:");
					System.out.println();
					for (int i = 0; i < vetorJoiaVingador.length; i++) {
						System.out.println(vetorJoiaVingador[i]);
					}
					break;

				default:
					System.out.println("Resposta invalida");
				}

			}

		} else if (joiaThanos == 6) {
			System.out.println(
					"PARABÉNS você conseguiu realizar o 'ESTALO' e dizimou metade da população de todo universo.\nPLACAR: 6/6\nLISTAS DE JÓIAS: ");
			System.out.println();
			for (int i = 0; i < vetorJoiaThanos.length; i++) {
				System.out.println(vetorJoiaThanos[i]);
			}
		}
		for (int i = 0; i < vetorJoiaThanos.length; i++) {
			vetorJoiaThanos[i] = "0";//laço para alterar os valores do vetor, caso o usuario queira jogar novamente
		}
		joiaThanos = 0;//variavel joiaThanos recebe zero para caso o jogador queira jogar novamente na mesma modalidade
	}

	/*função que basicamente faz a interação com o usario para mudar de modalidade se acordo com a modalidade escolhida,
	depois do termino do quiz o usuario poderá escolher jogar na modalidade OPOSTA*/
	
	public static void mudaModalidade(byte escolheModalidade) {
		
		//condional que só entra caso o jogador tenha escolhido jogar como "VINGADORES" na modalidade 1.
		
		if (escolheModalidade == 1 && continua == true) {
			System.out.println();
			System.out.println("Deseja refazer um novo QUIZ como THANOS?");
			System.out.println("<1> - SIM\n<2> - NÃO");
			trocaModalidade = leitor.nextByte();
			if (trocaModalidade == 1) {//se o usuario colocar 1, ele quer mudar de modalidade.
				escolheModalidade = 2;//recebe 2 pois 2 refere-se a modalidade THANOS. O usuario modou da modalidade 1 para 2.

			}
			switch (trocaModalidade) {
			case 1:
				escolheModalidade = 2;
				System.out.println();
				System.out.println("Agora você está jogando como THANOS");
				System.out.println(
						"Seu objetivo é dizimar metade da população de todo o universo, para isso, é preciso reunir as jóias do infinito");

				//perguntas somente da modalidade THANOS sendo chamada.
				pergunta1Thanos(escolheModalidade);
				pergunta2Thanos(escolheModalidade);
				pergunta3Thanos(escolheModalidade);
				pergunta4Thanos(escolheModalidade);
				pergunta5Thanos(escolheModalidade);
				pergunta6Thanos(escolheModalidade);

				trocaModalidade = 2;
				
				//não possui break, pois eu quero que apareça o CASE 2 para voltar ao menu depois das perguntas

			case 2:
				//caso o usuario digite 2, ou termine as perguntas do CASE 1.
				System.out.println();
				System.out.println("Aperte '1' para voltar ao menu!");//interação para voltar ao menu
				voltaMenu = leitor.nextByte();

				while (voltaMenu != 1) {
					System.out.println();
					System.err.println("Aperte '1' para voltar ao menu!");//while caso o usuario digite algo diferente de 1.
					voltaMenu = leitor.nextByte();
				}
				if (voltaMenu == 1) {

					//toda a estrutura de menu sendo chamada novamente.
					do {
						escolheMenu = montaMenu();
						switch (escolheMenu) {
						case 1:
							jogar();
							break;
						case 2:
							instrucoes();
							break;
						case 3:
							creditos();
							break;
						case 4:
							sair();

							break;

						}

					} while (escolheMenu >= 5 || escolheMenu <= 0);

				}
				break;

			}
		}

		//condional que só entra caso o jogador tenha escolhido jogar como "THANOS" na modalidade 2.
		if (escolheModalidade == 2 && continua == true) {
			System.out.println("Deseja fazer um novo QUIZ como Vingador?");
			System.out.println("<1> - SIM\n<2> - NÃO");
			trocaModalidade = leitor.nextByte();

			if (trocaModalidade == 1) {//se o usuario colocar 1, ele quer mudar de modalidade.
				escolheModalidade = 1;//recebe 1 pois '1' refere-se a modalidade VINGADOR. Significa que trocou da modalidade 2 para 1.

			}
			switch (trocaModalidade) {
			case 1:
				//perguntas somente da modalidade VINGADOR sendo chamada.
				pergunta1Vingador(escolheModalidade);
				pergunta2Vingador(escolheModalidade);
				pergunta3Vingador(escolheModalidade);
				pergunta4Vingador(escolheModalidade);
				pergunta5Vingador(escolheModalidade);
				pergunta6Vingador(escolheModalidade);

			case 2:
				//caso o usuario digite 2, ou termine as perguntas do CASE 1.
				System.out.println("Aperte '1' para voltar ao menu!");
				voltaMenu = leitor.nextByte();

				while (voltaMenu != 1) {
					System.err.println("Aperte '1' para voltar ao menu!");
					voltaMenu = leitor.nextByte();
				}
				//toda a estrutura de menu sendo chamada novamente.
				if (voltaMenu == 1) {

					do {
						escolheMenu = montaMenu();
						switch (escolheMenu) {
						case 1:
							jogar();
							break;
						case 2:
							instrucoes();

							break;
						case 3:
							creditos();
							break;
						case 4:
							sair();

							break;

						}
					} while (escolheMenu >= 5 || escolheMenu <= 0);

				} else if (voltaMenu == 2) {
					break;
				}
				break;
			}

		}

	}

}