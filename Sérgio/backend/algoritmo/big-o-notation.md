# Notação Big O

## 🔍 O que é a Notação Big O?

A **notação Big O** é uma ferramenta usada para descrever a **eficiência** de um algoritmo, especialmente em termos de **tempo de execução** e **uso de memória**, conforme o tamanho da entrada cresce. Ela nos ajuda a entender como o desempenho de um algoritmo escala com entradas maiores.

---

## ⚙️ Por que é importante?

- **Comparação de algoritmos**: Permite comparar diferentes algoritmos para resolver o mesmo problema.
- **Previsibilidade**: Ajuda a prever o comportamento do algoritmo com grandes volumes de dados.
- **Eficiência**: Auxilia na escolha de algoritmos mais eficientes para aplicações específicas.

---

## 📊 Tipos comuns de complexidade

| Notação    | Nome               | Descrição                                                                 |
|------------|--------------------|---------------------------------------------------------------------------|
| O(1)       | Constante          | O tempo de execução não muda com o tamanho da entrada.                    |
| O(log n)   | Logarítmica        | O tempo cresce lentamente à medida que a entrada aumenta.                 |
| O(n)       | Linear             | O tempo cresce proporcionalmente ao tamanho da entrada.                   |
| O(n log n) | Linearítmica       | Combinação de crescimento linear e logarítmico.                           |
| O(n²)      | Quadrática         | O tempo cresce proporcionalmente ao quadrado do tamanho da entrada.       |
| O(2ⁿ)      | Exponencial        | O tempo dobra a cada incremento na entrada; cresce muito rapidamente.     |

---

## 🧪 Exemplos do livro

- **Busca Linear**: Percorre cada elemento até encontrar o alvo.
  - Complexidade: `O(n)`
- **Busca Binária**: Divide repetidamente a lista ordenada ao meio para encontrar o alvo.
  - Complexidade: `O(log n)`

---

## 📈 Visualizando o crescimento

- **O(n)**: Se a entrada dobra, o tempo de execução também dobra.
- **O(log n)**: Se a entrada dobra, o tempo de execução aumenta um pouco.
- **O(n²)**: Se a entrada dobra, o tempo de execução quadruplica.

---

## 📝 Observações importantes

- A notação Big O descreve o **pior caso** de um algoritmo.
- Ela abstrai detalhes específicos de hardware ou linguagem de programação.
- É uma ferramenta essencial para entender a **eficiência** e **escalabilidade** de algoritmos.

---

