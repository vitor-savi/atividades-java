# Regras para assistentes de IA neste repositório

Repositório das tarefas de Java da disciplina de LPOO (Linguagem de Programação
Orientada a Objetos). Cada pasta `Tarefa-XX/` tem um PDF com os enunciados.

Equipe:
- Vitor Savi do Nascimento
- Felipe Fernandes de Azevedo
- Lucas Matheus Dutra da Silva
- Lucas Dourado Martins

## O que fazer

- Resolver **somente** as questões que têm **"(Tarefa X)" em negrito** na frente,
  no PDF da pasta. As outras questões não devem ser feitas.
- Linguagem: Java. Usar apenas o que já foi visto na disciplina (Scanner,
  if/switch, laços, arrays, classes, construtores, getters/setters, métodos
  estáticos). Nada de streams, lambdas, `var`, records, coleções (`ArrayList`
  etc.) ou bibliotecas externas, a menos que o enunciado peça.
- Se o enunciado citar uma classe vista em aula que não está no repositório
  (ex.: Ponto3D, Bicicleta), criar uma versão simples e avisar o aluno.

## Estrutura

```
Tarefa-XX/
  src/
    questaoNN/        <- um pacote por questão (ex.: questao04, questao13)
      Classe.java
  doc/                <- só se o enunciado pedir JavaDoc
  TarefaXX_Nomes.zip  <- arquivo de entrega
```

Respostas teóricas (perguntas do tipo "por que deu erro?") vão em um
`Respostas.txt` dentro da pasta da questão.

## Estilo do código (importante)

O código deve parecer feito por um aluno da disciplina, de forma simples e direta:

- **Comentários**: poucos. Uma linha no topo da classe (ex.: `// Questão 4 - Velocidade média`)
  e, no máximo, um comentário curto em algum trecho que não seja óbvio.
  Não comentar o que o código já diz.
- **JavaDoc** (`/** ... */`, `@param`, `@return`): **só** quando o enunciado pedir.
  Nesse caso, gerar a documentação com `javadoc` na pasta `doc/`.
- Sem "programação defensiva" além do que o enunciado pede: não validar toda
  entrada, não criar construtor `private` em classe utilitária, não devolver
  cópias de arrays, não usar `Math.max`/truques para casos de borda.
- Preferir a solução mais simples: código dentro do `main`/`switch` quando
  for curto, em vez de criar vários métodos auxiliares.
- Nomes de variáveis, métodos e mensagens em português.
- Mensagens de saída simples. Quando o enunciado der o texto exato de uma
  mensagem, usar exatamente aquele texto.
- `Respostas.txt` em texto corrido e curto, sem tabelas nem formatação markdown.
- Valores monetários e decimais com `printf("%.2f")` quando o enunciado pedir casas decimais.

## Testes

Antes de commitar, compilar e rodar todos os programas da tarefa:

```
javac -encoding UTF-8 -d <pasta-temporária> src/*/*.java
java -cp <pasta-temporária> questaoNN.Classe
```

Usar os dados de teste do enunciado, quando houver. Não commitar arquivos `.class`.
Observação: os programas usam o locale do sistema, então números decimais são
digitados com vírgula (ex.: `100,5`).

## Entrega

Gerar um `.zip` dentro da pasta da tarefa, com a pasta `src/` (e `doc/`, se existir),
sem arquivos `.class`. Nome do arquivo:

```
TarefaXX_VitorSaviDoNascimento_FelipeFernandesDeAzevedo_LucasMatheusDutraDaSilva_LucasDouradoMartins.zip
```

## Commits

- Pode commitar direto na `main`.
- Um commit por tarefa, com a mensagem começando por `[Tarefa X]`
  (ex.: `[Tarefa 3] Resolve as questões 2, 5 e 7 da lista de Sintaxe II`).
- **Não** adicionar linhas de co-autoria ou atribuição de IA nas mensagens de
  commit (ex.: `Co-Authored-By: ...`, "Generated with ...").

## Para os alunos

Leiam e entendam o código antes de entregar. O professor pode perguntar
por que algo foi feito de certo jeito, e vocês precisam saber explicar.
