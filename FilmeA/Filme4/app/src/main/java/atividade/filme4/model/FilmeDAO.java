package Atividade.filme4.controller;
public class FilmeDAO {
    public static Genero[] generos;

    private FilmeDAO(){};

    public static Genero[] getGenero(){
        if(generos == null){

            generos = new Genero[8];
            generos[0] = new Genero(1,"Vingadores: Guerra Infinita","Homem de Ferro, Thor, Hulk e os Vingadores se unem para combater seu inimigo mais poderoso, o maligno Thanos. ");
            generos[1] = new Genero(2,"Jurassic World: Reino Ameaçado","Owen e Claire retornam à ilha Nublar para salvar os dinossauros restantes de um vulcão que está prestes a entrar em erupção.");
            generos[2] = new Genero(3,"O Predador","The Predator é um filme de ficção científica estadunidense de 2018, dirigido por Shane Black e escrito por Black e Fred Dekker. ");
            generos[3] = new Genero(4,"Venom","Venom é um futuro filme de ação, ficção científica, suspense e terror estadunidense de 2018.");
            generos[4] = new Genero(5,"Hotel Transilvânia 3: Férias Monstruosas","Solitário, infeliz e buscando um novo amor na internet, Dracula é surpreendido com um presente da querida filha: férias em um cruzeiro. ");
            generos[5] = new Genero(6,"Deadpool 2","O supersoldado Cable vem do futuro com a missão de assassinar o jovem mutante Russel e o mercenário Deadpool precisa aprender o que é ser herói de verdade para salvá-lo.");
            generos[6] = new Genero(7,"Os Incríveis 2","A Mulher Elástica entra em ação para salvar o dia, enquanto o Sr. Incrível enfrenta seu maior desafio até agora: cuidar dos problemas de seus três filhos.");
            generos[7] = new Genero(8,"Pantera Negra","Conheça a história de T'Challa, príncipe do reino de Wakanda, que perde o seu pai e viaja para os Estados Unidos, onde tem contato com os Vingadores.");

        }


        return generos;

    }

}
